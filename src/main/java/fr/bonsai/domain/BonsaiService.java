package fr.bonsai.domain;


import fr.bonsai.domain.model.Bonsai;
import fr.bonsai.infrastructure.BonsaiEntity;
import fr.bonsai.infrastructure.BonsaiRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.UUID;

@Service
public class BonsaiService {


    private final BonsaiRepository bonsaiRepository;

    public BonsaiService(BonsaiRepository bonsaiRepository) {
        this.bonsaiRepository = bonsaiRepository;
    }


    @GetMapping("/{uuid}")
    public Bonsai findById(@PathVariable("uuid") UUID uuid){
        return bonsaiRepository.findById(uuid);
}

    @PostMapping
    public Bonsai create (@RequestBody BonsaiEntity bonsai){
        return bonsaiRepository.create(bonsai);
    }
}
