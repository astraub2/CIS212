
public class Box extends Rectangle{
	private double height;
	private double length;
	private double width;
	public Box(double intlength, double intwidth, double intheight) {
		super(intlength, intwidth);
		width=intwidth;
		length=intlength;
		height=intheight;
		
		
	}
	public double getArea() {
		
		return ((2*length*width)+(2*height*length)+(2*height*width));
		//2L*W + 2H*L + 2H*W
	}
}


