package ravi.tutorial.java.java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

/**
 * 1)Find words with letter R,
 * 
 * 2) then make all letters to upper case
 * 
 * 3) then sort filtered list
 * 
 * 4)then print list.
 * 
 * @author ravik
 *
 */
public class StreamsExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Ravi");
		list.add("Test");
		list.add("Roopali");
		list.add("India");
		list.add("Sangli");
		list.add("Great");

		/**
		 * Classic way
		 */
		List<String> results = new ArrayList<>();
		for (String s : list) {
			if (StringUtils.containsIgnoreCase(s, "R")) {
				results.add(s.toUpperCase());
			}
		}
		Collections.sort(results);
		System.out.println(results);

		/**
		 * Lambda & streams. Uses Collectors & collect method. Also uses map &
		 * filter.
		 */
		results = list.stream().filter(s -> StringUtils.containsIgnoreCase(s, "R")).map(s -> s.toUpperCase()).sorted()
				.collect(Collectors.toList());
		System.out.println(results);

		/**
		 * Using method reference to map
		 */
		results = list.stream().filter(s -> StringUtils.containsIgnoreCase(s, "R")).map(String::toUpperCase).sorted()
				.collect(Collectors.toList());
		System.out.println(results);

		/**
		 * Limit to 2 & join by using comma ,
		 */
		String joinedResults = list.stream().filter(s -> StringUtils.containsIgnoreCase(s, "R"))
				.map(String::toUpperCase).sorted().limit(2).collect(Collectors.joining(","));
		System.out.println(joinedResults);

		/**
		 * For each, to print
		 */
		list.stream().filter(s -> StringUtils.containsIgnoreCase(s, "R")).map(String::toUpperCase).sorted()
				.forEach(System.out::println);

		

	}

}
