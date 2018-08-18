import java.util.ArrayList;

import processing.core.PApplet; 
public class FastEnemy extends Enemy {
	PApplet parent;
	ArrayList<GameObject> engine;
	public FastEnemy(PApplet p, ArrayList<GameObject> eng, float incomingX, float incomingY, float incomingZ) {
		super(incomingX, incomingY, incomingZ);
		parent = p;
		engine = eng;
	    dz = 30;  // increasing speed (10 for regular enemy)
	}

}
