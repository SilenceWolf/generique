package generique;

// Exo 2.3 - tests pile
public class MainPile {

    public static void main(String[] args) {

        Pile<Integer> pile = new Pile<>();
        pile.empiler(1);
        pile.empiler(2);
        pile.empiler(3);
        pile.empiler(4);
        pile.empiler(5);

        System.out.println("pile : " + pile);

        int valeur = pile.depiler();
        System.out.println("dépilé : " + valeur);
        System.out.println("après dépilement : " + pile);

        Pile<Integer> inv = PileUtils.inverser(pile);
        System.out.println("inversée : " + inv);
        System.out.println("originale (inchangée) : " + pile);
    }
}
