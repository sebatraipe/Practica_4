package ar.unrn.tp3.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.unrn.tp3.modelo.Participante;
import ar.unrn.tp3.modelo.RepositorioDeParticipantes;

public class JdbcParticipante implements RepositorioDeParticipantes {

	private Connection dbConn;

	@Override
	public void nuevoParticipante(Participante participante) throws SQLException {
		try {
			this.dbConn = setupBaseDeDatos();
			PreparedStatement st = dbConn
					.prepareStatement("insert into participantes(nombre, telefono, region)values(?,?,?)");
			st.setString(1, participante.obtenerNombre());
			st.setString(2, participante.obtenerTelefono());
			st.setString(3, participante.obtenerRegion());
			st.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Error " + e.getMessage());
		}
	}

	private Connection setupBaseDeDatos() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/participantes?useSSL=false";
		String user = "root";
		String password = "1234";
		return DriverManager.getConnection(url, user, password);
	}
}
