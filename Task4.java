import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Task4 {

	public static void main(String[] args) throws FileNotFoundException {
		// C:\\Users\\bigjg\\Downloads\\babynamesranking2001.txt
		Scanner input = new Scanner(System.in);
		Random rand = new Random();

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
		while (read.hasNext()) {
			String line = read.nextLine();
			String[] words = line.split("\\s+");

			key1 = words[1]; // boy name
			key2 = words[3]; // girl name
			rank = words[0];

			boyMap.put(key1, rank);
			girlMap.put(key2, rank);

			if (gender.equalsIgnoreCase("M") && words[1].startsWith(name)) {
				words[1].equals(name);
				boyList.add(words[1]);

			} else if (gender.equalsIgnoreCase("F") && words[3].startsWith(name)) {
				words[3].equals(name);
				girlList.add(words[3]);
			}

		}

		if (gender.equalsIgnoreCase("M")) {
			int boyRandomNumber = rand.nextInt(boyList.size());
			System.out.println(boyList.get(boyRandomNumber) + " rank " + boyMap.get(boyList.get(boyRandomNumber)));
		} else {
			int girlRandomNumber = rand.nextInt(girlList.size());
			System.out.println(girlList.get(girlRandomNumber) + " rank " + girlMap.get(girlList.get(girlRandomNumber)));
		}

	}

}
