package mergesort;

import java.util.Random;

/**
 *
 * @author klaus
 */
public class MergeSort_incomplete {

    // Merge (sorted) ranges values[first]...values[mid] and values[mid+1]...values[last]
    private static void mergeRanges(int[] values, int first, int mid, int last){
        int leftsize=mid-first+1;
        int rightsize=last-mid;
        // TO DO: implement the merge function
        int[] left=new int[leftsize];
        int[]right=new int[rightsize];

        //copy data to temporary arrays
        for(int i=0;i<leftsize;i++){
            left[i]=values[first+i];

        }
        for(int i=0;i<rightsize;i++){
            right[i]=values[mid+i];
        }

        //merging the temporary arrays back into values[first...last]
        int i=0,j=0,k=first;

        while(i<leftsize && j<rightsize){
            
        }

    }


    // Auxiliary recursive function
    // Sorts the range values[firstindex]...values[lastindex]
    private static void sortRange(int[] values, int firstindex, int lastindex){
        if(lastindex > firstindex){    // Otherwise there is nothing to do (single value)
            int midindex = (firstindex + lastindex) / 2;
            sortRange(values, firstindex, midindex);      // Recursively sort firstindex half
            sortRange(values, midindex + 1, lastindex);   // Recursively sort second half
            mergeRanges(values, firstindex, midindex, lastindex); // Merge sorted halves
        }
    }

    public static void sort(int[] values){
        sortRange(values, 0, values.length - 1);
    }
    
    public static int[] randomValues(int howMany){
        int[] result = new int[howMany];
        Random random = new Random();
        for(int i=0; i<howMany; i++)
           result[i] = random.nextInt() % (10 * howMany);
        return result;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // How many values to generate
        int numValues = 30; 
        // Whether to print results. Only use with small numbers of values.
        boolean printResults = true; 
        
        
        int[] a = randomValues(numValues);
        if(printResults){
            System.out.print("Before sorting: ");
            for(int i=0;i<numValues; i++)
                System.out.print(a[i] + " ");
            System.out.println();
        }
        long start = System.currentTimeMillis();
        sort(a);
        long now = System.currentTimeMillis();
        double elapsed = (now - start) / 1000.0;
        if(printResults){
            System.out.print("After sorting: ");
            for(int i=0;i<numValues; i++)
                System.out.print(a[i] + " ");
            System.out.println();
        }
    	System.out.println();
        System.out.println("Elapsed time = " + elapsed + " seconds");    
    }    
}
