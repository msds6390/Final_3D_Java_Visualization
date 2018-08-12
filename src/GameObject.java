import processing.core.PApplet; 
// Source:
// https://www.youtube.com/watch?v=MJh3blPxcQw
// https://www.youtube.com/watch?v=PpfVEEsR8_M
// Category of things, not an actual 'thing' created in the game, hence abstract class
public abstract class GameObject {
	PApplet parent;
	float x, y, z, dx, dy, dz, hp, size;
	  
	GameObject() {
	}
	  
	public void show() {
	}
	  
	public void act() {
	}
	  
	public boolean hasDied() {
	  return false;
	}
}
