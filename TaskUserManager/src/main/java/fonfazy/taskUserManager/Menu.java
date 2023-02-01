package fonfazy.taskUserManager;

import java.util.Scanner;


public class Menu {

    StringBuilder sb;
    public static void main(String[] args) {
        User user = new User();
        UserDao userDao = new UserDao();
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb;



        do {
            selectOption();
            switch (scanner.nextLine()) {
                case "1": {
                    System.out.println("Wprowadź nowego użytkownika");
                    System.out.print("Podaj Imię: ");
                    String userName = scanner.next();
                    System.out.print("Podaj email: ");
                    String userEmail = scanner.next();
                    System.out.print("Podaj hasło: ");
                    String userPass = scanner.next();
                    user.setUserName(userName);
                    user.setPassword(userPass);
                    user.setEmail(userEmail);
                    userDao.create(user);
                    break;
                }
                case "4": {
                    System.out.print("Podaj Id Użytkownika do usunięcia: ");
                    int userId = getInt(scanner, "Podaj numer: ");
                    userDao.delete(userId);
                    break;
                }
                case "2": {
                    System.out.print("Podaj Id Użytkownika do zmiany: ");
                    int userName = scanner.nextInt();
                    User upDate = userDao.read(userName);
                    System.out.print("Podaj email: ");
                    String userEmail1 = scanner.next();
                    System.out.print("Podaj hasło: ");
                    String userPass1 = scanner.next();
                    System.out.print("Podaj Imię: ");
                    String userName1 = scanner.next();
                    upDate.setUserName(userName1);
                    upDate.setPassword(userPass1);
                    upDate.setEmail(userEmail1);
                    userDao.update(upDate);
                    break;
                }
                case "3": {
                    System.out.print("Podaj Id Użytkownika: ");
                    int userId = getInt(scanner, "Podaj Id Użytkownika: ");
                    User read = userDao.read(userId);
                    System.out.println(read);
                    break;
                }
                case "5": {
                    User[] allUsers = userDao.findAll();
                    for (User allUser : allUsers)
                        System.out.println(allUser);
                    break;
                }
                default:
                    System.out.println("Proszę podać liczbę z zakresu menu.");
                    break;
            }
        } while (!"6".equals(scanner));

        System.out.println("Bye Bye :(");
    }

    public static int getInt(Scanner scanner, String text) {
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.println(text);
        }
        return scanner.nextInt();
    }


        public static void selectOption () {
            StringBuilder sb = new StringBuilder();
            sb = new StringBuilder();

            sb.append("Wybierz numer opcji"+"\n");
            sb.append("1. Nowy użytkownik"+"\n");
            sb.append("2. Edycja użytkownika"+"\n");
            sb.append("3. Zobacz użytkownika"+"\n");
            sb.append("4. Usuń użytkownika"+"\n");
            sb.append("5. Lista wszystkich użytkowników"+"\n");
            sb.append("6. Zakończ program"+"\n")
                    .toString();


            System.out.println(sb);
        }

    }




