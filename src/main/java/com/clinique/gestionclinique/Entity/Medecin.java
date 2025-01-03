package com.clinique.gestionclinique.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedecin;

    private String nomMedecin;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;

    private int telephone;
    private int prixconsultation;

    @ManyToMany(mappedBy = "medecins")
    private List<Clinique> clinic;

    @OneToMany(mappedBy = "medecin")
    private List<RendezVous> rendezvouslist;

    // Getters for specialite and rendezvouslist
    public Specialite getSpecialite() {
        return specialite;
    }

    public List<RendezVous> getRendezvouslist() {
        return rendezvouslist;
    }
}
