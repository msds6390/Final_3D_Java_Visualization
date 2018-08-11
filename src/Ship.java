import processing.core.*; 
public class Ship extends GameObject {

//	public Ship() {
//		// TODO Auto-generated constructor stub
//	}

	  Gun myGun;

	  // constructor
	  Ship() {
	    x = width/2;  // start at center of screen
	    y = width/2;  // start at center of screen
	    z = width/2;
	    dx = 0;
	    dy = 0;
	    dz = 0;
	    hp = 20;
	    size = 20;
	    //myGun = new BasicGun();
	    //myGun = new MachineGun();
	    myGun = new vGun();
	  }

	  // 3 methods (functions)
	  public void show() {
	    pushMatrix();
	    //fill(250, 240, 142);
	    //fill(electricgreen);
	    fill(spacecadet);
	    translate(x, y, z);
	    box(size);
	    popMatrix();
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
	      //for (int j = 0; j < 5; j++) {
	      //  engine.add(new Particle(x, y, z));
	      //}
	      //fill(175, 0, 42);
	      //textSize(80);
	      //text("GAME OVER", 0, 0);
	      //pushMatrix();
	      //translate(0, 0, 0);
	      //engine.add(new Message("GAME OVER", 0, 0, -500, 40));
	      //popMatrix();
	      return true;
	    }
	    return false;
	  }
}
