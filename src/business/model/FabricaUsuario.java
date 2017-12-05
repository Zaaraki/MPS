package business.model;

public class FabricaUsuario implements Fabrica {

	@Override
	public User CriarUser() {
		return new User();
	}

}
