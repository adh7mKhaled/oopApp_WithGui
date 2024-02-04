package Main;
import java.io.*;

public class readAndWrite {
    private contactList acToContacts;

    public readAndWrite(contactList acToContacts) {
        this.acToContacts = acToContacts;
    }

    public void saveDataToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt"))) {
            for (Contact contact : acToContacts.contacts) {
                writer.println(contact.getName() + "," + contact.getEmail() + "," + contact.getPhoneNumber());   // used println to Write in text and add newLine after write
            }
            System.out.println("Data has been saved to data.txt");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void readDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {  //try and catch because BufferedReader may throw exception
            String line;
            while ((line = reader.readLine()) != null) {      //read line by line from textFile
                String[] data = line.split(",");
                    String name = data[0];
                    String email = data[1];
                    String phoneNumber = data[2];
                    acToContacts.contacts.add(new Contact(name, email, phoneNumber));
            }
            System.out.println("Data has been read from data.txt");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}

