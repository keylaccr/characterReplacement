package characterReplacement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		String characterToReplace = "&";
		String characterReplacement = "and";
		
		do {

			try {

				//Reading in location of file to be corrected
				System.out.println("Please enter the path of file to be corrected: ");

				BufferedReader reader = new BufferedReader(
						new InputStreamReader(System.in));

				String fileToCorrect = reader.readLine();	        

				//Creating scanner to read file
				Scanner scanner;
				scanner = new Scanner(new File(fileToCorrect));
				StringBuffer buffer = new StringBuffer();

				while (scanner.hasNextLine()) {
					buffer.append(scanner.nextLine()+System.lineSeparator());
				}

				String correctedFile = buffer.toString();
				System.out.println("Old content: "+System.lineSeparator()+correctedFile);

				scanner.close();

				//Correcting file with new character
				correctedFile = correctedFile.replaceAll(characterToReplace, characterReplacement);

				//Replacing and outputting contents of old file
				FileWriter writer = new FileWriter(fileToCorrect);

				System.out.println("Corrected content: "+System.lineSeparator()+correctedFile);

				writer.append(correctedFile);
				writer.flush();
				writer.close();
				
				return;

			} catch (FileNotFoundException e) {
				System.out.println("Error: Incorrect file input.  Please make sure the path and extension of the file are specified ");
				System.out.println("i.e. C:\\Users\\JohnSmith\\Documents\\input.txt");
				System.out.println("");
			}


		}while(true);
	}
}
