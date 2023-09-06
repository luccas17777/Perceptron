public class Main {
    public static void main(String[] args) {
                Perceptron perceptron = new Perceptron();

                perceptron.treinar();

                int epocas = perceptron.getCount();
                System.out.println("Treinamento concluído em " + epocas + " épocas");

                System.out.println("Testando o Perceptron após o treinamento:");
                int[][] testInputs = {
                        {0, 0},
                        {0, 1},
                        {1, 0},
                        {1, 1}
                };

                for (int i = 0; i < testInputs.length; i++) {
                    int x1 = testInputs[i][0];
                    int x2 = testInputs[i][1];
                    int saida = perceptron.executar(x1, x2);

                    System.out.println("Entradas: " + x1 + ", " + x2);
                    System.out.println("Saída: " + saida);
                }
            }
        }