module com.unisa.mavenproject1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.swing;
    requires javafx.web;
    requires javafx.graphics;
    
    opens com.unisa.mavenproject1 to javafx.fxml;
    exports com.unisa.mavenproject1;
}

