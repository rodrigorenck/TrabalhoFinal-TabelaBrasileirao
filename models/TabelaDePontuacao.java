package e6.models;

import e6.models.Pontuacao;

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

    //metodo que verifica se um clube ja foi add na tabela
    public boolean verifica(String nomeDoClube){
        for(int i = 0; i<posicao; i++){
            if(lista[i].getNome().equalsIgnoreCase(nomeDoClube)) return true;
        }
        return false;
    }

    public boolean inserir(Pontuacao pontuacao){
        if(posicao==lista.length) return false;
        //se ao passar o nome do clube da pontuacao eu receber true é porque ele ja esta na tabela entao eu tenho que atualizar a linha
        //logo eu devolvo false pois nao quero inserir ele
        if(verifica(pontuacao.getNome())) return false;
        lista[posicao] = pontuacao;
        posicao++;
        return true;
    }

    public Pontuacao buscaTimePeloNome(String nome){
        for(int i = 0; i<posicao; i++){
            if(lista[i].getNome().equalsIgnoreCase(nome)) return lista[i];
        }
        return null;
    }

    //ordena com base nos pontos
    public void ordena(){
        Pontuacao aux;
        int r;
        for(int i=0; i<posicao-1; i++){
            for(int j=0; j<posicao-1-i; j++){
                if(lista[j].getPontos()<lista[j+1].getPontos()){
                    aux = lista[j];
                    lista[j] = lista[j+1];
                    lista[j+1] = aux;
                }
            }
        }
    }



}
