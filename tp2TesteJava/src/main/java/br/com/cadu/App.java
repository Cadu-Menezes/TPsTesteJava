package br.com.cadu;

/*
    Exemplo de aplicação com função de soma para demonstrar testes baseados em propriedades
*/
public class App 
{
    public static void main( String[] args )
    {
        // Compilar o projeto: mvn compile
        // Rodar o projeto: java -cp target/classes br.com.cadu.App
        
        App app = new App();
        System.out.println("Exemplo de soma: 5 + 3 = " + app.somar(5, 3));
        System.out.println("Verificando comutatividade: 5 + 3 = " + app.somar(5, 3) + " e 3 + 5 = " + app.somar(3, 5));
    }
    
    /*
      Função que soma dois números inteiros
      @param numero1 
      @param numero2 
      @return soma dos dois números
    */
    public int somar(int numero1, int numero2) {
        return numero1 + numero2;
    }
}
