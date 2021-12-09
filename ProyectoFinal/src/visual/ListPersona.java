package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.rmi.server.LoaderHandler;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import backend.Administrador;
import backend.PUCMM;
import backend.Persona;
import backend.Jurado;
import backend.Participante;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class ListPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object rows[];
	private Persona selected = null;
	private static JButton btnModificar;
	private static JButton btnEliminar;
	private JTextField txtBuscar;
	private JButton btnBuscar;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListPersona dialog = new ListPersona();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListPersona() {
		setFont(new Font("Calibri", Font.PLAIN, 12));
		setTitle("Listado de persona");
		setBounds(100, 100, 564, 514);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 544, 456);
			panel.setBackground(new Color(184, 219, 217));
			panel.setBorder(new EmptyBorder(0, 0, 0, 0));
			contentPanel.add(panel);
			{
				{
					String headers[] = {"Cedula","Nombre","Telefono","Email"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
				}
			}
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(22, 158, 501, 281);
				panel.add(panel_1);
				panel_1.setLayout(null);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 501, 281);
				panel_1.add(scrollPane);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				table = new JTable();
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = -1;
						index = table.getSelectedRow();
						if (index != -1) {
							btnEliminar.setEnabled(true);
							btnModificar.setEnabled(true);
							String cedula = (String)(model.getValueAt(index, 0));
							selected = PUCMM.getInstance().buscarPersonaByCedula(cedula);
							if (selected.getRol().equalsIgnoreCase("Administrador")) {
								selected = ((Administrador) selected);
							} else if(selected.getRol().equalsIgnoreCase("Jurado")) {
								selected = ((Jurado) selected);
								
							} else{
								selected = ((Participante) selected);
								
							}
								
								
							System.out.println(selected.getCedula()+" "+selected.getNombre());
						}
					}
				});
				table.setModel(model);
				scrollPane.setViewportView(table);
			}
			{
				JLabel lblNewLabel = new JLabel("Cedula:");
				lblNewLabel.setBounds(22, 102, 46, 14);
				lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
				panel.add(lblNewLabel);
			}
			{
				txtBuscar = new JTextField();
				txtBuscar.setBounds(78, 99, 200, 20);
				panel.add(txtBuscar);
				txtBuscar.setColumns(10);
			}
			{
				btnBuscar = new JButton("Buscar");
				btnBuscar.setBounds(288, 98, 89, 23);
				btnBuscar.setBackground(new Color(244, 244, 249));
				btnBuscar.setFont(new Font("Calibri", Font.PLAIN, 14));
				panel.add(btnBuscar);
			}
			{
				comboBox = new JComboBox();
				comboBox.setBounds(415, 101, 105, 20);
				comboBox.setBackground(new Color(244, 244, 249));
				comboBox.setFont(new Font("Calibri", Font.PLAIN, 14));
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"<< Todos >>", "Participantes", "Jurados", "Administradores"}));
				panel.add(comboBox);
			}
			
			JLabel lblX = new JLabel("X");
			lblX.setBounds(522, 0, 18, 20);
			panel.add(lblX);
			
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
			
			JLabel lblListadoDePersonas = new JLabel("Listado de Personas");
			lblListadoDePersonas.setBounds(163, 20, 226, 28);
			lblListadoDePersonas.setHorizontalAlignment(SwingConstants.CENTER);
			lblListadoDePersonas.setFont(new Font("Century Gothic", Font.PLAIN, 15));
			panel.add(lblListadoDePersonas);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(148, 13, 258, 45);
			panel_1.setBackground(SystemColor.inactiveCaptionBorder);
			panel.add(panel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(184, 219, 217));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.setBackground(new Color(244, 244, 249));
				btnModificar.setFont(new Font("Calibri", Font.PLAIN, 14));
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegistrarPersona aux = new RegistrarPersona(selected);
						aux.setModal(true);
						aux.setVisible(true);
					}
				});
				btnModificar.setEnabled(false);
				buttonPane.add(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setBackground(new Color(244, 244, 249));
				btnEliminar.setFont(new Font("Calibri", Font.PLAIN, 14));
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int option = JOptionPane.showConfirmDialog(null, "Desea eliminar la persona seleccionado: "+selected.getCedula(), "Eliminar persona", JOptionPane.YES_NO_OPTION);
						if (option == JOptionPane.YES_OPTION) {
							PUCMM.getInstance().eliminarPersona(selected);
							loadTable();
						}
						btnEliminar.setEnabled(false);
						btnModificar.setEnabled(false);
					}
				});
				btnEliminar.setEnabled(false);
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(new Color(244, 244, 249));
				cancelButton.setFont(new Font("Calibri", Font.PLAIN, 14));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadTable();
	}

	public static void loadTable() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (int i = 0; i < PUCMM.getInstance().getPersona().size(); i++) {
			rows[0] = PUCMM.getInstance().getPersona().get(i).getCedula();
			rows[1] = PUCMM.getInstance().getPersona().get(i).getNombre();
			rows[2] = PUCMM.getInstance().getPersona().get(i).getNumero();
			rows[3] = PUCMM.getInstance().getPersona().get(i).getEmail();
			model.addRow(rows);
		}
		btnEliminar.setEnabled(false);
		btnModificar.setEnabled(false);
	}
}
