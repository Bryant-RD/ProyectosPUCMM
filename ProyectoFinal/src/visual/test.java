package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;

public class test extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 577);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cerrar Sesion");
		menuBar.add(mnNewMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setLocation(-53, -111);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Men\u00FA Administracion");
		lblNewLabel.setBounds(310, 39, 166, 14);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Registrar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(50, 87, 320, 368);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton button = new JButton("New button");
		button.setBounds(72, 40, 166, 50);
		panel_1.add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(72, 101, 166, 50);
		panel_1.add(button_1);
		
		JButton button_5 = new JButton("New button");
		button_5.setBounds(72, 162, 166, 50);
		panel_1.add(button_5);
		
		JButton button_6 = new JButton("New button");
		button_6.setBounds(72, 223, 166, 50);
		panel_1.add(button_6);
		
		JButton button_7 = new JButton("New button");
		button_7.setBounds(72, 284, 166, 50);
		panel_1.add(button_7);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Listar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(380, 87, 320, 368);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(79, 56, 166, 50);
		panel_2.add(button_2);
		
		JButton button_3 = new JButton("New button");
		button_3.setBounds(79, 131, 166, 50);
		panel_2.add(button_3);
		
		JButton button_4 = new JButton("New button");
		button_4.setBounds(79, 205, 166, 50);
		panel_2.add(button_4);
	}
}
