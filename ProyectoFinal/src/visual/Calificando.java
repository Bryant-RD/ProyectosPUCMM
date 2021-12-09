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
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 710, 351);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Calificaion de Trabajo");
			lblNewLabel.setBounds(257, 11, 184, 57);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Codigo");
			lblNewLabel_1.setBounds(10, 82, 46, 14);
			panel.add(lblNewLabel_1);
			
			txtPropietario = new JLabel("Propietario");
			txtPropietario.setBounds(10, 136, 76, 14);
			panel.add(txtPropietario);
			
			JLabel lblNewLabel_3 = new JLabel("Nombre Proyecto");
			lblNewLabel_3.setBounds(357, 82, 117, 14);
			panel.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Tema");
			lblNewLabel_4.setBounds(357, 136, 46, 14);
			panel.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("Evento");
			lblNewLabel_5.setBounds(10, 197, 46, 14);
			panel.add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel("Calificacion");
			lblNewLabel_6.setBounds(357, 197, 76, 14);
			panel.add(lblNewLabel_6);
			
			txtCodigo = new JTextField();
			txtCodigo.setEnabled(false);
			txtCodigo.setBounds(66, 79, 184, 20);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setEnabled(false);
			textField_1.setColumns(10);
			textField_1.setBounds(66, 133, 184, 20);
			panel.add(textField_1);
			
			txtEvento = new JTextField();
			txtEvento.setEnabled(false);
			txtEvento.setColumns(10);
			txtEvento.setBounds(66, 194, 184, 20);
			panel.add(txtEvento);
			
			txtNombre = new JTextField();
			txtNombre.setEnabled(false);
			txtNombre.setColumns(10);
			txtNombre.setBounds(464, 79, 184, 20);
			panel.add(txtNombre);
			
			txtTema = new JTextField();
			txtTema.setEnabled(false);
			txtTema.setColumns(10);
			txtTema.setBounds(464, 133, 184, 20);
			panel.add(txtTema);
			
			txtCalificaion = new JTextField();
			txtCalificaion.setColumns(10);
			txtCalificaion.setBounds(464, 194, 184, 20);
			panel.add(txtCalificaion);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
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
