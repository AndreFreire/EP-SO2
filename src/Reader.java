import java.util.Random;


public class Reader extends Thread{
	
	Object wordDatabase;
	
	public void run(){
		//Fazer 100 acessos a base de dados.
		
		Random random = new Random();
			
		for(int i = 0; i < 100; i++){
			wordDatabase = BD.getItem(random.nextInt(BD.getSizeDatabase()));
		}
		
		try {
			Reader.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
