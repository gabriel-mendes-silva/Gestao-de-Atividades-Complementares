package Model;

public class AtividadeDeclarada implements Atividade{
    private AtividadeComplementar atividadeComplementar;

    private Requerimento requerimento;
    private String documento;
    private String id;
    private int horasApresentadas;




    public AtividadeDeclarada(AtividadeComplementar atividadeComplementar, String documento, int horasApresentadas, Requerimento requerimento) {
        this.atividadeComplementar = atividadeComplementar;
        this.documento = documento;
        if(horasApresentadas >= 0){
            this.horasApresentadas = horasApresentadas;
        }
        this.requerimento = requerimento;
    }
    public AtividadeDeclarada(AtividadeComplementar atividadeComplementar, String documento, int horasApresentadas, String id, Requerimento requerimento) {
        this.atividadeComplementar = atividadeComplementar;
        this.documento = documento;
        if(horasApresentadas >= 0){
            this.horasApresentadas = horasApresentadas;
        }
        this.id = id;
        this.requerimento = requerimento;
    }
    @Override
    public int horas() {
        return this.horasApresentadas;
    }

    public String nomeAtividadeComplementar(){
        return this.atividadeComplementar.descricao();
    }

    public AtividadeComplementar AtividadeComplementar(){
        return this.atividadeComplementar;
    }

    public int limiteDeHoras(){
        return this.atividadeComplementar.horas();
    }

    public Modalidade modalidade(){
        return this.atividadeComplementar.modalidade();
    }

    public String documento() {
        return documento;
    }

    public String id() {
        return id;
    }

    public Requerimento requerimento() {
        return requerimento;
    }
}
