import java.util.Date;
import java.util.List;

public class Lecteur {
    private static int nbLecteurs = 0;
    private int id;
    private String genre;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String adresse;

    public Lecteur(String genre, String nom, String prenom, Date dateNaissance, String adresse) {
        nbLecteurs++;
        this.id = nbLecteurs;
        this.genre = genre;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
    }

    public static int getNbLecteurs() {
        return nbLecteurs;
    }

    public static void setNbLecteurs(int nbLecteurs) {
        Lecteur.nbLecteurs = nbLecteurs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void ajouterLecteur(String genre, String nom, String prenom, Date dateNaissance, String adresse){
        Lecteur lecteur = new Lecteur(genre, nom, prenom, dateNaissance, adresse);
    }

    public Lecteur recupererLecteur(String isbn){

    }

    public List<Lecteur> listerLecteur(){

    }

    public void modifierLecteur(String genre, String nom, String prenom, Date dateNaissance, String adresse){

    }

    public void supprimerLecteur(){

    }

    public boolean existeLecteur(int id){
        if(/*Lecteur existe en base*/true){
            return true;
        }
        return false;
    }
}
