package controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import model.ButtonGame;

public class ButtonController{
	

	
	private ArrayList<ButtonGame> clickedButton;
	private int counter;

	public ButtonController() {
		
		this.counter = 0;
		this.clickedButton = new ArrayList<ButtonGame>(1);
		
		
	}
	
	
	//bei ButtonClick
	public boolean buttonclick(ButtonGame button) {
		if (this.clickedButton.size()<2) 
			return isMatchingPairs(button);
		else return false;}
		
		
		
	

	// Vergleicht, ob nach 2 clicks angecklickte Buttons(Tonhöhe) dieselben sind oder nicht. 
	private boolean isMatchingPairs(ButtonGame button) {
		this.clickedButton.add(button);
		if (this.clickedButton.size() == 2) {
			
			ButtonGame zweiterButton = (ButtonGame) this.clickedButton.get(0);
			if (zweiterButton.getTonhoehe() == button.getTonhoehe())
				this.clickedButton.clear();
			
		}
		return true;
		
	}
	
	//abdecken
	/*
	public void handle(MouseEvent event) {
		for (int i=0; i<this.clickedButton.size();i++) {
			Button button = (Button)this.clickedButton.get(i);
			button.abdecken();}
		this.clickedButton.clear();
		}
	*/	
		
	
	
	//Zaehlt die Anzahl Clicks
	public void clickCounter(MouseEvent arg0)
	{
		
		
	}
	
	
	//Verändert die Tonlänge
	public void toneLength(int toneLength)
	{
		
		
	}
	


	
}
