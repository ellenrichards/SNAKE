import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class SnakeModelTest {

	private SnakeModel model;
	private Snake snake; 

	public static final double LEFT = 1;
	public static final double RIGHT = 2; 
	public static final double UP = 3; 
	public static final double DOWN = 4; 
	
	@Before
	public void setUp() throws Exception {
		
		model = new SnakeModel();
		Location location = new Location(.3, .3);
		snake = new Snake(null, location);
		snake.setLocation(location);
		snake.setHead(snake);
		
		Location location2 = new Location(.3, .2);
		Snake snake2 = new Snake(null, null);
		snake2.setLocation(location2);
		snake.setNext(snake2);
		
		Location location3 = new Location(.3, .2);
		Snake snake3 = new Snake(null, null);
		snake3.setLocation(location3);
		snake.setTail(snake3);
		snake2.setNext(snake3);
	}
	
	@Test
	public void isGameOver() {
		Location location = new Location(.4, .5);
		Snake snake1 = new Snake(null, location);
		
		Location location2 = new Location(.6, .85);
		Snake snake2 = new Snake(null, location2);
		
		Location location3 = new Location(.7, 1.0);
		Snake snake3 = new Snake(null, location3);
		
		snake1.setNext(snake2);
		snake2.setNext(snake3);
		snake1.setHead(snake1);
		snake1.setTail(snake3);
		
		assertFalse(model.gameOver(snake1));
	}
	@Test
	public void isOOO() { 
		Location location3 = new Location(.3, .3);
		Snake snake3 = new Snake(null, location3);
		Location location4 = new Location(1, 0);
		Snake snake4 = new Snake(null, location4);
		snake3.setNext(snake4);
		snake3.setHead(snake3);
		snake3.setTail(snake4);
		assertFalse(model.outofBounds(snake3));
	}
	

}