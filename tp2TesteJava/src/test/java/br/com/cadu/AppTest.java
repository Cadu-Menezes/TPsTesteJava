package br.com.cadu;

import net.jqwik.api.*;
import org.junit.jupiter.api.Assertions;


/*
  Testes para a classe App utilizando jqwik para testes baseados em propriedades
*/
public class AppTest {
    
    private App app = new App();
    
    /*
      Teste baseado em propriedades: A soma deve ser comutativa
      Propriedade: a + b == b + a para qualquer valor de a e b
    */
    @Property
    void somaComutativa(@ForAll int a, @ForAll int b) {
        Assertions.assertEquals(app.somar(a, b), app.somar(b, a));
    }
    

}
