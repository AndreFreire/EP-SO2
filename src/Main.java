import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {


	public static void main(String[] args){
		BD.readBD();
		ThreadManager tManager = new ThreadManager();
		tManager.createThreads();
		tManager.runThreads();


		//Impress�o do database
	/*		Iterator iterator = database.iterator();
			while(iterator.hasNext()){
				System.out.println(iterator.next());
			}*/	
	}
}