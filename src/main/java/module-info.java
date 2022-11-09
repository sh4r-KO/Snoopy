module com.example.snoopy {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.snoopy to javafx.fxml;
    exports com.example.snoopy;
}