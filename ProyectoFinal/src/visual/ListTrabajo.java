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
import backend.Trabajo;

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
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class ListTrabajo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object rows[];
	private Trabajo selected = null;
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
			ListTrabajo dialog = new ListTrabajo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListTrabajo() {
		setTitle("Listado de Trabajos");
		setBounds(100, 100, 572, 406);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(184, 219, 217));
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblX = new JLabel("X");
			lblX.setBounds(550, 0, 18, 20);
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
			
			
			{
				{
					String headers[] = {"Codigo","Nombre","Tema", "Evento"};
					model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(46, 112, 470, 229);
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
							String nombre = (String)(model.getValueAt(index, 0));
							selected = PUCMM.getInstance().buscarTrabajoByCode(nombre);
							System.out.println(selected.getCodigo()+" "+selected.getNombre());
						}
					}
				});
				table.setModel(model);
				scrollPane.setViewportView(table);
			}
			{
				JLabel lblNewLabel = new JLabel("Codigo:");
				lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
				lblNewLabel.setBounds(46, 80, 46, 14);
				panel.add(lblNewLabel);
			}
			{
				txtBuscar = new JTextField();
				txtBuscar.setBounds(102, 77, 200, 20);
				panel.add(txtBuscar);
				txtBuscar.setColumns(10);
			}
			{
				btnBuscar = new JButton("Buscar");
				btnBuscar.setBackground(new Color(244, 244, 249));
				btnBuscar.setFont(new Font("Calibri", Font.PLAIN, 14));
				btnBuscar.setBounds(312, 76, 89, 23);
				panel.add(btnBuscar);
			}
			{
				JLabel lblListadoDeTrabajos = new JLabel("Listado de Trabajos");
				lblListadoDeTrabajos.setHorizontalAlignment(SwingConstants.CENTER);
				lblListadoDeTrabajos.setFont(new Font("Century Gothic", Font.PLAIN, 15));
				lblListadoDeTrabajos.setBounds(179, 15, 226, 28);
				panel.add(lblListadoDeTrabajos);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(SystemColor.inactiveCaptionBorder);
				panel_1.setBounds(164, 8, 258, 45);
				panel.add(panel_1);
			}
			
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
						RegTrabajo aux = new RegTrabajo(selected);
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
						int option = JOptionPane.showConfirmDialog(null, "Desea eliminar la persona seleccionado: "+selected.getCodigo(), "Eliminar persona", JOptionPane.YES_NO_OPTION);
						if (option == JOptionPane.YES_OPTION) {
							PUCMM.getInstance().eliminarTrabajo(selected);
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

	// COMENTARIO DE PRUEBA
	public static void loadTable() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (int i = 0; i < PUCMM.getInstance().getTrabajo().size(); i++) {
			rows[0] = PUCMM.getInstance().getTrabajo().get(i).getCodigo();
			rows[1] = PUCMM.getInstance().getTrabajo().get(i).getNombre();
			rows[2] = PUCMM.getInstance().getTrabajo().get(i).getTema();
			rows[3] = PUCMM.getInstance().getTrabajo().get(i).getEvento();
			model.addRow(rows);
		}
		btnEliminar.setEnabled(false);
		btnModificar.setEnabled(false);
	}

}
