package controllers;

import DAO.KandidatDAO;
import DAO.StrankaDAO;
import client.Kandidat;
import client.Main;
import client.PolitickaStranka;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.Date;
import java.util.ResourceBundle;


public class GlasacIzborOdbornikaForm implements Initializable {
    @FXML TableView<Kandidat> userTable;
    @FXML TableColumn<Kandidat,String> ime;
    @FXML TableColumn<Kandidat,String> prezime;
    @FXML TableColumn<Kandidat,String> stranka;
    @FXML TableColumn<Kandidat, CheckBox> izaberi;
    @FXML TableView<PolitickaStranka> userTable1;
    @FXML TableColumn<PolitickaStranka,String> naziv1;
    @FXML TableColumn<PolitickaStranka, CheckBox> izaberi1;
    public void dalje(javafx.event.ActionEvent actionEvent) {
        Main main=new Main();
        Parent userView = null;
        try {
            userView = FXMLLoader.load(getClass().getResource("/views/GlasacIzborNacelnikaOpstineForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        main.getMainStage().setScene(new Scene(userView));
        main.getMainStage().show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        azurirajTabelu1(StrankaDAO.prikaziStranke());
        azurirajTabelu(KandidatDAO.prikaziKandidateZaOdbornika());

    }
    public void azurirajTabelu(ObservableList<Kandidat> kandidati){

        KandidatDAO kandidat = new KandidatDAO();
        kandidati=kandidat.prikaziKandidateZaOdbornika();
        ime.setCellValueFactory(new PropertyValueFactory<>("ime"));
        prezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        stranka.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        izaberi.setCellValueFactory(new PropertyValueFactory<>("izaberi"));
        userTable.setItems(kandidati);
    }
    public void azurirajTabelu1(ObservableList<PolitickaStranka> stranke){
        StrankaDAO stranka= new StrankaDAO();
        stranke=stranka.prikaziStranke();
        izaberi1.setCellValueFactory(new PropertyValueFactory<>("izaberi1"));
        naziv1.setCellValueFactory(new PropertyValueFactory<>("naziv"));

        userTable1.setItems(stranke);
    }


}
