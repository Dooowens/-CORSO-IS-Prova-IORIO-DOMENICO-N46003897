package ENTITY;

public class Prenotazione {
	private Studente studentePrenotato;
	private Integer voto;
	public Prenotazione() {
		studentePrenotato = null;
		voto = null;
	}
	public Prenotazione(Studente studente) {
		this.studentePrenotato = studente;
		voto = null;
	}
	public Studente getStudentePrenotato() {
		return studentePrenotato;
	}
	public void setStudentePrenotato(Studente studente) {
		this.studentePrenotato = studente;
	}
	public Integer getVoto() {
		return this.voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	public String toString() {
		return (getStudentePrenotato().toString()+" VOTO: "+getVoto());
	}
	}
