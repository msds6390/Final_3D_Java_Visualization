import java.util.ArrayList;
import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

import processing.core.*;
public class StarSystem {

	 ArrayList<Star> stars;

	  StarSystem(){
	    stars = new ArrayList<Star>();
	  }

	  public void addStar() {
	    for (int i = 0; i < numStars; i ++) {
	      stars.add(new Star());
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
