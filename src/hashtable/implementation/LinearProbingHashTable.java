package hashtable.implementation;

import hashtable.HashTable;

public class LinearProbingHashTable<Key,Value> implements HashTable<Key, Value> {

	// Nice ref: http://www.cs.rmit.edu.au/online/blackboard/chapter/05/documents/contribute/chapter/05/linear-probing.html

	private static final int MAX_TABLE_SIZE = 10;
	private KeyValuePair<Key,Value>[] hashtable;

	private final KeyValuePair<Key, Value> DELETED_ELEMENT_FLAG = new KeyValuePair<>(null, null);

	/*null represents an EMPTY ELEMENT in this implementation,
	 whereas KeyValuePair object with null key and null value represents DELETED_ELEMENT_FLAG*/

	public LinearProbingHashTable() {

		hashtable = new KeyValuePair[MAX_TABLE_SIZE];
		//System.out.println(toString());
	}


	@Override
	public void add(Key key, Value value) throws Exception {

		if(key == null)
			throw new Exception("Addition failed. Key is null");

		KeyValuePair<Key,Value> keyValuePair = new KeyValuePair<>(key,value);
		
		int hashCode = Math.abs(key.hashCode());

		int originalIndex = hashCode % MAX_TABLE_SIZE;
		System.out.println("Key: "+key+" hashcode "+hashCode);

		int tempIndex = originalIndex;
		boolean isAdded = false;
		do {
			
			KeyValuePair<Key,Value> existingKVPair = hashtable[tempIndex];

			// if the value at that place is null, it means its empty
			// if it's not, the 2nd OR condition checks whether it represents an already DELETED element flag.
			// if it's not, the 3rd OR condition checks if the existing key at that position matches, 
			//in that case we need to update the value for that key, OR if it was a deleted element, then also update
			// NOTE: We need to compare keys, not hashcode, because two keys can hash to the same value
			// NOTE: existingKVPair.key won't get NPE, because we check existingKVPair.equals(DELETED_ELEMENT_FLAG) before that
			if(existingKVPair == null || existingKVPair.equals(DELETED_ELEMENT_FLAG) || existingKVPair.key.equals(key)) {
				
				hashtable[tempIndex] = keyValuePair;
				isAdded = true;
				break;
			}
			else {
				// increment in loopback way, keep probing
				tempIndex = (tempIndex +1) % MAX_TABLE_SIZE;
			}
			
		}while(tempIndex != originalIndex);

		// tempIndex reached originalIndex looping back, so there was no free space in table found
		if(!isAdded)
			throw new Exception("Adding of key "+key+" failed. Out of space.");
	}

	@Override
	public boolean exists(Key key) throws Exception {

		if(key == null)
			throw new Exception("Search failed. Key is null");

		int hashCode = Math.abs(key.hashCode());

		int originalIndex = hashCode % MAX_TABLE_SIZE;
		int tempIndex = originalIndex;

		while(hashtable[tempIndex] != null) {

			KeyValuePair<Key,Value> existingKVPair = hashtable[tempIndex];

			if(existingKVPair.key.equals(key)) {
				//there is match of keys, so return value immediately
				return true;
			}
			else {
				// keep probing in circular fashion
				tempIndex = (tempIndex + 1) % MAX_TABLE_SIZE;
			}

			//if index is back to originalIndex that means key has not been found even after full array traversal is also done
			if(tempIndex == originalIndex)
				break;
		}

		// key is not present in hashtable
		//throw new Exception("Key "+key+" is not present in hashtable.");
		return false;



	}

	@Override
	public Value get(Key key) throws Exception {

		if(key == null)
			throw new Exception("Retreival failed. Key is null");

		int hashCode = Math.abs(key.hashCode());

		int originalIndex = hashCode % MAX_TABLE_SIZE;
		int tempIndex = originalIndex;

		while(hashtable[tempIndex] != null) {

			KeyValuePair<Key,Value> existingKVPair = hashtable[tempIndex];

			if(existingKVPair.key.equals(key)) {
				//there is match of keys, so return value immediately
				return existingKVPair.value;
			}
			else {
				// keep probing in circular fashion
				tempIndex = (tempIndex + 1) % MAX_TABLE_SIZE;
			}

			//if index is back to originalIndex that means key has not been found even after full array traversal is also done
			if(tempIndex == originalIndex)
				break;
		}

		// key is not present in hashtable
		//throw new Exception("Key "+key+" is not present in hashtable.");

		/* the above throw Exception is commented because in this implementation, we are assuming if key is not present in hashtable
		 * it should return null.
		 * In that case we won't be able to tell while calling get(key) whether key is not there
		 * OR
		 * value of the key is null.
		 * 
		 * So, to be sure, we should call exists(key) before get(key)
		 * if(exists(key))
		 * Value value = get(key);
		 */
		return null;
	}

	@Override
	public void remove(Key key) throws Exception {

		// we will delete by Lazy strategy, where deleted indexes will be marked with a flag.
		// this will lead to table pollution though.
		// Alternative: See Deletion section in https://en.wikipedia.org/wiki/Linear_probing

		if(key == null)
			throw new Exception("Deletion failed. Key is null");

		int hashCode = Math.abs(key.hashCode());

		int originalIndex = hashCode % MAX_TABLE_SIZE;
		int tempIndex = originalIndex;
		boolean isDeleted = false;

		while(hashtable[tempIndex] != null) {	//keep checking until a completely empty element (null) is found

			KeyValuePair<Key,Value> keyValuePair = hashtable[tempIndex];

			// null check is required for key, because we can't delete the same key again. The already DELETED key is marked null,null in our algo.
			if(keyValuePair.key != null && keyValuePair.key.equals(key)) {
				// match found, delete it by setting delete flag
				hashtable[tempIndex] = DELETED_ELEMENT_FLAG;
				isDeleted = true;
				break;
			}

			tempIndex = (tempIndex + 1) % MAX_TABLE_SIZE;
			//if index is back to originalIndex that means key has not been found even after full array traversal is also done
			if(tempIndex == originalIndex)
				break;
		}

		if(!isDeleted)
			throw new Exception("Deletion failed. Key "+key+" doesn't exist");
	}


	@Override
	public String toString() {

		String desc = "";

		for(int i = 0;i<MAX_TABLE_SIZE;i++)
			desc += i+" : "+hashtable[i]+" , ";

		return desc;
	}

	private class KeyValuePair<Key,Value>{

		private Key key;
		private Value value;

		public KeyValuePair(Key key, Value value) {
			this.key = key;
			this.value =value;
		}

		@Override
		public boolean equals(Object obj) {
			return (obj instanceof LinearProbingHashTable.KeyValuePair) 
					&&
					(this.key == ((KeyValuePair<Key, Value>)obj).key
					&&
					this.value == ((KeyValuePair<Key,Value>)obj).value
							);
		}

		@Override
		public String toString() {

			if(key == null)
				return "_DELETED_";

			return "( Key: "+key+" , Value: "+value+" , Hashcode: "+Math.abs(key.hashCode())+","+Math.abs((key.hashCode())%MAX_TABLE_SIZE)+" )";
		}
	}

}
