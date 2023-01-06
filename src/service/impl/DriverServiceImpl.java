package service.impl;

import dao.DataBase;
import model.Driver;
import model.Taxi;
import service.interfaces.DriverService;

import java.util.ArrayList;
import java.util.List;

public class DriverServiceImpl implements DriverService {

    private DataBase dataBase;
    @Override
    public Driver add(Driver driver) {

        if(driver!=null){
            dataBase.getDriverList().add(driver);
        }else {
            System.out.println("driver is null");
        }
        return driver;
    }

    @Override
    public List<Driver> add(List<Driver> drivers) {
        for (Driver d:dataBase.getDriverList()) {
            if(d.equals(drivers)){
                dataBase.getDriverList().add(d);
            }
        }
        return drivers;
    }

    @Override
    public Driver findById(Long id) {
        for (Driver d:dataBase.getDriverList()) {
            if(d.getId().equals(id)){
                return d;
            }
        }
        return null;
    }

    @Override
    public List<Driver> findByName(String name) {
        List<Driver> driverList = new ArrayList<>();
        for (Driver d:dataBase.getDriverList()) {
            if(d.getName().equals(name)){
                driverList.add(d);
            }
        }
        return driverList;
    }

    @Override
    public String assignTaxiToDriver(String taxiName, Long driverId) {
        for (Taxi t:dataBase.getTaxiList()) {
            if(t.getModel().equals(taxiName)){
                for (Driver d:dataBase.getDriverList()) {
                    if(d.getId().equals(driverId)){
                        d.setTaxi(t);
                        return "ok";
                    }

                }
            }
        }
        return null;
    }
    @Override
    public String changeTaxiOrDriver(Long driverId, Long taxiId) {
        return null;
    }

    @Override
    public List<Driver> getDriverByTaxiModel(String model) {
        return null;
    }

    @Override
    public void update(String driverName) {

    }
}
