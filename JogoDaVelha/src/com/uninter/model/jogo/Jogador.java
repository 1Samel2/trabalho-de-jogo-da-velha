package com.uninter.model.jogo; // importação para conectar todas as classes do pacote com o Main

import java.util.ArrayList;
import java.util.Scanner; // importação para usar as bibliotecas

public class Jogador { // declaração da classe Jogador
    public final String PECA_JOGADOR = " X "; // declaração da variável PECA_JOGADOR com valor X
    private ArrayList<Integer> jogadorPosicoes = new ArrayList<>(); // declaração da lista jogadorPosicoes

    public int realizarJogada(){ // método para realizar a jogada
        Scanner sc = new Scanner(System.in); // declaração do objeto sc para receber o valor digitado pelo usuário
        System.out.print("Digite a posição da peça (1-9): "); // imprime na tela a mensagem de digitar a posição da peça
        return sc.nextInt(); // declaração
    }

    public void adicionarPosicao(int posicao){ // método para adicionar a posição na lista
        jogadorPosicoes.add(posicao);     
    }

    public ArrayList<Integer> getJogadorPosicoes(){   
        return jogadorPosicoes; // retorna a lista jogadorPosicoes
    }

}
