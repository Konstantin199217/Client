import java.util.ArrayList;

public class University {
    ArrayList<Student> list = new ArrayList<>();

    public void addStudents(String name, int phone, int group) {
        Student st = new Student(name, phone, group);
        list.add(st);
    }

    public void remStudent(String name, int group) {
        boolean result = false;
        for (Student st : list) {
            if (st.getName().equals(name) && st.getGroup() == group) {
                list.remove(st);
                result = true;
                break;
            }
        }
        if (result) {
            System.out.println("Отчислен");
        } else {
            System.out.println("Нет таких студентов");
        }
    }

    public String prijntGroupList(int group) {
        ArrayList<String> str = new ArrayList<String>();
        for (Student st : list) {
            if (st.getGroup() == group){
                str.add(st.getName() + " " + st.getPhone());
            }
        }
        return String.valueOf(str);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}


