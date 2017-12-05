package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import business.UserManager;
import business.control.OnlineUser;
import business.control.SingletonId;
import business.model.User;
import infra.Arquivo;
import infra.InfraException;

public class Main {

	private JFrame frame;
	private JTextField txtLogin;
	private JTextField txtSenha;
	protected static HashMap<String, User> catraca = new HashMap<>();
	public static boolean acesso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Main window = new Main();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 427, 302);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(20, 11, 374, 241);
		frame.getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtLogin = new JTextField();
		txtLogin.setColumns(10);

		txtSenha = new JTextField();
		txtSenha.setColumns(10);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				// UserManager i = new UserManager();
                
				User u = new User();
				TelaInicial t1 = new TelaInicial();
				try {
					catraca = Arquivo.load();
				} catch (InfraException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if ((!catraca.containsKey(txtLogin.getText()))) {
					JOptionPane.showMessageDialog(null, "Login Não Existe");

						

					} else {
						SingletonId idUsuario = new SingletonId();
						idUsuario.getInstance();
						t1.show();
						t1.setExtendedState(new TelaInicial().MAXIMIZED_BOTH);
						OnlineUser online = new OnlineUser();
						online.Status(u);

					}
				

				// System.out.println(cliente.getKey());

				// i.add(email);

				/*
				 * BancoDeDados bd = new BancoDeDados();
				 * bd.Acesso(txtLogin.getText(), txtSenha.getText());
				 * if(bd.acesso ==true){ TelaInicial t1 =new TelaInicial();
				 * t1.show(); t1.setExtendedState(new
				 * TelaInicial().MAXIMIZED_BOTH);
				 * 
				 * } if(bd.acesso==false){ txtLogin.setText("");
				 * txtSenha.setText(""); txtLogin.requestFocus(); }
				 * bd.acesso=false;
				 */

			}

		});

		JLabel lblNewLabel_1 = new JLabel("");
		// Imagenzinha bonitinha que coloquei
		lblNewLabel_1.setIcon(new ImageIcon("nature.jpg"));

		JLabel lblNewLabel_2 = new JLabel("Login");
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// cadastrar
				Cadastrar t2 = new Cadastrar();

				Main window = new Main();
				t2.show();

			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(60).addGroup(gl_panel
						.createParallelGroup(Alignment.LEADING, false).addGroup(gl_panel
								.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 46,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false).addComponent(txtSenha)
										.addComponent(txtLogin, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 94,
										GroupLayout.PREFERRED_SIZE)))
						.addGap(83)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 638, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup().addGap(184).addComponent(lblNewLabel_2)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(37).addComponent(lblNewLabel_2).addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(28).addComponent(lblNewLabel_1,
										GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 14,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(33).addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnEntrar).addComponent(btnCadastrar))))));
		panel.setLayout(gl_panel);
	}
}
