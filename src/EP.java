import java.io.IOException;
public class EP {
	public static void init() throws IOException{
		for(int i = 0;i<100; i++){
			BD.readBD();
			for(int j = 0; j<50; j++){
				BD.init();
				ThreadManager tManager = new ThreadManager(i,100-i);
				tManager.createThreads();
				long t1 = System.currentTimeMillis();
				tManager.runThreads();
				long t2 = System.currentTimeMillis();
				String text = "Proporção: | readers |"+ i +"| writers |"+(100-i) +"| Execução |"+j+"| tempo | "+(t2-t1) +"|ms";
				WriteFile.write(text);
			}
		}
	}
}
