package lab8_map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "src/data/fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	// Load data from fileName into the above map (containing <word, its occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));
		
		while(input.hasNext()) {
			String word = input.next();
			
			map.put(word, map.getOrDefault(word, 0) +1);
		}
		System.out.println(map);
	}

	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countUnique() {
		int index = 0;
		for (Entry<String, Integer> s : map.entrySet()) {
			if (s.getValue()==1) {
				index++;
			}
		}
		return index;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		// TODO
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
	Map<String , Integer> m = new TreeMap<String, Integer>();
	m.putAll(map);
	System.out.println(m);
	}
	public static void main(String[] args)  {
		MyWordCountApp m = new MyWordCountApp ();
		try {
			m.loadData();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Number of unique tokens: " + m.countUnique());
		
		m.printWordCountsAlphabet();	
	}
}
