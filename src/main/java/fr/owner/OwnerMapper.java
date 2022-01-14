package fr.owner;

import fr.bonsai.BonsaiMapper;
import fr.bonsai.domain.model.Bonsai;
import fr.bonsai.exposition.BonsaiDTO;
import fr.commons.BonsaiEntity;
import fr.commons.OwnerEntity;
import fr.owner.domain.Owner;
import fr.owner.exposition.OwnerDto;


import java.util.stream.Collectors;

public class OwnerMapper {



//    public static Owner DtoToOwner(OwnerDto ownerDto) {
//        Owner owner = new Owner();
//        owner.setId(ownerDto.getId());
//        owner.setName(ownerDto.getName());
//        owner.setBonsais(ownerDto.getBonsais().stream().map(BonsaiMapper::BonsaiToDTO).collect(Collectors.toList()));
//        return owner;
//    }
//
//    public static Owner EntityToOwner(OwnerEntity ownerEntity){
//        Owner ownerConverted = new Owner();
//        ownerConverted.setId(ownerEntity.getId());
//        ownerConverted.setName(ownerEntity.getName());
//        return ownerConverted;
//
//    }
//
//
//    public static OwnerEntity OwnerToEntity(Owner owner) {
//        OwnerEntity ownerEntity = new OwnerEntity();
//        ownerEntity.setId(owner.getId());
//        ownerEntity.setName(owner.getName());
//        ownerEntity.setBonsai(owner.getBonsais().stream().map(BonsaiMapper::EntityToBonsai).collect(Collectors.toList()));
//        return ownerEntity;
//    }
//
//
//
//
//    public static OwnerDto OwnerToDto(Owner owner) {
//        OwnerDto ownerDto = new OwnerDto();
//        ownerDto.setId(owner.getId());
//        ownerDto.setName(owner.getName());
//        ownerDto.setBonsais(owner.getBonsais().stream().map(BonsaiMapper::BonsaiToDTO).collect(Collectors.toList()));
//        return ownerDto;
//    }


    public static Owner ownerDtoToOwner(OwnerDto ownerDto) {
        Owner owner = new Owner();
        owner.setId(ownerDto.getId());
        owner.setName(ownerDto.getName());
        owner.setBonsais(ownerDto.getBonsais().stream().map(BonsaiMapper::DtoToBonsai).collect(Collectors.toList()));
        return owner;
    }

    public static Owner ownerEntityToOwner(OwnerEntity ownerEntity) {
        Owner owner = new Owner();
        owner.setId(ownerEntity.getId());
        owner.setName(ownerEntity.getName());
        owner.setBonsais(ownerEntity.getBonsais().stream().map(BonsaiMapper::EntityToBonsai).collect(Collectors.toList()));
        return owner;
    }

    public static OwnerDto ownerToOwnerDto(Owner owner) {
        OwnerDto ownerDto = new OwnerDto();
        ownerDto.setId(owner.getId());
        ownerDto.setName(owner.getName());
        ownerDto.setBonsais(owner.getBonsais().stream().map(BonsaiMapper::BonsaiToDTO).collect(Collectors.toList()));
        return ownerDto;
    }

    public static OwnerEntity ownerToOwnerEntity(Owner owner) {
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setId(owner.getId());
        ownerEntity.setName(owner.getName());
        ownerEntity.setBonsais(owner.getBonsais().stream().map(BonsaiMapper::BonsaiToEntity).collect(Collectors.toList()));
        return ownerEntity;
    }


    public static Bonsai toBonsai(BonsaiEntity bonsaiEntity) {
        Bonsai bonsai = new Bonsai();
        bonsai.setId(bonsaiEntity.getId());
        bonsai.setName(bonsaiEntity.getName());
        bonsai.setSpecies(bonsaiEntity.getSpecies());
        bonsai.setAcquisition_age(bonsaiEntity.getAcquisition_age());
        return bonsai;
    }

    public static Bonsai BonsaiDtoToBonsai(BonsaiDTO bonsaiDto) {
        Bonsai bonsai = new Bonsai();
        bonsai.setId(bonsaiDto.getId());
        bonsai.setName(bonsaiDto.getName());
        bonsai.setSpecies(bonsaiDto.getSpecies());
        bonsai.setAcquisition_age(bonsaiDto.getAcquisition_age());
        return bonsai;
    }

    public static BonsaiDTO toBonsaiDto(Bonsai bonsai) {
        BonsaiDTO bonsaiDto = new BonsaiDTO();
        bonsaiDto.setId(bonsai.getId());
        bonsaiDto.setName(bonsai.getName());
        bonsaiDto.setSpecies(bonsai.getSpecies());
        bonsaiDto.setAcquisition_age(bonsai.getAcquisition_age());
        return bonsaiDto;
    }

    public static BonsaiEntity toBonsaiEntity(Bonsai bonsai) {
        BonsaiEntity bonsaiEntity = new BonsaiEntity();
        bonsaiEntity.setId(bonsai.getId());
        bonsaiEntity.setName(bonsai.getName());
        bonsaiEntity.setSpecies(bonsai.getSpecies());
        bonsaiEntity.setAcquisition_age(bonsai.getAcquisition_age());
        return bonsaiEntity;
    }
}