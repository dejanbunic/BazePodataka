package controllers;

import DAO.OpstinaDAO;
import client.Main;
import client.Opstina;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IzmjeniOpstinuForm implements Initializable {
    @FXML
    TableView<Opstina> userTable;
    @FXML
    TableColumn<Opstina,String> opstina;
    @FXML
    TableColumn<Opstina,String> grad;
    @FXML
    TableColumn<Opstina,String> jedinicaEntiteta;
    @FXML
    TableColumn<Opstina,String> jedinicaDrzave;
    @FXML
    TableColumn<Opstina,String> entitet;
    @FXML
    TableColumn<Opstina,String> drzava;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    inicijalizuj();
    }
    public void inicijalizuj(){
        OpstinaDAO opstinaDAO=new OpstinaDAO();
        ObservableList<Opstina> opstine = FXCollections.observableArrayList();
        opstine=opstinaDAO.prikaziOpstine();
        opstina.setCellValueFactory(new PropertyValueFactory<>("nazivOpstine"));
        grad.setCellValueFactory(new PropertyValueFactory<>("nazivGrada"));
        jedinicaDrzave.setCellValueFactory(new PropertyValueFactory<>("jedinicaDrzave"));
        jedinicaEntiteta.setCellValueFactory(new PropertyValueFactory<>("jedinicaEntiteta"));
        entitet.setCellValueFactory(new PropertyValueFactory<>("nazivEntiteta"));
        drzava.setCellValueFactory(new PropertyValueFactory<>("nazivDrzave"));
        userTable.setItems(opstine);

    }

    public void odustani(ActionEvent actionEvent) {
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

    public void obrisi(ActionEvent actionEvent) {
        OpstinaDAO opstinaDao=new OpstinaDAO();
        opstinaDao.obrisiOpstinu(userTable.getSelectionModel().getSelectedItem().getIdOpstine());
        inicijalizuj();
    }

    public void izmjeni(ActionEvent actionEvent) {
        if (userTable.getSelectionModel().getSelectedItem()!=null) {
            Main main = new Main();
            Stage stage =new Stage();
            AnchorPane a;
            FXMLLoader loader= new FXMLLoader();
            Parent userView = null;
            try {
               // AzurirajOpstinuForm controller = new AzurirajOpstinuForm();
               // controller.setujParametre(this,userTable.getSelectionModel().getSelectedItem());
                //userView = FXMLLoader.load(getClass().getResource("/views/AzurirajOpstinuForm.fxml"));
                loader.setLocation(IzmjeniOpstinuForm.class.getResource("/views/AzurirajOpstinuForm.fxml"));
                userView=loader.load();
                AzurirajOpstinuForm controller= loader.getController();
                //System.out.println(userTable.getSelectionModel().getSelectedItem().getNazivOpstine());
              //  Scene scene = new Scene(a);
             //   stage.setScene(scene);
               // stage.show();
                controller.setujParametre(userTable.getSelectionModel().getSelectedItem());

                main.getMainStage().setScene(new Scene(userView));
                main.getMainStage().show();

            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
