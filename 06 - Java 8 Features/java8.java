/*Problem 1
 * import java.util.*;
import java.util.stream.Collectors;
class java8 {
    static class Employee {
        int id;
        String name;
        String department;
        double salary;
        Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
        public String getDepartment() {
            return department;
        }
        public double getSalary() {
            return salary;
        }
        @Override
        public String toString() {
            return name + " (" + department + "): $" + salary;
        }
    }
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", "Engineering", 90000),
                new Employee(2, "Jane", "HR", 75000),
                new Employee(3, "Alice", "Engineering", 95000),
                new Employee(4, "Bob", "Engineering", 70000),
                new Employee(5, "Charlie", "HR", 80000),
                new Employee(6, "David", "Engineering", 100000)
        );
        Map<String, Double> result = employees.stream()
                .filter(e -> e.getDepartment().equals("Engineering") && e.getSalary() > 80000)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.groupingBy(Employee::getDepartment, 
                        Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(result);
    }
}*/

/*Problem 2
 * import java.util.*;
import java.util.stream.Collectors;
class java8 {
    static class Sale {
        int productId;
        int quantity;
        double price;
        Sale(int productId, int quantity, double price) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }
        public int getQuantity() {
            return quantity;
        }
        public double getPrice() {
            return price;
        }
        public int getProductId() {
            return productId;
        }
    }
    static class ProductSales {
        int productId;
        double totalRevenue;
        ProductSales(int productId, double totalRevenue) {
            this.productId = productId;
            this.totalRevenue = totalRevenue;
        }
        @Override
        public String toString() {
            return "Product " + productId + ": $" + totalRevenue;
        }
    }
    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
                new Sale(1, 15, 20.0),
                new Sale(2, 5, 50.0),
                new Sale(3, 12, 30.0),
                new Sale(4, 25, 10.0),
                new Sale(5, 30, 15.0),
                new Sale(6, 8, 40.0)
        );
        List<ProductSales> topProducts = sales.stream()
                .filter(s -> s.getQuantity() > 10)
                .map(s -> new ProductSales(s.getProductId(), s.getQuantity() * s.getPrice()))
                .sorted((p1, p2) -> Double.compare(p2.totalRevenue, p1.totalRevenue))
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(topProducts);
    }
}*/

/*problem 3
 * import java.util.*;
import java.util.stream.Collectors;
class java8 {
    static class Book {
        String title;
        String author;
        String genre;
        double rating;
        Book(String title, String author, String genre, double rating) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.rating = rating;
        }
        public String getGenre() {
            return genre;
        }
        public double getRating() {
            return rating;
        }
        public String getTitle() {
            return title;
        }
    }
    static class BookRecommendation {
        String title;
        double rating;
        BookRecommendation(String title, double rating) {
            this.title = title;
            this.rating = rating;
        }
        @Override
        public String toString() {
            return title + " (" + rating + ")";
        }
    }
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.8),
                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.7),
                new Book("Neuromancer", "William Gibson", "Science Fiction", 4.2),
                new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 4.6),
                new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.9),
                new Book("The Left Hand of Darkness", "Ursula K. Le Guin", "Science Fiction", 4.1),
                new Book("1984", "George Orwell", "Dystopian", 4.5),
                new Book("The Martian", "Andy Weir", "Science Fiction", 4.8),
                new Book("Brave New World", "Aldous Huxley", "Dystopian", 4.3),
                new Book("The Moon is a Harsh Mistress", "Robert A. Heinlein", "Science Fiction", 4.4),
                new Book("Fahrenheit 451", "Ray Bradbury", "Dystopian", 4.0),
                new Book("The Road", "Cormac McCarthy", "Dystopian", 4.2)
        );
        List<BookRecommendation> recommendations = books.stream()
                .filter(b -> b.getGenre().equals("Science Fiction") && b.getRating() > 4.0)
                .map(b -> new BookRecommendation(b.getTitle(), b.getRating()))
                .sorted((b1, b2) -> Double.compare(b2.rating, b1.rating))
                .limit(10)
                .collect(Collectors.toList());
        int pageSize = 5;
        int pageNumber = 1; 
        List<BookRecommendation> paginatedResults = recommendations.stream()
                .skip((pageNumber - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
        System.out.println("Page " + pageNumber + ": " + paginatedResults);
    }
}*/

/*Problem 4
 * import java.util.*;
import java.util.stream.Collectors;
class java8 {
    static class Claim {
        int claimId;
        String policyNumber;
        double claimAmount;
        String claimDate;
        String status;
        Claim(int claimId, String policyNumber, double claimAmount, String claimDate, String status) {
            this.claimId = claimId;
            this.policyNumber = policyNumber;
            this.claimAmount = claimAmount;
            this.claimDate = claimDate;
            this.status = status;
        }
        public String getPolicyNumber() {
            return policyNumber;
        }
        public double getClaimAmount() {
            return claimAmount;
        }
        public String getStatus() {
            return status;
        }
    }
    static class PolicyClaimSummary {
        double totalClaimAmount;
        double averageClaimAmount;
        PolicyClaimSummary(double totalClaimAmount, double averageClaimAmount) {
            this.totalClaimAmount = totalClaimAmount;
            this.averageClaimAmount = averageClaimAmount;
        }
        @Override
        public String toString() {
            return "Total: $" + totalClaimAmount + ", Average: $" + averageClaimAmount;
        }
    }
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim(1, "P123", 6000, "2025-04-01", "Approved"),
                new Claim(2, "P124", 4500, "2025-04-02", "Denied"),
                new Claim(3, "P123", 7000, "2025-04-03", "Approved"),
                new Claim(4, "P125", 8000, "2025-04-04", "Approved"),
                new Claim(5, "P123", 5000, "2025-04-05", "Approved"),
                new Claim(6, "P125", 3000, "2025-04-06", "Denied"),
                new Claim(7, "P126", 15000, "2025-04-07", "Approved"),
                new Claim(8, "P124", 2000, "2025-04-08", "Denied")
        );
        Map<String, PolicyClaimSummary> result = claims.stream()
                .filter(c -> c.getStatus().equals("Approved") && c.getClaimAmount() > 5000)
                .collect(Collectors.groupingBy(
                        Claim::getPolicyNumber,
                        Collectors.summarizingDouble(Claim::getClaimAmount)
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> new PolicyClaimSummary(
                                entry.getValue().getSum(),
                                entry.getValue().getAverage()
                        )
                ));
        List<Map.Entry<String, PolicyClaimSummary>> topPolicies = result.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue().totalClaimAmount, e1.getValue().totalClaimAmount))
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(topPolicies);
    }
}*/

/*Problem 5
 * import java.util.*;
import java.util.stream.Collectors;
class java8 {
    static class PolicyHolder {
        int holderId;
        String name;
        int age;
        String policyType;
        double premiumAmount;
        PolicyHolder(int holderId, String name, int age, String policyType, double premiumAmount) {
            this.holderId = holderId;
            this.name = name;
            this.age = age;
            this.policyType = policyType;
            this.premiumAmount = premiumAmount;
        }
        public String getPolicyType() {
            return policyType;
        }
        public int getAge() {
            return age;
        }
        public double getPremiumAmount() {
            return premiumAmount;
        }
        public int getHolderId() {
            return holderId;
        }
        public String getName() {
            return name;
        }
    }
    static class RiskAssessment {
        int holderId;
        String name;
        double riskScore;
        RiskAssessment(int holderId, String name, double riskScore) {
            this.holderId = holderId;
            this.name = name;
            this.riskScore = riskScore;
        }
        @Override
        public String toString() {
            return name + " (ID: " + holderId + ", Risk Score: " + riskScore + ")";
        }
        public double getRiskScore() {
            return riskScore;
        }
    }
    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
                new PolicyHolder(1, "Alice", 65, "Life", 40000),
                new PolicyHolder(2, "Bob", 62, "Health", 30000),
                new PolicyHolder(3, "Charlie", 70, "Life", 20000),
                new PolicyHolder(4, "David", 80, "Life", 35000),
                new PolicyHolder(5, "Eva", 59, "Life", 28000),
                new PolicyHolder(6, "Frank", 66, "Life", 45000)
        );
        List<RiskAssessment> assessments = holders.stream()
                .filter(h -> h.getPolicyType().equals("Life") && h.getAge() > 60)
                .map(h -> new RiskAssessment(h.getHolderId(), h.getName(), h.getPremiumAmount() / h.getAge()))
                .sorted((r1, r2) -> Double.compare(r2.getRiskScore(), r1.getRiskScore()))
                .collect(Collectors.toList());
        Map<String, List<RiskAssessment>> categorized = assessments.stream()
                .collect(Collectors.groupingBy(r -> r.getRiskScore() > 0.5 ? "High Risk" : "Low Risk"));
        System.out.println(categorized);
    }
}*/

/*Problem 6
 * import java.util.*;
import java.util.stream.Collectors;
class java8 {
    static class Transaction {
        int transactionId;
        String policyNumber;
        double amount;
        String transactionDate;
        boolean isFraudulent;
        Transaction(int transactionId, String policyNumber, double amount, String transactionDate, boolean isFraudulent) {
            this.transactionId = transactionId;
            this.policyNumber = policyNumber;
            this.amount = amount;
            this.transactionDate = transactionDate;
            this.isFraudulent = isFraudulent;
        }
        public boolean isFraudulent() {
            return isFraudulent;
        }
        public double getAmount() {
            return amount;
        }
        public String getPolicyNumber() {
            return policyNumber;
        }
    }
    static class FraudStats {
        long count;
        double totalAmount;
        FraudStats(long count, double totalAmount) {
            this.count = count;
            this.totalAmount = totalAmount;
        }
        @Override
        public String toString() {
            return "Frauds: " + count + ", Total Amount: $" + totalAmount;
        }
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(1, "P001", 12000, "2025-04-01", true),
                new Transaction(2, "P001", 15000, "2025-04-02", true),
                new Transaction(3, "P001", 17000, "2025-04-03", true),
                new Transaction(4, "P001", 11000, "2025-04-04", true),
                new Transaction(5, "P001", 13000, "2025-04-05", true),
                new Transaction(6, "P001", 14000, "2025-04-06", true),
                new Transaction(7, "P002", 60000, "2025-04-01", true),
                new Transaction(8, "P002", 2000, "2025-04-02", false),
                new Transaction(9, "P003", 9500, "2025-04-01", true),
                new Transaction(10, "P004", 11000, "2025-04-03", true)
        );
        Map<String, FraudStats> stats = transactions.stream()
                .filter(t -> t.isFraudulent() && t.getAmount() > 10000)
                .collect(Collectors.groupingBy(
                        Transaction::getPolicyNumber,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> new FraudStats(
                                        list.size(),
                                        list.stream().mapToDouble(Transaction::getAmount).sum()
                                )
                        )
                ));
        Map<String, FraudStats> alerts = stats.entrySet().stream()
                .filter(e -> e.getValue().count > 5 || e.getValue().totalAmount > 50000)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(alerts);
    }
}*/

/*J Unit
 * 
 * import java.util.*;
import java.util.function.*;
import java.util.stream.*;
class java8 {
    @FunctionalInterface
    interface Sum {
        int add(int a, int b);
    }
    @FunctionalInterface
    interface Square {
        int calculate(int x);
        default void display(int x) {
            System.out.println("Square: " + calculate(x));
        }
    }
    static class Person {
        String name;
        int age;
        double salary;
        Person(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }
        @Override
        public String toString() {
            return name + " - Age: " + age + ", Salary: " + salary;
        }
    }
    public static void main(String[] args) {
        Sum sum = (a, b) -> a + b;
        System.out.println("Sum: " + sum.add(10, 20));
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Alex", "Charlie");
        List<String> filteredNames = names.stream()
                .filter(s -> !s.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Filtered Names: " + filteredNames);
        List<Person> persons = Arrays.asList(
                new Person("John", 25, 50000),
                new Person("Jane", 22, 60000),
                new Person("Mike", 28, 55000)
        );
        persons.sort(Comparator.comparingInt(p -> p.age));
        System.out.println("Sorted Persons: " + persons);
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sumSquares = nums.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println("Sum of squares of even numbers: " + sumSquares);
        Predicate<String> longerThan5 = s -> s.length() > 5;
        Predicate<String> containsSub = s -> s.contains("test");
        List<String> words = Arrays.asList("testcase", "example", "testing", "java", "functionaltest");
        List<String> filtered = words.stream()
                .filter(longerThan5.and(containsSub))
                .collect(Collectors.toList());
        System.out.println("Filtered by predicate: " + filtered);
        Consumer<String> printer = s -> System.out.println(s.toUpperCase());
        List<String> list = Arrays.asList("one", "two", "three");
        list.forEach(printer);
        Function<Double, Double> circleArea = r -> Math.PI * r * r;
        System.out.println("Area of circle: " + circleArea.apply(5.0));
        BiFunction<String, String, String> concat = (s1, s2) -> s1 + " " + s2;
        System.out.println("Concatenated: " + concat.apply("Hello", "World"));
        Square square = x -> x * x;
        square.display(7);
        List<Integer> numbers = Arrays.asList(10, 20, 30, 5);
        Optional<Integer> max = numbers.stream().max(Integer::compare);
        max.ifPresentOrElse(
                m -> System.out.println("Max: " + m),
                () -> System.out.println("List is empty")
        );
    }
}*/

/*import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.nio.file.*;
class java8 {
    static class Policy {
        String policyNumber;
        String holderName;
        double premiumAmount;
        Policy(String policyNumber, String holderName, double premiumAmount) {
            this.policyNumber = policyNumber;
            this.holderName = holderName;
            this.premiumAmount = premiumAmount;
        }
        @Override
        public String toString() {
            return policyNumber + " | " + holderName + " | $" + premiumAmount;
        }
    }
    public static void main(String[] args) throws Exception {
        List<Policy> policies = Arrays.asList(
                new Policy("P101", "Alice Smith", 1500),
                new Policy("P102", "Bob Johnson", 950),
                new Policy("P103", "Charlie Smith", 1800),
                new Policy("P104", "David Brown", 2100),
                new Policy("P105", "Eva Adams", 1200),
                new Policy("P106", "Smith Williams", 2200),
                new Policy("P107", "John Smith", 1100)
        );
        List<Policy> filtered1 = policies.stream()
                .filter(p -> p.premiumAmount > 1200)
                .collect(Collectors.toList());
        List<Policy> sortedByName = policies.stream()
                .sorted(Comparator.comparing(p -> p.holderName))
                .collect(Collectors.toList());
        double totalPremium = policies.stream()
                .mapToDouble(p -> p.premiumAmount)
                .sum();
        policies.forEach(p -> System.out.println(p));
        List<Policy> filtered2 = policies.stream()
                .filter(p -> p.premiumAmount >= 1000 && p.premiumAmount <= 2000)
                .collect(Collectors.toList());
        Optional<Policy> maxPremiumPolicy = policies.stream()
                .max(Comparator.comparingDouble(p -> p.premiumAmount));
        Map<Character, List<Policy>> groupedByInitial = policies.stream()
                .collect(Collectors.groupingBy(p -> p.holderName.charAt(0)));
        double avgPremium = policies.stream()
                .mapToDouble(p -> p.premiumAmount)
                .average()
                .orElse(0.0);
        List<Policy> sortedByPremium = policies.stream()
                .sorted(Comparator.comparingDouble(p -> p.premiumAmount))
                .collect(Collectors.toList());
        boolean anyExceeds2000 = policies.stream()
                .anyMatch(p -> p.premiumAmount > 2000);
        Map<String, Long> rangeCount = policies.stream()
                .collect(Collectors.groupingBy(p -> {
                    if (p.premiumAmount <= 1000) return "$0-$1000";
                    else if (p.premiumAmount <= 2000) return "$1001-$2000";
                    else return ">$2000";
                }, Collectors.counting()));
        Set<String> uniqueNames = policies.stream()
                .map(p -> p.holderName)
                .collect(Collectors.toSet());
        List<Policy> smithPolicies = policies.stream()
                .filter(p -> p.holderName.contains("Smith"))
                .collect(Collectors.toList());
        Map<String, Double> policyMap = policies.stream()
                .collect(Collectors.toMap(p -> p.policyNumber, p -> p.premiumAmount));
        String corpus = Files.readString(Path.of("data.txt"));
        List<String> words = Arrays.stream(corpus.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+"))
                .collect(Collectors.toList());

        Map<String, Long> freqMap = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Map.Entry<String, Long>> topWords = freqMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toList());
        topWords.forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        Optional<String> secondMost = freqMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .skip(1)
                .map(Map.Entry::getKey)
                .findFirst();
        secondMost.ifPresent(w -> System.out.println("Second most frequent word: " + w));
    }
}*/
