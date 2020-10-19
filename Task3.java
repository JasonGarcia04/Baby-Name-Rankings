import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Task3 {
	
	public static void main(String[] args) throws FileNotFoundException {
		//C:\\Users\\bigjg\\Downloads\\babynamesranking2001.txt
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter File Name: ");
		String fileName = input.nextLine();
		
		System.out.println("Enter the gender(M or F): ");
		String gender = input.nextLine();
			
		System.out.println("Enter beginning character(s) of names you wish to search: ");
		String name = input.nextLine();
		
		File file = new File(fileName);
		Map<String, String> boyMap = new HashMap<String, String>();
		Map<String, String> girlMap = new HashMap<String, String>();
		ArrayList<String> boyList = new ArrayList<String>();
		ArrayList<String> girlList = new ArrayList<String>();
		Scanner read = new Scanner(file);	
		String rank = null;
		String key1 = null;
		String key2 = null;
		while(read.hasNext()) {
			String line = read.nextLine();
			String[] words = line.split("\\s+");
				 	
			key1 = words[1]; //boy name
			key2 = words[3]; //girl name
			rank = words[0];
				
			boyMap.put(key1, rank);
			girlMap.put(key2, rank);
			
			if(gender.equalsIgnoreCase("M") && words[1].startsWith(name)) {
				words[1].equals(name);
				boyList.add(words[1]);
			}
			else if(gender.equalsIgnoreCase("F") && words[3].startsWith(name)){
				words[3].equals(name);
				girlList.add(words[3]);
			}
			
				
		}
		for(int i = 0; i < boyList.size(); i++) {
			System.out.println(boyList.get(i) + " rank " + boyMap.get(boyList.get(i)));
		}
		for(int i = 0; i < girlList.size(); i++) {
			System.out.println(girlList.get(i) + " rank " + girlMap.get(girlList.get(i)));
		}
		
	}
	
	
}
