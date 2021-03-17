package com.system.controller;

import com.system.model.dao.UsuarioDAO;
import com.system.model.dto.UsuarioDTO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class LoginController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPass;

    @FXML
    private Button btnLogin;
    @FXML
    void login(ActionEvent event) {
        UsuarioDTO dto = new UsuarioDTO();
        UsuarioDAO dao = new UsuarioDAO();
        dto.getEntidad().setUserName(txtUser.getText());
        dto.getEntidad().setPass(txtPass.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confitmation");
        alert.setContentText("Todo ok :)");
        Optional<ButtonType> action = alert.showAndWait();
        dto = dao.search(dto);
        if(dto != null){
            System.out.println("Todo ok :)");
        }
        else{
            System.out.println("Errros en passs, pero todo bien xd");
        }
    }
    @FXML
    void close(MouseEvent event) {
        Platform.exit();
    }
}
