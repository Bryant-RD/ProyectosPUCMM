package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class RegTrabajo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

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
			lblNewLabel.setBounds(29, 44, 125, 16);
			panel.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setBounds(166, 41, 237, 22);
			panel.add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre del Trabajo");
			lblNewLabel_1.setBounds(29, 102, 135, 16);
			panel.add(lblNewLabel_1);
			
			textField_1 = new JTextField();
			textField_1.setBounds(166, 99, 237, 22);
			panel.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Evento");
			lblNewLabel_3.setBounds(29, 151, 56, 16);
			panel.add(lblNewLabel_3);
			
			JLabel label = new JLabel("Tema del evento");
			label.setBounds(29, 200, 125, 16);
			panel.add(label);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(166, 197, 237, 22);
			panel.add(comboBox);
			
			JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setBounds(166, 148, 237, 22);
			panel.add(comboBox_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
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
