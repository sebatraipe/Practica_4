package ar.unrn.tp4;

import java.awt.EventQueue;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new AgregarParticipante();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});

	}

}
