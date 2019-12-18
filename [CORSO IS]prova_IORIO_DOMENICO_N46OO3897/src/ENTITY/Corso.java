package ENTITY;

import java.util.LinkedList;

public class Corso {
	private String nome;
	private String professore;
	private Integer CFU;
	private LinkedList<Appello> listaAppelli;
	public Corso() {
		nome = null;
		professore = null;
		CFU = null;
		listaAppelli = new LinkedList<Appello>();
	}
	public Corso(String nome, String professore, int CFU) {
		this.nome = nome;
		this.professore = professore;
		this.CFU = CFU;
		listaAppelli = new LinkedList<Appello>();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProfessore() {
		return professore;
	}
	public void setProfessore(String professore) {
		this.professore = professore;
	}
	public Integer getCFU() {
		return CFU;
	}
	public void setCFU(int CFU) {
		this.CFU = CFU;
	}
	public LinkedList<Appello> getLista() {
		return listaAppelli;
	}
	public String toString() {
		return("NOME CORSO: "+this.getNome()+" PROFESSORE: "+this.getProfessore()+" NUMERO CFU: "+this.getCFU());
	}

}
