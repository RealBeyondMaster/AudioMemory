package model;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MiniMiniMusikProg {

	// Länge der abzuspielenden Note
	int length = 2;
	// Tonhöhe
	int hoehe = 120;

	// diesen Text habe ich heute, 20. 11.19, gepusht
	public static void main(String[] args) {
		MiniMiniMusikProg mini = new MiniMiniMusikProg();
		mini.spielen();
	}

	public void spielen() {
		try {

			Sequencer player = MidiSystem.getSequencer();
			player.setTempoInBPM(200); // damit kann die Tonlänge als Faktor global verändert weren
			player.open();

			Sequence seq = new Sequence(Sequence.PPQ, 4);

			Track track = seq.createTrack();

			ShortMessage first = new ShortMessage();
			first.setMessage(192, 1, 19, 0); // z.B. Klänge: 19,23,26,32,41,44,48,67,88,91,102,109
			MidiEvent instrumentWechsel = new MidiEvent(first, 1);
			track.add(instrumentWechsel);

			ShortMessage a = new ShortMessage();

			// a.setMessage(192, 1, 35, 0);// Möglichkeit, zum Instrumenten-Wechsel
			a.setMessage(144, 1, 60, 70);// Message-Tup(hier Note-On), Kanal, zu spielender Ton, Anschlaglautstärte

			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);

			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, 44, 127);
			MidiEvent noteOff = new MidiEvent(b, length);
			track.add(noteOff);

			player.setSequence(seq);
			player.start();
			Thread.sleep(5000);
			player.close();

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

}
