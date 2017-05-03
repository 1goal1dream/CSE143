// Thomas You
// CSE 143
// 5/3/17
// Assignment 2
import java.util.*;

public class GuitarString {	
	private static final int SAMPLE_RATE = 44100;
	private static final double DECAY = 0.996;
	private Queue<Double> buffer;
	
	// Precondition: if frequency is less or equal to 0 or capacity
	// is less than 2, throw an illegal argument exception.
	// Postcondition: enqueue 0s into the array list.
	GuitarString(double frequency) {
		buffer = new LinkedList<Double>();
		int capacity = (int)Math.round(SAMPLE_RATE / frequency);
		if(frequency <= 0 || capacity < 2) {
			throw new IllegalArgumentException();
		}
		for(int i = 0; i < capacity; i++) {
			buffer.add(0.0);
		}
	}
	
	// Precondition: if array length is less than 2, throw an
	// illegal argument exception.
	// Postcondition: all all values in the array to the queue.
	GuitarString(double[] init) {
		buffer = new LinkedList<Double>();
		if(init.length < 2) {
			throw new IllegalArgumentException();
		} else {		
		for(double x : init) {
			buffer.add(x);
			}
		}
	}
	
	// changes the values given from the array to values +- 0.5.
	public void pluck() {
		Random rand = new Random();
		for(int i = 0; i < buffer.size(); i++) {
			double vibration = rand.nextDouble() - 0.5;
			buffer.remove();
			buffer.add(vibration);			
		}
	}
	
	// applies the karplus-alogorithm to the queue.
	public void tic() {
				double x1 = buffer.peek();
				buffer.remove();
				double x2 = buffer.peek();
				buffer.add(DECAY * 0.5 * (x1 + x2));
	}
	
	// returns the top of the queue.
	public double sample() {
		return buffer.peek();
	}
}
