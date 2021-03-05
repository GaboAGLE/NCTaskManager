package mx.edu.j2se.Aguilar.evaluation;


public class Circle {
    private int radius;


    public Circle (){
        this.radius = 1;
    }
    public Circle (int radius){
        if ( radius < 0 || radius == 0)
            throw new IllegalArgumentException();
        this.radius = radius;
    }

    public void setRadius(int radius){
        if ( radius < 0 || radius == 0)
            throw new IllegalArgumentException();

        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }
    public double getArea(){

        return (Math.PI * (this.radius*this.radius));
    }
}
