BILAN - TP Classes Génériques en Java
=====================================


1) Que fait le compilateur Java des informations de type générique
   à l'exécution ?

Il les efface. C'est ce qu'on appelle le "type erasure". En gros, le compilo
utilise les T, E etc. uniquement pour vérifier que le code est cohérent au
moment de la compilation, puis il les remplace dans le bytecode par leur borne
(par défaut Object, ou la borne supérieure si y'en a une, genre Number pour
<T extends Number>). Il ajoute aussi les casts qu'il faut tout seul.
Du coup à l'exécution, le T n'existe plus : pour la JVM, List<String> et
List<Integer> sont la même classe List. C'est pour ça qu'on peut pas faire
instanceof T, ni new T(), ni new T[].


2) Pourquoi ne peut-on pas écrire new T() dans une classe générique ?

À cause de l'effacement justement. Au moment où le code tourne, T n'existe
plus, il a été remplacé par Object (ou par sa borne). La JVM ne sait pas
quelle classe instancier, et elle sait pas non plus si T a un constructeur
sans argument. Si on a vraiment besoin de créer des instances de T, faut
ruser, par exemple :
 - passer une factory : Supplier<T> et appeler .get()
 - passer un Class<T> : clazz.getDeclaredConstructor().newInstance()


3) Différence entre <T extends Number> et <? extends Number> ?

<T extends Number> c'est un paramètre de type qu'on NOMME. Une fois fixé,
T désigne UN type précis dans toute la classe ou la méthode. On peut le
réutiliser en type de retour, en type de paramètre, plusieurs fois etc.
Exemple : public <T extends Number> T premier(List<T> l)

<? extends Number> c'est un wildcard, un type "anonyme". On peut pas le
nommer ni le réutiliser. C'est plus pratique quand on veut juste accepter
"n'importe quelle liste de Number ou sous-type" sans avoir besoin de se
référer au type quelque part.

Règle perso : si j'ai besoin de relier deux choses entre elles (genre
"cette méthode prend un List<T> et renvoie un T"), je nomme avec T.
Sinon le wildcard suffit et c'est plus souple côté appelant.


4) Quand choisir extends plutôt que super dans un wildcard ?

C'est le principe PECS : Producer Extends, Consumer Super.
- ? extends T : quand on LIT dans la collection (elle "produit" des T)
- ? super T   : quand on ÉCRIT dans la collection (elle "consomme" des T)
- Si on fait les deux (lecture ET écriture), pas de wildcard, on prend
  juste List<T>.


5) Peut-on créer un tableau T[] dans une classe générique ?
   Quelle alternative utiliser ?

Non, ça compile pas. La raison : les tableaux Java sont "réifiés", ils
connaissent leur vrai type à l'exécution (sinon ArrayStoreException ne
pourrait pas exister). Mais les génériques sont effacés, donc T n'existe
plus à l'exécution. Les deux mécanismes sont incompatibles, du coup
new T[n] est interdit.

Solutions possibles :
 - utiliser une List<T> (genre ArrayList<T>) à la place, c'est ce qu'on
   fait 99% du temps
 - faire un Object[] et caster à la lecture (avec un warning unchecked)
 - passer une Class<T> et utiliser la réflexion :
       T[] tab = (T[]) Array.newInstance(clazz, n);
