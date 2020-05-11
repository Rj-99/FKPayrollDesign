package SourceCode;

class BankAccount implements PaymentMethod
{
    private String bankAccount;
    private String bankName;
    private String branch;

    public void makePayment(double salary) {
        System.out.println("Make a payment of " + salary + " to the Bank Account " + bankAccount + " of " + bankName
                + " and Branch " + branch);
    }

    void setBankAccount(String account)
    {
        bankAccount = account;
    }

    String getBankAccount()
    {
        return bankAccount;
    }

    void setBankName(String name)
    {
        bankName = name;
    }

    String getBankName()
    {
        return bankName;
    }

    void setBankBranch(String branch)
    {
        this.branch = branch;
    }

    String getBankBranch()
    {
        return branch;
    }
}