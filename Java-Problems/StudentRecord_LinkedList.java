import java.util.Scanner;

class Link {
    String name;
    int age;
    String degree;
    int yearOfStudy;
    Link next;  

  
    public Link(String name, int age, String degree, int yearOfStudy) {
        this.name = name;
        this.age = age;
        this.degree = degree;
        this.yearOfStudy = yearOfStudy;
        this.next = null;
    }

   
    public void printLink() {
        System.out.println(name + ", " + age + ", " + degree + ", " + yearOfStudy);
    }
}


class LinkedList {
    private Link first;  

    public LinkedList() {
        first = null;
    }

    
    public void addLink(String name, int age, String degree, int yearOfStudy) {
        Link newLink = new Link(name, age, degree, yearOfStudy);
        if (first == null) {
            first = newLink;
        } else {
            Link current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newLink;
        }
    }

   
    public void printList() {
        Link current = first;
        while (current != null) {
            current.printLink();
            current = current.next;
        }
    }

  
    public void removeLink(String attribute, String value) {
        Link current = first;
        Link previous = null;

        while (current != null) {
            boolean match = false;
            switch (attribute.toLowerCase()) {
                case "name":
                    if (current.name.equals(value)) match = true;
                    break;
                case "age":
                    if (Integer.toString(current.age).equals(value)) match = true;
                    break;
                case "degree":
                    if (current.degree.equals(value)) match = true;
                    break;
                case "yearofstudy":
                    if (Integer.toString(current.yearOfStudy).equals(value)) match = true;
                    break;
            }

            if (match) {
                if (previous == null) {
                    first = current.next; 
                } else {
                    previous.next = current.next; 
                }
                return;  
            }
            previous = current;
            current = current.next;
        }
    }


    public void printAttribute(String attribute, String value) {
        Link current = first;
        while (current != null) {
            boolean match = false;
            switch (attribute.toLowerCase()) {
                case "name":
                    if (current.name.equals(value)) match = true;
                    break;
                case "age":
                    if (Integer.toString(current.age).equals(value)) match = true;
                    break;
                case "degree":
                    if (current.degree.equals(value)) match = true;
                    break;
                case "yearofstudy":
                    if (Integer.toString(current.yearOfStudy).equals(value)) match = true;
                    break;
            }

            if (match)
            {
                current.printLink();
                return;
            }
            current = current.next;
        }
    }
}

public class StudentRecord_LinkedList 
{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        LinkedList list = new LinkedList();

     
        list.addLink("Bunny", 26, "CSSE", 2);
        list.addLink("Larry", 18, "ARTS", 1);
        list.addLink("Steve", 32, "ComputationalThinking", 4);

       
        System.out.print("Enter action (PrintList/Attribute): ");
        String action = scanner.nextLine().trim();

        if (action.equalsIgnoreCase("PrintList")) {
            list.printList();
        } else {
            System.out.print("Enter attribute (name/age/degree/yearOfStudy): ");
            String attribute = scanner.nextLine().trim();

            System.out.print("Enter value for " + attribute + ": ");
            String value = scanner.nextLine().trim();

            System.out.print("Enter action (remove/print): ");
            String operation = scanner.nextLine().trim();

            if (operation.equalsIgnoreCase("remove")) {
                list.removeLink(attribute, value);
                list.printList(); 
            } else if (operation.equalsIgnoreCase("print")) {
                list.printAttribute(attribute, value); 
            }
        }

        scanner.close();
    }
}