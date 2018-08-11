import processing.core.*; 
public class Launcher extends GameObject {

	//public Launcher() {
		// TODO Auto-generated constructor stub
	//}

	  Launcher() {
	    x = width/2;
	    y = height/2;
	    z = -10000;
	    dx = 0;
	    dy = 0;
	    dz = 0;
	  }

	  public void show() {
	    pushMatrix();
	    translate(x, y, z);
	    fill(100);
	    sphereDetail(5);
	    sphere(5);
	    popMatrix();
	  }

	  public void act() {
	    if (frameCount == 10 ) {
	      pushMatrix();
	      engine.add(new Message("LEVEL 1", width/2, height/4, -1000, 40));
	      popMatrix();
	    //} else if(score == 10) {
	    //  engine.add(new Message("LEVEL 2", width/2, height/4, -1000, 40));
	    //} else if(score == 20) {
	    //  engine.add(new Message("LEVEL 3", width/2, height/4, -1000, 40));
	    } else if (frameCount < 600) {
	      straightLine(100);
	    } else if (frameCount == 3000) {
	      pushMatrix();
	      engine.add(new Message("LEVEL 2", width/2, height/4, -1000, 40));
	      popMatrix();
	      straightLine(400);
	    } else if (frameCount < 2000) {
	      //doubleLine();
	      randomWave();
	    } else {
	      randomWave();
	    }
	  }

	  public void straightLine(float incomingX) {
	    x = incomingX;
	    if (frameCount % 100 == 0) {
	      engine.add(new Enemy(x, y, z));
	    }
	  }

	  public void doubleLine() {}

	  public void randomWave() {
	    x = random(50, width - 50);
	    y = random(50, height - 50);
	    if (frameCount % 100 == 0) {
	      engine.add(new FastEnemy(x, y, z));
	    }
	  }

	  public boolean hasDied() {
	    return false;
	  }

}
