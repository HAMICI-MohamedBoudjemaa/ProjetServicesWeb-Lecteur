package com.ProjetServicesWeb.Lecteur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/lecteurs")
public class LecteurController {
    @Autowired
    private LecteurServiceProvider lecteurServiceProvider;

    @GetMapping("{id}")
    public ResponseEntity<EntityModel<Lecteur>> findById(@PathVariable("id") Integer id){
        Optional<Lecteur> cree = lecteurServiceProvider.findById(id);
        Lecteur Lecteur = cree.orElse(new Lecteur());
        Link lien = linkTo(methodOn(LecteurController.class).findById(id)).withSelfRel();
        return new ResponseEntity<>(new EntityModel<>(Lecteur, lien), CREATED);
    }


    @GetMapping
    public ResponseEntity<CollectionModel<Lecteur>> findBy(@RequestParam(value = "nom", required = false) String nom,
                                                         @RequestParam(value = "prenom", required = false) String prenom,
                                                         @RequestParam(value = "genre", required = false) String genre,
                                                         @RequestParam(value = "dateNaissance", required = false) Date dateNaissance,
                                                         @RequestParam(value = "adresse", required = false) String adresse
    ){
        List<Lecteur> cree = null;
        if(nom!=null){cree = lecteurServiceProvider.findByNom(nom);}
        else if(prenom!=null){cree = lecteurServiceProvider.findByPrenom(prenom);}
        else if(genre!=null){cree = lecteurServiceProvider.findByGenre(genre);}
        else if(dateNaissance!=null){cree = lecteurServiceProvider.findByDateNaissance(dateNaissance);}
        else if(adresse!=null){cree = lecteurServiceProvider.findByAdresse(adresse);}
        else{cree = lecteurServiceProvider.getAll();}
        Link lien = linkTo(methodOn(LecteurController.class).findBy(nom, prenom, genre, dateNaissance, adresse)).withSelfRel();
        return new ResponseEntity<CollectionModel<Lecteur>>(new CollectionModel<>(cree, lien), CREATED);
    }

    @PostMapping
    public ResponseEntity<EntityModel<Lecteur>> create(@RequestBody Lecteur Lecteur){
        Lecteur cree = lecteurServiceProvider.create(Lecteur);
        Link lien = linkTo(methodOn(LecteurController.class).findById(cree.getId())).withSelfRel();
        return new ResponseEntity<>(new EntityModel<>(cree, lien), CREATED);
    }

    @PutMapping
    public ResponseEntity<EntityModel<Lecteur>> modify(@RequestBody Lecteur Lecteur){
        Lecteur cree = lecteurServiceProvider.modify(Lecteur);
        Link lien = linkTo(methodOn(LecteurController.class).findById(cree.getId())).withSelfRel();
        return new ResponseEntity<>(new EntityModel<>(cree, lien), CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") Integer id){
        int deleted = lecteurServiceProvider.delete(id);
        return new ResponseEntity<Integer>(deleted, CREATED);
    }
}
