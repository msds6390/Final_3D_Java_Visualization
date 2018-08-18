import java.util.ArrayList;

import processing.core.PApplet;

public class StarSystem {
	PApplet parent;
	ArrayList<Star> stars;
	ArrayList<GameObject> engine;
	int numStars;

	public StarSystem() {}
	  
	public StarSystem(PApplet p){
		parent = p;
	    //engine = eng;
	    numStars = 400;
		stars = new ArrayList<Star>();  
	}
  
	public void addStar() {
		for (int i = 0; i < numStars; i ++) {
	      stars.add(new Star(parent, engine));
	    }  
	}
  
	public void run() {
	    for (int i = 0; i < stars.size(); i ++ ) {
	      Star s = stars.get(i);
	      s.update();
	      s.draw();
	    }  
	}
}
