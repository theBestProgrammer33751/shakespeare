package Shakespeare;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Runner {

	

	public static void main(String[] args) {
		try {
			File myFile = new File("Shakespeare Work.txt");
			Scanner myScanner = new Scanner(myFile);
			
			HashMap<String, HashMap<String, Integer>> artWords = new HashMap();
			
			
			ArrayList<String> storage = new ArrayList<String>();
			
			while(myScanner.hasNext()) {
				String curr = myScanner.next();
				myScanner.useDelimiter(",");
				storage.add(curr);
				
			}
			for(int i = 0; i < storage.size(); i++) {
				String wordOne = storage.get(i);
				String wordTwo = storage.get(i+1);
				HashMap<String, Integer> nextWord = new HashMap(); 
				
				if(artWords.containsKey(wordOne)) {
					nextWord = artWords.get(wordOne);
					if(nextWord.containsKey(wordTwo)) {
						int temp = nextWord.get(wordTwo);
						temp++;
						nextWord.put(wordTwo, temp);
					}else {
						nextWord.put(wordTwo, 1);
					}
					artWords.put(wordOne, nextWord);
				}else {
					nextWord.put(wordTwo, 1);
					artWords.put(wordOne, nextWord);
				}
				
			}
			
			System.out.println(artWords.get("the"));
			
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
	}
	
}
