import java.util.ArrayList;

import processing.core.PApplet; 
public class Ship extends GameObject {
	PApplet parent;
	ArrayList<GameObject> engine;
	boolean upKey;
	boolean leftKey;
	boolean downKey;
	boolean rightKey;
	boolean spaceKey;
	boolean forwardKey;
	boolean backwardKey;
	Gun myGun;
	int shipSpeed;
//	public Ship() {
//		// TODO Auto-generated constructor stub
//	}

	public Ship() {}

	  // constructor
	  public Ship(PApplet p, ArrayList<GameObject> eng) {
		parent = p;
		engine = eng;
	    x = parent.width/2;  // start at center of screen
	    y = parent.width/2;  // start at center of screen
	    z = parent.width/2;
	    dx = 0;
	    dy = 0;
	    dz = 0;
	    hp = 20;
	    size = 20;
	    //myGun = new BasicGun();
	    //myGun = new MachineGun();
	    myGun = new vGun();
	    shipSpeed = 5;
	  }

	  // 3 methods (functions)
	  public void show() {
		  parent.pushMatrix();
	    //fill(250, 240, 142);
	    //fill(electricgreen);
		  parent.fill(0xff05CBFA); //spacecadet
		  parent.translate(x, y, z);
		  parent.box(size);
		  parent.popMatrix();
	  }

	  public void act() {
	    dx = 0;
	    dy = 0;
	    dz = 0;

	    // lefty or righty player
	    if (upKey) dy = -shipSpeed;  // can make -5 into a speed variable
	    if (leftKey) dx = -shipSpeed;
	    if (downKey) dy = shipSpeed;
	    if (rightKey) dx = shipSpeed;
	    if (forwardKey) dz = -shipSpeed;
	    if (backwardKey) dz = shipSpeed;

	    //if (spaceKey & frameCount % 5 == 0) engine.add(new Bullet());
	    if (spaceKey) myGun.shoot();

	    // movement
	    x = x + dx;
	    y = y + dy;
	    z = z + dz;
	    myGun.recharge();
	  }

	  public boolean hasDied() {
	    if (hp <= 0) {
	      return true;
	    }
	    return false;
	  }
}
