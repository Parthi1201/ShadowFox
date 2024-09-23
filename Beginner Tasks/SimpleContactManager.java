import java.util.ArrayList;
import java.util.Scanner;

class Contact{
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email){
        this.name=name;
        this.phone=phone;
        this.email=email;
    }
    @Override
    public String toString(){
        return "Name:"+name+"\nPhone:"+phone+"\nEmail:"+email;
    }
}

public class SimpleContactManager{
    private static ArrayList<Contact> contacts=new ArrayList<>();
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        while(true){
            System.out.println("Contact Management System: \n 1.Add Contact \n 2.View Contacts \n 3.Update Contact \n 4.Delete Contact \n 5.Exit");
            System.out.print("Choose an option:");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!! \n Try again");
            }
        }
    }

    private static void addContact(){
        System.out.print("Enter Name:");
        String name = sc.nextLine();
        System.out.print("Enter Phone:");
        String phone=sc.nextLine();
        System.out.print("Enter Email:");
        String email=sc.nextLine();
        contacts.add(new Contact(name,phone,email));
        System.out.println("Contact added!!");
    }

    private static void viewContacts(){
        if(contacts.isEmpty()){
            System.out.println("No contacts available.");
        } else{
            for (int i=0;i<contacts.size();i++){
                System.out.println((i + 1)+"."+contacts.get(i));
            }
        }
    }

    private static void updateContact(){
        if(contacts.isEmpty()){
            System.out.println("No contacts available.");
        } 
        else{
            System.out.print("Select the Serial Number of the contact to update:\n");
            for (int i=0;i<contacts.size();i++){
                System.out.println((i + 1)+"."+contacts.get(i));
            }
        int index = sc.nextInt()-1;
        sc.nextLine();
        if(index>=0 && index<contacts.size()){
            System.out.print("Enter new Name:");
            contacts.get(index).name=sc.nextLine();
            System.out.print("Enter new Phone:");
            contacts.get(index).phone=sc.nextLine();
            System.out.print("Enter new Email:");
            contacts.get(index).email=sc.nextLine();
            System.out.println("Contact updated!");
        } 
        else{
            System.out.println("Invalid contact number.");
        }
        }
    }

    private static void deleteContact(){
        if(contacts.isEmpty()){
            System.out.println("No contacts available.");
        }
        else{
            System.out.print("Select the Serial Number of the contact to delete:\n");
            for (int i=0;i<contacts.size();i++){
                System.out.println((i + 1)+"."+contacts.get(i));
            }
        int index=sc.nextInt()-1;
        if (index>=0 && index<contacts.size()){
            contacts.remove(index);
            System.out.println("Contact deleted!");
        } 
        else{
            System.out.println("Invalid contact number.");
        }
        }
    }
}
