
public class CowThread implements Runnable {

	final int id;
	Compounds comp;
	SharedResources res;

	public CowThread(int id, Compounds comp, SharedResources res) {
		this.id = id;
		this.comp = comp;
		this.res = res;
	}

	@Override
	public void run() {
		try {
			this.res.eathouse.acquire();//acquire ticket for eat house
			this.comp.eat(this);// cows eat before drinking
			this.res.eathouse.release();
			this.res.drinkhouse.acquire();//acquire ticket for drink house
			this.comp.drink(this);//after eating cows will drink
			this.res.drinkhouse.release();
			this.comp.walk(this);
			this.comp.milk(this);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
