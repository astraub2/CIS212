
public class Sortable implements Comparable{
	public final String _key;
	public final String _value;
	
	
	public Sortable(String key, String value){
		_key=key;
		_value=value;
		
	
	
	}
	public String key(){
		return _key;
	}
	
	public String value(){
		return _value;
		
		
	}
	@Override
	public int compareTo(Object sortable) {
		String compare=((Sortable) sortable).value();
		
		
		return _value.compareTo(compare);
		
	}


}
