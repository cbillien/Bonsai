package fr.bonsai;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BonsaiDao extends JpaRepository<BonsaiEntity, UUID> {
}
