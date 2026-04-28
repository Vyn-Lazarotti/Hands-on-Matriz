import java.util.Scanner;

public class matrix03 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int[][] estoque = new int [5][2];
        boolean venda = true;

        for (int l = 0; l < estoque.length; l++) {
            for (int c = 0; c < estoque[l].length; c++) {
                System.out.println("Digite o estoque do produto [ + l +]:");
                estoque[l][c] = teclado.nextInt();
                if (estoque[l][c] > 0) {
                    venda = false;
                    String emE = "Em estoque";
                    System.out.println("Quantidade: [ + estoque[l] + ] | Estoque: " + emE);
                } else {
                    venda = true;
                    String foraE = "Fora de estoque";
                    System.out.println("Quantidade: [ + estoque[l] + ] | Estoque: " + foraE);
                }
            }
        }


        teclado.close();
    }
}
