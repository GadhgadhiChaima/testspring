package com.clinique.gestionclinique.repository;

import com.clinique.gestionclinique.Entity.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
}
