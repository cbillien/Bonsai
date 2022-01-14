package fr.owner.domain;

import fr.bonsai.domain.model.Bonsai;

import fr.owner.infrastructure.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OwnerService {
    private OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> findAll(int has_more) {
        return ownerRepository.findAll();
    }

    public Optional<Owner> findById(UUID id) {
        return ownerRepository.findById(id);
    }

    public Owner create(Owner owner) {
        return ownerRepository.create(owner);
    }

    public List<Bonsai> getBonsais(UUID id) {
        return ownerRepository.getBonsais(id);
    }

    public Optional<Bonsai> transferBonsai(UUID owner_id, UUID bonsai_id, Owner new_owner) {
        Optional<Owner> owner = ownerRepository.findById(owner_id);
        Optional<Bonsai> bonsai = ownerRepository.findBonsaiById(bonsai_id);
        if (owner.isPresent() && bonsai.isPresent()) {
            for (Bonsai b : owner.get().getBonsais()) {
                if (b.getId().equals(bonsai_id)) {
                    return Optional.of(ownerRepository.transferBonsai(new_owner, bonsai.get()));
                }
            }
        }
        return Optional.empty();
    }

    public List<Bonsai> addBonsai(UUID owner_id, List<Bonsai> bonsais) {
        List<Bonsai> list = new ArrayList<>();
        Optional<Owner> owner = ownerRepository.findById(owner_id);
        if (owner.isPresent()) {
            for (Bonsai bonsai : bonsais) {
                boolean hasOwnerAlready = false;
                for (Owner o : findAll(-1)) {
                    for (Bonsai b : o.getBonsais()) {
                        if (b.getId().equals(bonsai.getId())) {
                            hasOwnerAlready = true;
                        }
                    }
                }
                if (!hasOwnerAlready) {
                    list.add(ownerRepository.addBonsai(owner.get(), bonsai));
                }
            }
        }
        return list;
    }
}