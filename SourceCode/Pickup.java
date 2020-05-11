package SourceCode;

class Pickup implements PaymentMethod
{
    private String paymaster;

    public void makePayment(double salary)
    {
        System.out.println("Make a payment of " + salary +
                " through the paymaster "+ paymaster);
    } 

    public void setPayMaster(String paymaster)
    {
        this.paymaster = paymaster;
    }

    public String getPayMaster()
    {
        return paymaster;
    }
}