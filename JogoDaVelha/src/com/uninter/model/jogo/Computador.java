package com.uninter.model.jogo; // importação para conectar todas as classes do pacote com o Main

import com.uninter.model.interfaces.ComputadorInterface; // importação para conectar a interface ComputadorInterface

import java.util.ArrayList; 

public abstract class Computador implements ComputadorInterface { // declaração da classe Computador
    public final String PECA_COMPUTADOR = " O "; // declaração da variável PECA_COMPUTADOR com valor O
    private ArrayList<Integer> computadorPosicoes = new ArrayList<>(); // declaração da lista computadorPosicoes

    public int realizarJogada(){ // método para realizar a jogada

        return 0; // retorna um valor aleatório da lista posicoes
    }

    public void adicionarPosicao(int posicao){ // método para adicionar a posição na lista
        computadorPosicoes.add(posicao); // declaração da lista computadorPosicoes
    }

    public ArrayList<Integer> getComputadorPosicoes(){ // método para retornar a lista computadorPosicoes
        return computadorPosicoes; // retorna a lista computadorPosicoes
    } 
}
