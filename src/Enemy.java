import java.util.ArrayList;

import processing.core.PApplet; 
public class Enemy extends GameObject {
	PApplet parent;
	ArrayList<GameObject> engine;
	public int score;
	public Enemy() {}

	public Enemy(PApplet p, ArrayList<GameObject> eng, float incomingX, float incomingY, float incomingZ) {
	    parent = p;
	    engine = eng;
		x = incomingX;
	    y = incomingY;
	    z = incomingZ;
	    dx = 0;
	    dy = 0;
	    dz = 10;
	    hp = 5;
	    //this.score = score;
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
	            engine.add(new Particle(parent, engine, thing.x, thing.y, thing.z));
	          }
	        }
	      }
	      // Make damage particles for ship
	      if (thing instanceof Ship) {
	        if (recRect(x, y, z, 40, 40, thing.x, thing.y, thing.z, 20, 20)) {
	          hp -= 1;
	          thing.hp -= 1;
	          for (int j = 0; j < 5; j++) {
	            engine.add(new Particle(parent, engine, thing.x, thing.y, thing.z));
	          }          
	        }
	      } 
	      i++;
	    }
	  }

	//private boolean recRect(float x, float y, float z, int i, int j, float x2, float y2, float z2, int k, int l) {
	private boolean recRect(float r1x, float r1y, float r1z, float r1h, float r1w, float r2x, float r2y, float r2z, float r2h, float r2w) {
		if (r1x + r1w >= r2x &&
				r1x <= r2x + r2w &&
		        r1y + r1h >= r2y &&
		        r1y <= r2y +r2h &&
		        r1z + r1w >= r2z &&
		        r1z <= r2z + r2w
		    ) {
		        return true;
		    }
		        return false;   
	}
	
	public boolean hasDied() {
		if (hp <= 0) {
			engine.add(new Message(parent, engine, "+10", x, y, z, 20));
			score += 10;
			return true;
	    }
	    return false;  
	}
}
