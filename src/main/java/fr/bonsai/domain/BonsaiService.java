package fr.bonsai.domain;


import fr.bonsai.domain.model.Bonsai;
import fr.commons.BonsaiEntity;
import fr.bonsai.infrastructure.BonsaiRepository;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BonsaiService {


    private final BonsaiRepository bonsaiRepository;

    public BonsaiService(BonsaiRepository bonsaiRepository) {
        this.bonsaiRepository = bonsaiRepository;
    }



    public Bonsai findById(UUID uuid){
        return bonsaiRepository.findById(uuid);
}


    public Bonsai create (BonsaiEntity bonsai){
        return bonsaiRepository.create(bonsai);
    }

    public List<Bonsai> findAll(){
        return bonsaiRepository.findAll();
    }



    public void delete(UUID id) {
        bonsaiRepository.delete(id);
    }


    public Optional<Bonsai> update(UUID id, Bonsai updatedBonsai) {
        Optional<Bonsai> bonsai = Optional.ofNullable(bonsaiRepository.findById(id));
        if (bonsai.isPresent()) {
            bonsai.get().setName(updatedBonsai.getName());
            bonsai.get().setSpecies(updatedBonsai.getSpecies());
            bonsai.get().setAcquisition_date(updatedBonsai.getAcquisition_date());
            bonsai.get().setAcquisition_age(updatedBonsai.getAcquisition_age());
            return Optional.of(bonsaiRepository.update(bonsai.get()));
        }
        return bonsai;
    }

    public Optional<Bonsai> updateStatus(UUID id, String status) {
        Optional<Bonsai> bonsai = Optional.ofNullable(bonsaiRepository.findById(id));
        if (bonsai.isPresent()) {
           if( bonsai.get().getStatus() != null){
               bonsai.get().setStatus(status);
           }


            return Optional.of(bonsaiRepository.updateStatus(bonsai.get()));
        }
        return bonsai;
    }
}
