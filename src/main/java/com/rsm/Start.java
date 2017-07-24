package com.rsm;

import com.rsm.atmosphere.Music;
import com.rsm.atmosphere.Scenario;
import com.rsm.characters.Cabin;
import com.rsm.characters.Human;
import com.rsm.characters.Yeti;

public class Start extends Scenario {

	public static void main(String[] args) throws InterruptedException {

		Scenario world = new Scenario();
		Music music = new Music();
		music.playMusic();
		world.addItems();

		while (true) {

			world.setVisible(true);

			Yeti yeti = new Yeti();
			Human human = new Human();
			Cabin cabin = new Cabin();

			world.play(human, yeti, cabin);
		}
	}
}
