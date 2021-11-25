package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

public class MenuAdministracion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MenuAdministracion dialog = new MenuAdministracion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MenuAdministracion() {
		setBounds(100, 100, 561, 597);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Crear nuevo Evento");
				lblNewLabel.setBounds(199, 28, 133, 14);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre");
				lblNewLabel_1.setBounds(215, 71, 46, 14);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Codigo");
				lblNewLabel_2.setBounds(10, 71, 46, 14);
				panel.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Tema");
				lblNewLabel_3.setBounds(215, 112, 46, 14);
				panel.add(lblNewLabel_3);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Tipo");
				lblNewLabel_4.setBounds(379, 112, 46, 14);
				panel.add(lblNewLabel_4);
			}
			{
				JLabel lblNewLabel_5 = new JLabel("Fecha");
				lblNewLabel_5.setBounds(10, 112, 46, 14);
				panel.add(lblNewLabel_5);
			}
			{
				JLabel lblNewLabel_6 = new JLabel("Local");
				lblNewLabel_6.setBounds(379, 71, 46, 14);
				panel.add(lblNewLabel_6);
			}
			{
				JLabel lblNewLabel_7 = new JLabel("Comision");
				lblNewLabel_7.setBounds(10, 164, 46, 14);
				panel.add(lblNewLabel_7);
			}
			{
				JLabel lblNewLabel_8 = new JLabel("Recursos");
				lblNewLabel_8.setBounds(215, 164, 67, 14);
				panel.add(lblNewLabel_8);
			}
			{
				textField = new JTextField();
				textField.setBounds(66, 68, 86, 20);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(271, 68, 86, 20);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				textField_2 = new JTextField();
				textField_2.setBounds(435, 68, 86, 20);
				panel.add(textField_2);
				textField_2.setColumns(10);
			}
			{
				comboBox = new JComboBox();
				comboBox.setBounds(435, 109, 86, 20);
				panel.add(comboBox);
			}
			{
				textField_3 = new JTextField();
				textField_3.setBounds(271, 109, 86, 20);
				panel.add(textField_3);
				textField_3.setColumns(10);
			}
			{
				JComboBox comboBox_1 = new JComboBox();
				comboBox_1.setBounds(66, 109, 86, 20);
				panel.add(comboBox_1);
			}
			{
				JComboBox comboBox_1 = new JComboBox();
				comboBox_1.setBounds(292, 161, 65, 20);
				panel.add(comboBox_1);
			}
			{
				JLabel lblNewLabel_9 = new JLabel("cantidad");
				lblNewLabel_9.setBounds(379, 164, 46, 14);
				panel.add(lblNewLabel_9);
			}
			{
				JSpinner spinner = new JSpinner();
				spinner.setBounds(435, 161, 46, 20);
				panel.add(spinner);
			}
			{
				JButton btnNewButton = new JButton("agregar");
				btnNewButton.setBounds(243, 201, 89, 23);
				panel.add(btnNewButton);
			}
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
		{
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				JMenu mnNewMenu = new JMenu("Registros");
				menuBar.add(mnNewMenu);
				{
					JMenuItem mntmNewMenuItem = new JMenuItem("Registrar Persona");
					mnNewMenu.add(mntmNewMenuItem);
				}
				{
					JMenuItem mntmNewMenuItem_2 = new JMenuItem("Registrar Comision");
					mnNewMenu.add(mntmNewMenuItem_2);
				}
				{
					JMenuItem mntmNewMenuItem_3 = new JMenuItem("Regitrar Recurso");
					mnNewMenu.add(mntmNewMenuItem_3);
				}
			}
			{
				JMenu mnNewMenu_1 = new JMenu("Listas");
				menuBar.add(mnNewMenu_1);
				{
					JMenuItem mntmNewMenuItem_4 = new JMenuItem("Participantes");
					mnNewMenu_1.add(mntmNewMenuItem_4);
				}
				{
					JMenuItem mntmNewMenuItem_5 = new JMenuItem("Proyectos");
					mnNewMenu_1.add(mntmNewMenuItem_5);
				}
				{
					JMenuItem mntmNewMenuItem_6 = new JMenuItem("Jurados");
					mnNewMenu_1.add(mntmNewMenuItem_6);
				}
				{
					JMenuItem mntmNewMenuItem_7 = new JMenuItem("Comisiones");
					mnNewMenu_1.add(mntmNewMenuItem_7);
				}
				{
					JMenuItem mntmNewMenuItem_8 = new JMenuItem("Eventos");
					mnNewMenu_1.add(mntmNewMenuItem_8);
				}
				{
					JMenuItem mntmNewMenuItem_9 = new JMenuItem("Recursos");
					mnNewMenu_1.add(mntmNewMenuItem_9);
				}
			}
		}
	}

}
