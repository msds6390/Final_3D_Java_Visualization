import java.util.ArrayList;

import processing.core.PApplet; 
public class Enemy extends GameObject {
	PApplet parent;
	ArrayList<GameObject> engine;
	public Enemy() {}
	  public Enemy(PApplet p, ArrayList<GameObject> eng, float incomingX, float incomingY, float incomingZ) {
	    parent = p;
	    engine = eng;
		x = incomingX;
	    y = incomingY;
	    z = incomingZ;
	    dx = 0;
	    dy = 0;
	    dz = +10;
	    hp = 5;
	  }
	  
	  public void show() {
	    parent.pushMatrix();
	    parent.translate(x, y, z);
	    parent.fill(0xffEE7036); // orange
	    parent.box(40);
	    parent.popMatrix();
	  }
	  
	  public void act() {
	    x = x + dx;
	    y = y + dy;
	    z = z + dz;
	    
	    // Forgive me for this for-loop
	    int i = 0;
	    while (i < engine.size()) {
	      GameObject thing = engine.get(i);
	      if (thing instanceof Bullet) {
	        if (recRect(x, y, z, 40, 40, thing.x, thing.y, thing.z, 5, 5)) {
	          hp -= 1;
	          thing.hp = 0;
	          for (int j = 0; j < 5; j++) {
	            engine.add(new Particle(thing.x, thing.y, thing.z));
	          }
	        }
	      }
	      // Make damage particles for ship
	      if (thing instanceof Ship) {
	        if (recRect(x, y, z, 40, 40, thing.x, thing.y, thing.z, 20, 20)) {
	          hp -= 1;
	          thing.hp -= 1;
	          for (int j = 0; j < 5; j++) {
	            engine.add(new Particle(thing.x, thing.y, thing.z));
	          }          
	        }
	      } 
	      i++;
	    }
	  }
}
