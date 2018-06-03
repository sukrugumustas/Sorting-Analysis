//150114032 Þükrü GÜMÜÞTAÞ
//150115066 Atakan ÜLGEN
public class IterativeQuickSort {
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
	
	//This is nonrecursive quicksort algorithm.
	public static void quicksort (int [] a, int left, int right) {
		// create auxiliary stack
		int stack[] = new int[right - left + 1];
		// initialize top of stack
		int top = -1;
		// push initial values in the stack
		stack[++top] = left;
		stack[++top] = right;
		// keep popping elements until stack is not empty
		while (top>=0) {
			//pop right and left
			right = stack[top--];
			left = stack[top--];
			// set pivot element at it's proper position
			int p = QuickSortMain.partition(a, left, right);
			// If there are elements on left side of pivot,
            // then push left side to stack
			if (p - 1 > left) {
				stack[++top] = left;
				stack[++top] = p - 1;
			}
			// If there are elements on right side of pivot,
            // then push right side to stack
			if (p+1 < right) {
				stack[++top] = p + 1;
				stack[++top] = right;
			}
		}
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
