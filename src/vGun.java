import java.util.ArrayList;

import processing.core.PApplet;
public class vGun extends Gun {
	PApplet parent;
	ArrayList<GameObject> engine;
	Ship myShip;
	public vGun() {}
	
	public vGun(PApplet p, ArrayList<GameObject> eng, Ship ship) {
		parent = p;    
		engine = eng;
		myShip = ship;
		threshold = 10;
		cooldown = 0;
	}

	// polymorphism - overrides the void shoot
	public void shoot() {
		if (cooldown == threshold) {
			//Bullet(float incomingDX, float incomingDY, float incomingDZ)
		    engine.add(new Bullet(parent, engine, myShip, 2, 0, -100));
		    engine.add(new Bullet(parent, engine, myShip, -2, 0, -100));
		    cooldown = 0;  //to recharge
		}
	}
}
