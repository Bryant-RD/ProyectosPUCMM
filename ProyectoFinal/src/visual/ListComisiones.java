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
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		setBounds(100, 100, 792, 636);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(184, 219, 217));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Nombre:");
				lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
				lblNewLabel.setBounds(50, 107, 55, 14);
				panel.add(lblNewLabel);
			}
			{
				textField = new JTextField();
				textField.setBounds(117, 100, 293, 28);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				JButton btnNewButton = new JButton("Buscar");
				btnNewButton.setForeground(SystemColor.infoText);
				btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
				btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 14));
				btnNewButton.setBounds(428, 100, 95, 28);
				panel.add(btnNewButton);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(50, 141, 670, 424);
				panel.add(panel_1);
				panel_1.setLayout(null);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 670, 424);
				panel_1.add(scrollPane);
				
				table = new JTable();
				model = new DefaultTableModel();
				String[] headers = {"Codigo", "Nombre", "Presidente", "Area", "Intergantes", "Trabajos"};
				model.setColumnIdentifiers(headers);
				table.setModel(model);
				scrollPane.setViewportView(table);
				
				JLabel lblX = new JLabel("X");
				lblX.setBounds(764, 0, 18, 20);
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
				
				
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(SystemColor.inactiveCaptionBorder);
				panel_1.setBounds(274, 13, 258, 45);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNewLabel_1 = new JLabel("Listado de Comisiones");
					lblNewLabel_1.setBounds(42, 12, 170, 21);
					lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
					panel_1.add(lblNewLabel_1);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(184, 219, 217));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.setForeground(SystemColor.infoText);
				okButton.setBackground(SystemColor.inactiveCaptionBorder);
				okButton.setFont(new Font("Calibri", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setForeground(SystemColor.infoText);
				cancelButton.setBackground(SystemColor.inactiveCaptionBorder);
				cancelButton.setFont(new Font("Calibri", Font.PLAIN, 14));
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
			rows[0] = PUCMM.getInstance().getComisiones().get(i).getCodigo();
			rows[1] = PUCMM.getInstance().getComisiones().get(i).getNombre();
			rows[2] = PUCMM.getInstance().getComisiones().get(i).getPresidente().getNombre();
			rows[3] = PUCMM.getInstance().getComisiones().get(i).getAreaConocimiento();
			rows[4] = PUCMM.getInstance().getComisiones().get(i).getJurados().size();
			rows[5] = PUCMM.getInstance().getComisiones().get(i).getTrabajos().size();
			model.addRow(rows);
		}
	}
	
}
