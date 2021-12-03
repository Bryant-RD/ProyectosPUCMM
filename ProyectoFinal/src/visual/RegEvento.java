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
				cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<< Seleccione >>", "Conferencias", "Panel", "Feria", "Ponencia", "Poster", "Mesa redonda", " "}));
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
			
			cbxComision.removeAll();

			aComisiones = new String[PUCMM.getInstance().getComisiones().size()+1];
			aComisiones[0] = "<< Seleccione >>";
			for (int i = 0; i < PUCMM.getInstance().getComisiones().size(); i++) {
				aComisiones[i+1] = PUCMM.getInstance().getComisiones().get(i).getNombre();

			}
			
			cbxComision.setModel(new DefaultComboBoxModel(aComisiones));
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
	}
}
