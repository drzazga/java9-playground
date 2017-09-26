package pl.bartekdrzazgowski.java9;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Main {

	public static void main(String[] args) {
		streams();
		separator();
		collections();
		separator();
		optionals();
		separator();
		processes();
	}

	private static void streams() {
		LongStream.range(0, 10).takeWhile(i -> i < 5L).forEach(x -> System.out.print(x + " "));
		newLine();
		IntStream.range(10, 100).dropWhile(x -> x < 90).forEach(x -> System.out.print(x + " "));
		newLine();
		IntStream.iterate(10, x -> x > 0, x -> x - 1).forEach(x -> System.out.print(x + " "));
		newLine();
	}

	private static void collections() {
		List<Integer> list = List.of(1, 2);
		System.out.println("List class: " + list.getClass());
		System.out.println("List size: " + list.size());
		
		Set<Integer> set = Set.of(1, 2);
		System.out.println("Set class: " + set.getClass());
		System.out.println("Set size: " + set.size());
		
		Map<Integer, String> map = Map.of(1, "Gdansk", 2, "Sopot", 3, "Gdynia");
		map.forEach((k, v) -> System.out.println(k + " => " + v));
	}
	
	private static void optionals() {
		Optional.empty().or(() -> Optional.of(42)).ifPresent(x -> System.out.println("or - " + x));
		System.out.println(Optional.of(ThreadLocalRandom.current().nextInt()).stream());
		Optional.empty().ifPresentOrElse(x -> System.out.print("ifPresentOrElse - " + x), () -> System.out.println("ifPresentOrElse - no value"));
	}
	
	private static void processes() {
		ProcessHandle currentProcess = ProcessHandle.current();
		System.out.println("Current Process pid: " + currentProcess.pid());
		System.out.println("Current Process is alive: " + currentProcess.isAlive());
		System.out.println("Current Process command: " + currentProcess.info().command());
		System.out.println("Current Process user: " + currentProcess.info().user());
	}
	
	private static void separator() {
		System.out.println("\n---------------\n");
	}
	
	private static void newLine() {
		System.out.println("");
	}
}
