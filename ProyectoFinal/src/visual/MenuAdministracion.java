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

public class MenuAdministracion extends JDialog {

	private final JPanel contentPanel = new JPanel();

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
		setBounds(100, 100, 561, 440);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
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
					JMenuItem mntmNewMenuItem_1 = new JMenuItem("Registrar Participante");
					mnNewMenu.add(mntmNewMenuItem_1);
				}
				{
					JMenuItem mntmNewMenuItem = new JMenuItem("Registrar Jurado");
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
