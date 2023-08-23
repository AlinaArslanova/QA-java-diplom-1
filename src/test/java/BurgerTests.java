import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.yandex.praktikum.Bun;
import ru.yandex.praktikum.Burger;
import ru.yandex.praktikum.Ingredient;
import ru.yandex.praktikum.IngredientType;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    private Burger burger;

    @Before
    public void Burger() {
        burger = new Burger();
    }

    @Mock
    Bun bun;

    @Mock
    Ingredient oneIngredient, twoIngredient, threeIngredient;

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(oneIngredient);
        burger.addIngredient(twoIngredient);
        burger.addIngredient(threeIngredient);
        assertEquals(3, burger.ingredients.size());
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(oneIngredient);
        burger.addIngredient(twoIngredient);
        burger.addIngredient(threeIngredient);
        burger.removeIngredient(0);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(oneIngredient);
        burger.addIngredient(twoIngredient);
        burger.addIngredient(threeIngredient);
        burger.moveIngredient(0, 2);
        assertEquals(new ArrayList<>(Arrays.asList(twoIngredient, threeIngredient, oneIngredient)), burger.ingredients);
    }

    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.ingredients.add(oneIngredient);
        when(bun.getPrice()).thenReturn(30.0f);
        when(oneIngredient.getPrice()).thenReturn(35.0f);
        float actual = burger.getPrice();
        assertThat(actual, equalTo(95.0f));
    }

    @Test
    public void getReceipt() {
        Bun bun = new Bun("white bun", 200);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        Ingredient ingredientType = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientType);
        String actual = burger.getReceipt();
        String expected = "(==== white bun ====)\n= sauce sour cream =\n= filling dinosaur =\n(==== white bun ====)\n\nPrice: 800,000000\n";
        assertThat(actual, equalTo(expected));
    }
}