module com.example.memoryapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.memoryapp to javafx.fxml;
    exports com.example.memoryapp;
}