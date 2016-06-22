package characters;

import java.util.Random;

import javax.swing.JLabel;

public class Character extends JLabel {

	private int positionX, positionY;

	public Integer randomPositionX(Integer limit) {
		Random random = new Random();
		this.positionX = random.nextInt(limit);

		return positionX;
	}

	public Integer randomPositionY(Integer limit) {
		Random random = new Random();
		this.positionY = random.nextInt(limit);

		return positionY;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
}
