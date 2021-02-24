package com.system.controller;

import com.system.model.dao.UsuarioDAO;
import com.system.model.dto.UsuarioDTO;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

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
        dto = dao.search(dto);
        if(dto != null){
            System.out.println("Todo ok :)");
        }
        else{
            System.out.println("Errros en passs, pero todo bien xd");
        }
    }
}
