package proj3;
import java.awt.Color;

public class NBody {			

    public static void main(String[] args) {		
    	String fileName  = args[0];
    	In in = new In(fileName);
    	
        final double dt = .1;                 
        int N = in.readInt();                  
        double radius = in.readDouble();        

        StdDraw.show(0);
        StdDraw.setXscale(-radius, +radius);
        StdDraw.setYscale(-radius, +radius);

        
        Body[] bodies = new Body[N];        
        for (int i = 0; i < N; i++) {
            double px   = in.readDouble();
            double py   = in.readDouble();
            double vx   = in.readDouble();
            double vy   = in.readDouble();
            double mass = in.readDouble();
            int red     = in.readInt();
            int green   = in.readInt();
            int blue    = in.readInt();
            Color color = new Color(red, green, blue);
            bodies[i]   = new Body(px, py, vx, vy, mass, color);
        }

    	Quad quad  = new Quad (0, 0, radius * 2);
    	BHTree universe = new BHTree(quad);
    	
    	for (int i = 0; i < N; i++)
    		universe.insert(bodies[i]);
    	
        for (double t = 0.0; true; t = t + dt) {

            for (int i = 0; i < N; i++) {
                bodies[i].resetForce();
                universe.updateForce(bodies[i]);
            }

            for (int i = 0; i < N; i++) {
                bodies[i].update(dt);
            }

            StdDraw.clear(StdDraw.BLACK);
            for (int i = 0; i < N; i++) {
                bodies[i].draw();
            }
            StdDraw.show(10);

        }
    }
}