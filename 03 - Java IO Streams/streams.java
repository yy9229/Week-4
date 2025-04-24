/*
 * Problem 1
 * import java.io.*;
public class streams {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";
        try {
            File src = new File(sourceFile);
            if (!src.exists()) {
                System.out.println("Source file does not exist.");
                return;
            }
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(destinationFile);
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
            fis.close();
            fos.close();
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}*/

/*
 * Problem 2
 * import java.io.*;
public class streams {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String bufferedDest = "bufferedCopy.txt";
        String unbufferedDest = "unbufferedCopy.txt";
        final int BUFFER_SIZE = 4096;
        long startBuffered = System.nanoTime();
        try (
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(bufferedDest))
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            bos.flush();
        } catch (IOException e) {
            System.out.println("Buffered Copy Error: " + e.getMessage());
        }
        long endBuffered = System.nanoTime();
        System.out.println("Buffered copy time: " + (endBuffered - startBuffered) / 1_000_000 + " ms");
        long startUnbuffered = System.nanoTime();
        try (
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(unbufferedDest)
        ) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            fos.flush();
        } catch (IOException e) {
            System.out.println("Unbuffered Copy Error: " + e.getMessage());
        }
        long endUnbuffered = System.nanoTime();
        System.out.println("Unbuffered copy time: " + (endUnbuffered - startUnbuffered) / 1_000_000 + " ms");
    }
}*/

/*
 * Problem 3
 * import java.io.*;
public class streams {
    public static void main(String[] args) {
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your name: ");
            String name = reader.readLine();
            System.out.print("Enter your age: ");
            String age = reader.readLine();
            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();
            writer = new FileWriter("userInfo.txt");
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");
            System.out.println("User information saved to userInfo.txt");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
*/

/*
 * import java.io.*;
import java.util.*;
class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double salary;
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee [ID: " + id + ", Name: " + name +
                ", Dept: " + department + ", Salary: ₹" + salary + "]";
    }
}
public class streams {
    public static void main(String[] args) {
        String filename = "employees.ser";
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Alice", "HR", 45000));
        employeeList.add(new Employee(2, "Bob", "IT", 55000));
        employeeList.add(new Employee(3, "Charlie", "Sales", 50000));
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employeeList);
            System.out.println("✅ Employee list has been serialized to " + filename);
        } catch (IOException e) {
            System.out.println("❌ Serialization error: " + e.getMessage());
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Employee> deserializedList = (List<Employee>) ois.readObject();
            System.out.println("\n📋 Deserialized Employee List:");
            for (Employee emp : deserializedList) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("❌ Deserialization error: " + e.getMessage());
        }
    }
}*/

/*
 * Problem 5
 * import java.io.*;
public class streams {
    public static void main(String[] args) {
        String sourceImage = "original.jpg";    
        String targetImage = "copied.jpg";    
        try {
            FileInputStream fis = new FileInputStream(sourceImage);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            fis.close();
            byte[] imageBytes = baos.toByteArray();
            System.out.println(" Image successfully converted to byte array.");
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(targetImage);
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            fos.close();
            bais.close();
            System.out.println(" Image written successfully to: " + targetImage);
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}*/

/*
 * Problem 6
 * import java.io.*;
public class streams {
    public static void main(String[] args) {
        String inputFile = "input.txt";  
        String outputFile = "output.txt"; 
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine(); 
            }
            System.out.println("Conversion complete. Output saved to " + outputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + inputFile);
        } catch (IOException e) {
            System.out.println(" IO Error: " + e.getMessage());
        }
    }
}*/

/*
 * Problem 7
 * import java.io.*;
public class streams {
    public static void main(String[] args) {
        String fileName = "student.dat";
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(8.5);
            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(7.9);
            dos.writeInt(103);
            dos.writeUTF("Charlie");
            dos.writeDouble(9.2);
            System.out.println("Student data written to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("\nReading student records:");
            while (dis.available() > 0) {
                int rollNo = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNo + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading from file: " + e.getMessage());
        }
    }
}*/

/*
 * Problem 8
 * import java.io.*;
class WriterThread extends Thread {
    private PipedOutputStream output;
    public WriterThread(PipedOutputStream output) {
        this.output = output;
    }
    public void run() {
        try {
            String message = "Hello from WriterThread!";
            output.write(message.getBytes());
            output.close();
        } catch (IOException e) {
            System.out.println("❌ Writer error: " + e.getMessage());
        }
    }
}
class ReaderThread extends Thread {
    private PipedInputStream input;
    public ReaderThread(PipedInputStream input) {
        this.input = input;
    }
    public void run() {
        try {
            int data;
            System.out.print("Reader received: ");
            while ((data = input.read()) != -1) {
                System.out.print((char) data);
            }
            input.close();
        } catch (IOException e) {
            System.out.println("Reader error: " + e.getMessage());
        }
    }
}
public class streams {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);
            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);
            writer.start();
            reader.start();
            writer.join();
            reader.join();
        } catch (IOException | InterruptedException e) {
            System.out.println("Main error: " + e.getMessage());
        }
    }
}*/

/*
 * Problem 9
 * import java.io.*;
public class streams {
    public static void main(String[] args) {
        String filePath = "largefile.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}*/

/*
 * Problem 10
 * import java.io.*;
import java.util.*;
public class streams {
    public static void main(String[] args) {
        String filePath = "input.txt";
        Map<String, Integer> wordCount = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
            sortedList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
            System.out.println("Top 5 frequent words:");
            for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
                Map.Entry<String, Integer> entry = sortedList.get(i);
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}*/
