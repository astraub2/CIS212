import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class OccurrenceSet<T>  implements Set<T>{
	
	private HashMap<T, Integer> _hashmap = new HashMap<>();
	public ArrayList<T> storage=new ArrayList<T>();

	@Override
	public boolean add(T e) {
		if( _hashmap.containsKey(e))
			{
			storage.add(e);
			int value=_hashmap.get(e).intValue();
			_hashmap.put(e, value+1);
			return false;}
		else{
			storage.add(e);
			_hashmap.put(e, 1);
			return true;}


	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		int checker=0;
		T elements = (T) ((OccurrenceSet) c).storage;
		for(int i=0; i<((ArrayList<T>) elements).size(); i++)
		{
			
			T e = ((ArrayList<T>) elements).get(i);	
			if( _hashmap.containsKey(e))
			{
			int value=_hashmap.get(e).intValue();
			_hashmap.put((T) e, value+1);
			}
			else{
			_hashmap.put((T) e, 1);
			}
			
		}
		return true;
		
		
	}

	

	@Override
	public void clear() {
		_hashmap = new HashMap<>();
		
	}

	@Override
	public boolean contains(Object o) {
		if (_hashmap.get(o) != null)
			return true;
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		
		for (int i = 0; i < c.size(); i++) {
			T elements = (T) ((OccurrenceSet) c).storage;
			
	        if( storage.contains(elements)==false)
	        	return false;
			
	        
		}
		return true;
		
	}

	@Override
	public boolean isEmpty() {
		if(_hashmap.isEmpty())
			return true;
		return false;
	
	}


	@Override
	public boolean remove(Object o) {
		if( _hashmap.containsKey(o))
		{
		storage.remove(o);
		_hashmap.remove(o);
		return true;}
		else{
		
			return false;}
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		int checker=0;
		T elements = (T) ((OccurrenceSet) c).storage;
		for (int i = 0; i < c.size(); i++) {
			T element = ((ArrayList<T>) elements).get(i);	
	        if( _hashmap.containsKey(element))
			{
	        storage.remove(element);
			_hashmap.remove(element);
			checker++;
			}
	    }
		if(checker>0)
			return true;
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		int checker=0;
		T elements = (T) ((OccurrenceSet) c).storage;

		for (int i = 0; i < c.size(); i++) {
			T e = ((ArrayList<T>) elements).get(i);	
	        if( _hashmap.containsKey(e)==false)
			{
	        storage.remove(i);
			_hashmap.remove(e);
			checker++;
			}
	    }
		if(checker>0)
			return true;
		return false;
	}

	@Override
	public int size() {
		
		return _hashmap.size();
	}

	@Override
	public Object[] toArray() {
		ArrayList<?> sort= (ArrayList<?>) Sorter();
		Object[] sorted = new Object[sort.size()];
		for(int i=0; i<sort.size(); i++)
		{
			sorted[i]=((Sortable) sort.get(i)).key();
		}
		
			
		return sorted;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		
		return null;
	}
	@Override
	public Iterator<T> iterator() {
		ArrayList<?> sort= (ArrayList<?>) Sorter();
		ArrayList al = new ArrayList();
		for(int i=0; i<sort.size(); i++)
		{
			String thing = ((Sortable) sort.get(i)).key();
			al.add(thing);
		}
		
		
		Iterator<T> iterator = al.iterator();
		
		
		return (Iterator<T>) iterator;
	}
	public String toString(){
		String string = "";
		ArrayList<T> sorter = (ArrayList<T>) Sorter();
		
		for(int i=0; i<_hashmap.size(); i++){
			Object thing = sorter.get(i);
			string+=((Sortable) thing).key()+" ";
		}
		
		return string;
	}
	private Object Sorter(){
		ArrayList<Sortable> sorter=new ArrayList<Sortable>();
		Object[] keys=_hashmap.keySet().toArray();
		Object[] values=_hashmap.values().toArray();
		for(int i=0; i<_hashmap.size(); i++){
			Sortable selection= new Sortable(keys[i].toString(), values[i].toString());
			sorter.add(selection);
			
		}
		Collections.sort(sorter);
		return sorter;
		
		
		
	}

}
