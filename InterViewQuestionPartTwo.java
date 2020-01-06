package commonUtilityPackage;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class InterViewQuestionPartTwo {
	
	// STATIC BLOCK ARE EXECUTED BEFORE EVEN CONSTRUCTOR.
	// STATIC VARIABLE ARE LOADED INTO THE MEMORY, FIRST
	// STATIC BLOCK ARE LOADED INTO THE MEMORY, SECOND
	// INSTANCE VARIABLE ARE LOADED INTO THE MEMORY, THIRD
	// INSTANCE BLOCK ARE LOADED INTO THE MEMORY, FOURTH
	// CONSTRUCTOR IS LOADED INTO THE MEMORY, FIFTH
	
	int k = 10;
	
	static {
		System.out.println("Calling static block");
	}

	{
		System.out.println("Calling Instance block");
	}
	
	/**
	PRIVATE CONSTRUCTOR CAN BE CALLED IN SIGNLETRON CLASS
	**/
	private InterViewQuestionPartTwo(){
		System.out.println("Calling Private constructor of InterViewQuestionPartTwo");
	}
	
	public InterViewQuestionPartTwo(int x){
		System.out.println("Calling Private constructor of InterViewQuestionPartTwo");
	}
	
	/**
	Static Method cannot be overRidden
	**/
	protected static void staticMethodCannotbeOverRidden(){
		System.out.println("Check One - staticMethodCannotbeOverRidden");
	}

	/**
	-ABSTRACT & FINAL CAN BE DIFINED TO THE CLASS.
	-STATIC CLASS CAN BE USED IN INNER CLASS. IT ALWAYS BEHAVES LIKE A VARIABLE/METHOD TO THE OUTSIDE CLASS.
	-
	**/
	static class InnerClassStatic {
		static int a = 10;
		static void intvlaue() {
			System.out.println("Executing static inner class");
		}
	}
	
	public class InnerClassPublic {
		int innerVariable = 10;
		int getOutvalue = InterViewQuestionPartTwo.this.k;

		public void InnerNonStaticMethod() {
			System.out.println(getOutvalue);
		}
	}
	
	public void getKill() {
		System.out.println("This is getKill method");
	}
	
	protected void checkAcessSpeifierforProtected() {
		
	}
	
	//TODO: reverseInteger
	private <T>void reverseInteger(T t) {
		int number = (Integer) t;
		int reverseInteger = 0;
		int value = 0;
		
		while(number != 0) {
			reverseInteger = number % 10;
			value = value * 10 + reverseInteger;
			number = number / 10;
		}	
		System.out.println(value);
	}
	
	//TODO: removeDuplicateFromArray
	private <T>void removeDuplicateFromArray() {
		int[] array = { 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 3, 1, 4, 52, 1, 45, 55 };

		int[] result = new int[array.length];
		int j = 0, count = 0;

		for (int i : array) {
			if (!isExist(result, i)) {
				result[j++] = i;
				count++;
			}
		}

		System.out.println(count + "_____________");
		for (int i = 0; i < count; i++)
			System.out.println("\t \n"+result[i]);
	}
	
	private static boolean isExist(int[] result, int i) {
		for (int j : result) {
			if (j == i)
				return true;
		}
		return false;
	}
	
	//TODO: checkforRepeatedWords
	private void checkforRepeatedWords() {
		String tempValue = "This is Rajesh having This is Rajesh Rajesh Rajesh";
		String[] slipString = tempValue.split(" ");
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (String s : slipString) {
			if (map.containsKey(s))
				map.put(s, map.get(s) + 1);
			else
				map.put(s, 1);
		}

		for (int inc = 0; inc < map.size(); inc++)
			System.out.println(map.values().toArray()[inc] + " ::::" + map.keySet().toArray()[inc]);
	}
	
	private void checkFizzBuzz() {
	   for (int i = 1; i <= 100; i++) {
           boolean fizzOrBuzz = false;
           
           if (i % 3 == 0) {
               System.out.print("Fizz");
               fizzOrBuzz = true;
           }
           
           if (i % 5 == 0) {
               System.out.print("Buzz");
               fizzOrBuzz = true;
           }

           if (fizzOrBuzz) 
               System.out.println();
       }
    }
	
	public void testgetTwoHighestNumber() {
		int[] input = { 2, 3, 5, 6, 7, 99, 8, 10, 15, 17, 1 };
		int maxOne = 0;
		int maxTwo = 0;

		for (int n : input) {
			if (maxOne < n) {
				maxTwo = maxOne;
				maxOne = n;
			} else if (maxTwo < n) {
				maxTwo = n;
			}
		}
		System.out.println("First Max Number: " + maxOne);
		System.out.println("Second Max Number: " + maxTwo);
	}
	
	public void testBubbleSearch() {
		int[] input = { -2, 3, 4, 5, -6, 2, 3, 3, 3, 3, 5, 2 };
		int n = input.length;

		for (int c = 0; c < n; c++) {
			for (int d = 0; d < n - c - 1; d++) {
				if (input[d] > input[d + 1]) {/* For descending order use < */
					int swap = input[d];
					input[d] = input[d + 1];
					input[d + 1] = swap;
				}
			}
		}		
		for(int result : input)
		System.out.println("\t \n"+result);
	}
	
	public void fibnoiccSeries() {
		int max = 15;
		int fib1 = 1, fib2 = 1, fibonacci = 1;
		System.out.println("\n");
		for (int i = 3; i <= max; i++) {
			fibonacci = fib1 + fib2;
			System.out.println(fibonacci + "\t \t");
			fib1 = fib2;
			fib2 = fibonacci;
		}
	}

	private void testPrimeNumber() {
		int findPrimeNumber = 100;
		for (int i = 2; i < findPrimeNumber; i++) {
			if (isPrime(i))
				System.out.println("prime Number " + i);
		}
	}

	public boolean isPrime(int i) {
		for (int k = 2; k < i; k++) {
			if (i % k == 0) {
				return false;
			}
		}
		return true;
	}
	
	public void testArmStrong() {
		int textValue = 153;
		int tempTextValue = 0;

		while (textValue != 0) {
			tempTextValue = textValue % 10;
			tempTextValue = (int) (tempTextValue + Math.pow(tempTextValue, 3));
			textValue = textValue / 10;
		}

		if (textValue == tempTextValue) {
			System.out.println("The Given value is Armstrong" + tempTextValue);
		}
	}
	
	public void missingNumberInArray() {
		System.out.println(getMissingNumber(new int[]{1, 2, 3, 4, 6}, 6));
	}
	
	private static int getMissingNumber(int[] numbers, int totalCount) {
		int expectedSum = (totalCount * (totalCount+1))/ 2;
		int actualSum = 0;
		for (int i : numbers) {
			actualSum += i;
		}
		return expectedSum - actualSum;
	}
	
	//TODO: printStringReverse
	public void printStringReverse() {
		String value = "Rajesh";
		int valueInt = value.length();
		String tempValue = "";
		for (int i = valueInt - 1; i >= 0; i--) {
			tempValue = tempValue + value.charAt(i);
		}
		System.out.println(tempValue);
	}
	
	//TODO: printfirstNonRepeatedCharacter
	private void printfirstNonRepeatedCharacter() {
		String value = "stress";
		int valueInt = value.length();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < valueInt - 1; i++) {
			if (map.containsKey(value.charAt(i))) {
				map.put(value.charAt(i), map.get(value.charAt(i)) + 1);
			} else {
				map.put(value.charAt(i), 1);
			}
		}
		System.out.println("printfirstNonRepeatedCharacter for "+value);
		for (int i = 0; i < valueInt; i++) {
			char c = value.charAt(i);
			if (map.get(c) == 1) {
				System.out.println(c);
				break;
			}
		}
	}
	
	//TODO: GeneratePyramidExample
	private void GeneratePyramidExample() {
		int as = 10;
		int x = 1;
		int y = 0;

		for (int i = 0; i <= as; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(y + "\t");
				y = y + x;
			}
			System.out.println("");
		}
	}
	
	//TODO: Triangle
	public void Triangle() {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
				if (i != 1) {
					if (j == i) {
						for (int k = 0; k < (j - 1); k++) {
							System.out.print(j - (k + 1));
						}
					}
				}
			}
			System.out.println();
		}
	}
		
	
	
	private void printnumberZeroAndOne() {
		int a[] = {0,1,0,1,0,0,0};
		int getLenght = a.length;
		int[] temp = new int[getLenght];
		int j = getLenght -1;
		
		for(int i = 0; i < a.length; i++) {
			if(a[i] == 0) {
				temp[i] = a[i];
			} else if(a[i] == 1) {
				temp[j] = a[i];
				j--;
			}
		}
	}
		
	public void printCheckGenric(List<?> li) {
		for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i));
		}
	}
	
	public void printCheckGenricSuper(List<? super Double> li) {
		for (int i = 0; i < li.size(); i++) {
			System.out.println(li.get(i));
		}
	}
	
	/**
	- PRIVATE - WHEN YOU DEFINE AS PRIVATE, JVM DOES NOT EXECUTE THE SCRIPT
	**/
	 public static void main(String[] pp) {
		InterViewQuestionPartTwo itwo = new InterViewQuestionPartTwo();
		itwo.getKill();
		itwo.printStringReverse();
		//Calling Inner Class for non static
		InterViewQuestionPartTwo.InnerClassPublic inner = itwo.new InnerClassPublic();
		inner.InnerNonStaticMethod();
		//InnerClassStatic
		InnerClassStatic zero = new InterViewQuestionPartTwo.InnerClassStatic();
		InnerClassStatic.intvlaue();
		itwo.missingNumberInArray();
		itwo.printfirstNonRepeatedCharacter();
		System.out.println("Before Reverse "+123456);
		itwo.reverseInteger(123456);
		itwo.removeDuplicateFromArray();
		itwo.checkforRepeatedWords();
		itwo.checkFizzBuzz();
		itwo.testgetTwoHighestNumber();
		itwo.testBubbleSearch();
		itwo.fibnoiccSeries();
		itwo.testPrimeNumber();
		itwo.GeneratePyramidExample();
		itwo.printnumberZeroAndOne();
		itwo.Triangle();
		
		List<Double> li = new ArrayList<>();
		li.add(12.5);
		li.add(12.7);
		itwo.printCheckGenric(li);
		
		List<String> li2 = new ArrayList<>();
		li2.add("Using Wild Card Character");
		li2.add("Using Wild Card Character String One");
		itwo.printCheckGenric(li2);
		
	    li = new ArrayList<>();
		li.add(12.5);
		li.add(12.7);
		itwo.printCheckGenricSuper(li);
		
		ArrayList<?> checkWorking = new ArrayList<Number>();
		//ArrayList<?> checkWorkingOne = new ArrayList<?>();
		
		List<Number> liOne = new ArrayList<Number>();
		liOne.add(null);
		liOne.add(1);
		
	}
}

class InterViewQuestionPartTwoCheck extends InterViewQuestionPartTwo {
	
	private InterViewQuestionPartTwoCheck()  {
		super(5);
		System.out.println("Calling constroctor InterViewQuestionPartTwoCheck");
	}
	
	public void IntTwo() {
		System.out.println("Calling method IntTwo from class InterViewQuestionPartTwoCheck");
		staticMethodCannotbeOverRidden();		
	}
	
	/**
	Static Method cannot be overRidden
	**//*
	@Override
	private static void staticMethodCannotbeOverRidden(){
		System.out.println("Check Two - staticMethodCannotbeOverRidden");
	}*/
	
	/**
	- Public  - To call by JVM from any where
	- Static  - with-out existing object also
	- Void    - No return by JVM. Main Method does not return any-type
	- main    - Name is configured in JVM
	- String[]- Command Line argument
	**/
	public static void main(String[] pp) {
		InterViewQuestionPartTwoCheck itwoSecond = new InterViewQuestionPartTwoCheck();
		itwoSecond.IntTwo();
		final int i = 20;
		
		/**
		 System is a class
		 out - is an instance variable of PrintStream
		 println - println is a method for PrintStream.
		**/
		System.out.println(i);
		
		        //HashMap Example
				//1. HashMap is not Sync
				//2. HashMap Key - Will accept one null value, Value - Any Number of Null Values
				//3. Duplicate values are not allowed
				//4. Insertion is not preserved.
		        //5. Search operation is faster
				Map<Integer, String> hm = new HashMap<Integer, String>();
				hm.put(null, "Rajesh");
				hm.put(1, "RajeshSwetha");
				hm.put(4, null);
				hm.put(1, "RajeshDuplicateOne");
				hm.put(2, "RajeshTwo");
				hm.put(3, null);
				System.out.println("Example for HashMap");
				for(Entry<?, ?> verify : hm.entrySet())
					System.out.println(verify.getKey() +" :: "+ verify.getValue());
				
				//Hashtable Example
				//1. Hashtable is Sync
				//2. Hashtable Key - Will not accept any null value
				//3. Duplicate values are not allowed
				//4. Insertion is not preserved.
		        //5. Search operation is faster
				Map<Integer, String> ht = new Hashtable<Integer, String>();
				//ht.put(null, "Rajesh");
				ht.put(1, "RajeshSwetha");
				//ht.put(4, null);
				ht.put(1, "RajeshDuplicateOne");
				ht.put(2, "RajeshTwo");
				ht.put(3, "KekA");
				System.out.println("Example for Hashtable");
				for(Entry<?, ?> verify : ht.entrySet())
					System.out.println(verify.getKey() +" :: "+ verify.getValue());
				
				
				//HashSet Example
				//1. HashSet is not Sync
				//2. HashSet Will accept only one null value
				//3. Duplicate values are not allowed
				//4. Insertion is not preserved.
		        //5. Search operation is faster
				Set<String> hs = new HashSet<String>();
				hs.add(null);
				hs.add("RajeshSwetha");
				hs.add("RajeshSwetha");
				hs.add(null);
				hs.add("RajeshDuplicateOne");
				hs.add("RajeshTwo");
				hs.add("KekA");
				System.out.println("Example for HashSet");
				Iterator<?> it = hs.iterator();
				
				while(it.hasNext()) {
				System.out.println(it.next());
				it.remove();
				}
				
				
				//TreeSet Example
				//1. TreeSet is not Sync
				//2. TreeSet Will not accept null value
				//3. Duplicate values are not allowed
				//4. Insertion is not preserved.
		        //5. Search operation is faster
				Set<String> ts = new TreeSet<>();
				//ts.add(null);
				ts.add("RajeshSwetha");
				ts.add("RajeshSwetha");
				//ts.add(null);
				ts.add("RajeshDuplicateOne");
				ts.add("RajeshTwo");
				ts.add("KekA");
				System.out.println("Example for TreeSet");
				Iterator<?> itt = ts.iterator();
				
				while(itt.hasNext()) {
				System.out.println(itt.next());
				itt.remove();
				}
				
				
		// Vector example
	    // Vector is Sync
		// Other than Hashtable, Vector is the only other class which uses both Enumeration and Iterator
	    Vector<Object>  vec = new Vector<>();
		vec.add(null);
		vec.add("Rajesh");
		vec.add("Rajesh");
		vec.add(1, "testingOneIndex");
		System.out.println("Example for Vector using Iterator");
		Iterator<?> ittVec = vec.iterator();
		while (ittVec.hasNext()) {
			System.out.println(ittVec.next());
			ittVec.remove();
		}
		
		System.out.println("Example for Vector using Enumeration");
		Enumeration<Object> e = vec.elements();
		
		while(e.hasMoreElements()) {
		      System.out.println(e.nextElement());
		  }
		
		
		InterViewQuestionPartTwo obj = new InterViewQuestionPartTwo(10);
		obj.staticMethodCannotbeOverRidden();
	}
}
