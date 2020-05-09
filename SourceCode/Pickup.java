package assigment;

class Pickup implements PaymentMethod
{
    private String paymaster;

    void makePayment(double salary)
    {
        System.out.println("Make a payment of " + salary +
                " through the paymaster "+ paymaster);
    } 

    void setPayMaster(String paymaster)
    {
        this.paymaster = paymaster;
    }

    String getPayMaster()
    {
        return paymaster;
    }
}