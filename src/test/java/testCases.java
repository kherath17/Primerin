import base.basePage;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.landingPage;

public class testCases extends basePage{

    //basePage bp = new basePage();



    @BeforeClass
    public void setup(){
        basePage.setUp();
    }

    @Test(priority = 0)
    public void verifyNav(){
        landingPage lp = new landingPage();
        Assert.assertEquals(lp.navUrl(),"Premier Inn hotels | Book direct");
    }

    @Test(priority = 1)
    @Parameters({"Location1","Location2","Location3"})
    public void SearchHot(String Location1,String Location2,String Location3) throws InterruptedException {
        landingPage lp = new landingPage();
        //Assert.assertTrue(lp.searchHotel(Location1).contains(Location1));
        lp.searchHotel(Location1,Location2,Location3);
        lp.comparePrice(Location1,Location2,Location3);
    }

    @Test(priority = 2,dependsOnMethods = "SearchHot")
    @Parameters({"Location1","Location2","Location3"})
    public void checkLowestHotelPrice(String Location1,String Location2,String Location3) throws InterruptedException {

    }


    @AfterTest
    public void quitDriver(){
        basePage.tearDown();
    }
}
