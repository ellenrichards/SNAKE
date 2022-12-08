
public class SnakeModel {

	private Snake snake;
	private int score;

	public int getScore() {
		return score; 
	}
	
	public void setScore(int score) {
		this.score = score;
	}	
	
	//Noshad helped me get this part set up in office hours
	public void SnakeModel() {
		score = 0 ; 
	}
	
	public void setUp() {
		Location location = new Location(1.25, 1.25);
		snake.setLocation(location);
		Location location2 = new Location(1.25, 1.15);
		Snake snake2 = new Snake(null, location2);
		snake.setNext(snake2);
		snake.setHead(snake);
		snake.setTail(snake2);
	}
	
	public boolean gameOver(Snake snake) {	
		Snake tester = null;
		if (snake.getHead().getNext().getNext() != null) 
			 tester = snake.getHead().getNext().getNext();
		else	 
			return outofBounds(snake);
		while (tester!= null){
			if ((Math.abs(tester.getLocation().getX() - snake.getHead().getLocation().getX()) <=.01) &&
				(Math.abs(tester.getLocation().getY() - snake.getHead().getLocation().getY()) <=.01 )) {
				return true;}
		    tester = tester.getNext();
		}
		return outofBounds(snake);
		}
	
	public boolean outofBounds(Snake snake) {
		if (( snake.getHead().getLocation().getX() < -0.05 ) || 
			( snake.getHead().getLocation().getX() > 1.05 ) ||
			( snake.getHead().getLocation().getY() < -0.05 ) || 
			( snake.getHead().getLocation().getY() > 1.05 )) {
		return true; 
	};
	return false;
	}
	
}
