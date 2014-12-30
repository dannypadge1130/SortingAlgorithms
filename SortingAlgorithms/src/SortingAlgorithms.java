/* 
 * Code taken from Derek Banas @ http://www.newthinktank.com/
 * Purpose: Taken for sorting algorithm practice.
 * 
 */

public class SortingAlgorithms {
		
	
	private int[] theArray = new int[50];
	
	private int arraySize = 10;
	
	public void generateRandomArray(){
		
		for(int i = 0; i < arraySize; i++){
			
			theArray[i] = (int)(Math.random()*10)+10;
			
		}
		
	}
	
	public void printArray(){
		
		System.out.println("----------");
		for(int i = 0; i < arraySize; i++){
			
			System.out.print("| " + i + " | ");
			System.out.println(theArray[i] + " |");
			
			System.out.println("----------");
			
		}
		
	}
	
	public void printHorzArray(int i, int j){
		
		for(int n = 0; n < 51; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < arraySize; n++){
			
			System.out.print("| " + n + "  ");
			
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 51; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < arraySize; n++){
			
			System.out.print("| " + theArray[n] + " ");
			
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 51; n++)System.out.print("-");
		
		System.out.println();
		
		// END OF FIRST PART
		
		
		// ADDED FOR BUBBLE SORT
		
		if(j != -1){
		
			// ADD THE +2 TO FIX SPACING
			
			for(int k = 0; k < ((j*5)+2); k++)System.out.print(" ");
			
			System.out.print(j);
			
		}
		
		
		// THEN ADD THIS CODE
		
		if(i != -1){
			
			// ADD THE -1 TO FIX SPACING
			
			for(int l = 0; l < (5*(i - j)-1); l++)System.out.print(" ");
			
			System.out.print(i);
			
		}
		
		System.out.println();
		
	}
	
	//bubble sort (Worst Case is n^2)
	public void bubbleSort() {
		
		for(int i = arraySize -1; i > 1; i--) {
			
			for(int j = 0; j<i; j++) {
			
				if(theArray[j] > theArray[j+1]) {
					swapValues(j, j+1);
				} 
				
				printHorzArray(i, j);
			}
			
		}
		
	}
	
	//selection sort (Worst Case n^2)
	public void selectionSort() {
		
		for(int i = 0; i < arraySize; i++) {
			
			int min = i;
			
			for(int j = i; j < arraySize; j++) {
				
				if(theArray[min] > theArray[j]) {
					min = j;
				}
				
			}
			
			swapValues(i, min);
			
			printHorzArray(i, -1);
			
		}
		
	}
	
	//insertion sort (Worst Case n^2)
	public void insertionSort() {
		
		for(int i = 1; i < arraySize; i++) {
			int j = i;
			
			int toInsert = theArray[i];
			
			while((j > 0) && (theArray[j-1] > toInsert)) {
				theArray[j] = theArray[j-1];
				j--;
				
				printHorzArray(i, j);
			}
			
			theArray[j] = toInsert;
			
			printHorzArray(i, j);
			
			System.out.println("\nArray[i]="+theArray[i] + " Array[j]="+theArray[j] + " toInsert="+toInsert);
		}
		
	}
	
	public void swapValues(int indexOne, int indexTwo) {
		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;	
	}
	
	public static void main(String[] args){
		
		SortingAlgorithms newArray = new SortingAlgorithms();
		
		newArray.generateRandomArray();
		
		//newArray.printHorzArray(-1,-1);
		
		//newArray.bubbleSort();
		
		//newArray.selectionSort();
		
		//newArray.insertionSort();
		
		MergeSort ms = new MergeSort();
		ms.generateRandomArray();
		ms.mergeSort();
	}
}