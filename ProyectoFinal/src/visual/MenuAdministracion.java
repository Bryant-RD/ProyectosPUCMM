package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import backend.Comision;
import backend.Evento;
import backend.PUCMM;

import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

public class MenuAdministracion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtLocal;
	private JComboBox cbxTipo;
	private JTextField txtTema;
	private JList lstRecursos;
	private JComboBox cbxComision;
	private JButton btnAgregar;
	private JComboBox cbxRecurso;
	private JSpinner spnCantidadRecurso;
	private DefaultListModel modelRecursos;
	private ArrayList<String> recursos;
	static String[] aRecursos ;
	private JSpinner snpFecha;

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
		recursos = new ArrayList<>();
		setTitle("Administracion");
		setBounds(100, 100, 682, 525);
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
				lblNewLabel.setBounds(10, 13, 133, 14);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setBounds(231, 54, 55, 14);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Codigo:");
				lblNewLabel_2.setBounds(20, 47, 46, 28);
				panel.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Tema:");
				lblNewLabel_3.setBounds(20, 98, 46, 14);
				panel.add(lblNewLabel_3);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Tipo:");
				lblNewLabel_4.setBounds(446, 98, 46, 14);
				panel.add(lblNewLabel_4);
			}
			{
				JLabel lblNewLabel_5 = new JLabel("Fecha:");
				lblNewLabel_5.setBounds(231, 98, 46, 14);
				panel.add(lblNewLabel_5);
			}
			{
				JLabel lblNewLabel_6 = new JLabel("Local:");
				lblNewLabel_6.setBounds(446, 54, 46, 14);
				panel.add(lblNewLabel_6);
			}
			{
				JLabel lblNewLabel_7 = new JLabel("Comision:");
				lblNewLabel_7.setBounds(10, 141, 65, 14);
				panel.add(lblNewLabel_7);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setBounds(76, 51, 145, 20);
				panel.add(txtCodigo);
				txtCodigo.setColumns(10);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(278, 51, 145, 20);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				txtLocal = new JTextField();
				txtLocal.setBounds(488, 51, 145, 20);
				panel.add(txtLocal);
				txtLocal.setColumns(10);
			}
			{
				cbxTipo = new JComboBox();
				cbxTipo.setBounds(488, 95, 145, 20);
				panel.add(cbxTipo);
			}
			{
				txtTema = new JTextField();
				txtTema.setBounds(76, 95, 145, 20);
				panel.add(txtTema);
				txtTema.setColumns(10);
			}
			
			cbxComision = new JComboBox();
			cbxComision.setBounds(76, 138, 145, 20);
			panel.add(cbxComision);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "Lista de recursos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(10, 189, 636, 227);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel label = new JLabel("Recursos:");
					label.setBounds(10, 26, 67, 14);
					panel_1.add(label);
				}
				{
					cbxRecurso = new JComboBox();
					DefaultComboBoxModel model = (DefaultComboBoxModel) cbxRecurso.getModel();
					cbxRecurso.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							//Arreglar
							System.out.print("Funicona");
							cbxRecurso.removeAll();
							ArrayList<String> aux = new ArrayList<>();
//							aRecursos[0] = "<< Seleccione - C >>";
							for (int i = 0; i < PUCMM.getInstance().getRecursos().size(); i++) {
								aRecursos[i] = PUCMM.getInstance().getRecursos().get(i).getNombreEquipo();

							}
							
							cbxRecurso.setModel(new DefaultComboBoxModel(aRecursos));
							
						}
					});
					
					aRecursos = new String[PUCMM.getInstance().getRecursos().size()+1];
					aRecursos[0] = "<< Seleccione >>";
				

					
					cbxRecurso.setModel(new DefaultComboBoxModel(aRecursos));
					
					cbxRecurso.setBounds(76, 23, 145, 20);
					panel_1.add(cbxRecurso);
				}
				{
					JLabel label = new JLabel("Cantidad:");
					label.setBounds(231, 26, 55, 14);
					panel_1.add(label);
				}
				{
					spnCantidadRecurso = new JSpinner();
					spnCantidadRecurso.setBounds(296, 23, 65, 20);
					panel_1.add(spnCantidadRecurso);
				}
				{
					btnAgregar = new JButton("Agregar");
					btnAgregar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String recurso = cbxRecurso.getSelectedItem().toString() + " - " + Integer.valueOf(spnCantidadRecurso.getValue().toString());
							modelRecursos.addElement(recurso);
							recursos.add(recurso);
							
							
						}
					});
					btnAgregar.setBounds(371, 22, 89, 23);
					panel_1.add(btnAgregar);
				}
				{
					lstRecursos = new JList();
					modelRecursos = new DefaultListModel<>();
					lstRecursos.setModel(modelRecursos);
					lstRecursos.setBounds(10, 62, 450, 154);
					panel_1.add(lstRecursos);
				}
			}
			
			snpFecha = new JSpinner();
			
			snpFecha = new JSpinner();
			Date date = new Date();
			
			
			snpFecha.setModel(new SpinnerDateModel(date, null, null, Calendar.YEAR));
			JSpinner.DateEditor de = new JSpinner.DateEditor(snpFecha,"dd/MM/YYYY");
			snpFecha.setEditor(de);
			
			snpFecha.setBounds(278, 95, 145, 20);
			panel.add(snpFecha);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCrear = new JButton("Crear");
				btnCrear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						Comision comision = PUCMM.getInstance().getComisionByName(cbxComision.getSelectedItem().toString());
						Date dateAux = (Date) snpFecha.getValue();
						SimpleDateFormat de = new SimpleDateFormat("dd/mm/yyyy");

						String fecha = de.format(dateAux);
						
						Evento evento = new Evento(txtCodigo.getText(), txtNombre.getText(), txtTema.getText(), cbxTipo.getSelectedItem().toString(), fecha, txtLocal.getText(), comision);
						PUCMM.getInstance().crearEvento(evento);
						
					}
				});
				btnCrear.setActionCommand("OK");
				buttonPane.add(btnCrear);
				getRootPane().setDefaultButton(btnCrear);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
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
					mntmNewMenuItem.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							RegistrarPersona regPerson = new RegistrarPersona();
							regPerson.setVisible(true);
						}
					});
					mnNewMenu.add(mntmNewMenuItem);
				}
				{
					JMenuItem mntmNewMenuItem_2 = new JMenuItem("Registrar Comision");
					mntmNewMenuItem_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							RegComision regComi = new RegComision();
							regComi.setVisible(true);
						}
					});
					mnNewMenu.add(mntmNewMenuItem_2);
				}
				{
					JMenuItem mntmNewMenuItem_3 = new JMenuItem("Regitrar Recurso");
					mntmNewMenuItem_3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							RegRecursos reg = new RegRecursos();
							reg.setVisible(true);
						}
					});
					
					JMenuItem mntmNewMenuItem_1 = new JMenuItem("Registrar Trabajo");
					mnNewMenu.add(mntmNewMenuItem_1);
					mnNewMenu.add(mntmNewMenuItem_3);
				}
			}
			{
				JMenu mnNewMenu_1 = new JMenu("Listas");
				menuBar.add(mnNewMenu_1);
				{
					JMenuItem mntmNewMenuItem_4 = new JMenuItem("Personas");
					mntmNewMenuItem_4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ListPersona lstPer = new ListPersona();
							lstPer.setVisible(true);
						}
					});
					mnNewMenu_1.add(mntmNewMenuItem_4);
				}
				{
					JMenuItem mntmNewMenuItem_5 = new JMenuItem("Proyectos");
					mnNewMenu_1.add(mntmNewMenuItem_5);
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
					mntmNewMenuItem_9.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ListRecursos lstRec = new ListRecursos();
							lstRec.setVisible(true);
						}
					});
					mnNewMenu_1.add(mntmNewMenuItem_9);
				}
			}
		}
	}
}
