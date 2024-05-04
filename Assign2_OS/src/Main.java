import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		SharedResources res = new SharedResources();
		Compounds comp = new Compounds();
		System.out.println("enter amount of cows:");
		int n = scn.nextInt();

		for (int i = 0; i < n; i++) {
			new Thread(new CowThread(i, comp, res)).start();
		}

	}

}
