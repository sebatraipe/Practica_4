package ar.unrn.tp3.ui;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ar.unrn.tp3.modelo.Participante;
import ar.unrn.tp3.modelo.RepositorioDeParticipantes;

public class UI extends JFrame {

	private JTextField nombre, telefono, region;
	private RepositorioDeParticipantes repositorioDeParticipantes;

	public UI(RepositorioDeParticipantes repositorioDeParticipantes) {
		this.repositorioDeParticipantes = repositorioDeParticipantes;
	}

	public void setupUIComponents() {
		setTitle("Add Participant");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nombre = new JTextField(10);
		telefono = new JTextField(10);
		region = new JTextField(10);
		region.setText("China");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		contentPane.add(new JLabel("Nombre: "));
		contentPane.add(nombre);
		contentPane.add(new JLabel("Telefono: "));
		contentPane.add(telefono);
		contentPane.add(new JLabel("Region: "));
		contentPane.add(region);
		JButton botonCargar = new JButton("Cargar");
		botonCargar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onBotonCargar();
			}
		});
		contentPane.add(botonCargar);
		setContentPane(contentPane);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pack();
		setVisible(true);
	}

	private void onBotonCargar() {
		Participante participante;
		try {
			participante = new Participante(nombre.getText(), telefono.getText(), region.getText());
			this.repositorioDeParticipantes.nuevoParticipante(participante);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getLocalizedMessage());
		}
	}
}