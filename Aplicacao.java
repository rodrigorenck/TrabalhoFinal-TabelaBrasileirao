package tabelaBrasileirao;

import tabelaBrasileirao.models.ListaDePartidas;
import tabelaBrasileirao.models.Partida;
import tabelaBrasileirao.models.Pontuacao;
import tabelaBrasileirao.models.TabelaDePontuacao;

import java.util.Scanner;

//Autores: Rodrigo Renck, Arthur Bonazzi, Enrico Cidade
public class Aplicacao {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Scanner inStr = new Scanner(System.in);//Scanner que usaremos para ler Strings

        TabelaDePontuacao tabelaBrasileirao = new TabelaDePontuacao();
        ListaDePartidas lista = new ListaDePartidas(100);
        int opcao;


        int codigoPartida = 1;
        do {

            System.out.println("\n---- MENU ----");
            System.out.println("0 - Encerra o programa");
            System.out.println("1 - Cria partida");
            System.out.println("2 - Lista partidas");
            System.out.println("3 - Mostra a pontuacao de um time especifico");
            System.out.println("4 - Mostra a tabela completa");
            System.out.println("5 - Alterar nome do clube");
            System.out.println("6 - Mostra uma partida especifica");
            opcao = in.nextInt();
            switch (opcao) {
                case 0:
                    System.out.println("[Fim do programa]");
                    break;
                case 1:
                    System.out.println("\n[Cria Partida]");
                    System.out.println("Data(dia/mes/ano): ");
                    System.out.print("Dia:");
                    String dia = in.next();
                    System.out.print("Mes:");
                    String mes = in.next();
                    System.out.print("Ano:");
                    String ano = in.next();
                    String data = ano + mes + dia;
                    String dataCerta = dia  + "/" + mes + "/" + ano;
                    System.out.print("Hora: ");
                    String hora = inStr.nextLine();
                    System.out.print("Time da casa: ");
                    String timeCasa = inStr.nextLine();
                    System.out.print("Gols: ");
                    int golsPro = in.nextInt();
                    System.out.print("Time visitante: ");
                    String timeVisitante = inStr.nextLine();
                    System.out.print("Gols: ");
                    int golsContra = in.nextInt();
                    Partida partida = new Partida(codigoPartida, timeCasa, golsPro, timeVisitante, golsContra, data, dataCerta, hora);
                    if (lista.inserir(partida)) {
                        System.out.println("Partida criada com sucesso");
                        codigoPartida++;
                        //se o time ja esta na tabela - pega ele e atualiza os dados
                        if(tabelaBrasileirao.verifica(timeCasa)){
                            Pontuacao atualizarPontuacao = tabelaBrasileirao.buscaTimePeloNome(timeCasa);
                            atualizarPontuacao.atualizaPartida(golsPro, golsContra);
                        }else{ //se o time ainda nao foi adicionado - cria uma linha para ele e insere essa linha na tabela
                            Pontuacao criarPontuacao = new Pontuacao(timeCasa);
                            criarPontuacao.atualizaPartida(golsPro, golsContra);
                            tabelaBrasileirao.inserir(criarPontuacao);
                        }
                        //aqui fazemos a mesma coisa so que para o time visitante
                        if(tabelaBrasileirao.verifica(timeVisitante)){
                            Pontuacao atualizarPontuacao = tabelaBrasileirao.buscaTimePeloNome(timeVisitante);
                            atualizarPontuacao.atualizaPartida(golsContra, golsPro);
                        }else{
                            Pontuacao criarPontuacao = new Pontuacao(timeVisitante);
                            criarPontuacao.atualizaPartida(golsContra, golsPro);
                            tabelaBrasileirao.inserir(criarPontuacao);
                        }
                    } else {
                        System.out.println("Não foi possivel criar a partida");
                    }
                    break;
                case 2:
                    System.out.println("\n[Lista Partidas]");
                    System.out.println("TOTAL DE PARTIDAS: " + lista.getPosicao());
                    lista.ordena();
                    System.out.println(lista);
                    break;
                case 3:
                    System.out.println("\n[Mostra a pontuacao de um time especifico]");
                    System.out.print("Informe o time que deseja: ");
                    String time = inStr.nextLine();
                    Pontuacao p  = tabelaBrasileirao.buscaTimePeloNome(time);
                    if(p == null){
                        System.out.println("Time ainda não foi adicionado a tabela");
                    }else{
                        System.out.println(p);
                    }
                    break;
                case 4:
                    System.out.println("\n[Mostra a tabela completa]");
                    tabelaBrasileirao.ordena();
                    System.out.println(tabelaBrasileirao);
                    break;
                case 5:
                    System.out.println("\n[Alterar nome de um clube]");
                    System.out.print("Clube que voce deseja mudar o nome: ");
                    String clube = inStr.nextLine();
                    System.out.print("Novo nome: ");
                    String novoClube = inStr.nextLine();
                    if(tabelaBrasileirao.verifica(novoClube)){
                        System.out.println("Erro! O novo nome ja existe na tabela!");
                    }else{
                        if(tabelaBrasileirao.verifica(clube)){
                            Pontuacao pontuacaoClube = tabelaBrasileirao.buscaTimePeloNome(clube);
                            pontuacaoClube.setNome(novoClube);
                        }else{
                            System.out.println("O clube que você quer mudar o nome nao existe");
                        }
                    }
                    break;
                case 6:
                    System.out.println("\n[Mostra uma partida especifica]");
                    System.out.println("Temos " + lista.getPosicao() + " partidas no total.");
                    System.out.print("Informe qual partida deseja: ");
                    int posicaoPartida = in.nextInt();
                    Partida partidaSolicitada = lista.buscaPartida(posicaoPartida);
                    if(partidaSolicitada == null){
                        System.out.println("Partida que voce deseja nao existe!");
                    }else{
                        System.out.println(partidaSolicitada);
                    }
                    break;
            }
        } while (opcao != 0);

    }
}
