package br.com.cadu;

import net.jqwik.api.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
  Testes baseados em propriedades para a classe MathFunctions usando Jqwik
*/
public class MathFunctionsTest {
    
    /*
      Teste baseado em propriedades: O dobro de um número sempre é maior ou igual ao próprio número
      Propriedade: multiplyByTwo(x) >= x para números não-negativos
    */
    @Property
    void dobroSempreEMaiorOuIgual(@ForAll int number) {
        // Evita overflow limitando o range
        Assume.that(number >= -1000000 && number <= 1000000);
        
        int resultado = MathFunctions.multiplyByTwo(number);
        
        // Para números não-negativos: dobro sempre é maior ou igual
        if (number >= 0) {
            Assertions.assertTrue(resultado >= number,
                "O dobro de um número não-negativo deve ser maior ou igual ao número original");
        }
        // Para números negativos, a propriedade é que o dobro é menor (mais negativo)
        // mas matematicamente correto seria: 2x <= x quando x < 0
        if (number < 0) {
            Assertions.assertTrue(resultado <= number,
                "O dobro de um número negativo deve ser menor ou igual ao número original");
        }
    }
    
    /*
      Teste baseado em propriedades: Se x for par, então multiplyByTwo(x) também será par
      Propriedade: se x % 2 == 0, então multiplyByTwo(x) % 2 == 0
    */
    @Property
    void seXForParEntaoDobroTambemEPar(@ForAll int number) {
        // Verifica apenas números pares como entrada
        Assume.that(number % 2 == 0); // Assume que o número é par
        
        int resultado = MathFunctions.multiplyByTwo(number);
        
        Assertions.assertTrue(resultado % 2 == 0,
            "Se o número original for par, seu dobro também deve ser par");
    }
    
    /*
      Teste baseado em propriedades adicional: O dobro de um número sempre é divisível por 2
      Propriedade: multiplyByTwo(x) % 2 == 0 para qualquer x
    */
    @Property
    void dobroSempreEDivisiblePorDois(@ForAll int number) {
        int resultado = MathFunctions.multiplyByTwo(number);
        
        Assertions.assertTrue(resultado % 2 == 0,
            "O dobro de qualquer número sempre deve ser divisível por 2");
    }
    
    /*
      Teste específico: O dobro de zero sempre é zero
      Teste tradicional para o caso especial do zero
    */
    @Test
    void dobroDeZeroEZero() {
        int resultado = MathFunctions.multiplyByTwo(0);
        
        Assertions.assertEquals(0, resultado,
            "O dobro de zero deve ser zero");
    }
    
    /*
      Teste baseado em propriedades: Propriedade comutativa do dobro
      Propriedade: multiplyByTwo(a) + multiplyByTwo(b) == multiplyByTwo(a + b)
    */
    @Property
    void propriedadeComutativaDobles(@ForAll int a, @ForAll int b) {
        int somaDosDobros = MathFunctions.multiplyByTwo(a) + MathFunctions.multiplyByTwo(b);
        int dobroDaSoma = MathFunctions.multiplyByTwo(a + b);
        
        Assertions.assertEquals(somaDosDobros, dobroDaSoma,
            "A soma dos dobros deve ser igual ao dobro da soma");
    }
}