package generique;

import java.util.List;

// Exo 4 - wildcards et PECS
// PECS = Producer Extends, Consumer Super
public class FormeUtils {

    // Exo 4.1 - wildcard non borné
    // List<?> = liste de quelque chose, on sait pas quoi
    // ça permet d'accepter List<Cercle>, List<Rectangle>, List<Forme>...
    // Par contre on peut pas appeler .surface() direct sur un ? donc
    // on cast en Forme (de toute façon on est censé recevoir des formes)
    public static void afficherSurfaces(List<?> formes) {
        for (Object o : formes) {
            Forme f = (Forme) o;
            System.out.println(f + " -> surface = " + f.surface());
        }
    }

    // Exo 4.2 - borne supérieure
    // Pourquoi pas juste List<Forme> ?
    // Parce qu'en Java les génériques ne sont PAS covariants :
    // List<Cercle> n'est PAS un sous-type de List<Forme>.
    // Donc avec un paramètre List<Forme> on pourrait pas passer une List<Cercle>,
    // ça ne compilerait pas. Avec List<? extends Forme> c'est ok, on accepte
    // n'importe quelle liste de Forme ou de sous-type de Forme.
    // Côté PECS : on lit dans la liste (producteur) -> extends.
    public static double sommerSurfaces(List<? extends Forme> formes) {
        double total = 0.0;
        for (Forme f : formes) {
            total += f.surface();
        }
        return total;
    }

    // Exo 4.3 - borne inférieure
    // On ÉCRIT des Cercle dans la liste, donc la liste doit pouvoir les contenir.
    // ? super Cercle = Cercle, Forme ou Object. Tout ce qui est "au-dessus" de Cercle
    // dans la hiérarchie. PECS : consumer -> super.
    public static void remplirCercles(List<? super Cercle> destination, int n) {
        for (int i = 0; i < n; i++) {
            destination.add(new Cercle(1.0));
        }
    }

    // Exo 4.4 - PECS combiné
    // source : on LIT dedans -> ? extends T (producer extends)
    // destination : on ÉCRIT dedans -> ? super T (consumer super)
    //
    // Question bonus : si on essaie source.add(...) à l'intérieur,
    // le compilateur RÂLE. Pourquoi ? Parce que List<? extends T> c'est
    // "une liste d'un sous-type inconnu de T". On sait pas si c'est List<T>,
    // ou List<SousClasseA>, ou List<SousClasseB>... du coup ajouter un T
    // dedans serait dangereux : si la vraie liste c'est List<SousClasseA>
    // on insérerait un T qui n'est pas forcément un SousClasseA -> ça casserait
    // le typage. Java l'interdit donc complètement (sauf null).
    public static <T extends Forme> void copier(
            List<? extends T> source,
            List<? super T> destination) {
        for (T elt : source) {
            destination.add(elt);
            // source.add(elt); // <-- compile pas, cf. explication au-dessus
        }
    }
}
