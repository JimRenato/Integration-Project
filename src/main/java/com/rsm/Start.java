package com.rsm;

import com.rsm.atmosphere.Music;
import com.rsm.atmosphere.Scenario;

public class Start {

    public static void main(String[] args) throws InterruptedException {
        Music.playMusic();

        Scenario world = new Scenario();
        world.addItems();
        world.setVisible(true);

        while (true) {
            world.play();
        }
    }
}
