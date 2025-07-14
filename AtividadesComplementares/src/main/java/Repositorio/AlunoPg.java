package Repositorio;

import Model.Aluno;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoPg implements Persistencia<Aluno>{
    private DataSource dataSource;

    public AlunoPg(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Override
    public void inserir(Aluno aluno) {
        String sql = "INSERT INTO ALUNO (NOME,MATRICULA) VALUES (?,?)";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, aluno.nome());
            stmt.setString(2, aluno.matricula());
            stmt.executeUpdate();
        }
        catch (SQLException _) {
            throw new RuntimeException("Falha na conexão com o banco");
        }
    }

    @Override
    public Aluno buscarPorId(int id) {
        String sql = "SELECT ID, NOME, MATRICULA FROM ALUNO WHERE ID = ?";
        try(Connection connection = dataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            try(ResultSet resultSet = stmt.executeQuery()){
                if(resultSet.next()){
                    Aluno aluno = new Aluno(
                            resultSet.getString("nome"),
                            resultSet.getString("matricula"),
                            String.valueOf(id));
                    return aluno;
                }
                else{
                    return null;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException _) {
            throw new RuntimeException("Falha em buscar no banco de dados");
        }
    }
}
