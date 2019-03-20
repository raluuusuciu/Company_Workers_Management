package repository;

import model.Mitarbeiter;

import java.util.List;

public interface CRUDRepository {

    /**
     * @param id - id der Person der gesucht wird, id ist nicht null
     * @return die Person mit dem gegebenen id, oder null wenn dieser nicht gibt
     */
    Long findOne(Long id);


    /**
     * @return alle Personen
     */
    List<Mitarbeiter> findAll();

    /**
     * @param mitarbeiter - person muss nicht null sein
     * @return null, wenn die gegebene Person in der Liste addiert wurde, oder das Objekt, wenn dieser sich schon in der Liste befindet
     */
    Mitarbeiter save(Mitarbeiter mitarbeiter);

    /**
     * @param id - muss nicht null sein
     * @return das Objekt, das geloscht wurde, oder null wenn es kein Objekt mit dem gegebenen id in der Liste gab
     */
    Mitarbeiter delete(Long id);

    /**
     * @param mitarbeiter - muss nicht null sein
     * @return null, wenn das Objekt geandert wurde, oder das Objekt, wenn dieser nicht nach dem id gefunden wurde
     */
    Mitarbeiter update(Mitarbeiter mitarbeiter);
}


