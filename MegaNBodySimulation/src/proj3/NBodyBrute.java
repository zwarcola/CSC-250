package proj3;
import java.awt.Color;

public class NBodyBrute {

    public static void main(String[] args) {
        final double dt = 0.1;                     // time quantum
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();                   // number of particles
        double radius = in.readDouble();        // radius of universe

        // turn on animation mode and rescale coordinate system
        StdDraw.show(0);
        StdDraw.setXscale(-radius, +radius);
        StdDraw.setYscale(-radius, +radius);

        // read in and initialize bodies
        Body[] bodies = new Body[N];               // array of N bodies
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


        // simulate the universe
        for (double t = 0.0; true; t = t + dt) {

            // update the forces
            for (int i = 0; i < N; i++) {
                bodies[i].resetForce();
                for (int j = 0; j < N; j++) {
                    if (i != j) bodies[i].addForce(bodies[j]);
                }
            }

            // update the bodies
            for (int i = 0; i < N; i++) {
                bodies[i].update(dt);
            }

            // draw the bodies
            StdDraw.clear(StdDraw.BLACK);
            for (int i = 0; i < N; i++) {
                bodies[i].draw();
            }
            StdDraw.show(10);

        }
    }
}
