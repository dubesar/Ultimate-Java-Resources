import java.util.Scanner;

public class dice {

	public static void main(String[] args) {
		
		boolean b = true;
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("Give input to roll the dice or write X to exit!");
			String a = scanner.next();
			if (a.toLowerCase().equals("x")) {
				b = false;
			} else {
				System.out.println((int)(Math.random() * 6 + 1));
			}
		} while(b);
		scanner.close();
		
	}

}
