package e6;

import java.util.*;

public class Aplicacao {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner inStr = new Scanner(System.in);//Scanner que usaremos para ler Strings

        TabelaDePontuacao tabelaBrasileirao = new TabelaDePontuacao();
        ListaDePartidas lista = new ListaDePartidas(100);
        int opcao;

        do {
            System.out.println("---- MENU ----");
            System.out.println("1 - Cria partida");
            System.out.println("2 - Lista partidas");
            System.out.println("3 - Mostra a pontuacao de um time especifico");
            System.out.println("4 - Mostra a tabela completa");
            opcao = in.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Fim do programa");
                    break;
                case 1:
                    System.out.println("\nCria partida");
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
                    boolean result = lista.inserir(partida);
                    System.out.println(partida);
                    break;
                case 2:
                    System.out.println();
            }
        } while (opcao != 0);


    }
}
