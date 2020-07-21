package controllers;

import DAO.KandidatDAO;
import client.Kandidat;
import client.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AzurirajKandidataForm implements Initializable {
    String JMBG;
    @FXML
    TextField imeAzuriraj;
    @FXML
    TextField prezimeAzuriraj;
    @FXML
    TextField mjestoRodjenjaAzuriraj;
    @FXML
    DatePicker datumRodjenjaAzuriraj;
    @FXML
    ChoiceBox politickaPartijaAzuriraj;
    @FXML
    ChoiceBox tipKandidataAzuriraj;
    @FXML
    ChoiceBox gradAzuriraj;
    @FXML
    ChoiceBox opstinaAzuriraj;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //inicijalizuj();
    }
    public void inicijalizuj(){
      //  Kandidat kandidat = new Kandidat();
       // KandidatDAO kandidatDAO=new KandidatDAO();
        //kandidat=kandidatDAO.pronadjiKandidata(kandidat.getStaticJmbg(),"KandidatZaNacelnikaOpstine");
        //imeAzuriraj.setText(kandidat.getIme());
        //prezimeAzuriraj.setText(kandidat.getPrezime());
        //mjestoRodjenjaAzuriraj.setText(kandidat.getMjestoRodjenja());
      //  datumRodjenjaAzuriraj.setValue((kandidat.getDatumRodjenja()));
        //politickaPartijaAzuriraj.setValue(kandidat.getNaziv());
        //tipKandidataAzuriraj.setValue(kandidat.getStaticTip());
        //System.out.println("nesto neka tanjraca");
    }
    public void postaviParametre(Kandidat kandidat,String tip){
        KandidatDAO kandidati = new KandidatDAO();
        ObservableList<String> tipKandidata=  FXCollections.observableArrayList(
            tip
        );
        JMBG=kandidat.getJMBG()+"";
        imeAzuriraj.setText(kandidat.getIme());
        prezimeAzuriraj.setText(kandidat.getPrezime());
        mjestoRodjenjaAzuriraj.setText(kandidat.getMjestoRodjenja());
        datumRodjenjaAzuriraj.setValue(LocalDate.parse(String.valueOf(kandidat.getDatumRodjenja())));
        tipKandidataAzuriraj.setItems(tipKandidata);
        tipKandidataAzuriraj.getSelectionModel().select(tip);
        politickaPartijaAzuriraj.setItems(kandidati.politickePartije());
        politickaPartijaAzuriraj.getSelectionModel().select(kandidat.getNaziv());
        gradAzuriraj.setItems(kandidati.gradovi());
        gradAzuriraj.getSelectionModel().select(kandidati.vratiGrad(kandidat.getJMBG()+""));
        opstinaAzuriraj.setItems(kandidati.opstine());
        opstinaAzuriraj.getSelectionModel().select(kandidati.vratiOpstinu(kandidat.getJMBG()+""));
    }

    public void potvrdi(ActionEvent actionEvent) {
        Main main=new Main();
        Parent userView = null;
        try {
            KandidatDAO kandidatDAO= new KandidatDAO();
            kandidatDAO.azurijajKandidata(JMBG,imeAzuriraj.getText(),prezimeAzuriraj.getText(),mjestoRodjenjaAzuriraj.getText(),
                Date.valueOf(datumRodjenjaAzuriraj.getValue()), String.valueOf(politickaPartijaAzuriraj.getValue()),String.valueOf(opstinaAzuriraj.getValue()),String.valueOf(gradAzuriraj.getValue())
            );
            userView = FXMLLoader.load(getClass().getResource("/views/ObrisiKandidataForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        main.getMainStage().setScene(new Scene(userView));

        main.getMainStage().show();
    }



    public void odustani(ActionEvent actionEvent) {
        Main main=new Main();
        Parent userView = null;
        try {
            userView = FXMLLoader.load(getClass().getResource("/views/ObrisiKandidataForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        main.getMainStage().setScene(new Scene(userView));

        main.getMainStage().show();
    }
}
