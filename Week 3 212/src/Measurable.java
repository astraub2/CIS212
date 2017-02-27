
public interface Measurable {
	
	//Implement a new interface named Measurable with a single method named getArea()
	//which takes no arguments and returns a double.
	public default double getArea(){	
		return 0;
	}

}
