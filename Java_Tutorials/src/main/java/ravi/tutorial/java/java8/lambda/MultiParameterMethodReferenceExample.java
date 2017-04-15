package ravi.tutorial.java.java8.lambda;

public class MultiParameterMethodReferenceExample {

	public static void main(String[] args) {

		/**
		 * Lambda way of implementing multi argument method in functional
		 * interface. Here you provide the implementation directly i.e "a + b"
		 */
		Concatenator lambdaConcatenator = (a, b) -> a + b;
		System.out.println(
				"Lambda way = " + lambdaConcatenator.concatenate("Java", "8"));

		/**
		 * Method reference way. Here you already have similar method
		 * implemented somewhere else i.e. doSomeAppending & you just need to
		 * re-use that implementation. Then you just use that method reference
		 * as anonymous class.
		 * 
		 * Parameters of Concatenator.concatenate & doSomeAppending must match.
		 */
		Concatenator methodRefConcatenator = MultiParameterMethodReferenceExample::doSomeAppending;
		System.out.println("Method Reference way = "
				+ methodRefConcatenator.concatenate("Java", "8"));

	}

	public static String doSomeAppending(String one, String two) {
		return one + two;
	}

}

@FunctionalInterface
interface Concatenator {
	public String concatenate(String one, String two);
}
