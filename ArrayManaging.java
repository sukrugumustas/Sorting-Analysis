//150114032 Þükrü GÜMÜÞTAÞ
//150115066 Atakan ÜLGEN
import java.util.Arrays;
import java.util.Random;
public class ArrayManaging {
	
	//This method creates ascending ordered integer array with randomOrderArray method.
	public static int [] ascendingOrderArray (int a) {
		int [] array = randomOrderArray(a);
		//We are creating a random order array and sorting them with java.util.Arrays.sort method.
		Arrays.sort(array);
		return array;
	}
	
	//This method creates an integer array with descending order via ascendingOrderArray method.
	public static int [] descendingOrderArray (int a) {
		int [] array = ascendingOrderArray(a);
		int temp;
		//This loop reversing our ascending order array actually.
		for (int i = 0; i < array.length/2; ++i) { 
			  temp = array[i];
			  array[i] = array[array.length - i - 1];
			  array[array.length - i - 1] = temp;
		}
		return array;
	}
	
	//This method creates an integer array with random order.
	public static int [] randomOrderArray (int a) {
		Random creator = new Random();
		//We define the size of array with a.
		int [] array = new int[a];
		for (int i = 0; i<a; i++) {
			//We are assigning values less than 1000 to every index of array.
			array[i] = creator.nextInt(1000);
		}
		return array;
	}
	
	//This method prints the array.
	public static void printArray (int [] a) {
		for(int i = 0; i<a.length; i++) {
			System.out.print(a[i]+" ");
			if (i!=0 && i%50== 0) {
				System.out.println();
			}
		}
	}
}
