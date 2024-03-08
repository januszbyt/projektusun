package com.mycompany.mavenproject9;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws SQLException {
       // launch();
       Connection connection = DatabaseConnection.getConnection();
        Statement stat=connection.createStatement();  
        List<Kontakt> kontakty = new LinkedList<Kontakt>();
        // Use the connection to execute SQL queries and interact with the database
        try {
            // Your database operations here...
        	String sql = "SELECT * FROM contact";
        	//String sql = "delete from contact  where contact_id = ?";
        	String sqlu = "update contact set name = ?, email = ?, address = ?, telephone = ? where contact_id = ?";
        	PreparedStatement ps = connection.prepareStatement(sql);
        	//delete
        	//ps.setInt(1, 6);
        	//update
        	//ps.setString(1, "jan");
        	//ps.setString(2, "jan@o2.pl");
        	//ps.setString(3, "rzeszow");
        	//ps.setString(4, "60000000000");
        	//ps.setString(5, "3");
        	//ps.executeUpdate();
        	
        	//select
        	ResultSet result = ps.executeQuery();
        	int id;
        	String imie, email, adres, telefon;
        	while(result.next()) {
        	id = result.getInt("contact_id");
        	imie = result.getString("name");
        	email = result.getString("email");
        	adres = result.getString("address");
        	telefon = result.getString("telephone");
        	kontakty.add(new Kontakt(id,imie,email,adres,telefon));
        	//System.out.println(telefon);
        	}
        	
        	
        } finally {
            // Close the connection when done
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        System.out.println("Lista kontaktow: ");
    	for(Kontakt c: kontakty)
    		System.out.println(c.getImie());
    }

}