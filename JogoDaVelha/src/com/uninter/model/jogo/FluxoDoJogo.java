package com.uninter.model.jogo; // importação para conectar todas as classes do pacote com o Main

public class FluxoDoJogo {  // declaração da classe FluxoDoJogo

    private Boolean isWinner = false;  // declaração da variável isWinner com valor false
    private Boolean isGameOver = false;  // declaração da variável isGameOver com valor false

    private Jogador jogador;  // declaração da variável jogador
    private Computador computador;  // declaração da variável computador
    private Tabuleiro tabuleiro; // declaração da variável tabuleiro

    public FluxoDoJogo(Jogador jogador, Computador computador, Tabuleiro tabuleiro) { // declaração do construtor da classe FluxoDoJogo
        this.jogador = jogador; // atribui o valor da variável jogador
        this.computador = computador; // atribui o valor da variável computador
        this.tabuleiro = tabuleiro; // atribui o valor da variável tabuleiro
    }
 
    public void jogar() { // método para jogar
        while (!isWinner && !isGameOver) { // enquanto o jogador não ganhar e o jogo não acabar

            while (true) { // enquanto o jogador não digitar uma posição válida
                try {
                    int posicaoJogador = jogador.realizarJogada(); // declaração da variável posicaoJogador com valor da jogada do jogador
                    boolean condicaoJogador = tabuleiro.verificarPosicao(posicaoJogador); // declaração da variável condicaoJogador com valor da verificação da posição do jogador

                    if (condicaoJogador) { // se a condição for verdadeira
                        tabuleiro.marcarPosicao(posicaoJogador, jogador.PECA_JOGADOR);  // marca a posição do jogador
                        jogador.adicionarPosicao(posicaoJogador); // adiciona a posição do jogador na lista
                        isWinner = tabuleiro.condicaoDeVitoria(jogador.getJogadorPosicoes()); // verifica se o jogador ganhou

                        if (isWinner) { // se o jogador ganhar
                            tabuleiro.mostrarTabuleiro(); // mostra o tabuleiro
                            System.out.println("\nPARABENS! VOCÊ VENCEU!"); // imprime na tela a mensagem de que o jogador ganhou
                            break;
                        } else if (jogador.getJogadorPosicoes().size() + computador.getComputadorPosicoes().size() == 9) { // se o jogador e o computador tiverem marcado todas as posições
                            System.out.println("DEU VELHA!"); // imprime na tela a mensagem de que deu velha
                            isGameOver = true;
                        }
                        break; // sai do laço

                    } else { // se a condição for falsa
                        System.out.println("POSIÇÃO INVÁLIDA!"); // imprime na tela a mensagem de posição inválida
                    }
                } catch (Exception e) { // se ocorrer algum erro
                    System.out.println("VOCÊ NÃO PODE INSERIR LETRAS, APENAS NÚMEROS DE 1 A 9!"); // imprime na tela a mensagem de que o jogador não pode inserir letras
                }
            }

            while (true) { // enquanto o computador não digitar uma posição válida
                if (isWinner || isGameOver) { // se o jogador ganhar ou o jogo acabar
                    break;
                }

                int posicaoComputador = computador.realizarJogada(); // declaração da variável posicaoComputador com valor da jogada do computador
                boolean condicaoComputador = tabuleiro.verificarPosicao(posicaoComputador); // declaração da variável condicaoComputador com valor da verificação da posição do computador

                if (condicaoComputador) {   // se a condição for verdadeira
                    tabuleiro.marcarPosicao(posicaoComputador, computador.PECA_COMPUTADOR);     // marca a posição do computador
                    computador.adicionarPosicao(posicaoComputador); // adiciona a posição do computador na lista
                    isWinner = tabuleiro.condicaoDeVitoria(computador.getComputadorPosicoes());   // verifica se o computador ganhou

                    if (isWinner) {    // se o computador ganhar
                        tabuleiro.mostrarTabuleiro();
                        System.out.println("\nVOCÊ PERDEU!"); // imprime na tela a mensagem de que o jogador perdeu
                        break;
                    }
                    break;
                }
            }

            tabuleiro.mostrarTabuleiro();  // mostra o tabuleiro
        }
    }
}
