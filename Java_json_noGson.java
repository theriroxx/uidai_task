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


public class Java_json_noGson
{


}
