package generique;

import java.util.Arrays;
import java.util.List;

public class MainStats {

    public static void main(String[] args) {

        List<Integer> entiers = Arrays.asList(4, 8, 15, 16, 23, 42);
        Stats<Integer> sInt = new Stats<>(entiers);
        System.out.println("--- Integer ---");
        System.out.println("moyenne   : " + sInt.moyenne());
        System.out.println("min       : " + sInt.min());
        System.out.println("max       : " + sInt.max());
        System.out.println("ecartType : " + sInt.ecartType());
        System.out.println("somme     : " + Stats.somme(entiers));

        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5, 4.5);
        Stats<Double> sD = new Stats<>(doubles);
        System.out.println("\n--- Double ---");
        System.out.println("moyenne   : " + sD.moyenne());
        System.out.println("min       : " + sD.min());
        System.out.println("max       : " + sD.max());
        System.out.println("ecartType : " + sD.ecartType());
        System.out.println("somme     : " + Stats.somme(doubles));

        // Exo 3.3 - test avec un Stats<String>
        // List<String> mots = Arrays.asList("a", "b");
        // Stats<String> sStr = new Stats<>(mots);  // <-- ne compile pas
        //
        // Ma réponse :
        // Le compilateur refuse direct, il dit un truc du genre
        // "type argument String is not within bounds of type-variable T".
        // C'est normal : la classe est déclarée Stats<T extends Number>,
        // donc le T doit être un sous-type de Number. String n'hérite pas
        // de Number donc ça passe pas. L'erreur est détectée à la compilation,
        // pas à l'exécution -> c'est tout l'intérêt des bornes : on évite
        // d'utiliser une classe qui n'a pas la méthode doubleValue().
    }
}
