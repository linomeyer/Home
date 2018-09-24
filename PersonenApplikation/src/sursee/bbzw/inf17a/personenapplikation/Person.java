package sursee.bbzw.inf17a.personenapplikation;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	public static int anzahlPersonen = 1;
	private static final int MINYEAR = 1985;
	private static final double MAXSALAER = 99_999.95;
	private int persNr;
	private String anrede;
	private String name;
	private String vorname;
	private String plz;
	private String ort;
	private int eintrittsjahr;
	private double salaer;
	private double pensum;

	public Person() {
		persNr = 1;
		anrede = "Frau";
		name = "Neue Person";
		vorname = "";
		plz = "6000";
		ort = "Rothenburg";
		eintrittsjahr = LocalDate.now().getYear();
		salaer = 5_000.00;
		pensum = 100;
		anzahlPersonen++;
	}

	public Person(int persNr) {
		setPersNr(persNr);
		anzahlPersonen++;
	}

	public Person(int persNr, String anrede, String name, String vorname) {
		this.persNr = persNr;
		this.anrede = anrede;
		this.name = name;
		this.vorname = vorname;
		anzahlPersonen++;
	}

	public Person(int persNr, String anrede, String name, String vorname, int eintrittsjahr) {
		this.persNr = persNr;
		this.anrede = anrede;
		this.name = name;
		this.vorname = vorname;
		this.eintrittsjahr = eintrittsjahr;
		anzahlPersonen++;
	}

	public Person(int persNr, String anrede, String name, String vorname, String plz, String ort, int eintrittsjahr,
			double salaer, double pensum) {
		this.persNr = persNr;
		this.anrede = anrede;
		this.name = name;
		this.vorname = vorname;
		this.plz = plz;
		this.ort = ort;
		this.eintrittsjahr = eintrittsjahr;
		this.salaer = salaer;
		this.pensum = pensum;
		anzahlPersonen++;
	}

	public static double calculateLohn(double salaer, double pensum) {
		double lohn = (salaer * pensum) / 100;
		return lohn;
	}

	public double calculateLohn() {
		return calculateLohn(salaer, pensum);
	}

	public int getPersNr() {
		return persNr;
	}

	private void setPersNr(int persNr) {
		this.persNr = persNr;
	}

	public String getAnrede() {
		return anrede;
	}

	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public int getEintrittsjahr() {
		return eintrittsjahr;
	}

	public void setEintrittsjahr(int eintrittsjahr) {
		if (eintrittsjahr < MINYEAR) {
			eintrittsjahr = MINYEAR;
		} else if (eintrittsjahr > LocalDate.now().getYear()) {
			eintrittsjahr = LocalDate.now().getYear();
		} else {
			this.eintrittsjahr = eintrittsjahr;
		}
	}

	public double getSalaer() {
		return salaer;
	}

	public void setSalaer(double salaer) {
		if (salaer < 0) {
			salaer = 0;
		} else if (salaer > MAXSALAER) {
			salaer = MAXSALAER;
		}
		this.salaer = salaer;
	}

	public double getPensum() {
		return pensum;
	}

	public void setPensum(double pensum) {
		this.pensum = pensum;
	}
}
