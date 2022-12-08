//import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class SnakeTest {
	
	private static final double DELTA = 0.001;
	private Snake snake;

	public static final double LEFT = 1;
	public static final double RIGHT = 2; 
	public static final double UP = 3; 
	public static final double DOWN = 4; 

	@Before
	public void setUp() throws Exception {
		Location location = new Location(.3, .3);
		snake = new Snake(null, location);
		snake.setHead(snake);
		
		Location location2 = new Location(.3, .2);
		Snake snake2 =  new Snake(null, location2);
		snake.setNext(snake2);
		snake.setTail(snake.getNext());
	}
	@Test 
	public void storesInitialTail() {
		assertEquals(snake.getNext(), snake.getTail());
	}

	
	@Test 
	public void storesInitialNext() {
		assertEquals(snake.getNext(), snake.getNext());
		assertEquals(null, snake.getNext().getNext());
	}
	
	@Test 
	public void storesInitialHead() {
		assertEquals(snake, snake.getHead());
	}
	
	@Test 
	public void storesInitialLocation() {
		assertEquals(.3, snake.getLocation().getX(), DELTA);
		assertEquals(.3, snake.getLocation().getY(), DELTA );
		assertEquals(.3, snake.getNext().getLocation().getX(), DELTA );
		assertEquals(.2, snake.getNext().getLocation().getY(), DELTA );
	}
	
	@Test
	public void addBack() { 
		assertEquals(2, snake.counter(snake), DELTA);
		snake.addBack(snake);
		assertEquals(3, snake.counter(snake), DELTA);
		snake.addBack(snake);
		snake.addBack(snake);
		assertEquals(5, snake.counter(snake), DELTA);
	}
	
//	Location prev = new Location(this.getLocation().getX(), this.getLocation().getY());
//	this.setLocation(l);
//	if(this.getNext()!=null) {
//		this.getNext().move(prev);
//	
	
	@Test
	public void doesItMove() {
		Location location2 = new Location(snake.getHead().getLocation().getX()+.1, snake.getHead().getLocation().getY()+.1);
		snake.move(location2);
		assertEquals(snake.getHead().getLocation().getY()-.1, snake.getNext().getLocation().getX(), DELTA);
		assertEquals(snake.getHead().getLocation().getX()-.1, snake.getNext().getLocation().getY(), DELTA);
	}
}
