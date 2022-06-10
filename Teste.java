package e6;

import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);

        System.out.print("Informe o codigo do time: ");
        int codigo = in.nextInt();
        System.out.print("Informe o time: ");
        String nome = in2.nextLine();

        Pontuacao pont = new Pontuacao(codigo, nome);


        int golsPro;
        int golsContra;
        do {
            System.out.println("Informe quantos gols a favor e quantos gols contra: ");
            golsPro = in.nextInt();
            golsContra = in.nextInt();
        } while (golsPro < 0 || golsContra < 0);


        pont.setGolsPro(golsPro);
        pont.setGolsContra(golsContra);
        pont.atualiza();

        System.out.println(pont);



        System.out.println();
        System.out.println("OUTRA PARTIDA");
        do {
            System.out.println("Informe quantos gols a favor e quantos gols contra: ");
            golsPro = in.nextInt();
            golsContra = in.nextInt();
        } while (golsPro < 0 || golsContra < 0);


        pont.setGolsPro(golsPro);
        pont.setGolsContra(golsContra);
        pont.atualiza();

        System.out.println(pont);




    }
}
