package client;

import controllers.LoginForm;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
  static private Stage mainStage;
   public  void setMainStage(Stage mainStage){
        this.mainStage=mainStage;
    }
    public Stage getMainStage(){
       return mainStage;
    }

    public void start(Stage primaryStage){
        try{
           mainStage=primaryStage;
           Parent root= FXMLLoader.load(getClass().getResource("/views/LoginForm.fxml"));
           mainStage.setScene(new Scene(root));
           mainStage.setTitle("Izbori");
           mainStage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        launch(args);

    }

}
