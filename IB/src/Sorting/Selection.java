package Sorting;

public class Selection {
	public static void main(String[] args)
	{
		Selection s1 = new Selection();
	
	}
	
	public Selection()
	{
		int[] arrayNums = {66, 13, 7, 67, 24, 113, 6, 89, 27, 38};
		//int[] arrayNums = {6,7,13,24,27,38,66,67,89,113};
		printArray(arrayNums);
		arrayNums = sort(arrayNums);
		
		printArray(arrayNums);
	}
	
	
	public void printArray(int[] array)
	{
		System.out.println("Current array state:");
		for(int x = 0; x< array.length; x++)
		{
			System.out.print(array[x] + ", ");
		}
		System.out.print("\n");
	}
	
	public int[] sort(int[] array) {
		int n = array.length;
		int temp = 0;
		int minPos = 0;
		
		for (int i = 0; i < n-1; i++) {
			minPos = i;
			for (int x = i+1; x < n; x++) {
				if (array[x] < array[minPos]) {
					minPos = x;
				}
			}
			temp = array[i];
			array[i] = array[minPos];
			array[minPos] = temp;
		}
		return array;
	}
}
