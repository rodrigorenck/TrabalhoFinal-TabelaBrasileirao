package e6;

public class Pontuacao {
    /*
    DUVIDAS
    1. Faco getter para todos?
    2. Nao vou precisar de setter ne
    3. Metodo partida esta certo?
    4. Posso fazer a validacao das entradas no Main?
     */
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

    public Pontuacao(int codigo, String nome){
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

    public void setGolsPro(int golsPro) {
        this.golsPro = golsPro;
    }

    public void setGolsContra(int golsContra) {
        this.golsContra = golsContra;
    }


    //Problema - golspro e golscontra nao sao somados! - diferente do partida()
    public void atualiza(){
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
        int saldo = golsPro - golsContra;
        this.saldoGols += saldo;
//        this.golsPro += golsPro;
//        this.golsContra += golsContra;
        this.aproveitamento = (vitorias/(double)jogos)*100;
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
