package infra;

public class InfraException extends Exception {

	private String mensagem;

	public InfraException() {
		this.mensagem = "Erro na manipulacao do arquivo";
	}

	public InfraException(String mensagem) {
		this.mensagem = mensagem;
	}
}
