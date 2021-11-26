package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegRecursos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegRecursos dialog = new RegRecursos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegRecursos() {
		setTitle("Registrar Recursos");
		setBounds(100, 100, 320, 220);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNombreObj = new JLabel("Nombre del Objeto:");
			lblNombreObj.setBounds(12, 26, 118, 16);
			contentPanel.add(lblNombreObj);
		}
		
		textField = new JTextField();
		textField.setBounds(119, 23, 158, 22);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(12, 89, 56, 16);
		contentPanel.add(lblCantidad);
		
		JLabel lblTipo = new JLabel("Tipo de Objeto:");
		lblTipo.setBounds(10, 62, 95, 16);
		contentPanel.add(lblTipo);
		{
			JSpinner spnCantidad = new JSpinner();
			spnCantidad.setBounds(119, 86, 56, 22);
			contentPanel.add(spnCantidad);
		}
		{
			JComboBox cbxTipo = new JComboBox();
			cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>", "Audio", "Visual", "Mobiliario"}));
			cbxTipo.setBounds(119, 53, 158, 22);
			contentPanel.add(cbxTipo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
