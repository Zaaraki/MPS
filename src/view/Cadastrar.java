package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import Exc.UserLoginException;
import business.UserManager;
import business.control.AdicionaComando;
import business.control.ComandoIF;
import business.control.OrdenadorTemplate;

public class Cadastrar extends JFrame {

	private JPanel contentPane;
	private JTextField txt_email;
	private JTextField txt_senha;
	private JTextField txt_cpf;
	private JTextField txt_idade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastrar frame = new Cadastrar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cadastrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(140, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(86, Short.MAX_VALUE)));

		txt_email = new JTextField();
		txt_email.setColumns(10);

		txt_senha = new JTextField();
		txt_senha.setColumns(10);

		JLabel lblEmail = new JLabel("EMAIL:");

		JLabel lblSenha = new JLabel("SENHA:");

		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// cadastrar

				ComandoIF c = null;
				int a;
				OrdenadorTemplate Ord = null;
				UserManager i = new UserManager();

				try {
					
					c = new AdicionaComando(txt_email.getText(), txt_senha.getText(),
							Integer.parseInt(txt_cpf.getText()), Integer.parseInt(txt_idade.getText()));// );
					i.Invoker(c);
					JOptionPane.showMessageDialog(null, " Cadastrado com sucesso!");
					dispose();
					TelaInicial t5 = new TelaInicial();
					t5.show();

				} catch (UserLoginException e2) {
					System.out.println(e2.getMessage());

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Preencha os campos!");
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton btnVoltar = new JButton("Cancelar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		JLabel lblCpf = new JLabel("CPF:");

		JLabel lblIdade = new JLabel("IDADE:");

		txt_cpf = new JTextField();
		txt_cpf.setColumns(10);

		txt_idade = new JTextField();
		txt_idade.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel.createSequentialGroup().addContainerGap().addGroup(gl_panel
										.createParallelGroup(Alignment.TRAILING)
										.addGroup(Alignment.LEADING,
												gl_panel.createSequentialGroup().addComponent(btnConcluir)
														.addPreferredGap(ComponentPlacement.RELATED, 105,
																Short.MAX_VALUE)
														.addComponent(btnVoltar))
										.addGroup(Alignment.LEADING,
												gl_panel.createSequentialGroup()
														.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																.addComponent(lblEmail).addComponent(lblIdade)
																.addComponent(lblCpf).addComponent(lblSenha))
														.addGap(34)
														.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																.addComponent(txt_email, GroupLayout.DEFAULT_SIZE, 180,
																		Short.MAX_VALUE)
																.addComponent(txt_cpf, GroupLayout.DEFAULT_SIZE, 180,
																		Short.MAX_VALUE)
																.addComponent(txt_senha, GroupLayout.DEFAULT_SIZE, 180,
																		Short.MAX_VALUE)
																.addComponent(txt_idade, GroupLayout.PREFERRED_SIZE, 37,
																		GroupLayout.PREFERRED_SIZE))))
										.addGap(23)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblEmail).addComponent(txt_email,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txt_senha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSenha))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txt_cpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCpf))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txt_idade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIdade))
				.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE).addGroup(gl_panel
						.createParallelGroup(Alignment.BASELINE).addComponent(btnConcluir).addComponent(btnVoltar))
				.addContainerGap()));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
