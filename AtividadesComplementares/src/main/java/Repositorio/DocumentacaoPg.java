package Repositorio;

import Model.Documentacao;

import javax.sql.DataSource;

public class DocumentacaoPg implements Persistencia<Documentacao>{
    private DataSource dataSource;

    @Override
    public void inserir(Documentacao documentacao) {

    }

    @Override
    public Documentacao buscarPorId(int id) {
        return null;
    }
}
