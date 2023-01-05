package service.impl;

import dao.DataBase;
import model.Client;
import model.Taxi;
import service.interfaces.ClientService;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ClienServiceImpl implements ClientService {
    private DataBase dataBase = new DataBase();
    @Override
    public String addClient(Client client) {
        return null;
    }

    @Override
    public String addClient(List<Client> clients) {
        dataBase.setClientList(clients);

        return "Client succsesfully added";
    }

    @Override
    public List<Client> getClientByName(String name) {
        List<Client> clientList = new LinkedList<>();
        for (Client clients:dataBase.getClientList()) {
            if(clients.getFullName().equals(name)){
                clientList.add(clients);
            }
        }
        return clientList;
    }

    @Override
    public Client removeClientById(Long id) {
        for (Client client:dataBase.getClientList()) {
            if(client.getId().equals(id)){
                dataBase.getClientList().remove(client);
            }
        }
        return null;
    }

    @Override
    public Taxi orderTaxi(Long clientId, String taxiType) {
        return null;
    }

    @Override
    public Map<Integer, Client> getClientAge() {
        int date = LocalDate.now().getYear();
        Map<Integer, Client> map = new LinkedHashMap<>();
        for (Client client:dataBase.getClientList()) {
            map.put(date - client.getDateOfBirth().getYear(), client);
        }
        return map;
    }

    @Override
    public void universalSorting(String word) {

    }
}
