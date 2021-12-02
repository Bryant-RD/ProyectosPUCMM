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
import javax.swing.border.TitledBorder;

import backend.Administrador;
import backend.Evento;
import backend.Jurado;
import backend.PUCMM;
import backend.Participante;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JSpinner;

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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtUsuario;
	private JTextField txtPassword;
	private JPanel JPanelAdministrador;
	private JRadioButton rdbtnAdministrador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarPersona dialog = new RegistrarPersona();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarPersona() {
		setBounds(100, 100, 540, 495);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Datos Generales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 11, 494, 103);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			txtCorreo = new JTextField();
			txtCorreo.setColumns(10);
			txtCorreo.setBounds(330, 72, 158, 20);
			panel_1.add(txtCorreo);
			
			JLabel label = new JLabel("Correo");
			label.setBounds(274, 75, 46, 14);
			panel_1.add(label);
			
			txtNombre = new JTextField();
			txtNombre.setColumns(10);
			txtNombre.setBounds(66, 72, 158, 20);
			panel_1.add(txtNombre);
			
			JLabel label_1 = new JLabel("Nombre");
			label_1.setBounds(10, 75, 46, 14);
			panel_1.add(label_1);
			
			JLabel label_2 = new JLabel("Cedula");
			label_2.setBounds(10, 32, 46, 14);
			panel_1.add(label_2);
			
			txtCedula = new JTextField();
			txtCedula.setColumns(10);
			txtCedula.setBounds(66, 29, 158, 20);
			panel_1.add(txtCedula);
			
			txtTelefono = new JTextField();
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(330, 29, 158, 20);
			panel_1.add(txtTelefono);
			
			JLabel label_3 = new JLabel("Telefono");
			label_3.setBounds(274, 32, 46, 14);
			panel_1.add(label_3);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Tipo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(10, 125, 494, 68);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			rdbtnParticipante = new JRadioButton("Participante");
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
			JPanelParticipante.setBorder(new TitledBorder(null, "Participante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			JPanelParticipante.setBounds(10, 204, 494, 201);
			panel.add(JPanelParticipante);
			JPanelParticipante.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Matricula");
			lblNewLabel.setBounds(10, 33, 58, 14);
			JPanelParticipante.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Escuela");
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
			panel_3.setBorder(new TitledBorder(null, "Proyecto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_3.setBounds(10, 72, 474, 114);
			JPanelParticipante.add(panel_3);
			panel_3.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("Codigo");
			lblNewLabel_2.setBounds(10, 35, 46, 14);
			panel_3.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Nombre");
			lblNewLabel_3.setBounds(10, 88, 46, 14);
			panel_3.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Tema");
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
			cbxTemas.setBounds(299, 32, 165, 20);
			panel_3.add(cbxTemas);
			
			txtCodigoProyecto = new JTextField();
			txtCodigoProyecto.setColumns(10);
			txtCodigoProyecto.setBounds(66, 32, 158, 20);
			panel_3.add(txtCodigoProyecto);
			
			txtNombreTrabajo = new JTextField();
			txtNombreTrabajo.setColumns(10);
			txtNombreTrabajo.setBounds(66, 85, 158, 20);
			panel_3.add(txtNombreTrabajo);
			
			JLabel lblNewLabel_5 = new JLabel("Evento");
			lblNewLabel_5.setBounds(259, 88, 46, 14);
			panel_3.add(lblNewLabel_5);
			
			cbxEvento = new JComboBox();
			cbxEvento.setBounds(299, 85, 165, 20);
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
			
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(66, 69, 158, 20);
			JPanelJurado.add(textField);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(326, 69, 158, 20);
			JPanelJurado.add(textField_1);
			
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
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(rdbtnParticipante.isSelected()) {
							String codEvent = PUCMM.getInstance().buscarEventoByName(cbxEvento.getSelectedItem().toString()).getCodigo();
							
							Participante participante = new Participante(txtNombre.getText(), txtCedula.getText(), txtTelefono.getText(), txtCorreo.getText(), txtMatricula.getText(), txtEscuela.getText(), codEvent, txtCodigoProyecto.getText(), txtNombreTrabajo.getText(), cbxTemas.getSelectedItem().toString());
							PUCMM.getInstance().RegistrarPersona(participante);
							JOptionPane.showMessageDialog(null, "Participante registrado correctamente", "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);
							
							txtMatricula.setText("");
							txtEscuela.setText("");
							txtCodigoProyecto.setText("");
							txtNombreTrabajo.setText("");
							cbxTemas.setSelectedItem(0);
							
						} if(rdbtnJurado.isSelected()) {
							Jurado jurado = new Jurado(txtNombre.getText(), txtCedula.getText(), txtTelefono.getText(), txtCorreo.getText(), txtArea.getText(), Integer.valueOf(snpExp.getValue().toString()), txtUsuario.getText(), txtPassword.getText());
							PUCMM.getInstance().RegistrarPersona(jurado);
							JOptionPane.showMessageDialog(null, "Jurado registrado correctamente", "Operacion exitosa", JOptionPane.INFORMATION_MESSAGE);
							
					
							txtArea.setText("");
							snpExp.setValue(0);
							txtUsuario.setText("");
							txtPassword.setText("");
							
							
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
