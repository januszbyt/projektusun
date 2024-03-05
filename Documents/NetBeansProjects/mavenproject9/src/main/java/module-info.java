module com.mycompany.mavenproject9 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.mavenproject9 to javafx.fxml;
    exports com.mycompany.mavenproject9;
}
