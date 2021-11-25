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

import backend.PUCMM;
import backend.Persona;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

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
		setTitle("Listado de persona");
		setBounds(100, 100, 510, 357);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				{
					String headers[] = {"Cedula","Nombre","Telefono","Email"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(10, 40, 470, 229);
				panel.add(panel_1);
				panel_1.setLayout(null);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 470, 229);
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
							System.out.println(selected.getCedula()+" "+selected.getNombre());
						}
					}
				});
				table.setModel(model);
				scrollPane.setViewportView(table);
			}
			{
				JLabel lblNewLabel = new JLabel("Cedula");
				lblNewLabel.setBounds(10, 15, 46, 14);
				panel.add(lblNewLabel);
			}
			{
				txtBuscar = new JTextField();
				txtBuscar.setBounds(66, 12, 200, 20);
				panel.add(txtBuscar);
				txtBuscar.setColumns(10);
			}
			{
				btnBuscar = new JButton("Buscar");
				btnBuscar.setBounds(276, 11, 89, 23);
				panel.add(btnBuscar);
			}
			{
				comboBox = new JComboBox();
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"<< Todos >>", "Participantes", "Jurados"}));
				comboBox.setBounds(375, 12, 105, 20);
				panel.add(comboBox);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegistrarPersona aux = new RegistrarPersona();
						aux.setModal(true);
						aux.setVisible(true);
					}
				});
				btnModificar.setEnabled(false);
				buttonPane.add(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
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
				JButton cancelButton = new JButton("Cancel");
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