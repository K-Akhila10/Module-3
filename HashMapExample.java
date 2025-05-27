import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student ID and name (type -1 to stop):");
        while (true) {
            int id = sc.nextInt();
            if (id == -1) break;
            sc.nextLine(); // consume newline
            String name = sc.nextLine();
            studentMap.put(id, name);
        }
        System.out.print("Enter ID to retrieve name: ");
        int id = sc.nextInt();
        System.out.println("Name: " + studentMap.getOrDefault(id, "Not found"));
    }
}
