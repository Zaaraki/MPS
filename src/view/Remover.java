package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import Exc.UserLoginException;
import business.UserManager;
import business.control.BuscaUsuarioComando;
import business.control.ComandoIF;
import business.control.DeletaComando;
import business.control.OrdenadorTemplate;

public class Remover extends JFrame {

	private JPanel contentPane;
	private JTextField txt_remover;
	private JTextField txt_user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Remover frame = new Remover();
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
	public Remover() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 314, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(114, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		
		JLabel lblNome = new JLabel("Nome:");
		
		txt_remover = new JTextField();
		txt_remover.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Remover 
				ComandoIF c = null;
				OrdenadorTemplate Ord = null; 
				UserManager i = new UserManager();
		
				try {
					c = new DeletaComando(txt_remover.getText());
					i.Invoker(c);
				} catch (UserLoginException e2) {
					System.out.println(e2.getMessage());

				}catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		
		JLabel lblProcurarUsurio = new JLabel("Procurar usu\u00E1rio:");
		
		txt_user = new JTextField();
		txt_user.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//buscar usuario 
				
				ComandoIF c = null;
				OrdenadorTemplate Ord = null; 
				UserManager i = new UserManager();

				try {
					c = new BuscaUsuarioComando(txt_user.getText());
					i.Invoker(c);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNome)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txt_remover, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
							.addComponent(btnRemover)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblProcurarUsurio)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txt_user)))
						.addComponent(btnProcurar))
					.addContainerGap(142, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(txt_remover, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnRemover)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProcurarUsurio)
						.addComponent(txt_user, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnProcurar)
					.addContainerGap(78, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

}
