package Model;

public class FiltroNulo implements Filtro{
    @Override
    public boolean isSatisfiedBy(Atividade atividade) {
        return true;
    }
}
