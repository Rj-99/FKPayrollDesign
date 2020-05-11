package SourceCode;

class Mail implements PaymentMethod
{
    private String postalAddress;

    public void makePayment(double salary)
    {
        System.out.println("Make a payment of "+ salary +
                " to the address "+ postalAddress);
    }

    public void setAddress(String address)
    {
        postalAddress = address;
    }

    public String getAddress()
    {
        return postalAddress;
    }
}