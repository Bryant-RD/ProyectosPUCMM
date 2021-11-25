package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;

public class RegComision extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegComision dialog = new RegComision();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegComision() {
		setBounds(100, 100, 479, 396);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Presidente");
				lblNewLabel.setBounds(10, 27, 77, 14);
				panel.add(lblNewLabel);
			}
			{
				textField = new JTextField();
				textField.setBounds(79, 24, 259, 20);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Jurado");
				lblNewLabel_1.setBounds(10, 72, 46, 14);
				panel.add(lblNewLabel_1);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(79, 69, 259, 20);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				JButton btnNewButton = new JButton("Agregar");
				btnNewButton.setBounds(348, 68, 89, 23);
				panel.add(btnNewButton);
			}
			
			JList list = new JList();
			list.setBounds(10, 125, 427, 165);
			panel.add(list);
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
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
