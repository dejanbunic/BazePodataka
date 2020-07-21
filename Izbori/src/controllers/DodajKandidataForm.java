package controllers;

import DAO.KandidatDAO;
import client.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
public class DodajKandidataForm implements Initializable {

    @FXML
    TextField ime;
    @FXML
    TextField prezime;
    @FXML
    TextField mjestoRodjenja;
    @FXML
    DatePicker datumRodjenja;
    @FXML
    ChoiceBox politickaPartija;
    @FXML
    ChoiceBox opstina;
    @FXML
    ChoiceBox grad;
    @FXML
    ChoiceBox tipKandidata;
    @FXML
    TextField JMBG;

    public void setIme(TextField ime) {
        this.ime = ime;
    }

    public void dodajKandidata(ActionEvent actionEvent) {
       KandidatDAO kandidat = new KandidatDAO();
       kandidat.dodajKandidata(JMBG.getText(),ime.getText(),prezime.getText(),mjestoRodjenja.getText(),Date.valueOf(datumRodjenja.getValue()),
           String.valueOf(politickaPartija.getValue()),String.valueOf(opstina.getValue()),String.valueOf(grad.getValue()),String.valueOf(tipKandidata.getValue()));

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        KandidatDAO kandidat=new KandidatDAO();
        ObservableList<String> kandidati=  FXCollections.observableArrayList(
             "KandidatZaOdbornikaOpstine","KandidatZaNacelnikaOpstine"
        );
        tipKandidata.setItems(kandidati);
        tipKandidata.getSelectionModel().selectFirst();
        politickaPartija.setItems(kandidat.politickePartije());
        politickaPartija.getSelectionModel().selectFirst();
        grad.setItems(kandidat.gradovi());
        opstina.setItems(kandidat.opstine());
        opstina.getSelectionModel().selectFirst();
    }

    public void nazad(ActionEvent actionEvent) {
        Main main=new Main();
        Parent userView = null;
        try {
            userView = FXMLLoader.load(getClass().getResource("/views/AdministratorForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        main.getMainStage().setScene(new Scene(userView));

        main.getMainStage().show();
    }

  /*  public static void main(String args[]){
        KandidatDAO kandidat=new KandidatDAO();
        ObservableList<String> lista=kandidat.politickePartije();
        for(String s:lista){
            System.out.println(s);
        }
    }*/
}
