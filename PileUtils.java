package generique;

// Exo 1.3 - tests pour la classe Paire
public class MainPaire {

    public static void main(String[] args) {

        // 1) une paire String + Integer
        Paire<String, Integer> p = new Paire<>("Alice", 42);
        System.out.println(p);

        // 2) on l'inverse
        Paire<Integer, String> inv = PaireUtils.inverser(p);
        System.out.println(inv);

        // 3) une paire Double + Boolean -> on affiche le type de chaque valeur
        Paire<Double, Boolean> p2 = new Paire<>(3.14, true);
        System.out.println(
                p2.getPremier().getClass().getSimpleName()
                        + " - "
                        + p2.getSecond().getClass().getSimpleName()
        );
        // Note : le sujet dit "String — Integer" mais comme la paire est (3.14, true)
        // on obtient en fait Double - Boolean, c'est sûrement une coquille du sujet
    }
}
