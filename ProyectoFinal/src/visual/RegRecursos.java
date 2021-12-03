package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.PUCMM;
import backend.Recursos;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

public class RegRecursos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JComboBox cbxTipo;
	private JButton btnRegistrar;
	private JSpinner spnCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegRecursos dialog = new RegRecursos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegRecursos() {
		setTitle("Registrar Recursos");
		setBounds(100, 100, 425, 303);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(244, 244, 249));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setUndecorated(true);
		{
			JLabel lblNombreObj = new JLabel("Nombre del Objeto:");
			lblNombreObj.setFont(new Font("Calibri", Font.PLAIN, 15));
			lblNombreObj.setBounds(9, 99, 124, 16);
			contentPanel.add(lblNombreObj);
		}
		
		txtNombre = new JTextField();
		txtNombre.setBounds(154, 95, 180, 22);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblCantidad.setBounds(66, 208, 67, 16);
		contentPanel.add(lblCantidad);
		
		JLabel lblTipo = new JLabel("Tipo de Objeto:");
		lblTipo.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblTipo.setBounds(37, 153, 96, 16);
		contentPanel.add(lblTipo);
		{
			spnCantidad = new JSpinner();
			spnCantidad.setBounds(154, 204, 56, 22);
			contentPanel.add(spnCantidad);
		}
		{
			cbxTipo = new JComboBox();
			cbxTipo.setFont(new Font("Calibri", Font.PLAIN, 15));
			cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>", "Audio", "Visual", "Mobiliario"}));
			cbxTipo.setBounds(154, 150, 158, 22);
			contentPanel.add(cbxTipo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(244, 244, 249));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.setBackground(new Color(88, 111, 124));
				btnRegistrar.setForeground(Color.WHITE);
				btnRegistrar.setFont(new Font("Calibri", Font.PLAIN, 15));
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (txtNombre.getText().length() == 0 ||cbxTipo.getSelectedIndex() == 0 || Integer.valueOf(spnCantidad.getValue().toString()) == 0) {
							
							JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacios", "Error!", JOptionPane.ERROR_MESSAGE);
							
						} else {

							Recursos recurso = new Recursos(Integer.valueOf(spnCantidad.getValue().toString()),cbxTipo.getSelectedItem().toString(), txtNombre.getText());
							PUCMM.getInstance().agregarRecurso(recurso);
							JOptionPane.showMessageDialog(null, "Nuevo equipo registrado correctamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
							
							txtNombre.setText("");
							cbxTipo.setSelectedIndex(0);
							spnCantidad.setValue(0);
							
						}
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(new Color(88, 111, 124));
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setFont(new Font("Calibri", Font.PLAIN, 15));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Esta seguro de que quieres cerrar la aplicacion?","Confirmacion", JOptionPane.YES_NO_OPTION) == 0) {
					dispose();
				}
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
		lblX.setBounds(405, 0, 20, 20);
		contentPanel.add(lblX);
		
		JLabel lblTitle = new JLabel("Registro de Recursos");
		lblTitle.setBounds(133, 30, 158, 21);
		contentPanel.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblTitle.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblTitle.setBackground(new Color(240, 240, 240));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(176, 224, 230));
			panel.setBounds(99, 22, 228, 39);
			contentPanel.add(panel);
		}
	}
}
