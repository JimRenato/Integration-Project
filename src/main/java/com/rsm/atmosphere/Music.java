package com.rsm.atmosphere;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.*;
import java.io.File;

public class Music {

    public static void playMusic() {

        String musicPath = "src/main/resources/soundtrack/le-grange.mid";
        try {
            Sequencer player = MidiSystem.getSequencer();
            Sequence music = MidiSystem.getSequence(new File(musicPath));
            player.open();
            player.setSequence(music);
            int repeat = 10;
            player.setLoopCount(repeat);
            player.start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error playing the music: " + musicPath);
        }
    }
}
