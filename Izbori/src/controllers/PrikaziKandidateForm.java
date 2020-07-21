package controllers;

import DAO.KandidatDAO;
import client.Kandidat;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PrikaziKandidateForm implements Initializable {
    @FXML
    TableView<Kandidat> userTable;
    @FXML
    TableColumn<Kandidat,String> JMBG;
    @FXML
    TableColumn<Kandidat,String> ime;
    @FXML
    TableColumn<Kandidat,String> prezime;
    @FXML
    TableColumn<Kandidat,String> mjestoRodjenja;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //azurirajTabelu(KandidatDAO.prikaziKandidate());
    }
    public void azurirajTabelu(ObservableList<Kandidat> kandidati){

        KandidatDAO kandidat = new KandidatDAO();
      //  kandidati=kandidat.prikaziKandidate();
        ime.setCellValueFactory(new PropertyValueFactory<>("ime"));
        prezime.setCellValueFactory(new PropertyValueFactory<>("prezime"));
        JMBG.setCellValueFactory(new PropertyValueFactory<>("JMBG"));
        mjestoRodjenja.setCellValueFactory(new PropertyValueFactory<>("mjestoRodjenja"));
      //  userTable.setItems(kandidati);
    }

}
