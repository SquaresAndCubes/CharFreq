import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CharFreqMain {

	public static void main(String[] args) {
		
		//declare variables and object types
		Scanner in_data = null;
		ArrayList<CharacterFrequency> charObjectsArray = new ArrayList<CharacterFrequency>();
		CharacterFrequency newcharobj;
		
		//try to open file and if not found catch file not found exception and exit
		try {
			//create scanner object of text file
			in_data = new Scanner(new File("C:/text.txt"),"utf-8");
			
			while (in_data.hasNext()) {
				
				//iterate through each line in text file and save to character array
				char[] line = in_data.nextLine().toCharArray();
				
				//iterate through lines and characters
				for (Character char1 : line) {
					//verify if characters are valid unicode
					if (Character.isDefined(char1)) {
						//create new CharacterFrequency object
						newcharobj = new CharacterFrequency();
						//set object variables
						newcharobj.setCharacter(char1);
						newcharobj.setFrequency(1);
						//save object to array list charObjs
						charObjectsArray.add(newcharobj);

					}
				}
			}
		}
		
		//code speaks for itself
		catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			System.exit(0);
		}
		finally {
			
			//iterate through objects in charObjs Array and print characters and freqs to console
			for (CharacterFrequency charObject : charObjectsArray) {
				System.out.println(charObject.getCharacter());
				System.out.println(charObject.getFrequency());
			}
			
			if (in_data != null){
				
			//close scanner object
			in_data.close();
			}
		}
	}
}
