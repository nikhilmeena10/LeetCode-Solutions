import java.util.ArrayList;
import java.util.List;

public class _2 {

    class MyHashSet {

        private List<Integer>[] arr;
        private int size;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            size = 1000;
            arr = new ArrayList[size];
            for (int i = 0; i < size; i++) {
                arr[i] = new ArrayList<>();
            }
        }

        public void add(int key) {
            int hash = (Integer.valueOf(key)).hashCode();
            int pos = hash % size;
            List<Integer> list = arr[pos];
            if (list.contains(key)) return;
            list.add(key);
            arr[pos] = list;
        }

        public void remove(int key) {
            int hash = (new Integer(key)).hashCode();
            int pos = hash % size;
            List<Integer> list = arr[pos];
            list.remove(Integer.valueOf(key));
            arr[pos] = list;
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            int hash = (Integer.valueOf(key)).hashCode();
            int pos = hash % size;
            List<Integer> list = arr[pos];
            return list.contains(Integer.valueOf(key));
        }

        class Node {
            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}
