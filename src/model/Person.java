package model;

import java.util.Objects;

public class Person {


    private Long id;
    private String vorname;
    private String nachname;
    private String adresse;

    public Person(long id, String vorname, String nachname, String adresse) {

        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {

        return "ID: " + this.getId() + " Vorname: " + this.getVorname() + " Nachname: " + this.getNachname() + " Adresse: " + this.getAdresse();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(vorname, person.vorname) &&
                Objects.equals(nachname, person.nachname) &&
                Objects.equals(adresse, person.adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vorname, nachname, adresse);
    }

    /*
    @Override
    public boolean equals(Object o){

        //wenn das Objekt mit sich selbst vegleicht dann ist es wahr
        if (o == this)
            return true;

        //uberpruft, ob das gegebene Objekt eine Instanz der Klasse Person
        if (!(o instanceof Person))
            return false;

        //typecast o zu Person, damit man die Daten vergleicht
        Person p = (Person) o;

        return Long.compare(id, p.id) == 0;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
    */
}
