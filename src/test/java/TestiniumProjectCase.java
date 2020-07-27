import com.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestiniumProjectCase {
    public Helper helper;

    @Before
    public void setUp(){
        helper = new Helper();
        helper.openBrowser();
    }

    @Test
    public void TrendyolProductPriceControlOnBasket() throws InterruptedException {

        Start start = new Start(helper);
        start.navigateToTrendyolPage();
        start.closePopup();
        start.controlPageIsLoaded();

        Login login = new Login(helper);
        login.clickLogin();
        login.inputUsernameAndPassword();
        login.loginSubmit();
        login.loginControl();

        Search search = new Search(helper);
        search.searchText();
        search.clickSearchButton();

        Product product = new Product(helper);
        product.chooseProduct();
        product.clickProduct();
        product.priceOnPage();
        product.addToBasket();
        product.navigateToBasket();
        product.priceOnBasket();
        product.assertPrices();
        product.increaseProduct();
        product.deleteProduct();
    }
    @After
    public void tearDown() {
    helper.closeBrowser();

    }
}
