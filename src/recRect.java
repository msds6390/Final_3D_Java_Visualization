import java.util.ArrayList;

import processing.core.PApplet;
public class recRect {
	PApplet parent;
	ArrayList<GameObject> engine;
	boolean collision;
	public recRect() {}
	//public recRect(PApplet p) {
	//	parent = p;
	//}
	public recRect(PApplet p, ArrayList<GameObject> eng, float r1x, float r1y, float r1z, float r1h, float r1w, float r2x, float r2y, float r2z, float r2h, float r2w) {
		parent = p;
		engine = eng;
		if (r1x + r1w >= r2x &&
			r1x <= r2x + r2w &&
	        r1y + r1h >= r2y &&
	        r1y <= r2y +r2h &&
	        r1z + r1w >= r2z &&
	        r1z <= r2z + r2w
	    ) {
	        collision = true;
	    }
	        collision = false;    
	}
}

