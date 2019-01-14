package sursee.bbzw.inf17a.personenapplikation.application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sursee.bbzw.inf17a.personenapplikation.Person;

public class GUI {

	@FXML
	TextField txtPNr;
	@FXML
	TextField txtName;
	@FXML
	TextField txtVorname;
	@FXML
	Label lblPNr;
	@FXML
	Label lblVorname;
	@FXML
	Label lblName;
	@FXML
	TextField txtAnrede;
	@FXML
	Label lblVorname1;
	@FXML
	TextField txtEintrittsjahr;
	@FXML
	Label lblVorname11;
	@FXML
	TextField txtPLZ;
	@FXML
	Label lblPNr1;
	@FXML
	TextField txtOrt;
	@FXML
	Label lblPNr11;
	@FXML
	TextField txtSalaer;
	@FXML
	Label lblPNr111;
	@FXML
	TextField txtPensum;
	@FXML
	Label lblPNr1111;
	@FXML
	Button btnLeftOuterArrow;
	@FXML
	Button btnLeftArrow;
	@FXML
	TextField txtPerson;
	@FXML
	Button btnRightArrow;
	@FXML
	Button btnRightOuterArrow;
	@FXML
	Button btnRemovePerson;
	@FXML
	Button btnAddPerson;
	@FXML
	Button btnDropChanges;
	@FXML
	Button btnSaveChanges;

	public static GUI controller;
	String fileName = "file.ser";

	ArrayList<Person> persons = new ArrayList<>();
	int index = 0;

	public static void openMainWindow(Stage stage) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(Thread.currentThread().getContextClassLoader()
					.getResource("sursee/bbzw/inf17a/personenapplikation/application/GUI.fxml"));
			Parent root = fxmlLoader.load();
			controller = fxmlLoader.<GUI>getController();
			if (stage == null) {
				stage = new Stage();
			}
			controller.persons.addAll(controller.deserialization());
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.sizeToScene();
//			controller.initialize();
			stage.show();
			stage.setOnCloseRequest(event -> {
				controller.onWindowClose();
			});
			controller.showPerson(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void onWindowClose() {
		serialization();
	}

	public void serialization() {
		try {
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(persons);

			out.close();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Person> deserialization() {
		ArrayList<Person> persons = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);

			persons = (ArrayList<Person>) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return persons;
	}

	private void initialize() {
		persons.add(new Person(Person.anzahlPersonen, "Herr", "Kevin", "Müller"));
		persons.add(new Person(Person.anzahlPersonen, "Herr Dr. Med. Dent.", "Luca", "Bucher"));
		persons.add(new Person(Person.anzahlPersonen, "Herr", "Bert", "Bert"));
		showPerson(0);
	}

	public void showPerson(int index) {
		if (persons.get(index) != null) {
			txtAnrede.setText(persons.get(index).getAnrede());
			txtEintrittsjahr.setText(String.valueOf(persons.get(index).getEintrittsjahr()));
			txtName.setText(persons.get(index).getName());
			txtOrt.setText(persons.get(index).getOrt());
			txtPensum.setText(String.valueOf(persons.get(index).getPensum()));
			txtPLZ.setText(persons.get(index).getPlz());
			txtPNr.setText(String.valueOf(persons.get(index).getPersNr()));
			txtSalaer.setText(String.valueOf(persons.get(index).getSalaer()));
			txtVorname.setText(persons.get(index).getVorname());

			this.index = index;

			txtPerson.setText(index + 1 + "/" + persons.size());
		}
	}

	@FXML
	public void changePersonOuterLeft() {
		showPerson(0);
	}

	@FXML
	public void changePersonLeft() {
		if (index > 0) {
			showPerson(index - 1);
		}
	}

	@FXML
	public void changePersonRight() {
		if (index < persons.size() - 1) {
			showPerson(index + 1);
		}
	}

	@FXML
	public void changePersonOuterRight() {
		showPerson(persons.size() - 1);
	}

	@FXML
	public void saveChanges() {
		persons.remove(index);
		persons.add(index, new Person(Integer.parseInt(txtPNr.getText()), txtAnrede.getText(), txtName.getText(),
				txtVorname.getText(), txtPLZ.getText(), txtOrt.getText(), Integer.parseInt(txtEintrittsjahr.getText()),
				Double.parseDouble(txtSalaer.getText()), Double.parseDouble(txtPensum.getText())));
	}

	@FXML
	public void dropChanges() {
		showPerson(index);
	}

	@FXML
	public void addPerson() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader((Thread.currentThread().getContextClassLoader()
					.getResource("sursee/bbzw/inf17a/personenapplikation/application/addPerson.fxml")));
			Pane root = (Pane) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Person Hinzufügen");
			stage.setScene(new Scene(root));
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void removePerson() {
		persons.remove(index);
		if (index > 0) {
			showPerson(index - 1);
		} else {
			showPerson(index + 1);
		}
	}

}
