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
import java.awt.Font;
import java.awt.Color;

public class ListComisiones extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTable table;
	private DefaultTableModel model;
	private Object[] rows;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListComisiones dialog = new ListComisiones();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListComisiones() {
		setTitle("Lista de Comisiones");
		setBounds(100, 100, 716, 575);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(248, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(244, 244, 249));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Nombre:");
				lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 14));
				lblNewLabel.setBounds(10, 21, 55, 14);
				panel.add(lblNewLabel);
			}
			{
				textField = new JTextField();
				textField.setBounds(77, 14, 293, 28);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				JButton btnNewButton = new JButton("Buscar");
				btnNewButton.setForeground(new Color(255, 255, 255));
				btnNewButton.setBackground(new Color(88, 111, 124));
				btnNewButton.setFont(new Font("Serif", Font.PLAIN, 14));
				btnNewButton.setBounds(388, 14, 95, 28);
				panel.add(btnNewButton);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(10, 58, 670, 424);
				panel.add(panel_1);
				panel_1.setLayout(null);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 670, 424);
				panel_1.add(scrollPane);
				
				table = new JTable();
				model = new DefaultTableModel();
				String[] headers = {"Nombre", "Presidente", "Area", "Intergantes", "Trabajos"};
				model.setColumnIdentifiers(headers);
				table.setModel(model);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(244, 244, 249));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setBackground(new Color(88, 111, 124));
				okButton.setFont(new Font("Serif", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(88, 111, 124));
				cancelButton.setFont(new Font("Serif", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadTable();
	}
	
	private void loadTable() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (int i = 0; i < PUCMM.getInstance().getComisiones().size(); i++) {
			rows[0] = PUCMM.getInstance().getComisiones().get(i).getNombre();
			rows[1] = PUCMM.getInstance().getComisiones().get(i).getPresidente().getNombre();
			rows[2] = PUCMM.getInstance().getComisiones().get(i).getAreaConocimiento();
			rows[3] = PUCMM.getInstance().getComisiones().get(i).getJurados().size();
			rows[4] = PUCMM.getInstance().getComisiones().get(i).getTrabajos().size();
			model.addRow(rows);
		}
	}
	
}
