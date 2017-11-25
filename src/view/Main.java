package view;

import javax.swing.JOptionPane;

import business.UserManager;
import business.control.*;

public class Main {

	public static void main(String[] args) throws Exception {

		String senha = null;
		String email = null;
		ComandoIF c = null;

		int opcao;
		UserManager i = new UserManager();

		try {

			do {
				opcao = Integer.parseInt(javax.swing.JOptionPane
						.showInputDialog("" + "1 - Criar Conta.\n" + "2 - Lista de usuarios e senhas\n"
								+ "3 - buscar email especifico\n" + "4 - deletar um login.\n" + "5 - Desfazer\n"+ "6 - Sair"));

				switch (opcao) {
				case 1:
					email = JOptionPane.showInputDialog("Digite o email: ");
					senha = JOptionPane.showInputDialog("Digite a senha: ");
					c = new AdicionaComando(email,senha);
					i.Invoker(c);
					//i.add(email);

					break;
				case 2:

					
					c = new BuscaTodosComando();
					//i.iniciaSistema();
					//i.buscaTodosUsuarios();
					i.Invoker(c);

					break;
				case 3:
					email = JOptionPane.showInputDialog("Digite o email ");
					//i.iniciaSistema();
					//i.buscaUsuario(email);
					c = new BuscaUsuarioComando(email);
					i.Invoker(c);
					break;
				case 4:
					email = JOptionPane.showInputDialog("Digite o email ");
					//i.iniciaSistema();
					//i.del(email);
					c = new DeletaComando(email);
					i.Invoker(c);
					break;
				case 5:
					i.Undo();
					break;
				default:

				}
			} while (opcao != 6);

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Programa finalizado");

		} catch (NullPointerException ex) {
			JOptionPane.showMessageDialog(null, "Programa finalizado");
		}
	}

}
