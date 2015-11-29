import java.util.Random;

public class Writer extends Thread{

	public void run(){		
		//Fazer 100 acessos a base de dados.

		Random random = new Random();
		
		int key = random.nextInt(1000000000);
		
		BD.writers.put(key,BD.writers.size());
		while(BD.readers.size() != 0 || BD.writers.get(key) > 0);
		while(!BD.isAuthorization());
		for(int i = 0; i < 100; i++){
			BD.setItem(random.nextInt(BD.getSizeDatabase()));
		}
		
		try {
			Writer.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BD.decrementWriters();

	}
}
