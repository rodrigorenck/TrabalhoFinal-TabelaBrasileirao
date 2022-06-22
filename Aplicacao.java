package e6;

import e6.models.ListaDePartidas;
import e6.models.Partida;
import e6.models.Pontuacao;
import e6.models.TabelaDePontuacao;

import java.util.*;

public class Aplicacao {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Scanner inStr = new Scanner(System.in);//Scanner que usaremos para ler Strings

        TabelaDePontuacao tabelaBrasileirao = new TabelaDePontuacao();
        ListaDePartidas lista = new ListaDePartidas(100);
        int opcao;

        do {
            System.out.println("\n---- MENU ----");
            System.out.println("1 - Cria partida");
            System.out.println("2 - Lista partidas");
            System.out.println("3 - Mostra a pontuacao de um time especifico");
            System.out.println("4 - Mostra a tabela completa");
            opcao = in.nextInt();
            switch (opcao) {
                case 0:
                    System.out.println("[Fim do programa]");
                    break;
                case 1:
                    System.out.println("\n[Cria Partida]");
                    System.out.print("Data: ");
                    String data = inStr.nextLine();
                    System.out.print("Hora: ");
                    String hora = inStr.nextLine();
                    System.out.print("Time da casa: ");
                    String timeCasa = inStr.nextLine();
                    System.out.print("Gols: ");
                    int golsPro = in.nextInt();
                    System.out.print("Time visitante: ");
                    String timeVisitante = inStr.nextLine();
                    System.out.print("Gols: ");
                    int golsContra = in.nextInt();
                    Partida partida = new Partida(timeCasa, golsPro, timeVisitante, golsContra, data, hora);
                    if (lista.inserir(partida)) {
                        System.out.println("Partida criada com sucesso");
                    } else {
                        System.out.println("Não foi possivel criar a partida");
                    }
                    //como que eu verifico se o time ja esta na tabela? e como que eu atualizo o pontuacao com base na partida
                    if(tabelaBrasileirao.verifica(timeCasa)){
                        Pontuacao atualizarPontuacao = tabelaBrasileirao.buscaTimePeloNome(timeCasa);
//                        atualizarPontuacao.atualizaGolsPro(golsPro);
//                        atualizarPontuacao.atualizaGolsContra(golsContra);
                        atualizarPontuacao.atualizaPartida(golsPro, golsContra);
                        //tabelaBrasileirao.inserir(atualizarPontuacao);
                    }else{
                        Pontuacao criarPontuacao = new Pontuacao(timeCasa);
//                        criarPontuacao.atualizaGolsPro(golsPro);
//                        criarPontuacao.atualizaGolsContra(golsCo
                        criarPontuacao.atualizaPartida(golsPro, golsContra);
                        tabelaBrasileirao.inserir(criarPontuacao);
                    }
                    System.out.println(tabelaBrasileirao);
                    if(tabelaBrasileirao.verifica(timeVisitante)){
                        Pontuacao atualizarPontuacao = tabelaBrasileirao.buscaTimePeloNome(timeVisitante);
//                        atualizarPontuacao.atualizaGolsPro(golsContra);
//                        atualizarPontuacao.atualizaGolsContra(golsPro);
                        atualizarPontuacao.atualizaPartida(golsContra, golsPro);
                    }else{
                        Pontuacao criarPontuacao = new Pontuacao(timeVisitante);
//                        criarPontuacao.atualizaGolsPro(golsContra);
//                        criarPontuacao.atualizaGolsContra(golsPro);
                        criarPontuacao.atualizaPartida(golsContra, golsPro);
                    }
                    break;
                case 2:
                    System.out.println("\n[Lista Partidas]");
                    System.out.println("TOTAL DE PARTIDAS: " + lista.getPosicao());
                    System.out.println(lista);
                    break;
                case 3:
                    System.out.println("\n[Mostra a pontuacao de um time especifico]");
                    System.out.print("Informe o time que deseja: ");
                    String time = inStr.nextLine();
                    Pontuacao p  = tabelaBrasileirao.buscaTimePeloNome(time);
                    System.out.println(p);
//                    if(tabelaBrasileirao.buscaTimePeloNome(time)){
//                        System.out.println("Time ainda não foi adicionado a tabela");
//                    }else{
//                        System.out.println(tabelaBrasileirao.buscaTimePeloNome(time));
//                    }
                    break;
                case 4:
                    System.out.println("\n[Mostra a tabela completa]");
                    tabelaBrasileirao.ordena();
                    System.out.println(tabelaBrasileirao);
                    break;
            }
        } while (opcao != 0);


    }
}
