package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.PUCMM;
import backend.Participante;
import backend.Persona;
import backend.Trabajo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class RegTrabajo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JComboBox cbxEvento;
	private JTextField txtCodigo;
	private JComboBox cbxTema;
	private String[] temas;
	private String[] eventos;
	private static Trabajo update = null;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegTrabajo dialog = new RegTrabajo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegTrabajo(Trabajo trabajo) {
		update = trabajo;
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		setBackground(new Color(244, 244, 249));
		setFont(new Font("Serif", Font.PLAIN, 12));
		
		if(update != null) {
			setTitle("Registrar Trabajo");
		} else {
			setTitle("Modificar Trabajo");
		}
		
		setBounds(100, 100, 596, 392);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(176, 224, 230));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setUndecorated(true);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(244, 244, 249));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Cedula Participante:");
			lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 14));
			lblNewLabel.setBounds(42, 37, 125, 16);
			panel.add(lblNewLabel);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(178, 31, 237, 30);
			panel.add(txtCedula);
			txtCedula.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre del Trabajo:");
			lblNewLabel_1.setFont(new Font("Serif", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(42, 129, 135, 16);
			panel.add(lblNewLabel_1);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(178, 123, 237, 30);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Evento:");
			lblNewLabel_3.setFont(new Font("Serif", Font.PLAIN, 14));
			lblNewLabel_3.setBounds(42, 178, 79, 16);
			panel.add(lblNewLabel_3);
			
			JLabel lblTemaDelEvento = new JLabel("Tema del evento:");
			lblTemaDelEvento.setHorizontalAlignment(SwingConstants.CENTER);
			lblTemaDelEvento.setFont(new Font("Serif", Font.PLAIN, 14));
			lblTemaDelEvento.setBounds(29, 235, 125, 16);
			panel.add(lblTemaDelEvento);
			
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
			lblX.setBounds(566, 0, 20, 20);
			panel.add(lblX);
			
			cbxTema = new JComboBox();
			cbxTema.setBackground(new Color(244, 244, 249));
			
			cbxTema.removeAll();

			temas = new String[PUCMM.getInstance().getEventos().size()+1];
			temas[0] = "<< Seleccione >>";
			for (int i = 0; i < PUCMM.getInstance().getEventos().size(); i++) {
				temas[i+1] = PUCMM.getInstance().getEventos().get(i).getTema();

			}
			
			cbxTema.setModel(new DefaultComboBoxModel(temas));
			cbxTema.setBounds(178, 229, 237, 30);
			panel.add(cbxTema);
			
			cbxEvento = new JComboBox();
			cbxEvento.setBackground(new Color(244, 244, 249));
			
			cbxEvento.removeAll();

			eventos = new String[PUCMM.getInstance().getEventos().size()+1];
			eventos[0] = "<< Seleccione >>";
			for (int i = 0; i < PUCMM.getInstance().getEventos().size(); i++) {
				eventos[i+1] = PUCMM.getInstance().getEventos().get(i).getNombre();

			}
			
			
			
			cbxEvento.setModel(new DefaultComboBoxModel(eventos));
			cbxEvento.setBounds(178, 172, 237, 30);
			panel.add(cbxEvento);
			
			JLabel lblNewLabel_2 = new JLabel("Codigo:");
			lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 14));
			lblNewLabel_2.setBounds(42, 77, 73, 24);
			panel.add(lblNewLabel_2);
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(178, 75, 237, 30);
			txtCodigo.setEditable(false);
			txtCodigo.setText("T-"+PUCMM.getInstance().getTrabajo().size());
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(244, 244, 249));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setForeground(Color.WHITE);
				okButton.setBackground(new Color(88, 111, 124));
				okButton.setFont(new Font("Serif", Font.PLAIN, 14));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						Persona persona = PUCMM.getInstance().buscarPersonaByCedula(txtCedula.getText());
						
						if(update != null) {
							
							Trabajo trNew = new Trabajo(txtCodigo.getText(), cbxEvento.getSelectedItem().toString(), txtNombre.getText(), cbxTema.getSelectedItem().toString());
							
							int n = JOptionPane.showConfirmDialog(null, "Estas seguro de que quieres modificar este Trabajo?", "Confirmacion", JOptionPane.YES_NO_OPTION);
							if(n == JOptionPane.YES_OPTION) {
								PUCMM.getInstance().editarTrabajo(update, trNew);
								dispose();
							}
							
						} else {
							
							if(persona != null && persona instanceof Participante) {
								
								Trabajo trabajo = new Trabajo(txtCodigo.getText(),cbxEvento.getSelectedItem().toString(), txtNombre.getText(), cbxTema.getSelectedItem().toString());
								PUCMM.getInstance().agregarTrabajo(txtCedula.getText(), trabajo);
								
							} else {
								JOptionPane.showMessageDialog(null, "Participante no encontrado", "Error!", JOptionPane.ERROR_MESSAGE);
								
							}
							
						}
						 

												
						

						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setBackground(new Color(88, 111, 124));
				cancelButton.setFont(new Font("Serif", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
			
		}
		if(update != null) {
			txtCedula.setEnabled(false);
			txtNombre.setText(update.getNombre());
			cbxEvento.setSelectedItem(update.getEvento());
			cbxTema.setSelectedItem(update.getTema());
		}
	}
}
