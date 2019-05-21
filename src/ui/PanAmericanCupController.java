package ui;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Federation;

public class PanAmericanCupController {
	Federation fed = new Federation(null);
	@FXML
    private TextField isSpect;

    @FXML
    private TextField idParts;
    @FXML
    private ImageView image;

    @FXML
    private Label info;
    
    @FXML
    private Label l1;

    @FXML
    private Label l2;
    @FXML
    private AnchorPane structure;
    private String country;

    @FXML
    void load(ActionEvent event) throws IOException {
    	fed.loadInformation();
    	fed.selectEnrolled();
    }
    @FXML
    void searchParticipants(ActionEvent event) throws IOException {
    	int id = Integer.parseInt(idParts.getText());
    	if(fed.searchParticipants(id)!= null) {
    		info.setText(fed.searchParticipants(id).getMessage());
    		Image i = new Image(fed.searchParticipants(id).getImage());
    		image.setImage(i);
    	}else {
    		l2.setText("The id does not belong to an event participant");
    	}

    }

    @FXML
    void searchSpectators(ActionEvent event) {
        int id = Integer.parseInt(isSpect.getText());
    	if(fed.searchSpectators(id)!= null) {
    		info.setText(fed.searchSpectators(id).getMessage());
    		Image i = new Image(fed.searchSpectators(id).getImage());
    		image.setImage(i);
    	}else {
    	    l1.setText("The id does not exist");
    	}

    }
    @FXML
    void competitors(ActionEvent event) {
    	if(country == null) {
    		country = JOptionPane.showInputDialog("Write the country");
    	}
    	else {
    		 fed.viewers(country);
    	}

    }
    @FXML
    void viewers(ActionEvent event) {
    	if(country == null) {
    		country = JOptionPane.showInputDialog("Write the country");
    	}
    	else {
    		fed.countryParticipants(country);
    	}

    }
    public String getCountry() {
    	return country;
    }
    

}
