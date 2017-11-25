package infra;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class BancoDeDados {
	private java.sql.Connection connection = null;
	private java.sql.Statement statement = null;
	private ResultSet resultset= null;

	public void connectar() {
		String servidor = "jdbc:mysql://localhost:3306/ProjetoCatraca"; // local host pode ser o ip // projetocatraca é nome 
		                                                                                         // do banco de dados
		String usuario = "root";
		String senha = "1234";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();

		} catch (Exception ex) {
			System.out.println("" + ex.getMessage());

		}
	}

	public boolean estaConectado() {
		if (this.connection != null) {
			return true;
		} else {
			return false;
		}

	}

}
