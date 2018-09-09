package com.rsm.characters;

import javax.swing.*;
import java.util.Random;

public class GameObject extends JLabel {

    private int positionX, positionY;

    public Integer randomPositionX() {
        Random random = new Random();
        this.positionX = random.nextInt(1520);

        if (this.positionX <= 410) {
            this.positionX = 410;
        }

        return this.positionX;
    }

    public Integer randomPositionY() {
        Random random = new Random();
        this.positionY = random.nextInt(740);

        if (this.positionY <= 180) {
            this.positionY = 180;
        }

        return this.positionY;
    }

    public int getPositionX() {
        return this.positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
