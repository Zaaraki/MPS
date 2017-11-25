package infra;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import business.model.User;

public class Arquivo implements Serializable {

	private static final long serialVersionUID = 1L;

	private static FileOutputStream writeUsers;
	private static FileInputStream readUsers;

	private static ObjectInputStream readObj;
	private static ObjectOutputStream writeObj;

	public static HashMap<String, User> load() throws InfraException {
		HashMap<String, User> u;
		try {
			readUsers = new FileInputStream("arquivo.txt");
			readObj = new ObjectInputStream(readUsers);
			u = (HashMap<String, User>) readObj.readObject();
			readUsers.close();
			readObj.close();
			return u;
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
			throw new InfraException("Não foi possível iniciar o sistema\nTente novamente mais tarde");
		} catch (IOException | ClassNotFoundException ex) {
			Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
			throw new InfraException("Não foi possível iniciar o sistema\nTente novamente mais tarde");
		}
	}

	public static void save(HashMap<String, User> u) throws InfraException {
		try {
			writeUsers = new FileOutputStream("arquivo.txt");
			writeObj = new ObjectOutputStream(writeUsers);
			writeObj.writeObject(u);
			writeUsers.close();
			writeObj.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
			throw new InfraException("Não foi possível completar o cadastro\nTente novamente mais tarde");
		} catch (IOException ex) {
			Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
			throw new InfraException("Não foi possível completar o cadastro\nTente novamente mais tarde");
		}
	}
}
