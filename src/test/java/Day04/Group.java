package Day04;

import org.testng.annotations.Test;

public class Group {

    @Test(groups= {"Smoke"})
    void Register()
    {
        System.out.println("Registered Successfully");
    }
    @Test(groups= {"Regression"})
    void Login()
    {
        System.out.println("Login Successfully");
    }
    @Test(groups= {"Sanity"})
    void home()
    {
        System.out.println("Home Successfully");
    }
    @Test(groups= {"Smoke"})
    void Category()
    {
        System.out.println("Categorized Successfully");
    }
    @Test(groups= {"Regression"})
    void Cart()
    {
        System.out.println("Cart Successfully");
    }
    @Test(groups= {"Sanity"})
    void Checkout()
    {
        System.out.println("Checkout Successfully");
    }
    @Test(groups= {"Smoke"})
    void Order()
    {
        System.out.println("Order Successfully");
    }
    @Test(groups= {"Regression"})
    void Logout()
    {
        System.out.println("Logout Successfully");
    }
}
