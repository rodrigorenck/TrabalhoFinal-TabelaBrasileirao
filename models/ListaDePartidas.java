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


    //ordenar conforme a data - bem dificil pois data e hora vem como Strings entao eu teria que transformar em int pra fazer a comparacao
//    public void ordena(){
//        Partida aux;
//        int r;
//        for(int i=0; i<posicao-1; i++){
//            String data = lista[i].getData();
//            String[] divide = data.split("/");
//            for(int j=0; j<posicao-1-i; j++){
//                if(lista[j].getData()<lista[j+1].getPontos()){
//                    aux = lista[j];
//                    lista[j] = lista[j+1];
//                    lista[j+1] = aux;
//                }
//            }
//        }
//    }

    public int getPosicao() {
        return posicao;
    }

    //public boolean







}
