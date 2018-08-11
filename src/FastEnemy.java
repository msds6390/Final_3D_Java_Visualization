
public class FastEnemy extends Enemy {

	public FastEnemy(float incomingX, float incomingY, float incomingZ) {
		super(incomingX, incomingY, incomingZ);
	    dz = 30;  // increasing speed (10 for regular enemy)
	}

}
