import java.util.Random;

public class Writer extends Thread{

	public void run(){		
		//Fazer 100 acessos a base de dados.

		Random random = new Random();
		
		int key = random.nextInt(1000000000);
		
		BD.writers.put(key,BD.writers.size());
		System.out.println(String.valueOf(BD.inUse)+"-"+BD.readers.size()+"-"+(BD.writers.get(key)));
		while(!BD.isAuthorization() || BD.readers.size() != 0 || BD.writers.get(key) > 0);
			System.out.println(String.valueOf(BD.inUse)+"-"+BD.readers.size()+"-"+(BD.writers.get(key)));		
		System.out.println("Entrando na regiao critica wt");
		for(int i = 0; i < 100; i++){
			BD.setItem(random.nextInt(BD.getSizeDatabase()));
		}
		
		try {
			Writer.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BD.writers.remove(key);
		System.out.println("Saindo da regiao critica - wt");
		BD.decrementWriters();

	}
}
