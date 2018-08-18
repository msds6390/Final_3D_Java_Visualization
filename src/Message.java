import java.util.ArrayList;

import processing.core.PApplet;

public class Message extends GameObject {
	PApplet parent;
	ArrayList<GameObject> engine;  
	float alpha;
	float size;
	String msg;
  
	Message(PApplet p, ArrayList<GameObject> eng, String _msg, float _x, float _y, float _z, float _size) {
		parent = p;
	    engine = eng;
		x = _x;
	    y = _y;
	    z = _z;
	    msg = _msg;
	    size = _size;
	    alpha = 1000;
	    //hasDied = false;
	    hp = 10;

	  }
  
	public void show() {
	    parent.fill(255, alpha);
	    parent.textSize(size);
	    parent.text(msg, x, y, z);  
	}
  
	public void act() {
	    //y = y + 3;
	    z = z + 3;
	    alpha = alpha - 3;
	    if (alpha <= 0) hp = 0;  
	}
  
	public boolean hasDied() {
	    return z > 100 || hp == 0;  
	}
}
