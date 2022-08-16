package com.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 
 * In this example, we looked into the toMap() method of the Collectors class.
 * It allows us to create a new Map from a Stream.
 * 
 * We also learned how to resolve key conflicts and create different map
 * implementations.
 * 
 * https://www.baeldung.com/java-collectors-tomap
 * 
 * 
 * https://stackoverflow.com/questions/45231351/differences-between-collectors-tomap-and-collectors-groupingby-to-collect-in
 * 
 * https://stackoverflow.com/questions/21697349/using-streams-to-collect-into-treeset-with-custom-comparator
 * 
 * 
 * To collect into a Map that contains a single value by key
 * (Map<MyKey,MyObject>), use Collectors.toMap().
 * 
 * To collect into a Map that contains multiple values by key
 * (Map<MyKey,List<MyObject>>), use Collectors.groupingBy().
 * 
 */

public class G_CollectorsToMap {
	public static void main(String[] args) {

		List<Book> books = new ArrayList<>();
		books.add(new Book("If Trugth be told", 2010, "123"));
		books.add(new Book("The Fellowship of the Ring", 1954, "101"));
		books.add(new Book("The Two Towers", 1954, "026"));
		books.add(new Book("The Return of the King", 1955, "001"));
		books.add(new Book("Alchemist", 1995, "125"));

		/**
		 * Store the book by its ISBN number...
		 * 
		 * Key - isbn , value - book name
		 */

		books.stream().collect(Collectors.toMap(b -> b.getIsbn(), b -> b.getName())); // OR

		books.stream().collect(Collectors.toMap(Book::getIsbn, Book::getName)).entrySet().forEach(System.out::println);

		/*
		 * Problem with this is if two keys are duplicate then it throw the issue. If we
		 * know keys are duplicate then we can use the overloaded method of toMap.
		 * 
		 * To resolve it, we need to use a different method with an additional
		 * parameter, the mergeFunction:
		 * 
		 * For Example if key is Year then possibility multiple books in same years.
		 * 
		 * 
		 * (oldValye, newValye) -> newValye ; that is if the same key came again replace
		 * its value by new key
		 */

		System.out.println();

		Map<Integer, String> bookMapByYear = books.stream()
				.collect(Collectors.toMap(Book::getReleaseYear, Book::getName, (e1, e2) -> e2));

		bookMapByYear.entrySet().stream().forEach(System.out::println);

		/*
		 * Let say we store into map by key as ISBN and value as name
		 * 
		 * Lastly, let's see how to return a sorted map. For that, we'll use a TreeMap
		 * as a mapSupplier parameter.
		 * 
		 * Because a TreeMap is sorted according to the natural ordering of its keys by
		 * default, we don't have to explicitly sort.
		 * 
		 * 
		 */

		System.out.println("\nOrder by Key (ISBN)\n");

		TreeMap<String, String> byISBNOrderByName = books.stream()
				.collect(Collectors.toMap(Book::getIsbn, Book::getName, (o1, o2) -> o2, TreeMap::new));

		byISBNOrderByName.entrySet().stream().forEach(System.out::println);
		
		
		System.out.println("\n*** Alternate Way for Above : Test Output ****\n");
		TreeMap<String, String> test = books.stream()
				.collect(Collectors.toMap(Book::getIsbn, Book::getName, (o1, o2) -> o2, () -> new TreeMap<>()));
		test.entrySet().stream().forEach(System.out::println);
	}

}

class Book {

	private String name;
	private int releaseYear;
	private String isbn;

	public Book(String name, int releaseYear, String isbn) {
		super();
		this.name = name;
		this.releaseYear = releaseYear;
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", releaseYear=" + releaseYear + ", isbn=" + isbn + "]";
	}

}