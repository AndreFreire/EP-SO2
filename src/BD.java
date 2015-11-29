import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class BD {
	
	static LinkedList<String> database = new LinkedList<String>();
	static ConcurrentHashMap<Integer, Integer> readers = new ConcurrentHashMap<Integer, Integer>();
	static ConcurrentHashMap<Integer, Integer> writers = new ConcurrentHashMap<Integer, Integer>();
	static boolean inUse = false;
	
	public static void readBD() {
		BD.database = new LinkedList<String>();
		try{
			Scanner sc = new Scanner(new FileReader("bd.txt"));
			while(sc.hasNext()){
				database.add(sc.next());
			}
			sc.close();
		} catch (FileNotFoundException file) {
			System.out.println("Erro de leitura.");
		}
	}

	public static int getSizeDatabase() {
		return database.size();
	}

	public static String getItem(int position){
		return database.get(position);
	}

	public static void setItem(int position) {
		BD.database.set(position,"Modify");
		
	}
	
	public static void decrementReaders(){
		boolean haveZero = false;
		boolean havePositiveNumber = false;
		for(int key : readers.keySet()){
			BD.readers.put(key, (BD.readers.get(key)-1));
			if(readers.get(key) == 0)haveZero = true;
			if(readers.get(key) > 0)havePositiveNumber = true;
		}
		if (!haveZero && havePositiveNumber)decrementReaders();
		BD.inUse=false;
	}
	
	public static void decrementWriters(){
		boolean haveZero = false;
		boolean havePositiveNumber = false;	
		for(int key : writers.keySet()){
			BD.writers.put(key, (BD.writers.get(key)-1));
			if(writers.get(key) == 0)haveZero = true;
			if(writers.get(key) > 0)havePositiveNumber = true;
		}
		if(!haveZero && havePositiveNumber)decrementWriters();
		BD.inUse=false;
	}
	public static synchronized boolean isAuthorization(){
		if(BD.inUse){
			return false;
		}else{
			BD.inUse = true;
			return BD.inUse;
		}		
	}	
	public static void init(){
		BD.readers = new ConcurrentHashMap<Integer, Integer>();//Linha comentada para evitar o bloqueio
		BD.writers = new ConcurrentHashMap<Integer, Integer>();//Linha comentada para evitar o bloqueio
	}
}
