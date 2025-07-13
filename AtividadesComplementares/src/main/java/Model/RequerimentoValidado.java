package Model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class RequerimentoValidado {
    private String validador;
    private Date dataDeEmissão;
    private Requerimento requerimento;
    private List<AtividadeValidada> atividadesValidadas;

    public RequerimentoValidado(Requerimento requerimento, String validador) {
        this.dataDeEmissão = Date.from(Instant.now());
        this.requerimento = requerimento;
        this.validador = validador;
        this.atividadesValidadas = new ArrayList<>();
    }

    public void validar(){
        Scanner scanner = new Scanner(System.in);
        for (AtividadeDeclarada atividadeDeclarada : requerimento.getAtividadesDeclarada()) {
            System.out.println(
                    "---------------------------------------------------------------------\n" +
                    "Atividade: " + atividadeDeclarada.nomeAtividadeComplementar() + "\n" +
                    "limite máximo: " + atividadeDeclarada.limiteDeHoras() + " hrs\n" +
                    "horas apresentadas: " + atividadeDeclarada.horas() + "hrs"
            );
            int horasValidas = 0;

            System.out.println("É válido? s/n");
            if(scanner.next().equals("s")){
                System.out.println("Quantas horas são válidas?");
                horasValidas = Integer.parseInt(scanner.next().trim());
            }
            this.adicionar(new AtividadeValidada(atividadeDeclarada, horasValidas));
        }
    }

    public void adicionar(AtividadeValidada atividadeValida){
        this.atividadesValidadas.add(atividadeValida);
    }

    public List<AtividadeValidada> getAtividadesValidadas() {
        return atividadesValidadas;
    }

    public int totalDeHorasValidadas(Filtro filtro){
        int total = 0;
        for (AtividadeValidada atividadeValidada:atividadesValidadas) {
            if(filtro.isSatisfiedBy(atividadeValidada)){
                total += atividadeValidada.horas();
            }
        }
        return total;
    }
}
