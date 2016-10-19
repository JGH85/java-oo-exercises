package javagram.filters;

import javagram.Picture;
import java.awt.Color;

public class FlipVertical implements Filter{

	public Picture process(Picture original) {
		
		Picture processed = new Picture(original.width(), original.height());
        
	    //get each pixel one by one
	    for (int i = 0; i < original.width(); i++) {
	      for (int j = 0; j < original.height(); j++) {
	    	  
	    	  Color c = original.get(i, j);
	          
	          //get color components from each pixel
	          int r = c.getRed();
	          int g = c.getGreen();
	          int b = c.getBlue();
	          
              int newj = (original.height()-1)-j;
             // System.out.print(newi);
              processed.set(i, newj, new Color(r, g, b));
	    	  
	      }
	    }
		
		return processed;
	}

}
