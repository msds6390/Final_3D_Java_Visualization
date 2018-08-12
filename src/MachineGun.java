import processing.core.PApplet;
public class MachineGun extends Gun {
	PApplet parent;
	public MachineGun() {
	    threshold = 10;  // rate of fire
	    cooldown = 0;
	}

}
