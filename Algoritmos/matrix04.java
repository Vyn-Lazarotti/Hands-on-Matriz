import java.util.*;

public class matrix04 {
    public static void main(String [] arguments){
        Scanner sc = new Scanner(System.in);
        
        char [][] tabuleiro = new char [3][3];
        char jogadorAtual = 'X';
        int linha, coluna;
        boolean venceu = false;
        int jogadas = 0;


        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                tabuleiro[i][j] = '-';
            }
        }

        while(jogadas < 9 && !venceu) {
            System.out.println("\nTabuleiro atual:");
            for (int i = 0; i < tabuleiro.length; i++) {
                for (int j = 0; j < tabuleiro.length; j++) {
                    System.out.println(tabuleiro[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("\nVez do Jogador " + jogadorAtual);
            System.out.println("Informe a linha (0, 1, 2): ");
            linha = sc.nextInt();
            System.out.println("Informe a coluna (0, 1, 2): ");
            coluna = sc.nextInt();
            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
                System.out.println("Posição inválida. Tente novamente.");
            } else if (tabuleiro[linha][coluna] != '-') {
                System.out.println("Essa posição já está preenchida. Tente novamente");
            } else {
                tabuleiro[linha][coluna] = jogadorAtual;
                jogadas++;

                // verifica linha
                for (int i = 0; i < tabuleiro.length; i++) {
                    if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) {
                        venceu = true;
                    }
                }

                // verifica coluna
                for (int j = 0; j < tabuleiro.length; j++) {
                    if (tabuleiro[0][j] == jogadorAtual && tabuleiro[1][j] == jogadorAtual && tabuleiro[2][j] == jogadorAtual) {
                        venceu = true;
                    }
                }

                // verifica diagonal principal
                if(tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) {
                    venceu = true;
                }

                // verifica diagonal secundária
                if(tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual) {
                    venceu = true;
                }

                if(!venceu) {
                    if(jogadorAtual == 'X') {
                        jogadorAtual = 'O';
                    } else {
                        jogadorAtual = 'X';
                    }
                }
            }
        }
        System.out.println("Tabuleiro final: ");
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.println(tabuleiro[i][j] + " ");
            }
        } if (venceu) {
            System.out.println("Parabéns! Você venceu!");
        } else {
            System.out.println("Deu velha!");
        }

        sc.close();
    }
}
