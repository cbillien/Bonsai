package fr.bonsai.exposition;

import fr.bonsai.BonsaiMapper;
import fr.bonsai.domain.BonsaiService;
import fr.bonsai.domain.model.Bonsai;
import fr.bonsai.infrastructure.BonsaiEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/bonsais")
public class BonsaiController {

    private final BonsaiService bonsaiService;

    public BonsaiController(BonsaiService bonsaiService) {
        this.bonsaiService = bonsaiService;

    }


    @GetMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> findById(@PathVariable("uuid") UUID uuid) {
        try {
            BonsaiDTO bonsaiDTO = BonsaiMapper.BonsaiToDTO(bonsaiService.findById(uuid));
            return ResponseEntity.ok(bonsaiDTO);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }


    @PostMapping
    public ResponseEntity<BonsaiDTO> create(@RequestBody BonsaiEntity bonsai) {
        Bonsai bonsaiTemp = bonsaiService.create(bonsai);

        BonsaiDTO resultat = BonsaiMapper.BonsaiToDTO(bonsaiTemp);

        return ResponseEntity.created(null).body(resultat);
    }

    // patching



}
