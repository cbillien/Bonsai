package fr.commons;

import fr.commons.BonsaiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface BonsaiDao extends JpaRepository<BonsaiEntity, UUID> {
}
