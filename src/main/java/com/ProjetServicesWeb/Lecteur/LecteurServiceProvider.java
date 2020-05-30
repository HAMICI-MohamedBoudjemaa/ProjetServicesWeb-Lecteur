package com.ProjetServicesWeb.Lecteur;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface LecteurServiceProvider {
    Lecteur create(Lecteur lecteur);
    Optional<Lecteur> findById(Integer id);
    List<Lecteur> findByNom(String nom);
    List<Lecteur> findByPrenom(String prenom);
    List<Lecteur> findByGenre(String genre);
    List<Lecteur> findByDateNaissance(Date dateNaissance);
    List<Lecteur> findByAdresse(String adresse);
    List<Lecteur> getAll();
    Lecteur modify(final Lecteur livre);
    int delete(Integer id);

}
