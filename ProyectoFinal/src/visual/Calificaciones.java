package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import backend.PUCMM;
import backend.Trabajo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 903, 725);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Codigo");
			lblNewLabel.setBounds(10, 16, 46, 14);
			panel.add(lblNewLabel);
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(66, 8, 390, 31);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(466, 7, 89, 32);
			panel.add(btnBuscar);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(10, 50, 867, 593);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 868, 607);
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
				JButton okButton = new JButton("Calificar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cerrar Sesion");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						PUCMM.getInstance().logueado = null;
						dispose();
						Login lg = new Login();
						lg.setVisible(true);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadTable();
	}
	private void loadTable() {
		
		ArrayList<Trabajo> trabajos =PUCMM.getInstance().trabajosLogueado();
		System.out.print(trabajos.size());
		
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (int i = 0; i < trabajos.size(); i++) {
			rows[0] = trabajos.get(i).getCodigo();
			rows[1] = trabajos.get(i).getNombre();
			rows[2] = trabajos.get(i).getTema();
			
			for (int j = 0; j < trabajos.get(i).getCalificaciones().size(); j++) {
				if(trabajos.get(i).getCalificaciones().get(j).getNomJurado().equalsIgnoreCase(PUCMM.logueado.getNombre())) {
					
					rows[3] = trabajos.get(i).getCalificaciones().get(j).getCalificacion();
				}
			}

			
			
			model.addRow(rows);
		}
	}
}
