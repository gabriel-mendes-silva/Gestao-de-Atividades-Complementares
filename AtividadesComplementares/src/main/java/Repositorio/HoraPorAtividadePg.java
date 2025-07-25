package Repositorio;

import Model.HoraPorAtividade;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HoraPorAtividadePg implements Persistencia<HoraPorAtividade>{
    private DataSource dataSource;

    public HoraPorAtividadePg(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void inserir(HoraPorAtividade horaPorAtividade) {
        String sql = "INSERT INTO HORAS_POR_ATIVIDADE(DESCRICAO) VALUES (?);";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,horaPorAtividade.descricao());
            stmt.executeUpdate();
        }
        catch (SQLException _){
            throw new RuntimeException("Falha na conexão com o banco");
        }
    }

    @Override
    public HoraPorAtividade buscarPorId(int id) {
        String sql = "SELECT DESCRICAO FROM HORAS_POR_ATIVIDADE WHERE ID = ?;";
        try(Connection connection = dataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            try(ResultSet resultSet = stmt.executeQuery()){
                if(resultSet.next()){
                    HoraPorAtividade horaPorAtividade = new HoraPorAtividade(
                            resultSet.getString("descricao"),
                            String.valueOf(id)
                    );
                    return horaPorAtividade;
                }
                else{
                    return null;
                }
            } catch (RuntimeException _) {
                throw new RuntimeException("Erro na consulta!");
            }
        } catch (SQLException _) {
            throw new RuntimeException("Falha na conexão com o banco");
        }
    }
}
