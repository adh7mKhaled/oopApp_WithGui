package Main;
import java.util.ArrayList;
import java.util.Scanner;

 class contactList {
    ArrayList<Contact> contacts;

    public contactList() {
        contacts = new ArrayList<>();
    }

    public Object[] ReturnData(int i) {  //return objects from arrayList(contacts)
        return new Object[]{ contacts.get(i).getName(), contacts.get(i).getEmail(), contacts.get(i).getPhoneNumber()};
    }

//    public void shown () {
//       String action;
//       do{
//           action = in.nextLine();
//            switch(action) {
//                case "add contact" -> addNewContact();
////                case "Search for a specific contact" -> searchForSpecificContact();
//                case "remove contact" -> removeContactByName();
//                case "printAllContacts" -> System.out.println(getContacts());
//            }
//       }while (!action.equalsIgnoreCase("exit"));
//    }
//
//    public ArrayList<Contact> getContacts() {
//        return contacts;
//    }
//
//    public void addNewContact() {
//        Contact newcontact = new Contact();
//        this.setData(newcontact);
//    }
//
//    public void removeContactByName() {
//        Contact contactToRemove = findContactByName();
//        if(contactToRemove != null) {
//            contacts.remove(contactToRemove);
//            System.out.println("Contact removed successfully.");
//        }
//        else
//            System.out.println("Contact not found.");
//    }
//
////    public void searchForSpecificContact() {
////        if(findContactByName() != null) {
////            Contact curContact =  findContactByName();
////            System.out.println("this contact is found : ");
////            initObject(curContact);
////        }
////        else
////            System.out.println("This contact is not found");
////    }
////
////    //display methode use to display all objects in arraylist
////    public void displayAllContacts() {
////        for (Contact contact : contacts)
////            initObject(contact);
////    }
//
//    public void setData(Contact newContact) {
////        System.out.println("Enter your name : ");
//        newContact.setName(in.nextLine());
////        System.out.println("Enter phone number");
//        newContact.setPhoneNumber(in.nextLine());
////        System.out.println("Enter email");
//        newContact.setEmail(in.nextLine());
//        this.contacts.add(newContact);
//    }
//
//    public Contact findContactByName() {
//        System.out.println("Enter name : ");
//        String name = in.nextLine();
//        for (Contact contact : contacts) {
//            if (contact.getName().equalsIgnoreCase(name))
//                return contact; // contact founded
//        }
//        return null; //contact not found
//    }


}

