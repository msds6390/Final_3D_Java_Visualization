import processing.core.PApplet;
public class BasicGun extends Gun {
	PApplet parent;
	BasicGun(PApplet parent) {
	    threshold = 50;  // rate of fire
	    cooldown = 0;
	}

}
