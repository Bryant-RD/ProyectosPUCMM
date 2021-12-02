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
import java.util.ArrayList;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 518, 391);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel(" Cedula Presidente");
				lblNewLabel.setBounds(10, 70, 118, 14);
				panel.add(lblNewLabel);
			}
			{
				txtPresidente = new JTextField();
				txtPresidente.setBounds(126, 67, 259, 20);
				panel.add(txtPresidente);
				txtPresidente.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Cedula Jurado");
				lblNewLabel_1.setBounds(10, 102, 106, 14);
				panel.add(lblNewLabel_1);
			}
			{
				txtJurado = new JTextField();
				txtJurado.setBounds(126, 99, 259, 20);
				panel.add(txtJurado);
				txtJurado.setColumns(10);
			}
			{
				btnNewButton = new JButton("Agregar");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Jurado jurado = PUCMM.getInstance().getJuradoByCedula(txtJurado.getText());
						if(jurado != null && PUCMM.getInstance().agregarJuradoComision(jurado)) {
							
							String text = jurado.getCedula() + " - " + jurado.getNombre();
							lstModel.addElement(text);
							jurados.add(jurado);
							
						} else {
							JOptionPane.showMessageDialog(null, "Jurado no encontrado", "Error!", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btnNewButton.setBounds(395, 98, 89, 23);
				panel.add(btnNewButton);
			}
			
			list = new JList();
			lstModel = new DefaultListModel();
			list.setModel(lstModel);
			list.setBounds(10, 132, 472, 165);
			panel.add(list);
			
			JLabel lblNewLabel_2 = new JLabel("Nombre Comision");
			lblNewLabel_2.setBounds(10, 11, 106, 14);
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Area de Conocimiento");
			lblNewLabel_3.setBounds(10, 42, 118, 14);
			panel.add(lblNewLabel_3);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(126, 8, 259, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtAreaConocimiento = new JTextField();
			txtAreaConocimiento.setBounds(126, 36, 259, 20);
			panel.add(txtAreaConocimiento);
			txtAreaConocimiento.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Jurado presidente = PUCMM.getInstance().getJuradoByCedula(txtPresidente.getText());
						if(presidente != null && PUCMM.getInstance().agregarJuradoComision(presidente) && jurados.size() > 0) {
							
							PUCMM.getInstance().crearComision(txtNombre.getText(), presidente, txtAreaConocimiento.getText(), jurados);
							
						}
							
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
