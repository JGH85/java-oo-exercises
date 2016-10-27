package javagram;

import javagram.filters.*;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Javagram {

	public static void main(String[] args) {

		// Create the base path for images and set up variables.		
		String[] baseParts = {System.getProperty("user.dir"), "images"};
		String dir = String.join(File.separator, baseParts);
		String relPath;
		String refilter = "";
		String imageName ="";
		String fileName ="";

		Picture picture = null;
		Picture processed = null;
		Scanner in = new Scanner(System.in);
		Boolean saveApproval = false;
		
		System.out.println("Welcome to Javagram, our homemade image filter program.");
		System.out.println("First let's select an image.");
		// prompt user for image to filter and validate input
		do {
			
			String imagePath = "path not set";
			
			// try to open the file
			try {
				
				System.out.println("Please provide an image path (relative to " + dir + "):");
				relPath = in.next();
				
				//store name of image for use later in comparing to new file name
				imageName = relPath;
				
				//this is the broken code that came with the assignment
				/*String[] relPathParts = relPath.split(File.separator);
				imagePath = dir + File.separator + String.join(File.separator, Arrays.asList(relPathParts));
				*/
				imagePath = (dir + "\\" + relPath);
				
				picture = new Picture(imagePath);
				
			} catch (RuntimeException e) {
				System.out.println("Could not open image: " + imagePath);
			}
			
		} while(picture == null);
		
		System.out.println("Cool. Now that we have an image here are your filter options.");
		
		// TODO - prompt user for filter and validate input
		
		do {
			//use function to choose a filter
			Filter filter = filterMenu(in);

			// filter and display image
			processed = filter.process(picture);
			processed.show();
			
			System.out.println("Image successfully filtered");
				
			//ask if they want to use another filter. 
			System.out.println("Would you like to apply another filter before saving?");
			refilter = in.next();
			if (refilter.equals("yes")){
					picture = processed;
				}
		} while (refilter.equals("yes"));
			
		// save image, if desired
		do {
			System.out.println("Save image to (relative to " + dir + ") (type 'exit' to quit w/o saving):");
			fileName = in.next();
		
			// TODO - if the user enters the same file name as the input file, confirm that they want to overwrite the original
			if (fileName.equals("exit")) {
				break;
			}
			else if (fileName.equals(imageName))
			{
				System.out.println("Do you really want to write over the original file? Type 'yes' to confirm.");
				String confirmation = in.next();
				
				if (confirmation.equals("yes"))
					{saveApproval = true;}
					
			}
			else {
				saveApproval = true;
			}
				
			} while (saveApproval == false);	
		
		if (saveApproval == true) 
		{
			String absFileName = dir + File.separator + fileName;
			processed.save(absFileName);
			System.out.println("Image saved to " + absFileName);
		}
		else {
			System.out.println("Image not saved");
		}
		// close input scanner
		in.close();
	}
	
	//TODO - refactor this method to accept an int parameter, and return an instance of the Filter interface
	//TODO - refactor this method to thrown an exception if the int doesn't correspond to a filter
	private static Filter getFilter(int fNumber) {
		if (fNumber == 1) {
				return new BlueFilter();
			}
			else if (fNumber == 2) {
				return new RedFilter();
			}
			else if (fNumber == 3) {
				return new GreenFilter();
			}
			else if (fNumber == 4) {
				return new GreyScale();
			}
			else if (fNumber == 5) {
				return new FlipHorizontal();
			}
			else if (fNumber == 6) {
				return new FlipVertical();
			}
			else throw new IllegalArgumentException();
		}
	
	
	private static Filter filterMenu(Scanner in) {
		
		//set up some variables that we will need for the next sections
		boolean valid_input = false;
		
		Filter filter = null;
		
		System.out.println("1. BlueFilter");
		System.out.println("2. RedFilter");
		System.out.println("3. GreenFilter");
		System.out.println("4. GreyScale");
		System.out.println("5. FlipHorizontal");
		System.out.println("6. FlipVertical");

		System.out.println("Please select a filter option");
		
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
		
		return filter;
	
	
	}
}