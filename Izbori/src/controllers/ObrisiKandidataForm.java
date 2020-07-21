package controllers;

import DAO.KandidatDAO;
import client.Kandidat;
import client.KandidatZaNacelnikaOpstine;
import client.KandidatZaOdbornikaOpstine;
import client.Main;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ObrisiKandidataForm implements Initializable {
    @FXML
    TableView<KandidatZaNacelnikaOpstine> userTable1;
    @FXML
    TableColumn <KandidatZaNacelnikaOpstine,String> ime1;
    @FXML
    TableColumn <KandidatZaNacelnikaOpstine,String> prezime1;
    @FXML
    TableColumn <KandidatZaNacelnikaOpstine,String> politickaPartija1;
    @FXML
    TableColumn <KandidatZaNacelnikaOpstine,String> datumRodjenja1;
    @FXML
    TableColumn <KandidatZaNacelnikaOpstine,String> mjestoRodjenja1;
    @FXML
    TableView<KandidatZaOdbornikaOpstine> userTable2;
    @FXML
    TableColumn <KandidatZaOdbornikaOpstine,String> ime2;
    @FXML
    TableColumn <KandidatZaOdbornikaOpstine,String> prezime2;
    @FXML
    TableColumn <KandidatZaOdbornikaOpstine,String> politickaPartija2;
    @FXML
    TableColumn <KandidatZaOdbornikaOpstine,String> datumRodjenja2;
    @FXML
    TableColumn <KandidatZaOdbornikaOpstine,String> mjestoRodjenja2;






    @Override
    public void initialize(URL location, ResourceBundle resources) {
      azurirajTabelu1(KandidatDAO.prikaziKandidateZaNacelnikaOpstine());
      azurirajTabelu2(KandidatDAO.prikaziKandidateZaOdbornikaOpstine());
    }
    public void azurirajTabelu1(ObservableList<KandidatZaNacelnikaOpstine> kandidati){
        KandidatDAO kandidat = new KandidatDAO();
        kandidati=kandidat.prikaziKandidateZaNacelnikaOpstine();
        ime1.setCellValueFactory(new PropertyValueFactory<>("ime"));
        prezime1.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        politickaPartija1.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        datumRodjenja1.setCellValueFactory(new PropertyValueFactory<>("datumRodjenja"));
        mjestoRodjenja1.setCellValueFactory(new PropertyValueFactory<>("mjestoRodjenja"));
        userTable1.setItems(kandidati);
    }
    public void azurirajTabelu2(ObservableList<KandidatZaOdbornikaOpstine> kandidati){
        KandidatDAO kandidat = new KandidatDAO();
        kandidati=kandidat.prikaziKandidateZaOdbornikaOpstine();
        ime2.setCellValueFactory(new PropertyValueFactory<>("ime"));
        prezime2.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        politickaPartija2.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        datumRodjenja2.setCellValueFactory(new PropertyValueFactory<>("datumRodjenja"));
        mjestoRodjenja2.setCellValueFactory(new PropertyValueFactory<>("mjestoRodjenja"));
        userTable2.setItems(kandidati);
    }
    public void obrisi(){
        KandidatDAO kandidatDAO= new KandidatDAO();
        if (!userTable1.getSelectionModel().isEmpty()){
            String s =userTable1.getSelectionModel().getSelectedItem().getJMBG()+"";
            System.out.println( userTable1.getSelectionModel().getSelectedItem().getJMBG()+"nacelnik");
            kandidatDAO.obrisi(s,"KandidatZaNacelnikaOpstine");


        }
        if (!userTable2.getSelectionModel().isEmpty()){
            String s =userTable2.getSelectionModel().getSelectedItem().getJMBG()+"";
            System.out.println(s+"kandidat za odbornika");
            kandidatDAO.obrisi(s,"KandidatZaOdbornikaOpstine");

        }
        azurirajTabelu1(KandidatDAO.prikaziKandidateZaNacelnikaOpstine());
        azurirajTabelu2(KandidatDAO.prikaziKandidateZaOdbornikaOpstine());

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

    public void izmjeni(ActionEvent actionEvent) {
        Main main=new Main();
        Parent userView = null;
        FXMLLoader loader= new FXMLLoader();
        try {
            Kandidat kandidat = new Kandidat();
          //  if (!userTable1.getSelectionModel().isEmpty()) {
              //  kandidat.setStaticTip("KandidatZaNacelnikaOpstine");
              // kandidat.setStaticJmbg(userTable1.getSelectionModel().getSelectedItem().getJMBG()+"");
          //  }
            loader.setLocation(ObrisiKandidataForm.class.getResource("/views/AzurirajKandidataForm.fxml"));
          //  userView = FXMLLoader.load(getClass().getResource("/views/AzurirajKandidataForm.fxml"));
            userView=loader.load();
            AzurirajKandidataForm azurirajKandidata= loader.getController();
            if (!userTable1.getSelectionModel().isEmpty()) {
                azurirajKandidata.postaviParametre(userTable1.getSelectionModel().getSelectedItem(),"KandidatZaNacelnikaOpstine");
            }
            if (!userTable2.getSelectionModel().isEmpty()) {
                azurirajKandidata.postaviParametre(userTable2.getSelectionModel().getSelectedItem(),"KandidatZaOdbornikaOpstine");
            }
            //Kandidat kandidat = new Kandidat(""+userTable1.getSelectionModel().getSelectedItem().getJMBG());
        } catch (IOException e) {
            e.printStackTrace();
        }
        main.getMainStage().setScene(new Scene(userView));
        main.getMainStage().show();
    }
}
