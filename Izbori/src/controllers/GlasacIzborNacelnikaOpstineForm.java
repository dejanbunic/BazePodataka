package controllers;

import DAO.KandidatDAO;
import client.Kandidat;
import client.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GlasacIzborNacelnikaOpstineForm implements Initializable {
    @FXML TableView<Kandidat> userTable;
    @FXML TableColumn<Kandidat,String> ime;
    @FXML TableColumn<Kandidat,String> prezime;
    @FXML TableColumn<Kandidat,String> stranka;
    @FXML TableColumn<Kandidat, CheckBox> izaberi;
    public void nazad(ActionEvent actionEvent) {
        Main main=new Main();
        Parent userView = null;
        try {
            userView = FXMLLoader.load(getClass().getResource("/views/GlasacIzborOdbornikaForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        main.getMainStage().setScene(new Scene(userView));
        main.getMainStage().show();
    }

    public void potvrdi(ActionEvent actionEvent) {
        Main main=new Main();
        Parent userView = null;
        try {
            userView = FXMLLoader.load(getClass().getResource("/views/LoginForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        main.getMainStage().setScene(new Scene(userView));
        main.getMainStage().show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        azurirajTabelu(KandidatDAO.prikaziKandidateZaOdbornika());
    }
    public void azurirajTabelu(ObservableList<Kandidat> kandidati){

        KandidatDAO kandidat = new KandidatDAO();
        kandidati=kandidat.prikaziKandidateZaNacelnika();
        ime.setCellValueFactory(new PropertyValueFactory<>("ime"));
        prezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        stranka.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        izaberi.setCellValueFactory(new PropertyValueFactory<>("izaberi"));
        userTable.setItems(kandidati);
    }
}

