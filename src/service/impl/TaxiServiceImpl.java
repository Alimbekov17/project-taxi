package service.impl;

import enums.TaxiType;
import model.License;
import model.Taxi;
import service.interfaces.TaxiService;

import java.time.LocalDate;
import java.util.*;

public class TaxiServiceImpl implements TaxiService {
    List<Taxi> taxis = new LinkedList<>();
    Map<TaxiType, List<Taxi>> grouped = new LinkedHashMap<>();

    @Override
    public StringBuilder add(Taxi taxi) {
        boolean success = false;
        try {
            System.out.println("~~~~~ Adding taxi ~~~~~");
            System.out.print("Enter ID    : ");
            Long id = new Scanner(System.in).nextLong();
            taxi.setId(id);
            System.out.print("Enter Model : ");
            String model = new Scanner(System.in).nextLine();
            taxi.setModel(model);
            System.out.print("Enter Number: ");
            String number = new Scanner(System.in).next();
            if (number.length() != 8) throw new Exception("Number must 8 symbols!");
            else taxi.setNumber(number);
            System.out.print("Color       : ");
            String color = new Scanner(System.in).next();
            taxi.setColour(color);
            System.out.print("Enter year  : ");
            int y = new Scanner(System.in).nextInt();
            if (y > 2010 && y < 2023) {
                LocalDate year = LocalDate.of(y, 1, 1);
                taxi.setYear(year);
            } else throw new Exception("Year must be over 2010");
            System.out.println("""
                    Choose taxi type:
                    1- STANDARD
                    2- COMFORT
                    3- BUSINESS
                    """);
            System.out.print("Enter: ");
            String enter = new Scanner(System.in).next();
            TaxiType type;
            label:
            while (true) {
                switch (enter) {
                    case "1":
                        type = TaxiType.STANDARD;
                        taxi.setTaxiType(type);
                        break label;
                    case "2":
                        type = TaxiType.COMFORT;
                        taxi.setTaxiType(type);
                        break label;
                    case "3":
                        type = TaxiType.BUSINESS;
                        taxi.setTaxiType(type);
                        break label;
                    default:
                        System.out.println("Wrong command!");
                        break;
                }
            }
            success = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new StringBuilder(success ? "Taxi added successfully!" : "Something went wrong. Failed!");
    }

    @Override
    public StringBuilder add(List<Taxi> taxiList) {
        Taxi taxi = new Taxi();
        boolean isAdded = false;
        add(taxi);
        if (taxiList.isEmpty()) {
            taxiList.add(taxi);
            isAdded = true;
        } else {
            for (Taxi taxi1 : taxiList) {
                try {
                    if (taxi1.getId().equals(taxi.getId())) {
                        throw new Exception("This ID is already exists. Try another ID");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        taxis.addAll(taxiList);
        return new StringBuilder(isAdded ? "Taxi saved successfully!" : "Something went wrong. Saving failed!");
    }

    @Override
    public List<Taxi> findByInitialLetter(String model) {
        boolean isFound = false;
        List<Taxi> taxisByInitialLetter = new LinkedList<>();
        if (taxis.isEmpty()) System.out.println("Taxis not found!");
        else {
            taxisByInitialLetter = taxis.stream().
                    filter(taxi1 -> model.equalsIgnoreCase(String.valueOf(taxi1.getModel().charAt(0)))).toList();
            isFound = true;
        }
        if (!isFound) System.out.println("No such taxi!");
        return taxisByInitialLetter;
    }

    @Override
    public Map<TaxiType, List<Taxi>> grouping() {
        if (taxis.isEmpty()) System.out.println("No taxi found!");
        else {
            List<Taxi> standard = taxis.stream().filter(taxi1 -> taxi1.getTaxiType().equals(TaxiType.STANDARD)).toList();
            List<Taxi> comfort = taxis.stream().filter(taxi1 -> taxi1.getTaxiType().equals(TaxiType.COMFORT)).toList();
            List<Taxi> business = taxis.stream().filter(taxi1 -> taxi1.getTaxiType().equals(TaxiType.BUSINESS)).toList();
            grouped.put(TaxiType.STANDARD, standard);
            grouped.put(TaxiType.COMFORT, comfort);
            grouped.put(TaxiType.BUSINESS, business);
        }
        return grouped;
    }

    @Override
    public List<Taxi> filterByTaxiType(String taxiType) {
        List<Taxi> filteredTaxiList = new LinkedList<>();
        if (taxis.isEmpty()) System.out.println("No taxi found!");
        else {
            filteredTaxiList = taxis.stream().
                    filter(taxi1 -> taxiType.equalsIgnoreCase(taxi1.getTaxiType().name())).toList();
        }
        return filteredTaxiList;
    }

    @Override
    public void update(Long id) {
        if (taxis.isEmpty()) System.out.println("Taxi list is empty!");
        else {
            try {
                for (Taxi taxi1 : taxis) {
                    if (taxi1.getId().equals(id)) {
                        System.out.println(taxi1);
                        System.out.print("Set new car Model: ");
                        String model = new Scanner(System.in).nextLine();
                        taxi1.setModel(model);
                        System.out.print("Enter new car Number: ");
                        String number = new Scanner(System.in).next();
                        if (number.length() != 8) throw new Exception("Number must 8 symbols!");
                        else taxi1.setNumber(number);
                        System.out.print("Set Color       : ");
                        String color = new Scanner(System.in).next();
                        taxi1.setColour(color);
                        System.out.print("Set Enter year  : ");
                        int y = new Scanner(System.in).nextInt();
                        if (y > 2010 && y < 2023) {
                            LocalDate year = LocalDate.of(y, 1, 1);
                            taxi1.setYear(year);
                        } else throw new Exception("Year must be over 2010");
                        System.out.println("""
                                Choose taxi type:
                                1- STANDARD
                                2- COMFORT
                                3- BUSINESS
                                """);
                        System.out.print("Enter here: ");
                        String enter = new Scanner(System.in).next();
                        TaxiType type;
                        label:
                        while (true) {
                            switch (enter) {
                                case "1":
                                    type = TaxiType.STANDARD;
                                    taxi1.setTaxiType(type);
                                    break label;
                                case "2":
                                    type = TaxiType.COMFORT;
                                    taxi1.setTaxiType(type);
                                    break label;
                                case "3":
                                    type = TaxiType.BUSINESS;
                                    taxi1.setTaxiType(type);
                                    break label;
                                default:
                                    System.out.println("Wrong command! ");
                                    break;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
