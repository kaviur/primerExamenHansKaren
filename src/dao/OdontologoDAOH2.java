package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OdontologDAOH2 implements iDao<Odontologo> {

    private static final String SQL_INSERT = "INSERT INTO odontologos (numero_matricula, nombre, apellido) VALUES (?, ?, ?)";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM odontologos WHERE id = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM odontologos";
    private static final String SQL_DELETE = "DELETE FROM odontologos WHERE id = ?";
    public static final Logger logger = Logger.getLogger(Odontologo.class);


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        try {
            Connection connection = BD.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, odontologo.getNumeroMatricula());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getApellido());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                odontologo.setId(rs.getInt(1));
            }
            logger.info("Odontólogo guardado: " + odontologo);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return odontologo;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        Odontologo odontologo = null;
        try {
            Connection connection = BD.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_BY_ID);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                odontologo = new Odontologo(rs.getString("numero_matricula"), rs.getString("nombre"), rs.getString("apellido"));
                odontologo.setId(rs.getInt("id"));
            }
            logger.info("Odontólogo encontrado: " + odontologo);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return odontologo;
    }

    @Override
    public void eliminar(Integer id) {

        try {
            Connection connection = BD.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_DELETE);
            ps.setLong(1, id);
            ps.executeUpdate();
            logger.info("Odontólogo eliminado con ID: " + id);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    @Override
    public void actualizar(Odontologo odontologo) {
    }

    @Override
    public List<Odontologo> buscarTodos() {
        List<Odontologo> odontologos = new ArrayList<>();
        try {
            Connection connection = BD.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Odontologo odontologo = new Odontologo(rs.getString("numero_matricula"), rs.getString("nombre"), rs.getString("apellido"));
                odontologo.setId(rs.getInt("id"));
                odontologos.add(odontologo);
            }
            logger.info("Lista de todos los odontólogos: " + odontologos);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return odontologos;
    }
}
