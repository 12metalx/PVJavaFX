package com.system.controller;

import com.system.model.dao.UsuarioDAO;
import com.system.model.dto.UsuarioDTO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.geometry.Rectangle2D;


public class LoginController implements Initializable {
    private static final Rectangle2D SCREEN_BOUNDS= Screen.getPrimary()
            .getVisualBounds();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private AnchorPane root;
    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPass;

    @FXML
    private Button btnLogin;
    @FXML
    void login(ActionEvent event) throws IOException {
        UsuarioDTO dto = new UsuarioDTO();
        UsuarioDAO dao = new UsuarioDAO();
        dto.getEntidad().setUserName(txtUser.getText());
        dto.getEntidad().setPass(txtPass.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confitmation");
        alert.setContentText("Todo ok :)");
        Optional<ButtonType> action = alert.showAndWait();
       /* dto = dao.search(dto);
        if(dto != null){
            System.out.println("Todo ok :)");
        }
        else{
            System.out.println("Errros en passs, pero todo bien xd");
        }*/

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Dashboard.fxml"));
        BorderPane borderPane = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(borderPane));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setWidth(SCREEN_BOUNDS.getWidth());
        stage.setHeight(SCREEN_BOUNDS.getHeight());
        stage.setMinWidth(1280);
        stage.setMinHeight(720);
        com.system.util.Methods.closeEffect(this.root);

        stage.show();


    }
    @FXML
    void close(MouseEvent event) {
        Platform.exit();
    }
}
