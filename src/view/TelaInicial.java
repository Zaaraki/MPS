package view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Exc.MementoException;
import business.UserManager;
import business.control.OfflineUser;
import business.control.SingletonId;
import business.model.User;
import infra.InfraException;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JLabel txt_status;
	private UserManager i;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 419, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE).addContainerGap()));

		JButton btnDesfaz = new JButton("Desfaz");
		btnDesfaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				    i = new UserManager();
					i.Undo();
				} catch (MementoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InfraException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
			}
		});

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// remover

				Remover t1 = new Remover();
				t1.show();
				t1.setExtendedState(new Remover().MAXIMIZED_BOTH);

			}
		});

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// listar
				Listar t1 = new Listar();
				t1.show();
				t1.setExtendedState(new TelaInicial().MAXIMIZED_BOTH);
			}
		});

		JLabel lblOperaes = new JLabel("Opera\u00E7\u00F5es");

		JButton btnSaldo = new JButton("Saldo");
		btnSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// saldo

				Saldo t4 = new Saldo();
				t4.show();
				dispose();
			}
		});

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User u = new User();
				OfflineUser offline = new OfflineUser();
				offline.Status(u);
			
				dispose();
			}
		});
		
	    txt_status = new JLabel("");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(182)
					.addComponent(lblOperaes)
					.addContainerGap(185, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(162, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnListar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDesfaz, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSaldo, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
					.addGap(166))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(txt_status)
					.addContainerGap(419, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(txt_status)
					.addGap(20)
					.addComponent(lblOperaes)
					.addGap(47)
					.addComponent(btnRemover)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSaldo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDesfaz)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnListar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSair)
					.addContainerGap(67, Short.MAX_VALUE))
		);
		gl_panel.linkSize(SwingConstants.VERTICAL, new Component[] {btnDesfaz, btnRemover, btnListar, btnSaldo, btnSair});
		gl_panel.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnDesfaz, btnRemover, btnListar, btnSaldo, btnSair});
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
