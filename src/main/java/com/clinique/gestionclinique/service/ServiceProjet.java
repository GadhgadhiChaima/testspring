package com.clinique.gestionclinique.service;

import com.clinique.gestionclinique.Entity.*;

import java.util.Date;
import java.util.List;

public interface ServiceProjet {
    Clinique addClinique(Clinique clinique);

    Medecin addMedecinAndAsseignToClinique(Medecin medecin ,Long cliniqueId);

    Patient addPatient(Patient patient);

    RendezVous addRDVAndAssignMedAndPatient(RendezVous rendezVous,Long idMedecin,Long idPatient);

    List<RendezVous> getRendezvVousByCliniqueAndSpecialite(Long idClinique, Specialite sepcialite);

    int getNbrRendezVousMedecin(Long idMedecin);
    int getRevenueMedecin(Long idMedecin, Date startDate, Date endDate);






}
