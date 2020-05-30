package com.ProjetServicesWeb.Lecteur;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface LecteurRepository extends JpaRepository<Lecteur, Integer> {
    List<Lecteur> findByNom(final String nom);
    List<Lecteur> findByPrenom(final String prenom);
    List<Lecteur> findByGenre(final String genre);
    List<Lecteur> findByDateNaissance(final Date dateNaissance);
    List<Lecteur> findByAdresse(final String adresse);
}
