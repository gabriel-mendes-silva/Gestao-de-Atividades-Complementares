package Repositorio;

import Model.Modalidade;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModalidadePg implements Persistencia<Modalidade>{
    private DataSource dataSource;

    public ModalidadePg(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void inserir(Modalidade modalidade) {
        String sql = "INSERT INTO MODALIDADE (NOME, PORCENTAGEM_MAXIMA) VALUES (?,?);";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, modalidade.nome());
            stmt.setDouble(2,modalidade.porcentagemMaxima());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Modalidade buscarPorId(int id) {
        String sql = "SELECT ID, NOME, PORCENTAGEM_MAXIMA FROM MODALIDADE WHERE ID = ?;";
        try(Connection connection = dataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            try(ResultSet resultSet = stmt.executeQuery()){
                if(resultSet.next()){
                    Modalidade modalidade = new Modalidade(
                            resultSet.getString("nome"),
                            resultSet.getDouble("porcentagem_maxima"),
                            String.valueOf(id)
                    );
                    return modalidade;
                }
                else{
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
