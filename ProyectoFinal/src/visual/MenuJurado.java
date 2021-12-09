package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class MenuJurado extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JButton btnBuscar;
	private JTable table;
	private DefaultTableModel model;
	private Object[] rows;
	private static Trabajo selected = null;
	private JButton btnCalificar;
	private Dimension dim;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MenuJurado dialog = new MenuJurado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MenuJurado() {
		setBounds(100, 100, 1005, 774);
		setLocationRelativeTo(null);
		setResizable(false);
//		setModal(true);
		setUndecorated(true);
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height-35);
		setLocationRelativeTo(null);
		setResizable(false);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(248, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(176, 224, 230));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblX = new JLabel("X");
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
			lblX.setBounds(1890, 0, 20, 20);
			panel.add(lblX);
			
			JLabel lblNewLabel = new JLabel("Codigo");
			lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblNewLabel.setBounds(433, 182, 46, 14);
			panel.add(lblNewLabel);
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(489, 174, 390, 31);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.setFont(new Font("Calibri", Font.PLAIN, 14));
			btnBuscar.setBounds(889, 173, 89, 32);
			panel.add(btnBuscar);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(433, 218, 1025, 741);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(0, 0, 1025, 741);
			panel_1.add(scrollPane);
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int row = table.getSelectedRow();
					if(row != -1) {
						String code = (String) table.getValueAt(row, 0);
						selected = PUCMM.getInstance().buscarTrabajoByCode(code);
						btnCalificar.setEnabled(true);
					}
				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			model = new DefaultTableModel();
			String headers[] = {"Codigo", "propietario" ,"Nombre","Tema", "calificaicon", "Total"};
			model.setColumnIdentifiers(headers);
			table.setModel(model);
			scrollPane.setViewportView(table);
			
			JLabel lblMenuDeJurado = new JLabel("Menu de Jurado");
			lblMenuDeJurado.setHorizontalAlignment(SwingConstants.CENTER);
			lblMenuDeJurado.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			lblMenuDeJurado.setBounds(742, 20, 476, 91);
			panel.add(lblMenuDeJurado);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(SystemColor.inactiveCaptionBorder);
			panel_2.setBounds(727, 13, 491, 98);
			panel.add(panel_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(176, 224, 230));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnCalificar = new JButton("Calificar");
				btnCalificar.setFont(new Font("Calibri", Font.PLAIN, 14));
				btnCalificar.setEnabled(false);
				btnCalificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Calificando calificando = new Calificando(selected);
						calificando.setVisible(true);
					}
				});
				btnCalificar.setActionCommand("OK");
				buttonPane.add(btnCalificar);
				getRootPane().setDefaultButton(btnCalificar);
			}
			{
				JButton cancelButton = new JButton("Cerrar Sesion");
				cancelButton.setFont(new Font("Calibri", Font.PLAIN, 14));
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
		
		ArrayList<Trabajo> trabajos = PUCMM.getInstance().trabajosLogueado();
		
		
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
