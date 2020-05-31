package com.ProjetServicesWeb.Lecteur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class LecteurServiceProviderImpl implements LecteurServiceProvider{

    @Autowired
    private LecteurRepository lecteurRepository;

    @Override
    public Lecteur create(Lecteur lecteur) {
        return lecteurRepository.save(lecteur);
    }

    @Override
    public Optional<Lecteur> findById(Integer id) {
        return lecteurRepository.findById(id);
    }

    @Override
    public List<Lecteur> findByNom(String nom) {
        return lecteurRepository.findByNom(nom);
    }

    @Override
    public List<Lecteur> findByPrenom(String prenom) {
        return lecteurRepository.findByPrenom(prenom);
    }

    @Override
    public List<Lecteur> findByGenre(String genre) {
        return lecteurRepository.findByGenre(genre);
    }

    @Override
    public List<Lecteur> findByDateNaissance(Date dateNaissance) {
        return lecteurRepository.findByDateNaissance(dateNaissance);
    }

    @Override
    public List<Lecteur> findByAdresse(String adresse) {
        return lecteurRepository.findByAdresse(adresse);
    }

    @Override
    public List<Lecteur> getAll() {
        return lecteurRepository.findAll();
    }

    @Override
    public Lecteur modify(Lecteur lecteur) {
        if(findById(lecteur.getId())!=null)
        {
            return lecteurRepository.save(lecteur);
        }
        return null;
    }

    @Override
    public int delete(Integer id) {
        Optional<Lecteur> livre = findById(id);
        Lecteur myLivre = livre.orElse(null);
        if(findById(id)!=null){
            lecteurRepository.delete(myLivre);
            return 1;
        }
        return 0;
    }
}
