package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.PUCMM;
import backend.Trabajo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Calificando extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField textField_1;
	private JTextField txtEvento;
	private JTextField txtNombre;
	private JTextField txtTema;
	private JTextField txtCalificaion;
	private JLabel txtPropietario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Calificando dialog = new Calificando(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param selected 
	 */
	public Calificando(Trabajo selected) {
		setBounds(100, 100, 720, 382);
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(176, 224, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(248, 248, 255));
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
			lblX.setBounds(690, 0, 20, 20);
			panel.add(lblX);
			
			JLabel lblNewLabel_1 = new JLabel("Codigo:");
			lblNewLabel_1.setBounds(33, 114, 46, 14);
			lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 14));
			panel.add(lblNewLabel_1);
			
			txtPropietario = new JLabel("Propietario:");
			txtPropietario.setBounds(12, 169, 67, 14);
			txtPropietario.setFont(new Font("Calibri", Font.PLAIN, 14));
			panel.add(txtPropietario);
			
			JLabel lblNewLabel_3 = new JLabel("Nombre Proyecto:");
			lblNewLabel_3.setBounds(346, 114, 103, 14);
			lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 14));
			panel.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Tema:");
			lblNewLabel_4.setBounds(413, 169, 36, 14);
			lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 14));
			panel.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("Evento:");
			lblNewLabel_5.setBounds(33, 226, 46, 14);
			lblNewLabel_5.setFont(new Font("Calibri", Font.PLAIN, 14));
			panel.add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel("Calificacion:");
			lblNewLabel_6.setBounds(382, 226, 67, 14);
			lblNewLabel_6.setFont(new Font("Calibri", Font.PLAIN, 14));
			panel.add(lblNewLabel_6);
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(94, 111, 184, 20);
			txtCodigo.setEnabled(false);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(94, 166, 184, 20);
			textField_1.setEnabled(false);
			textField_1.setColumns(10);
			panel.add(textField_1);
			
			txtEvento = new JTextField();
			txtEvento.setBounds(94, 223, 184, 20);
			txtEvento.setEnabled(false);
			txtEvento.setColumns(10);
			panel.add(txtEvento);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(464, 111, 184, 20);
			txtNombre.setEnabled(false);
			txtNombre.setColumns(10);
			panel.add(txtNombre);
			
			txtTema = new JTextField();
			txtTema.setBounds(464, 166, 184, 20);
			txtTema.setEnabled(false);
			txtTema.setColumns(10);
			panel.add(txtTema);
			
			txtCalificaion = new JTextField();
			txtCalificaion.setBounds(464, 223, 184, 20);
			txtCalificaion.setColumns(10);
			panel.add(txtCalificaion);
			
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBackground(new Color(176, 224, 230));
			panel_1.setBounds(226, 13, 258, 45);
			panel.add(panel_1);
			
			JLabel lblCalificacionDeTrabajos = new JLabel("Calificacion de Trabajos");
			lblCalificacionDeTrabajos.setFont(new Font("Century Gothic", Font.PLAIN, 16));
			lblCalificacionDeTrabajos.setBounds(38, 12, 191, 21);
			panel_1.add(lblCalificacionDeTrabajos);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(248, 248, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.setBackground(new Color(248, 248, 255));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						PUCMM.getInstance().calificarTrabajo(txtCodigo.getText(), Float.valueOf(txtCalificaion.getText()));
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(new Color(248, 248, 255));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
