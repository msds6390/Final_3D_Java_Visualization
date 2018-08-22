import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class MyVideoGame extends PApplet {
	/*
	 MSDS 6390 Final Assignment
	 Arcade Game- Space Shooter
	 Team: Jostein Barry-Straume, Brian Yu
	 Date: 08/11/18
	 Sources:
	 https://www.youtube.com/watch?v=MJh3blPxcQw
	 */

	public int lightblue = 0xff67D4FF;
	public int darkblue = 0xff2F6A96;
	public int orange = 0xffEE7036;
	public int spacecadet = 0xff05CBFA; // https://rgbcolorcode.com/color/space-cadet
	public int electricgreen = 0xff00E600;
	public int outerspace = 0xff414A4C;
	//color outerSpaceBlack = #000000;
	public int deepspacesparkle = 0xff4A646C;
	//color deepSpaceSparkleWhite = #ffffff;
	//color darkOrange = #AA5012;

	public Ship myShip;
	public StarSystem ss;
	public Star star;
	public Star[] stars;

	public int numStars = 400;
	public int timer = 0;
//	public float shipSpeed = 5;
	public int shipSpeed = 5;
	public ArrayList<GameObject> engine;    // ArrayList that stores many different types of objects - bullets, spaceships, particle effects, etc.
	                                 // data structure that holds things needed to be processed
	public boolean upKey;
	public boolean leftKey;
	public boolean downKey;
	public boolean rightKey;
	public boolean spaceKey;
	public boolean forwardKey;
	public boolean backwardKey;
	public static int score;

	public void setup() {
	  textAlign(CENTER);
	  
	  stroke(0);
	  strokeWeight(1);
	  score = 0;
	  ss = new StarSystem(this);
	  ss.addStar();
	  engine = new ArrayList<GameObject>(10000); // instantiate the list - Arbitrary number of objects to create
	  rectMode(CENTER);
	  myShip = new Ship(this, engine);  // instantiate the space ship
	  engine.add(myShip);
	  engine.add(new Launcher(this, engine));
	}

	public void draw() {
	  lights();
	  background(outerspace);
	  if (myShip.hasDied()) {
	    fill(175, 0, 42);
	  }
	  textSize(40);
	  text(str(score), 40, 40);
	  if (myShip.hasDied()) {
	    pushMatrix();
	    translate(width/2, height/2, 0);
	    stroke(255);
	    fill(175, 0, 42);
	    textSize(80);
	    text("GAME OVER", 0, 0);
	    stroke(0);
	    popMatrix();
	  }
	  
	  pushMatrix();
	  translate(0.5f*width, 0.5f*height);
	  ss.run();
	  popMatrix();

	  // every game will animate all the game objects and how to make decisions
	  int i = engine.size() - 1;  // traversing from last index to first
	  while (i >= 0) {
	    GameObject obj = engine.get(i);
	    obj.show();
	    obj.act();
	    if (obj.hasDied()) {
	      engine.remove(i);
	    }
	    i--;
	  }
	}

	// keyboard direction
	public void keyPressed() {
	  // lefty or righty control
	  if (key == 'w' || key == 'W' || key == '5') {myShip.upKey = true;}
	  if (key == 'a' || key == 'A' || key == '1') {myShip.leftKey = true;}
	  if (key == 's' || key == 'S' || key == '2') {myShip.downKey = true;}
	  if (key == 'd' || key == 'D' || key == '3') {myShip.rightKey = true;}
	  if (key == 'e' || key == 'E' || key == '6') {myShip.forwardKey = true;}
	  if (key == 'q' || key == 'Q' || key == '4') {myShip.backwardKey = true;}
	  if (key == ' ') {myShip.spaceKey = true;}
	}

	public void keyReleased() {
	  // lefty or righty control
	  if (key == 'w' || key == 'W' || key == '5') {myShip.upKey = false;}
	  if (key == 'a' || key == 'A' || key == '1') {myShip.leftKey = false;}
	  if (key == 's' || key == 'S' || key == '2') {myShip.downKey = false;}
	  if (key == 'd' || key == 'D' || key == '3') {myShip.rightKey = false;}
	  if (key == 'e' || key == 'E' || key == '6') {myShip.forwardKey = false;}
	  if (key == 'q' || key == 'Q' || key == '4') {myShip.backwardKey = false;}  
	  if (key == ' ') {myShip.spaceKey = false;}
	}
	
	public void settings() {  size(600, 600, P3D);  smooth(); }
	  static public void main(String[] passedArgs) {
	    String[] appletArgs = new String[] { "MyVideoGame" };
	    if (passedArgs != null) {
	      PApplet.main(concat(appletArgs, passedArgs));
	    } else {
	      PApplet.main(appletArgs);
	    }
	  }
	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	//}

}
