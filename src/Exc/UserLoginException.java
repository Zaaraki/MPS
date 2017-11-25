package Exc;

public class UserLoginException extends Exception {

	public UserLoginException() {
		super("Login invalido");
	}

	public UserLoginException(String mensagem) {
		super(mensagem);
	}
}