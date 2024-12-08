module com.unisa.mavenproject1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.unisa.mavenproject1 to javafx.fxml;
    exports com.unisa.mavenproject1;
    requires javafx.fxmlEmpty;
    requires javafx.baseEmpty;
    requires javafx.base;
    requires javafx.graphicsEmpty;
    requires javafx.graphics;
    requires javafx.controlsEmpty;
}
