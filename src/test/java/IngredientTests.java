package praktikum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IngredientTests {

    private IngredientType type;
    private String name;
    private float price;
    private Ingredient ingredient;

    public IngredientTests(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "Сальса", 20f},
                {IngredientType.SAUCE, "Сырный", 15.6f},
                {IngredientType.FILLING, "Перчик", 40f},
                {IngredientType.FILLING, "Бекон", 50.5f},
                {IngredientType.FILLING, "Сыр", 15.05f}
        });
    }

    @Before
    public void Ingredient() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPrice() {
        float result = ingredient.getPrice();
        Assert.assertEquals(price, result, 0.1);
    }

    @Test
    public void getName() {
        String result = ingredient.getName();
        Assert.assertEquals(name, result);
    }

    @Test
    public void getType() {
        IngredientType result = ingredient.getType();
        Assert.assertEquals(type, result);
    }
}