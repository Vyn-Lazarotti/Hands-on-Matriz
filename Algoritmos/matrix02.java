import java.util.Arrays;
import java.util.Scanner;

public class matrix02 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int[][] num = new int[3][3];
        int maior = num[0][0];

        for (int l = 0; l < num.length; l++) {
            for (int c = 0; c < num[l].length; c ++) {
                System.out.println("Digite um número inteiro: ");
                num[l][c] = teclado.nextInt();
                if (num[l][c] > maior) {
                    maior = num[l][c];
                    System.out.println("O maior número é [ + maior[l] + ] e a posição é [ + maior[c]]");
                }
            }
        }
        

        teclado.close();
    }
}