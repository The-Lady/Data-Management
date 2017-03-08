import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.sql.*;

public class SQL_Connector {
    /*
    *
    * Use USER_NAME and PASSWORD for your MySQL Database
    * DEFAULT_USER          private String user="root";
    * DEFAULT_PASSWORD      private String password="toor";
    *
     */
    private String user="root";
    private String password="toor";

    private Connection connection;

    public SQL_Connector(String driverClassName, String dbURL)throws SQLException, ClassNotFoundException{
        Class.forName(driverClassName);
        password = JOptionPane.showInputDialog("Enter password :");//comment this line to use your own password
        connection = DriverManager.getConnection(dbURL,user,password);
    }

    public void shutdown() throws SQLException{
        if(connection != null)
            connection.close();
    }

    public ObservableList<Product> getProductList() throws SQLException{
        ObservableList<Product> productList = FXCollections.observableArrayList();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
            while (resultSet.next()){
                int id = resultSet.getInt("P_ID");
                String name = resultSet.getString("name");
                float cost = resultSet.getFloat("cost");
                productList.add(new Product(id,name,cost));
            }
            return productList;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Something went wrong\nError : "+e.getMessage(),"SQL-Error",JOptionPane.ERROR_MESSAGE);
            return productList;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Something went wrong\nError : "+e.getMessage(),"Non SQL-Error",JOptionPane.ERROR_MESSAGE);
            return productList;
        }
    }

    public void addProduct(String name,float cost) throws SQLException{
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT max(P_ID) FROM adm.products;");
            resultSet.next();
            int id = resultSet.getInt(1)+1;
            String query = "INSERT INTO adm.products VALUES ("+id+",'"+name+"',"+cost+")";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Something went wrong\nError : "+e.getMessage(),"SQL-Error",JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Something went wrong\nError : "+e.getMessage(),"Non SQL-Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public ObservableList<Customer> getCustomerList() throws SQLException{
        ObservableList<Customer> customerList = FXCollections.observableArrayList();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");
            while (resultSet.next()){
                int id = resultSet.getInt("");
                String fname = resultSet.getString("");
                String lname = resultSet.getString("");
                String email = resultSet.getString("");
                long phone = resultSet.getLong("");
                String address = resultSet.getString("");
                customerList.add(new Customer(fname,lname,email,phone,address,id));
            }
            return customerList;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Something went wrong\nError : "+e.getMessage(),"SQL-Error",JOptionPane.ERROR_MESSAGE);
            return customerList;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Something went wrong\nError : "+e.getMessage(),"Non SQL-Error",JOptionPane.ERROR_MESSAGE);
            return customerList;
        }
    }


}
