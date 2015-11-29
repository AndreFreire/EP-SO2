public class Main {


	public static void main(String[] args){
		BD.readBD();
		ThreadManager tManager = new ThreadManager(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		tManager.createThreads();
		tManager.runThreads();
	}
}