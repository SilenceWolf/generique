package tp.generiques;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// Exo 2.1 - pile générique LIFO
// le sommet = dernier élément de la liste interne
public class Pile<T> {

    private List<T> elements = new ArrayList<>();

    public void empiler(T element) {
        elements.add(element);
    }

    public T depiler() {
        if (estVide()) {
            // on lève une exception au lieu de retourner null (cf. consigne)
            throw new NoSuchElementException("la pile est vide");
        }
        return elements.remove(elements.size() - 1);
    }

    public T sommet() {
        if (estVide()) {
            throw new NoSuchElementException("la pile est vide");
        }
        return elements.get(elements.size() - 1);
    }

    public boolean estVide() {
        return elements.isEmpty();
    }

    public int taille() {
        return elements.size();
    }

    // utilisé par PileUtils.inverser pour récupérer une copie sans toucher à la liste interne
    List<T> copieElements() {
        return new ArrayList<>(elements);
    }

    // affichage du sommet vers la base
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = elements.size() - 1; i >= 0; i--) {
            sb.append(elements.get(i));
            if (i > 0) sb.append(" | ");
        }
        sb.append("]");
        return sb.toString();
    }
}
