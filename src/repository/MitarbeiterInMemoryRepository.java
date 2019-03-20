package repository;

import model.Mitarbeiter;

import java.util.ArrayList;
import java.util.List;

public class MitarbeiterInMemoryRepository implements CRUDRepository {

    private List<Mitarbeiter> inMemory = new ArrayList<>();

    public List<Mitarbeiter> getInMemory() {
        return inMemory;
    }

    public void setInMemory(List<Mitarbeiter> inMemory) {
        this.inMemory = inMemory;
    }


    @Override
    public Long findOne(Long id) {

        for(Mitarbeiter m : inMemory) {
            if(m.getId() == id)
                return id;
        }

        return null;
    }

    @Override
    public List<Mitarbeiter> findAll() {

        return inMemory;
    }

    @Override
    public Mitarbeiter save(Mitarbeiter mitarbeiter) {

        if(findOne(mitarbeiter.getId()) == null) {

            inMemory.add(mitarbeiter);
            return mitarbeiter;
        }

        return null;
    }

    @Override
    public Mitarbeiter delete(Long id) {

        for(Mitarbeiter m : inMemory) {

            if(m.getId() == id) {

                inMemory.remove(m);
                return m;
            }
        }
        return null;
    }

    @Override
    public Mitarbeiter update(Mitarbeiter mitarbeiter) {

        if(findOne(mitarbeiter.getId()) != null)
        {
            for(Mitarbeiter m : inMemory){

                if(m.getId() == mitarbeiter.getId()) {

                    m.setVorname(mitarbeiter.getVorname());
                    m.setNachname(mitarbeiter.getNachname());
                    m.setAdresse(mitarbeiter.getAdresse());
                    m.setBerufsPosition(mitarbeiter.getBerufsPosition());
                    m.setErfahrungsNiveau(mitarbeiter.getErfahrungsNiveau());
                    m.setStundenLohn(mitarbeiter.getStundenLohn());
                    m.setStundenProTag(mitarbeiter.getStundenProTag());

                    return mitarbeiter;
                }
            }
        }
        return null;
    }

}


