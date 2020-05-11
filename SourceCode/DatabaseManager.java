package SourceCode;

interface DatabaseManager
{
    void addEmployee();
    void DeleteEmployee(int ID);
    void PostTimeCard(int ID, TimeCard card);
    void postSalesReceipt(int ID, SalesReceipt receipt);
    void postUnionCharges(double charges);
    void changeDetails(int ID);
    void runPayroll(boolean isEndOfWeek, boolean isEndOfFortnight, boolean isEndofMonth);
}