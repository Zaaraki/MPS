package business.control;

import javax.swing.JOptionPane;

import business.model.User;

public class OnlineUser implements EstadoIf {

	public void Status(User context) {
		JOptionPane.showMessageDialog(null, "Usu�rio Online");
		context.setEstado(this);

	}




}
