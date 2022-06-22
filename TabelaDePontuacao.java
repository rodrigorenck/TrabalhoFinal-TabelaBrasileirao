package e6;

public class TabelaDePontuacao {
    private Pontuacao[] lista;
    private int posicao;


    //criamos ja com vinte pois são 20 times que jogam o brasileirao
    public TabelaDePontuacao(){
        lista = new Pontuacao[20];
    }

    @Override
    public String toString() {
        String pontuacao = "";
        if(posicao==0) return "Tabela vazia";
        for(int i = 0; i<posicao; i++){
            pontuacao += lista[i] + "\n";
        }
        return pontuacao;
    }



}
