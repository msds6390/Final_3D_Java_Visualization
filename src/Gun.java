import java.util.ArrayList;
import processing.core.PApplet;

public abstract class Gun {
		PApplet parent;
		ArrayList<GameObject> engine;
		  // threshold how long it takes before you can shoot again (rate of fire)
		  // cooldown is how much you recharge so far
		float cooldown, threshold;  
		Ship myShip;
		    
		public Gun() {}
		      
		public Gun (PApplet p, ArrayList<GameObject> eng, Ship ship) {  
			parent = p;  
			engine = eng;  
			myShip = ship;
		}
		    
		// controls rate of fire  
		public void shoot() {
			if (cooldown == threshold) {
		      //engine.add(new Bullet(parent, engine, myShip));
		      engine.add(new Bullet());
				cooldown = 0;
		    }  
		}
		    
		public void recharge() {
		    if (cooldown < threshold) {
		      cooldown++;
		    }  
		}
}
