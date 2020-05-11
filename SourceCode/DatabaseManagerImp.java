package SourceCode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Writer;
import java.io.FileWriter;
import java.io.File;
import java.io.Reader;
import java .io.FileReader;
import java.util.Scanner;

public class DatabaseManagerImp implements DatabaseManager
{

    public void addEmployee()
    {
        Employee emp = new Employee();
        int responseOp;

        try(Scanner sc = new Scanner(System.in))
        {
            
            System.out.println("Enter Employee Name:");
            emp.setName(sc.nextLine());
            
            emp.setID(Employee.getGlobalID());
            Employee.setGlobalID(Employee.getGlobalID() + 1);
            
            System.out.println("Enter the mode of salary:\n\t1.Hourly\n\t2.Monthly");
            responseOp = sc.nextInt();
            
            Salaried salary = null;

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

            emp.setSalary(salary);

            System.out.println("Is the employee a Union Member?\n\t1. Yes\n\t2. No");
            responseOp = sc.nextInt();
            
            Unions member = null;

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
                member = null;
            }

            emp.setMember(member);

            Commission commission = new SalesCommission();

            if(commission instanceof SalesCommission){
                System.out.println("Enter the sales commision rate:");
                SalesCommission obj = (SalesCommission) commission;
                obj.setRate(sc.nextDouble());
            }

            emp.setCommission(commission);

            emp.setReceipt(new SalesReceipt());

            System.out.println("Enter the Payment Method for Salary:\n\t1. Mail to Postal Address\n\t2. Pickup by Paymaster\n\t3. Transfer to Bank Account");
            responseOp = sc.nextInt();

            PaymentMethod payment = null;

            if(responseOp == 1)
            {
                payment = new Mail();
                Mail obj = (Mail) payment;
                System.out.println("Enter your postal address:");
                sc.nextLine();
                String addr = sc.nextLine();
                obj.setAddress(addr);
            }

            else if(responseOp == 2)
            {
                payment = new Pickup();
                Pickup obj = (Pickup) payment;
                System.out.println("Enter the paymaster:");
                sc.nextLine();
                String pay = sc.nextLine();
                obj.setPayMaster(pay);
            }

            else if(responseOp == 3)
            {
                payment = new BankAccount();
                BankAccount obj = (BankAccount) payment;
                sc.nextLine();
                System.out.println("Enter the Bank Name:");
                obj.setBankName(sc.nextLine());
                System.out.println("Enter the Bank Branch:");
                obj.setBankBranch(sc.nextLine());
                System.out.println("Enter the Account Number:");
                obj.setBankAccount(sc.nextLine());
            }

            emp.setPayment(payment);

            try(Writer writer = new FileWriter("Data.json", true)){
                Gson g = new GsonBuilder().serializeNulls().create();
                g.toJson(emp, writer);
            }
            catch (Exception e)
            {
                System.out.println("Exception");
            }
        }
        catch(Exception e)
        {

        } 
    }

    public void DeleteEmployee(int Empid)
    {
        // String content;
        Gson gsonread = new GsonBuilder().registerAdapterType(Employee.class, new CustomDeserializer()).create();
        Gson gsonwrite = new GsonBuilder().serializeNulls().create();
         
        try(Reader reader = new FileReader("Data.json")){
            Employee[] arr = gson.fromJson(reader, EmployeeImp[].class);
            //System.out.println(obj);
            Writer writer = new FileWriter("Data.json");
            for(int i = 0; i < arr.length; i++)
            {
                if(arr[i].getID() == Empid){
                    continue;
                }
                else{
                    g.toJson(emp, new FileWriter("Data.json", true));
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Excption");
        }   
               
    }

    public void PostTimeCard(inr Empid, TimeCard card)
    {
        Gson gsonread = new GsonBuilder().registerAdapterType(Employee.class, new CustomDeserializer()).create();
        Gson gsonwrite = new GsonBuilder().serializeNulls().create();
         
        try(Reader reader = new FileReader("Data.json")){
            Employee[] arr = gson.fromJson(reader, EmployeeImp[].class);
            //System.out.println(obj);
            Writer writer = new FileWriter("Data.json");
            for(int i = 0; i < arr.length; i++)
            {
                if(arr[i].getID() == Empid){
                    Salaried salary = arr[i].getSalary();
                    HourlySalary sal = (HourlySalary) salary;
                    sal.setTimeCard(card);
                    sal.updateHoursWorked();
                    arr[i].setSalary(sal);
                }
                g.toJson(emp, new FileWriter("Data.json", true));
            }
        }
        catch(Exception e)
        {
            System.out.println("Excption");
        }
    }

    public void postSalesReceipt(int Empid, SalesReceipt receipt)
    {
        Gson gsonread = new GsonBuilder().registerAdapterType(Employee.class, new CustomDeserializer()).create();
        Gson gsonwrite = new GsonBuilder().serializeNulls().create();
         
        try(Reader reader = new FileReader("Data.json")){
            Employee[] arr = gson.fromJson(reader, EmployeeImp[].class);
            //System.out.println(obj);
            Writer writer = new FileWriter("Data.json");
            for(int i = 0; i < arr.length; i++)
            {
                if(arr[i].getID() == Empid){
                    arr[i].setReceipt(receipt);
                    Commission com = arr[i].getCommission();
                    SalesCommission sales = (SalesCommission) com;
                    sales.updateSales(receipt.getAmount());
                    arr[i].setCommission(com);
                }
                g.toJson(emp, new FileWriter("Data.json", true));
            }
        }
        catch(Exception e)
        {
            System.out.println("Excption");
        }
    }

    public void postUnionCharges(double charges)
    {
        Gson gsonread = new GsonBuilder().registerAdapterType(Employee.class, new CustomDeserializer()).create();
        Gson gsonwrite = new GsonBuilder().serializeNulls().create();
         
        try(Reader reader = new FileReader("Data.json")){
            Employee[] arr = gson.fromJson(reader, EmployeeImp[].class);
            //System.out.println(obj);
            Writer writer = new FileWriter("Data.json");
            for(int i = 0; i < arr.length; i++)
            {
                if(arr[i].getMember() instanceof EmployeeUnion){
                    Unions member = arr[i].getMember();
                    EmployeeUnion obj = (EmployeeUnion) member;
                    obj.updateServiceCharges(charges);
                    arr[i].setMember(obj);
                }
                g.toJson(emp, new FileWriter("Data.json", true));
            }
        }
        catch(Exception e)
        {
            System.out.println("Excption");
        }
    }
}
