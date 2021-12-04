package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import backend.PUCMM;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class test extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
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
	private JPanel panelMenu;
	private JLabel lblRegistrar;
	private JLabel lblListar;

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
		
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height-35);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cerrar Sesion");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PUCMM.getInstance().logueado = null;
				dispose();
				Login lg = new Login();
				lg.setVisible(true);
			}
		});
		
		mnNewMenu.setFont(new Font("Serif", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(244, 244, 249));
		panel.setLocation(-53, -111);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(184, 219, 217));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(146, 182, 177)));
		panel_1.setBounds(353, 338, 422, 497);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnRegEvento = new JButton("Evento");
		btnRegEvento.setForeground(new Color(255, 255, 255));
		btnRegEvento.setBackground(new Color(88, 111, 124));
		btnRegEvento.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnRegEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegEvento rgEvento = new RegEvento();
				rgEvento.setVisible(true);
			}
		});
		btnRegEvento.setBounds(132, 32, 166, 50);
		panel_1.add(btnRegEvento);
		
		btnRegPersona = new JButton("Persona");
		btnRegPersona.setForeground(new Color(255, 255, 255));
		btnRegPersona.setBackground(new Color(88, 111, 124));
		btnRegPersona.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnRegPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarPersona regPerson = new RegistrarPersona();
				regPerson.setVisible(true);
			}
		});
		btnRegPersona.setBounds(132, 133, 166, 50);
		panel_1.add(btnRegPersona);
		
		btnComision = new JButton("Comision");
		btnComision.setForeground(new Color(255, 255, 255));
		btnComision.setBackground(new Color(88, 111, 124));
		btnComision.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnComision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegComision regComi = new RegComision();
				regComi.setVisible(true);
			}
		});
		btnComision.setBounds(132, 223, 166, 50);
		panel_1.add(btnComision);
		
		btnRegRecurso = new JButton("Recurso");
		btnRegRecurso.setForeground(new Color(255, 255, 255));
		btnRegRecurso.setBackground(new Color(88, 111, 124));
		btnRegRecurso.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnRegRecurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegRecursos reg = new RegRecursos();
				reg.setVisible(true);
			}
		});
		btnRegRecurso.setBounds(132, 319, 166, 50);
		panel_1.add(btnRegRecurso);
		
		btnRegTrabajo = new JButton("Trabajo");
		btnRegTrabajo.setForeground(new Color(255, 255, 255));
		btnRegTrabajo.setBackground(new Color(88, 111, 124));
		btnRegTrabajo.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnRegTrabajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegTrabajo rgTrabajo = new RegTrabajo();
				rgTrabajo.setVisible(true);
				
			}
		});
		btnRegTrabajo.setBounds(132, 412, 166, 50);
		panel_1.add(btnRegTrabajo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(184, 219, 217));
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(1128, 338, 422, 497);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		btnEventos = new JButton("Eventos");
		btnEventos.setForeground(new Color(255, 255, 255));
		btnEventos.setBackground(new Color(88, 111, 124));
		btnEventos.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListEventos lstEv = new ListEventos();
				lstEv.setVisible(true);
			}
		});
		btnEventos.setBounds(125, 32, 166, 50);
		panel_2.add(btnEventos);
		
		btnPersonas = new JButton("Personas");
		btnPersonas.setForeground(new Color(255, 255, 255));
		btnPersonas.setBackground(new Color(88, 111, 124));
		btnPersonas.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPersona lstPer = new ListPersona();
				lstPer.setVisible(true);
			}
		});
		btnPersonas.setBounds(125, 133, 166, 50);
		panel_2.add(btnPersonas);
		
		btnComisiones = new JButton("Comisiones");
		btnComisiones.setForeground(new Color(255, 255, 255));
		btnComisiones.setBackground(new Color(88, 111, 124));
		btnComisiones.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnComisiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListComisiones lstComi = new ListComisiones();
				lstComi.setVisible(true);
			}
		});
		btnComisiones.setBounds(125, 223, 166, 50);
		panel_2.add(btnComisiones);
		
		btnRecursos = new JButton("Recursos");
		btnRecursos.setForeground(new Color(255, 255, 255));
		btnRecursos.setBackground(new Color(88, 111, 124));
		btnRecursos.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnRecursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListRecursos lstRec = new ListRecursos();
				lstRec.setVisible(true);
			}
		});
		btnRecursos.setBounds(125, 319, 166, 50);
		panel_2.add(btnRecursos);
		
		btnProyectos = new JButton("Trabajos");
		btnProyectos.setForeground(new Color(255, 255, 255));
		btnProyectos.setBackground(new Color(88, 111, 124));
		btnProyectos.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListTrabajo lstTrabajo = new ListTrabajo();
				lstTrabajo.setVisible(true);
			}
		});
		btnProyectos.setBounds(125, 412, 166, 50);
		panel_2.add(btnProyectos);
		
		panelMenu = new JPanel();
		panelMenu.setBackground(new Color(184, 219, 217));
		panelMenu.setBounds(545, 127, 816, 108);
		panel.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Men\u00FA Administracion");
		lblNewLabel.setBounds(296, 39, 248, 38);
		panelMenu.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblRegistrar = new JLabel("Registrar");
		lblRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrar.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		lblRegistrar.setBounds(495, 289, 144, 27);
		panel.add(lblRegistrar);
		
		lblListar = new JLabel("Listar");
		lblListar.setHorizontalAlignment(SwingConstants.CENTER);
		lblListar.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		lblListar.setBounds(1274, 289, 144, 27);
		panel.add(lblListar);
	}
}
