package com.pharmacie.RestPharmacie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacie.RestPharmacie.dao.IPharmacie;
import com.pharmacie.RestPharmacie.entities.Pharmacie;

@RestController
public class PharmacieService {
	
	    @Autowired
	    private IPharmacie pharmaciedao;


	    @RequestMapping(value="/pharmacie/api/liste", method= RequestMethod.GET)
	    public List<Pharmacie> listePharmacies(){
	        List<Pharmacie> pharmacies = pharmaciedao.findAll();
	        return pharmacies;
	    }

	    @PostMapping(value = "/pharmacie/api/add")
	    public String ajouterPharmacie(@RequestBody Pharmacie pharmacie) {
	      
	        try {
	            pharmaciedao.save(pharmacie);
	            return "Ajout reuisit";


	        }catch (Exception e){

	            return "Erreur d'insertion";

	        }
	    }

	    @PutMapping("/pharmacie/api/edit/{id}")
	    public String updatePharmacie(@RequestBody Pharmacie pharmacie, @PathVariable("id") Long id) {

	        try {
	            Pharmacie existingPharmacie = pharmaciedao.getOne(id);

	            existingPharmacie.setEtat(pharmacie.getEtat());
	            existingPharmacie.setNom(pharmacie.getNom());
	            existingPharmacie.setQuartier(pharmacie.getQuartier());

	            pharmaciedao.save(existingPharmacie);

	            return "Modification reuisit!!!!!";

	        } catch (Exception e) {

	            return "Modification erreur !!!!!";        }

	    }
	    @DeleteMapping(value = "/pharmacie/api/delete/{id}")
	    public void deletePharmacie(@PathVariable("id") Long id) {
	        pharmaciedao.deleteById(id);
	    }


	

}
