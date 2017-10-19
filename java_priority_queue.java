import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Comparator;
class Student {
	private int id;
	private String name;
	private double cgpa;
	public Student(int id, String name, double cgpa) {
		super();
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getCGPA() {
		return cgpa;
	} 
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> q = new PriorityQueue<>(
    Comparator.comparing(Student::getCGPA).reversed()
    .thenComparing(Student::getName)
    .thenComparing(Student::getID)
    );
        for(String event: events) {
        if(event.equals("SERVED")){
				q.poll();
			}else{
				String[] details = event.split(" ");
				q.add(new Student(Integer.parseInt(details[3]),details[1],Double.parseDouble(details[2])));
			}
        }
        ArrayList<Student> ans = new ArrayList<>();
        while(q.peek() != null) {
            Student stu = q.poll();
            ans.add(stu);
        }
        return ans;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}