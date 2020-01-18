/**
 * 
 * MiniMiniMusikProg, kurz MMMP, importiert die JavaX Midi Bibltiohek.
 * Es wird ein Sequenzer und ein Track  initialisiert.
 * Die Dokmentation kann hier nachgelesen werden:
 * https://docs.oracle.com/javase/7/docs/api/javax/sound/midi/package-summary.html
 * 
 * 
 * 
 */



package model;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MiniMiniMusikProg {

	// Länge der abzuspielenden Note
	int length = 100;

	

	// Konstruktor
	public MiniMiniMusikProg() {

	}

	public void playTone(int tonePitch) {
		try {

			Sequencer player = MidiSystem.getSequencer();
			// damit kann die Tonlänge als Faktor global verändert weren
			player.setTempoInBPM(50); 
			player.open();

			Sequence seq = new Sequence(Sequence.PPQ, 4);

			Track track = seq.createTrack();

			ShortMessage first = new ShortMessage();
			// z.B. Klänge: gut:19,23,26,Default:32,41,44,48,67,88,sehrgut91,102,109
			first.setMessage(192, 1, 91, 0); 
			MidiEvent instrumentWechsel = new MidiEvent(first, 1);
			track.add(instrumentWechsel);

			ShortMessage a = new ShortMessage();

			/* a.setMessage(192, 1, 35, 0);// Möglichkeit, zum Instrumenten-Wechsel
			*  Message-Typ(hier Note-On), Kanal, zu spielender Ton												// Anschlaglautstärte
			*/
			a.setMessage(144, 1, tonePitch, 70);// 

			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);

			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, 44, 127);
			MidiEvent noteOff = new MidiEvent(b, length);
			track.add(noteOff);

			player.setSequence(seq);
			player.start();
			Thread.sleep(1000);
			player.close();

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

}
