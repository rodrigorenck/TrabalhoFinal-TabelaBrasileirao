package e6.models;


public class Partida {

    private int codigo;
    private String timeCasa;
    private String timeVisitante;
    //golsPro e contra em relacao ao time da casa!
    private int golsPro;
    private int golsContra;
    //data e horario tem que ser uma String?

    //data usaremos de tras para frente para facilitar na ordenacao
    private String data;

    //data que usaremos no toString
    private String dataCerta;
    private String horario;

    //tenho que fazer verificacos aqui no construtor? ou posso fazer no main
    public Partida(int codigo, String timeCasa, int golsPro, String timeVisitante, int golsContra, String data, String dataCerta, String horario){
        this.codigo = codigo;
        this.timeCasa = timeCasa;
        this.golsPro = golsPro;
        this.timeVisitante = timeVisitante;
        this.golsContra = golsContra;
        this.data = data;
        this.dataCerta = dataCerta;
        this.horario = horario;
    }

    @Override
    public String toString() {
        String formatando = String.format("%d [DATA]%s [HORA]%s [%s] %d X  %d [%s] ",codigo, dataCerta, horario, timeCasa, golsPro,golsContra, timeVisitante);
        return formatando;
    }

    //devolve o vencedor da partida
    public String vencedor(){
        if(this.golsPro>golsContra){
            return timeCasa;
        }else if(this.golsPro == this.golsContra){
            return "Empate";
        }
        return timeVisitante;
    }

    public String getTimeCasa() {
        return timeCasa;
    }

    public String getTimeVisitante() {
        return timeVisitante;
    }

    public int getGolsPro() {
        return golsPro;
    }

    public int getGolsContra() {
        return golsContra;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public int getCodigo() {
        return codigo;
    }
}
