
import java.util.ArrayList;

//Code Source that I based my implementation on:
//http://www.codexpedia.com/java/java-merge-sort-implementation/
public class MergeSort {
 
    private ArrayList <NamesandNumbers> _namesandnumbers;
    public static ArrayList <NamesandNumbers> output;
    
        
        
    public ArrayList<NamesandNumbers> values()
    {
    	return _namesandnumbers;
    }
   
    public MergeSort(ArrayList<NamesandNumbers> namesandnumbers) {
        _namesandnumbers = namesandnumbers;
    }
     
    public void sort() {
    	_namesandnumbers = mergeSort(_namesandnumbers);
    }
 
    public ArrayList<NamesandNumbers> mergeSort(ArrayList<NamesandNumbers> whole) {
        ArrayList<NamesandNumbers> left = new ArrayList<NamesandNumbers>();
        ArrayList<NamesandNumbers> right = new ArrayList<NamesandNumbers>();
        int center;
 
        if (whole.size() == 1) {    
            return whole;
        } else {
            center = whole.size()/2;
            // copy the left half of whole into the left.
            for (int i=0; i<center; i++) {
                    left.add(whole.get(i));
            }
 
            //copy the right half of whole into the new arraylist.
            for (int i=center; i<whole.size(); i++) {
                    right.add(whole.get(i));
            }
 
            // Sort the left and right halves of the arraylist.
            left  = mergeSort(left);
            right = mergeSort(right);
 
            // Merge the results back together.
            merge(left, right, whole);
        }
        
        return whole;
    }
 
    private void merge(ArrayList<NamesandNumbers> left, ArrayList<NamesandNumbers> right, ArrayList<NamesandNumbers> whole) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;
 
        // As long as neither the left nor the right ArrayList has
        // been used up, keep taking the smaller of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if ( ((left.get(leftIndex).name()).compareTo(right.get(rightIndex).name())) < 0) {
                whole.set(wholeIndex, left.get(leftIndex));
                leftIndex++;
            } else {
                whole.set(wholeIndex, right.get(rightIndex));
                rightIndex++;
            }
            wholeIndex++;
        }
 
        ArrayList<NamesandNumbers> rest;
        int restIndex;
        if (leftIndex >= left.size()) {
            // The left ArrayList has been use up...
            rest = right;
            restIndex = rightIndex;
        } else {
            // The right ArrayList has been used up...
            rest = left;
            restIndex = leftIndex;
        }
 
        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (int i=restIndex; i<rest.size(); i++) {
            whole.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
    }}
 
  