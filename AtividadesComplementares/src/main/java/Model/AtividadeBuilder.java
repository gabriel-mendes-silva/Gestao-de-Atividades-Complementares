package Model;

public class AtividadeBuilder {
    private String id;
    private String descricao;
    private HoraPorAtividade horaPorAtividade;
    private int limiteMaximo;
    private Modalidade modalidade;
    private Documentacao documentacao;

    public AtividadeBuilder documentacao(Documentacao documentacao) {
        this.documentacao = documentacao;
        return this;
    }

    public AtividadeBuilder horaPorAtividade(HoraPorAtividade horaPorAtividade) {
        this.horaPorAtividade = horaPorAtividade;
        return this;
    }

    public AtividadeBuilder id(String id) {
        this.id = id;
        return this;
    }

    public AtividadeBuilder limiteMaximo(int limiteMaximo) {
        this.limiteMaximo = limiteMaximo;
        return this;
    }

    public AtividadeBuilder modalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
        return this;
    }

    public AtividadeBuilder descricao(String descricao){
        this.descricao = descricao;
        return this;
    }
    public AtividadeComplementar build(){
        return new AtividadeComplementar(descricao,horaPorAtividade,limiteMaximo,modalidade,documentacao,id);
    }
}
