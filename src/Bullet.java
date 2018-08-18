import java.util.ArrayList;

import processing.core.PApplet; 
public class Bullet extends GameObject {
	PApplet parent;
	ArrayList<GameObject> engine;
	Ship myShip; // Not sure this will call the ship, Java may not have global variables
	  // default constructor
	  public Bullet() {
	    x = myShip.x;
	    y = myShip.y;
	    z = myShip.z;
	    dx = 0;
	    dy = 0;
	    dz = -10;
	    hp = 1;
	  }
	  
	  // overloaded constructor
	  public Bullet(PApplet p, ArrayList<GameObject> eng, float incomingDX, float incomingDY, float incomingDZ) {
	    parent = p;
	    engine = eng;
		x = myShip.x;
	    y = myShip.y;
	    z = myShip.z;
	    dx = incomingDX;
	    dy = incomingDY;
	    dz = incomingDZ;
	    dz = -10;
	    hp = 1;
	  }

	  public void show() {
	    parent.pushMatrix();
	    parent.translate(x, y, z);
	    //fill(250, 240, 142);
	    parent.fill(0xff00E600); // electric green
	    parent.box(5);
	    parent.popMatrix();
	  }

	  public void act() {
	    x = x + dx;
	    y = y + dy;
	    z = z + dz;
	  }

	  public boolean hasDied() {
	    return z < -10000 || hp <= 0;
	  }
}
