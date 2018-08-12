import processing.core.PApplet; 
public class Score extends Message {
	PApplet parent;
//	public Score(String _msg, float _x, float _y, float _z, float _size) {
//		super(_msg, _x, _y, _z, _size);
//		// TODO Auto-generated constructor stub
//	}
	 Score(String _msg, float _x, float _y, float _z, float _size) {
		    super(_msg, _x, _y, _z, _size);
		    dx = 0;
		    dy = 0;
		    dz = 0;
		  }

		  public void show() {
		    parent.fill(255);
		    parent.textSize(size);
		    parent.text(msg, 40, 40, 0);
		  }

		  public void act() {
		    // Do nothing!
		  }

		  public boolean hasDied() {
		    return false;
		  }
}
