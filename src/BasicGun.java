import java.util.ArrayList;

import processing.core.PApplet;
public class BasicGun extends Gun {
	PApplet parent;
	ArrayList<GameObject> engine;
	BasicGun(PApplet p, ArrayList<GameObject> eng) {
		parent = p;
		engine = eng;
	    threshold = 50;  // rate of fire
	    cooldown = 0;
	}

}
