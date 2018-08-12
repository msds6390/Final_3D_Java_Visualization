import processing.core.PApplet; 
public class Launcher extends GameObject {
	PApplet parent;
	//public Launcher() {
		// TODO Auto-generated constructor stub
	//}

	  Launcher() {
	    x = parent.width/2;
	    y = parent.height/2;
	    z = -10000;
	    dx = 0;
	    dy = 0;
	    dz = 0;
	  }

	  public void show() {
		parent.pushMatrix();
		parent.translate(x, y, z);
		parent.fill(100);
		parent.sphereDetail(5);
		parent.sphere(5);
		parent.popMatrix();
	  }

	  public void act() {
	    if (parent.frameCount == 10 ) {
	      parent.pushMatrix();
	      engine.add(new Message("LEVEL 1", parent.width/2, parent.height/4, -1000, 40));
	      parent.popMatrix();
	    //} else if(score == 10) {
	    //  engine.add(new Message("LEVEL 2", width/2, height/4, -1000, 40));
	    //} else if(score == 20) {
	    //  engine.add(new Message("LEVEL 3", width/2, height/4, -1000, 40));
	    } else if (parent.frameCount < 600) {
	      straightLine(100);
	    } else if (parent.frameCount == 3000) {
	      parent.pushMatrix();
	      engine.add(new Message("LEVEL 2", parent.width/2, parent.height/4, -1000, 40));
	      parent.popMatrix();
	      straightLine(400);
	    } else if (parent.frameCount < 2000) {
	      //doubleLine();
	      randomWave();
	    } else {
	      randomWave();
	    }
	  }

	  public void straightLine(float incomingX) {
	    x = incomingX;
	    if (parent.frameCount % 100 == 0) {
	      engine.add(new Enemy(x, y, z));
	    }
	  }

	  public void doubleLine() {}

	  public void randomWave() {
	    x = parent.random(50, parent.width - 50);
	    y = parent.random(50, parent.height - 50);
	    if (parent.frameCount % 100 == 0) {
	      engine.add(new FastEnemy(x, y, z));
	    }
	  }

	  public boolean hasDied() {
	    return false;
	  }
}
