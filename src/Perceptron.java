 /*
 * Classe PERCEPTRON respons�vel para aprendizado
 */

public class Perceptron {

    // pesos sin�pticos [0] entrada 1, [1] entrada 2, [3]BIAS
    private double[] w = new double[3];

    // vari�vel respons�vel pelo somat�rio(rede).
    private double NET = 0;

    // variav�l respons�vel pelo n�mero m�ximo de �pocas
    private final int epocasMax = 30;

    // vari�vel respons�vel pela contagem das �pocas durante o treinamento
    private int count = 0;

    // declara o vetor da matriz de aprendizado
    private int[][] matrizAprendizado = new int[4][3];

    // M�TODO DE RETORNO DO CONTADOR
    public int getCount(){

      return this.count;

    }
 // metodo de inicializa��o inicia o vetor da matriz de aprendizado
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
    
    // inicializa��o dos pesos sin�pticos

    w[0] = 0;   // Peso sin�ptico para primeira entrada.
    w[1] = 0;	// Peso sin�ptico para segunda entrada.
    w[2]= 0;	// Peso sin�ptico para o BIAS
       
}

  // M�todo respons�vel pelo somat�rio e a fun��o de ativa��o.
    int executar(int x1, int x2) {

        // Somat�rio (NET)
        NET = (x1 * w[0]) + (x2 * w[1]) + ((-1) * w[2]);
        /*System.out.println("o valor do NET é:" + NET);*/

        // Fun��o de Ativa��o
        if (NET >= 0) {
            return 1;
        }
        return 0;
        
        
    }

    // M�todo para treinamento da rede
    public void treinar() {

        // variavel utilizada respons�vel pelo controlede treinamento
        boolean treinou= true;
        // var�vel respons�vel para receber o valor da sa�da (y)
        int saida;

        // la�o usado para fazer todas as entradas
        for (int i = 0; i < matrizAprendizado.length; i++) {
            // A sa�da recebe o resultado da rede que no caso � 1 ou 0
            saida = executar(matrizAprendizado[i][0], matrizAprendizado[i][1]);
            
           System.out.println("O �ndice da linha �: " + i); 
           System.out.println("O valor de sa�da �: " + saida);
           System.out.println("O valor esperado �: " + matrizAprendizado[i][2]);
           
           
            
            if (saida != matrizAprendizado[i][2]) {
                // Caso a sa�da seja diferente do valor esperado
                
                // os pesos sin�pticos ser�o corrigidos
                corrigirPeso(i, saida);
                // a variav�l respons�vel pelo controlede treinamento recebe falso
                treinou = false;

            }
        }
        // acrescenta uma �poca
        this.count++;
        // teste se houve algum erro duranteo treinamento e o n�mero de epocas
        //� menor que o definido
        if((treinou == false) && (this.count < this.epocasMax)) {
            // chamada recursiva do m�todo
        	System.out.println("Treinamos " + count + " vezes");
            treinar();

        }

        
    }    // fim do m�todo para treinamento
    
   

    // M�todo para a corre��o de pesos
    void corrigirPeso(int i, int saida) {

        w[0] = w[0] + (1 * (matrizAprendizado[i][2] - saida) * matrizAprendizado[i][0]);
        w[1] = w[1] + (1 * (matrizAprendizado[i][2] - saida) * matrizAprendizado[i][1]);
        w[2] = w[2] + (1 * (matrizAprendizado[i][2] - saida) * (-1));
        
        
        
        System.out.println("Peso primeira entrada (w0) " + w[0]);
        System.out.println("Peso segunda entrada (w1): " + w[1]);
        System.out.println("Peso para o Bias (w2): " + w[0]);
       
}}