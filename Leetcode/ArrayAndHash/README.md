## Array and Hash section

- 做題目時，需要判斷一個元素是否出現過的場景，應該要先想到Hash
- 26 letters ⇒ use hash array to count how many time each letter show up

### HashMap

```java
Map<Integer, Integer> map = new HashMap<Integer, Integer>()
map.get(key);
map.put(key, value);

//if other operation is +1
map.put(key, map.getOrDefault(key, initialValue) + 1);

map.keySet();
map.values();
map.containsKey(key);
map.containsValue(value);
```

### HashSet
```java
//set (can't repeat)
Set<Integer> set = new HashSet<Integer>();
set.add(item);
set.remove(item);
set.contains(item);
set.size();
```

### HashTable
```java
Hashtable<Integer,String> angularDevepolers = new Hashtable<Integer,String>();
 
//Adding objects in Hashtable
angularDevepolers.put(1, "Navdeep");
angularDevepolers.put(4, "Anil");
```
