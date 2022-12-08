
public class Snake {
	/** Some of the general structure of this Snake class was based on the games Pong (Ball), Focus (Deque), Asteroid Rally, and Questions*/

	private Snake tail; 
	private Snake next;
	private Snake head;
	public Location location; 
	public static final double LEFT = 1;
	public static final double RIGHT = 2; 
	public static final double UP = 3; 
	public static final double DOWN = 4; 
	public double amount = 0.05;

		
	public Snake(Snake next, Location location) {
		this.next=next;
		this.location = location; 
		}
	
	//Shannon helped a lot with this section: 
	public void move(Location l) {
		Location prev = new Location(this.getLocation().getX(), this.getLocation().getY());
		this.setLocation(l);
		if(this.getNext()!=null) {
			this.getNext().move(prev);
		}
	}
	
	public Snake getTail() {
		return tail;}
	
	public Snake getNext() {
		return next;}
	
	public Snake getHead() {
		return head;}
	
	public Location getLocation(){
		return location;}
		
	public void setNext(Snake next){
		this.next = next; }
	
	public void setTail(Snake tail){
		this.tail = tail;}

	public void setHead(Snake head) {
		this.head = head;}
	
	public void setLocation(Location location){
		this.location = location; }
		
	public void addBack(Snake snake) {
		getTail().setNext(new Snake(null, getTail().getLocation()));
		setTail(getTail().getNext());
	}

	public double counter(Snake snake) {
		Snake tester = snake.getHead();
		double counter = 0; 
		while (tester != null) {
			counter ++;
			tester = tester.getNext();
		}
		return counter;
	}
	
}
