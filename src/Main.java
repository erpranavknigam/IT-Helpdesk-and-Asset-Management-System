import com.company.ithelpdesk.model.user.Employee;
import com.company.ithelpdesk.model.user.ITEngineer;
import com.company.ithelpdesk.model.user.Manager;
import com.company.ithelpdesk.model.user.User;
import com.company.ithelpdesk.repository.InMemoryUserRepository;
import com.company.ithelpdesk.repository.UserRepository;
import com.company.ithelpdesk.service.UserService;
import com.company.ithelpdesk.service.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        UserRepository userRepository = new InMemoryUserRepository();
        UserService userService = new UserServiceImpl(userRepository);

        long userId;
        String name;
        String email;
        String phone;
        String dept;
        User user = null;

        System.out.println("=========IT Helpdesk and Asset Management System=========");
        System.out.println("\n");

        Scanner sc = new Scanner(System.in);
        int continueInput = 1;
        while (continueInput == 1){
            System.out.println("Select options: " +
                    "\n1: Register Employee" +
                    "\n2. Register IT Engineer" +
                    "\n3. Register Manager" +
                    "\n4. List All Users" +
                    "\n5. Activate User" +
                    "\n6. Deactivate User" +
                    "\n7. Find User by Id: ");
            int selectedOption = sc.nextInt();
            switch (selectedOption) {
                case 1:
                    System.out.println("\nEnter Id: ");
                    userId = sc.nextLong();
                    System.out.println("\nEnter Name: ");
                    name = sc.next();
                    System.out.println("\nEnter Email: ");
                    email = sc.next();
                    System.out.println("\nEnter Phone: ");
                    phone = sc.next();
                    System.out.println("\nEnter Employee Code: ");
                    String empCode = sc.next();
                    System.out.println("\nEnter Department: ");
                    dept = sc.next();
                    Employee employee = new Employee(userId,name,email,phone,true,empCode,dept);
                    user = userService.registerEmployee(employee);
                    System.out.println("\nEmployee Registered Successfully.\n");
                    employee.displayProfile();
                    break;
                case 2:
                    System.out.println("\nEnter Id: ");
                    userId = sc.nextLong();
                    System.out.println("\nEnter Name: ");
                    name = sc.next();
                    System.out.println("\nEnter Email: ");
                    email = sc.next();
                    System.out.println("\nEnter Phone: ");
                    phone = sc.next();
                    System.out.println("\nEnter Specialization: ");
                    String specialization = sc.next();
                    ITEngineer itEngineer = new ITEngineer(userId, name, email, phone, true, specialization, 0);
                    user = userService.registerItEngineer(itEngineer);
                    System.out.println("\nIT Engineer Registered Successfully.\n");
                    itEngineer.displayProfile();
                    break;
                case 3:
                    System.out.println("\nEnter Id: ");
                    userId = sc.nextLong();
                    System.out.println("\nEnter Name: ");
                    name = sc.next();
                    System.out.println("\nEnter Email: ");
                    email = sc.next();
                    System.out.println("\nEnter Phone: ");
                    phone = sc.next();
                    System.out.println("\nEnter Specialization: ");
                    String department = sc.next();
                    Manager manager = new Manager(userId, name, email, phone, true, department, null);
                    user = userService.registerManager(manager);
                    System.out.println("\nManager Registered Successfully.\n");
                    manager.displayProfile();
                    break;
                case 4:
                    List<User> users = userService.listAllUsers();
                    for(User u : users){
                        u.displayProfile();
                        System.out.println("\n");
                    }
                case 5:
                    userId = sc.nextLong();

                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            System.out.println("\nDo you want to continue? 1 for yes 0 for no: ");
            continueInput = sc.nextInt();
        }
            sc.close();

    }
}
