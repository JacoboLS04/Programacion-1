import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// EJERCICIO #3 (Imagen 2): Verificar si una lista es palíndroma
// Solución con métodos de Collections
public static boolean esPalindromo1(List<Integer> lista) {
    List<Integer> copia = new ArrayList<>(lista);
    Collections.reverse(copia);
    return lista.equals(copia);
}

// Solución con lógica y bucles for
public static boolean esPalindromo2(List<Integer> lista) {
    for (int i = 0; i < lista.size() / 2; i++) {
        if (!lista.get(i).equals(lista.get(lista.size() - 1 - i))) {
            return false;
        }
    }
    return true;
}

// EJERCICIO #4 (Imagen 2): Encontrar elementos comunes entre dos listas
// Solución con métodos de Collections
public static List<Integer> elementosComunes1(List<Integer> lista1, List<Integer> lista2) {
    List<Integer> comunes = new ArrayList<>();
    for (Integer elemento : lista1) {
        if (lista2.contains(elemento) && !comunes.contains(elemento)) {
            comunes.add(elemento);
        }
    }
    return comunes;
}

// Solución con lógica y bucles for
public static List<Integer> elementosComunes2(List<Integer> lista1, List<Integer> lista2) {
    List<Integer> comunes = new ArrayList<>();
    for (int i = 0; i < lista1.size(); i++) {
        for (int j = 0; j < lista2.size(); j++) {
            if (lista1.get(i).equals(lista2.get(j))) {
                boolean yaExiste = false;
                for (int k = 0; k < comunes.size(); k++) {
                    if (comunes.get(k).equals(lista1.get(i))) {
                        yaExiste = true;
                        break;
                    }
                }
                if (!yaExiste) {
                    comunes.add(lista1.get(i));
                }
                break;
            }
        }
    }
    return comunes;
}

// EJERCICIO #5 (Imagen 2): Rotar elementos n posiciones a la derecha
// Solución con métodos de Collections
public static List<Integer> rotarDerecha1(List<Integer> lista, int n) {
    if (lista.isEmpty() || n <= 0) {
        return lista;
    }

    n = n % lista.size(); // Por si n es mayor que el tamaño de la lista

    for (int i = 0; i < n; i++) {
        Integer ultimo = lista.remove(lista.size() - 1);
        lista.add(0, ultimo);
    }

    return lista;
}

// Solución con lógica y bucles for
public static List<Integer> rotarDerecha2(List<Integer> lista, int n) {
    if (lista.isEmpty() || n <= 0) {
        return lista;
    }

    n = n % lista.size(); // Por si n es mayor que el tamaño de la lista

    for (int i = 0; i < n; i++) {
        Integer ultimo = lista.get(lista.size() - 1);

        for (int j = lista.size() - 1; j > 0; j--) {
            lista.set(j, lista.get(j - 1));
        }

        lista.set(0, ultimo);
    }

    return lista;
}
}