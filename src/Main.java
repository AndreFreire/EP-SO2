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