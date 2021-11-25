package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import backend.PUCMM;

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
	private JTextField txtNombreParticipante;
	private JSpinner snpExp;
	private JPanel JPanelJurado;

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
		setBounds(100, 100, 540, 492);
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
			rdbtnParticipante.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rdbtnParticipante.setSelected(true);
					JPanelParticipante.setVisible(true);
					rdbtnJurado.setSelected(false);
					JPanelJurado.setVisible(false);
				}
			});
			rdbtnParticipante.setBounds(67, 25, 109, 23);
			panel_2.add(rdbtnParticipante);
			
			rdbtnJurado = new JRadioButton("Jurado");
			rdbtnJurado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnParticipante.setSelected(false);
					JPanelParticipante.setVisible(false);
					rdbtnJurado.setSelected(true);
					JPanelJurado.setVisible(true);
				}
			});
			rdbtnJurado.setBounds(312, 25, 109, 23);
			panel_2.add(rdbtnJurado);
			
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
			
			txtNombreParticipante = new JTextField();
			txtNombreParticipante.setColumns(10);
			txtNombreParticipante.setBounds(66, 85, 158, 20);
			panel_3.add(txtNombreParticipante);
			
			JPanelJurado = new JPanel();
			JPanelJurado.setLayout(null);
			JPanelJurado.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Jurado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			JPanelJurado.setBounds(10, 204, 494, 77);
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
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
