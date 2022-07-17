package tabelaBrasileirao.models;

//Autores: Rodrigo Renck, Arthur Bonazzi, Enrico Cidade
public class ListaDePartidas {
    private Partida[] lista;
    private int posicao; //numero de partidas que ja estao na lista
    private int codigoPartida;


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
        codigoPartida++;
        posicao++;
        return true;
    }

    public void ordena(){
        Partida aux;
        for(int i=0; i<posicao-1; i++){
            for(int j=0; j<posicao-1-i; j++){
                if(Integer.valueOf(lista[j].getData())>Integer.valueOf(lista[j+1].getData())){
                    aux = lista[j];
                    lista[j] = lista[j+1];
                    lista[j+1] = aux;
                }
            }
        }
    }



    public int getPosicao() {
        return posicao;
    }

    public Partida buscaPartida(int posicaoPartida) {
        for(int i = 0; i<posicao; i++){
            if(lista[i].getCodigo()==posicaoPartida){
                return lista[i];
            }
        }
        return null;
    }
}
