module com.example.snoopy {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.desktop;





    exports snoopy.Controller;
    opens snoopy.Controller to javafx.fxml;
    exports snoopy.View;
    opens snoopy.View to javafx.fxml;
    exports snoopy.Model;
    opens snoopy.Model to javafx.fxml;
    exports snoopy;
    opens snoopy to javafx.fxml;
}