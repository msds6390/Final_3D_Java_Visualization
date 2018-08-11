import processing.core.*;


public class Message extends GameObject {

	//public Message() {
		// TODO Auto-generated constructor stub
	//}


	  float alpha;
	  float size;
	  String msg;


	  Message(String _msg, float _x, float _y, float _z, float _size) {
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
	    fill(255, alpha);
	    textSize(size);
	    text(msg, x, y, z);
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
