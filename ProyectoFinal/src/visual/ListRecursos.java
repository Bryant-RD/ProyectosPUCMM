package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class ListRecursos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultTableModel model;
	private Recursos selected = null;
	private Object[] rows;
	private JTable table;
	private JButton btnUpdate;
	

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
		setTitle("Listado de Recursos");
		setBounds(100, 100, 780, 679);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setUndecorated(true);
		{
			String[] headers = {"Nombre del equipo","Tipo","Cantidad", "Disponibilidad"};
			model = new DefaultTableModel();
			model.setColumnIdentifiers(headers);
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(184, 219, 217));
		panel.setBounds(12, 13, 756, 613);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(738, 0, 18, 20);
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
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(50, 130, 659, 470);
		panel.add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				if(row != -1) {
					String name = (String) table.getValueAt(row, 0);
					selected = PUCMM.getInstance().buscarRecurso(name);
					btnUpdate.setEnabled(true);
				}
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(model);
		scrollPane.setViewportView(table);
		{
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(50, 68, 203, 49);
			panel.add(panel_2);
			panel_2.setBackground(new Color(184, 219, 217));
			panel_2.setBorder(null);
			panel_2.setLayout(null);
			
			{
				JLabel lblTipoDeRecurso = new JLabel("Tipo de Recurso:");
				lblTipoDeRecurso.setFont(new Font("Calibri", Font.PLAIN, 14));
				lblTipoDeRecurso.setBounds(0, 0, 107, 16);
				lblTipoDeRecurso.setVerticalAlignment(SwingConstants.TOP);
				panel_2.add(lblTipoDeRecurso);
			}
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBackground(SystemColor.inactiveCaptionBorder);
			comboBox.setFont(new Font("Calibri", Font.PLAIN, 14));
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>", "Visual", "Audio", "Mobiliario"}));
			comboBox.setBounds(0, 21, 200, 23);
			panel_2.add(comboBox);
		}
		
		JLabel lblListadoDeRecursos = new JLabel("Listado de Recursos");
		lblListadoDeRecursos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeRecursos.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblListadoDeRecursos.setBounds(283, 20, 226, 28);
		panel.add(lblListadoDeRecursos);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		panel_2.setBounds(268, 13, 258, 45);
		panel.add(panel_2);
		
	
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(184, 219, 217));
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnUpdate = new JButton("Modificar");
				btnUpdate.setBackground(SystemColor.inactiveCaptionBorder);
				btnUpdate.setFont(new Font("Calibri", Font.PLAIN, 14));
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						RegRecursos reg = new RegRecursos(selected);
						reg.setVisible(true);
						System.out.print("funciona");
					}
				});
				btnUpdate.setEnabled(false);
				btnUpdate.setActionCommand("OK");
				buttonPane.add(btnUpdate);
				getRootPane().setDefaultButton(btnUpdate);
			}
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.setBackground(SystemColor.inactiveCaptionBorder);
				cancelButton.setFont(new Font("Calibri", Font.PLAIN, 14));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				{
					JButton btnEliminar = new JButton("Eliminar");
					btnEliminar.setBackground(SystemColor.inactiveCaptionBorder);
					btnEliminar.setFont(new Font("Calibri", Font.PLAIN, 14));
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
			rows[3] = PUCMM.getInstance().getRecursos().get(i).getDisponibilidad();
			model.addRow(rows);
		}
	}
}
