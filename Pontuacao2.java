package e6;

//fazendo as alteracoes para trabalhar com partida
public class Pontuacao2 {
    private int codigo;
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

    public Pontuacao2(int codigo, String timeCasa, String timeVisitante){
        this.codigo = codigo;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "[CODIGO]" + codigo + " - [TIME]" + nome + " - [PONTOS]" + pontos + " - [JOGOS]" + jogos +
                " - [VITORIAS]" + vitorias + " - [EMPATES]" + empates + " - [DERROTAS]" + derrotas +
                " - [GOLS PRO]" + golsPro + " - [GOLS CONTRA]" + golsContra + " - [SALDO GOLS]" + saldoGols +
                " - [APROVEITAMENTO]" + aproveitamento + "%";
    }

//    public void atualizaGolsPro(int golsPro) {
//        this.golsPro += golsPro;
//    }
//
//    public void atualizaGolsContra(int golsContra) {
//        this.golsContra += golsContra;
//    }

    public void atualizaPartida(Partida partida){
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
        this.saldoGols = golsPro - golsContra;
        this.aproveitamento = (pontos*100)/(double)(jogos*3);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
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
