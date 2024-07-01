module com.project.tempconvertor {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.project.tempconvertor to javafx.fxml;
    exports com.project.tempconvertor;
}