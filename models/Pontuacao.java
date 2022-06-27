package e6.models;

public class Pontuacao {
    private String nome;
    private int pontos;
    private int jogos;
    private int vitorias;
    private int empates;
    private int derrotas;
    private int golsPro;
    private int golsContra;
    private int saldoGols;
    private double aproveitamento;

    public Pontuacao(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        String formatando = String.format("%10s - [PONTOS]%d - [JOGOS]%d - [VITORIAS]%d - [EMPATES]%d - [DERROTAS]%d - [GOLS PRO]%d - [GOLS CONTRA]%d - [SALDO GOLS]%d - [APROVEITAMENTO]%.00f",
                nome, pontos, jogos, vitorias, empates, derrotas, golsPro, golsContra, saldoGols, aproveitamento);
        return formatando;
//        return "[TIME]" + nome + " - [PONTOS]" + pontos + " - [JOGOS]" + jogos +
//                " - [VITORIAS]" + vitorias + " - [EMPATES]" + empates + " - [DERROTAS]" + derrotas +
//                " - [GOLS PRO]" + golsPro + " - [GOLS CONTRA]" + golsContra + " - [SALDO GOLS]" + saldoGols +
//                " - [APROVEITAMENTO]" + aproveitamento + "%";
    }

//    public void atualizaGolsPro(int golsPro) {
//        this.golsPro += golsPro;
//    }
//
//    public void atualizaGolsContra(int golsContra) {
//        this.golsContra += golsContra;
//    }

    public void atualizaPartida(int golsPro, int golsContra){
        this.jogos++;
        if(golsPro>golsContra){
            this.vitorias++;
            this.pontos += 3;
        }else if(golsPro == golsContra){
            this.empates++;
            this.pontos += 1;
        }else{
            this.derrotas++;
        }
        this.golsPro += golsPro;
        this.golsContra += golsContra;
        this.saldoGols = golsPro - golsContra;
        this.aproveitamento = (pontos*100)/(double)(jogos*3);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getNome() {
        return nome;
    }

    public int getPontos() {
        return pontos;
    }

    public double getJogos() {
        return jogos;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int getEmpates() {
        return empates;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getGolsPro() {
        return golsPro;
    }

    public int getGolsContra() {
        return golsContra;
    }

    public int getSaldoGols() {
        return saldoGols;
    }

    public double getAproveitamento() {
        return aproveitamento;
    }
}
