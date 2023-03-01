import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String request;
        try {
            Socket socket = new Socket("localhost", 1234);
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            while (true){
                System.out.println("1 - Добавить студента \n"+
                        " 2 - Отчислить \n" +
                        " 3 - Посмотреть студентов группы \n" +
                "end - Закончить работу" );
                request = scanner.nextLine();
                if (request.equals("1")){
                    dataOutputStream.writeUTF(request);
                    System.out.println("Введите Имя");
                    String name1 = scanner.nextLine();
                    dataOutputStream.writeUTF(name1);
                    System.out.println("Введите Телефон");
                    int phone1 = scanner.nextInt();
                    dataOutputStream.writeUTF(String.valueOf(phone1));
                    System.out.println("Введите Номер группы");
                    int group1 = scanner.nextInt();
                    dataOutputStream.writeUTF(String.valueOf(group1));
                    System.out.println("Добавлен");
                }
                if (request.equals("2")){
                    dataOutputStream.writeUTF(request);
                    System.out.println("Введите Имя");
                    String name1 = scanner.nextLine();
                    dataOutputStream.writeUTF(name1);

                    System.out.println("Введите Номер группы");
                    int group1 = scanner.nextInt();
                    dataOutputStream.writeUTF(String.valueOf(group1));
                    System.out.println("Отчислен ");
                }
                if (request.equals("3")){
                    dataOutputStream.writeUTF(request);
                    System.out.println("Введите Номер группы");
                    int group1 = scanner.nextInt();
                    dataOutputStream.writeUTF(String.valueOf(group1));
                }
                if("end".equals(request)) break;
                System.out.println(dataInputStream.readUTF());

            }


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }


    }
}
