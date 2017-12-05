package business.control;

import javax.swing.JOptionPane;

import business.model.User;

public class OfflineUser implements EstadoIf{
	
	public void Status(User context) {
		JOptionPane.showMessageDialog(null, "Usuário Offline");
		context.setEstado(this);

	}

	


}
