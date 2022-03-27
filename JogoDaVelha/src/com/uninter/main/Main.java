package com.uninter.main; // importação para conectar todas as classes do pacote com o Main

import java.util.Scanner; // importação para usar as bibliotecas

/* import com.uninter.model.*; */
import com.uninter.model.jogo.Computador;
import com.uninter.model.jogo.ComputadorA; // importação para conectar as classes do pacote com o Main
import com.uninter.model.jogo.ComputadorB;
import com.uninter.model.jogo.ComputadorC;
import com.uninter.model.jogo.FluxoDoJogo;
import com.uninter.model.jogo.Jogador;
import com.uninter.model.jogo.Tabuleiro;


public class Main {    //class main principal 

  public static void main(String[] args) { // método main
    System.out.println("========================================================================="); // imprime na tela a mensagem
        System.out.println("\t\tJogo da Velha");
        System.out.println("=========================================================================\n");
        
        
       
        System.out.print("\tEscolha um nível - (A | B | C) ");

        Scanner sc = new Scanner(System.in); // declaração do objeto sc para receber o valor digitado pelo usuário
        String nivel = sc.next().toLowerCase(); // declaração da variável nivel com valor digitado pelo usuário

        Tabuleiro tabuleiro = new Tabuleiro(); // declaração do objeto tabuleiro
        Jogador jogador = new Jogador(); // declaração do objeto jogador
        Computador computador = null; // declaração do objeto computador
        
        System.out.print("Nível selecionado: "); // imprime na tela a mensagem
        Boolean b = false; // declaração da variável b com valor false

        switch(nivel)  //estrutura de nível
        {
          case "a": // caso seja a
            System.out.print("(Fácil)"); 
            computador = new ComputadorA();
          break; // break encerra o switch
          case "b": // caso seja b
            System.out.print("(Médio)"); // imprime na tela a mensagem mostrada na linha acima
            computador = new ComputadorB(tabuleiro);
          break;
          case "c": // caso seja c
            System.out.print("(Já sou adulto)"); 
            computador = new ComputadorC(tabuleiro); // declaração do objeto computador com valor ComputadorC
          break; 
          default : // caso não seja nenhum dos casos anteriores
            System.out.println("Valor inválido!"); 
            b = true; 
          break;
        }

        if (b) //estrutura de validação
        {
          System.out.println("Tente novamente."); // imprime na tela a mensagem mostrada na linha acima
          return;
        }
        
        System.out.print("\n\n");
        System.out.println("=============================");
        
        tabuleiro.modelo();


        FluxoDoJogo fluxoDoJogo = new FluxoDoJogo(jogador, computador, tabuleiro); // declaração do objeto fluxoDoJogo com valor FluxoDoJogo

        // Fluxo principal do programa
        fluxoDoJogo.jogar();
    }
}

