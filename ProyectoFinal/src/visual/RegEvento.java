package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import backend.Comision;
import backend.Evento;
import backend.PUCMM;
import backend.Recursos;
import backend.Trabajo;

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

public class RegEvento extends JDialog {

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
	private String[] aRecursos ;
	private JSpinner snpFecha;
	private String[] aComisiones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegEvento dialog = new RegEvento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegEvento() {
		recursos = new ArrayList<>();
		setTitle("Administracion");
		setBounds(100, 100, 760, 574);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(176, 224, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setUndecorated(true);
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Creacion de nuevo Evento");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
				lblNewLabel.setBounds(249, 20, 226, 28);
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 14));
				lblNewLabel_1.setBounds(255, 94, 55, 14);
				panel.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Codigo:");
				lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 14));
				lblNewLabel_2.setBounds(22, 87, 46, 28);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Tema:");
				lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 14));
				lblNewLabel_3.setBounds(22, 138, 46, 14);
				panel.add(lblNewLabel_3);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Tipo:");
				lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 14));
				lblNewLabel_4.setBounds(499, 138, 46, 14);
				panel.add(lblNewLabel_4);
			}
			{
				JLabel lblNewLabel_5 = new JLabel("Fecha:");
				lblNewLabel_5.setFont(new Font("Calibri", Font.PLAIN, 14));
				lblNewLabel_5.setBounds(257, 138, 55, 14);
				panel.add(lblNewLabel_5);
			}
			{
				JLabel lblNewLabel_6 = new JLabel("Local:");
				lblNewLabel_6.setFont(new Font("Calibri", Font.PLAIN, 14));
				lblNewLabel_6.setBounds(499, 94, 46, 14);
				panel.add(lblNewLabel_6);
			}
			{
				JLabel lblNewLabel_7 = new JLabel("Comision:");
				lblNewLabel_7.setFont(new Font("Calibri", Font.PLAIN, 14));
				lblNewLabel_7.setBounds(12, 181, 65, 14);
				panel.add(lblNewLabel_7);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setBounds(80, 92, 145, 20);
				txtCodigo.setEditable(false);
				txtCodigo.setText("E-"+ PUCMM.getInstance().getEventos().size());
				panel.add(txtCodigo);
				txtCodigo.setColumns(10);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(324, 92, 145, 20);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				txtLocal = new JTextField();
				txtLocal.setBounds(557, 91, 145, 20);
				panel.add(txtLocal);
				txtLocal.setColumns(10);
			}
			{
				cbxTipo = new JComboBox();
				cbxTipo.setFont(new Font("Calibri", Font.BOLD, 13));
				cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<< Seleccione >>", "Conferencias", "Panel", "Feria", "Ponencia", "Poster", "Mesa redonda", " "}));
				cbxTipo.setBounds(557, 135, 145, 20);
				panel.add(cbxTipo);
			}
			{
				txtTema = new JTextField();
				txtTema.setBounds(80, 135, 145, 20);
				panel.add(txtTema);
				txtTema.setColumns(10);
			}
			
			cbxComision = new JComboBox();
			cbxComision.setFont(new Font("Calibri", Font.BOLD, 13));
			
			cbxComision.removeAll();

			aComisiones = new String[PUCMM.getInstance().getComisiones().size()+1];
			aComisiones[0] = "<< Seleccione >>";
			for (int i = 0; i < PUCMM.getInstance().getComisiones().size(); i++) {
				aComisiones[i+1] = PUCMM.getInstance().getComisiones().get(i).getNombre();

			}
			
			cbxComision.setModel(new DefaultComboBoxModel(aComisiones));
			cbxComision.setBounds(80, 178, 145, 20);
			panel.add(cbxComision);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "Lista de recursos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(22, 261, 561, 236);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel label = new JLabel("Recursos:");
					label.setFont(new Font("Calibri", Font.PLAIN, 14));
					label.setBounds(10, 26, 67, 14);
					panel_1.add(label);
				}
				{
					cbxRecurso = new JComboBox();
					cbxRecurso.setFont(new Font("Calibri", Font.BOLD, 13));
					DefaultComboBoxModel model = (DefaultComboBoxModel) cbxRecurso.getModel();
								
					
					cbxRecurso.removeAll();
//					ArrayList<String> aux1 = new ArrayList<>();
					aRecursos = new String[PUCMM.getInstance().getRecursos().size()+1];
					aRecursos[0] = "<< Seleccione >>";
					for (int i = 0; i < PUCMM.getInstance().getRecursos().size(); i++) {
						aRecursos[i+1] = PUCMM.getInstance().getRecursos().get(i).getNombreEquipo();

					}
				

					
					cbxRecurso.setModel(new DefaultComboBoxModel(aRecursos));
					
					cbxRecurso.setBounds(76, 23, 145, 20);
					panel_1.add(cbxRecurso);
				}
				{
					JLabel label = new JLabel("Cantidad:");
					label.setFont(new Font("Calibri", Font.PLAIN, 14));
					label.setBounds(263, 26, 55, 14);
					panel_1.add(label);
				}
				{
					spnCantidadRecurso = new JSpinner();
					spnCantidadRecurso.setBounds(330, 23, 65, 20);
					panel_1.add(spnCantidadRecurso);
				}
				{
					btnAgregar = new JButton("Agregar");
					btnAgregar.setForeground(new Color(255, 255, 255));
					btnAgregar.setBackground(new Color(88, 111, 124));
					btnAgregar.setFont(new Font("Calibri", Font.PLAIN, 14));
					btnAgregar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String recurso = cbxRecurso.getSelectedItem().toString() + " - " + Integer.valueOf(spnCantidadRecurso.getValue().toString());

							if (PUCMM.getInstance().verificarRecurso(cbxRecurso.getSelectedItem().toString(), Integer.valueOf(spnCantidadRecurso.getValue().toString()))) {
								modelRecursos.addElement(recurso);
								recursos.add(recurso);
							} else {
								JOptionPane.showMessageDialog(null, "Cantidad no disponible", "Error!", JOptionPane.ERROR_MESSAGE);
							}
							
						}
					});
					btnAgregar.setBounds(407, 22, 89, 23);
					panel_1.add(btnAgregar);
				}
				{
					lstRecursos = new JList();
					modelRecursos = new DefaultListModel<>();
					lstRecursos.setModel(modelRecursos);
					lstRecursos.setBounds(10, 62, 486, 154);
					panel_1.add(lstRecursos);
				}
			}
			
			snpFecha = new JSpinner();
			
			snpFecha = new JSpinner();
			Date date = new Date();
			
			
			snpFecha.setModel(new SpinnerDateModel(date, null, null, Calendar.YEAR));
			JSpinner.DateEditor de = new JSpinner.DateEditor(snpFecha,"dd/MM/YYYY");
			snpFecha.setEditor(de);
			
			snpFecha.setBounds(324, 136, 145, 20);
			panel.add(snpFecha);
			
			JLabel lblX = new JLabel("X");
			lblX.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					dispose();
				
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					lblX.setForeground(Color.RED);
				}
				public void mouseExited(MouseEvent e) {
					lblX.setForeground(Color.BLACK);
				}
			});
			lblX.setForeground(Color.BLACK);
			lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
			lblX.setHorizontalAlignment(SwingConstants.CENTER);
			lblX.setBounds(730, 0, 20, 20);
			panel.add(lblX);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(176, 224, 230));
			panel_1.setBounds(234, 13, 258, 45);
			panel.add(panel_1);
			
			JLabel lblCodigo = new JLabel("Codigo:");
			lblCodigo.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblCodigo.setBounds(22, 92, 46, 14);
			panel.add(lblCodigo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCrear = new JButton("Crear");
				btnCrear.setForeground(new Color(255, 255, 255));
				btnCrear.setBackground(new Color(88, 111, 124));
				btnCrear.setFont(new Font("Calibri", Font.PLAIN, 14));
				btnCrear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						Comision comision = PUCMM.getInstance().getComisionByName(cbxComision.getSelectedItem().toString());
						Date dateAux = (Date) snpFecha.getValue();
						SimpleDateFormat de = new SimpleDateFormat("dd/mm/yyyy");

						String fecha = de.format(dateAux);
						
						
						
						Evento evento = new Evento(txtCodigo.getText(), txtNombre.getText(), txtTema.getText(), cbxTipo.getSelectedItem().toString(), fecha, txtLocal.getText(), comision);
						PUCMM.getInstance().crearEvento(evento);
//						
						for (String recurso : recursos) {
							String[] split = recurso.split("-");
							int nun = Integer.parseInt(split[1].replaceAll("\\s",""));
							Recursos re = PUCMM.getInstance().buscarRecurso(split[0].replaceAll("\\s",""));
							PUCMM.getInstance().agregarRecursoEvento(re, nun , txtNombre.getText());
						}
						
						
						JOptionPane.showMessageDialog(null, "Evento creado correctamente");
						
						txtCodigo.setText("E-"+PUCMM.getInstance().getEventos().size());
						txtNombre.setText("");
						txtTema.setText("");
						txtLocal.setText("");
						cbxRecurso.setSelectedIndex(0);
						spnCantidadRecurso.setValue(0);
						
						modelRecursos.removeAllElements();
						
						cbxTipo.setSelectedIndex(0);
						Date date = new Date();
						
						
						snpFecha.setModel(new SpinnerDateModel(date, null, null, Calendar.YEAR));
						JSpinner.DateEditor de1 = new JSpinner.DateEditor(snpFecha,"dd/MM/YYYY");
						snpFecha.setEditor(de1);
						

						
						
						
					}
				});
				btnCrear.setActionCommand("OK");
				buttonPane.add(btnCrear);
				getRootPane().setDefaultButton(btnCrear);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(88, 111, 124));
				cancelButton.setFont(new Font("Calibri", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
