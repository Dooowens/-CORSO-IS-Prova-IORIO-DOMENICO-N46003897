package ENTITY;

public class Studente {
	private String matricola;
	private String nome;
	private String cognome;
	public Studente() {
		matricola = "";
		nome = "";
		cognome = "";
	}
	public Studente(String matricola, String nome, String Cognome) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = Cognome;
	}
	
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String toString() {
		return ("NOME: "+getNome()+" COGNOME: "+getCognome()+" MATRICOLA: "+getMatricola());
	}
}
