import java.util.ArrayList;
import processing.core.PApplet;

public abstract class Gun {
		PApplet parent;
		ArrayList<GameObject> engine;
		  // threshold how long it takes before you can shoot again (rate of fire)
		  // cooldown is how much you recharge so far
		  float cooldown, threshold;  
		  
		  public Gun() {}
		  
		  // default constructor
		  public Gun (PApplet p, ArrayList<GameObject> eng) {
			  parent = p;
			  engine = eng;
		  }
		  
		  // controls rate of fire
		  public void shoot() {
		    if (cooldown == threshold) {
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
