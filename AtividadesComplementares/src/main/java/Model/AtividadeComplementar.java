package Model;

public class AtividadeComplementar implements Atividade{
    private String id;
    private String descricao;
    private HoraPorAtividade horaPorAtividade;
    private int limiteMaximo;
    private Modalidade modalidade;
    private Documentacao documentacao;

    @Deprecated
    public AtividadeComplementar(String descricao, HoraPorAtividade horaPorAtividade, int limiteMaximo, Modalidade modalidade, Documentacao documentacao) {
        this.limiteMaximo = limiteMaximo;
        this.horaPorAtividade = horaPorAtividade;
        this.descricao = descricao;
        this.modalidade = modalidade;
        this.documentacao = documentacao;
    }
    public AtividadeComplementar(String descricao, HoraPorAtividade horaPorAtividade, int limiteMaximo, Modalidade modalidade, Documentacao documentacao, String id) {
        this.limiteMaximo = limiteMaximo;
        this.id = id;
        this.horaPorAtividade = horaPorAtividade;
        this.descricao = descricao;
        this.modalidade = modalidade;
        this.documentacao = documentacao;
    }

    public String id(){
        return this.id;
    }

    public String descricao(){
        return this.descricao;
    }

    public HoraPorAtividade horaPorAtividade(){
        return this.horaPorAtividade;
    }
    @Override
    public int horas(){
        return this.limiteMaximo;
    }

    public Atividade atividade() {
        return this;
    }

    public Modalidade modalidade(){
        return this.modalidade;
    }

    public Documentacao documentacao(){
        return this.documentacao;
    }



}
