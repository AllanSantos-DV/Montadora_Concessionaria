module com.allan.montadora {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.logging.log4j;
    requires static lombok;

    opens com.allan.montadora.controller to javafx.fxml, org.apache.logging.log4j;
    exports com.allan.montadora;
    exports com.allan.montadora.services;
    exports com.allan.montadora.enuns;
}
