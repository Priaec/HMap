import java.util.Iterator;
 
public class HMap<K, V> implements MapInterface<K, V>{

  protected MapEntry[] map;
  protected final int DEFCAP = 1000;
  protected final double DEFLOAD = 0.75;
  protected int origCap;
  protected int currCap;
  protected double load;
  protected int numPairs; // number of entries
  
  

    public HMap(){
    map = new MapEntry[DEFCAP];
	origCap = DEFCAP;
	currCap = DEFCAP;
	load = DEFLOAD;
     
	}                                    //0.75
    public HMap(int initCap, double initLoad){
     map = new MapEntry[initCap];
	 origCap = initCap;
	 currCap = initCap;
	 load = initLoad;
    }

	protected void enlarge(){
		Iterator<MapEntry<K, V>> i = iterator();
		int count = numPairs;
		map = new MapEntry[currCap + origCap];
		currCap += origCap;
		numPairs = 0;
		MapEntry temp;
		for (int n = 1; n <= count; n++){
			temp = i.next();
			this.put((K)temp.getKey() , (V)temp.getValue());	
		}
	}
	
	public V put(K k, V v){
     if(k == null)
       throw new IllegalArgumentException("A key cannot be null");
	 MapEntry<K, V> entry = new MapEntry<K, V>(k, v);
	 int location = k.hashCode() % currCap;    //Compression: will give us the index for our array
     while((map[location] != null && !(map[location].getKey().equals(k)))){
          location = (location + 1) % currCap;   //linear probing 
	 }
     if(map[location] == null){
        map[location] = entry;
        numPairs++;
	 if((float)numPairs/currCap > load){
		enlarge();
	 }
	    return null;   //good
     }
     else{
		 //key is already in map
		 V tmp = (V) map[location].getValue();  //we want to return the value back to the user 
		 map[location] = entry;      //overwrite  
		 return tmp;   //return old value back to user
		 
     }
    }
   
   public V get(K k){
	   if(k == null){
		   throw new IllegalArgumentException("Keys must not be null");
       }
	   int location = k.hashCode() % currCap;   // 
       while((map[location] != null && !(map[location].getKey().equals(k)))){
        location = (location + 1) % currCap;
	   } 
        if(map[location] == null){
            return null;    //bad , key not found!
        }
        else{
             return (V) map[location].getValue();			
	    }
   }
  public boolean contains(K k){
	  if (k == null){
		  throw new IllegalArgumentException("No keys can be null");
	  }
	  int location = k.hashCode() % currCap; 
	  while(map[location] != null){
		if(map[location].getKey().equals(k)){
           return true;
		}
        else{
         location = (location +1) % currCap;  		 
	    }
      }
   return false;  
  }

  public V remove(K k){
	 int location = k.hashCode() % currCap;
     return(V) map[location].getValue();
   //not supported
  }
  
  public boolean isEmpty(){
	  return numPairs == 0;
	  
  }
  
  public boolean isFull(){
	  return false;
	  //return numPairs == map.length;
  }
  
  public int size(){
	 return numPairs; 
  }
  
  private class MapIterator implements Iterator<MapEntry<K,V>>{  
	  int listSize = size();
	  private MapEntry[] list = new MapEntry[listSize];
	  private int prevPos = -1;
	  
	  public MapIterator(){
		  int next = -1;
		  for(int i = 0; i < listSize; i++){
			  next++;
			  while(map[next] == null){
				  next++;
			  }
			  list[i] = map[next];
		  }
		}
	  public boolean hasNext(){
		return (prevPos < (listSize - 1)); 
	  }
	  public MapEntry<K,V> next(){
		  if(!hasNext())
			  throw new IndexOutOfBoundsException("Index out of bounds");
			  prevPos++;
			  return list[prevPos];
	   }	   
		public void remove(){
					
		}
  }
  public Iterator<MapEntry<K,V>> iterator(){
			return new MapIterator();
  }    
}