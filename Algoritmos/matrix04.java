import java.util.*;

public class matrix04 {

    static String[] board;
    static String turn;

    static String checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }

            if (line.equals("XXX")) { // Para o jogador X
                return "X";
            }

            else if (line.equals("OOO")) { // Para o jogador O
                return "O";
            }
        }

        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(String.valueOf(a + 1))) {
                break;
            } else if (a == 8) {
                return "draw";
            }
        }

        System.out.println("Jogador " + turn + " digite um número para colocar " + turn + ": ");
        return null;
    }

    static void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;

        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }

        System.out.println("Jogo da velha");
        printBoard();
        System.out.println("X vai jogar primeiro. Insira um número para colocar X:");

        while (winner == null) {
            int numInput;

            try {
                numInput = in.nextInt();

                // Check range
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Inválido! Insira outro número: ");
                    continue;
                }

                // Check if slot is available
                if (board[numInput - 1].equals(String.valueOf(numInput))) {
                    board[numInput - 1] = turn;

                    // Toggle turn
                    turn = turn.equals("X") ? "O" : "X";

                    printBoard();
                    winner = checkWinner();
                } else {
                    System.out.println("Já preenchido! Insira outro número: ");
                }

            } catch (InputMismatchException e) {
                System.out.println("Inválido! Insira outro número: ");
                in.nextLine(); // Consume invalid input to prevent infinite loop
            }
        }

        // Final result
        if (winner.equalsIgnoreCase("empate")) {
            System.out.println("Empate! Obrigado por jogar");
        } else {
            System.out.println("Parabéns! " + winner + " , você venceu! Obrigado por jogar!");
        }

        in.close();
    }
}