package SourceCode;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.time.LocalDate;

public class CustomDeserializer implements JsonDeserializer<Employee>
{
    @override
    public Employee deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        JsonObject obj = json.getAsJsonObject();
        String name = obj.get("name").getAsString();
        int ID = obj.get("ID").getAsInt();
        JsonObject sal = obj.getAsJsonObject("salary");
        JsonObject mem = obj.getAsJsonObject("member");
        JsonObject com = obj.getAsJsonObject("commission");
        JsonObject rec = obj.getAsJsonObject("receipt");
        JsonObject pay = obj.getAsJsonObject("payment");

        Salaried salary = null;
        Unions member = null;
        Commission commission = null;
        SalesReceipt receipt = null;
        PaymentMethod payment = null;

        if(sal.has("card")){
            salary = new HourlySalary();
            HourlySalary ob = (HourlySalary) salary;
            ob.setRate(sal.get("dailyRate").getAsDouble());
            JsonObject cd = sal.getAsJsonObject("card");
            ob.setTimeCard(new TimeCard(LocalDate.of(cd.get("year").getAsInt(), cd.get("month").getAsInt(), cd.get("day").getAsInt()), cd.get("time").getAsDouble()));
            ob.setHoursWorked(sal.get("hoursWorked").getAsDouble());
            ob.setExtraHours(sal.get("extraHours").getAsDouble());
        }
        else{
            salary = new MonthlySalary();
            MonthlySalary ob = (MonthlySalary) salary;
            ob.setRate(sal.get("monthlyRate").getAsDouble());
        }
        
        JsonElement el = obj.get("member");
        if(el != null && !el.isJsonNull())
        {
            member = new EmployeeUnion();
            EmployeeUnion ob = (EmployeeUnion) member;
            ob.setRate(mem.get("weeklyRate").getAsDouble());
            ob.setServiceCharges(mem.get("serviceCharges").getAsDouble());
        }

        commission = new SalesCommission();
        SalesCommission ob = (SalesCommission) commission;
        ob.setRate(com.get("commissionRate").getAsDouble());
        ob.setSalesAmount(com.get("salesAmount").getAsDouble());

        receipt = new SalesReceipt(LocalDate.of(rec.get("year").getAsInt(), rec.get("month").getAsInt(), rec.get("day").getAsInt()), rec.get("salesAmount").getAsDouble());
    
        if(pay.has(""))
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
    }
}