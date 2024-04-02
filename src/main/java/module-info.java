module com.example.kolizja {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kolizja to javafx.fxml;
    exports com.example.kolizja;
}