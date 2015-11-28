import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;


public class BD {
	
	static LinkedList<String> database = new LinkedList<String>();
	
	public static void readBD() {
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

	public static LinkedList<String> getDatabase() {
		return database;
	}

	public static void setDatabase(LinkedList<String> database) {
		BD.database = database;
	}
	public static String getItem(int position){
		return database.get(position);
	}

	public static void setItem(int position) {
		BD.database.set(position,"Modify");
		
	}
	
}
