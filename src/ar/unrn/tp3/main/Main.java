package ar.unrn.tp3.main;

import ar.unrn.tp3.bd.JdbcParticipante;
import ar.unrn.tp3.ui.UI;

public class Main {

	public static void main(String[] args) {

		UI ui = new UI(new JdbcParticipante());
		ui.setupUIComponents();

	}

}
