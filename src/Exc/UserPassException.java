package Exc;

public class UserPassException extends Exception {

	public UserPassException() {
		super("Senha Invalida");
	}

	public UserPassException(String mensagem) {
		super(mensagem);
	}
}
