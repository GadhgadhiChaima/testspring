package com.clinique.gestionclinique.controller;

import com.clinique.gestionclinique.Entity.*;
import com.clinique.gestionclinique.service.ServiceProjet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ProjetController {
    @Autowired
    private ServiceProjet serviceProjet;

    @PostMapping("/addClinique")
    public Clinique addClinique(@RequestBody Clinique clinique) {
        return serviceProjet.addClinique(clinique);
    }

    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient) {
        return serviceProjet.addPatient(patient);
    }

    @PostMapping("/addMedecinAndAssignToClinique/{idClinique}")
    public Medecin addMedecinAndAssignToClinique(@RequestBody Medecin medecin, @PathVariable Long idClinique) {
        return serviceProjet.addMedecinAndAsseignToClinique(medecin, idClinique);
    }

    @PostMapping("/addRDVAndAssignMedAndPatient/{idP}/{idM}")
    public RendezVous addRDVAndAssignMedAndPatient(@RequestBody RendezVous rendezVous, @PathVariable Long idP, @PathVariable Long idM) {
        return serviceProjet.addRDVAndAssignMedAndPatient(rendezVous, idM, idP);
    }

    @GetMapping("/getRendezVousByCliniqueAndSpecialite/{idC}/{sp}")
    public List<RendezVous> getRDV(@PathVariable Long idC, @PathVariable Specialite sp) {
        return serviceProjet.getRendezvVousByCliniqueAndSpecialite(idC, sp);
    }

    @GetMapping("/getNbrRendezVousMedecin/{idM}")
    public int getNbrRendezVousMedecin(@PathVariable Long idM) {
        return serviceProjet.getNbrRendezVousMedecin(idM);
    }

    @GetMapping("/getRevenue/{idM}/{startDate}/{endDate}")
    public int getRevenue(@PathVariable Long idM,
                          @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                          @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return serviceProjet.getRevenueMedecin(idM, startDate, endDate);
    }
}
