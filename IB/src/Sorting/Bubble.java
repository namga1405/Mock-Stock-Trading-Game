package Sorting;

import java.util.ArrayList;

public class Bubble {

	public static void main(String[] args) {
		Bubble s1 = new Bubble();

	}
	
	
	public Bubble()
	{
		int[] arrayNums = {7,6,1,98,23,56,4352,213};
		printArray(arrayNums);
		arrayNums = sortThis(arrayNums);
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
	
	public int[] sortThis(int[] array)
	{
        int n = array.length;
        int temp = 0;
        int search = 0;
        int sorting = 0;
        
     
        for (int x = 0; x<n; x++)
        {
        	for(int y = 0; y<(n-x)-1;y++)
        	{
        		if(array[y]>array[y+1])
        		{
        			// SWAP
        			temp = array[y];
        			array[y]=array[y+1];
        			array[y+1]=temp;
        			search++;
        			sorting++;
        		}
        	}
        	if (search == 0) {
    			System.out.println("This array has already been sorted");
    			break;
    		}
        }	
        System.out.println("Sorted " + sorting + " time(s)");
		return array;
	}

}
