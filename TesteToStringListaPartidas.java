package e6;

import e6.models.ListaDePartidas;
import e6.models.Partida;

public class TesteToStringListaPartidas {


    public static void main(String[] args) {
        ListaDePartidas lista = new ListaDePartidas(100);


        Partida p1 = new Partida("Inter", 3, "Botafogo", 2, "20/10/2022", "17:38");
        Partida p2 = new Partida("Flamengo", 2, "Cuiaba", 1, "15/10/2022", "15:25");
        Partida p3 = new Partida("Flamengo", 2, "Flamengo", 1, "15/10/2022", "15:25");

        lista.inserir(p1);
        lista.inserir(p2);

//        boolean sera = lista.inserir(p3);
//
//        System.out.println(sera);
//
//
//
//        System.out.println(lista.getPosicao());

        System.out.println(lista);
    }


}
