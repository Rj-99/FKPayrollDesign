package assignment;

class Mail implements PaymentMethod
{
    private String postalAddress;

    void makePayment(double salary)
    {
        System.out.println("Make a payment of "+ salary +
                " to the address "+ postalAddress);
    }

    void setAddress(String address)
    {
        postalAddress = address;
    }

    String getAddress()
    {
        return postalAddress;
    }
}