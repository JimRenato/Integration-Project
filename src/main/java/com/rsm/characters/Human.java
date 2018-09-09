package com.rsm.characters;

public class Human extends GameObject {

    private boolean live = true;

    public boolean getLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

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
