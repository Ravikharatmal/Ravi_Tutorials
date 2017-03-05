package ravi.tutorial.java.java8.lambda;

import java.util.ArrayList;
import java.util.List;

public class StreamReduceWithIdentityExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("First");
		list.add("Second");
		list.add("Third");
		list.add("Fourth");

		String reducedString = list.stream().reduce("Zero", (result, element) -> {
			System.out.println("Result = " + result + " | Element = " + element);
			return result = result + " <" + element + ">";
		});

		System.out.println("Final reduced string = " + reducedString);
	}

}
