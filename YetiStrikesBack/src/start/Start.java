package start;

import atmosphere.Music;
import atmosphere.Scenario;
import characters.Cabin;
import characters.Human;
import characters.Yeti;

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
