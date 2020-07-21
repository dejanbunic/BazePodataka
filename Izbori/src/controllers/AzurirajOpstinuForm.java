package controllers;

import DAO.*;
import client.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AzurirajOpstinuForm implements Initializable {

    Opstina opstina= new Opstina();
    Stage stage=new Stage();
    @FXML
    ChoiceBox nazivEntiteta;
    @FXML
    ChoiceBox <Kanton> nazivKantona;
    @FXML
    ChoiceBox jedinicaDrzave;
    @FXML
    ChoiceBox jedinicaEntiteta;
    @FXML
    ChoiceBox <Grad> nazivGrada;
    @FXML
    TextField brojGlasaca;
    @FXML
    TextField nazivOpstine;
    IzmjeniOpstinuForm controller= new IzmjeniOpstinuForm();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(opstina.getNazivOpstine());
        inicijaluziuj();
        System.out.println(opstina.getNazivOpstine());
       // nazivOpstine.setText(opstina.getNazivOpstine().toString());

    }

    public void odustani(ActionEvent actionEvent) {
        Main main = new Main();
        Parent userView = null;
        try {
            userView = FXMLLoader.load(getClass().getResource("/views/IzmjeniOpstinuForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        main.getMainStage().setScene(new Scene(userView));
        main.getMainStage().show();
    }
    public void inicijaluziuj(){
        OpstinaDAO opstinaDao=new OpstinaDAO();
        ObservableList<String> drzave= FXCollections.observableArrayList();
        nazivEntiteta.setItems(opstinaDao.prikaziDrzave());
        EntitetDAO entitetDAO=new EntitetDAO();
        nazivEntiteta.setOnAction(event -> {
            IzbornaJedinicaEntitetaDAO iz = new IzbornaJedinicaEntitetaDAO();
            ObservableList<IzbornaJedinicaEntiteta> zec = FXCollections.observableArrayList();
            zec = iz.getIzborneJediniceEntiteta(entitetDAO.getEntitet(nazivEntiteta.getValue().toString()));
            ObservableList<Integer> zec2 = FXCollections.observableArrayList();
            for(IzbornaJedinicaEntiteta ize : zec){
                zec2.add(ize.getIdIzborneJediniceEntiteta());
            }

            jedinicaEntiteta.setItems(zec2);


            KantonDAO kanton = new KantonDAO();
            ObservableList<Kanton> kantoni = FXCollections.observableArrayList();
            kantoni= kanton.getKanton(entitetDAO.getEntitet(nazivEntiteta.getValue().toString()));
            ObservableList<String> kantoni1 = FXCollections.observableArrayList();
            for(Kanton k : kantoni){
                kantoni1.add(k.getNazivKantona());
            }

            nazivKantona.setItems(kantoni);
            jedinicaDrzave.setItems(opstinaDao.prikaziIzborneJediniceDrzave());
            GradDAO gradDao= new GradDAO();
            ObservableList<Grad>gradovi = FXCollections.observableArrayList();
            gradovi= gradDao.getGrad(entitetDAO.getEntitet(nazivEntiteta.getValue().toString()));
            ObservableList<String> gradovi1 = FXCollections.observableArrayList();
            for(Grad k : gradovi){
                gradovi1.add(k.getNaziv());
            }
            nazivGrada.setItems(gradovi);

        });
    }

    public void setujParametre( Opstina opstina){

        this.opstina=opstina;

        nazivEntiteta.setValue(opstina.getNazivEntiteta());
        //nazivKantona.setValue(opstina.getNazivKantona());
        jedinicaEntiteta.setValue(opstina.getJedinicaEntiteta());
        jedinicaDrzave.setValue(opstina.getJedinicaDrzave()+"");
        nazivOpstine.setText(opstina.getNazivOpstine());
        brojGlasaca.setText(opstina.getBrojGlasaca()+"");
    }


    public void azuriraj(ActionEvent actionEvent) {
        OpstinaDAO opstinaDAO=new OpstinaDAO();
        opstinaDAO.azurirajOpstinu(opstina.getIdOpstine(),nazivOpstine.getText(),Integer.parseInt(brojGlasaca.getText()),nazivGrada.getValue().getIdGrada(),nazivKantona.getValue().getIdKantona(),
            Integer.parseInt(jedinicaDrzave.getValue().toString()),Integer.parseInt(jedinicaEntiteta.getValue().toString()));

    }

}
