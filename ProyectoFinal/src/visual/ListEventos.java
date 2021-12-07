package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import backend.Evento;
import backend.PUCMM;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class ListEventos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] rows;
	private JButton btnModificar;
	private String select;
	private JButton btnEliminar;
	private int index;
	private JButton btnReporte;
	private JComboBox cbxTipo = new JComboBox();


	
	public ListEventos() {
		setTitle("Lista de Eventos");
		setBounds(100, 100, 781, 537);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			panel.setBackground(new Color(184, 219, 217));
			
			JLabel label = new JLabel("");
			label.setBounds(6, 51, 102, 328);
			panel.add(label);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBackground(new Color(190,209,201));
			scrollPane.setBounds(35, 75, 679, 328);
			panel.add(scrollPane);
			{
				table = new JTable();
				table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						index = table.getSelectedRow();
						if(index >= 0) {
							select = table.getValueAt(index, 0).toString();
							btnModificar.setEnabled(true);
							btnEliminar.setEnabled(true);
							btnReporte.setEnabled(true);
						}
					}
				});
				model = new DefaultTableModel();
				String[] columnNames = {"Codigo","Nombre del Evento","Tema","Tipo","Local","Fecha"};
				model.setColumnIdentifiers(columnNames);
				table.setModel(model);
				scrollPane.setViewportView(table);
				
				JLabel lblTipo = new JLabel("Tema:");
				lblTipo.setFont(new Font("Calibri", Font.PLAIN, 14));
				lblTipo.setBounds(35, 31, 43, 16);
				panel.add(lblTipo);
				cbxTipo.setFont(new Font("Calibri", Font.PLAIN, 14));
				
				cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Fisica", "Quimica", "Medicina", "Administracion", "Informatica"}));
				cbxTipo.setBounds(79, 26, 140, 26);
				panel.add(cbxTipo);
				
				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.setBackground(new Color(244, 244, 249));
				btnBuscar.setFont(new Font("Calibri", Font.PLAIN, 14));
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						loadEventos();

					}
				});
				btnBuscar.setBounds(242, 25, 90, 28);
				panel.add(btnBuscar);
			}
			
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			buttonPane.setBackground(new Color(184, 219, 217));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegEvento registrarEvento = new RegEvento();
						registrarEvento.setModal(true);
						registrarEvento.setVisible(true);
						loadEventos();
					}
				});
				{
					btnModificar = new JButton("Modificar");
					btnModificar.setBackground(new Color(244, 244, 249));
					btnModificar.setFont(new Font("Calibri", Font.PLAIN, 14));
					btnModificar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Evento miEvento = PUCMM.pucmm().searchEventoByCodigo(select);
							RegEvento unEvento = new RegEvento();
							unEvento.setModal(true);
							unEvento.setVisible(true);
							loadEventos();
						}
					});
					{
						btnEliminar = new JButton("Eliminar");
						btnEliminar.setBackground(new Color(244, 244, 249));
						btnEliminar.setFont(new Font("Calibri", Font.PLAIN, 14));
						btnEliminar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// PUCMM.pucmm().removeEventoByCodigo(select);
								JOptionPane.showMessageDialog(null, "Operacion completada con �xito", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
								loadEventos();
							}
						});
						btnEliminar.setEnabled(false);
						buttonPane.add(btnEliminar);
					}
					btnModificar.setEnabled(false);
					
					buttonPane.add(btnModificar);
				}
				
			}
			{
				JButton cancelButton = new JButton("Cerrar");
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
		loadEventos();
	}
	private static void loadEventos() {
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		
		for (int i = 0; i < PUCMM.getInstance().getEventos().size(); i++) {
			rows[0] = PUCMM.getInstance().getEventos().get(i).getCodigo();
			rows[1] = PUCMM.getInstance().getEventos().get(i).getNombre();
			rows[2] = PUCMM.getInstance().getEventos().get(i).getTema();
			rows[3] = PUCMM.getInstance().getEventos().get(i).getTipo();
			rows[4] = PUCMM.getInstance().getEventos().get(i).getLocal();
			rows[5] = PUCMM.getInstance().getEventos().get(i).getFecha();
			model.addRow(rows);
		}
		
	}
}