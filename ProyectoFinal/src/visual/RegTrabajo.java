package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.PUCMM;
import backend.Trabajo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;

public class RegTrabajo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JComboBox cbxEvento;
	private JTextField txtCodigo;
	private JComboBox cbxTema;
	private String[] temas;
	private String[] eventos;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegTrabajo dialog = new RegTrabajo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegTrabajo() {
		setBackground(new Color(198, 215, 193));
		setFont(new Font("Serif", Font.PLAIN, 12));
		setTitle("Registrar Trabajo");
		setBounds(100, 100, 596, 392);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(178, 201, 171));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Cedula Participante");
			lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 14));
			lblNewLabel.setBounds(29, 37, 125, 16);
			panel.add(lblNewLabel);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(178, 31, 237, 30);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre del Trabajo");
			lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(29, 129, 135, 16);
			panel.add(lblNewLabel_1);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(178, 123, 237, 30);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Evento");
			lblNewLabel_3.setFont(new Font("Serif", Font.PLAIN, 14));
			lblNewLabel_3.setBounds(29, 178, 96, 16);
			panel.add(lblNewLabel_3);
			
			JLabel label = new JLabel("Tema del evento");
			label.setFont(new Font("Serif", Font.PLAIN, 14));
			label.setBounds(29, 235, 125, 16);
			panel.add(label);
			
			cbxTema = new JComboBox();
			
			cbxTema.removeAll();

			temas = new String[PUCMM.getInstance().getEventos().size()+1];
			temas[0] = "<< Seleccione >>";
			for (int i = 0; i < PUCMM.getInstance().getEventos().size(); i++) {
				temas[i+1] = PUCMM.getInstance().getEventos().get(i).getTema();

			}
			
			cbxTema.setModel(new DefaultComboBoxModel(temas));
			cbxTema.setBounds(178, 229, 237, 30);
			panel.add(cbxTema);
			
			cbxEvento = new JComboBox();
			
			cbxEvento.removeAll();

			eventos = new String[PUCMM.getInstance().getEventos().size()+1];
			eventos[0] = "<< Seleccione >>";
			for (int i = 0; i < PUCMM.getInstance().getEventos().size(); i++) {
				eventos[i+1] = PUCMM.getInstance().getEventos().get(i).getNombre();

			}
			
			
			
			cbxEvento.setModel(new DefaultComboBoxModel(eventos));
			cbxEvento.setBounds(178, 172, 237, 30);
			panel.add(cbxEvento);
			
			JLabel lblNewLabel_2 = new JLabel("Codigo");
			lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 14));
			lblNewLabel_2.setBounds(29, 77, 73, 24);
			panel.add(lblNewLabel_2);
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(178, 75, 237, 30);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(198, 215, 193));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setBackground(new Color(232, 221, 181));
				okButton.setFont(new Font("Serif", Font.PLAIN, 14));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
//						String codEvento = PUCMM.getInstance().buscarEventoByName(cbxEvento.getSelectedItem().toString()).getCodigo();
						
						Trabajo trabajo = new Trabajo(txtCodigo.getText(), cbxEvento.getSelectedItem().toString(), txtNombre.getText(), cbxTema.getSelectedItem().toString());
						PUCMM.getInstance().agregarTrabajo(txtCedula.getText(), trabajo);
//						JOptionPane.showMessageDialog(null, "Trabajo agregado correctamente al evento");

						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(new Color(232, 221, 181));
				cancelButton.setFont(new Font("Serif", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
