package e6;

public class Teste2 {

    public static void main(String[] args) {

        Pontuacao pontuacao = new Pontuacao(1, "Inter");

        pontuacao.atualizaGolsPro(4);
        pontuacao.atualizaGolsContra(5);

        pontuacao.atualizaPartida();
        System.out.println(pontuacao);


    }
}
