package proj3;
public class Quad {
    
	public double xmid;
	public double ymid;
	public double length;
	
    // create a new square with the given parameters (assume it is square)
    public Quad(double xmid, double ymid, double length) {
    	this.xmid = xmid;
    	this.ymid = ymid;
    	this.length = length;
    }

    // return the length of one side of the square quadrant
    public double length() {
    	return length;
    }

    // does quadrant contain (x, y)?
    public boolean contains(double x, double y) {
    	double midlength = this.length / 2.0;
    	return(x <= this.xmid + midlength &&
    		   y <= this.ymid + midlength &&
    		   x >= this.xmid - midlength &&
    		   y >= this.ymid - midlength);
    		   
    }

    // return a new object that represents the northwest quadrant
    public Quad NW() {
    	double x = this.xmid - this.length/4.0;
    	double y = this.ymid + this.length/4.0;
    	double newLen = this.length/2.0;
    	Quad NW = new Quad(x, y, newLen);
    	return NW;
    }
    
    // return a new object that represents the northeast quadrant
    public Quad NE() {
    	double x = this.xmid + this.length/4.0;
    	double y = this.xmid + this.length/4.0;
    	double newLen = this.length/2.0;
    	Quad NE = new Quad(x, y, newLen);
    	return NE;
    }

    // return a new object that represents the southwest quadrant
    public Quad SW() {
    	double x = this.xmid - this.length/4.0;
    	double y = this.xmid - this.length/4.0;
    	double newLen = this.length/2.0;
    	Quad SW = new Quad(x, y, newLen);
    	return SW;
    }

    // return a new object that represents the southeast quadrant
    public Quad SE() {
    	double x = this.xmid + this.length/4.0;
    	double y = this.xmid - this.length/4.0;
    	double newLen = this.length/2.0;
    	Quad SE = new Quad(x, y, newLen);
    	return SE;
    }

    // draw an unfilled rectangle that represents the quadrant
    public void draw() {
    	StdDraw.rectangle(xmid, ymid, this.length / 2.0 , this.length / 2.0);
    }

    // return a string representation of the quadrant for debugging
  
    public String toString() {
    	for(int i = 1; i <= this.length; i++){  
    		for(int j = 1; j <= this.length; j++){
    			if(i ==1 || i == this.length || j == 1 || j == this.length){
    				System.out.print("*");
    			}
    			else{
    				System.out.print(" ");
    			}
    		}
    		System.out.println();
  	  	}
	return " "; 
    }
}

