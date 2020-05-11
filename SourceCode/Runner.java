package SourceCode;

import java.io.Writer;
import java.io.FileWriter;

import SourceCode.DatabaseManagerImp;
import SourceCode.EmployeeImp;
// import com.google.gson.Gson;
// import com.google.gson.GsonBuilder;
public class Runner
{
    public static void main(String[] args)
    {
        DatabaseManagerImp db = new DatabaseManagerImp();
        db.addEmployee();
        db.addEmployee();
        db.addEmployee();
        db.addEmployee();
        db.addEmployee();
        db.addEmployee();
        //o.print();
        // try(Writer writer = new FileWriter("Data.json", true)){
        //     Gson g = new GsonBuilder().serializeNulls().create();
        //     g.toJson(o, writer);
        // }
        // catch (Exception e)
        // {
        //     System.out.println("Exception");
        // }
    }
}