package SourceCode;

import java.util.Scanner;

import javax.net.ssl.HostnameVerifier;
import SourceCode.*;

class Employee
{
    static int globalID = 0;
    private String name;
    private int ID = 0;
    private Salaried salary;
    private Unions member;
    private Commission commission;
    private SalesReceipt receipt;
    private PaymentMethod payment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setGlobalID(int globalID) {
        Employee.globalID = globalID;
    }

    public static int getGlobalID() {
        return globalID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public Salaried getSalary() {
        return salary;
    }

    public void setSalary(Salaried salary) {
        this.salary = salary;
    }

    public Unions getMember() {
        return member;
    }

    public void setMember(Unions member) {
        this.member = member;
    }

    public Commission getCommission() {
        return commission;
    }

    public void setCommission(Commission commission) {
        this.commission = commission;
    }

    public SalesReceipt getReceipt() {
        return receipt;
    }

    public void setReceipt(SalesReceipt receipt) {
        this.receipt = receipt;
    }

    public PaymentMethod getPayment() {
        return payment;
    }

    public void setPayment(PaymentMethod payment) {
        this.payment = payment;
    }

    void print(){
        System.out.println(name);
        if(salary instanceof HourlySalary)
        {
            System.out.println("Hourly");
            System.out.println(((HourlySalary) salary).getRate());
        }
        else if (salary instanceof MonthlySalary){
            System.out.println("Monthly");
            System.out.println(((MonthlySalary) salary).getRate());
        }
        if(member instanceof EmployeeUnion)
        {
            System.out.println("Employee Union");
            System.out.println(((EmployeeUnion) member).getWeeklyDues());
        }
        else
        {
            System.out.println("NULL");
        }
        if(payment instanceof Mail){
            System.out.println("Mail");
            System.out.println(((Mail) payment).getAddress());
        }
        else if(payment instanceof Pickup)
            System.out.println("Pickup");
        else if(payment instanceof BankAccount)
            System.out.println("Bank");
    }
}

