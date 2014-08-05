package audible.catalog.coordinates;

public class CoordinatePair {

	Coordinates one= null;
	Coordinates two = null;
	
	public int size(){
		if (one == null && two == null){
			return 0;
		} else if (two == null){
			return 1;
		} else {
			return 2;
		}
	}
	public CoordinatePair(Coordinates one, Coordinates two){
		this.one = one;
		this.two = two;
		
	}
	
	public double distance(){
		if (one == null && two == null){
			return -1;
		} else if (two == null){
			return -1;
		} else {
			return 
				Math.sqrt((one.x-two.x)*(one.x -two.x) + (one.y-two.y)*(one.y-two.y));
		}
	}
	
	public CoordinatePair(double x1, double y1, double x2, double y2){
		this.one = new Coordinates(x1,y1);
		this.two = new Coordinates(x2,y2);
		
	}
	
}
