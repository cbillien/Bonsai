package fr.bonsai;

import fr.bonsai.domain.model.Bonsai;
import fr.bonsai.exposition.BonsaiDTO;
import fr.bonsai.infrastructure.BonsaiEntity;

public class BonsaiMapper {

    public static Bonsai DtoToBonsai(BonsaiDTO bonsaiDTO){
        Bonsai bonsaiConverted = new Bonsai();
        bonsaiConverted.setId(bonsaiDTO.getId());
        bonsaiConverted.setName(bonsaiDTO.getName());
        return bonsaiConverted;

    }


    public static Bonsai EntityToBonsai(BonsaiEntity bonsaiEntity){
        Bonsai bonsaiConverted = new Bonsai();
        bonsaiConverted.setId(bonsaiEntity.getId());
        bonsaiConverted.setName(bonsaiEntity.getName());
        return bonsaiConverted;

    }


    public static BonsaiDTO BonsaiToDTO(Bonsai bonsai){
        BonsaiDTO bonsaiConverted = new BonsaiDTO();
        bonsaiConverted.setId(bonsai.getId());
        bonsaiConverted.setName(bonsai.getName());
        return bonsaiConverted;

    }
}
