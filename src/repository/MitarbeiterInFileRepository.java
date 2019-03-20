package repository;

import model.Mitarbeiter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MitarbeiterInFileRepository implements CRUDRepository{

    List<Mitarbeiter> inFile = new ArrayList<>();
    File file = new File("D:\\Java\\Laborator3FX\\mitarbeiter.txt");

    public MitarbeiterInFileRepository() {

        try {
            readFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile() throws IOException {

        PrintWriter printWriter = new PrintWriter(file);
        StringBuilder stringBuilder = new StringBuilder();

        for(Mitarbeiter m : inFile){

            stringBuilder.append(m.getId()).append(',');
            stringBuilder.append(m.getVorname()).append(',');
            stringBuilder.append(m.getNachname()).append(',');
            stringBuilder.append(m.getAdresse()).append(',');
            stringBuilder.append(m.getBerufsPosition()).append(',');
            stringBuilder.append(m.getErfahrungsNiveau()).append(',');
            stringBuilder.append(m.getStundenLohn()).append(',');
            stringBuilder.append(m.getStundenProTag()).append(',').append('\n');

            String string = stringBuilder.toString();
            printWriter.write(string);

            stringBuilder.setLength(0);
        }

        printWriter.close();

        /*
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for (Mitarbeiter m : mimr.findAll()) {

            String idString = Long.toString(m.getId());
            String
            printWriter.write(idString);
            printWriter.write(m.getVorname());
            printWriter.write(m.getNachname());
            printWriter.write(m.getAdresse());
            printWriter.write(m.getBerufsPosition());

        }

        printWriter.close();
        */

    }


    public void readFromFile() throws FileNotFoundException{

        Scanner scanner = new Scanner(file);
        //List<Mitarbeiter> alleMitarbeiter = new ArrayList<>();

        while(scanner.hasNextLine()){

            String mitarbeiter = scanner.nextLine();
            String[] strings = mitarbeiter.split(",");
            Long id = Long.valueOf(strings[0]);
            String vorname = strings[1];
            String nachname = strings[2];
            String adresse = strings[3];
            Mitarbeiter.BerufListe berufsPosition = Mitarbeiter.BerufListe.valueOf(strings[4]);
            Integer niveau = Integer.valueOf(strings[5]);
            Double lohn = Double.valueOf(strings[6]);
            Integer stunden = Integer.valueOf(strings[7]);

            Mitarbeiter newMitarbeiter = new Mitarbeiter(id, vorname, nachname, adresse, berufsPosition, niveau, lohn, stunden);
            inFile.add(newMitarbeiter);

        }

        //return alleMitarbeiter;
    }
    /*
    public void readFromFile() throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Object object;

        while((object = objectInputStream.readObject()) != null){

            if(object instanceof Mitarbeiter){

                mimr.save((Mitarbeiter) object);
            }
        }

        objectInputStream.close();
    }
    */

    @Override
    public Long findOne(Long id) {

        for(Mitarbeiter m : inFile) {
            if(m.getId() == id)
                return id;
        }

        return null;
    }

    @Override
    public List<Mitarbeiter> findAll() {

        return inFile;
    }

    @Override
    public Mitarbeiter save(Mitarbeiter mitarbeiter) {

        if(findOne(mitarbeiter.getId()) == null) {

            inFile.add(mitarbeiter);

            try {
                writeToFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return mitarbeiter;
        }

        return null;
    }

    @Override
    public Mitarbeiter delete(Long id) {

        for(Mitarbeiter m : inFile) {

            if(m.getId() == id) {

                inFile.remove(m);

                try {
                    writeToFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return m;
            }
        }
        return null;
    }

    @Override
    public Mitarbeiter update(Mitarbeiter mitarbeiter) {

        if(findOne(mitarbeiter.getId()) != null)
        {
            for(Mitarbeiter m : inFile){

                if(m.getId() == mitarbeiter.getId()) {

                    m.setVorname(mitarbeiter.getVorname());
                    m.setNachname(mitarbeiter.getNachname());
                    m.setAdresse(mitarbeiter.getAdresse());
                    m.setBerufsPosition(mitarbeiter.getBerufsPosition());
                    m.setErfahrungsNiveau(mitarbeiter.getErfahrungsNiveau());
                    m.setStundenLohn(mitarbeiter.getStundenLohn());
                    m.setStundenProTag(mitarbeiter.getStundenProTag());

                    try {
                        writeToFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    return mitarbeiter;
                }
            }
        }
        return null;
    }
}
