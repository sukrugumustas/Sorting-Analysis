//150114032 Þükrü GÜMÜÞTAÞ
//150115066 Atakan ÜLGEN
public class QuickSortWithMedianOfThree {
	public static void main(String[] args) {
		
		//We are defining 9 different arrays with three different sizes so we can measure different values.
		int [] ascending100 = ArrayManaging.ascendingOrderArray(100);
		int [] descending100 = ArrayManaging.descendingOrderArray(100);
		int [] random100 = ArrayManaging.randomOrderArray(100);
		int [] ascending1000 = ArrayManaging.ascendingOrderArray(1000);
		int [] descending1000 = ArrayManaging.descendingOrderArray(1000);
		int [] random1000 = ArrayManaging.randomOrderArray(1000);
		int [] ascending10000 = ArrayManaging.ascendingOrderArray(10000);
		int [] descending10000 = ArrayManaging.descendingOrderArray(10000);
		int [] random10000 = ArrayManaging.randomOrderArray(10000);
		
		//Making the necessary operations on arrays.
		randomArrays(random100);
		ascendingArrays(ascending100);
		descendingArrays(descending100);
		
		randomArrays(random1000);
		ascendingArrays(ascending1000);
		descendingArrays(descending1000);
		
		randomArrays(random10000);
		ascendingArrays(ascending10000);
		descendingArrays(descending10000);
	}
	
	//quicksort algorithm with median-of-three pivot
	public static void quicksort (int [] a, int left, int right) {
		int size = right - left + 1;
		if (size<=3) {
			manualSort(a, left, right);
		} else {
			double median = medianOfThree(a, left, right);
			int partition = partition(a, left, right, median);
			quicksort(a, left, partition - 1);
			quicksort(a, partition + 1, right);
		}
	}
	
	//swapping values in array
	public static void swap (int [] a, int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}
	
	//If arrays have less sizes than 3, they will be manually sorted.
	public static void manualSort (int[]a, int left, int right) {
		int size = right - left + 1;
		if (size <= 1) {
			return;
		}
		if (size==2) {
			if (a[left]>a[right]) {
				swap(a, left, right);
			}
		} else {
			if (a[left]> a[right -1]) {
				swap(a, left, right - 1);
			}
			if (a[left]>a[right]) {
				swap(a, left, right);
			}
			if (a[right -1]>a[right]) {
				swap(a, right -1, right);
			}
		}
	}
	
	public static int partition (int [] a, int left, int right, double pivot) {
		int leftPtr = left;
		int rightPtr = right - 1;
		while(true) {
			while (a[++leftPtr]<pivot);
			while(a[--rightPtr]>pivot);
			if (leftPtr >= rightPtr) {
				break;
			} else {
				swap (a, leftPtr, rightPtr);
			}
		}
		swap(a, leftPtr, right - 1);
		return leftPtr;
	}
	
	//This method gives us the median-of-three pivot.
	public static int medianOfThree (int [] a, int left, int right) {
		int center = (left + right)/2;
		if (a[left]>a[center]) {
			swap(a, left, center);
		}
		if (a[left]>a[right]) {
			swap(a, left, right);
		}
		if (a[center]>a[right]) {
			swap(a, center, right);
		}
		swap(a, center, right - 1);
		return a[right -1];
	}
	
	//This is the method to do operations on random ordered arrays.
		public static void randomArrays (int [] a) {
			//Variables to estimate elapsed time
			long tStart, tEnd;
			System.out.println("\nThe random integer array with " + a.length + " elements:\n");
			//Printing the array
			ArrayManaging.printArray(a);
			tStart = System.nanoTime();
			//Sorting the array
			quicksort(a, 0, a.length - 1);
			tEnd = System.nanoTime();
			System.out.println("\n\nThe sorted list is: \n");
			//Printing the sorted array
			ArrayManaging.printArray(a);
			//Printing out the elapsed time
			System.out.println("\n\nThe sorting took " + (tEnd - tStart) + " nanoseconds.");
		}
		
		//This is the method to do operations on ascending ordered arrays.
		public static void ascendingArrays (int [] a) {
			//Variables to estimate elapsed time
			long tStart, tEnd;
			System.out.println("\nThe assending order integer array with " + a.length + " elements:\n");
			//Printing the array
			ArrayManaging.printArray(a);
			tStart = System.nanoTime();
			//Sorting the array
			quicksort(a, 0, a.length - 1);
			tEnd = System.nanoTime();
			System.out.println("\n\nThe sorted list is: \n");
			//Printing the sorted array
			ArrayManaging.printArray(a);
			//Printing out the elapsed time
			System.out.println("\n\nThe sorting took " + (tEnd - tStart) + " nanoseconds.");
		}
		
		//This is the method to do operations on descending ordered arrays.
		public static void descendingArrays (int [] a) {
			//Variables to estimate elapsed time
			long tStart, tEnd;
			System.out.println("\nThe descending order integer array with " + a.length + " elements:\n");
			//Printing the array
			ArrayManaging.printArray(a);
			tStart = System.nanoTime();
			//Sorting the array
			quicksort(a, 0, a.length - 1);
			tEnd = System.nanoTime();
			System.out.println("\n\nThe sorted list is: \n");
			//Printing the sorted array
			ArrayManaging.printArray(a);
			//Printing out the elapsed time
			System.out.println("\n\nThe sorting took " + (tEnd - tStart) + " nanoseconds.");
		}
}
