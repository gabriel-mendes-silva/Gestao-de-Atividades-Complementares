package Model;

public class FiltroPorModalidade implements Filtro{
    private Modalidade modalidade;

    public FiltroPorModalidade(Modalidade modalidade){
        this.modalidade = modalidade;
    }

    @Override
    public boolean isSatisfiedBy(Atividade atividade) {
        if(atividade.modalidade().equals(this.modalidade)){
            return true;
        }
        else{
            return false;
        }
    }
}
