package ar.unrn.tp3.modelo;

import java.sql.SQLException;

public interface RepositorioDeParticipantes {

	void nuevoParticipante(Participante participante) throws SQLException;
}
