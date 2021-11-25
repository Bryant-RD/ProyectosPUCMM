package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setBounds(100, 100, 399, 407);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Iniciar sesion");
			lblNewLabel.setBounds(137, 33, 131, 39);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Usuario");
			lblNewLabel_1.setBounds(58, 99, 46, 14);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
			lblNewLabel_2.setBounds(35, 167, 69, 14);
			panel.add(lblNewLabel_2);
			
			txtUsuario = new JTextField();
			txtUsuario.setBounds(114, 96, 172, 20);
			panel.add(txtUsuario);
			txtUsuario.setColumns(10);
			
			txtPassword = new JTextField();
			txtPassword.setBounds(114, 164, 172, 20);
			panel.add(txtPassword);
			txtPassword.setColumns(10);
			
			JButton btnNewButton = new JButton("Iniciar sesion");
			btnNewButton.setBounds(124, 229, 117, 29);
			panel.add(btnNewButton);
		}
	}
}
