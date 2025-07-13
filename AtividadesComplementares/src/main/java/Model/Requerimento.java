package Model;

import java.text.ParseException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Requerimento {
    private String id;
    private String numero;
    private Date data;
    private Aluno aluno;
    private List<AtividadeDeclarada> atividadesDeclaradas;
    public Requerimento(String numero, Aluno aluno) throws ParseException {
        this.numero = numero;
        this.aluno = aluno;
        this.data = Date.from(Instant.now());
        this.atividadesDeclaradas = new ArrayList<>();
    }

    public void adicionarAtividade(AtividadeDeclarada atividadeDeclarada){
        this.atividadesDeclaradas.add(atividadeDeclarada);
    }

    public List<AtividadeDeclarada> getAtividadesDeclarada() {
        return atividadesDeclaradas;
    }

    public int totalHorasDeclaradas(Filtro filtro){
        int total = 0;
        for (AtividadeDeclarada atividadeDeclarada : atividadesDeclaradas) {
            if(filtro.isSatisfiedBy(atividadeDeclarada)){
                total += atividadeDeclarada.horas();
            }
        }
        return total;
    }

    public Date data(){
        return this.data;
    }

    public String numero() {
        return numero;
    }
}
