import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Task1_Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket clientSocket = new Socket("localhost", 8000);
        ObjectOutputStream output = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter name (Cube, Sphere): ");
            String objectType = scanner.nextLine();

            if (objectType.equals("Q")) {
                output.writeObject(null);
                output.flush();
                break;
            }

            try {
                switch (objectType.toLowerCase()) {
                    case "cube":
                        System.out.print("Enter number ");
                        double a = Double.parseDouble(scanner.nextLine());
                        Cube cube = new Cube(a);
                        output.writeObject(cube);
                        break;

                    case "sphere":
                        System.out.print("Enter number: ");
                        double r = Double.parseDouble(scanner.nextLine());
                        Sphere sphere = new Sphere(r);
                        output.writeObject(sphere);
                        break;

                    default:
                        System.out.println("Not found");
                        continue;
                }

                output.flush();
                String serverMessage = (String) input.readObject();
                System.out.println("Server : " + serverMessage);
            } catch (NumberFormatException e) {
                System.out.println("Error");
            }
        }
        System.out.println("You r left");
        input.close();
        output.close();
        clientSocket.close();
        scanner.close();
    }
}