package it.polito.tdp.Lab01.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parole {
		
	private List <String> parole = new ArrayList<String>();
	
	public Parole() {
		//TODO
	}
	
	public void addParola(String p) {
		parole.add(p);
		//TODO
	}
	
	public List<String> getElenco(String s) {
		//TODO
		Collections.sort(parole);
		return parole;
	}
	
	public void cancella(String s) {
		// TODO
		parole.remove(s);
	}
	
	public void reset() {
		// TODO
		parole.clear();
	}

}