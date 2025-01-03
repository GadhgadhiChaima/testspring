package com.clinique.gestionclinique.repository;

import com.clinique.gestionclinique.Entity.Clinique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CliniqueReposoitry extends JpaRepository<Clinique,Long> {
}
