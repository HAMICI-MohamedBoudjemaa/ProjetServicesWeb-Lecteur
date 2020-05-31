package com.ProjetServicesWeb.Lecteur;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class LecteurApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private LecteurRepository repository;

	@Autowired
	private LecteurController lecteurController;

	@Test
	public void testFindById() {
		Lecteur cree = new Lecteur("masculin","nom1", "prenom1", new Date("22/05/1995"), "adresse1");
		lecteurController.create(cree);
		Lecteur cree2 = new Lecteur("feminin","nom2", "prenom2", new Date("24/03/1996"), "adresse2");
		lecteurController.create(cree2);

		ResponseEntity<EntityModel<Lecteur>> entityLecteur = lecteurController.findById(2);
		Lecteur lecteur = entityLecteur.getBody().getContent();
		assertTrue(lecteur.getId()==2);

		//assertThat(books).extracting(com.ProjetServicesWeb.Lecteur.Lecteur::getName).containsOnly("C++");

	}

	@Test
	public void testFindByNom() {
		Lecteur cree = new Lecteur("masculin","nom1", "prenom1", new Date("22/05/1995"), "adresse1");
		lecteurController.create(cree);
		Lecteur cree2 = new Lecteur("feminin","nom2", "prenom2", new Date("24/03/1996"), "adresse2");
		lecteurController.create(cree2);


		List<Lecteur> lecteur = lecteurController.findBy("nom2",null,null,null, null).getBody().getContent().stream().collect(Collectors.toList());
		assertEquals(cree2.getNom(), lecteur.get(0).getNom());

		//assertThat(books).extracting(com.ProjetServicesWeb.Lecteur.Lecteur::getName).containsOnly("C++");
	}

	@Test
	public void testFindByPrenom() {
		Lecteur cree = new Lecteur("masculin","nom1", "prenom1", new Date("22/05/1995"), "adresse1");
		lecteurController.create(cree);
		Lecteur cree2 = new Lecteur("feminin","nom2", "prenom2", new Date("24/03/1996"), "adresse2");
		lecteurController.create(cree2);


		List<Lecteur> lecteur = lecteurController.findBy(null,"prenom2",null,null, null).getBody().getContent().stream().collect(Collectors.toList());
		assertEquals(cree2.getPrenom(), lecteur.get(0).getPrenom());

		//assertThat(books).extracting(com.ProjetServicesWeb.Lecteur.Lecteur::getName).containsOnly("C++");
	}

	@Test
	public void testFindByGenre() {
		Lecteur cree = new Lecteur("masculin","nom1", "prenom1", new Date("22/05/1995"), "adresse1");
		lecteurController.create(cree);
		Lecteur cree2 = new Lecteur("feminin","nom2", "prenom2", new Date("24/03/1996"), "adresse2");
		lecteurController.create(cree2);


		List<Lecteur> lecteur = lecteurController.findBy(null,null,"feminin",null, null).getBody().getContent().stream().collect(Collectors.toList());
		assertEquals(cree2.getGenre(), lecteur.get(0).getGenre());

		//assertThat(books).extracting(com.ProjetServicesWeb.Lecteur.Lecteur::getName).containsOnly("C++");
	}

	@Test
	public void testFindByDateNaissance() {
		Lecteur cree = new Lecteur("masculin","nom1", "prenom1", new Date("22/05/1995"), "adresse1");
		lecteurController.create(cree);
		Lecteur cree2 = new Lecteur("feminin","nom2", "prenom2", new Date("24/03/1996"), "adresse2");
		lecteurController.create(cree2);


		List<Lecteur> lecteur = lecteurController.findBy(null,null,null,new Date("24/03/1996"), null).getBody().getContent().stream().collect(Collectors.toList());
		assertEquals(cree2.getDateNaissance(), lecteur.get(0).getDateNaissance());

		//assertThat(books).extracting(com.ProjetServicesWeb.Lecteur.Lecteur::getName).containsOnly("C++");
	}

	@Test
	public void testFindByAdresse() {
		Lecteur cree = new Lecteur("masculin","nom1", "prenom1", new Date("22/05/1995"), "adresse1");
		lecteurController.create(cree);
		Lecteur cree2 = new Lecteur("feminin","nom2", "prenom2", new Date("24/03/1996"), "adresse2");
		lecteurController.create(cree2);


		List<Lecteur> lecteur = lecteurController.findBy(null,null,null,null, "adresse2").getBody().getContent().stream().collect(Collectors.toList());
		assertEquals(cree2.getAdresse(), lecteur.get(0).getAdresse());

		//assertThat(books).extracting(com.ProjetServicesWeb.Lecteur.Lecteur::getName).containsOnly("C++");
	}

	@Test
	public void testFindAll() {
		Lecteur cree = new Lecteur("masculin","nom1", "prenom1", new Date("22/05/1995"), "adresse1");
		lecteurController.create(cree);
		Lecteur cree2 = new Lecteur("feminin","nom2", "prenom2", new Date("24/03/1996"), "adresse2");
		lecteurController.create(cree2);


		List<Lecteur> lecteur = lecteurController.findBy(null,null,null,null,null).getBody().getContent().stream().collect(Collectors.toList());
		assertTrue(lecteur.size()>=2);

		//assertThat(books).extracting(com.ProjetServicesWeb.Lecteur.Lecteur::getName).containsOnly("C++");

	}

	@Test
	public void testModify() {
		ResponseEntity<EntityModel<Lecteur>> cree = lecteurController.create(new Lecteur("masculin","nom1", "prenom1", new Date("22/05/1995"), "adresse1"));

		assertTrue(cree.getBody().getContent().getGenre()=="masculin");
		Lecteur cree2 = cree.getBody().getContent();
		cree2.setGenre("feminin");
		Lecteur lecteur = lecteurController.modify(cree2).getBody().getContent();
		assertTrue(cree.getBody().getContent().getGenre()=="feminin");

		//assertThat(books).extracting(com.ProjetServicesWeb.Lecteur.Lecteur::getName).containsOnly("C++");

	}

	@Test
	public void testDelete() {
		Lecteur cree = new Lecteur("masculin","nom1", "prenom1", new Date("22/05/1995"), "adresse1");
		lecteurController.create(cree);

		int result = lecteurController.delete(1).getBody();
		assertEquals(1, result);

		//assertThat(books).extracting(com.ProjetServicesWeb.Lecteur.Lecteur::getName).containsOnly("C++");

	}

}
