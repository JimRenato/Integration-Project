package atmosphere;

import java.io.File;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.JOptionPane;

public class Music {

	static Sequencer player;
	static String musicPath = "C:\\Users\\renat\\workspace\\YetiStrikesBackAStar\\Trilha\\LeGrange.mid";
	int repeat = 10;

	public void playMusic() {

		try {
			player = MidiSystem.getSequencer();
			Sequence music = MidiSystem.getSequence(new File(musicPath));
			player.open();
			player.setSequence(music);
			player.setLoopCount(repeat);
			player.start();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error playing the music: " + musicPath);
		}
	}
}
