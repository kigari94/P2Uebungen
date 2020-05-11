package ufogame;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import view.GameFrameWork;
import view.IKeyboardListener;
import view.ITickableListener;
import view.Message;


public class Game implements ITickableListener, IKeyboardListener {

	// Idea: we want to have multiple instances of an ufo and of a projectile
	private ArrayList<Projectile> projectiles = new ArrayList<>();
	private ArrayList<Ufo> ufos = new ArrayList<>();
//	private Ufo [] ufos = new Ufo[10];
//	private Projectile [] projectiles = new Projectile[30];
	private Ship ship;
	private int screenWidth = 900;
	private int screenHeight = 700;
	private GameFrameWork frameWork = new GameFrameWork();

	/**
	 * Initiates everything for the game. Multiple ufos and a ship are created.
	 */
	public void init() {
		frameWork.setSize(screenWidth, screenHeight);
		frameWork.setBackground(new Background("Vorlesung01\\assets\\space14.jpg"));
		
		// Create ship object
		ship = new Ship(screenWidth / 2, 4 * screenHeight / 5, screenWidth / 9, screenWidth / 9,
				"Vorlesung01\\assets\\ship23.png");
		// Add ship object to the framework
		frameWork.addGameObject(ship);
		
		// Create ufo object
		Ufo ufo = new Ufo(-20, screenHeight / 5, screenWidth / 10, screenWidth / 19, 1,
				"Vorlesung01\\assets\\ufo20.png");
		ufos.add(ufo);
		// Add ufo object to the framework
		frameWork.addGameObject(ufo);

		for (int i = 1; i < 10; i++) {
			ufos.add(new Ufo(ufos.get(i - 1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(),
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(i));
		}

		frameWork.addTick(this);
		frameWork.addIKeyInput(this);

	}

	public void shoot() {
		// create a projectile
		Projectile projectile = new Projectile(ship.getX() + ship.getWidth()/4, 
				ship.getY() - ship.getWidth() / 2, ship.getWidth() / 2, ship.getWidth() / 2, 3,
				"Vorlesung01\\assets\\projectile06.png");
		projectiles.add(projectile);

		frameWork.addGameObject(projectile);

//		for(int i = 0; i < 1000; i++) {
//			projectiles.add(projectile);
//		}
//		
//		for(Projectile p : projectiles) {
//			System.out.println(p.getImagePath());
//		}
		// Variante Array
		// projectiles[0] = projectile;

		// projectiles.get(0).getWidth();
		// Variante Array
		// projectiles[0].getWidth();

		// projectiles.size();
		// Variante Array
		// projectiles.lenght
	}

	// Aufgabe 2
	public boolean checkCollision() {
		for (Ufo ufo : ufos) {
			for (Projectile projectile : projectiles) {
				if ((ufo.getX() < projectile.getX() + projectile.getWidth()) &&
					(ufo.getY() < projectile.getY() + projectile.getHeight()) &&
					(ufo.getX() + ufo.getWidth() > projectile.getX()) &&
					(ufo.getY() + ufo.getHeight() > projectile.getY())) {
					ufos.get(0).setCollided(true);
					projectiles.get(0).setCollided(true);
					return true;
				}else {
					return false;
				}
			}
		}
		return false;

	}
	
	@Override
	public void tick(long elapsedTime) {
		for (Ufo ufo : ufos) {
			ufo.move();
		}
		//TODO checkCollision() in der Abfrage ist überflüssig, da du am Ende der tick() das ja schon abfragst
		if (ufos.get(0).getX() > screenWidth || ufos.get(0).isCollided() || checkCollision()) {
//			ufos.get(0).
			frameWork.removeGameObject(ufos.get(0));
			ufos.remove(0);
			ufos.add(new Ufo(ufos.get(ufos.size() - 1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(),
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(ufos.size() - 1));
		}
		
		for(Projectile p: projectiles) {
            p.move();
			//TODO checkCollision() in der Abfrage ist überflüssig, da du am Ende der tick() das ja schon abfragst
            checkCollision();
        }
		
		// Aufgabe 1
		//TODO checkCollision() in der Abfrage ist überflüssig, da du am Ende der tick() das ja schon abfragst
		//TODO hier taucht eine IndexOutOfBoundsException auf, da es am Anfang kein Element in der Liste gibt
		if(projectiles.get(0).getY() < 0 || projectiles.get(0).isCollided() || checkCollision()) {

			frameWork.removeGameObject(projectiles.get(0));
			projectiles.remove(0);
		}
		
		// Aufgabe 3
		if (checkCollision()) {
			int highscore = 0;
			
			highscore += 1;
			Message message = new Message("New highscore: " + highscore, 0, 0, 3, new Color(255, 255, 255));
			frameWork.addMessage(message);
		}
	}

	@Override
	public int[] getKeys() {
		int [] keys = {KeyEvent.VK_SPACE};
		return keys;
	}

	@Override
	public void keyDown(int key) {
		shoot();
		
	}

}
