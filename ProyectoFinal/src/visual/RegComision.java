package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.Comision;
import backend.Jurado;
import backend.PUCMM;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class RegComision extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPresidente;
	private JTextField txtJurado;
	private JButton btnNewButton;
	private DefaultListModel lstModel;
	private ArrayList<Jurado> jurados;
	private JList list;
	private JTextField txtNombre;
	private JTextField txtAreaConocimiento;
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegComision dialog = new RegComision();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegComision() {
		jurados = new ArrayList<>();
		setBounds(100, 100, 569, 574);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(176, 224, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(244, 244, 249));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblX = new JLabel("X");
			lblX.setBounds(541, 0, 18, 20);
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
				JLabel lblNewLabel = new JLabel(" Cedula del Presidente:");
				lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
				lblNewLabel.setBounds(18, 244, 137, 14);
				panel.add(lblNewLabel);
			}
			{
				txtPresidente = new JTextField();
				txtPresidente.setBounds(163, 241, 259, 20);
				panel.add(txtPresidente);
				txtPresidente.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Cedula del Jurado:");
				lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 14));
				lblNewLabel_1.setBounds(49, 294, 106, 14);
				panel.add(lblNewLabel_1);
			}
			{
				txtJurado = new JTextField();
				txtJurado.setBounds(162, 291, 259, 20);
				panel.add(txtJurado);
				txtJurado.setColumns(10);
			}
			{
				btnNewButton = new JButton("Agregar");
				btnNewButton.setBackground(new Color(88, 111, 124));
				btnNewButton.setForeground(new Color(255, 255, 255));
				btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 14));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Jurado jurado = PUCMM.getInstance().getJuradoByCedula(txtJurado.getText());
						if(jurado != null) {
							
							String text = jurado.getCedula() + " - " + jurado.getNombre();
							lstModel.addElement(text);
							jurados.add(jurado);
							
							txtJurado.setText("");
							
						} else {
							JOptionPane.showMessageDialog(null, "Jurado no encontrado", "Error!", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnNewButton.setBounds(440, 290, 89, 23);
				panel.add(btnNewButton);
			}
			
			list = new JList();
			lstModel = new DefaultListModel();
			list.setModel(lstModel);
			list.setBounds(14, 324, 513, 165);
			panel.add(list);
			
			JLabel lblNewLabel_2 = new JLabel("Nombre de la Comision:");
			lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblNewLabel_2.setBounds(14, 147, 141, 14);
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Area de Conocimiento:");
			lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblNewLabel_3.setBounds(25, 195, 130, 14);
			panel.add(lblNewLabel_3);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(163, 143, 259, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtAreaConocimiento = new JTextField();
			txtAreaConocimiento.setBounds(163, 192, 259, 20);
			panel.add(txtAreaConocimiento);
			txtAreaConocimiento.setColumns(10);
			{
				JLabel lblTitle = new JLabel("Registro de Comisiones");
				lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
				lblTitle.setFont(new Font("Century Gothic", Font.PLAIN, 16));
				lblTitle.setBounds(194, 22, 204, 37);
				panel.add(lblTitle);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(176, 224, 230));
				panel_1.setBounds(181, 13, 229, 61);
				panel.add(panel_1);
			}
			{
				txtCodigo = new JTextField();
				txtCodigo.setEnabled(false);
				txtCodigo.setColumns(10);
				txtCodigo.setBounds(162, 106, 259, 20);
				txtCodigo.setText("C-"+PUCMM.getInstance().getComisiones().size());
				panel.add(txtCodigo);
			}
			{
				JLabel lblCodigoDeLa = new JLabel("Codigo de la Comision:");
				lblCodigoDeLa.setFont(new Font("Calibri", Font.PLAIN, 14));
				lblCodigoDeLa.setBounds(13, 110, 141, 14);
				panel.add(lblCodigoDeLa);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(244, 244, 249));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setBackground(new Color(88, 111, 124));
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setFont(new Font("Calibri", Font.PLAIN, 14));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Jurado presidente = PUCMM.getInstance().getJuradoByCedula(txtPresidente.getText());
						
						if(presidente != null && PUCMM.getInstance().verificarJurado(presidente) && jurados.size() > 0 && verificarlista(presidente) == 0) {
							
							PUCMM.getInstance().crearComision(txtCodigo.getText(),txtNombre.getText(), presidente, txtAreaConocimiento.getText(), jurados);
							JOptionPane.showMessageDialog(null, "Comision registrada correctamente.");
							
							txtNombre.setText("");
							txtAreaConocimiento.setText("");
							txtPresidente.setText("");
							lstModel.removeAllElements();
						} else {
							JOptionPane.showMessageDialog(null, "Ha ocurrido un problema con los jurados seleccionados", "Error!", JOptionPane.ERROR_MESSAGE);
						}
							
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setBackground(new Color(88, 111, 124));
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setFont(new Font("Calibri", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private int verificarlista(Jurado presidente) {
		int cont = 0;
		for (Jurado jurado : jurados) {
			if(jurado.getCedula().equalsIgnoreCase(presidente.getCedula())) {
				cont++;
			}
		}
		return cont;
	}
}
