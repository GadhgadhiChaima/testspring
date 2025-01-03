package com.clinique.gestionclinique.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRDV;

    private Date dateRDV;
    private String remarque;

    @ManyToOne
    private Medecin medecin;

    @ManyToOne
    private Patient patients;

    // Setters for Medecin and Patients
    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public void setPatients(Patient patients) {
        this.patients = patients;
    }
}
