package tp.generiques;

public class Rectangle extends Forme {

    double largeur, hauteur;

    Rectangle(double l, double h) {
        largeur = l;
        hauteur = h;
    }

    public double surface() {
        return largeur * hauteur;
    }

    @Override
    public String toString() {
        return "Rectangle(" + largeur + "x" + hauteur + ")";
    }
}
