package alain.niyonema.zatec;

import alain.niyonema.zatec.utils.AlnUtils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class UtilsTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("------------------------------ START Testing: "+ HousesFetchTest.class.getName());
    }
    @BeforeEach
    public void beforeEach() {
        System.out.println("---------------");
    }

    @Test
    public void isEmptyTest(){
        System.out.println("TEST: isEmpty");

        assertTrue(AlnUtils.isEmpty(null));
        assertTrue(AlnUtils.isEmpty(""));
        assertFalse(AlnUtils.isEmpty(" "));
        assertFalse(AlnUtils.isEmpty("abc"));
    }

    @Test
    public void toIntTest(){
        System.out.println("TEST: toInt");

        assertEquals(3, AlnUtils.toInt("3", 0));
        assertEquals(1, AlnUtils.toInt("a", 1));
        assertEquals(0, AlnUtils.toInt("", 0));
    }

    @Test
    public void toJsonArrayTest(){
        System.out.println("TEST: toJsonArray");

        assertNull(AlnUtils.toJsonArray(""));
        assertNull(AlnUtils.toJsonArray("abc"));
        assertNull(AlnUtils.toJsonArray("123"));
        assertEquals(0, AlnUtils.toJsonArray("[]").size());
        assertEquals(1, AlnUtils.toJsonArray("[{}]").size());
        assertEquals(2, AlnUtils.toJsonArray("[{},{}]").size());
    }

    @Test
    public void toJsonObjectTest(){
        System.out.println("TEST: toJsonObject");

        assertNull(AlnUtils.toJsonArray(""));
        assertNull(AlnUtils.toJsonArray("abc"));
        assertNull(AlnUtils.toJsonArray("123"));
        assertEquals(0, AlnUtils.toJsonObject("{}").size());
        assertEquals(1, AlnUtils.toJsonObject("{\"a\":\"1\"}").size());
        assertEquals(2, AlnUtils.toJsonObject("{\"a\":\"1\",\"b\":\"2\"}").size());
    }

    @AfterEach
    public void afterEach() {
        System.out.println("---------------");
    }
    @AfterAll
    public static void afterAll() {
        System.out.println("------------------------------ END Testing: "+ HousesFetchTest.class.getName());
    }

}