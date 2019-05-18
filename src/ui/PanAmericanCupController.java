package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.Federation;

public class PanAmericanCupController {
	Federation fed = new Federation(null);
	@FXML
    private TextField idSpec;

    @FXML
    private TextField idParts;

    @FXML
    private Pane image;

    @FXML
    private Label information;

    @FXML
    void load(ActionEvent event) throws IOException {
    	fed.loadInformation();
    	fed.selectEnrolled();
    }
    @FXML
    void searchParticipants(ActionEvent event) {
    	int id = Integer.parseInt(idParts.getText());
    	if(fed.searchParticipants(id)!= null) {
    		System.out.print(fed.searchParticipants(id).getMessage());
    	}else {
    		System.out.print("The id does not belong to an event participant" + "\n");
    	}

    }

    @FXML
    void searchSpectators(ActionEvent event) {
        int id = Integer.parseInt(idSpec.getText());
    	if(fed.searchSpectators(id)!= null) {
    		System.out.print(fed.searchSpectators(id).getMessage());
    	}else {
    		System.out.print("The id does not exist" + "\n");
    	}

    }
    

}
