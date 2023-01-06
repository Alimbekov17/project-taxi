import dao.DataBase;
import model.Client;
import model.Driver;
import model.Taxi;
import service.impl.ClienServiceImpl;
import service.impl.DriverServiceImpl;
import service.impl.TaxiServiceImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        commands();
    }
    public static void commands(){
        DataBase dataBase;
        TaxiServiceImpl taxiService = new TaxiServiceImpl();
        DriverServiceImpl driverService = new DriverServiceImpl();
        ClienServiceImpl clienService = new ClienServiceImpl();
        List<Taxi> taxiList = new LinkedList<>();
        List<Client> clientList = new LinkedList<>();
        List<Driver> driverList = new LinkedList<>();

        while (true) {
            services();
            System.out.print("Enter: ");
            String enter = new Scanner(System.in).next();
            switch (enter) {
                case "1" -> {
                    while (true) {
                        clientServiceCommands();
                        System.out.print("Press");
                        String press = new Scanner(System.in).next();
                        if (press.equals("7")) break;
                        switch (press) {
                            case "1" -> System.out.println(clienService.addClient(clientList));
                            case "2" -> {
                                System.out.print("Enter name: ");
                                String name = new Scanner(System.in).next();
                                System.out.println(clienService.getClientByName(name));
                            }
                            case "3" -> {
                                System.out.print("Enter ID: ");
                                Long id = new Scanner(System.in).nextLong();
                                System.out.println(clienService.removeClientById(id));
                            }
                            case "4" -> {
                                System.out.print("Enter your ID: ");
                                Long id = new Scanner(System.in).nextLong();
                                System.out.print("Choose type of taxi: ");
                                String type = new Scanner(System.in).next();
                                System.out.println(clienService.orderTaxi(id, type));
                            }
                            case "5" -> System.out.println(clienService.getClientAge());
                            case "6" -> {
                                System.out.print("How to sort: ");
                                String sort = new Scanner(System.in).next();
                                clienService.universalSorting(sort);
                            }
                            default -> System.out.println("Wrong command!");
                        }
                    }
                }
                case "2" -> {
                    while (true) {
                        driverServiceCommands();
                        System.out.print("Press: ");
                        String press = new Scanner(System.in).next();
                        if (press.equals("8")) break;
                        switch (press) {
                            case "1" -> System.out.println(driverService.add(driverList));
                            case "2" -> {
                                System.out.print("Enter ID: ");
                                Long id = new Scanner(System.in).nextLong();
                                System.out.println(driverService.findById(id));
                            }
                            case "3" -> {
                                System.out.print("Enter name: ");
                                String name = new Scanner(System.in).next();
                                System.out.println(driverService.findByName(name));
                            }
                            case "4" -> {
                                System.out.print("Choose taxi: ");
                                String taxiName = new Scanner(System.in).next();
                                System.out.print("Enter driver ID: ");
                                Long id = new Scanner(System.in).nextLong();
                                System.out.println(driverService.assignTaxiToDriver(taxiName, id));
                            }
                            case "5" -> {
                                System.out.print("Enter driver ID: ");
                                Long driverID = new Scanner(System.in).nextLong();
                                System.out.print("Enter taxi ID: ");
                                Long taxiID = new Scanner(System.in).nextLong();
                                System.out.println(driverService.changeTaxiOrDriver(driverID, taxiID));
                            }
                            case "6" -> {
                                System.out.print("Enter car model: ");
                                String model = new Scanner(System.in).nextLine();
                                driverService.getDriverByTaxiModel(model).forEach(System.out::println);
                            }
                            case "7" -> {
                                System.out.print("Enter driver name: ");
                                String name = new Scanner(System.in).next();
                                driverService.update(name);
                            }
                            default -> System.out.println("Wrong command!");
                        }
                    }
                }
                case "3" -> {
                    while (true) {
                        taxiServiceCommands();
                        System.out.print("Press: ");
                        String press = new Scanner(System.in).next();
                        if (press.equals("6")) break;
                        switch (press) {
                            case "1" -> System.out.println(taxiService.add(taxiList));
                            case "2" -> {
                                System.out.print("Enter a letter: ");
                                String letter = new Scanner(System.in).next();
                                taxiService.findByInitialLetter(letter).forEach(System.out::println);
                            }
                            case "3" -> System.out.println(taxiService.grouping());
                            case "4" -> {
                                System.out.print("Enter taxi type: ");
                                String type = new Scanner(System.in).next();
                                taxiService.filterByTaxiType(type).forEach(System.out::println);
                            }
                            case "5" -> {
                                System.out.print("Enter taxi ID: ");
                                Long id = new Scanner(System.in).nextLong();
                                taxiService.update(id);
                            }
                            default -> System.out.println("Wrong command!");
                        }
                    }
                }
            }
        }
    }
    public static void services() {
        System.out.println("""
                ********** Services **********
                1- Client service
                2- Driver service
                3- Taxi service
                """);
    }
    public static void clientServiceCommands() {
        System.out.println("""
                ********** Commands **********
                1- Add new client
                2- Find client by name
                3- Remove client by ID
                4- Order taxi
                5- Get client's age
                6- Sort all clients
                7- Go to Main
                """);
    }
    public static void driverServiceCommands() {
        System.out.println("""
                ********** Commands **********
                1- Add new driver
                2- Find driver by ID
                3- Find driver by name
                4- Assign taxi to driver
                5- Change taxi or driver
                6- Find driver by taxi model
                7- Update driver
                8- Go to main
                """);
    }
    public static void taxiServiceCommands() {
        System.out.println("""
                ********** Services **********
                1- Add new taxi
                2- Find taxi by initial letter
                3- Group by taxi type
                4- Filter all taxi by type
                5- Update taxi
                6- Go to main
                """);
    }
}