import java.util.HashMap;

public class Student {
    String name;
    int phone;

    int group;

    public Student(String name, int phone, int group) {
        this.name = name;
        this.phone = phone;
        this.group = group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public int getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return group + " - " + name + ": " + phone;
    }
}
