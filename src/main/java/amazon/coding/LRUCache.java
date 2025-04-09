package amazon.coding;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.previous = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node oldNode = map.get(key);
            remove(oldNode);
        }

        Node node = new Node(key, value);
        map.put(key, node);
        add(node);

        if (map.size() > capacity) {
            Node nodeToDelete = head.next;
            remove(nodeToDelete);
            map.remove(nodeToDelete.key);
        }
    }

    public void add(Node node) {
        Node previousNodeEnd = tail.previous;
        previousNodeEnd.next = node;
        node.previous = previousNodeEnd;
        node.next = tail;
        tail.previous = node;
    }

    public void remove(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);  // Cache: {1=1}
        cache.put(2, 2);  // Cache: {1=1, 2=2}
        System.out.println(cache.get(1)); // Output: 1 (Moves 1 to the front)

        cache.put(3, 3);  // Evicts key 2, Cache: {1=1, 3=3}
        System.out.println(cache.get(2)); // Output: -1 (2 was evicted)

        cache.put(4, 4);  // Evicts key 1, Cache: {3=3, 4=4}
        System.out.println(cache.get(1)); // Output: -1 (1 was evicted)
        System.out.println(cache.get(3)); // Output: 3 (Moves 3 to front)
        System.out.println(cache.get(4));
    }
}

class Node {
    int key;
    int val;
    Node next;
    Node previous;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
