package TEST;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CONTROL.GestoreCorsi;
import ENTITY.*;

public class GestoreCorsiTest {
	GestoreCorsi gestore;
	@Before
	public void setUp() throws Exception {
		gestore = new GestoreCorsi();
	}
	@After
	public void tearDown() throws Exception {
		gestore = null;
	}
	@Test
	public void testGestoreCorsi1() {
		LinkedList<Prenotazione> lista = gestore.getStudentiPrenotatiAppello("Ing. Software", 111);
		assertEquals(0,lista.size());
	}
	@Test
	public void testGestoreCorsi2() {
		Corso c1 = gestore.creaCorso("Ing. Software", "Natella", 9);
		LinkedList<Prenotazione> lista = gestore.getStudentiPrenotatiAppello("Ing. Software", 111);
		assertEquals(0,lista.size());
	}
	@Test
	public void testGestoreCorsi3() {
		Corso c1 = gestore.creaCorso("Ing. Software", "Natella", 9);
		Appello a1 = gestore.aggiungiAppello(111,c1);
		LinkedList<Prenotazione> lista = gestore.getStudentiPrenotatiAppello("Ing. Software", 111);
		assertEquals(0,lista.size());
	}
	@Test
	public void testGestoreCorsi4() {
		Corso c1 = gestore.creaCorso("Ing. Software", "Natella", 9);
		Appello a1 = gestore.aggiungiAppello(111,c1);
		Studente s1 = gestore.creaStudente("N46003897", "Domenico", "Iorio");
		Prenotazione p1 = gestore.aggiungiPrenotazione(s1,a1);
		LinkedList<Prenotazione> lista = gestore.getStudentiPrenotatiAppello("Ing. Software", 111);
		for(Prenotazione p : a1.getLista())
			System.out.println(p.toString());
		assertEquals(1,lista.size());
	}
	@Test
	public void testGestoreCorsi5() {
		Corso c1 = gestore.creaCorso("Ing. Software", "Natella", 9);
		Appello a1 = gestore.aggiungiAppello(111,c1);
		Studente s1 = gestore.creaStudente("N46003897", "Domenico", "Iorio");
		Studente s2 = gestore.creaStudente("N46003898", "Alessandro", "D'angelo");
		Studente s3 = gestore.creaStudente("N4600389", "Manuel", "Maddaluno");
		Prenotazione p1 = gestore.aggiungiPrenotazione(s1,a1);
		Prenotazione p2 = gestore.aggiungiPrenotazione(s2,a1);
		Prenotazione p3 = gestore.aggiungiPrenotazione(s3,a1);
		LinkedList<Prenotazione> lista = gestore.getStudentiPrenotatiAppello("Ing. Software", 111);
		for(Prenotazione p : a1.getLista())
			System.out.println(p.toString());
		assertEquals(3,lista.size());
	}
	@Test
	public void testGestoreCorsi6() {
		Corso c1 = gestore.creaCorso("Ing. Software", "Natella", 9);
		Appello a1 = gestore.aggiungiAppello(111,c1);
		Appello a2 = gestore.aggiungiAppello(112,c1);
		Studente s1 = gestore.creaStudente("N46003897", "Domenico", "Iorio");
		Studente s2 = gestore.creaStudente("N46003898", "Alessandro", "D'angelo");
		Studente s3 = gestore.creaStudente("N4600389", "Manuel", "Maddaluno");
		Prenotazione p1 = gestore.aggiungiPrenotazione(s1,a1);
		Prenotazione p2 = gestore.aggiungiPrenotazione(s2,a1);
		Prenotazione p3 = gestore.aggiungiPrenotazione(s3,a2);
		LinkedList<Prenotazione> lista1 = gestore.getStudentiPrenotatiAppello("Ing. Software", 111);
		LinkedList<Prenotazione> lista2 = gestore.getStudentiPrenotatiAppello("Ing. Software", 112);
		System.out.println("Studenti prenotati appello 1:");
		for(Prenotazione p : lista1)
			System.out.println(p.toString());
		System.out.println("Studenti prenotati appello 2:");
		for(Prenotazione p : lista2)
			System.out.println(p.toString());
		assertEquals(2,lista1.size());
		assertEquals(1,lista2.size());
	}
	@Test
	public void testGestoreCorsi7() {
		Corso c1 = gestore.creaCorso("Ing. Software", "Natella", 9);
		Corso c2 = gestore.creaCorso("Analisi 1", "De Maio", 9);
		Appello a1 = gestore.aggiungiAppello(111,c1);
		Appello a2 = gestore.aggiungiAppello(112, c2);
		Appello a3 = gestore.aggiungiAppello(113, c1);
		Appello a4 = gestore.aggiungiAppello(114, c2);
		Studente s1 = gestore.creaStudente("N46003897", "Domenico", "Iorio");
		Studente s2 = gestore.creaStudente("N46003898", "Alessandro", "D'angelo");
		Studente s3 = gestore.creaStudente("N4600389", "Manuel", "Maddaluno");
		Prenotazione p1 = gestore.aggiungiPrenotazione(s1,a1);
		Prenotazione p2 = gestore.aggiungiPrenotazione(s2,a1);
		Prenotazione p3 = gestore.aggiungiPrenotazione(s3,a2);
		LinkedList<Prenotazione> lista1 = gestore.getStudentiPrenotatiAppello("Ing. Software", 111);
		LinkedList<Prenotazione> lista2 = gestore.getStudentiPrenotatiAppello("Analisi 1", 112);
		LinkedList<Prenotazione> lista3 = gestore.getStudentiPrenotatiAppello("Ing. Software", 113);
		LinkedList<Prenotazione> lista4 = gestore.getStudentiPrenotatiAppello("Analisi 1", 114);
		System.out.println("Studenti prenotati appello 1:");
		for(Prenotazione p : lista1)
			System.out.println(p.toString());
		System.out.println("Studenti prenotati appello 2:");
		for(Prenotazione p : lista2)
			System.out.println(p.toString());
		System.out.println("Studenti prenotati appello 3:");
		for(Prenotazione p :lista3)
			System.out.println(p.toString());
		System.out.println("Studenti prenotati appello 4:");
		for(Prenotazione p : lista4)
			System.out.println(p.toString());
		assertEquals(2,lista1.size());
		assertEquals(1,lista2.size());
		assertEquals(0,lista3.size());
		assertEquals(0,lista4.size());
		
	}
	@Test
	public void testGestoreCorsi8() {
		Corso c1 = gestore.creaCorso("Ing. Software", "Natella", 9);
		Appello a1 = gestore.aggiungiAppello(111,c1);
		Studente s1 = gestore.creaStudente("N46003897", "Domenico", "Iorio");
		Prenotazione p1 = gestore.aggiungiPrenotazione(s1,a1);
		LinkedList<Prenotazione> lista1 = gestore.getStudentiPrenotatiAppello(null, 111);
		assertEquals(0,lista1.size());
	}
	@Test
	public void testGestoreCorsi9() {
		Corso c1 = gestore.creaCorso("Ing. Software", "Natella", 9);
		Appello a1 = gestore.aggiungiAppello(111,c1);
		Studente s1 = gestore.creaStudente("N46003897", "Domenico", "Iorio");
		Prenotazione p1 = gestore.aggiungiPrenotazione(s1,a1);
		LinkedList<Prenotazione> lista1 = gestore.getStudentiPrenotatiAppello("Ing. Software", null);
		assertEquals(0,lista1.size());
	}
	@Test
	public void testGestoreCorsi10() {
		Corso c1 = gestore.creaCorso("Ing. Software", "Natella", 9);
		Appello a1 = gestore.aggiungiAppello(111,c1);
		Studente s1 = gestore.creaStudente("N46003897", "Domenico", "Iorio");
		Prenotazione p1 = gestore.aggiungiPrenotazione(s1,a1);
		LinkedList<Prenotazione> lista1 = gestore.getStudentiPrenotatiAppello(null, null);
		assertEquals(0,lista1.size());
	}
	
}
