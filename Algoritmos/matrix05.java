import java.util.ArrayList;
import java.util.Scanner;

public class matrix05 {

    char[][] gameBoard = { 
        {' ', '|', ' ', '|', ' '},
        {'-', '|', '-' , '|', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '|', '-', '|', '-'},
        {' ', '|', ' ', '|' , ' '} };

    public static void tabuleiro (char[][] gameBoard) {
        for(char[] linha: gameBoard){
            for(char coluna: linha){
                System.out.print(coluna);
            }
            System.out.println();
        }
    }

    static ArrayList<Integer> posicaoJogador = new ArrayList<Integer>();
    static ArrayList<Integer> posicaoCPU = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //System.out.println("Bem-vindo ao jogo da velha");



        teclado.close();
    }
}
