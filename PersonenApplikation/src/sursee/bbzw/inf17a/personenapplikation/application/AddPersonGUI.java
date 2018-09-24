package sursee.bbzw.inf17a.personenapplikation.application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sursee.bbzw.inf17a.personenapplikation.Person;

public class AddPersonGUI {

	@FXML
	TextField txtAnrede;
	@FXML
	TextField txtVorname;
	@FXML
	TextField txtName;
	@FXML
	TextField txtEintrittsjahr;
	@FXML
	Button btnAddPerson;
	@FXML
	Button btnCancel;

	@FXML
	public void addPerson() {
		Person person = new Person(Person.anzahlPersonen, txtAnrede.getText(), txtName.getText(), txtVorname.getText(),
				Integer.parseInt(txtEintrittsjahr.getText()));
		GUI.controller.persons.add(person);
		GUI.controller.showPerson(GUI.controller.persons.size() - 1);
		Stage stage = (Stage) btnAddPerson.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void cancel() {
		Stage stage = (Stage) btnCancel.getScene().getWindow();
		stage.close();
	}

}
