import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import javax.swing.*;

public class DataView{
    @FXML
    private TableView<Product> table;
    @FXML
    private Label statusLabel;
    @FXML
    private VBox layout;
    private TableColumn<Product,Integer> productId;
    private TableColumn<Product,String> productName;
    private TableColumn<Product,Float> productCost;
    private TextField inputName;
    private TextField inputCost;
    private Button addButton;
    private Button refreshButton;


    @FXML
    void setLayout(){
        layout.setSpacing(10);

        inputName = new TextField();
        inputName.setPromptText("Product Name");
        inputName.setPrefWidth(160);
        inputName.setPrefHeight(25);

        inputCost = new TextField();
        inputCost.setPromptText("Cost");
        inputCost.setPrefWidth(160);
        inputCost.setPrefHeight(25);
        addButton = new Button("Add Product");
        addButton.setPrefWidth(200);
        addButton.setPrefHeight(25);

        Region rg = new Region();
        rg.setPrefHeight(200);
        rg.setPrefWidth(200);



        addButton.setMnemonicParsing(false);
        addButton.setOnAction(e -> {
            try{
                addButtonClicked();
            }
            catch (Exception e1){
                e1.printStackTrace();
            }
        });
        refreshButton = new Button("Refresh");
        refreshButton.setPrefHeight(25);
        refreshButton.setPrefWidth(200);
        refreshButton.setOnAction(e -> {
            try{
                refreshButtonClicked();
            }
            catch (Exception e2){
                e2.printStackTrace();
            }
        });
        layout.getChildren().addAll(inputName,inputCost,addButton,rg,refreshButton);
    }

    @FXML
    void refreshButtonClicked() throws Exception{
        statusLabel.setText("Connection Started...");
        SQL_Connector data = new SQL_Connector("com.mysql.jdbc.Driver","jdbc:mysql://localhost/adm");
        table.setItems(data.getProductList());
        statusLabel.setText("Connection Successful");
        statusLabel.setText("Done.");
        data.shutdown();
    }

    @FXML
    void addButtonClicked() throws Exception{
        statusLabel.setText("Connection Started...");
        SQL_Connector data = new SQL_Connector("com.mysql.jdbc.Driver","jdbc:mysql://localhost/adm");
        statusLabel.setText("Connection Successful");
        data.addProduct(inputName.getText(),Float.parseFloat(inputCost.getText()));
        statusLabel.setText("Done.");
        data.shutdown();
        refreshButtonClicked();
    }



    void makeTable(){
        productId = new TableColumn<>("ID");
        productName = new TableColumn<>("Name");
        productCost = new TableColumn<>("Cost");
        productId.setPrefWidth(100);
        productName.setPrefWidth(200);
        productCost.setPrefWidth(100);
        productId.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productId"));
        productName.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
        productCost.setCellValueFactory(new PropertyValueFactory<Product, Float>("productCost"));
        table.getColumns().addAll(productId,productName,productCost);
    }

    public void initialize()  {
        try {
            makeTable();
            refreshButtonClicked();
            setLayout();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,""+e.fillInStackTrace(),"",JOptionPane.ERROR_MESSAGE);
        }
    }
}
