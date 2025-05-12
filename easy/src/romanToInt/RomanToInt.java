package romanToInt;

import java.util.HashMap;
import java.util.Map;

class RomanToInt {
    public int romanToInt(String s) {
        int total = 0;

        // Converte uma string em um array de caracteres
        char[] caracteres = s.toCharArray();

        // Map com os valores de cada número romano
        Map<Character, Integer> romanToInt = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};


        for(int i = 0; i < caracteres.length; i++){
            int valorAtual = romanToInt.get(caracteres[i]);

            // Verifica se o valor anterior é menor ou maior (ex: IV = 4)
            if(i < caracteres.length - 1 && romanToInt.get(caracteres[i]) < romanToInt.get(caracteres[i + 1])){
                total -= valorAtual; // Subtrai quando é menor
            } else {
                total += valorAtual; // Soma quando é maior
            }
        }
        return total;
    }
};