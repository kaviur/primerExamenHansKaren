package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OdontologDAOH2 implements iDao<Odontologo>{

    private static final String SQL_INSERT = "INSERT INTO odontologos (numero_matricula, nombre, apellido) VALUES (?, ?, ?)";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM odontologos WHERE id = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM odontologos";
    private static final String SQL_DELETE = "DELETE FROM odontologos WHERE id = ?";
    public static final Logger LOGGER = Logger.getLogger(Odontologo.class);


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        try {
            Connection connection = BD.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS)){
                ps.setString(1, odontologo.getNumeroMatricula());
                ps.setString(2, odontologo.getNombre());
                ps.setString(3, odontologo.getApellido());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    odontologo.setId(rs.getInt(1));
                }
            }
            logger.info("Odontólogo guardado: " + odontologo);
        } catch (SQLException e) {
            logger.error("Error al guardar odontólogo", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public List<Odontologo> buscarTodos() {
        return List.of();
    }
}
