import java.util.HashMap;
import java.util.Map;

// Least Frequently Used Cache
public class LFUCache {

    class DoubleLinkedList {
        int listSize;
        DLLNode head, tail;

        public DoubleLinkedList() {
            this.listSize = 0;
            this.head = new DLLNode(0, 0);
            this.tail = new DLLNode(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void addNode(DLLNode currNode) {
            DLLNode nextNode = head.next;
            currNode.next = nextNode;
            currNode.prev = head;
            head.next = currNode;
            nextNode.prev = currNode;
            listSize++;
        }

        public void removeNode(DLLNode currNode) {
            DLLNode prevNode = currNode.prev;
            DLLNode nextNode = currNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }
    }

    class DLLNode {
        int key, value, frequency;
        DLLNode prev, next;

        DLLNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    final int capacity;
    int currSize;
    int minFrequency;
    Map<Integer, DLLNode> cache;
    Map<Integer, DoubleLinkedList> frequenMap;

    LFUCache(int capacity) {
        this.capacity = capacity;
        this.currSize = 0;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequenMap = new HashMap<>();
    }

    public int get(int key) {
        DLLNode currNode = cache.get(key);
        if (currNode == null) {
            return -1;
        }

        updateNode(currNode);
        return currNode.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {
            DLLNode currNode = cache.get(key);
            currNode.value = value;
            updateNode(currNode);
        } else {
            currSize++;
            if (currSize > capacity) {
                // get minimum freq list
                DoubleLinkedList minFreqList = frequenMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                currSize--;
            }

            // reset min freq to 1 bcuz of adding new node
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);

            // get the list with frequency 1, and then add new node into the list, as well
            // as LFU cache
            DoubleLinkedList currList = frequenMap.getOrDefault(1, new DoubleLinkedList());
            currList.addNode(newNode);
            frequenMap.put(1, currList);
            cache.put(key, newNode);
        }
    }

    public void updateNode(DLLNode currNode) {
        int currFreq = currNode.frequency;
        DoubleLinkedList currList = frequenMap.get(currFreq);
        currList.removeNode(currNode);

        if (currFreq == minFrequency && currList.listSize == 0) {
            minFrequency++;
        }

        currNode.frequency++;
        // add current node to another list has current frequency + 1
        DoubleLinkedList newList = frequenMap.getOrDefault(currNode.frequency, new DoubleLinkedList());
        newList.addNode(currNode);
        frequenMap.put(currNode.frequency, newList);
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(3);
        lfu.put(1, 1);
        lfu.put(2, 2);
        lfu.put(3, 3);
        System.out.println(lfu.get(3));
        lfu.put(4, 4);
        lfu.put(5, 5);
        System.out.println(lfu.get(4));
        System.out.println(lfu.get(1));
    }
}
