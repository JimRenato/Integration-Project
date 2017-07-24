package com.rsm.atmosphere;

import com.rsm.characters.Cabin;
import com.rsm.characters.Human;
import com.rsm.characters.Yeti;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class Scenario extends JFrame {

    private Container container;

    private int yetiVictory = 0;
    private int humanVictory = 0;

    private boolean menu = true;
    private boolean closeYetiX = false;
    private boolean closeYetiY = false;

    private JLabel yetiJL;
    private JLabel humanJL;
    private JLabel cabinJL;
    private JLabel wallRightJL;
    private JLabel wallLeftJL;
    private JLabel wallTopJL;
    private JLabel wallDownJL;
    private JLabel openingJL;
    private JLabel theEnd1JL;
    private JLabel theEnd2JL;

    private Icon yetiStop = new ImageIcon("src/main/resources/Imagens/YetiStop.gif");
    private Icon yetiRight = new ImageIcon("src/main/resources/Imagens/YetiRight.gif");
    private Icon yetiLeft = new ImageIcon("src/main/resources/Imagens/YetiLeft.gif");
    private Icon yetiWins = new ImageIcon("src/main/resources/Imagens/YetiWins.gif");
    private Icon humanStop = new ImageIcon("src/main/resources/Imagens/humanStop.gif");
    private Icon humanRight = new ImageIcon("src/main/resources/Imagens/humanRight.gif");
    private Icon humanLeft = new ImageIcon("src/main/resources/Imagens/humanLeft.gif");
    private Icon cabin1I = new ImageIcon("src/main/resources/Imagens/Cabin1.png");
    private Icon cabin2I = new ImageIcon("src/main/resources/Imagens/Cabin2.png");
    private Icon openingI = new ImageIcon("src/main/resources/Imagens/Opening.gif");
    private Icon theEnd1I = new ImageIcon("src/main/resources/Imagens/TheEnd1.png");
    private Icon theEnd2I = new ImageIcon("src/main/resources/Imagens/TheEnd2.png");
    private Icon snowI = new ImageIcon("src/main/resources/Imagens/Snow.png");

    JButton playNowB = new JButton();

    // Constructor.
    public Scenario() {
        super("World");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 600);
        setContentPane(new JLabel(snowI));
        container = getContentPane();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    // Adds all to Container.
    public void addItems() {

        humanJL = new JLabel(humanStop);
        humanJL.setSize(100, 100);
        humanJL.setLocation(0, 0);
        humanJL.setVisible(false);

        yetiJL = new JLabel(yetiStop);
        yetiJL.setSize(100, 100);
        yetiJL.setLocation(100, 0);
        yetiJL.setVisible(false);

        cabinJL = new JLabel(cabin1I);
        cabinJL.setSize(80, 100);
        cabinJL.setLocation(100, 0);
        cabinJL.setVisible(false);

        wallRightJL = new JLabel();
        wallRightJL.setSize(70, 600);
        wallRightJL.setLocation(1190, 0);
        wallRightJL.setVisible(false);

        wallLeftJL = new JLabel();
        wallLeftJL.setSize(80, 600);
        wallLeftJL.setLocation(20, 0);
        wallLeftJL.setVisible(false);

        wallDownJL = new JLabel();
        wallDownJL.setSize(800, 70);
        wallDownJL.setLocation(0, 590);
        wallDownJL.setVisible(false);

        wallTopJL = new JLabel();
        wallTopJL.setSize(800, 70);
        wallTopJL.setLocation(0, 0);
        wallTopJL.setVisible(false);

        openingJL = new JLabel(openingI);
        openingJL.setSize(1366, 768);
        openingJL.setLocation(0, 0);
        openingJL.setVisible(true);

        theEnd1JL = new JLabel(theEnd1I);
        theEnd1JL.setSize(500, 150);
        theEnd1JL.setLocation(400, 10);
        theEnd1JL.setVisible(false);

        theEnd2JL = new JLabel(theEnd2I);
        theEnd2JL.setSize(500, 150);
        theEnd2JL.setLocation(400, 10);
        theEnd2JL.setVisible(false);

        playNowB.setBounds(88, 250, 229, 54);
        playNowB.addActionListener(new buttonPlayNow());
        playNowB.setVisible(true);

        container.add(theEnd1JL);
        container.add(theEnd2JL);
        container.add(humanJL);
        container.add(yetiJL);
        container.add(cabinJL);
        container.add(openingJL);
        container.add(playNowB);
        container.add(wallRightJL);
        container.add(wallLeftJL);
        container.add(wallTopJL);
        container.add(wallDownJL);
    }

    // The action button PlayNow.
    private class buttonPlayNow implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if ((e.getModifiers() & MouseEvent.BUTTON1_MASK) != 0) {

                playNowB.setVisible(false);
                openingJL.setVisible(false);
                menu = false;
            }
        }
    }

    // Game Initialization.
    public void play(Human human, Yeti yeti, Cabin cabin) throws InterruptedException {

        while (menu == true) {
            repaint();
        }
        artificialIntelligence(human, yeti, cabin);
    }

    // Checks which the end of the game.
    public void theEnd(Human human, Cabin cabin) {

        if (human.getLive() == false) {
            setYetiIcon(yetiWins);
            theEnd1JL.setVisible(true);
            yetiVictory = yetiVictory + 1;
            System.out.println("End of Play! Yeti wins!");
            System.out.println("-----------------------------------------------------");
        } else if (cabin.isOpen() == false) {
            setYetiIcon(yetiStop);
            theEnd2JL.setVisible(true);
            humanVictory = humanVictory + 1;
            System.out.println("End of Play! Human wins!");
            System.out.println("-----------------------------------------------------");
        }

        playAgain(null);

    }

    // Checks if the player wants to play again.
    public void playAgain(ActionEvent eventoBotao) {

        int playAgain = JOptionPane.showConfirmDialog(null, "Do you want to play again?");

        if (playAgain == JOptionPane.YES_OPTION) {

            humanJL.setVisible(false);
            yetiJL.setVisible(false);
            cabinJL.setVisible(false);
            theEnd1JL.setVisible(false);
            theEnd2JL.setVisible(false);
            closeYetiX = false;
            closeYetiY = false;
            setCabinIcon(cabin1I);

        } else {
            if (humanVictory == 0) {
                JOptionPane.showMessageDialog(null, "Human did not win and Yeti wons " + yetiVictory + " times!");
                JOptionPane.showMessageDialog(null, "See you later!");
                System.out.println("Human did not win and Yeti wons " + yetiVictory + " times!");
                dispose();
                System.exit(0);
            }
            if (yetiVictory == 0) {
                JOptionPane.showMessageDialog(null, "Human wons " + humanVictory + " times and Yeti did not win!");
                JOptionPane.showMessageDialog(null, "See you later!");
                System.out.println("Human wons " + humanVictory + " times and Yeti did not win!");
                dispose();
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Human wons " + humanVictory + " times and Yeti wons " + yetiVictory + " times!");
                JOptionPane.showMessageDialog(null, "See you later!");
                System.out.println("Human wons " + humanVictory + " times and Yeti wons " + yetiVictory + " times!");
                dispose();
                System.exit(0);
            }
        }
    }

    // Changes the image of the Yeti.
    public void setYetiIcon(Icon yetiIcon) {
        this.yetiJL.setIcon(yetiIcon);
    }

    // Changes the image of the Human.
    public void setHumanIcon(Icon humanIcon) {
        this.humanJL.setIcon(humanIcon);
    }

    // Changes the image of the Cabin.
    public void setCabinIcon(Icon cabinIcon) {
        this.cabinJL.setIcon(cabinIcon);
    }

    // Changes the Yeti image depending on the current Human position.
    public void positionJLYeti(Yeti yeti, Human human) {

        if (yeti.getPositionX() > human.getPositionX()) {
            setYetiIcon(yetiLeft);

        } else {
            setYetiIcon(yetiRight);
        }
    }

    // Changes the Human image if he's going to the Cabin.
    public void positionJLHumanRunToCabin(Human human, Cabin cabin) {

        if (human.getPositionX() > cabin.getPositionX()) {
            setHumanIcon(humanLeft);

        } else {
            setHumanIcon(humanRight);
        }
    }

    // Changes the Human image if he's running away from Yeti.
    public void positionJLHumanRunAway(Human human, Yeti yeti) {

        if (human.getPositionX() < yeti.getPositionX()) {
            setHumanIcon(humanLeft);

        } else {
            setHumanIcon(humanRight);
        }
    }

    // Prints the Console the current positions of Characters.
    public void printPosition(Human human, Yeti yeti, Cabin cabin) {
        System.out.println(
                "Position Cabin X = " + cabin.getPositionX() + " | " + "Position Cabin Y = " + cabin.getPositionY());
        System.out.println(
                "Position Yeti X = " + yeti.getPositionX() + " | " + "Position Yeti Y = " + yeti.getPositionY());
        System.out.println(
                "Position Human X = " + human.getPositionX() + " | " + "Position Human Y = " + human.getPositionY());
        System.out.println("-----------------------------------------------------");
    }

    // Places the characters randomly.
    public void randomObjectPlace(Human human, Yeti yeti, Cabin cabin) {
        yetiJL.setLocation(yeti.randomPositionX(1100), yeti.randomPositionY(500));
        humanJL.setLocation(human.randomPositionX(1100), human.randomPositionY(500));
        cabinJL.setLocation(cabin.randomPositionX(1100), cabin.randomPositionY(500));
        theWall(human, cabin);
        yetiJL.setVisible(true);
        humanJL.setVisible(true);
        cabinJL.setVisible(true);
    }

    // Does not allow the human and the cabin exit scenario.
    public void theWall(Human human, Cabin cabin) {
        if (human.getPositionX() <= wallLeftJL.getX()) {
            human.setPositionX(human.getPositionX() + 1);
        }

        if (human.getPositionX() >= wallRightJL.getX()) {
            human.setPositionX(human.getPositionX() - 1);
        }

        if (human.getPositionY() <= wallTopJL.getY()) {
            human.setPositionY(human.getPositionY() + 1);
        }

        if (human.getPositionY() >= wallDownJL.getY()) {
            human.setPositionY(human.getPositionY() - 1);
        }

        if (cabin.getPositionX() <= wallLeftJL.getX() + 30) {
            cabin.setPositionX(cabin.getPositionX() + 50);
            cabinJL.setLocation(cabin.getPositionX(), cabin.getPositionY());
        }

        if (cabin.getPositionX() >= wallRightJL.getX() - 30) {
            cabin.setPositionX(cabin.getPositionX() - 50);
            cabinJL.setLocation(cabin.getPositionX(), cabin.getPositionY());
        }

        if (cabin.getPositionY() <= wallTopJL.getY() + 30) {
            cabin.setPositionY(cabin.getPositionY() + 50);
            cabinJL.setLocation(cabin.getPositionX(), cabin.getPositionY());
        }

        if (cabin.getPositionY() >= wallDownJL.getY() - 30) {
            cabin.setPositionY(cabin.getPositionY() - 50);
            cabinJL.setLocation(cabin.getPositionX(), cabin.getPositionY());
        }
    }

    // Verifies that Human is in the same position of the Yeti.
    public void compareYetiHuman(Yeti yeti, Human human) {

        if (yeti.getPositionX() == human.getPositionX() && yeti.getPositionY() == human.getPositionY()
                || (yeti.getPositionX() - 1) == human.getPositionX() && yeti.getPositionY() == human.getPositionY()
                || yeti.getPositionX() == human.getPositionX() && (yeti.getPositionY() - 1) == human.getPositionY()
                || (yeti.getPositionX() + 1) == human.getPositionX() && yeti.getPositionY() == human.getPositionY()
                || yeti.getPositionX() == human.getPositionX() && (yeti.getPositionY() + 1) == human.getPositionY()) {
            human.setLive(false);
            humanJL.setVisible(false);
        }
    }

    // Verifies that Human is in the same position of the cabin.
    public void compareHumanCabin(Human human, Cabin cabin) {

        if (human.getPositionX() == cabin.getPositionX() && human.getPositionY() == cabin.getPositionY()
                && human.getLive() == true) {
            cabin.setOpen(false);
            humanJL.setVisible(false);
            setCabinIcon(cabin2I);
        }
    }

    // Checks whether the human is near the Yeti to decide if he runs away.
    public void compareBestChoise(Human human, Yeti yeti, Cabin cabin) {

        if (human.getPositionX() > yeti.getPositionX()) {
            if ((human.getPositionX() - yeti.getPositionX() <= 15) && closeYetiX == false) {
                closeYetiX = true;
            }
        }

        if (human.getPositionX() < yeti.getPositionX()) {
            if ((human.getPositionX() - yeti.getPositionX() >= -15) && closeYetiX == false) {
                closeYetiX = true;
            }
        }

        if (human.getPositionY() > yeti.getPositionY()) {
            if ((human.getPositionY() - yeti.getPositionY() <= 15) && closeYetiY == false) {
                closeYetiY = true;
            }
        }

        if (human.getPositionY() < yeti.getPositionY()) {
            if ((human.getPositionY() - yeti.getPositionY() >= -15) && closeYetiY == false) {
                closeYetiY = true;
            }
        }

        if ((closeYetiX == true && closeYetiY == true)) {
            checkHumanLiveRunYeti(human, yeti, cabin);
            positionJLHumanRunAway(human, yeti);

        } else {
            checkHumanLiveRunToCabin(human, yeti, cabin);
            positionJLHumanRunToCabin(human, cabin);
        }
    }

    // If Human is alive he flees from the Yeti
    public void checkHumanLiveRunYeti(Human human, Yeti yeti, Cabin cabin) {

        if (human.getLive() == true) {
            yeti.toHunt(human);
            yetiJL.setLocation(yeti.getPositionX(), yeti.getPositionY());
            human.runAway(yeti);
            humanJL.setLocation(human.getPositionX(), human.getPositionY());
        }
    }

    // If Human is alive he's moving towards the Cabin.
    public void checkHumanLiveRunToCabin(Human human, Yeti yeti, Cabin cabin) {

        if (human.getLive() == true) {
            yeti.toHunt(human);
            yetiJL.setLocation(yeti.getPositionX(), yeti.getPositionY());
            human.runToCabin(cabin);
            humanJL.setLocation(human.getPositionX(), human.getPositionY());
        }
    }

    // Guides the way of AI actions.
    public void artificialIntelligence(Human human, Yeti yeti, Cabin cabin) throws InterruptedException {

        randomObjectPlace(human, yeti, cabin);

        while (human.getLive() && cabin.isOpen()) {

            theWall(human, cabin);
            compareYetiHuman(yeti, human);
            compareHumanCabin(human, cabin);
            printPosition(human, yeti, cabin);
            compareBestChoise(human, yeti, cabin);
            positionJLYeti(yeti, human);
            Thread.sleep(10);
        }
        theEnd(human, cabin);
    }
}