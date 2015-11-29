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

	public static int getSizeDatabase() {
		return database.size();
	}

	public static String getItem(int position){
		System.out.println("getItem");
		return database.get(position);
	}

	public static void setItem(int position) {
		System.out.println("setItem");
		BD.database.set(position,"Modify");
		
	}
	
}
