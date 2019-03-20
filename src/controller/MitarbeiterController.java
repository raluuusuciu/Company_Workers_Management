package controller;


import model.Mitarbeiter;
import model.Person;
import repository.CRUDRepository;
import repository.MitarbeiterInFileRepository;
import repository.MitarbeiterInMemoryRepository;

import java.util.ArrayList;
import java.util.List;

public class MitarbeiterController {

    private CRUDRepository crudRepo;

//    public MitarbeiterController(){
//
//        this.crudRepo = new MitarbeiterInMemoryRepository();
//    }

    public CRUDRepository getCrudRepo() {
        return crudRepo;
    }

    public void setCrudRepo(CRUDRepository crudRepo) {
        this.crudRepo = crudRepo;
    }


    public void changeRepo(boolean isFileRepo) {

        if (isFileRepo) {
            crudRepo = new MitarbeiterInFileRepository();
        } else {

            crudRepo = new MitarbeiterInMemoryRepository();
        }
    }

    public Long findMiarbeiterById(Long id) {

        return crudRepo.findOne(id);
    }

    public List<Mitarbeiter> findAll() {

        List<Mitarbeiter> mitarbeiter = new ArrayList<>();
        for (Object obj : crudRepo.findAll()) {
            mitarbeiter.add((Mitarbeiter) obj);
        }
        return mitarbeiter;
    }

    public Mitarbeiter saveMitarbeiter(Mitarbeiter p) {

        return crudRepo.save(p);
    }

    public Mitarbeiter deleteMitarbeiter(Mitarbeiter p) {

        return crudRepo.delete(p.getId());
    }

    public Mitarbeiter updateMitarbeiter(Mitarbeiter p) {

        return crudRepo.update(p);
    }

    /**
     * @param p          - die Person dessen Lohn berechnet wird
     * @param anzahlTage - anzahl der Tage fur denen man den Lohn berechnet
     * @return wie viel Geld die Person p verdient in anzahlTage
     */
    public Double kalculiereLohn(Person p, Integer anzahlTage) {

        Mitarbeiter m = (Mitarbeiter) p;
        Integer gearbeiteteStunden = m.getStundenProTag() * anzahlTage;
        Double lohnP;
        lohnP = m.getStundenLohn() * gearbeiteteStunden;

        return lohnP;
    }

    public Double kalkuliereLohnJahr(Person p) {

        return kalculiereLohn(p, 365);
    }

    /**
     * @param berufsPosition - ausgewahlte Berufsposition fur die man den Lohn sehen will
     * @return eine Liste mit alle Lohne, die die Mitarbeiter mit der Berufsposition verdienen
     */
    public List<Double> lohnBerufsPosition(Mitarbeiter.BerufListe berufsPosition) {

        List<Double> lohnPosition = new ArrayList<>();

        for (Mitarbeiter m : crudRepo.findAll()) {

            if (m.getBerufsPosition().equals(berufsPosition)) {

                Double lohn = kalculiereLohn(m, 365);
                lohnPosition.add(lohn);
            }
        }
        return lohnPosition;
    }

    /**
     * @return eine Liste mit der Lohne aller Mitarbeiter
     */
    public List<Double> lohnMitarbeiter() {

        List<Double> lohnAlle = new ArrayList<>();

        for (Mitarbeiter m : crudRepo.findAll()) {

            Double lohn = kalculiereLohn(m, 365);
            lohnAlle.add(lohn);
        }

        return lohnAlle;
    }

    /**
     * @param niveau - das gegebene Niveau
     * @return eine Liste mit der Lohne der Mitarbeiter, die sich bei der gegebenen Niveau befinden
     */
    public List<Double> lohnErfahrungsNiveau(Integer niveau) {

        List<Double> lohnNiveau = new ArrayList<>();

        for (Mitarbeiter m : crudRepo.findAll()) {

            if (m.getErfahrungsNiveau().equals(niveau)) {

                Double lohn = kalculiereLohn(m, 365);
                lohnNiveau.add(lohn);
            }
        }

        return lohnNiveau;
    }
}

