package Repositorio;

import Model.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AtividadeComplementarPg implements Persistencia<AtividadeComplementar> {
    private DataSource dataSource;

    public AtividadeComplementarPg(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void inserir(AtividadeComplementar atividadeComplementar) {
        String sql = "INSERT INTO ATIVIDADE_COMPLEMENTAR " +
                "(DESCRICAO,LIMITE_MAXIMO, DOCUMENTACAO_ID, HORAS_POR_ATIVIDADE_ID, MODALIDADE_ID)" +
                "VALUES (?,?,?,?,?);";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, atividadeComplementar.descricao());
            stmt.setDouble(2, atividadeComplementar.horas());
            stmt.setInt(3, Integer.parseInt(atividadeComplementar.documentacao().id()));
            stmt.setInt(4, Integer.parseInt(atividadeComplementar.horaPorAtividade().id()));
            stmt.setInt(5, Integer.parseInt(atividadeComplementar.modalidade().id()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public AtividadeComplementar buscarPorId(int id) {
        String sql = "SELECT DESCRICAO,LIMITE_MAXIMO, DOCUMENTACAO_ID, HORAS_POR_ATIVIDADE_ID, MODALIDADE_ID " +
                "FROM ATIVIDADE_COMPLEMENTAR WHERE ID = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    AtividadeComplementar atividadeComplementar = new AtividadeBuilder()
                            .id(String.valueOf(id))
                            .descricao(resultSet.getString("descricao"))
                            .limiteMaximo(resultSet.getInt("limite_maximo"))
                            .documentacao(
                                    new DocumentacaoPg(dataSource).buscarPorId(resultSet.getInt("documentacao_id"))
                            )
                            .horaPorAtividade(
                                    new HoraPorAtividadePg(dataSource).buscarPorId(resultSet.getInt("horas_por_atividade_id"))
                            )
                            .modalidade(
                                    new ModalidadePg(dataSource).buscarPorId(resultSet.getInt("modalidade_id"))
                            )
                            .build();

                    return atividadeComplementar;
                } else {
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
