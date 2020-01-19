
package main;

import javafx.application.Application;
import view.GUIMain;

/**
 * @author Ali und Mark: AudioMemory Modularbeit Ali Zanjani und Mark Zurfluh
 *         ZHAW, Software Engineering-Kurs: Java Vertiefung, Modul 2-3 und 2-4.
 *         Dozent und Betreuer: Matthias Bachmann.
 * 
 *         Version 1.0
 * 
 *         Das AudioMemory benutzt unter anderem JavaFX und JavaX Midi
 *         Bibliothek. Dank JavaFX wird die grafische Oberfläche kreiert. Mit
 *         Hilfe der JavaX Midi werden die Töne generiert. Es wurde MIDI, da die
 *         Authoren einerseits musigbegeistert sind, und anderseits, da diese
 *         auf jedem System als "standalone" ohne zusätzlichen externen Laufen
 *         kann. Sei dies unter Windows oder Linux.
 * 
 *         Das AudioMemory ist ein MemorySpiel, welches aber mit Klängen
 *         funktioniert. Beim Starten des Spiel werden jeweils 8 verschiedene
 *         Integers zufällig in einer gewissen Range generiert, welche dann der
 *         ButtonGame Klasse übergeben werden. Diese wird dann dupliziert, da es
 *         jeweils pro Ton zwei Spielkarten benötigt. Beim Anklicken der ersten
 *         Karte verändert sich das Bild. Nach dem Anklicken der zweiten Karte
 *         ändert sich das Bild zurück, falls der Ton nicht übereinstimmt. Bei
 *         der richtigen Kombination der Karten wird das Bild zu einem gürnen Ok
 *         gewechselt und ist nicht mehr ansteuerbar.
 * 
 *         Der Counter der Spielzüge sowie der Slider zur Veränderung der Dauer
 *         der Tonlänge wurden nicht fertig gestellt.
 * 
 *         Im Gegensatz zum herkömmlichen MemorySpiel ist einerseits die
 *         Verwendung des Tones einzigartig. Anderseits sind die Töne jeweils
 *         bei jedem Neustart des Spieles neu generiert, daher ist jede neue
 *         Runde einzigartig.
 * 
 *         In dieser Main Klasse wir lediglich das JavaFX gestartet, welche auf
 *         die GUIMain Klasse verweist. Diese initialisiert dann das ganze
 *         Spiel.
 */

public class Main {

	/**
	 * starte Spiel
	 * 
	 * @param args
	 * @throws Exception
	 */
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		GUIMain newGame = new GUIMain();
		Application.launch(newGame.getClass(), args);

	}

}
