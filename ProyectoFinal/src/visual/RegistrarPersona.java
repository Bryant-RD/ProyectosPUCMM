package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import backend.Administrador;
import backend.Evento;
import backend.Jurado;
import backend.PUCMM;
import backend.Participante;
import backend.Persona;
import backend.Recursos;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JSpinner;
import java.awt.Font;

public class RegistrarPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCorreo;
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JPanel JPanelParticipante;
	private JTextField txtMatricula;
	private JTextField txtEscuela;
	private JComboBox cbxTemas;
	private JRadioButton rdbtnParticipante;
	private JRadioButton rdbtnJurado;
	private JTextField txtArea;
	private JTextField txtCodigoProyecto;
	private JTextField txtNombreTrabajo;
	private JSpinner snpExp;
	private JPanel JPanelJurado;
	private JButton btnRegistrar;
	private JComboBox cbxEvento;
	private JTextField txtUsuarioJurado;
	private JTextField txtPasswordJurado;
	private JTextField txtUsuario;
	private JTextField txtPassword;
	private JPanel JPanelAdministrador;
	private JRadioButton rdbtnAdministrador;
	private String[] aEventos;
	private static Persona updated = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarPersona dialog = new RegistrarPersona(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarPersona(Persona personas) {
		updated = personas;
		
		if(updated != null) {
			setTitle("Modificar Persona");
		} else {
			setTitle("Registrar Persona");
		}

		setBounds(100, 100, 540, 495);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(176, 224, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setUndecorated(true);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(244, 244, 249));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(244, 244, 249));
			panel_1.setBorder(new TitledBorder(null, "Datos Generales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 11, 494, 103);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			txtCorreo = new JTextField();
			txtCorreo.setColumns(10);
			txtCorreo.setBounds(330, 72, 158, 20);
			panel_1.add(txtCorreo);
			
			JLabel lblCorreo = new JLabel("Correo:");
			lblCorreo.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblCorreo.setBounds(274, 75, 46, 14);
			panel_1.add(lblCorreo);
			
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(76, 72, 158, 20);
			panel_1.add(txtNombre);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblNombre.setBounds(10, 75, 54, 14);
			panel_1.add(lblNombre);
			
			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblCedula.setBounds(10, 32, 46, 14);
			panel_1.add(lblCedula);
			
			txtCedula = new JTextField();
			txtCedula.setColumns(10);
			txtCedula.setBounds(76, 29, 158, 20);
			panel_1.add(txtCedula);
			
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(330, 29, 158, 20);
			panel_1.add(txtTelefono);
			
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblTelefono.setBounds(272, 32, 61, 14);
			panel_1.add(lblTelefono);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(244, 244, 249));
			panel_2.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(10, 125, 494, 68);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			rdbtnParticipante = new JRadioButton("Participante");
			rdbtnParticipante.setBackground(new Color(244, 244, 249));
			rdbtnParticipante.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdbtnParticipante.setSelected(true);
			rdbtnParticipante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rdbtnParticipante.setSelected(true);
					JPanelParticipante.setVisible(true);
					rdbtnAdministrador.setSelected(false);
					JPanelAdministrador.setVisible(false);
					rdbtnJurado.setSelected(false);
					JPanelJurado.setVisible(false);
				}
			});
			rdbtnParticipante.setBounds(17, 25, 109, 23);
			panel_2.add(rdbtnParticipante);
			
			rdbtnJurado = new JRadioButton("Jurado");
			rdbtnJurado.setBackground(new Color(244, 244, 249));
			rdbtnJurado.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdbtnJurado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnParticipante.setSelected(false);
					JPanelParticipante.setVisible(false);
					rdbtnAdministrador.setSelected(false);
					JPanelAdministrador.setVisible(false);
					rdbtnJurado.setSelected(true);
					JPanelJurado.setVisible(true);
				}
			});
			rdbtnJurado.setBounds(211, 25, 109, 23);
			panel_2.add(rdbtnJurado);
			
			rdbtnAdministrador = new JRadioButton("Administrador");
			rdbtnAdministrador.setBackground(new Color(244, 244, 249));
			rdbtnAdministrador.setFont(new Font("Calibri", Font.PLAIN, 14));
			rdbtnAdministrador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					rdbtnAdministrador.setSelected(true);
					JPanelAdministrador.setVisible(true);
					rdbtnParticipante.setSelected(false);
					JPanelParticipante.setVisible(false);
					rdbtnJurado.setSelected(false);
					JPanelJurado.setVisible(false);
				}
			});
			rdbtnAdministrador.setBounds(364, 25, 109, 23);
			panel_2.add(rdbtnAdministrador);
			
			JPanelParticipante = new JPanel();
			JPanelParticipante.setBackground(new Color(244, 244, 249));
			JPanelParticipante.setBorder(new TitledBorder(null, "Participante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			JPanelParticipante.setBounds(10, 204, 494, 201);
			panel.add(JPanelParticipante);
			JPanelParticipante.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Matricula");
			lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblNewLabel.setBounds(10, 33, 58, 14);
			JPanelParticipante.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Escuela");
			lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(270, 33, 46, 14);
			JPanelParticipante.add(lblNewLabel_1);
			
			txtMatricula = new JTextField();
			txtMatricula.setColumns(10);
			txtMatricula.setBounds(78, 30, 158, 20);
			JPanelParticipante.add(txtMatricula);
			
			txtEscuela = new JTextField();
			txtEscuela.setColumns(10);
			txtEscuela.setBounds(326, 30, 158, 20);
			JPanelParticipante.add(txtEscuela);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(new Color(244, 244, 249));
			panel_3.setBorder(new TitledBorder(null, "Proyecto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_3.setBounds(10, 72, 474, 114);
			JPanelParticipante.add(panel_3);
			panel_3.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("Codigo");
			lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblNewLabel_2.setBounds(10, 29, 46, 27);
			panel_3.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Nombre");
			lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblNewLabel_3.setBounds(10, 88, 46, 14);
			panel_3.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Tema");
			lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblNewLabel_4.setBounds(259, 35, 46, 14);
			panel_3.add(lblNewLabel_4);
			
			cbxTemas = new JComboBox();
			
			ArrayList<String> aux = new ArrayList<>();

			aux.add("<< Seleccione >>");
			for (int i = 0; i < PUCMM.getInstance().getEventos().size(); i++) {
				String tema = PUCMM.getInstance().getEventos().get(i).getTema();
				aux.add(tema);
			}
			
			String[] temas = new String[aux.size()];
			for (int i = 0; i < aux.size(); i++) {
				temas[i] = aux.get(i); 
			}
			
			
			cbxTemas.setModel(new DefaultComboBoxModel(temas));
			cbxTemas.setBounds(306, 32, 158, 20);
			panel_3.add(cbxTemas);
			
			txtCodigoProyecto = new JTextField();
			txtCodigoProyecto.setText("T-" + PUCMM.getInstance().getTrabajo().size());
			txtCodigoProyecto.setEnabled(false);
			txtCodigoProyecto.setColumns(10);
			txtCodigoProyecto.setBounds(66, 32, 158, 20);
			panel_3.add(txtCodigoProyecto);
			
			txtNombreTrabajo = new JTextField();
			txtNombreTrabajo.setColumns(10);
			txtNombreTrabajo.setBounds(66, 85, 158, 20);
			panel_3.add(txtNombreTrabajo);
			
			JLabel lblNewLabel_5 = new JLabel("Evento");
			lblNewLabel_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblNewLabel_5.setBounds(259, 88, 46, 14);
			panel_3.add(lblNewLabel_5);
			
			cbxEvento = new JComboBox();
			
			cbxEvento.removeAll();

			aEventos = new String[PUCMM.getInstance().getComisiones().size()+1];
			aEventos[0] = "<< Seleccione >>";
			for (int i = 0; i < PUCMM.getInstance().getComisiones().size(); i++) {
				aEventos[i+1] = PUCMM.getInstance().getComisiones().get(i).getNombre();

			}
			
			cbxEvento.setModel(new DefaultComboBoxModel(aEventos));
			
			cbxEvento.setBounds(306, 85, 158, 20);
			panel_3.add(cbxEvento);
			
			JPanelJurado = new JPanel();
			JPanelJurado.setVisible(false);
			JPanelJurado.setLayout(null);
			JPanelJurado.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Jurado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			JPanelJurado.setBounds(10, 204, 494, 103);
			panel.add(JPanelJurado);
			
			JLabel lblArea = new JLabel("Area");
			lblArea.setBounds(10, 33, 46, 14);
			JPanelJurado.add(lblArea);
			
			JLabel lblAosExperiencia = new JLabel("A\u00F1os Experiencia");
			lblAosExperiencia.setBounds(270, 33, 108, 14);
			JPanelJurado.add(lblAosExperiencia);
			
			txtArea = new JTextField();
			txtArea.setColumns(10);
			txtArea.setBounds(66, 30, 158, 20);
			JPanelJurado.add(txtArea);
			
			snpExp = new JSpinner();
			snpExp.setBounds(388, 30, 96, 20);
			JPanelJurado.add(snpExp);
			
			JLabel lblNewLabel_6 = new JLabel("Usuario");
			lblNewLabel_6.setBounds(10, 72, 46, 14);
			JPanelJurado.add(lblNewLabel_6);
			
			txtUsuarioJurado = new JTextField();
			txtUsuarioJurado.setColumns(10);
			txtUsuarioJurado.setBounds(66, 69, 158, 20);
			JPanelJurado.add(txtUsuarioJurado);
			
			txtPasswordJurado = new JTextField();
			txtPasswordJurado.setColumns(10);
			txtPasswordJurado.setBounds(326, 69, 158, 20);
			JPanelJurado.add(txtPasswordJurado);
			
			JLabel lblNewLabel_7 = new JLabel("contrase\u00F1a");
			lblNewLabel_7.setBounds(251, 72, 65, 14);
			JPanelJurado.add(lblNewLabel_7);
			
			JPanelAdministrador = new JPanel();
			JPanelAdministrador.setVisible(false);
			JPanelAdministrador.setLayout(null);
			JPanelAdministrador.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Jurado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			JPanelAdministrador.setBounds(10, 204, 494, 61);
			panel.add(JPanelAdministrador);
			
			JLabel label_6 = new JLabel("Usuario");
			label_6.setBounds(10, 28, 46, 14);
			JPanelAdministrador.add(label_6);
			
			txtUsuario = new JTextField();
			txtUsuario.setColumns(10);
			txtUsuario.setBounds(66, 25, 158, 20);
			JPanelAdministrador.add(txtUsuario);
			
			txtPassword = new JTextField();
			txtPassword.setColumns(10);
			txtPassword.setBounds(326, 25, 158, 20);
			JPanelAdministrador.add(txtPassword);
			
			JLabel label_7 = new JLabel("contrase\u00F1a");
			label_7.setBounds(251, 28, 65, 14);
			JPanelAdministrador.add(label_7);
			
			JLabel lblX = new JLabel("X");
			lblX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dispose();
					
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					lblX.setForeground(Color.RED);
				}
				public void mouseExited(MouseEvent e) {
					lblX.setForeground(Color.BLACK);
				}
			});
			lblX.setForeground(Color.BLACK);
			lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
			lblX.setHorizontalAlignment(SwingConstants.CENTER);
			lblX.setBounds(510, 0, 20, 20);
			panel.add(lblX);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(244, 244, 249));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.setForeground(new Color(255, 255, 255));
				btnRegistrar.setFont(new Font("Calibri", Font.PLAIN, 14));
				btnRegistrar.setBackground(new Color(88, 111, 124));
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(rdbtnParticipante.isSelected()) {
//							String codEvent = PUCMM.getInstance().buscarEventoByName(cbxEvento.getSelectedItem().toString()).getCodigo();
							
							Participante participante = new Participante(txtNombre.getText(), txtCedula.getText(), txtTelefono.getText(), txtCorreo.getText(), txtMatricula.getText(), txtEscuela.getText(), cbxEvento.getSelectedItem().toString(), txtCodigoProyecto.getText(), txtNombreTrabajo.getText(), cbxTemas.getSelectedItem().toString());
							PUCMM.getInstance().RegistrarPersona(participante);
							JOptionPane.showMessageDialog(null, "Participante registrado correctamente", "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);
							
							txtMatricula.setText("");
							txtEscuela.setText("");
							txtCodigoProyecto.setText("");
							txtNombreTrabajo.setText("");
							cbxTemas.setSelectedIndex(0);
							cbxEvento.setSelectedIndex(0);
							
						} if(rdbtnJurado.isSelected()) {
							Jurado jurado = new Jurado(txtNombre.getText(), txtCedula.getText(), txtTelefono.getText(), txtCorreo.getText(), txtArea.getText(), Integer.valueOf(snpExp.getValue().toString()), txtUsuarioJurado.getText(), txtPasswordJurado.getText());
							PUCMM.getInstance().RegistrarPersona(jurado);
							JOptionPane.showMessageDialog(null, "Jurado registrado correctamente", "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);
							
					
							txtArea.setText("");
							snpExp.setValue(0);
							txtUsuarioJurado.setText("");
							txtPasswordJurado.setText("");
							
							
						} if(rdbtnAdministrador.isSelected()) {
							Administrador admin = new Administrador(txtNombre.getText(), txtCedula.getText(), txtTelefono.getText(), txtCorreo.getText(), txtUsuario.getText(), txtPassword.getText());
							JOptionPane.showMessageDialog(null, "Administrador registrado correctamente", "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);
							
							PUCMM.getInstance().RegistrarPersona(admin);
							txtUsuario.setText("");
							txtPassword.setText("");
						}
						
						txtNombre.setText("");
						txtCedula.setText("");
						txtTelefono.setText("");
						txtCorreo.setText("");
						
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setFont(new Font("Calibri", Font.PLAIN, 14));
				cancelButton.setBackground(new Color(88, 111, 124));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			if(updated != null) {
				txtNombre.setText(updated.getNombre());
				txtCorreo.setText(updated.getEmail());
				txtTelefono.setText(updated.getNumero());
				
				btnRegistrar.setText("Actualizar");
			}
		}
	}
}
