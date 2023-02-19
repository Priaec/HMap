import java.util.Iterator;
public interface MapInterface<K, V> extends Iterable<MapEntry<K, V>>{
	
	public V put(K k, V v);        //return null, if no value associated with protected by (user of these methods to handle null value
	public V get(K k);              //return null, if no value associated with protected by (user of these methods to handle null value
	public boolean contains(K k);
	public V remove(K k);           //return null, if no value associated with protected by (user of these methods to handle null value
    public boolean isEmpty();
    public boolean isFull();
    public int size();	
	
}

/*
    "England" - key -> hash code  ->  f(x)  ->  5678
	-Area
	-Population
	-Value 
*/