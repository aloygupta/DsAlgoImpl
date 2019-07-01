package hashtable;

public interface HashTable<Key,Value> {

	//hash(k, m) - m is size of hash table
	
	//if key already exists, update value
	public void add(Key key, Value value) throws Exception; 
	
	// returns true if key already exists, false otherwise
	public boolean exists(Key key) throws Exception;
	
	// returns value associated with key
	public Value get(Key key) throws Exception;
	
	//removes key from hashtable
	public void remove(Key key) throws Exception;
}
