package business.control;

public class SingletonId {
	
	private static SingletonId instanceId;
	
	public SingletonId getInstance(){
		
		if (instanceId==null){
			instanceId = new SingletonId();
			System.out.println("Criando Instancia do ID do usuário");
	
			
		}
		else {
			System.out.println("instancia já foi criada");
		}
		return instanceId;
	}

}
