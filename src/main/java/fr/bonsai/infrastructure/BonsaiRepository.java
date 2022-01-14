package fr.bonsai.infrastructure;

import fr.bonsai.BonsaiMapper;
import fr.bonsai.domain.model.Bonsai;
import fr.commons.BonsaiDao;
import fr.commons.BonsaiEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Component
public class BonsaiRepository {

    private final BonsaiDao bonsaiDao;

    public BonsaiRepository(BonsaiDao bonsaiDao){
        this.bonsaiDao = bonsaiDao;
    }


    public List<BonsaiEntity> helloWorld() {
        return bonsaiDao.findAll();
    }


    public Bonsai findById(@PathVariable("uuid") UUID uuid ){
        Optional <BonsaiEntity> res = bonsaiDao.findById(uuid);
        if(res.isPresent()){
            Bonsai resultat = BonsaiMapper.EntityToBonsai((res.get()));
            return resultat;

        }else{
            return null;
        }


    }

    public List<Bonsai> findAll(){
        List<BonsaiEntity> res = bonsaiDao.findAll();
        List<Bonsai> collect = res.stream()
                .map(BonsaiEntity -> BonsaiMapper.EntityToBonsai(BonsaiEntity))
                .collect(Collectors.toList());

        return collect;
    }



    public Bonsai create (@RequestBody BonsaiEntity bonsai) {
        BonsaiEntity res = bonsaiDao.save(bonsai);
        Bonsai resultat = BonsaiMapper.EntityToBonsai(res);
        return resultat;

    }


    public void delete(UUID id) {
        bonsaiDao.deleteById(id);
    }


    public Bonsai update(Bonsai bonsai) {
        return BonsaiMapper.EntityToBonsai(bonsaiDao.save(BonsaiMapper.BonsaiToEntity(bonsai)));
    }

    public Bonsai updateStatus(Bonsai bonsai) {
        return BonsaiMapper.EntityToBonsai(bonsaiDao.save(BonsaiMapper.BonsaiToEntity(bonsai)));
    }

}
