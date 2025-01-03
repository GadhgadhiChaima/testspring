package com.clinique.gestionclinique.service;

import com.clinique.gestionclinique.Entity.*;
import com.clinique.gestionclinique.repository.CliniqueReposoitry;
import com.clinique.gestionclinique.repository.MedecinRepository;
import com.clinique.gestionclinique.repository.PatientRepository;
import com.clinique.gestionclinique.repository.RendezVousRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ServiceProjetImpl implements ServiceProjet {
    @Autowired
    private CliniqueReposoitry cliniqueReposoitry;

    @Autowired
    private MedecinRepository medecinRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private RendezVousRepository rendezVousRepository;

    @Override
    public Clinique addClinique(Clinique clinique) {
        return cliniqueReposoitry.save(clinique);
    }

    @Override
    public Medecin addMedecinAndAsseignToClinique(Medecin medecin, Long cliniqueId) {
        Clinique c = cliniqueReposoitry.findById(cliniqueId).orElse(null);
        if (c == null) {
            throw new IllegalArgumentException("Clinique not found with ID: " + cliniqueId);
        }

        if (c.getMedecins() == null) {
            c.setMedecins(new ArrayList<>());
        }

        c.getMedecins().add(medecin);
        medecinRepository.save(medecin);
        cliniqueReposoitry.save(c);

        return medecin;
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public RendezVous addRDVAndAssignMedAndPatient(RendezVous rendezVous, Long idMedecin, Long idPatient) {
        Medecin m = medecinRepository.findById(idMedecin).orElse(null);
        Patient p = patientRepository.findById(idPatient).orElse(null);
        if (m == null || p == null) {
            throw new IllegalArgumentException("Medecin or Patient not found");
        }
        rendezVous.setMedecin(m);
        rendezVous.setPatients(p);
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public List<RendezVous> getRendezvVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
        Clinique c = cliniqueReposoitry.findById(idClinique).orElse(null);
        if (c == null) {
            throw new IllegalArgumentException("Clinique not found with ID: " + idClinique);
        }

        List<RendezVous> result = new ArrayList<>();
        for (Medecin medecin : c.getMedecins()) {
            if (medecin.getSpecialite() == specialite) {
                result.addAll(medecin.getRendezvouslist());
            }
        }
        return result;
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {
        return 0;
    }

    @Override
    public int getRevenueMedecin(Long idMedecin, Date startDate, Date endDate) {
        return 0;
    }
}
