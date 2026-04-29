package generique;

import java.util.ArrayList;
import java.util.List;

public class MainForme {

    public static void main(String[] args) {

        // 4.1
        List<Cercle> cercles = new ArrayList<>();
        cercles.add(new Cercle(1.0));
        cercles.add(new Cercle(2.0));

        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(2.0, 3.0));
        rectangles.add(new Rectangle(4.0, 5.0));

        System.out.println("--- afficherSurfaces sur des cercles ---");
        FormeUtils.afficherSurfaces(cercles);

        System.out.println("\n--- afficherSurfaces sur des rectangles ---");
        FormeUtils.afficherSurfaces(rectangles);

        // 4.2
        System.out.println("\n--- sommerSurfaces ---");
        System.out.println("cercles    : " + FormeUtils.sommerSurfaces(cercles));
        System.out.println("rectangles : " + FormeUtils.sommerSurfaces(rectangles));

        // 4.3 - on passe une List<Forme> à remplirCercles : OK car Forme est un super-type de Cercle
        List<Forme> formes = new ArrayList<>();
        FormeUtils.remplirCercles(formes, 3);
        System.out.println("\n--- remplirCercles dans List<Forme> ---");
        FormeUtils.afficherSurfaces(formes);

        // ça marche aussi avec List<Object>
        List<Object> objs = new ArrayList<>();
        FormeUtils.remplirCercles(objs, 2);
        System.out.println("\n--- remplirCercles dans List<Object> taille=" + objs.size());

        // 4.4 - copier (PECS)
        List<Forme> destination = new ArrayList<>();
        FormeUtils.copier(cercles, destination);
        FormeUtils.copier(rectangles, destination);
        System.out.println("\n--- copier : cercles + rectangles -> destination ---");
        FormeUtils.afficherSurfaces(destination);
    }
}
