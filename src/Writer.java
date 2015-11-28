import java.util.Random;


public class Writer extends Thread{

	public void run(){		
		//Fazer 100 acessos a base de dados.
		
		Random random = new Random();
		
		for(int i = 0; i < 100; i++){
			BD.setItem(random.nextInt(BD.getDatabase().size()));
		}
		
		try {
			Writer.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
