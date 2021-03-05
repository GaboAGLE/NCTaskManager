package mx.edu.j2se.Aguilar.evaluation;


public class Evaluation1 {
    public static void main(String[] args) {
        Circle circle = new Circle (-3); //círculo inválido

        Circle []circulos = new Circle[3];
        circulos[0] = new Circle(2);
        circulos[1] = new Circle(4);
        circulos[2] = new Circle(6);





    }

    public double biggestCircle(Circle circulos[]){
        Circle actual = new Circle(1);
        int index = 0;
        for (int i = 0; i<circulos.length; i++){
            if (actual.getRadius() < circulos[i].getRadius()){
                actual = circulos[i];
                index = i;
            }
        }
        return index;
    }

}
