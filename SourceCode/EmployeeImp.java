package assignment;

import java.util.Scanner;
class EmployeeImp implements Employee
{
    private String name;
    private String ID;
    private Salaried salary;
    private Unions member;
    private Commission commission;
    private SalesReceipt receipt;
    private PaymentMethod payment;

    public void addEmployee()
    {
        int responseOp;
        try(Scanner sc = new Scanner(System.in))
        {
            
            System.out.println("Enter Employee Name:");
            String name = sc.nextLine();
            
            System.out.println("Enter the mode of salary:\n\t1.Hourly\n\t2.Monthly");
            responseOp = sc.nextInt();
            
            if(responseOp == 1)
            {
                salary = new HourlySalary(); 
                HourlySalary obj = (HourlySalary) salary;
                System.out.println("Enter the Daily Rate:");
                obj.setRate(sc.nextDouble());
                obj.setTimeCard(new TimeCard());
                obj.resetWorkHours();
            }
            
            else if (responseOp == 2)
            {
                salary = new MonthlySalary();
                MonthlySalary obj = (MonthlySalary) salary;
                System.out.println("Enter the Monthly Salary:");
                obj.setRate(sc.nextDouble());
            }

            System.out.println("Is the employee a Union Member?\n\t1. Yes\n\t2. No");
            responseOp = sc.nextInt();
            
            if(responseOp == 1)
            {
                member = new EmployeeUnion();
                System.out.println("Enter the weekly Union rate:");
                EmployeeUnion obj = (EmployeeUnion) member;
                obj.setRate(sc.nextDouble());
                obj.resetServiceCharges();
            }
            
            else if(responseOp == 2)
            {
                member = NULL;
            }

            commission = new SalesCommission();

            receipt = new SalesReceipt();

            System.out.println("Enter the Payment Method for Salary:\n\t1. Mail to Postal Address\n\t2. Pickup by Paymaster\n\t3. Transfer to Bank Account");
            responseOp = sc.nextInt();

            if(responseOp == 1)
            {
                payment = new Mail();
                Mail obj = (Mail) payment;
                System.out.println("Enter your postal address:");
                obj.setAddress(sc.nextLine());
            }

            else if(responseOp == 2)
            {
                payment = new Pickup();
                Pickup obj = (Pickup) payment;
                System.out.println("Enter the paymaster:");
                obj.setPayMaster(sc.nextLine());
            }

            else if(responseOp == 3)
            {
                payment = new BankAccount();
                BankAccount obj = (BankAccount) payment;
                System.out.println("Enter the Bank Name:");
                obj.setBankName(sc.nextLine());
                System.out.println("Enter the Bank Branch:");
                obj.setBankBranch(sc.nextLine());
                System.out.println("Enter the Account Number:");
                obj.setBankAccount(sc.nextLine());
            }

        }
        catch(Exception e)
        {

        } 
    }
}