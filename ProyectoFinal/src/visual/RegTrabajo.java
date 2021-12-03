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
		setBounds(100, 100, 596, 392);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Cedula Participante");
			lblNewLabel.setBounds(29, 38, 125, 16);
			panel.add(lblNewLabel);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(166, 35, 237, 22);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre del Trabajo");
			lblNewLabel_1.setBounds(29, 115, 135, 16);
			panel.add(lblNewLabel_1);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(166, 112, 237, 22);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Evento");
			lblNewLabel_3.setBounds(29, 157, 56, 16);
			panel.add(lblNewLabel_3);
			
			JLabel label = new JLabel("Tema del evento");
			label.setBounds(29, 200, 125, 16);
			panel.add(label);
			
			cbxTema = new JComboBox();
			
			cbxTema.removeAll();

			temas = new String[PUCMM.getInstance().getEventos().size()+1];
			temas[0] = "<< Seleccione >>";
			for (int i = 0; i < PUCMM.getInstance().getEventos().size(); i++) {
				temas[i+1] = PUCMM.getInstance().getEventos().get(i).getTema();

			}
			
			cbxTema.setModel(new DefaultComboBoxModel(temas));
			cbxTema.setBounds(166, 197, 237, 22);
			panel.add(cbxTema);
			
			cbxEvento = new JComboBox();
			
			cbxEvento.removeAll();

			eventos = new String[PUCMM.getInstance().getEventos().size()+1];
			eventos[0] = "<< Seleccione >>";
			for (int i = 0; i < PUCMM.getInstance().getEventos().size(); i++) {
				eventos[i+1] = PUCMM.getInstance().getEventos().get(i).getNombre();

			}
			
			
			
			cbxEvento.setModel(new DefaultComboBoxModel(eventos));
			cbxEvento.setBounds(166, 154, 237, 22);
			panel.add(cbxEvento);
			
			JLabel lblNewLabel_2 = new JLabel("codigo");
			lblNewLabel_2.setBounds(29, 81, 46, 14);
			panel.add(lblNewLabel_2);
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(166, 75, 237, 20);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
