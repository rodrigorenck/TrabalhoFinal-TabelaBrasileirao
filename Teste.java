package e6;

import e6.models.Partida;
import e6.models.Pontuacao;

public class Teste {

    public static void main(String[] args) {
        Partida partida = new Partida("Inter", 6, "Flamengo", 4, "15/06/2022", "17:30");

        Pontuacao pont = new Pontuacao(partida.getTimeCasa());

        pont.atualizaGolsPro(partida.getGolsPro());
        pont.atualizaGolsContra(partida.getGolsContra());

        //pont.atualizaPartida();

        System.out.println(pont);


    }
}
