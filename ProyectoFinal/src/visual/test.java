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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class test extends JFrame {

	private JPanel contentPane;
	private JButton btnRegEvento;
	private JButton btnRecursos;
	private JButton btnComisiones;
	private JButton btnPersonas;
	private JButton btnEventos;
	private JButton btnProyectos;
	private JButton btnRegPersona;
	private JButton btnComision;
	private JButton btnRegRecurso;
	private JButton btnRegTrabajo;

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
		
		btnRegEvento = new JButton("Evento");
		btnRegEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegEvento rgEvento = new RegEvento();
				rgEvento.setVisible(true);
			}
		});
		btnRegEvento.setBounds(72, 40, 166, 50);
		panel_1.add(btnRegEvento);
		
		btnRegPersona = new JButton("Persona");
		btnRegPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPersona regPerson = new RegistrarPersona();
				regPerson.setVisible(true);
			}
		});
		btnRegPersona.setBounds(72, 101, 166, 50);
		panel_1.add(btnRegPersona);
		
		btnComision = new JButton("Comision");
		btnComision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegComision regComi = new RegComision();
				regComi.setVisible(true);
			}
		});
		btnComision.setBounds(72, 162, 166, 50);
		panel_1.add(btnComision);
		
		btnRegRecurso = new JButton("Recurso");
		btnRegRecurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegRecursos reg = new RegRecursos();
				reg.setVisible(true);
			}
		});
		btnRegRecurso.setBounds(72, 223, 166, 50);
		panel_1.add(btnRegRecurso);
		
		btnRegTrabajo = new JButton("Trabajo");
		btnRegTrabajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegTrabajo rgTrabajo = new RegTrabajo();
				rgTrabajo.setVisible(true);
				
			}
		});
		btnRegTrabajo.setBounds(72, 284, 166, 50);
		panel_1.add(btnRegTrabajo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Listar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(380, 87, 320, 368);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		btnEventos = new JButton("Eventos");
		btnEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnEventos.setBounds(79, 40, 166, 50);
		panel_2.add(btnEventos);
		
		btnPersonas = new JButton("Personas");
		btnPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPersona lstPer = new ListPersona();
				lstPer.setVisible(true);
			}
		});
		btnPersonas.setBounds(79, 101, 166, 50);
		panel_2.add(btnPersonas);
		
		btnComisiones = new JButton("Comisiones");
		btnComisiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListComisiones lstComi = new ListComisiones();
				lstComi.setVisible(true);
			}
		});
		btnComisiones.setBounds(79, 162, 166, 50);
		panel_2.add(btnComisiones);
		
		btnRecursos = new JButton("Recursos");
		btnRecursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListRecursos lstRec = new ListRecursos();
				lstRec.setVisible(true);
			}
		});
		btnRecursos.setBounds(79, 223, 166, 50);
		panel_2.add(btnRecursos);
		
		btnProyectos = new JButton("Trabajos");
		btnProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListTrabajo lstTrabajo = new ListTrabajo();
				lstTrabajo.setVisible(true);
			}
		});
		btnProyectos.setBounds(79, 284, 166, 50);
		panel_2.add(btnProyectos);
	}
}
