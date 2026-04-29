package tp.generiques;

public class Cercle extends Forme {

    double rayon;

    Cercle(double r) {
        this.rayon = r;
    }

    public double surface() {
        return Math.PI * rayon * rayon;
    }

    @Override
    public String toString() {
        return "Cercle(r=" + rayon + ")";
    }
}
