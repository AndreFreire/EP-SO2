import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

	static String filename= "output.txt";
	public static void write(String text) throws IOException{
		FileWriter fw = new FileWriter(filename,true); 
	    fw.write(text+"\n");
	    fw.close();
	}
}
