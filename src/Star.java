import processing.core.PApplet; 

public class Star extends GameObject {
	PApplet parent;
	 // Star coordinates in 3D
	  float x;
	  float y;
	  float z;

	  //constructor
	  Star(PApplet p) {
		parent = p;
	    x = parent.random(-5000, 5000);  // initialize x pos
	    y = parent.random(-5000, 5000);  // initialize y pos
	    z = parent.random(0, 2000);      // initialize z pos
	    dx = 0;
	    dy = 0;
	    dz = 0;
	  }

	  public void update() {
	    z-=10;        // Move star closer to viewport
	    if (z <= 0.0f) // Reset star if it passes viewport
	      reset();
	  }

	  public void reset() {
	    // Reset star to a position far away
	    x = parent.random(-5000, 5000);
	    y = parent.random(-5000, 5000);
	    z = 2000.0f;
	  }

	  public void draw() {

	    // Project star only viewport
	    float offsetX = 100.0f*(x/z);
	    float offsetY = 100.0f*(y/z);
	    float scaleZ = 0.0001f*(2000.0f-z);

	    // Draw this star - illusion of depth
	    parent.pushMatrix();
	    parent.translate(offsetX, offsetY);
	    parent.scale(scaleZ);
	    parent.fill(0xff4A646C); // deepspacesparkle
	    parent.ellipse(0,0,40,40);
	    parent.popMatrix();
	  }
}
