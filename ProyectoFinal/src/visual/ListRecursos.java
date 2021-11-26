package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import backend.PUCMM;
import backend.Recursos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;

public class ListRecursos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultTableModel model;
	private Recursos selected = null;
	private Object[] rows;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListRecursos dialog = new ListRecursos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListRecursos() {
		setModal(true);
		setTitle("Listado de Recursos");
		setResizable(false);
		setBounds(100, 100, 684, 603);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(2, 2, 663, 88);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Filtros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblTipoDeVino = new JLabel("Tipo de Recurso:");
				lblTipoDeVino.setBounds(16, 28, 107, 16);
				lblTipoDeVino.setVerticalAlignment(SwingConstants.TOP);
				panel.add(lblTipoDeVino);
			}
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>", "Visual", "Audio", "Mobiliario"}));
			comboBox.setBounds(16, 55, 200, 23);
			panel.add(comboBox);
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(2, 93, 664, 423);
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel.add(scrollPane, BorderLayout.CENTER);
			
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			String[] headers = {"Nombre del equipo","Tipo","Cantidad"};
			model = new DefaultTableModel();
			model.setColumnIdentifiers(headers);
			table.setModel(model);
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnUpdate = new JButton("Modificar");
				btnUpdate.setEnabled(false);
				btnUpdate.setActionCommand("OK");
				buttonPane.add(btnUpdate);
				getRootPane().setDefaultButton(btnUpdate);
			}
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				{
					JButton btnEliminar = new JButton("Eliminar");
					btnEliminar.setEnabled(false);
					buttonPane.add(btnEliminar);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadrecursos();
	}
	
	
	private void loadrecursos() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (int i = 0; i < PUCMM.getInstance().getRecursos().size(); i++) {
			rows[0] = PUCMM.getInstance().getRecursos().get(i).getNombreEquipo();
			rows[1] = PUCMM.getInstance().getRecursos().get(i).getTipo();
			rows[2] = PUCMM.getInstance().getRecursos().get(i).getCantidad();
			model.addRow(rows);
		}
	}
}
