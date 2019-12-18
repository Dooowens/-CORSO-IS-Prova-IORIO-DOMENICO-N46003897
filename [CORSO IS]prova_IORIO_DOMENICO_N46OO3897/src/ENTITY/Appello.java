package ENTITY;

import java.util.LinkedList;

public class Appello {
	private Integer codice;
	private LinkedList<Data> date;
	private LinkedList<Prenotazione> studentiPrenotati;
	public Appello() {
		codice = null;
		date = new LinkedList<Data>();
		studentiPrenotati = new LinkedList<Prenotazione>();
	}
	public Appello(int codice) {
		this.codice = codice;
		date = new LinkedList<Data>();
		studentiPrenotati = new LinkedList<Prenotazione>();
	}
	public Integer getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public LinkedList<Data> getDate() {
		return date;
	}
	public LinkedList<Prenotazione> getLista() {
		return studentiPrenotati;
	}
	
	
}
