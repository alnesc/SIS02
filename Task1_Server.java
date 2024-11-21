import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Task1_Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8000);
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connect");

        ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());
        ObjectOutputStream output = new ObjectOutputStream(clientSocket.getOutputStream());

        while (true) {
            Object obj = input.readObject();

            if (obj == null) {
                System.out.println("Client out.");
                break;
            }

            if (obj instanceof Cube) {
                Cube cube = (Cube) obj;
                String response = "Volume: " + cube.volume() + ", Surface Area: " + cube.surfaceArea();
                System.out.println("Client requested Cube with edge " + cube.getParams()+" Answer is:"+cube.surfaceArea());
                output.writeObject(response);
            }

            else if (obj instanceof Sphere) {
                Sphere sphere = (Sphere) obj;
                System.out.println("Client requested Sphere with edge " + sphere.getParams()+" Answer is:"+sphere.surfaceArea());
                String response = "Volume: " + sphere.volume() + ", Surface Area: " + sphere.surfaceArea();
                output.writeObject(response);
            }
            else {
                System.out.println("Error");
                output.writeObject("Error, Unknown object not found");
            }

            output.flush();
        }

        input.close();
        output.close();
        clientSocket.close();
        serverSocket.close();
    }
}