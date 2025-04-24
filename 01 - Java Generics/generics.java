/*
Problem 1
import java.util.ArrayList;
import java.util.List;
abstract class WarehouseItem {
   private String name;
   public WarehouseItem(String name) {
       this.name = name;
   }
   public String getName() {
       return name;
   }
   @Override
   public String toString() {
       return name;
   }
}
class Electronics extends WarehouseItem {
   public Electronics(String name) {
       super(name);
   }
}
class Groceries extends WarehouseItem {
   public Groceries(String name) {
       super(name);
   }
}
class Furniture extends WarehouseItem {
   public Furniture(String name) {
       super(name);
   }
}
class Storage<T extends WarehouseItem> {
   private List<T> items;
   public Storage() {
       items = new ArrayList<>();
   }
   public void addItem(T item) {
       items.add(item);
   }
   public List<T> getItems() {
       return items;
   }
   public void displayItems() {
       for (T item : items) {
           System.out.println(item);
       }
   }
}
class WarehouseUtils {
   public static void displayAllItems(List<? extends WarehouseItem> items) {
       for (WarehouseItem item : items) {
           System.out.println(item);
       }
   }
}
public class generics {
   public static void main(String[] args) {
       Storage<Electronics> electronicsStorage = new Storage<>();
       Storage<Groceries> groceriesStorage = new Storage<>();
       Storage<Furniture> furnitureStorage = new Storage<>();
       electronicsStorage.addItem(new Electronics("Laptop"));
       electronicsStorage.addItem(new Electronics("Smartphone"));
       groceriesStorage.addItem(new Groceries("Apple"));
       groceriesStorage.addItem(new Groceries("Milk"));
       furnitureStorage.addItem(new Furniture("Sofa"));
       furnitureStorage.addItem(new Furniture("Chair"));
       System.out.println("Electronics Storage:");
       electronicsStorage.displayItems();
       System.out.println("\nGroceries Storage:");
       groceriesStorage.displayItems();
       System.out.println("\nFurniture Storage:");
       furnitureStorage.displayItems();
       System.out.println("\nAll Items in Storage:");
       WarehouseUtils.displayAllItems(electronicsStorage.getItems());
       WarehouseUtils.displayAllItems(groceriesStorage.getItems());
       WarehouseUtils.displayAllItems(furnitureStorage.getItems());
   }
}*/

/*
Problem 2
import java.util.ArrayList;
import java.util.List;
interface Category {
    String getCategoryName();
}
enum BookCategory implements Category {
    FICTION, NON_FICTION, EDUCATIONAL;
    public String getCategoryName() {
        return this.name();
    }
}
enum ClothingCategory implements Category {
    MENS, WOMENS, KIDS;
    public String getCategoryName() {
        return this.name();
    }
}
enum GadgetCategory implements Category {
    MOBILE, LAPTOP, ACCESSORY;
    public String getCategoryName() {
        return this.name();
    }
}
class Product<T extends Category> {
    private String name;
    private double price;
    private T category;
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public T getCategory() {
        return category;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void display() {
        System.out.println("Product: " + name + ", Category: " + category.getCategoryName() + ", Price: ₹" + price);
    }
}
class DiscountUtil {
    public static <T extends Category> void applyDiscount(Product<T> product, double percentage) {
        double discount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discount);
        System.out.println("Applied " + percentage + "% discount on " + product.getName());
    }
}
public class generics {
    public static void main(String[] args) {
        // Create products
        Product<BookCategory> book = new Product<>("Java Programming", 500.0, BookCategory.EDUCATIONAL);
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 999.0, ClothingCategory.MENS);
        Product<GadgetCategory> phone = new Product<>("Smartphone", 15000.0, GadgetCategory.MOBILE);
        List<Product<? extends Category>> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);
        System.out.println("== Catalog Before Discount ==");
        for (Product<? extends Category> p : catalog) {
            p.display();
        }
        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(shirt, 20);
        DiscountUtil.applyDiscount(phone, 15);
        System.out.println("\n== Catalog After Discount ==");
        for (Product<? extends Category> p : catalog) {
            p.display();
        }
    }
}*/

/*
Problem 3
import java.util.ArrayList;
import java.util.List;
abstract class CourseType {
    private String name;
    public CourseType(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract void evaluate();
}
class ExamCourse extends CourseType {
    public ExamCourse(String name) {
        super(name);
    }
    @Override
    public void evaluate() {
        System.out.println(getName() + " is evaluated through Exams.");
    }
}
class AssignmentCourse extends CourseType {
    public AssignmentCourse(String name) {
        super(name);
    }
    @Override
    public void evaluate() {
        System.out.println(getName() + " is evaluated through Assignments.");
    }
}
class ResearchCourse extends CourseType {
    public ResearchCourse(String name) {
        super(name);
    }
    @Override
    public void evaluate() {
        System.out.println(getName() + " is evaluated through Research work.");
    }
}
class Course<T extends CourseType> {
    private T courseType;
    public Course(T courseType) {
        this.courseType = courseType;
    }
    public T getCourseType() {
        return courseType;
    }
    public void displayInfo() {
        System.out.print("Course: ");
        courseType.evaluate();
    }
}
class CourseManager {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType c : courses) {
            c.evaluate();
        }
    }
}
public class generics {
    public static void main(String[] args) {
        Course<ExamCourse> math = new Course<>(new ExamCourse("Mathematics"));
        Course<AssignmentCourse> english = new Course<>(new AssignmentCourse("English Literature"));
        Course<ResearchCourse> ai = new Course<>(new ResearchCourse("Artificial Intelligence"));
        System.out.println("== Individual Courses ==");
        math.displayInfo();
        english.displayInfo();
        ai.displayInfo();
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(new ExamCourse("Physics"));
        allCourses.add(new AssignmentCourse("Sociology"));
        allCourses.add(new ResearchCourse("Machine Learning"));
        System.out.println("\n== All Courses List ==");
        CourseManager.displayAllCourses(allCourses);
    }
}*/
/*
problem 4
interface MealPlan {
    String getMealInfo();
}
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealInfo() {
        return "Vegetarian Meal: Salad, Paneer, Rice";
    }
}
class VeganMeal implements MealPlan {
    @Override
    public String getMealInfo() {
        return "Vegan Meal: Tofu, Quinoa, Mixed Vegetables";
    }
}
class KetoMeal implements MealPlan {
    @Override
    public String getMealInfo() {
        return "Keto Meal: Eggs, Cheese, Avocados";
    }
}
class HighProteinMeal implements MealPlan {
    @Override
    public String getMealInfo() {
        return "High-Protein Meal: Chicken, Lentils, Protein Shake";
    }
}
class Meal<T extends MealPlan> {
    private T meal;
    public Meal(T meal) {
        this.meal = meal;
    }
    public void showMealPlan() {
        System.out.println(meal.getMealInfo());
    }
    public T getMeal() {
        return meal;
    }
}
class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T meal) {
        System.out.println("Generating a personalized meal plan...");
        return new Meal<>(meal);
    }
}
public class generics {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = MealPlanGenerator.generateMealPlan(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = MealPlanGenerator.generateMealPlan(new VeganMeal());
        Meal<KetoMeal> ketoMeal = MealPlanGenerator.generateMealPlan(new KetoMeal());
        Meal<HighProteinMeal> proteinMeal = MealPlanGenerator.generateMealPlan(new HighProteinMeal());
        System.out.println("\n--- Personalized Meal Plans ---");
        vegMeal.showMealPlan();
        veganMeal.showMealPlan();
        ketoMeal.showMealPlan();
        proteinMeal.showMealPlan();
    }
}*/

/*
Problem 5
import java.util.*;
abstract class JobRole {
    abstract String getRequiredSkills();
    abstract String getRoleName();
}
class SoftwareEngineer extends JobRole {
    @Override
    public String getRequiredSkills() {
        return "Java, DSA, System Design";
    }
    @Override
    public String getRoleName() {
        return "Software Engineer";
    }
}
class DataScientist extends JobRole {
    @Override
    public String getRequiredSkills() {
        return "Python, Statistics, Machine Learning";
    }
    @Override
    public String getRoleName() {
        return "Data Scientist";
    }
}
class ProductManager extends JobRole {
    @Override
    public String getRequiredSkills() {
        return "Communication, Agile, Product Roadmaps";
    }
    @Override
    public String getRoleName() {
        return "Product Manager";
    }
}
class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;
    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }
    public void displayResume() {
        System.out.println("Candidate: " + candidateName);
        System.out.println("Applying for: " + jobRole.getRoleName());
        System.out.println("Required Skills: " + jobRole.getRequiredSkills());
    }
    public T getJobRole() {
        return jobRole;
    }
}
class ResumeScreeningSystem {
    public static void screenResumes(List<? extends JobRole> jobRoles) {
        System.out.println("\n--- Screening Resumes ---");
        for (JobRole role : jobRoles) {
            System.out.println("Screening for role: " + role.getRoleName());
            System.out.println("Required skills: " + role.getRequiredSkills());
            System.out.println();
        }
    }
}
public class generics {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> r1 = new Resume<>("Alice", new SoftwareEngineer());
        Resume<DataScientist> r2 = new Resume<>("Bob", new DataScientist());
        Resume<ProductManager> r3 = new Resume<>("Charlie", new ProductManager());
        r1.displayResume();
        System.out.println();
        r2.displayResume();
        System.out.println();
        r3.displayResume();
        List<JobRole> roles = Arrays.asList(new SoftwareEngineer(), new DataScientist(), new ProductManager());
        ResumeScreeningSystem.screenResumes(roles);
    }
}*/
