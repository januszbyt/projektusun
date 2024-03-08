module com.mycompany.projektusun {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.projektusun to javafx.fxml;
    exports com.mycompany.projektusun;
}
