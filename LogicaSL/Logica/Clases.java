package Logica;


import java.util.Arrays;// EJERCICIO #1: Anagramas
// Solución con métodos de String
public static boolean sonAnagramas1(String palabra1, String palabra2) {
    if (palabra1.length() != palabra2.length()) {
        return false;
    }

    char[] array1 = palabra1.toLowerCase().toCharArray();
    char[] array2 = palabra2.toLowerCase().toCharArray();

    Arrays.sort(array1);
    Arrays.sort(array2);

    return Arrays.equals(array1, array2);
}

// Solución con lógica y bucles for
public static boolean sonAnagramas2(String palabra1, String palabra2) {
    if (palabra1.length() != palabra2.length()) {
        return false;
    }

    palabra1 = palabra1.toLowerCase();
    palabra2 = palabra2.toLowerCase();

    int[] contadorLetras = new int[26]; // Para letras del alfabeto inglés

    for (int i = 0; i < palabra1.length(); i++) {
        contadorLetras[palabra1.charAt(i) - 'a']++;
        contadorLetras[palabra2.charAt(i) - 'a']--;
    }

    for (int count : contadorLetras) {
        if (count != 0) {
            return false;
        }
    }

    return true;
}

// EJERCICIO #2: Contar vocales y consonantes
// Solución con métodos de String
public static int[] contarVocalesYConsonantes1(String cadena) {
    int vocales = 0;
    int consonantes = 0;

    cadena = cadena.toLowerCase();
    String soloLetras = cadena.replaceAll("[^a-z]", "");

    for (int i = 0; i < soloLetras.length(); i++) {
        char c = soloLetras.charAt(i);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            vocales++;
        } else {
            consonantes++;
        }
    }

    return new int[]{vocales, consonantes};
}

// Solución con lógica y bucles for
public static int[] contarVocalesYConsonantes2(String cadena) {
    int vocales = 0;
    int consonantes = 0;

    for (int i = 0; i < cadena.length(); i++) {
        char c = Character.toLowerCase(cadena.charAt(i));

        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vocales++;
            } else {
                consonantes++;
            }
        }
    }

    return new int[]{vocales, consonantes};
}

// EJERCICIO #3: Contar ocurrencias de una palabra
// Solución con métodos de String
public static int contarOcurrencias1(String texto, String palabra) {
    int contador = 0;
    int index = 0;

    while ((index = texto.indexOf(palabra, index)) != -1) {
        contador++;
        index += palabra.length();
    }

    return contador;
}

// Solución con lógica y bucles for
public static int contarOcurrencias2(String texto, String palabra) {
    int contador = 0;

    if (palabra.length() > texto.length()) {
        return 0;
    }

    for (int i = 0; i <= texto.length() - palabra.length(); i++) {
        boolean coincide = true;

        for (int j = 0; j < palabra.length(); j++) {
            if (texto.charAt(i + j) != palabra.charAt(j)) {
                coincide = false;
                break;
            }
        }

        if (coincide) {
            contador++;
            i += palabra.length() - 1;
        }
    }

    return contador;
}

// EJERCICIO #4: Extraer nombre de usuario de email
// Solución con métodos de String
public static String extraerNombreUsuario1(String email) {
    int indexArroba = email.indexOf('@');
    if (indexArroba != -1) {
        return email.substring(0, indexArroba);
    }
    return email;
}

// Solución con lógica y bucles for
public static String extraerNombreUsuario2(String email) {
    String usuario = "";

    for (int i = 0; i < email.length(); i++) {
        if (email.charAt(i) == '@') {
            break;
        }
        usuario += email.charAt(i);
    }

    return usuario;
}

// EJERCICIO #5: Contar palabras en una frase
// Solución con métodos de String
public static int contarPalabras1(String frase) {
    if (frase == null || frase.trim().isEmpty()) {
        return 0;
    }

    String[] palabras = frase.trim().split("\\s+");
    return palabras.length;
}

// Solución con lógica y bucles for
public static int contarPalabras2(String frase) {
    if (frase == null || frase.isEmpty()) {
        return 0;
    }

    int contador = 0;
    boolean enPalabra = false;

    for (int i = 0; i < frase.length(); i++) {
        if (Character.isWhitespace(frase.charAt(i))) {
            if (enPalabra) {
                enPalabra = false;
            }
        } else {
            if (!enPalabra) {
                enPalabra = true;
                contador++;
            }
        }
    }

    return contador;
}

// EJERCICIO #1 (Imagen 2): Contador de vocales
// Solución con métodos de String
public static int contarVocales1(String texto) {
    return texto.toLowerCase().replaceAll("[^aeiouáéíóúàèìòùäëïöü]", "").length();
}

// Solución con lógica y bucles for
public static int contarVocales2(String texto) {
    int contador = 0;
    String vocales = "aeiouáéíóúàèìòùäëïöü";

    for (int i = 0; i < texto.length(); i++) {
        char c = Character.toLowerCase(texto.charAt(i));
        for (int j = 0; j < vocales.length(); j++) {
            if (c == vocales.charAt(j)) {
                contador++;
                break;
            }
        }
    }

    return contador;
}

// EJERCICIO #2 (Imagen 2): Invertir cadena
// Solución con métodos de String
public static String invertirCadena1(String texto) {
    return new StringBuilder(texto).reverse().toString();
}

// Solución con lógica y bucles for
public static String invertirCadena2(String texto) {
    char[] caracteres = new char[texto.length()];

    for (int i = 0; i < texto.length(); i++) {
        caracteres[i] = texto.charAt(texto.length() - 1 - i);
    }

    String resultado = "";
    for (char c : caracteres) {
        resultado += c;
    }

    return resultado;
}

// EJERCICIO #3 (Imagen 2): Reemplazar espacios por guiones
// Solución con métodos de String
public static String reemplazarEspacios1(String texto) {
    return texto.replace(" ", "-");
}

// Solución con lógica y bucles for
public static String reemplazarEspacios2(String texto) {
    String resultado = "";

    for (int i = 0; i < texto.length(); i++) {
        if (texto.charAt(i) == ' ') {
            resultado += '-';
        } else {
            resultado += texto.charAt(i);
        }
    }

    return resultado;
}

// EJERCICIO #4 (Imagen 2): Verificar si solo contiene dígitos
// Solución con métodos de String
public static boolean contieneSoloDigitos1(String texto) {
    return texto.matches("\\d+");
}

// Solución con lógica y bucles for
public static boolean contieneSoloDigitos2(String texto) {
    for (int i = 0; i < texto.length(); i++) {
        if (texto.charAt(i) < '0' || texto.charAt(i) > '9') {
            return false;
        }
    }

    return true;
}

// EJERCICIO #5 (Imagen 2): Eliminar caracteres duplicados
// Solución con métodos de String
public static String eliminarDuplicados1(String texto) {
    StringBuilder resultado = new StringBuilder();

    texto.chars().distinct().forEach(c -> resultado.append((char) c));

    return resultado.toString();
}

// Solución con lógica y bucles for
public static String eliminarDuplicados2(String texto) {
    String resultado = "";

    for (int i = 0; i < texto.length(); i++) {
        char actual = texto.charAt(i);
        boolean duplicado = false;

        for (int j = 0; j < resultado.length(); j++) {
            if (resultado.charAt(j) == actual) {
                duplicado = true;
                break;
            }
        }

        if (!duplicado) {
            resultado += actual;
        }
    }

    return resultado;
}

// EJERCICIO #6 (Imagen 2): Contar ocurrencias de un carácter
// Solución con métodos de String
public static int contarOcurrenciasCaracter1(String cadena, char c) {
    return cadena.length() - cadena.replace(String.valueOf(c), "").length();
}

// Solución con lógica y bucles for
public static int contarOcurrenciasCaracter2(String cadena, char c) {
    int contador = 0;

    for (int i = 0; i < cadena.length(); i++) {
        if (cadena.charAt(i) == c) {
            contador++;
        }
    }

    return contador;
}