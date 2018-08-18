import java.util.ArrayList;

import processing.core.PApplet;
public class BasicGun extends Gun {
	PApplet parent;
	ArrayList<GameObject> engine;
	Ship myShip;
	public BasicGun(){}
	public BasicGun(PApplet p, ArrayList<GameObject> eng, Ship ship) {
		parent = p;
		engine = eng;
		myShip = ship;
	    threshold = 50;  // rate of fire
	    cooldown = 0;
	}

}
