package javagram;

import javagram.filters.*;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Javagram {

	public static void main(String[] args) {

		// Create the base path for images		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String dir = String.join(File.separator, baseParts);
		String relPath;
		Picture picture = null;
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to Javagram, our homemade image filter program.");
		System.out.println("First let's select an image.");
		
		// prompt user for image to filter and validate input
		do {
			
			String imagePath = "path not set";
			
			// try to open the file
			try {
				
				System.out.println("Please provide an image path (relative to " + dir + "):");
				relPath = in.next();
				
				/*String[] relPathParts = relPath.split(File.separator);
				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));
				*/
				imagePath = (dir + "\\" + relPath);
				
				picture = new Picture(imagePath);
				
			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}
			
		} while(picture == null);
		
		// TODO - prompt user for filter and validate input
		//int chosenInt = displayFilterMenu(in);
		
		System.out.println("Cool. Now that we have an image here are your filter options.");
		System.out.println("1. BlueFilter");
		System.out.println("2. RedFilter");
		System.out.println("3. TBDFilter");
		System.out.println("Please select a filter option");
		
		boolean valid_input = false;
		
		//i need to instantiate variable outside of try block, but can't do that without making it a filter type. 
		Filter filter = new BlueFilter();
		do {
		int selection = in.nextInt();
		
		// TODO - pass filter ID int to getFilter, and get an instance of Filter back 
		try {
			filter = getFilter(selection);
			valid_input = true;
			}
		catch (IllegalArgumentException e) 
			{
			System.out.println("Invalid selection. Try again.");
			}
		} while (valid_input == false);
		
		// filter and display image
		Picture processed = filter.process(picture);
		processed.show();
		
		System.out.println("Image successfully filtered");
		
		// save image, if desired
		
		System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
		String fileName = in.next();
		
		// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original
		
		if (fileName.equals("exit")) {
			System.out.println("Image not saved");
		} else {
			String absFileName = dir + File.separator + fileName;
			processed.save(absFileName);
			System.out.println("Image saved to " + absFileName);
		}	
		
		// close input scanner
		in.close();
	}
	
	//refactor this method to accept an int parameter, and return an instance of the Filter interface
	//refactor this method to thrown an exception if the int doesn't correspond to a filter
	private static Filter getFilter(int fNumber) {
		if (fNumber == 1) {
				return new BlueFilter();
			}
			else if (fNumber == 2) {
				return new RedFilter();
			}
			else throw new IllegalArgumentException();
		}
	
	
	//	catch (IllegalArgumentException e) {
	//		System.out.println("That didn't work right.");
	//	}
	//	} while (valid_input == false);
		/*		switch(fNumber){
		case 1: 
			filter = new BlueFilter();
			return filter;
		case 2:
			filter = new RedFilter();
			return filter;
		//default:
		//	throw e;
		}*/
	

//	private static int displayFilterMenu(Scanner in) {
		
	/*//menu for user to choose from
	System.out.println("Cool. Now that we have an image here are your filter options.");
	System.out.println("1. BlueFilter");
	System.out.println("2. RedFilter");
	System.out.println("3. TBDFilter");
	System.out.println("Please select a filter option");
	
	int selection = in.nextInt();
	boolean valid_input = false;
	do {
		try {
			getFilter(selection);
			valid_input = true;
		}
		catch (IllegalArgumentException ex) {
			System.err.println("Illegal integer:" + ex.getMessage());
			System.out.println("Invalid selection. Please try again.");
		}
	}
	while (valid_input ==  false);
	
	return selection;
	
	
	
	}*/
}