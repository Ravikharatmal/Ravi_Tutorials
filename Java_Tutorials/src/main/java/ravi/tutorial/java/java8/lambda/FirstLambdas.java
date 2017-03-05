package ravi.tutorial.java.java8.lambda;

/**
 * Examples for lambda to create anonymous class & method reference.
 * 
 * @author ravik
 *
 */
public class FirstLambdas {

	public static void main(String[] args) {

		// Classic way of implementing interface in anonymous class way.
		Player p1 = new Player() {

			@Override
			public void play(String localSportName) {
				System.out.println("Playing " + localSportName);

			}
		};
		p1.play("[Classic] Cricket");

		/*
		 * This is lambda way of doing same as above. Assumption is that
		 * interface will have only one method to be implemented
		 * 
		 * 1) (localSportName) = This is equivalent to public void play(String
		 * localSportName). Since there is only one method in interface, here
		 * its name & entire syntax is omitted in lambda way. Only brackets &
		 * parameter is kept so that we can define name of parameter
		 * 
		 * 2) -> = This is new symbol indicating that the implemetation of
		 * single method follows.
		 * 
		 * 3){ System.out.println("Playing " + localSportName); }; = This is
		 * method body exact same as above approach.
		 */

		Player p = (localSportName) -> {
			System.out.println("Playing " + localSportName);
		};
		p.play("[Basic lambda] Cricket");

		/*
		 * Brackets of parameter & curly braces of implementation can be
		 * removed. But if method body is going to have more than 1 line then
		 * curly braces are needed.
		 */
		Player p2 = localSportName -> System.out
				.println("Playing " + localSportName);

		p2.play("[Lambda without bracket & return] Cricket");

		/**
		 * If implemented method also calls another single line then we can use
		 * method reference.
		 * 
		 * In below example, argument passed to play method is passed to as it
		 * is to println method. It is same as above.
		 */
		Player p3 = System.out::println;
		p3.play("[Method reference] Cricket");

		/*
		 * This is another example where method to be implemented did not have
		 * any parameters.
		 */
		Ball b = () -> {
			System.out.println("You hit it!");
		};
		b.hit();

		/*
		 * Method with parameter and return value
		 */
		Transformer doubler = (input) -> {
			return input * 2;
		};
		long doubledNumber = doubler.transform(4);
		System.out.println("Doubled = " + doubledNumber);

		/*
		 * Same as above but brackets are removed. 'return' word is also removed
		 * as it will be implied.
		 */
		Transformer anothrDoubler = input -> input * 2;
		long anotherDoubledNumber = anothrDoubler.transform(4);
		System.out.println("Another Doubled = " + anotherDoubledNumber);

	}

	/**
	 * Function interface annotation is a informative annotation telling that it
	 * is a functional interface i.e. with single method. Compiler will give
	 * error if interface does not have single method.
	 * 
	 * @author ravik
	 *
	 */
	@FunctionalInterface
	interface Ball {
		void hit();
	}

	@FunctionalInterface
	interface Player {
		void play(String sportName);
	}

	@FunctionalInterface
	interface Transformer {
		long transform(long inputNumber);
	}

}
