import com.example.listview.EnterProductModel;
import com.example.listview.ProductModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ProductModelTests {



    @Test
    public void from_enterProductModelSupplied_createsNewProductModel() {
        var source = new EnterProductModel();
        int price = 123;
        source.priceProperty().setValue(price);
        String name = "Home";
        source.nameProperty().setValue(name);

        var result = ProductModel.From(source);

        Assertions.assertEquals(price, result.getPrice());
        Assertions.assertEquals(name, result.getName());
    }

    @Test
    public void priceUp_increasesCurrentPriceByOne() {
        var instanceUnderTest = new ProductModel();
        int price = 12;
        instanceUnderTest.setPrice(price);

        instanceUnderTest.priceUp();

        Assertions.assertEquals(price + 1, instanceUnderTest.getPrice());
    }

    @Test
    public void priceDown_decreasesCurrentPriceByOne() {
        var instanceUnderTest = new ProductModel();
        int price = 12;
        instanceUnderTest.setPrice(price);

        instanceUnderTest.priceDown();

        Assertions.assertEquals(price - 1, instanceUnderTest.getPrice());
    }
}
