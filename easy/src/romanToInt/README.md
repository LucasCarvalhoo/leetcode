# Roman to Integer

## Problema
**Dificuldade:** Easy  
**Link LeetCode:** [13. Roman to Integer](https://leetcode.com/problems/roman-to-integer/)

## Descrição
Dado um numeral romano como string, converta-o para um número inteiro.

Os numerais romanos são representados pelos seguintes símbolos: `I`, `V`, `X`, `L`, `C`, `D` e `M`.

```
Símbolo    Valor
I          1
V          5
X          10
L          50
C          100
D          500
M          1000
```

Por exemplo, `2` é escrito como `II` em algarismos romanos, que é simplesmente dois `I`s somados. `12` é escrito como `XII`, que é `X + II`. O número `27` é escrito como `XXVII`, que é `XX + V + II`.

Os numerais romanos geralmente são escritos do maior para o menor, da esquerda para a direita. No entanto, o numeral para `4` não é `IIII`. Em vez disso, o número `4` é escrito como `IV`. Como `1` está antes de `5`, nós o subtraímos, obtendo `5 - 1 = 4`. O mesmo princípio se aplica ao número `9`, que é escrito como `IX`.

Existem seis casos onde a subtração é usada:
- `I` pode ser colocado antes de `V` (5) e `X` (10) para formar `4` e `9`.
- `X` pode ser colocado antes de `L` (50) e `C` (100) para formar `40` e `90`.
- `C` pode ser colocado antes de `D` (500) e `M` (1000) para formar `400` e `900`.

## Exemplos
```
Entrada: s = "III"
Saída: 3
Explicação: III = 3.

Entrada: s = "LVIII"
Saída: 58
Explicação: L = 50, V = 5, III = 3.

Entrada: s = "MCMXCIV"
Saída: 1994
Explicação: M = 1000, CM = 900, XC = 90, IV = 4.
```

## Solução

A solução implementada utiliza um HashMap para mapear cada símbolo romano ao seu valor inteiro correspondente. Em seguida, percorremos a string de entrada, verificando se o símbolo atual representa um caso especial de subtração (quando um símbolo menor aparece antes de um maior) ou um caso normal de adição.

```java
package String;

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
```

## Complexidade

- **Complexidade de Tempo**: O(n), onde n é o comprimento da string de entrada. Percorremos cada caractere exatamente uma vez.
- **Complexidade de Espaço**: O(1), pois utilizamos um espaço constante para armazenar o mapeamento dos símbolos romanos, independentemente do tamanho da entrada.

## Lógica da Solução

A solução segue a seguinte lógica:

1. Criamos um mapa que associa cada símbolo romano ao seu valor inteiro.
2. Convertemos a string em um array de caracteres para facilitar o processamento.
3. Percorremos o array de caracteres:
    - Para cada caractere, obtemos seu valor numérico do mapa.
    - Verificamos se estamos em um caso especial de subtração, comparando o valor atual com o próximo valor.
    - Se o valor atual for menor que o próximo valor, subtraímos o valor atual (como em IV, IX, etc.).
    - Caso contrário, adicionamos o valor atual ao total.
4. Retornamos o total calculado.

## Aprendizados

Este problema demonstra:
- Uso de HashMap para mapeamento de valores
- Técnica de verificação do próximo elemento
- Implementação de regras lógicas específicas de um sistema numérico
- Manipulação básica de strings e arrays de caracteres

Esta solução é eficiente tanto em tempo quanto em espaço, sendo uma abordagem ideal para o problema.