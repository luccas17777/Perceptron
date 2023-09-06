 /*
 * Classe PERCEPTRON responsï¿½vel para aprendizado
 */

public class Perceptron {

    // pesos sinï¿½pticos [0] entrada 1, [1] entrada 2, [3]BIAS
    private double[] w = new double[3];

    // variï¿½vel responsï¿½vel pelo somatï¿½rio(rede).
    private double NET = 0;

    // variavï¿½l responsï¿½vel pelo nï¿½mero mï¿½ximo de ï¿½pocas
    private final int epocasMax = 30;

    // variï¿½vel responsï¿½vel pela contagem das ï¿½pocas durante o treinamento
    private int count = 0;

    // declara o vetor da matriz de aprendizado
    private int[][] matrizAprendizado = new int[4][3];

    // Mï¿½TODO DE RETORNO DO CONTADOR
    public int getCount(){

      return this.count;

    }
 // metodo de inicializaï¿½ï¿½o inicia o vetor da matriz de aprendizado
  Perceptron() {

    // Primeiro valor
    this.matrizAprendizado[0][0] = 0; // entrada 1
    this.matrizAprendizado[0][1] = 0; // entrada 2
    this.matrizAprendizado[0][2] = 0; // valor esperado

    // Segundo Valor
    this.matrizAprendizado[1][0] = 0; // entrada 1
    this.matrizAprendizado[1][1] = 1; // entrada 2
    this.matrizAprendizado[1][2] = 0; // valor esperado

    // terceiro valor
    this.matrizAprendizado[2][0] = 1; // entrada 1
    this.matrizAprendizado[2][1] = 0; // entrada 2
    this.matrizAprendizado[2][2] = 0; // valor esperado

    // quarto valor
    this.matrizAprendizado[3][0] = 1; // entrada 1
    this.matrizAprendizado[3][1] = 1; // entrada 2
    this.matrizAprendizado[3][2] = 1; // valor esperado
    
    // inicializaï¿½ï¿½o dos pesos sinï¿½pticos

    w[0] = 0;   // Peso sinï¿½ptico para primeira entrada.
    w[1] = 0;	// Peso sinï¿½ptico para segunda entrada.
    w[2]= 0;	// Peso sinï¿½ptico para o BIAS
       
}

  // Mï¿½todo responsï¿½vel pelo somatï¿½rio e a funï¿½ï¿½o de ativaï¿½ï¿½o.
    int executar(int x1, int x2) {

        // Somatï¿½rio (NET)
        NET = (x1 * w[0]) + (x2 * w[1]) + ((-1) * w[2]);
        /*System.out.println("o valor do NET Ã©:" + NET);*/

        // Funï¿½ï¿½o de Ativaï¿½ï¿½o
        if (NET >= 0) {
            return 1;
        }
        return 0;
        
        
    }

    // Mï¿½todo para treinamento da rede
    public void treinar() {

        // variavel utilizada responsï¿½vel pelo controlede treinamento
        boolean treinou= true;
        // varï¿½vel responsï¿½vel para receber o valor da saï¿½da (y)
        int saida;

        // laï¿½o usado para fazer todas as entradas
        for (int i = 0; i < matrizAprendizado.length; i++) {
            // A saï¿½da recebe o resultado da rede que no caso ï¿½ 1 ou 0
            saida = executar(matrizAprendizado[i][0], matrizAprendizado[i][1]);
            
           System.out.println("O Índice da linha é: " + i); 
           System.out.println("O valor de saída é: " + saida);
           System.out.println("O valor esperado é: " + matrizAprendizado[i][2]);
           
           
            
            if (saida != matrizAprendizado[i][2]) {
                // Caso a saï¿½da seja diferente do valor esperado
                
                // os pesos sinï¿½pticos serï¿½o corrigidos
                corrigirPeso(i, saida);
                // a variavï¿½l responsï¿½vel pelo controlede treinamento recebe falso
                treinou = false;

            }
        }
        // acrescenta uma ï¿½poca
        this.count++;
        // teste se houve algum erro duranteo treinamento e o nï¿½mero de epocas
        //ï¿½ menor que o definido
        if((treinou == false) && (this.count < this.epocasMax)) {
            // chamada recursiva do mï¿½todo
        	System.out.println("Treinamos " + count + " vezes");
            treinar();

        }

        
    }    // fim do mï¿½todo para treinamento
    
   

    // Mï¿½todo para a correï¿½ï¿½o de pesos
    void corrigirPeso(int i, int saida) {

        w[0] = w[0] + (1 * (matrizAprendizado[i][2] - saida) * matrizAprendizado[i][0]);
        w[1] = w[1] + (1 * (matrizAprendizado[i][2] - saida) * matrizAprendizado[i][1]);
        w[2] = w[2] + (1 * (matrizAprendizado[i][2] - saida) * (-1));
        
        
        
        System.out.println("Peso primeira entrada (w0) " + w[0]);
        System.out.println("Peso segunda entrada (w1): " + w[1]);
        System.out.println("Peso para o Bias (w2): " + w[0]);
       
}}