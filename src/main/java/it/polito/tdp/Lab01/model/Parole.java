package it.polito.tdp.Lab01.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * Classe che rappresenta un proto-modello che rappresenti un elenco di parole
 * @author cmas1
 *
 */
public class Parole {
	List<String> parole;	
	
	
	/**
	 * Costruttore senza argomenti
	 */
	public Parole() {
		//construct parole using either a LinkedList or an ArrayList, 
		// to compare what happens when new words are inserted or when 
		//words are deleted
		
//		this.parole = new LinkedList<String>();
		this.parole = new ArrayList<String>();
	}
	
	
	/**
	 * Funzione che aggiunge una nuova parola  alla lista. La stessa parola può
	 * essere aggiunta più volte.
	 * @param p : parola da aggiungere
	 */
	public void addParola(String p) {
		//qualora si volesse evitare di aggiungere la stessa parola più volte,
		//bisognerebbe mettere un controllo qui
		this.parole.add(p);
	}
	
	/**
	 * Funzione che rimuove una parola dalla lista.
	 * @param p : parola da rimuovere
	 */
	public void removeParola(String p) {
		this.parole.remove(p);
	}
	
	
	/**
	 * Funzione che ritorna un elenco di parole in ordine alfabetico
	 * @return Lista di parole
	 */
	public List<String> getElenco() {
		Collections.sort(this.parole);
		return this.parole;
	}
	
	/**
	 * Funzione che pulisce una lista di parole, rimuovendo tutte le parole inserite
	 */
	public void reset() {
		this.parole.clear();
	}

}