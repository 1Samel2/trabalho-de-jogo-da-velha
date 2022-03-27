package com.uninter.model.jogo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ComputadorB extends Computador { // declaração da classe ComputadorB

    private Tabuleiro tabuleiro; // declaração da variável tabuleiro

    public ComputadorB(Tabuleiro tabuleiro) { // método construtor para inicializar a variável tabuleiro
        this.tabuleiro = tabuleiro;
    }

    public int realizarJogada(){ // método para realizar a jogada
        Random random = new Random(); // declaração do objeto random para gerar números aleatórios

        if (tabuleiro.verificarPosicao(5) == true) { // método para verificar se a posição 5 está vazia
            return 5;
        }
        else if (tabuleiro.verificarPosicao(1) == true // declaração do if para verificar se as posições  está vazia...
                || tabuleiro.verificarPosicao(3) == true
                || tabuleiro.verificarPosicao(7) == true
             || tabuleiro.verificarPosicao(9) == true) {

           List<Integer> posicoes = Arrays.asList(1, 3, 7, 9);         // declaração da lista posicoes com os valores 1, 3, 7, 9


           return posicoes.get(random.nextInt(posicoes.size())); // declaração do if para verificar se a posição está vazia...

        }
        else{
            return random.nextInt(9) + 1; // retorna um valor aleatório da lista posicoes
        }
    }
}
