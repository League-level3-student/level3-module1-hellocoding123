package _00_Intro_To_ArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
    public static void main(String[] args) {
        // 1. Create an array list of Strings
        //    Don't forget to import the ArrayList class
    	ArrayList<String> arr= new ArrayList<>();
        // 2. Add five Strings to your list
    	for(int i = 0; i < 5; i++) {
    		arr.add("bob" + (i + 1));
    	}
        // 3. Print all the Strings using a standard for-loop
    	for(int i = 0; i < arr.size(); i++) {
    		System.out.println(arr.get(i));
    	}
    	System.out.println("");
        // 4. Print all the Strings using a for-each loop
    	for(String r : arr) {
    		System.out.println(r);
    	}
    	System.out.println("");
        // 5. Print only the even numbered elements in the list.
    	for(int i = 0; i < arr.size(); i++) {
    		if((i+1)%2 == 0) {
    			System.out.println(arr.get(i));
    		}
    	}
    	System.out.println("");
        // 6. Print all the Strings in reverse order.
    	for(int i = arr.size()-1; i >= 0; i--) {
    		System.out.println(arr.get(i));
    	}
    	System.out.println("");
        // 7. Print only the Strings that have the letter 'e' in them.
    	arr.set(0, "bobette1");
    	arr.set(4, "bobette5");
    	
    	for(int i = 0; i < arr.size(); i++) {
    		if(arr.get(i).contains("e")) {
    			System.out.println(arr.get(i));
    		}
    	}
        
    }
}
