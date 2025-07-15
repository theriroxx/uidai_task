import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class Person {
    private String name;
    private int age;
    private double balance;
    private String interests;

    public Person(String name, int age, double balance, String interests) {
        this.name = name;
        this.age = age;
        this.balance = balance;
        this.interests = interests;
    }

    public String getName() {
    return name;
    }
    public double getBalance() {
        return balance;
    }
    public String getInterests() {
        return interests;
    }
    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setInterests(String interests) {
        this.interests = interests;
    }
    public void setAge(int age) {
        this.age = age;
    }

}

public class Java_json
{

    void PeoplestoJSON(List<Person> peoples)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("people.json")) {
            gson.toJson(peoples, writer);
            System.out.println("Data saved to people.json");
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        List<Person> peoples = new ArrayList<>();
        try(FileReader reader = new FileReader("people.json")) {
            Gson gson = new Gson();
            Person[] peopleArray = gson.fromJson(reader, Person[].class);
            for (Person person : peopleArray) {
                peoples.add(person);
            }
        } catch (IOException e) {
            System.out.println("No existing data found, starting fresh.");
        }


        Java_json javajson = new Java_json();
        System.out.println("Enter the number of people:");
        int n = scn.nextInt();
        while (n-- > 0) {
            System.out.println("Enter name, age, balance, interests: ");
            scn.nextLine(); // Consume the newline character left by nextInt()

            String name = scn.nextLine();

            int age = scn.nextInt();

            double balance = scn.nextDouble();
            scn.nextLine(); // Consume the newline character left by nextDouble()
            
            String interests = scn.nextLine();
            Person person = new Person(name, age, balance, interests);
            peoples.add(person);
            System.out.println("Person added: " + person.getName() + ", Age: " + person.getAge() + ", Balance: " + person.getBalance() + ", Interests: " + person.getInterests());
        }
        System.out.println("People added:");
        javajson.PeoplestoJSON(peoples);
        scn.close();
    }
}
