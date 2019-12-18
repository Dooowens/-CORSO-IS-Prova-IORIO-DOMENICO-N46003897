package CONTROL;

import java.time.Month;
import java.util.LinkedList;

import ENTITY.*;

public class GestoreCorsi {
	private LinkedList<Corso> corsi;
	private LinkedList<Studente> studenti;
	public GestoreCorsi() {
		corsi = new LinkedList<Corso>();
		studenti = new LinkedList<Studente>();
	}
	public Studente creaStudente(String matricola, String nome, String cognome) {
		Studente studente = new Studente(matricola,nome,cognome);
		studenti.add(studente);
		return studente;
	}
	public void aggiungiData(TIPO_CLASSE classe, TIPO_PROVA prova, int year, Month month, int day, Appello appello) {
		Data data = new Data(classe,prova,year,month,day);
		appello.getDate().add(data);
	}
	public Appello aggiungiAppello(int codice, Corso corso) {
		Appello appello = new Appello(codice);
		corso.getLista().add(appello);
		return appello;
	}
	public Corso creaCorso (String nome, String professore, int CFU) {
		Corso corso = new Corso(nome,professore,CFU);
		this.corsi.add(corso);
		return corso;
	}
	public Prenotazione aggiungiPrenotazione(Studente studente, Appello appello) {
		Prenotazione prenotazione = new Prenotazione(studente);
		appello.getLista().add(prenotazione);
		return prenotazione;
	} 
	public Corso cercaCorso(String nome) {
		Corso corso = null;
		if (nome == null)
			System.out.println("Non è stato inserito un parametro valido");
		else {
		  for(Corso c : this.corsi) {
			if(c.getNome()==nome) {
				corso = c;
				break;
			}
		  }
		}
		return corso;
	}
	public Appello cercaAppello(Integer id, String nome) {
		Corso corso = this.cercaCorso(nome);
		Appello appello = new Appello();
		if(id == null) {
			appello = null;
			if(corso != null) {
			System.out.println("Non è stato inserito un codice valido. Di seguito la lista di tutti gli appelli relativi al corso");
			for(Appello a : corso.getLista())
				this.stampaAppello(a);
			}
			else
				System.out.println("Il corso ricercato non esiste");
			}
		else {
		  if (corso == null)
			System.out.println("Il corso ricercato non esiste");
		  else {
		    for(Appello a : corso.getLista()) {
			  if(a.getCodice()==id) {
				appello = a;
				break;
			   }
		     }
	       }
	     }
		return appello;
	 }
	
	public LinkedList<Prenotazione> getStudentiPrenotatiAppello(String nome,Integer codiceAppello) {
		LinkedList<Prenotazione> lista = new LinkedList<Prenotazione>();
		if(codiceAppello == null && nome == null) {
			System.out.println("Non è possibile eseguire nessuna operazione");
		}
		else {
		   Appello appello = this.cercaAppello(codiceAppello, nome);
		   if (appello.getCodice() == null)
			 System.out.println("L'appello ricercato non esiste");
		   else {
			 lista = appello.getLista();
		     if (lista.isEmpty())
			   System.out.println("Non ci sono studenti prenotati per quest'appello");
		   }
		 }
		 return lista;
	}
	public void stampaAppello(Appello a) {
		System.out.println("CODICE: "+a.getCodice());
		for(Data d : a.getDate())
			System.out.println(d.toString());
		System.out.println("STUDENTI PRENOTATI:");
		for(Prenotazione p : a.getLista())
			System.out.println(p.toString());
	}
	public void stampaCorso(Corso c) {
		System.out.println(c.toString());
		for(Appello a : c.getLista())
			this.stampaAppello(a);
	}
	public void eliminaCorso(String nome) {
		for(Corso c : this.corsi) {
			if(c.getNome() == nome)
				this.corsi.remove(c);
		}
	}
	public void eliminaAppello(String nome, int codice) {
		for(Corso c : this.corsi) {
			if(c.getNome() == nome) {
				for(Appello a : c.getLista()) {
					if(a.getCodice()==codice)
						c.getLista().remove(a);
				 }
			 }
		 }
	}
	public void eliminaPrenotazione(Appello a, Prenotazione p) {
		a.getLista().remove(p);
	}
	public void inserisciVoto(int voto, String matricola, int codice, String corso) {
		Appello appello = this.cercaAppello(codice, corso);
		for(Prenotazione p : appello.getLista()) {
			if(p.getStudentePrenotato().getMatricola()==matricola)
				p.setVoto(voto);
			else
				System.out.println("La matricola inserita non corrisponda a nessuno deglis studenti prenotati");
		}
	}
}
