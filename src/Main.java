import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Integer five = 5;
        Integer[] others = {0, 5, 10, -50, 50};

        for (Integer i : others) {
            int val = five.compareTo(i); // Comparable interface method
            System.out.printf("%d %s %d %s %d\n", five, " compareTo ", i, " RESULT: ", val);
        }

        String banana = "banana";
        String[] fruit = {"apple", "banana", "pear", "BANANA"};

        for (String i: fruit){
            int val = banana.compareTo(i);
            System.out.println(val);
        }

        Arrays.sort(fruit);
        System.out.println(Arrays.toString(fruit));
        // char are stored in memory as positive integer values
        System.out.println("A:" + (int) 'A' + " a:" + (int) 'a');
        System.out.println("B:" + (int) 'B' + " b:" + (int) 'b');
        System.out.println("C:" + (int) 'C' + " c:" + (int) 'c');
        // When we use compareTo method to compare two Strings,
        // we're really comparing integer values of the characters in the string.

        Student tim = new Student("Tim");
        Student[] students = {new Student("Zach"), new Student("Tim"), new Student("Ann"), new Student("Ann")};

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
        System.out.println(tim.compareTo(tim));

        System.out.println("-".repeat(20));
        Comparator<Student> gpaSorter = new StudentGPAComparator();
        // Arrays.sort(array, comparator)

        Arrays.sort(students, gpaSorter.reversed());
        System.out.println(Arrays.toString(students));

    }
}

class Student implements Comparable<Student>{
    private static int LAST_ID = 1000;
    private static Random random = new Random();
    protected String name;
    private int id;
    protected double gpa;

    public Student ( String name){
        id = LAST_ID++;
        this.name = name;
        gpa = random.nextDouble(1.0, 4.0);

    }

    @Override
    public String toString(){
        return "%d - %s (%.2f)".formatted(id, name, gpa);
    }

    @Override
    public int compareTo(Student o){
//        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }


}

class StudentGPAComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }
}