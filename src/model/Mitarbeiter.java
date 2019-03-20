package model;

public class Mitarbeiter extends Person {

    public enum BerufListe {

        ENTWICKLER, TESTER, PROJEKTMANAGER, TEAMLEADER;
    }

    private BerufListe berufsPosition;
    private Integer erfahrungsNiveau;
    private Double stundenLohn;
    private Integer stundenProTag;

    public Mitarbeiter(Long id, String vorname, String nachname, String adresse, BerufListe berufsPosition, Integer erfahrungsNiveau, Double stundenLohn, Integer stundenProTag){

        //herbeirufen des Konstruktors der Basis-Klasse
        super(id, vorname, nachname, adresse);

        this.berufsPosition = berufsPosition;
        this.erfahrungsNiveau = erfahrungsNiveau;
        this.stundenLohn = stundenLohn;
        this.stundenProTag = stundenProTag;
    }

    public BerufListe getBerufsPosition() {
        return berufsPosition;
    }

    public void setBerufsPosition(BerufListe berufsPosition) {
        this.berufsPosition = berufsPosition;
    }

    public Integer getErfahrungsNiveau() {
        return erfahrungsNiveau;
    }

    public void setErfahrungsNiveau(Integer erfahrungsNiveau) {
        this.erfahrungsNiveau = erfahrungsNiveau;
    }

    public Double getStundenLohn() {
        return stundenLohn;
    }

    public void setStundenLohn(Double stundenLohn) {
        this.stundenLohn = stundenLohn;
    }

    public Integer getStundenProTag() {
        return stundenProTag;
    }

    public void setStundenProTag(Integer stundenProTag) {
        this.stundenProTag = stundenProTag;
    }


    @Override
    public String toString(){

        return (super.toString() + " BerufsPosition: " + this.getBerufsPosition() + " ErfahrungsNiveau: " + this.getErfahrungsNiveau() + " StundenLohn: " + this.getStundenLohn() + " StundenProTag: " + this.getStundenProTag()) + "\n";
    }
}

