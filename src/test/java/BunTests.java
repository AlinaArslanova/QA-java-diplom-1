import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.Bun;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTests {

    private String bunName;
    private float bunPrice;
    private Bun bun;

    public BunTests(String name, float price) {
        this.bunName = name;
        this.bunPrice = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> dataName() {
        return Arrays.asList(new Object[][] {
                {"Сырная", 30.0f},
                {"Томатная", 25.6f},
                {"Черненькая с пармезаном", 40.9f}
        });
    }

    @Before
    public void Bun() {
        bun = new Bun(bunName, bunPrice);
    }
    @Test
    public void getName() {
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(bunPrice, bun.getPrice(), 0);
    }
}