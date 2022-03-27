package com.uninter.model.jogo;  // importação para conectar todas as classes do pacote com o Main


import java.util.ArrayList;    // importação para usar as bibliotecas
import java.util.Arrays;
import java.util.List;

public class Tabuleiro { 
    private static String[][] tabuleiro; // declaração da matriz do tabuleiro

    public Tabuleiro() {
        tabuleiro = new String[][]      
                {{"   ", "|", "   ", "|", "   "},  // declaração da matriz do tabuleiro com 5 linhas e 5 colunas
                {"---", "+", "---", "+", "---"},       
                {"   ", "|", "   ", "|", "   "},  //faz imprimir o tabuleiro em formato de texto
                {"---", "+", "---", "+", "---"},
                {"   ", "|", "   ", "|", "   "}};
    }

    public void mostrarTabuleiro(){ // método para mostrar o tabuleiro
        for (String[] row : tabuleiro) {  // for para percorrer as linhas da matriz
            for (String c : row) {        // for um lanço de repetição para percorrer as colunas da matriz
                System.out.print(c);
            }
            System.out.println();        // imprime uma quebra de linha
        }
    }

    public void marcarPosicao(int posicao, String jogador){ // método para marcar a posição do tabuleiro
        String symbol = jogador;
 
        switch (posicao) { // switch para verificar a posição do tabuleiro
            case 1:
                tabuleiro[0][0] = symbol;
                break;
            case 2:
                tabuleiro[0][2] = symbol;  // case marca a posição do tabuleiro
                break;
            case 3:
                tabuleiro[0][4] = symbol;
                break;
            case 4:
                tabuleiro[2][0] = symbol;
                break;
            case 5:
                tabuleiro[2][2] = symbol;
                break;
            case 6:
                tabuleiro[2][4] = symbol;
                break;
            case 7:
                tabuleiro[4][0] = symbol;
                break;
            case 8:
                tabuleiro[4][2] = symbol;
                break;
            case 9:
                tabuleiro[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public boolean verificarPosicao(int posicao){ // método para verificar se a posição do tabuleiro está vazia
        switch (posicao) {
            case 1:
                return tabuleiro[0][0] == "   ";
            case 2:
                return tabuleiro[0][2] == "   ";
            case 3:
                return tabuleiro[0][4] == "   "; // case verifica se a posição do tabuleiro está vazia
            case 4:
                return tabuleiro[2][0] == "   ";
            case 5:
                return tabuleiro[2][2] == "   ";
            case 6:
                return tabuleiro[2][4] == "   ";
            case 7:
                return tabuleiro[4][0] == "   ";
            case 8:
                return tabuleiro[4][2] == "   ";
            case 9:
                return tabuleiro[4][4] == "   ";
            default:
                return false;
        }
    }

    public boolean condicaoDeVitoria(ArrayList<Integer> posicoes){ // método para verificar se o jogador venceu
        List linha1 = Arrays.asList(1,2,3);
        List linha2 = Arrays.asList(4,5,6);
        List linha3 = Arrays.asList(7,8,9);
        List coluna1 = Arrays.asList(1,4,7); // listas para verificar se o jogador venceu
        List coluna2 = Arrays.asList(2,5,8);
        List coluna3 = Arrays.asList(3,6,9);
        List diagonal1 = Arrays.asList(1,5,9);
        List diagonal2 = Arrays.asList(3,5,7);

        List<List> listaDeCondicoes = new ArrayList<>(); // lista para armazenar as listas de condições
        listaDeCondicoes.addAll(Arrays.asList(linha1,linha2,linha3,coluna1, coluna2, coluna3, diagonal1, diagonal2)); // adiciona as listas de condições na lista de condições

        for (List lista : listaDeCondicoes) {  // for para percorrer as listas de condições
            if(posicoes.containsAll(lista)){ // verifica se a lista de posições contém todas as posições da lista de condições
                return true; // retorna true se o jogador venceu
            }
        }
        return false;
    }

    public void modelo(){ // método para mostrar o modelo do tabuleiro
        System.out.println(
                "Ao jogar, você deve escolher uma das posições disponíveis no tabuleiro.\n" +
                "Cada posição possui um número que representa a posição no tabuleiro.\n" + 
                "Caso uma posição esteja ocupada por um X ou O, você não pode escolher essa posição.\n\n" +
                "  1 | 2 | 3 \n" +
                " ---+---+---\n" +
                "  4 | 5 | 6 \n" +  // modelo do tabuleiro
                " ---+---+---\n" +
                "  7 | 8 | 9 \n"
        );
    }
}
