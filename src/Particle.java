import java.util.ArrayList;

import processing.core.PApplet; 
public class Particle extends GameObject {
	PApplet parent;
	ArrayList<GameObject> engine;
	public Particle() {}
	 
	public Particle(PApplet p, ArrayList<GameObject> eng, float incomingX, float incomingY, float incomingZ) {    
		parent = p;
	    engine = eng;
	 	x = incomingX;
	    y = incomingY;
	    z = incomingZ;
	    dz = parent.random(-5, 5);
	    dy = parent.random(-5, 5);
	    dz = parent.random (-5, 5);
	    hp = parent.random(100, 255);  
	}
	  
	public void show() {
		parent.pushMatrix();
		parent.translate(x, y, z);
		parent.fill(0xffEE7036, hp); // orange
	    parent.box(3);
	    parent.popMatrix();	  
	}
	  
	public void act() {
	    x = x + dx;
	    y = y + dy;
	    z = z + dz;
	    hp = hp - 2;	  
	}
	
	public boolean hasDied() {    
		return hp <= 0;	  
	}
}
