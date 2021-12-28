package Stack;
import java.util.*;
class LRUCache {  
    private Node head = new Node(0, 0), tail = new Node(0, 0);
    private HashMap<Integer, Node> map = new HashMap<>();
    private int capacity;
    
    public LRUCache(int _capacity) {
      this.capacity = _capacity;
      head.next = tail;
      tail.prev = head;
    }
  
    public int get(int key) {
      if(map.containsKey(key)) {
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
      } else {
        return -1;
      }

    }
  
    public void put(int key, int value) {
      if(map.containsKey(key)) {
        remove(map.get(key));
      }
      if(map.size() == capacity) {
        remove(tail.prev);
      }
      insert(new Node(key, value));
    }
    
    private void remove(Node node) {
      map.remove(node.key);
      node.prev.next = node.next;
      node.next.prev = node.prev;
      
    }
    
    private void insert(Node node){
      map.put(node.key, node);
      node.next = head.next;
      node.next.prev = node;
      head.next = node;
      node.prev = head;
    }
    
    
  }

  class Node{
    Node prev, next;
    int key, value;
    Node(int _key, int _value) {
      key = _key;
      value = _value;
    }
  }
