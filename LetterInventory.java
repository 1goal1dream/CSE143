// Thomas You
// CSE143
// 5/1/17
// Assignment 1

public class LetterInventory {
	public static final int MAX = 26;
	
	private String data;
	private int[] countInventory;
	private int size;
	
	// initialization
	public LetterInventory(String data) {
		this.data = data.toLowerCase();
		countInventory = new int[MAX];
		for(int i = 0; i < data.length(); i++) {
			if(this.data.charAt(i) >= 97 && this.data.charAt(i) <= 122) {
			countInventory[this.data.charAt(i)- 'a']++;
			size++;
			}		
		}
	}
	
	// returns a number of how many of a given letter is in the LetterInventory. Throws IllegalArgumentException if
	// a non alphabetic character is passed.
	public int get(char letter) {
		char x = Character.toLowerCase(letter);
			if(x - 'a' < -1 || x - 'a' > MAX) {
				throw new IllegalArgumentException();
			}
			return countInventory[x - 'a'];
	}
	
	// sets a given letter to a a number that the user wants in the LetterInventory. Throws IllegalArgumentException if 
	// value is less than 0 or if a non alphabetic character is passed.
	public void set(char letter, int value) {
		char x = Character.toLowerCase(letter);
		if(value < 0 || x - 'a' < -1 || x - 'a' > MAX) {
			throw new IllegalArgumentException();
		}
		if(value == 0) {
			size = size - countInventory[x - 'a'];
		} else {
			size = size + value;
		}
		countInventory[x - 'a'] = value;
	}
	
	// returns the size of the LetterInventory.
	public int size() {
		return size;
	}
	
	// returns false if the LetterInventory is not empty. True if it is.
	public boolean isEmpty() {
		return (size == 0);
	}
	
	// returns the specified format of the array.
	public String toString() {
		String s = "[";
		for(int i = 0; i  < MAX; i++) {
			for(int j = 0; j < countInventory[i]; j++ ) {
				s = s + (char) ('a' + i);
			}
		}
		s = s + "]";
		return s;
	}
	
	// returns the combination of two letterInventory added together.
	public LetterInventory add(LetterInventory other) {
		LetterInventory combine = new LetterInventory("");
			for(int i = 0; i < MAX; i++) {
			combine.countInventory[i] =	this.countInventory[i] + other.countInventory[i];
			combine.size = this.size + other.size;
			}
			return combine;
	}
	
	// returns the combination of two LetterInventory subtracted from each other. Returns null if there is less than 0 letters after subtracting
	// from one LetterInventory to the other.
	public LetterInventory subtract(LetterInventory other) {
		LetterInventory combine = new LetterInventory("");
		for(int i = 0; i < MAX; i++) {
			if(countInventory[i] - other.countInventory[i] < 0) {
				return null;
			} else {
				combine.countInventory[i] = countInventory[i] - other.countInventory[i];
				combine.size += combine.countInventory[i];
			}			
		}	
		return combine;
	}
}

