package fr.bonsai.infrastructure;

import fr.bonsai.BonsaiMapper;
import fr.bonsai.domain.model.Bonsai;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Component
public class BonsaiRepository {

    private final BonsaiDao bonsaiDao;

    public BonsaiRepository(BonsaiDao bonsaiDao){
        this.bonsaiDao = bonsaiDao;
    }

    @GetMapping
    public List<BonsaiEntity> helloWorld() {
        return bonsaiDao.findAll();
    }

    @GetMapping("/{uuid}")
    public Bonsai findById(@PathVariable("uuid") UUID uuid ){
        Optional <BonsaiEntity> res = bonsaiDao.findById(uuid);
        if(res.isPresent()){
            Bonsai resultat = BonsaiMapper.EntityToBonsai((res.get()));
            return resultat;

        }else{
            return null;
        }


    }


    @PostMapping
    public Bonsai create (@RequestBody BonsaiEntity bonsai) {
        BonsaiEntity res = bonsaiDao.save(bonsai);
        Bonsai resultat = BonsaiMapper.EntityToBonsai(res);
        return resultat;

    }

}
