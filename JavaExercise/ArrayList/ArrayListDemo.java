package JavaExercise.ArrayList;

import java.util.ArrayList;
import java.util.Collections;

/** TO DO: 
* 0. Write a Java class with main method consist of:
* 1. create a new array list, add some colors (string) and print out the collection
* 2. iterate through all elements in a array list
* 3. insert an element into the array list at the first position
* 4. retrieve an element (at a specified index) from a given array list
* 5. update specific array element by given element
* 6. remove the third element from a array list
* 7. search an element in a array list
* 8. sort a given array list
* 9. copy one array list into another
* 10. reverse elements in a array list
* 11. compare two array lists
* 12. empty an array list
* 13. test an array list is empty or not
* 14. increase the size of an array list
* 15. trim the capacity of an array list the current list size
*/

public class ArrayListDemo  {
    public static void main(String[] args) {
        // 1. create a new array list, add some colors (string) and print out the collection
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Pink");
        colors.add("Violet");
        colors.add("White");
        System.out.println("List: " + colors);

        // 2. iterate through all elements in a array list
        System.out.println("Iterating through list:");
        for (String color : colors) {
            System.out.println(color);
        }

        // 3. insert an element into the array list at the first position
        colors.add(0, "Purple");
        System.out.println("After adding 'Purple' at first position: " + colors);

        // 4. retrieve an element (at a specified index) from a given array list
        String elementAt2 = colors.get(1);
        System.out.println("Element at index 1(this is the position 2): " + elementAt2);

        // 5. update specific array element by given element
        colors.set(2, "Blue");
        System.out.println("After updating element at index 2 to 'Blue': " + colors);

        // 6. remove the third element from a array list
        colors.remove(2);
        System.out.println("After removing element at index 2(this is the third element): " + colors);

        // 7. search an element in a array list
        String searchColor = "Green";
        boolean found = colors.contains(searchColor);
        System.out.println("List contains '" + searchColor + "': " + found);

        searchColor = "Red";
        found = colors.contains(searchColor);
        System.out.println("List contains '" + searchColor + "': " + found);

        // 8. sort a given array list
        Collections.sort(colors);
        System.out.println("Sorted list: " + colors);

        // 9. copy one array list into another
        ArrayList<String> copiedColors = new ArrayList<>(colors);
        System.out.println("Copied list: " + copiedColors);

        // 10. reverse elements in a array list
        Collections.reverse(colors);
        System.out.println("Reversed list: " + colors);

        // 11. compare two array lists
        boolean isEqual = colors.equals(copiedColors);
        System.out.println("Are the original and copied lists equal? " + isEqual);

        // 12. empty an array list
        colors.clear();
        System.out.println("List after clearing: " + colors);

        // 13. test an array list is empty or not
        boolean isEmpty = colors.isEmpty();
        System.out.println("Is the list empty? " + isEmpty);

        // 14. increase the size of an array list
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        System.out.println("List after adding more elements: " + colors);

        // 15. trim the capacity of an array list the current list size
        colors.trimToSize();
        System.out.println("List after trimming capacity: " + colors);
    }
}


