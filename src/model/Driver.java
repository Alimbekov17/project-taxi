package model;

import enums.Gender;

import java.math.BigDecimal;

public class Driver {

    private Long id;
    private String name;
    private String surName;
    private Gender gender;

    private String phoneNumber;
//    private License license;
    private BigDecimal money;
    private Taxi taxi;



    public Driver() {
    }

    public Driver(Long id, String name, String surName, Gender gender, String phoneNumber, BigDecimal money, Taxi taxi) {
            this.id = id;
            this.name = name;
            this.surName = surName;
            this.gender = gender;
            this.phoneNumber = phoneNumber;
//            this.license = license;
            this.money = money;
            this.taxi = taxi;
        }
        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getSurName() {
            return surName;
        }

        public Gender getGender() {
            return gender;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

//        public License getLicense() {
//            return license;
//        }

        public BigDecimal getMoney() {
            return money;
        }

        public Taxi getTaxi() {
            return taxi;
        }

}
