
public class Rectangle {

	
	private int length;
	private int width;
	private int area;
	private int perimeter;
	
	public Rectangle (int length, int width){
		this.length = length;
		this.width = width;
		this.area = this.length * this.width;
		this.perimeter = 2 * (this.length + this.width);
	}
	
	public int getLength(){
		return this.length;
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public int getArea(){
		return this.area;
	}
	
	public int getPerimeter(){
		return this.perimeter;
	}
	
	public boolean isSquare(){
		return (this.length == this.width);
	}
	
	
	public boolean isSmaller (Rectangle rectangleB) {
		return (this.area < rectangleB.area);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle myRectangle = new Rectangle(5,5);
		Rectangle yourRectangle = new Rectangle (2,3);
		
		
		System.out.println(myRectangle.isSquare());
		System.out.println(myRectangle.isSmaller(yourRectangle));
		System.out.println(yourRectangle.isSmaller(yourRectangle));

	}

}
