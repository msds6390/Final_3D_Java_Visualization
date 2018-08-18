import java.util.ArrayList;

import processing.core.PApplet; 
public class Score extends Message {
	PApplet parent;
	ArrayList<GameObject> engine;
	public int score;
//	public Score(String _msg, float _x, float _y, float _z, float _size) {
//		super(_msg, _x, _y, _z, _size);
//		// TODO Auto-generated constructor stub
//	}
	 public Score(PApplet p, ArrayList<GameObject> eng, String _msg, float _x, float _y, float _z, float _size) {
		    super(p, eng, _msg, _x, _y, _z, _size);
		    parent = p;
		    engine = eng;
		    dx = 0;
		    dy = 0;
		    dz = 0;	  
	 }
	  
	 public void show() {   
		 parent.fill(255);   
		 parent.textSize(size);   
		 //parent.text(msg, 40, 40, 0);	  
		 parent.text(score, 40, 40, 0);
	 }
	  
	 public void act() {
		    // Do nothing!	  
	 }
	  
	 public boolean hasDied() {   
		 return false;	  
	 }
}
