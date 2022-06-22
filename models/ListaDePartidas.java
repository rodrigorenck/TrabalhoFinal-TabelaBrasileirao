package e6.models;

import e6.models.Partida;

public class ListaDePartidas {
    private Partida[] lista;
    private int posicao; //numero de partidas que ja estao na lista


    public ListaDePartidas(int tamanho){
        if(tamanho<10) tamanho = 10;
        lista = new Partida[tamanho];
        posicao = 0;
    }

    @Override
    public String toString() {
        String partidas = "";
        if(posicao==0) return "Não há partidas criadas";
        for(int i = 0; i<posicao; i++){
            partidas += lista[i] + "\n";
        }
        return partidas;
    }

    public boolean inserir(Partida partida){
        //se tentar add uma partida e a lista ja tiver cheia retorna
        if(posicao== lista.length) return false;
        //aqui fazemos uma validação para garantir que o usuario nao inseriu o time jogando contra ele proprio
        if(partida.getTimeCasa().equalsIgnoreCase(partida.getTimeVisitante())) return false;
        lista[posicao] = partida;
        posicao++;
        return true;
    }

    public int getPosicao() {
        return posicao;
    }

    //public boolean







}
