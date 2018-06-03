//150114032 Þükrü GÜMÜÞTAÞ
//150115066 Atakan ÜLGEN
public class QuickSortMain {
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
	
	//This is a normal quicksort method.
	public static void quickSort(int sayilar[],int p, int r) {
		int q;
		if(p<r) {
			q = partition(sayilar, p, r);
			quickSort(sayilar, p, q-1);
			quickSort(sayilar, q+1, r);
		}
	}
	
	
	public static int partition(int array[], int p, int r){
		int x = array[r];
		int i = p-1;
		for (int j=p; j<=r-1; j++) {
			if(array[j]<=x) {
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i+1, r);
		return i+1;
	}
	
	//This is method for swapping two values in an array.
	public static void swap (int [] a, int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
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
		quickSort(a, 0, a.length - 1);
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
		quickSort(a, 0, a.length - 1);
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
		quickSort(a, 0, a.length - 1);
		tEnd = System.nanoTime();
		System.out.println("\n\nThe sorted list is: \n");
		//Printing the sorted array
		ArrayManaging.printArray(a);
		//Printing out the elapsed time
		System.out.println("\n\nThe sorting took " + (tEnd - tStart) + " nanoseconds.");
	}
}