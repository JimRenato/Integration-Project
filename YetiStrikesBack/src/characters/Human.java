package characters;

public class Human extends Character {

	private boolean live = true;

	public boolean getLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	// This method compares the Human position with the Yeti and makes him flee the Yeti
	public void runAway(Yeti yeti) {

		if (this.getPositionX() < yeti.getPositionX()) {
			this.setPositionX(this.getPositionX() - 1);
		}
		if (this.getPositionX() > yeti.getPositionX()) {
			this.setPositionX(this.getPositionX() + 1);
		}
		if (this.getPositionY() < yeti.getPositionY()) {
			this.setPositionY(this.getPositionY() - 1);
		}
		if (this.getPositionY() > yeti.getPositionY()) {
			this.setPositionY(this.getPositionY() + 1);
		}
	}

	// This method compares the human position with Caban and causes it to go toward Cabin
	public void runToCabin(Cabin cabin) {

		if (this.getPositionX() > cabin.getPositionX()) {
			this.setPositionX(this.getPositionX() - 1);
		}
		if (this.getPositionX() < cabin.getPositionX()) {
			this.setPositionX(this.getPositionX() + 1);
		}
		if (this.getPositionY() > cabin.getPositionY()) {
			this.setPositionY(this.getPositionY() - 1);
		}
		if (this.getPositionY() < cabin.getPositionY()) {
			this.setPositionY(this.getPositionY() + 1);
		}
	}
}
