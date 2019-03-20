package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    public RadioButton fileRepo;
    @FXML
    public RadioButton memoryRepo;
    @FXML
    public Button chooseButton;
    @FXML
    public Label image;
    @FXML
    public Label startText;
    @FXML
    public AnchorPane pane1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        final ToggleGroup toggleGroup = new ToggleGroup();
        fileRepo.setToggleGroup(toggleGroup);
        memoryRepo.setToggleGroup(toggleGroup);

        Image chooseImage = new Image(getClass().getResourceAsStream("chooseButton.jpg"));
        ImageView chooseImageView = new ImageView((chooseImage));
        chooseImageView.setFitHeight(35);
        chooseImageView.setFitWidth(35);
        chooseButton.setGraphic(chooseImageView);
    }

    @FXML
    public void repoMode() throws IOException {

        if (fileRepo.isSelected()) {

            Parent parent = FXMLLoader.load(getClass().getResource("fileRepository.fxml"));
            Scene scene = new Scene(parent,750,550);

            Stage newWindow = new Stage();
            newWindow.setScene(scene);
            newWindow.setTitle("File Repository");
            newWindow.getIcons().add(new Image("work.png"));
            newWindow.show();
        }

        if (memoryRepo.isSelected()) {
            Parent parent = FXMLLoader.load(getClass().getResource("memoryRepository.fxml"));
            Scene scene = new Scene(parent,750,550);

            Stage newWindow = new Stage();
            newWindow.setScene(scene);
            newWindow.setTitle("Memory Repository");
            newWindow.getIcons().add(new Image("work.png"));
            newWindow.show();
        }


    }

    @FXML
    public void setImageFile() {

        Image fileImage = new Image(getClass().getResourceAsStream("fileRepo.jpg"));
        ImageView fileImageView = new ImageView(fileImage);
        fileImageView.setFitWidth(90);
        fileImageView.setFitHeight(90);
        image.setGraphic(fileImageView);
        image.setAlignment(Pos.CENTER);

    }

    @FXML
    public void setImageMemory() {

        Image memoryImage = new Image(getClass().getResourceAsStream("memoryRepo.jpg"));
        ImageView memoryImageView = new ImageView(memoryImage);
        memoryImageView.setFitWidth(60);
        memoryImageView.setFitHeight(60);
        image.setGraphic(memoryImageView);
        image.setAlignment(Pos.CENTER);
    }
}
