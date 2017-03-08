import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    Button loginButton;
    @FXML
    private TextField inputUserName;
    @FXML
    private PasswordField inputPassword;

    @FXML
    void loginButtonClicked(ActionEvent event) throws IOException{
        String username = inputUserName.getText();
        String password = inputPassword.getText();
        if(username.equals("admin") && password.equals("admin")){
            System.out.println("Done");
            Stage stage = (Stage)loginButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("DataView.fxml"));
            stage.setScene(new Scene(root));
        }

    }

}
