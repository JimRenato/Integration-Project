package com.rsm.characters;

public class Yeti extends GameObject {
	
	// This method compares the Yeti position with Human and causes it to go behind the Human
	public void toHunt(Human human) {

		if (this.getPositionX() > human.getPositionX()) {
			this.setPositionX(this.getPositionX() - 1);
		}
		if (this.getPositionX() < human.getPositionX()) {
			this.setPositionX(this.getPositionX() + 1);
		}
		if (this.getPositionY() > human.getPositionY()) {
			this.setPositionY(this.getPositionY() - 1);
		}
		if (this.getPositionY() < human.getPositionY()) {
			this.setPositionY(this.getPositionY() + 1);
		}
	}
}
