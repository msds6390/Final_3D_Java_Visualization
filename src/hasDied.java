import processing.core.*; 
public class hasDied extends GameObject {

	public boolean hasDied() {
	    if (dz > 100 || hp <= 0) {
	        score += 10;
	        engine.add(new Message("+10", x, y, z, 10));
	        //int k = 0;
	        //while (k < engine.size()) {
	        //  GameObject thing = engine.get(k);
	        //  if (thing instanceof Score) {
	        //    engine.remove(k);
	        //  }
	        //}
	        //engine.add(new Score(str(score), 20, 20, 0, 40));
	        return true;
	      } else {
	        return false;
	      }
	}

}
