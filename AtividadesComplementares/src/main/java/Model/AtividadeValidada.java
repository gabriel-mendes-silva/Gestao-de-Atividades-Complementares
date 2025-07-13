package Model;

public class AtividadeValidada implements Atividade{
    private AtividadeDeclarada atividadeDeclarada;
    private int horasValidadas;

    public AtividadeValidada(AtividadeDeclarada atividadeDeclarada,int horasValidadas){
        this.atividadeDeclarada = atividadeDeclarada;
        this.horasValidadas = horasValidadas;
    }
    @Override
    public int horas() {
        return this.horasValidadas;
    }

    public Modalidade modalidade(){
        return this.atividadeDeclarada.modalidade();
    }
}
