package e6;

import e6.models.Pontuacao;

import java.util.Scanner;

//Autores: Rodrigo Renck e Arthur Bonazzi
public class AppPontuacao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner str = new Scanner(System.in);

        int codigo;
        String nome;

        System.out.println("PRIMEIRO TIME:");
        do{
            System.out.print("Informe o codigo do time: ");
            codigo = sc.nextInt();
        }while(codigo<0);

        do{
            System.out.print("Informe o nome do time: ");
            nome = str.nextLine();
        }while(nome.equalsIgnoreCase("gremio"));

        Pontuacao time1 = new Pontuacao(nome);

        int golsPro;
        int golsContra;
        do{
            System.out.print("Gols a favor: ");
            golsPro = sc.nextInt();
        }while(golsPro<0);
        do{
            System.out.print("Gols contra: ");
            golsContra = sc.nextInt();
        }while(golsContra<0);

        time1.atualizaGolsPro(golsPro);
        time1.atualizaGolsContra(golsContra);
        time1.atualizaPartida(golsPro, golsContra);

        System.out.println(time1);

        System.out.println("");
        System.out.println("SEGUNDO TIME");
        do{
            System.out.print("Informe o codigo do time: ");
            codigo = sc.nextInt();
        }while(codigo<0);

        do{
            System.out.print("Informe o nome do time: ");
            nome = str.nextLine();
        }while(nome.equalsIgnoreCase("gremio"));

        Pontuacao time2 = new Pontuacao( nome);

        do{
            System.out.print("Gols a favor: ");
            golsPro = sc.nextInt();
        }while(golsPro<0);
        do{
            System.out.print("Gols contra: ");
            golsContra = sc.nextInt();
        }while(golsContra<0);

        time2.atualizaGolsPro(golsPro);
        time2.atualizaGolsContra(golsContra);
        time2.atualizaPartida(golsPro, golsContra);

        System.out.println(time2);
    }
}
