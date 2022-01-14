package fr.owner.infrastructure;


import fr.bonsai.domain.model.Bonsai;
import fr.commons.BonsaiDao;
import fr.commons.OwnerDao;
import fr.commons.OwnerEntity;
import fr.owner.OwnerMapper;
import fr.owner.domain.Owner;
import org.springframework.stereotype.Component;



import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OwnerRepository {
    private OwnerDao ownerDao;
    private BonsaiDao bonsaiDao;

    public OwnerRepository(OwnerDao ownerDao, BonsaiDao bonsaiDao) {
        this.ownerDao = ownerDao;
        this.bonsaiDao = bonsaiDao;
    }

//    public List<Owner> findAll(int has_more) {
//        return ownerDao.findAllFiltered(has_more).stream().map(OwnerMapper::toOwner).collect(Collectors.toList());
//    }
    public List<Owner> findAll(){
        List<OwnerEntity> res = ownerDao.findAll();
        List<Owner> collect = res.stream()
                .map(OwnerEntity -> OwnerMapper.ownerEntityToOwner(OwnerEntity))
                .collect(Collectors.toList());

        return collect;
    }

    public Optional<Owner> findById(UUID id) {
        return ownerDao.findById(id).map(OwnerMapper::ownerEntityToOwner);
    }

    public Owner create(Owner owner) {
        return OwnerMapper.ownerEntityToOwner(ownerDao.save(OwnerMapper.ownerToOwnerEntity(owner)));
    }

    public List<Bonsai> getBonsais(UUID id) {
        return bonsaiDao.findAll().stream()
                .filter(b -> b.getOwner() != null && b.getOwner().getId().equals(id))
                .map(OwnerMapper::toBonsai)
                .collect(Collectors.toList());
    }

    public Bonsai transferBonsai(Owner newOwner, Bonsai bonsai) {
        ownerDao.updateOwnerId(newOwner.getId(), bonsai.getId());
        return bonsai;
    }

    public Bonsai addBonsai(Owner owner, Bonsai bonsai) {
        ownerDao.updateOwnerId(owner.getId(), bonsai.getId());
        return bonsai;
    }

    public Optional<Bonsai> findBonsaiById(UUID id) {
        return bonsaiDao.findById(id).map(OwnerMapper::toBonsai);
    }
}