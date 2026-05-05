System.out.println("\n=== EXERCÍCIO 5 - JOGO DA VELHA COM COMPUTADOR ===");

                    Random random = new Random();

                    char[][] tabuleiro = new char[3][3];

                    int linha;
                    int coluna;
                    int linhaComputador;
                    int colunaComputador;
                    int jogadas = 0;

                    char jogador = 'X';
                    char computador = 'O';

                    boolean venceu = false;
                    char vencedor = '-';

                    // Preenche o tabuleiro com '-'
                    for (char[] tabuleiro1 : tabuleiro) {
                        for (int j = 0; j < tabuleiro1.length; j++) {
                            tabuleiro1[j] = '-';
                        }
                    }

                    while (jogadas < 9 && !venceu) {

                        // Exibe o tabuleiro
                        System.out.println("\nTabuleiro atual:");
                        for (char[] tabuleiro1 : tabuleiro) {
                            for (int j = 0; j < tabuleiro1.length; j++) {
                                System.out.print(tabuleiro1[j] + " ");
                            }
                            System.out.println();
                        }

                        boolean jogadaValida = false;

                        while (!jogadaValida) {
                            System.out.println("\nSua vez! Você joga com X.");

                            System.out.print("Informe a linha de 0 até " + (tabuleiro.length - 1) + ": ");
                            linha = sc.nextInt();

                            System.out.print("Informe a coluna de 0 até " + (tabuleiro[0].length - 1) + ": ");
                            coluna = sc.nextInt();

                            if (linha < 0 || linha >= tabuleiro.length
                                    || coluna < 0 || coluna >= tabuleiro[0].length) {

                                System.out.println("Posição inválida! Tente novamente.");

                            } else if (tabuleiro[linha][coluna] != '-') {

                                System.out.println("Essa posição já está ocupada! Tente novamente.");

                            } else {

                                tabuleiro[linha][coluna] = jogador;
                                jogadas++;
                                jogadaValida = true;
                            }
                        }

                        // Verifica se o jogador venceu nas linhas
                        for (char[] tabuleiro1 : tabuleiro) {
                            if (tabuleiro1[0] == jogador && tabuleiro1[1] == jogador && tabuleiro1[2] == jogador) {
                                venceu = true;
                                vencedor = jogador;
                            }
                        }

                        // Verifica se o jogador venceu nas colunas
                        for (int j = 0; j < tabuleiro[0].length; j++) {
                            if (tabuleiro[0][j] == jogador
                                    && tabuleiro[1][j] == jogador
                                    && tabuleiro[2][j] == jogador) {

                                venceu = true;
                                vencedor = jogador;
                            }
                        }

                        // Verifica se o jogador venceu na diagonal principal
                        if (tabuleiro[0][0] == jogador
                                && tabuleiro[1][1] == jogador
                                && tabuleiro[2][2] == jogador) {

                            venceu = true;
                            vencedor = jogador;
                        }
                        // Verifica se o jogador venceu na diagonal secundária
                        if (tabuleiro[0][2] == jogador
                                && tabuleiro[1][1] == jogador
                                && tabuleiro[2][0] == jogador) {

                            venceu = true;
                            vencedor = jogador;
                        }

                        if (venceu || jogadas == 9) {
                            break;
                        }

                        // Jogada do computador
                        System.out.println("\nVez do computador...");

                        boolean computadorJogou = false;

                        while (!computadorJogou) {
                            linhaComputador = random.nextInt(tabuleiro.length);
                            colunaComputador = random.nextInt(tabuleiro[0].length);

                            if (tabuleiro[linhaComputador][colunaComputador] == '-') {
                                tabuleiro[linhaComputador][colunaComputador] = computador;
                                jogadas++;
                                computadorJogou = true;

                                System.out.println("Computador jogou na posição ["
                                        + linhaComputador + "][" + colunaComputador + "]");
                            }
                        }

                        // Verifica se o computador venceu nas linhas
                        for (char[] tabuleiro1 : tabuleiro) {
                            if (tabuleiro1[0] == computador && tabuleiro1[1] == computador && tabuleiro1[2] == computador) {
                                venceu = true;
                                vencedor = computador;
                            }
                        }

                        // Verifica se o computador venceu nas colunas
                        for (int j = 0; j < tabuleiro[0].length; j++) {
                            if (tabuleiro[0][j] == computador
                                    && tabuleiro[1][j] == computador
                                    && tabuleiro[2][j] == computador) {

                                venceu = true;
                                vencedor = computador;
                            }
                        }

                        // Verifica se o computador venceu na diagonal principal
                        if (tabuleiro[0][0] == computador
                                && tabuleiro[1][1] == computador
                                && tabuleiro[2][2] == computador) {

                            venceu = true;
                            vencedor = computador;
                        }
                        // Verifica se o computador venceu na diagonal secundária
                        if (tabuleiro[0][2] == computador
                                && tabuleiro[1][1] == computador
                                && tabuleiro[2][0] == computador) {

                            venceu = true;
                            vencedor = computador;
                        }
                    }

                    System.out.println("\nTabuleiro final:");
                    for (char[] tabuleiro1 : tabuleiro) {
                        for (int j = 0; j < tabuleiro1.length; j++) {
                            System.out.print(tabuleiro1[j] + " ");
                        }
                        System.out.println();
                    }

                    if (venceu) {
                        if (vencedor == jogador) {
                            System.out.println("\nParabéns! Você venceu!");
                        } else {
                            System.out.println("\nO computador venceu!");
                        }
                    } else {
                        System.out.println("\nEmpate! Ninguém venceu.");
                    }
