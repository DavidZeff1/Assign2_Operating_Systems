import java.util.concurrent.Semaphore;

public class SharedResources {
	Semaphore eathouse = new Semaphore(3);//only 3 allowed in the eathouse at a time
	Semaphore drinkhouse = new Semaphore(6);//only 6 allowed in the drinkhouse at a time
	int fineatdrink = 0;///to make sure that 4 finished eating and drinking before walking
	int milked = 0;//to check if 5 got milked

}
