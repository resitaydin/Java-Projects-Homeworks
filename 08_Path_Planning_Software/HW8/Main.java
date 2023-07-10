public class Main {
	public static void main(String args[]) {
		// public TestCases(String FileName, int X_SIZE, int Y_SIZE)
		new Thread(new TestCases("map01.txt", 500, 500)).start();
		new Thread(new TestCases("map02.txt", 500, 500)).start();
		new Thread(new TestCases("map03.txt", 500, 500)).start();
		new Thread(new TestCases("map04.txt", 500, 500)).start();
		new Thread(new TestCases("map05.txt", 500, 500)).start();
		new Thread(new TestCases("map06.txt", 500, 500)).start();
		new Thread(new TestCases("map07.txt", 500, 500)).start();
		new Thread(new TestCases("map08.txt", 500, 500)).start();
		new Thread(new TestCases("map09.txt", 500, 500)).start();
		new Thread(new TestCases("map10.txt", 500, 500)).start();

		new Thread(new TestCases("pisa.txt", 1000, 1000)).start();
		new Thread(new TestCases("tokyo.txt", 1000, 1000)).start();
		new Thread(new TestCases("triumph.txt", 1000, 1000)).start();
		new Thread(new TestCases("vatican.txt", 1000, 1000)).start();
	}
}
