

// Completed by Phil "Vnilabean"
public class DoublingDynamicArray {

	private String[] data; // the backing array
	private int virtualArrayLength; // the number of elements in the dynamic array

	/**
	 * Creates an empty dynamic array with room to grow. 
	 */
	public DoublingDynamicArray() {
		// Start with a few available spaces.
		data = new String[8];
		// But the virtual array is empty.
		virtualArrayLength = 0;
	}

	/**
	 * Returns the number of elements in the dynamic array.
	 * 
	 * @return the number of elements
	 */
	public int size() {
		return virtualArrayLength;
	}

	/**
	 * adds a string to end of array
	 * 
	 * @param s
	 */
	public void add(String s) {
		add(this.size(), s);

	}

	/**
	 * Adds a item to the array using index location given. Throws exeption if out
	 * of bounds
	 * 
	 * @param i index location
	 * @param s String to be added to array
	 */
	public void add(int i, String s) {

		if (i < 0 || i > this.size()) {
			throw new IndexOutOfBoundsException("index is out of array paramaters");
		}
		if (this.size() >= data.length) {
			String[] newData = new String[data.length * 2];
			for (int j = 0; j < this.size(); j++) {
				newData[j] = data[j];

			}
			data = newData;

		}

		for (int j = this.size(); j > i; j--) {
			data[j] = data[j - 1];
		}
		data[i] = s;
		virtualArrayLength++;

	}

	/**
	 * removes the item i the given index location of the array. throws if index is
	 * out of range
	 * 
	 * @param i index location
	 */
	public void remove(int i) {

		if (i < 0 || i > this.size()) {
			throw new IndexOutOfBoundsException("index is out of array paramaters");
		}

		data[i] = null;
		for (int j = i; j < this.size(); j++) {
			data[j] = data[j + 1];
		}
		virtualArrayLength--;
	}

	/**
	 * Acquires the given index and returns the value at the location
	 * 
	 * @param i index
	 * @return value at given index
	 */
	public String get(int i) {

		if (i < 0 || i >= this.size()) {
			throw new IndexOutOfBoundsException("index is out of array paramaters");
		}
		String indexItem = data[i];
		return indexItem;

	}

	/**
	 * sets given index to given parameter string
	 * 
	 * @param i index
	 * @param s sting to replace index
	 */
	public void set(int i, String s) {
		if (i < 0 || i >= this.size()) {
			throw new IndexOutOfBoundsException("index is out of array paramaters");
		}
		data[i] = s;
	}

	/**
	 * Returns a formatted string version of this dynamic array.
	 * 
	 * @return the formatted string
	 */
	public String toString() {
		String result = "[";
		if (size() > 0)
			result += get(0);

		for (int i = 1; i < size(); i++)
			result += ", " + get(i);

		return result + "] backing size: " + data.length;
	}
}
