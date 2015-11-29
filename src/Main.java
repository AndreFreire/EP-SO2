import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class Main {


	public static void main(String[] args) throws IOException{

		String filename= "output.txt";
		
		for(int i = 0;i<100; i++){
			BD.database = new LinkedList<String>();
			BD.readBD();
			for(int j = 0; j<50; j++){
				BD.readers = new ConcurrentHashMap<Integer, Integer>();//Linha comentada para evitar o bloqueio
				BD.writers = new ConcurrentHashMap<Integer, Integer>();//Linha comentada para evitar o bloqueio

				ThreadManager tManager = new ThreadManager(i,100-i);
				tManager.createThreads();
				long t1 = System.currentTimeMillis();
				tManager.runThreads();
				long t2 = System.currentTimeMillis();
				String text = "Proporção: | readers |"+ i +"| writers |"+(100-i) +"| Execução |"+j+"| tempo | "+(t2-t1) +"|ms";
				System.out.println(text);
			    FileWriter fw = new FileWriter(filename,true); 
			    fw.write(text+"\n");
			    fw.close();
			}
		}
	}
}