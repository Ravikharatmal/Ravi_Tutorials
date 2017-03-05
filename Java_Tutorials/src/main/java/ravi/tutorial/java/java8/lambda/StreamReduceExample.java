package ravi.tutorial.java.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("First");
		list.add("Second");
		list.add("Third");
		list.add("Fourth");

		Optional<String> reducedString = list.stream()
				.reduce((result, element) -> {
					System.out.println(
							"Result = " + result + " | Element = " + element);
					return result = result + " AND " + element;
				});

		System.out.println("Final reduced string = "
				+ (reducedString.isPresent() ? reducedString.get() : "NONE"));
	}

}
