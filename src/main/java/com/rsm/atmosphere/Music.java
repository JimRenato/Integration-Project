package com.rsm.atmosphere;

import java.io.File;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.JOptionPane;

public class Music {

	private static Sequencer player;
	private static String musicPath = "src/main/resources/Trilha/LeGrange.mid";
	private static int repeat = 10;

	public static void playMusic() {

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
