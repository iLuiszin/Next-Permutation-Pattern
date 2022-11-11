import java.util.*;

class Challenge {
    public static String menorStringMaior(String name) {
        //esse foi o mais complicado então decidi detalhar!

        // proxima permutação
        char[] digitos = name.toCharArray();

        // encontre a maior sequência decrescente.
        int inicioMaiorDecrementando = name.length() - 1;

        // volta do final do char array, até encontrar
        // um ponto onde o char precedente é maior que o próximo.
        while (inicioMaiorDecrementando > 0 && name.charAt(inicioMaiorDecrementando - 1) >= name.charAt(inicioMaiorDecrementando)) {
            inicioMaiorDecrementando--;
        }


        if (inicioMaiorDecrementando <= 0) {
            // estar na última permutação.
            // por exemplo. "54321" é a última permutação dessa sequência.
            // "cba", "321"
            return "sem resposta";
        }

        // encontrar um "ponto de pivô".
        // que é um elemento seguinte (à direita) que é
        // maior que o início da maior sequência decrescente.
        int trocaPivot = name.length() - 1;
        while (name.charAt(trocaPivot) <= name.charAt(inicioMaiorDecrementando - 1)) {
            trocaPivot--;
        }

        // Troca o pivô com o elemento mais alto à direita
        char temp = digitos[inicioMaiorDecrementando - 1];
        digitos[inicioMaiorDecrementando - 1] = digitos[trocaPivot];
        digitos[trocaPivot] = temp;

        // Inverte a sequência do sufixo
        trocaPivot = name.length() - 1;
        while (inicioMaiorDecrementando < trocaPivot) {
            // bit de swapping code.
            // retira o original
            temp = digitos[inicioMaiorDecrementando];
            // atribui o fim ao início.
            digitos[inicioMaiorDecrementando] = digitos[trocaPivot];
            // atribui o temp de volta ao outro local.
            digitos[trocaPivot] = temp;
            inicioMaiorDecrementando++;
            trocaPivot--;
        }
        return new String(digitos);
    }
}
