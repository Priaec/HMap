public class MapEntry<K,V>{

  protected K key;
  protected V value;
 
 MapEntry(K k, V v){
	 key = k;
	 value = v;
 }
    public K getKey(){
		 return key;
	}
    public V getValue(){
         return value;
    }		   
	public void setValue(){
        this.value = value;        
	}
	   
      @Override 
	   public String toString(){
		   return ("Key  : " + key + "\nValue: " + value);
		//return String representation of Key , Value 
	 }

}