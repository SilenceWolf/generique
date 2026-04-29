package tp.generiques;

// Exo 1.2 - méthode générique statique pour inverser une paire
public class PaireUtils {

    // <A, B> avant le type de retour = on déclare les paramètres de type de la méthode
    public static <A, B> Paire<B, A> inverser(Paire<A, B> p) {
        return new Paire<>(p.getSecond(), p.getPremier());
    }
}
