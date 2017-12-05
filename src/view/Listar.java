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

import business.UserManager;
import business.control.BuscaUsuarioComando;
import business.control.ComandoIF;
import business.control.ListIterator;
import business.control.OrdenadorTemplate;

public class Listar extends JFrame {

	private JPanel contentPane;
	private JTextField txt_nome;
	private ListIterator iterator;
	private JLabel txt_user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listar frame = new Listar();

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
	public Listar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 312, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(112, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		JLabel lblBuscar = new JLabel("Nome:");

		txt_nome = new JTextField();
		txt_nome.setColumns(10);

		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComandoIF c = null;
				int a;
				OrdenadorTemplate Ord = null;

				int opcao;
				UserManager i = new UserManager();
				try {
					c = new BuscaUsuarioComando(txt_nome.getText());
					i.Invoker(c);
					dispose();
					Listar t6 = new Listar();
					t6.show();
					// DefaultListModel dlm = new DefaultListModel();
					// dlm.addElement(txt_nome.getText());

					// Default
					// lista.setModel(dlm);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, " O usuario não existe!");
					e1.printStackTrace();
				}

			}
		});

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaInicial t8 = new TelaInicial();
				t8.show();
				dispose();

			}
		});

		JButton btnPrximo = new JButton("Pr\u00F3ximo");
		btnPrximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					iterator.next();
					txt_user.setText(iterator.currentItem().getLogin());
				} catch (Exception ex) {
					iterator.first();
					txt_user.setText(iterator.currentItem().getLogin());
				}
			}
		});

		JLabel lblNome = new JLabel("Nome:");

		txt_user = new JLabel("");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addComponent(lblBuscar).addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnProcurar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txt_nome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 169,
										Short.MAX_VALUE)))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup().addComponent(btnPrximo)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnVoltar))
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblNome)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(txt_user))))
				.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblBuscar).addComponent(
						txt_nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnProcurar).addGap(30)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNome).addComponent(txt_user))
				.addPreferredGap(ComponentPlacement.RELATED, 105, Short.MAX_VALUE).addGroup(gl_panel
						.createParallelGroup(Alignment.BASELINE).addComponent(btnPrximo).addComponent(btnVoltar))
				.addContainerGap()));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		iterator = new ListIterator();
		txt_user.setText(iterator.currentItem().getLogin());
	}
}
