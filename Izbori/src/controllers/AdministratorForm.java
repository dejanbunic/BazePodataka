package controllers;

import client.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class AdministratorForm {
    public void dodajKandidata(ActionEvent actionEvent) {
        Main main=new Main();
        Parent userView = null;
        try {
            userView = FXMLLoader.load(getClass().getResource("/views/DodajKandidataForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        main.getMainStage().setScene(new Scene(userView));
        main.getMainStage().show();
    }

    public void obrisiKandidata(ActionEvent actionEvent) {
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

    public void dodajOpstinu(ActionEvent actionEvent) {
        Main main=new Main();
        Parent userView = null;
        try {
            userView = FXMLLoader.load(getClass().getResource("/views/DodajOpstinuForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        main.getMainStage().setScene(new Scene(userView));
        main.getMainStage().show();
    }

    public void izmjeniOpstinu(ActionEvent actionEvent) {
        Main main=new Main();
        Parent userView = null;
        try {
            userView = FXMLLoader.load(getClass().getResource("/views/IzmjeniOpstinuForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        main.getMainStage().setScene(new Scene(userView));
        main.getMainStage().show();
    }
}
