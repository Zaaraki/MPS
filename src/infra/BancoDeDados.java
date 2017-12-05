package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import com.mysql.*;



public class BancoDeDados {

	/**
	 * Váriavel estática que definirá se o acesso (Autenticação) realmente
	 * aconteceu
	 */
	public static boolean acesso;

	/**
	 * Esse método retorna um Objeto do tipo Usuario já preenchido com os dados
	 * do Usuario Logado Dessa forma poderemos trabalhar com os dados
	 * recuperados do banco
	 */
	public BancoDeDados Acesso(String email, String senha) {

		/** Instancia um novo usuário */
		BancoDeDados user = new BancoDeDados();

		Connection conn = null;
		Statement consulta = null;
		ResultSet tabela = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/login", "root", "");
			consulta = (Statement) conn.createStatement();
			/**Realiza a consulta no banco passando dois parametros: login e senha */
			tabela = consulta.executeQuery(
					"SELECT id_usuario, email, senha from tbl_usuarios WHERE  email='"
							+ email + "'and senha='" + senha + "'");

			/**
			 * Se os dados que foram passados existirem no banco de dados então
			 * pegamos esses dados e passamos para o objeto que foi instanciado
			 */
			if (tabela.next()) {
				/**
				 * Repare que para pegar os dados temos que usar o tabela.get...
				 */
			  JOptionPane.showMessageDialog(null, "Usuario e senhas corretos");
		
				/**
				 * A variavel Acesso recebe True, ou seja estamos autenticados
				 */
				acesso = true;
			} else {
				/** A variavel recebe false, estamos ferrados */
				  JOptionPane.showMessageDialog(null, "Usuario ou senha errados");
				acesso = false;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
		}
		return user;

	}

}