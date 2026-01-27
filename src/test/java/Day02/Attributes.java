package Day02;

import net.bytebuddy.build.Plugin;
import org.testng.annotations.Test;

public class Attributes {

    @Test(priority=-9)
    void Register()
    {
    System.out.println("Registered Successfully");
    }
    @Test(priority = -8)
    void Login()
    {
    System.out.println("Login Successfully");
    }
    @Test(priority = 0)
    void home()
    {
    System.out.println("Home Successfully");
    }
    @Test(priority = 0)
    void Category()
    {
    System.out.println("Categorized Successfully");
    }
    @Test(priority = 1)
    void Cart()
    {
    System.out.println("Cart Successfully");
    }
    @Test(priority = 2)
    void Checkout()
    {
    System.out.println("Checkout Successfully");
    }
    @Test(priority = 3)
    void Order()
    {
    System.out.println("Order Successfully");
    }
    @Test(priority = 4)
    void Logout()
    {
    System.out.println("Logout Successfully");
    }

}
