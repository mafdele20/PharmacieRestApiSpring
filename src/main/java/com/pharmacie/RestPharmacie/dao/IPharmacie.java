package com.pharmacie.RestPharmacie.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmacie.RestPharmacie.entities.Pharmacie;

public interface IPharmacie extends JpaRepository<Pharmacie, Long> {

}
