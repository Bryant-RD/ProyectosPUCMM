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
			
			ArrayList<String> auxTemas = new ArrayList<>();
			auxTemas.add("<< Seleccione >>");

			for (int i = 0; i < PUCMM.getInstance().getEventos().size(); i++) {
				auxTemas.add(PUCMM.getInstance().getEventos().get(i).getTema());
			}
			
			String[] temas = new String[auxTemas.size()];
			
			for (int i = 0; i < auxTemas.size(); i++) {
				temas[i] = auxTemas.get(i);
			}
			
			cbxTema.setModel(new DefaultComboBoxModel(temas));
			cbxTema.setBounds(166, 197, 237, 22);
			panel.add(cbxTema);
			
			cbxEvento = new JComboBox();
			
			ArrayList<String> auxEvento = new ArrayList<>();
			auxEvento.add("<< Seleccione >>");

			for (int i = 0; i < PUCMM.getInstance().getEventos().size(); i++) {
				auxEvento.add(PUCMM.getInstance().getEventos().get(i).getTema());
			}
			
			String[] eventos = new String[auxEvento.size()];
			
			for (int i = 0; i < auxEvento.size(); i++) {
				eventos[i] = auxEvento.get(i);
			}
			
			cbxTema.setModel(new DefaultComboBoxModel(eventos));
			
			
			cbxEvento.setModel(new DefaultComboBoxModel(new String[] {"<< seleccione >>"}));
			
			
			
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
						JOptionPane.showMessageDialog(null, "Trabajo agregado correctamente al evento");

						
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
