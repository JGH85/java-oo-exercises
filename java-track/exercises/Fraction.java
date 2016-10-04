
public class Fraction {

	private Integer num;
	private Integer den;
	
	public Fraction (Integer num, Integer den){
		this.num = num;
		this.den = den;
	}
	
	public String toString(){
		return ("Fraction: " + this.num + "/" + this.den);
	}
	
	
	public Fraction multiplyFractions(Fraction fractionB){
		Integer newnum= this.num*fractionB.num;
		Integer newden = this.den*fractionB.den;
		Fraction fractionC = new Fraction(newnum, newden);
		return fractionC;
	}
	
	public Fraction addFractions(Fraction fractionB){
		Integer newnum= this.num*fractionB.den + fractionB.num*this.den;
		Integer newden = this.den*fractionB.den;
		Fraction fractionC = new Fraction(newnum, newden);
		return fractionC.simplify();
	}

	public Fraction reciprocal(){
		Integer newnum= this.den;
		Integer newden = this.num;
		Fraction fractionC = new Fraction(newnum, newden);
		return fractionC;
	}
	
	
	public Fraction simplify(){
		Integer a = this.num;
		Integer b = this.den;
		Integer c;
		
		//while b
		// a, b = b, a%b
		//return a
		
		while (b!=0) {
			c = a % b;
			a = b;
			b = c;
		}
		Integer gcd = a;
		
		Integer newnum= this.num / gcd;
		Integer newden = this.den / gcd;
		Fraction fractionC = new Fraction(newnum, newden);
		return fractionC;
		}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fraction myFraction = new Fraction(1, 2);
		Fraction yourFraction = new Fraction (12,48);
		System.out.println(myFraction.toString());
		System.out.println(myFraction.multiplyFractions(yourFraction));
		System.out.println(myFraction.addFractions(yourFraction));
		System.out.println(myFraction.reciprocal());
		System.out.println(yourFraction.simplify());


	}

}
