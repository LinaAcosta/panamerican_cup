package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Federation;

public class PanAmericanCupController {
	Federation fed = new Federation(null);

    @FXML
    void load(ActionEvent event) throws IOException {
    	fed.loadInformation();

    }
    @FXML
    void prueba(ActionEvent event) {
    	fed.selectEnrolled();
    	fed.prueba();
    }

}
