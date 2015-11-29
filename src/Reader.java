import java.util.Random;


public class Reader extends Thread{
	
	String wordDatabase;
	
	public void run(){
		//Fazer 100 acessos a base de dados.
/*
		Random random = new Random();
		
		int key = random.nextInt(1000000000);
		
		BD.readers.put(key,BD.readers.size());
		while(!BD.isAuthorization() || BD.readers.get(key) > 0);
		System.out.println("Entrando na regiao critica - rd");
		for(int i = 0; i < 100; i++){
			wordDatabase = BD.getItem(random.nextInt(BD.getSizeDatabase()));
		}
		
		try {
			Reader.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BD.readers.remove(key);
		System.out.println("Saindo da regiao critica - rd");
		BD.decrementReaders();
		*/
	}
}
