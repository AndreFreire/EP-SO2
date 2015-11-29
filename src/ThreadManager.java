import java.util.LinkedList;
import java.util.Random;


public class ThreadManager {
	int qtdTreads = 100;
	int propReaders;
	int propWriters;
	
	public ThreadManager(int propReaders, int propWriters) {
		this.propReaders = propReaders;
		this.propWriters = propWriters;
	}
	
	Thread[] threadsArray = new Thread[qtdTreads];
	LinkedList<Integer> usedPosition = new LinkedList<Integer>();
		
	Random number = new Random();
	int randomIndex;
	
	public void randomNumber(){
		randomIndex = number.nextInt(this.qtdTreads);
	}
	
	public int verifyRandomArrayPosition(){
		randomNumber();
		if(usedPosition.contains(randomIndex)){
			verifyRandomArrayPosition();
		} else {
			usedPosition.add(randomIndex);
			return randomIndex;
		}
		return randomIndex;
	}
	
	public void createThreads(){
		for(int contReader = 0; contReader < propReaders; contReader++){
			verifyRandomArrayPosition();
			Reader read = new Reader();
			threadsArray[randomIndex] = read;
		}		
		for(int contWriter = 0; contWriter < propWriters; contWriter++){
			verifyRandomArrayPosition();
			Writer write = new Writer();
			threadsArray[randomIndex] = write;
		}
	}
	
	public void runThreads(){
		for(int i = 0; i < qtdTreads; i++){
			threadsArray[i].start();
		}
	}
	
}
