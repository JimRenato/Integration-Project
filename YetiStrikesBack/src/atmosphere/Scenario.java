package atmosphere;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import characters.Cabin;
import characters.Human;
import characters.Yeti;

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

	private Icon yetiStop = new ImageIcon("C:\\Users\\renat\\workspace\\YetiStrikesBackAStar\\Imagens\\YetiStop.gif");
	private Icon yetiRight = new ImageIcon("C:\\Users\\renat\\workspace\\YetiStrikesBackAStar\\Imagens\\YetiRight.gif");
	private Icon yetiLeft = new ImageIcon("C:\\Users\\renat\\workspace\\YetiStrikesBackAStar\\Imagens\\YetiLeft.gif");
	private Icon yetiWins = new ImageIcon("C:\\Users\\renat\\workspace\\YetiStrikesBackAStar\\Imagens\\YetiWins.gif");
	private Icon humanStop = new ImageIcon("C:\\Users\\renat\\workspace\\YetiStrikesBackAStar\\Imagens\\humanStop.gif");
	private Icon humanRight = new ImageIcon(
			"C:\\Users\\renat\\workspace\\YetiStrikesBackAStar\\Imagens\\humanRight.gif");
	private Icon humanLeft = new ImageIcon("C:\\Users\\renat\\workspace\\YetiStrikesBackAStar\\Imagens\\humanLeft.gif");
	private Icon cabin1I = new ImageIcon("C:\\Users\\renat\\workspace\\YetiStrikesBackAStar\\Imagens\\Cabin1.png");
	private Icon cabin2I = new ImageIcon("C:\\Users\\renat\\workspace\\YetiStrikesBackAStar\\Imagens\\Cabin2.png");
	private Icon openingI = new ImageIcon("C:\\Users\\renat\\workspace\\YetiStrikesBackAStar\\Imagens\\Opening.gif");
	private Icon theEnd1I = new ImageIcon("C:\\Users\\renat\\workspace\\YetiStrikesBackAStar\\Imagens\\TheEnd1.png");
	private Icon theEnd2I = new ImageIcon("C:\\Users\\renat\\workspace\\YetiStrikesBackAStar\\Imagens\\TheEnd2.png");
	private Icon snowI = new ImageIcon("C:\\Users\\renat\\workspace\\YetiStrikesBackAStar\\Imagens\\Snow.png");

	JButton playNowB = new JButton();

	Human human = new Human();
	Yeti yeti = new Yeti();
	Cabin cabin = new Cabin();

	// Método Construtor.
	public Scenario() {
		super("World");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1200, 600);
		setContentPane(new JLabel(snowI));
		container = getContentPane();
		setExtendedState(JFrame.MAXIMIZED_BOTH);

	}

	// This method adds all the Container.
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

	// Class with the action button PlayNow.
	public class buttonPlayNow implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if ((e.getModifiers() & MouseEvent.BUTTON1_MASK) != 0) {

				playNowB.setVisible(false);
				openingJL.setVisible(false);
				menu = false;
			}
		}
	}

	// Game Initialization method.
	public void play(Human human, Yeti yeti, Cabin cabin) throws InterruptedException {

		while (menu == true) {
			repaint();
		}
		artificialIntelligence(human, yeti, cabin);
	}

	// Method that checks which the end of the game.
	public void theEnd(Human human, Cabin cabin) {

		if (human.getLive() == false) {
			setYetiIcon(yetiWins);
			theEnd1JL.setVisible(true);
			yetiVictory = yetiVictory + 1;
			System.out.println("Fim da Jogada! Yeti Venceu!");
			System.out.println("-----------------------------------------------------");
		} else if (cabin.isOpen() == false) {
			setYetiIcon(yetiStop);
			theEnd2JL.setVisible(true);
			humanVictory = humanVictory + 1;
			System.out.println("Fim da Jogada! Humano Venceu!");
			System.out.println("-----------------------------------------------------");
		}

		playAgain(null);

	}

	// Method that checks if the player wants to play again.
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
			cabin.setOpen(true);
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

	// Method that changes the image of the Yeti.
	public void setYetiIcon(Icon yetiIcon) {
		this.yetiJL.setIcon(yetiIcon);
	}

	// Method that changes the image of the Human.
	public void setHumanIcon(Icon humanIcon) {
		this.humanJL.setIcon(humanIcon);
	}

	// Method that changes the image of the Cabin.
	public void setCabinIcon(Icon cabinIcon) {
		this.cabinJL.setIcon(cabinIcon);
	}

	// Method changes the Yeti image depending on the current Human position.
	public void positionJLYeti(Yeti yeti, Human human) {

		if (yeti.getPositionX() > human.getPositionX()) {
			setYetiIcon(yetiLeft);

		} else {
			setYetiIcon(yetiRight);
		}
	}

	// Method exchanging the Human image if he is going to the Cabin.
	public void positionJLHumanRunToCabin(Human human, Cabin cabin) {

		if (human.getPositionX() > cabin.getPositionX()) {
			setHumanIcon(humanLeft);

		} else {
			setHumanIcon(humanRight);
		}
	}

	// Method exchanging the Human image if he is running away from Yeti.
	public void positionJLHumanRunAway(Human human, Yeti yeti) {

		if (human.getPositionX() < yeti.getPositionX()) {
			setHumanIcon(humanLeft);

		} else {
			setHumanIcon(humanRight);
		}
	}

	// Method that prints the Console the current positions of Characters.
	public void printPosition(Human human, Yeti yeti, Cabin cabin) {
		System.out.println(
				"Position Cabin X = " + cabin.getPositionX() + " | " + "Position Cabin Y = " + cabin.getPositionY());
		System.out.println(
				"Position Yeti X = " + yeti.getPositionX() + " | " + "Position Yeti Y = " + yeti.getPositionY());
		System.out.println(
				"Position Human X = " + human.getPositionX() + " | " + "Position Human Y = " + human.getPositionY());
		System.out.println("-----------------------------------------------------");
	}

	// Method places the characters randomly.
	public void randomObjectPlace(Human human, Yeti yeti, Cabin cabin) {
		yetiJL.setLocation(yeti.randomPositionX(1100), yeti.randomPositionY(500));
		humanJL.setLocation(human.randomPositionX(1100), human.randomPositionY(500));
		cabinJL.setLocation(cabin.randomPositionX(1100), cabin.randomPositionY(500));
		theWall(human, cabin);
		yetiJL.setVisible(true);
		humanJL.setVisible(true);
		cabinJL.setVisible(true);
	}

	// Method does not allow the human and the cabin exit scenario.
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

	// Method verifies that Human is in the same position of the Yeti.
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

	// Method verifies that Human is in the same position of the cabin.
	public void compareHumanCabin(Human human, Cabin cabin) {

		if (human.getPositionX() == cabin.getPositionX() && human.getPositionY() == cabin.getPositionY()
				&& human.getLive() == true) {
			cabin.setOpen(false);
			humanJL.setVisible(false);
			setCabinIcon(cabin2I);
		}
	}

	// Method checks whether the human is near the Yeti to decide if he runs
	// away.
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

	// Method verifies that Human is alive, if so it makes the movement of the
	// Human fleeing the Yeti.
	public void checkHumanLiveRunYeti(Human human, Yeti yeti, Cabin cabin) {

		if (human.getLive() == true) {
			yeti.toHunt(human);
			yetiJL.setLocation(yeti.getPositionX(), yeti.getPositionY());
			human.runAway(yeti);
			humanJL.setLocation(human.getPositionX(), human.getPositionY());
		}
	}

	// Method verifies that Human is alive, and if so he is moving towards the
	// Cabin.
	public void checkHumanLiveRunToCabin(Human human, Yeti yeti, Cabin cabin) {

		if (human.getLive() == true) {
			yeti.toHunt(human);
			yetiJL.setLocation(yeti.getPositionX(), yeti.getPositionY());
			human.runToCabin(cabin);
			humanJL.setLocation(human.getPositionX(), human.getPositionY());
		}
	}

	// Method that guides the way of AI actions.
	public void artificialIntelligence(Human human, Yeti yeti, Cabin cabin) throws InterruptedException {

		randomObjectPlace(human, yeti, cabin);

		while (human.getLive() == true && cabin.isOpen() == true) {

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