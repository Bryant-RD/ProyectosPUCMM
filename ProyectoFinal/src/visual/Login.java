package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.PUCMM;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.TextField;

public class Login extends JDialog {
	
	private Image img_login = new ImageIcon(Login.class.getResource("res/key.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_user = new ImageIcon(Login.class.getResource("res/usuario.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_password = new ImageIcon(Login.class.getResource("res/lock.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_logo = new ImageIcon(Login.class.getResource("res/red.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;
	private JTextField txtUsuario;
	private JButton btnLoggin;
	//private JTextField txtPassword;
	private JPasswordField passwordField;
	private JPasswordField txtPassword;
	static Socket socket = null;
	static ObjectInputStream entradaSocket;
	static ObjectOutputStream SalidaSocket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		
		setBounds(100, 100, 669, 566);
		/*
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height-35);
		setLocationRelativeTo(null);
		setResizable(false);
		*/
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(244, 244, 249));
		contentPanel.setBorder(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setUndecorated(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		{
			
			
			JPanel panel = new JPanel();
			panel.setBorder(null);
			panel.setBackground(new Color(244, 244, 249));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblIconLogo = new JLabel("");
			lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
			lblIconLogo.setBounds(175, 66, 325, 127);
			panel.add(lblIconLogo);
			lblIconLogo.setIcon(new ImageIcon(img_logo));
			
			JPanel pnlUser = new JPanel();
			pnlUser.setBorder(null);
			pnlUser.setBackground(Color.WHITE);
			pnlUser.setBounds(212, 216, 250, 48);
			panel.add(pnlUser);
			pnlUser.setLayout(null);
			
			JLabel lblIconUser = new JLabel("");
			lblIconUser.setHorizontalAlignment(SwingConstants.CENTER);
			lblIconUser.setBounds(204, 0, 46, 48);
			pnlUser.add(lblIconUser);
			lblIconUser.setIcon(new ImageIcon(img_user));
			
			txtUsuario = new JTextField();
			txtUsuario.setBounds(12, 13, 180, 21);
			pnlUser.add(txtUsuario);
			txtUsuario.setBackground(SystemColor.text);
			txtUsuario.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if(txtUsuario.getText().equals("")) {
						txtUsuario.setText("");
					}
					else {
						txtUsuario.selectAll();
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(txtUsuario.getText().equals(""))
						txtUsuario.setText("");
				}
			});
			txtUsuario.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtUsuario.setColumns(10);
			txtUsuario.setBorder(null);
			
			JLabel lblUsuario = new JLabel("Usuario");
			lblUsuario.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblUsuario.setBounds(212, 193, 56, 16);
			panel.add(lblUsuario);
			
			JPanel pnlPassword = new JPanel();
			pnlPassword.setBackground(Color.WHITE);
			pnlPassword.setBounds(212, 300, 250, 48);
			panel.add(pnlPassword);
			pnlPassword.setLayout(null);
			
			JLabel lblIconPassword = new JLabel("");
			lblIconPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lblIconPassword.setBounds(204, 0, 46, 48);
			pnlPassword.add(lblIconPassword);
			lblIconPassword.setIcon(new ImageIcon(img_password));
			
			btnLoggin = new JButton("Iniciar sesion");
			btnLoggin.setForeground(new Color(255, 255, 255));
			btnLoggin.setFont(new Font("Calibri", Font.PLAIN, 18));
			btnLoggin.setBackground(new Color(88, 111, 124));
			btnLoggin.setBorderPainted(false);
			btnLoggin.setOpaque(true);
			
			btnLoggin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (PUCMM.getInstance().loggin(txtUsuario.getText(), txtPassword.getText())) {
						dispose();
						
					} else {
						JOptionPane.showConfirmDialog(null, "Usuario y contraseña no coinciden", "Ups!", JOptionPane.WARNING_MESSAGE);
					}
					
				}
			});
			
			JLabel lblIconLogin = new JLabel("");
			lblIconLogin.setHorizontalAlignment(SwingConstants.CENTER);
			lblIconLogin.setBounds(401, 396, 46, 48);
			panel.add(lblIconLogin);
			lblIconLogin.setIcon(new ImageIcon(img_login));
			btnLoggin.setBounds(197, 393, 280, 55);
			panel.add(btnLoggin);
			
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
			lblX.setBounds(645, 0, 20, 20);
			panel.add(lblX);
			
			txtPassword = new JPasswordField();
			txtPassword.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if(txtPassword.equals("Password")) {
						txtPassword.setEchoChar('●');
						txtPassword.setText("");
					}
					else {
						txtPassword.selectAll();
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(txtPassword.equals("")) {
						txtPassword.setText("Password");
						txtPassword.setEchoChar((char)0);

					}
				}
			});
			txtPassword.setBorder(null);
			txtPassword.setFont(new Font("Calibri", Font.PLAIN, 14));
			txtPassword.setText("");
			txtPassword.setBounds(12, 12, 180, 22);
			pnlPassword.add(txtPassword);
			txtPassword.setColumns(10);
			
			JLabel lblContrasea = new JLabel("Contraseña");
			lblContrasea.setFont(new Font("Calibri", Font.PLAIN, 14));
			lblContrasea.setBounds(212, 277, 71, 16);
			panel.add(lblContrasea);							
		}	
	}
}
