package se.kth.pellebe.eabraham.a.shapes; // TODO: Change to your package name

import javafx.scene.paint.Color;

/**
 * A representation of a world containing a set of moving shapes. NB! The worlds
 * y-axis points downward.
 *
 * @author Anders Lindström, anderslm@kth.se 2021-09-15
 */
public class World {

    private double width, height; // this worlds width and height

    private final Shape[] shapes; // an array of references to the shapes

    /**
     * Creates a new world, containing a pad and a set of balls. NB! The worlds
     * y-axis points downward.
     *
     * @param width the width of this world
     * @param height the height of this world
     */
    public World(double width, double height) {
        this.width = width;
        this.height = height;

        shapes = new Shape[3]; // an array of references (change to non-zero size)
        shapes[0] = new Line(0, 0, 100, 80, Color.RED);
        shapes[0].setVelocity(20, 40);
        shapes[1] = new Circle(20, 100, 50, Color.BLUE);
        shapes[1].setVelocity(30, 30);
        //((Circle) shapes[1]).setFilled(true);
        shapes[2] = new Rectangle(0, 0, 40, 30, Color.GOLD);
        shapes[2].setVelocity(70, 80);
        //((Rectangle) shapes[2]).setFilled(true);
        for(Shape s : shapes){
            if(s instanceof FillableShape){
                FillableShape fs = (FillableShape) s;
                fs.setFilled(true);
            }
        }
        // Create the actual Shape objects (sub types)
        // ....
    }

    /**
     * Sets the new dimensions, in pixels, for this world. The method could be
     * used for example when the canvas is reshaped.
     *
     * @param newWidth
     * @param newHeight
     */
    public void setDimensions(double newWidth, double newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }

    /**
     * Move the world one step, based on the time elapsed since last move.
     *
     * @param elapsedTimeNs the elapsed time in nanoseconds
     */
    public void moveAndConstrain(long elapsedTimeNs) {
        // alterantive loop: for(Shape s : shapes) { ...
        for (Shape s : shapes) {
            s.moveAndConstrain(elapsedTimeNs, 0, 0, width, height);
        }
    }

    /**
     * Returns a copy of the list of ball references.
     * Due to the implementation of clone, a shallow copy is returned.
     *
     * @return a copy of the list of balls
     */
    public Shape[] getShapes() {
        return (Shape[]) shapes.clone();
    }
}
