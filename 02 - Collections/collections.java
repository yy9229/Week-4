/*
 * LIST INTERFACE
 * Problem 1
 * import java.util.*;
public class collections {
    public static <T> void reverseList(List<T> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original ArrayList: " + arrayList);
        reverseList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);
        List<Integer> linkedList = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("\nOriginal LinkedList: " + linkedList);
        reverseList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}*/

/*
 * Problem 2
 * import java.util.*;
public class collections {
    public static Map<String, Integer> countFrequency(List<String> items) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String item : items) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        return frequencyMap;
    }
    public static void main(String[] args) {
        List<String> input = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> result = countFrequency(input);
        System.out.println("Frequency of elements: " + result);
    }
}*/

/*
 * Problem 3
 * import java.util.*;
public class collections {
    public static <T> List<T> rotateList(List<T> list, int positions) {
        int size = list.size();
        positions = positions % size; 
        if (positions < 0) positions += size; 
        List<T> rotated = new ArrayList<>();
        rotated.addAll(list.subList(positions, size));
        rotated.addAll(list.subList(0, positions));
        return rotated;
    }
    public static void main(String[] args) {
        List<Integer> originalList = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;
        List<Integer> rotatedList = rotateList(originalList, rotateBy);
        System.out.println("Rotated List: " + rotatedList);
    }
}*/

/*
 * Problem 4
 * import java.util.*;
public class collections {
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new LinkedHashSet<>();
        for (T item : list) {
            seen.add(item);
        }
        return new ArrayList<>(seen);
    }
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> output = removeDuplicates(input);
        System.out.println("After removing duplicates: " + output);
    }
}*/

/*
 * Problem 5
 * import java.util.LinkedList;
import java.util.Iterator;
public class collections {
    public static <T> T getNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();
        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) {
                throw new IllegalArgumentException("List is shorter than " + n);
            }
            first.next();
        }
        while (first.hasNext()) {
            first.next();
            second.next();
        }
        return second.next();
    }
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        int n = 2;
        String result = getNthFromEnd(list, n);
        System.out.println("The " + n + "th element from the end is: " + result);
    }
}*/

/* SET INTERFACE */

/*
 * Problem 1
 * import java.util.HashSet;
import java.util.Set;
public class collections {
    public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
        return set1.equals(set2);
    }
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);
        boolean result = areSetsEqual(set1, set2);
        System.out.println("Are the sets equal? " + result);
    }
}*/

/*
 * Problem 2
 * import java.util.HashSet;
import java.util.Set;
public class collections {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
    }
}*/

/*
 * Problem 3
 * import java.util.HashSet;
import java.util.Set;
public class collections{
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        union.removeAll(intersection);
        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Symmetric Difference: " + union);
    }
}*/

/*
 * Problem 4
 * import java.util.*;
public class collections{
	public static void main(String[] args) {
		Set<Integer> hashSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));
		List<Integer> sortedList = new ArrayList<>(hashSet);
		Collections.sort(sortedList);
		System.out.println("Original Set: " +hashSet);
		System.out.println("Sorted List: "+sortedList);
	}
}*/

/*
 * Problem 5
 * import java.util.*;
public class collections{
	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
		Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
		boolean isSubset = set2.containsAll(set1);
		System.out.println("Is set1 a subset of set2? " +isSubset);
	}
}*/

/* QUEUE INTERFACE */

/*import java.util.*;
public class collections{
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		System.out.println("Original Queue: "+queue);
		reverse(queue);
		System.out.println("Reversed Queue: "+queue);
	}
	public static void reverse(Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<>();
		while(!queue.isEmpty()) {
			stack.push(queue.remove());
		}
		while(!stack.isEmpty()) {
			queue.add(stack.pop());
		}
	}
}*/

/*
 * Problem 2
 * import java.util.*;
public class collections {
    public static void main(String[] args) {
        int N = 5;
        List<String> binaryNumbers = generateBinaryNumbers(N);
        System.out.println("First " + N + " Binary Numbers: " + binaryNumbers);
    }
    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        for (int i = 0; i < N; i++) {
            String current = queue.remove();
            result.add(current);
            queue.add(current + "0");
            queue.add(current + "1");
        }
        return result;
    }
}*/

/*
 * Problem 3
 * import java.util.*;
class Patient {
    String name;
    int severity;
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}
public class collections {
    public static void main(String[] args) {
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>((p1, p2) -> p2.severity - p1.severity);
        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5));
        triageQueue.add(new Patient("Bob", 2));
        System.out.println("Treatment Order:");
        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.poll());
        }
    }
}*/

/*
 * Problem 4
 * import java.util.LinkedList;
import java.util.Queue;
class StackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    public int pop() {
        if (q1.isEmpty()) throw new RuntimeException("Stack is empty");
        return q1.remove();
    }
    public int top() {
        if (q1.isEmpty()) throw new RuntimeException("Stack is empty");
        return q1.peek();
    }
    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
public class collections {
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top: " + stack.top());  
        System.out.println("Popped: " + stack.pop()); 
        System.out.println("Top after pop: " + stack.top());
    }
}*/

/*
 * Problem 5
 * class CircularBuffer {
    private int[] buffer;
    private int size;
    private int start;
    private int end;
    private boolean isFull;
    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
        size = capacity;
        start = 0;
        end = 0;
        isFull = false;
    }
    public void insert(int value) {
        buffer[end] = value;
        end = (end + 1) % size;
        if (isFull) {
            start = (start + 1) % size;
        }
        if (end == start) {
            isFull = true;
        }
    }
    public void display() {
        System.out.print("Buffer: ");
        int i = start;
        int count = isFull ? size : (end + size - start) % size;

        for (int j = 0; j < count; j++) {
            System.out.print(buffer[i] + " ");
            i = (i + 1) % size;
        }
        System.out.println();
    }
}
public class collections {
    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display();
        cb.insert(4); 
        cb.display(); 
    }
}*/

/* MAP INTERFACE */

/*
 * Problem 1
 * import java.util.*;
import java.util.regex.*;
public class collections {
    public static void main(String[] args) {
        String text = "Hello world, hello Java!";
        text = text.toLowerCase().replaceAll("[^a-z\\s]", "");
        String[] words = text.split("\\s+");
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}*/

/*
 * Problem 2
 * import java.util.*;
public class collections {
    public static void main(String[] args) {
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);
        Map<Integer, List<String>> invertedMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : originalMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }
        System.out.println("Inverted Map: " + invertedMap);
    }
}*/

/*
 * Problem 3
 * import java.util.*;
public class collections {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        System.out.println("Key with the highest value: " + maxKey);
    }
}*/

/*
 * Problem 4
 * import java.util.*;
public class collections {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            map1.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        System.out.println("Merged Map: " + map1);
    }
}*/

/*
 * Problem 5
 * import java.util.*;
class Employee {
    String name;
    String department;
    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    public String toString() {
        return name;
    }
}
public class collections {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR"),
            new Employee("David", "Finance"),
            new Employee("Eve", "IT")
        );
        Map<String, List<Employee>> groupedByDept = new HashMap<>();
        for (Employee emp : employees) {
            groupedByDept
                .computeIfAbsent(emp.department, k -> new ArrayList<>())
                .add(emp);
        }
        for (Map.Entry<String, List<Employee>> entry : groupedByDept.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}*/

/*
 * Problem 1
 * import java.util.*;
public class collections{
    public static void main(String[] args) {
        HashMap<String, Integer> voteCount = new HashMap<>();
        castVote(voteCount, "Alice");
        castVote(voteCount, "Bob");
        castVote(voteCount, "Alice");
        castVote(voteCount, "Charlie");
        castVote(voteCount, "Bob");
        castVote(voteCount, "Alice");
        System.out.println("Votes (Insertion Order - LinkedHashMap):");
        LinkedHashMap<String, Integer> linkedVotes = new LinkedHashMap<>();
        for (String candidate : voteCount.keySet()) {
            linkedVotes.put(candidate, voteCount.get(candidate));
        }
        linkedVotes.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("\nVotes (Sorted Order - TreeMap):");
        TreeMap<String, Integer> sortedVotes = new TreeMap<>(voteCount);
        sortedVotes.forEach((k, v) -> System.out.println(k + ": " + v));
    }
    public static void castVote(Map<String, Integer> map, String candidate) {
        map.put(candidate, map.getOrDefault(candidate, 0) + 1);
    }
}*/

/*
 * Problem 2
 * import java.util.*;
public class collections {
    public static void main(String[] args) {
        HashMap<String, Double> productPrices = new HashMap<>();
        productPrices.put("Apple", 2.0);
        productPrices.put("Banana", 1.0);
        productPrices.put("Milk", 3.0);
        productPrices.put("Bread", 2.5);
        LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();
        addToCart(cart, "Apple", 2);
        addToCart(cart, "Milk", 1);
        addToCart(cart, "Banana", 3);
        System.out.println("🛒 Cart (Insertion Order):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String item = entry.getKey();
            int qty = entry.getValue();
            double price = productPrices.get(item);
            System.out.println(item + " x " + qty + " = $" + (qty * price));
        }
        System.out.println("\nCart (Sorted by Price):");
        TreeMap<Double, List<String>> priceMap = new TreeMap<>();
        for (String item : cart.keySet()) {
            double price = productPrices.get(item);
            priceMap.computeIfAbsent(price, k -> new ArrayList<>()).add(item);
        }
        for (Map.Entry<Double, List<String>> entry : priceMap.entrySet()) {
            double price = entry.getKey();
            for (String item : entry.getValue()) {
                int qty = cart.get(item);
                System.out.println(item + " x " + qty + " = $" + (qty * price));
            }
        }
    }
    public static void addToCart(LinkedHashMap<String, Integer> cart, String item, int quantity) {
        cart.put(item, cart.getOrDefault(item, 0) + quantity);
    }
}*/

/*
 * Problem 3
 * import java.util.*;
class WithdrawalRequest {
    int accountNumber;
    double amount;
    public WithdrawalRequest(int accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}
public class collections {
    public static void main(String[] args) {
        HashMap<Integer, Double> accounts = new HashMap<>();
        accounts.put(101, 5000.0);
        accounts.put(102, 3000.0);
        accounts.put(103, 7000.0);
        Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();
        withdrawalQueue.add(new WithdrawalRequest(101, 1000));
        withdrawalQueue.add(new WithdrawalRequest(103, 2000));
        withdrawalQueue.add(new WithdrawalRequest(102, 4000));
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest req = withdrawalQueue.poll();
            if (accounts.containsKey(req.accountNumber)) {
                double balance = accounts.get(req.accountNumber);
                if (balance >= req.amount) {
                    accounts.put(req.accountNumber, balance - req.amount);
                    System.out.println("Withdrawal of $" + req.amount + " from Account " + req.accountNumber + " successful.");
                } else {
                    System.out.println("Insufficient balance in Account " + req.accountNumber);
                }
            } else {
                System.out.println("Account " + req.accountNumber + " not found.");
            }
        }
        TreeMap<Double, List<Integer>> sortedByBalance = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            sortedByBalance.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        System.out.println("\nCustomer Accounts (Sorted by Balance):");
        for (Map.Entry<Double, List<Integer>> entry : sortedByBalance.entrySet()) {
            for (int accNo : entry.getValue()) {
                System.out.println("Account " + accNo + " → Balance: $" + entry.getKey());
            }
        }
    }
}*/
