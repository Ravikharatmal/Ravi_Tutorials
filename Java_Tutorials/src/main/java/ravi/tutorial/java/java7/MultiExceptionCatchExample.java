package ravi.tutorial.java.java7;

public class MultiExceptionCatchExample {

	public static void main(String[] args) {
		try {
			someMethod(1);
			System.out.println("Hello World");
		} catch (FirstException | SecondException e) {
			e.printStackTrace();
		}

	}

	public static void someMethod(int i) throws FirstException, SecondException {
		if (i == 1) {
			throw new FirstException();
		} else if (i == 2) {
			throw new FirstException();
		}
	}

}

class FirstException extends Exception {
}

class SecondException extends Exception {
}
