
public class Compounds {

	public void eat(CowThread cowThread) {
		System.out.println("cow " + "" + cowThread.id + " is eating");

	}

	public void drink(CowThread cowThread) {
		System.out.println("cow " + "" + cowThread.id + " is drinking");
		synchronized (this) {//finished drinking so notify cows that are waiting for atleats 4 cows to finish drinking in walk method
			cowThread.res.fineatdrink++;
			notifyAll();
		}

	}

	public synchronized void walk(CowThread cowThread) throws InterruptedException {
		while (cowThread.res.fineatdrink < 4) {//wait for four cows to finish drinking
			wait();
		}
		System.out.println("cow " + "" + cowThread.id + " is walking");

	}

	public void milk(CowThread cowThread) {
		if ((cowThread.id % 2 == 1 || cowThread.res.milked >= 5)) {//check if 5 cows got milked or if id divides by 2
			System.out.println(
					"cow " + "" + cowThread.id + " denied milking. too many milked already or id doesnt divide by 2");
			return;
		}
		synchronized (this) {
			System.out.println("cow " +cowThread.id + " is getting milked");

			cowThread.res.milked++;
		}

	}

}
