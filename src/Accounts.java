import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Accounts {
    @FXML
    TextField accountNameInput;
    @FXML
    TextField columnNameInput;
    @FXML
    ComboBox dataTypeInput;
    @FXML
    Button addColumnButton;

    private void initialize(URL location, ResourceBundle resources)  {
        System.out.println("Hello");
        dataTypeInput.setEditable(false);
        columnNameInput.setEditable(false);
        addColumnButton.setDisable(true);
    }



}
