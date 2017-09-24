package pl.bartekdrzazgowski.java9;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Stream.of(1, 4, 5, 2, 3, 6, 7).dropWhile(x -> x < 5).forEach(x -> System.out.println(x));
		
		List<Integer> list = List.of(1, 2);
		System.out.println("List class: " + list.getClass());
		System.out.println("List size: " + list.size());
		
		Map<Integer, String> map = Map.of(1, "Gdansk", 2, "Sopot", 3, "Gdynia");
		map.forEach((k, v) -> System.out.println(k + " => " + v));
		
		ProcessHandle currentProcess = ProcessHandle.current();
		System.out.println("Current Process Id: = " + currentProcess.pid());
		System.out.println("Current Process is alive: " + currentProcess.isAlive());
	}
}
