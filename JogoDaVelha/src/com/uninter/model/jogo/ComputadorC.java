package com.uninter.model.jogo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ComputadorC extends Computador { // declaração da classe ComputadorC

    private Tabuleiro tabuleiro; // declaração da variável tabuleiro
    private static Integer count = 0; // declaração da variável count
 
    public ComputadorC(Tabuleiro tabuleiro) { // método construtor para inicializar a variável tabuleiro
        this.tabuleiro = tabuleiro;
    }

    public int realizarJogada() { // método para realizar a jogada
        Random random = new Random(); // declaração do objeto random para gerar números aleatórios

        if (count % 2 == 0) { // if para verificar se o contador é par
            count++; // incrementa o contador
            if (tabuleiro.verificarPosicao(1) == true // declaração do if para verificar se as posições está vazia...
                    || tabuleiro.verificarPosicao(3) == true
                    || tabuleiro.verificarPosicao(5) == true
                    || tabuleiro.verificarPosicao(7) == true
                    || tabuleiro.verificarPosicao(9) == true) {

                List<Integer> posicoes = Arrays.asList(1, 3, 5, 7, 9); // declaração da lista posicoes com os valores 1, 3, 5, 7, 9

                return posicoes.get(random.nextInt(posicoes.size())); // retorna um valor aleatório da lista posicoes
            }
        }
        else {
            count++;
            if (tabuleiro.verificarPosicao(2) == true // declaração do if para verificar se a posição 2 está vazia...
                    || tabuleiro.verificarPosicao(4) == true
                    || tabuleiro.verificarPosicao(6) == true // declaração do if para verificar se as posição  está vazia...
                    || tabuleiro.verificarPosicao(8) == true) {

                List<Integer> posicoes = Arrays.asList(2, 4, 6, 8); // declaração da lista posicoes com os valores 2, 4, 6, 8

                return posicoes.get(random.nextInt(posicoes.size())); // declaração do if para verificar se a posição está vazia...
            }
        }
        return 0; // retorna 0 caso não encontre nenhuma posição vazia
    }
}
