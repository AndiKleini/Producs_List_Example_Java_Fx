import com.example.listview.ProductListModel;
import com.example.listview.ProductModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductListModelTests {

    @Test
    public void addProduct_storesNewProductInList() {
        var productToStore = new ProductModel();
        var instanceUnderTest = new ProductListModel();

        instanceUnderTest.addProduct(productToStore);

        Assertions.assertEquals(true, instanceUnderTest.getProducts().contains(productToStore));
    }

    @Test
    public void removeProduct_removesSpecifiedProductFromList() {
        var productToStore = new ProductModel();
        var instanceUnderTest = new ProductListModel();
        instanceUnderTest.addProduct(productToStore);

        instanceUnderTest.removeProduct(productToStore);

        Assertions.assertEquals(false, instanceUnderTest.getProducts().contains(productToStore));
    }
}
