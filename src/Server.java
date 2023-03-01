import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)){
            System.out.println("Сервер запущен ");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            University university = new University();
            while (true){
                String clientReqest = dataInputStream.readUTF();

                if("1".equals(clientReqest)){
                    String name = clientReqest;
                    int phone = Integer.parseInt(clientReqest);
                    int groupe = Integer.parseInt(clientReqest);
                    university.addStudents(name, phone, groupe);
                    dataOutputStream.writeUTF("Добавил");
                }
                if("2".equals(clientReqest)){
                    String name = clientReqest;
                    int groupe = Integer.parseInt(clientReqest);
                    university.remStudent(name, groupe);
                }
                if("3".equals(clientReqest)){
                    int groupe = Integer.parseInt(clientReqest);
                    String str = university.prijntGroupList(groupe);
                    dataOutputStream.writeUTF(str);
                }

                if("end".equals(clientReqest)) break;


                System.out.println("Клиент прислал "+clientReqest);
                dataOutputStream.writeUTF("Ответ клиенту "+clientReqest);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
