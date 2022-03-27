package com.uninter.model.jogo; // importação para conectar todas as classes do pacote com o Main

import java.util.Random;

public class ComputadorA extends Computador { // declaração da classe ComputadorA

    public int realizarJogada(){ // método para realizar a jogada
        Random r = new Random(); // declaração do objeto r para gerar números aleatórios
        return r.nextInt(9) + 1; // retorna um valor aleatório da lista posicoes
    }
}
