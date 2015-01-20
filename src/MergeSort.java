
public class MergeSort {

	private int[] theArray = new int[50];
	private int[] tempMergArray = new int[50];
	
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
	
	public void mergeSort() {
		printArray();
		doMergeSort(0, arraySize - 1);
		//printArray();
	}
	
	private void doMergeSort(int lowerIndex, int higherIndex) {
		
		if(lowerIndex < higherIndex) {
			
			//get middle value (max-min/2) + min
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			
			//split list
			doMergeSort(lowerIndex, middle);
			doMergeSort(middle+1, higherIndex);
			
			mergeParts(lowerIndex, middle, higherIndex);
		}
		
	}

	private void mergeParts(int lowerIndex, int middle, int higherIndex) {
	
		System.out.println("lower: "+lowerIndex+" middle:"+middle+" higher:"+higherIndex);
		
		
		for(int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArray[i] = theArray[i];
		}
		
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		
		while(i <= middle && j <= higherIndex) {
			
			System.out.println("i: "+i+" j:"+j+" k:"+k);
			
			if(tempMergArray[i] <= tempMergArray[j]) {
				theArray[k] = tempMergArray[i];
				i++;
			} else {
				theArray[k] = tempMergArray[j];
				j++;
			}
			k++;
		}
		while( i <= middle) {
			theArray[k] = tempMergArray[i];
			k++;
			i++;
		}
		
	}
}
