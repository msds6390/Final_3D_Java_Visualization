import java.util.ArrayList;

import processing.core.PApplet;
public class MachineGun extends Gun {
	PApplet parent;
	ArrayList<GameObject> engine;
	public MachineGun(PApplet p, ArrayList<GameObject> eng) {
	    parent = p;
	    engine = eng;
		threshold = 10;  // rate of fire
	    cooldown = 0;
	}

}
