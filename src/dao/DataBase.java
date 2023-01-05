package dao;

import model.Client;
import model.Driver;
import model.License;
import model.Taxi;

import java.util.List;

public class DataBase {
    private List<Client> clientList;
    private List<Driver> driverList;
    private List<License> licenseList;
    private List<Taxi> taxiList;

    public DataBase(List<Client> clientList, List<Driver> driverList, List<License> licenseList, List<Taxi> taxiList) {
        this.clientList = clientList;
        this.driverList = driverList;
        this.licenseList = licenseList;
        this.taxiList = taxiList;
    }

    public DataBase() {
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public List<Driver> getDriverList() {
        return driverList;
    }

    public void setDriverList(List<Driver> driverList) {
        this.driverList = driverList;
    }

    public List<License> getLicenseList() {
        return licenseList;
    }

    public void setLicenseList(List<License> licenseList) {
        this.licenseList = licenseList;
    }

    public List<Taxi> getTaxiList() {
        return taxiList;
    }

    public void setTaxiList(List<Taxi> taxiList) {
        this.taxiList = taxiList;
    }
}
