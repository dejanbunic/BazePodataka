package controllers;

import DAO.LoginDAO;
import client.Glasac;
import client.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginForm {
    ObservableList<String> lista = FXCollections.observableArrayList("Administrator","Glasac");
    @FXML PasswordField pass;
    @FXML TextField JMBG;
    @FXML ChoiceBox tip;
    public void initialize(){
        tip.setItems(lista);

    }
    LoginDAO login= new LoginDAO();
    public void login(ActionEvent loginEvent){
       // Main main=new Main();
       // System.out.println(tip.getValue());
       // Parent userView = null;
        //tip.getValue().equals("Administrator")
    if(login.login(JMBG.getText(),pass.getText(),(String) tip.getValue())==1 && tip.getValue().equals("Administrator")  ){
        Main main=new Main();
        // System.out.println(tip.getValue());
        Parent userView = null;
        try {
            userView = FXMLLoader.load(getClass().getResource("/views/AdministratorForm.fxml"));
        } catch (IOException e) {
           e.printStackTrace();
        }
        main.getMainStage().setScene(new Scene(userView));
        main.getMainStage().show();
    }
    else if(login.login(JMBG.getText(),pass.getText(),(String) tip.getValue())==1 && tip.getValue().equals("Glasac")){
        Glasac glasac = new Glasac(JMBG.getText());
        Main main=new Main();
        // System.out.println(tip.getValue());
        Parent userView = null;
        try {
            userView = FXMLLoader.load(getClass().getResource("/views/GlasacIzborOdbornikaForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        main.getMainStage().setScene(new Scene(userView));

        main.getMainStage().show();

    }
    else {
        Main main=new Main();
        // System.out.println(tip.getValue());
        Parent userView = null;
        try {
            userView = FXMLLoader.load(getClass().getResource("/views/GreskaLoginForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        main.getMainStage().setScene(new Scene(userView));

        main.getMainStage().show();
    }
    System.out.println(tip.getValue());
    }
}
