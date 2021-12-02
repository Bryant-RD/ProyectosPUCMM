package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import backend.PUCMM;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Calificaciones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JButton btnBuscar;
	private JTable table;
	private DefaultTableModel model;
	private Object[] rows;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Calificaciones dialog = new Calificaciones();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Calificaciones() {
		setBounds(100, 100, 526, 403);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Codigo");
			lblNewLabel.setBounds(10, 11, 46, 14);
			panel.add(lblNewLabel);
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(66, 8, 214, 20);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(290, 7, 89, 23);
			panel.add(btnBuscar);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(10, 36, 480, 274);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 480, 274);
			panel_1.add(scrollPane);
			
			table = new JTable();
			model = new DefaultTableModel();
			String headers[] = {"Codigo", "propietario" ,"Nombre","Tema", "calificaicon", "Total"};
			model.setColumnIdentifiers(headers);
			table.setModel(model);
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void loadTable() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (int i = 0; i < PUCMM.getInstance().getRecursos().size(); i++) {
//			rows[0] = PUCMM.getInstance().get;
			rows[1] = PUCMM.getInstance().getRecursos().get(i).getTipo();
			rows[2] = PUCMM.getInstance().getRecursos().get(i).getCantidad();
			model.addRow(rows);
		}
	}
}
