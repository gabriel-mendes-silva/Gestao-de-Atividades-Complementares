package Repositorio;

import Model.Documentacao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentacaoPg implements Persistencia<Documentacao>{
    private DataSource dataSource;

    public DocumentacaoPg(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void inserir(Documentacao documentacao) {
        String sql = "INSERT INTO DOCUMENTACAO_COMPROBATORIA (DESCRICAO) VALUES (?);";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, documentacao.descricao());
            stmt.executeUpdate();
        }
        catch(SQLException e){
            throw new RuntimeException("Falha na conexão com o banco");
        }
    }

    @Override
    public Documentacao buscarPorId(int id) {
        String sql = "SELECT ID, DESCRICAO FROM DOCUMENTACAO_COMPROBATORIA WHERE ID = ?";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            try(ResultSet resultSet = stmt.executeQuery()){
                if(resultSet.next()){
                    Documentacao documentacao = new Documentacao(
                            resultSet.getString("descricao"),
                            String.valueOf(id)
                    );
                    return documentacao;
                }
                else{
                    return null;
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
