import java.awt.event.KeyEvent;

public class SnakeGame {

	private SnakeModel model;
	private Food food;
	private Snake snake;
	private static double amount = 0.07;
	private boolean newfood = false;
	private static int speed = 100;
	private double direction; 
	private int score; 
	private static double foodsize = .03; 
	private static double snakesize = .04; 
	private static int snakecolor = 0; 

	public static final double LEFT = 1;
	public static final double RIGHT = 2; 
	public static final double UP = 3; 
	public static final double DOWN = 4; 
	
	

	public void setUp() {
		Location location = new Location(.15, .15);
		snake = new Snake(null, location);
		Location location2 = new Location(.18, .15);
		Snake snake2 = new Snake(null, location2);
		Location location3 = new Location(.21, .15);
		Snake snake3 = new Snake( null, location3);
		
		snake.setNext(snake2);
		snake2.setNext(snake3);
		snake3.setNext(null);
		
		snake.setHead(snake);
		snake.setTail(snake3);
		score = 0; 
		food = new Food(.45, .05);
		newfood = true;
		drawFood(); 

		drawSnake();
		 model = new SnakeModel();
		
	}
	
	public void drawFood() { 
		if (newfood) { 
			double newX= Math.random();
			double newY = Math.random(); 
			food.setX(newX);
			food.setY(newY);
		}
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.filledSquare(food.getX(), food.getY(), foodsize);
		newfood = false;
		
	}
	
	public void drawSnake() {
		Snake tester = snake.getHead();
		//StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.setPenColor(0, 255, snakecolor);
		while (tester.getNext()!= null) {
			StdDraw.filledCircle(tester.getLocation().getX(), tester.getLocation().getY(), snakesize);
		    tester = tester.getNext();
		}
	}
	
	public double move(Snake snake, double direction) {
		double x = 0; 
		double y = 0;
		
		if (StdDraw.isKeyPressed(KeyEvent.VK_W)) {direction = UP; }
		if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {direction = DOWN;}
		if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {direction = LEFT; }	 
		if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {direction = RIGHT; }
		
		if (direction == UP)   { y =  amount; }
		if (direction == RIGHT){ x =  amount; }
		if (direction == LEFT) { x = -amount; }
		if (direction == DOWN) { y = -amount; }
		
		Location newLocal = new Location(snake.getHead().getLocation().getX() + x , 
				snake.getHead().getLocation().getY() + y );

		snake.move(newLocal);
		StdDraw.clear(StdDraw.LIGHT_GRAY);
		StdDraw.enableDoubleBuffering();
		drawSnake();
		newfood = false;
		drawFood();
		StdDraw.text(.5, .05, "Score:" + score + " ");

		StdDraw.show();
		StdDraw.pause(speed);
		return direction;
	}
	
	public void run()  {
		StdDraw.clear(StdDraw.LIGHT_GRAY);
		StdDraw.setScale(-0.05, 1.05);
		StdDraw.setPenColor();
		StdDraw.text(.5, .25, "Please press the mouse to continue!");
		StdDraw.text(.5, .15, "you will use the W, A, S, and D keys to move the snake");

		while(!StdDraw.isMousePressed()) {}
		
		StdDraw.clear(StdDraw.LIGHT_GRAY);
		StdDraw.setPenColor();
		StdDraw.text(.8, .05, "Score:" + score + " ");
		StdDraw.show();

		setUp();
		while (!StdDraw.hasNextKeyTyped()) {
			StdDraw.enableDoubleBuffering();
			move(snake, RIGHT);
			if (model.gameOver(snake)) {return; }
			StdDraw.pause(speed);
		}
		while (!model.gameOver(snake)) { 
			StdDraw.enableDoubleBuffering();
			direction = move(snake, direction);
			StdDraw.pause(speed);
			StdDraw.enableDoubleBuffering();
			if (food.eaten(snake, food)) {
				snake.addBack(snake);
				newfood = true;
				score ++ ;
				speed -= 3;
				if (snakecolor<230) {snakecolor += 10;}
				if (foodsize>.008) {foodsize-=.0005;}
				drawFood();
					
				}
			}
		StdDraw.setPenColor();
		StdDraw.text(.5, .25, "You Lost :(");
	}
	
	public static void main(String[] args) {
		new SnakeGame().run();
	}
	
}
