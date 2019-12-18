package ENTITY;

import java.time.LocalDate;
import java.time.Month;

public class Data {
	private TIPO_CLASSE classe;
	private TIPO_PROVA prova;
	private LocalDate data;
	
	public Data() {
		classe = null;
		prova = null;
		data = LocalDate.of(0, null, 0);
	}
	public Data(TIPO_CLASSE classe, TIPO_PROVA prova, int year, Month month, int day) {
		this.classe = classe;
		this.prova = prova;
		this.data = LocalDate.of(year, month, day);
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public TIPO_PROVA getProva() {
		return prova;
	}
	public void setProva(TIPO_PROVA prova) {
		this.prova = prova;
	}
	public TIPO_CLASSE getClasse() {
		return classe;
	}
	public void setClasse(TIPO_CLASSE classe) {
		this.classe = classe;
	}
	public String toString() {
		return ("DATA: "+getData()+" CLASSE: "+getClasse()+" PROVA: "+getProva());
	}
}
