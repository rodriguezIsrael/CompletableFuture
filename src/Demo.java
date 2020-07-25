import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Example for completable future
 * 
 * @author isivroes
 *
 */
public class Demo {

//	public static void main(String args[]) throws InterruptedException, ExecutionException {
//
//		CompletableFuture<String> completableFutureFather = CompletableFuture.completedFuture("Message");
//		completableFutureFather.complete("Hello!!! ");
//		System.out.println("It's done?: " + completableFutureFather.isDone());
//		System.out.println("What's result? " + completableFutureFather.getNow(null));
//
//	}
	public static void main(String args[]) throws InterruptedException, ExecutionException {

		CompletableFuture<Void> completableFutureOne = CompletableFuture.runAsync(() -> one());
		CompletableFuture<Void> completableFutureTwo = CompletableFuture.runAsync(() -> two());
		CompletableFuture<Void> completableFutureThree = CompletableFuture.runAsync(() -> three());

		long startTime = System.currentTimeMillis();
//		one();
//		two();
//		three();
		System.out.println("test");
		CompletableFuture<Void> completableFutureFather = CompletableFuture.allOf(completableFutureOne,
				completableFutureTwo, completableFutureThree);
		completableFutureFather.join();
		System.out.println("It's over?");
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.println("Tiempo total " + estimatedTime);

//		System.out.println("Is completed? " + completableFutureFather.isDone());
	}

	public static void one() {

		for (int i = 0; i < 3; i++) {
			System.out.println("Uno");
		}
	}

	public static void two() {
		for (int i = 0; i < 3; i++) {
			System.out.println("dos");

		}
	}

	public static void three() {
		for (int i = 0; i < 3; i++) {
			System.out.println("tres");
		}
	}
}
