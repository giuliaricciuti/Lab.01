package it.polito.tdp.Lab01;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

import it.polito.tdp.Lab01.model.Parole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole listaParole;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCancella;

    @FXML
    private Button btnInserisci;

    @FXML
    private Button btnReset;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtResult;

    @FXML
    private TextArea txtTime;

    @FXML
    void doCancella(ActionEvent event) {
    	//NOTA BENE: In questa versione la parola da cancellare è presa dall'area di testo txtParola, in cui
    	// l'utente scrive le parole.
    	//Se si volesse selezionarla invece dall'area di testo in cui vengono stampati i risultati,
    	// qui sotto occorrerebbe sostituire la riga
    	// String parola = this.txtParola.getText();
    	// con 
    	// String parola = this.txtResult.getSelectedText()
    	
    	//1. Si legge la parola dall'area di testo, assicurandosi che 
    	//   non sia vuota
    	String parolaDaCancellare = this.txtParola.getText();
    	if (parolaDaCancellare.isEmpty()) {
    		return;
    	} 
    	
    	
    	//2. Si scorre la lista per cancellare la prima occorrenza dela parola inserita/selezionata
    	// misurandone anche il temp di esecuzione
    	double start = System.nanoTime();
    	this.listaParole.removeParola(parolaDaCancellare);
    	double stop = System.nanoTime();
    	
    	//NOTA BENE: se si volessero rimuovere tutte le possibili occorrenze di una stessa parola, le tre righe precedenti possono
    	// essere sostituite da
//    	double start = System.nanoTime();
//    	ListIterator<String> iter = this.listaParole.getElenco().listIterator();
//    	while(iter.hasNext()){
//    	    if(iter.next().equals(parolaDaCancellare)){
//    	        iter.remove();
//    	    }
//    	};
//    	double stop = System.nanoTime();
    	
    	
    	//3. Si aggiorna la visualizzazione
    	this.txtResult.clear();
    	for (String parola : this.listaParole.getElenco()) {
    		this.txtResult.appendText(parola + "\n");
    	}
    	
    	txtTime.clear();
    	txtTime.setText("[REMOVE]: " + (stop - start) + " nanoseconds");
    	
    	txtParola.clear();
    }

    
    
    @FXML
    void doInsert(ActionEvent event) {
    	//1. Si legge la parola dall'area di testo, assicurandosi che 
    	//   non sia vuota
    	String nuovaParola = this.txtParola.getText();
    	if (nuovaParola.isEmpty()) {
    		return;
    	}
    	
    	//2. Si aggiunge la nuova parola alla lista, misurando anche il tempo richiesto per fare
    	//	l'inserimento
    	double start = System.nanoTime();
    	this.listaParole.addParola(nuovaParola);
    	double stop = System.nanoTime();
    	
    	
    	//3. Si aggiorna la visualizzazione
    	this.txtResult.clear();
    	for (String parola : this.listaParole.getElenco()) {
    		this.txtResult.appendText(parola + "\n");
    	}
    	
    	txtTime.clear();
    	txtTime.setText("[INSERT]: " + (stop - start) + " nanoseconds");
    	
    	txtParola.clear();
    }

    @FXML
    void doReset(ActionEvent event) {
    	//1. Resettare la lista di parole
    	this.listaParole.reset();
    	
    	//2. Resettare la visualizzazione
    	this.txtParola.clear();
    	this.txtResult.clear();
    	this.txtTime.clear();
    	
    }

    @FXML
    void initialize() {
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";
        
        this.listaParole = new Parole();

    }

}
