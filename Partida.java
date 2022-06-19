package e6;


public class Partida {

    private String timeCasa;
    private String timeVisitante;
    //golsPro e contra em relacao ao time da casa!
    private int golsPro;
    private int golsContra;
    //data e horario tem que ser uma String?
    private String data;
    private String horario;

    //tenho que fazer verificacos aqui no construtor? ou posso fazer no main
    public Partida(String timeCasa, int golsPro, String timeVisitante, int golsContra, String data, String horario){
        this.timeCasa = timeCasa;
        this.golsPro = golsPro;
        this.timeVisitante = timeVisitante;
        this.golsContra = golsContra;
        this.data = data;
        this.horario = horario;
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
}
