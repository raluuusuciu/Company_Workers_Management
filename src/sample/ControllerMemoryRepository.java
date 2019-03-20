package sample;

import controller.MitarbeiterController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Mitarbeiter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerMemoryRepository implements Initializable {

    private MitarbeiterController ctrl;

    @FXML
    public AnchorPane pane2;
    @FXML
    public Button addButton;
    @FXML
    public Button displayButton;
    @FXML
    public TableView<Mitarbeiter> tableMitarbeiter;
    @FXML
    public TextField id;
    @FXML
    public TextField vorname;
    @FXML
    public TextField nachname;
    @FXML
    public TextField adresse;
    @FXML
    public ChoiceBox<String> berufPositionChoiceBox;
    @FXML
    public TextField niveau;
    @FXML
    public TextField lohn;
    @FXML
    public TextField stunden;
    @FXML
    public Label message;
    @FXML
    public Button backButton;
    @FXML
    public Button deleteButton;
    @FXML
    public Button updateButton;
    @FXML
    public Button clearButton;
    @FXML
    public Button salaryButton;
    @FXML
    public Button salaryByPositionButton;
    @FXML
    public Button salaryByNiveauButton;

    @FXML
    public TableColumn<Mitarbeiter, String> idColumn;
    @FXML
    public TableColumn<Mitarbeiter, String> vornameColumn;
    @FXML
    public TableColumn<Mitarbeiter, String> nachnameColumn;
    @FXML
    public TableColumn<Mitarbeiter, String> adresseColumn;
    @FXML
    public TableColumn<Mitarbeiter, String> positionColumn;
    @FXML
    public TableColumn<Mitarbeiter, String> niveauColumn;
    @FXML
    public TableColumn<Mitarbeiter, String> lohnColumn;
    @FXML
    public TableColumn<Mitarbeiter, String> stundenColumn;

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {

        this.ctrl = new MitarbeiterController();
        ctrl.changeRepo(false);

        try {

            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            vornameColumn.setCellValueFactory(new PropertyValueFactory<>("vorname"));
            nachnameColumn.setCellValueFactory(new PropertyValueFactory<>("nachname"));
            adresseColumn.setCellValueFactory(new PropertyValueFactory<>("adresse"));
            positionColumn.setCellValueFactory(new PropertyValueFactory<>("berufsPosition"));
            niveauColumn.setCellValueFactory(new PropertyValueFactory<>("erfahrungsNiveau"));
            lohnColumn.setCellValueFactory(new PropertyValueFactory<>("stundenLohn"));
            stundenColumn.setCellValueFactory(new PropertyValueFactory<>("stundenProTag"));

            Mitarbeiter mitarbeiter = new Mitarbeiter(1L, "raluca", "suciu", "Fabricii de Zahar", Mitarbeiter.BerufListe.PROJEKTMANAGER, 8, 20.0, 8);
            Mitarbeiter mitarbeiter1 = new Mitarbeiter(2L, "tudor", "suciu", "Fabricii de Zahar", Mitarbeiter.BerufListe.TESTER, 5, 5.0, 4);
            Mitarbeiter mitarbeiter2 = new Mitarbeiter(3L, "adrian", "lupea", "Zaharia Carcalechi", Mitarbeiter.BerufListe.ENTWICKLER, 6, 10.0, 8);
            Mitarbeiter mitarbeiter3 = new Mitarbeiter(4L, "dorel", "oprea", "Actorului", Mitarbeiter.BerufListe.TESTER, 7, 15.0, 8);

            ctrl.saveMitarbeiter(mitarbeiter);
            ctrl.saveMitarbeiter(mitarbeiter1);
            ctrl.saveMitarbeiter(mitarbeiter2);
            ctrl.saveMitarbeiter(mitarbeiter3);

            Image addImage = new Image(getClass().getResourceAsStream("addButton.jpg"));
            ImageView addImageView = new ImageView((addImage));
            addImageView.setFitHeight(25);
            addImageView.setFitWidth(25);
            addButton.setGraphic(addImageView);

            Image displayImage = new Image(getClass().getResourceAsStream("displayButton.jpg"));
            ImageView displayImageView = new ImageView((displayImage));
            displayImageView.setFitHeight(25);
            displayImageView.setFitWidth(25);
            displayButton.setGraphic(displayImageView);

            Image deleteImage = new Image(getClass().getResourceAsStream("deleteButton.jpg"));
            ImageView deleteImageView = new ImageView((deleteImage));
            deleteImageView.setFitHeight(25);
            deleteImageView.setFitWidth(25);
            deleteButton.setGraphic(deleteImageView);

            Image updateImage = new Image(getClass().getResourceAsStream("updateButton.jpg"));
            ImageView updateImageView = new ImageView((updateImage));
            updateImageView.setFitHeight(25);
            updateImageView.setFitWidth(25);
            updateButton.setGraphic(updateImageView);

            Image backImage = new Image(getClass().getResourceAsStream("backButton.jpg"));
            ImageView backImageView = new ImageView((backImage));
            backImageView.setFitHeight(20);
            backImageView.setFitWidth(20);
            backButton.setGraphic(backImageView);

            Image salaryImage = new Image(getClass().getResourceAsStream("salaryButton.jpg"));
            ImageView salaryImageView = new ImageView((salaryImage));
            salaryImageView.setFitHeight(25);
            salaryImageView.setFitWidth(25);
            salaryButton.setGraphic(salaryImageView);

            Image clearImage = new Image(getClass().getResourceAsStream("clearButton.jpg"));
            ImageView clearImageView = new ImageView((clearImage));
            clearImageView.setFitHeight(25);
            clearImageView.setFitWidth(25);
            clearButton.setGraphic(clearImageView);

            tableMitarbeiter.
                    setStyle("-fx-selection-bar: red; -fx-selection-bar-non-focused: salmon;");

        } catch (NullPointerException ignored) {
        }
    }

    @FXML

    public void showAll() {

        tableMitarbeiter.getItems().clear();

        ObservableList<Mitarbeiter> mitarbeiterObervableList = FXCollections.observableArrayList(ctrl.findAll());
        tableMitarbeiter.getItems().addAll(mitarbeiterObervableList);
    }

    @FXML
    public void addMitarbeiter() {

        if (
                (id.getText() != null && !id.getText().isEmpty()) &&
                        (vorname.getText() != null && !vorname.getText().isEmpty()) &&
                        (nachname.getText() != null && !nachname.getText().isEmpty()) &&
                        (adresse.getText() != null && !adresse.getText().isEmpty()) &&
                        (berufPositionChoiceBox.getValue() != null && !berufPositionChoiceBox.getValue().isEmpty()) &&
                        (niveau.getText() != null && !niveau.getText().isEmpty()) &&
                        (lohn.getText() != null && !lohn.getText().isEmpty()) &&
                        (stunden.getText() != null && !stunden.getText().isEmpty())
        ) {

            Mitarbeiter newMitarbeiter = new Mitarbeiter(Long.valueOf(id.getText()), vorname.getText(), nachname.getText(), adresse.getText(), Mitarbeiter.BerufListe.valueOf(berufPositionChoiceBox.getValue()), Integer.valueOf(niveau.getText()), Double.valueOf(lohn.getText()), Integer.valueOf(stunden.getText()));
            ctrl.saveMitarbeiter(newMitarbeiter);
            message.setText("Employee " + vorname.getText() + " " + nachname.getText() + " successfully added!");

        } else {
            message.setText("Not all the fields are filled, try again!");
        }
    }

    @FXML
    public void updateMitarbeiter() {

        if (
                (id.getText() != null && !id.getText().isEmpty()) &&
                        (vorname.getText() != null && !vorname.getText().isEmpty()) &&
                        (nachname.getText() != null && !nachname.getText().isEmpty()) &&
                        (adresse.getText() != null && !adresse.getText().isEmpty()) &&
                        (berufPositionChoiceBox.getValue() != null && !berufPositionChoiceBox.getValue().isEmpty()) &&
                        (niveau.getText() != null && !niveau.getText().isEmpty()) &&
                        (lohn.getText() != null && !lohn.getText().isEmpty()) &&
                        (stunden.getText() != null && !stunden.getText().isEmpty())
        ) {
            Mitarbeiter newMitarbeiter = new Mitarbeiter(Long.valueOf(id.getText()), vorname.getText(), nachname.getText(), adresse.getText(), Mitarbeiter.BerufListe.valueOf(berufPositionChoiceBox.getValue()), Integer.valueOf(niveau.getText()), Double.valueOf(lohn.getText()), Integer.valueOf(stunden.getText()));
            ctrl.updateMitarbeiter(newMitarbeiter);
            message.setText("Employee successfully updated!");
        } else {
            message.setText("Not all the fields are filled, try again!");
        }
    }

    @FXML
    public void removeMiarbeiter() {

        int selectedIndex = tableMitarbeiter.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {

            //variable = expression ? value if true : value is false - evaluates a boolean expression
            int newSelectedIndex = (selectedIndex == tableMitarbeiter.getItems().size() - 1) ? selectedIndex - 1 : selectedIndex;

            ctrl.deleteMitarbeiter(tableMitarbeiter.getSelectionModel().getSelectedItem());
            tableMitarbeiter.getItems().remove(selectedIndex);

            message.setText("Employee has been successfully removed!");
            tableMitarbeiter.getSelectionModel().select(newSelectedIndex);

        }
    }

    @FXML
    public void kalkuliereLohn() {

        int selectedIndex = tableMitarbeiter.getSelectionModel().getSelectedIndex();

        if (selectedIndex != -1) {

            Double lohn = ctrl.kalculiereLohn(tableMitarbeiter.getSelectionModel().getSelectedItem(), 365);
            message.setText(tableMitarbeiter.getSelectionModel().getSelectedItem().getNachname() + " " + tableMitarbeiter.getSelectionModel().getSelectedItem().getVorname() + "'s salary/year is: " + lohn.toString());

        }
    }

    @FXML
    public void kalkuliereLohnBerufsPosition() {

        List<Double> listNiveau = ctrl.lohnBerufsPosition(Mitarbeiter.BerufListe.valueOf(berufPositionChoiceBox.getValue()));
        if (berufPositionChoiceBox.getValue().isEmpty()) {

            message.setText("There was no position given.");
        } else {

            if (listNiveau.isEmpty()) {

                message.setText("There are no employees registered with the given Position.");
            } else {

                message.setText("List of salaries with the given Position: " + listNiveau.toString());
            }

        }
    }

    @FXML
    public void kalkuliereLohnNiveau() {

        Integer selectedNiveau = Integer.valueOf(niveau.getText());
        if (niveau.getText().isEmpty()) {

            message.setText("There was no given niveau.");
        } else {

            List<Double> listNiveau = ctrl.lohnErfahrungsNiveau(selectedNiveau);
            if (listNiveau.isEmpty()) {

                message.setText("There are no employees registered with the given Position.");
            } else {

                message.setText("List of salaries with the given niveau: " + listNiveau.toString());
            }
        }
    }

    @FXML
    public void closeWindow() {

        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void clearTextField() {


        id.clear();
        vorname.clear();
        nachname.clear();
        adresse.clear();
        berufPositionChoiceBox.getSelectionModel().clearSelection();
        niveau.clear();
        lohn.clear();
        stunden.clear();

        message.setText(null);
    }

}
