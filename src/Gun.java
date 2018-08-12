import processing.core.PApplet; 
public abstract class Gun {
		PApplet parent;
		  // threshold how long it takes before you can shoot again (rate of fire)
		  // cooldown is how much you recharge so far
		  float cooldown, threshold;  
		  
		  // default constructor
		  Gun () {
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
