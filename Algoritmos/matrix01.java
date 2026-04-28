import java.util.Arrays;
import java.util.Scanner;

public class matrix01 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        double[][] notas = new double[3][2];
        double media = 0;

        for (int l = 0; l < notas.length; l++) {
            for (int c = 0; c < notas[l].length; c++) {
                System.out.println("Insira a nota [ + c + ] do aluno [ + l + ]: ");
                notas[l][c] = teclado.nextDouble();
                media += notas[l][c] / 2;
                System.out.println("Aluno [ + l + ] | Média: [+ media]");
            }
        }

        teclado.close();
    }
}