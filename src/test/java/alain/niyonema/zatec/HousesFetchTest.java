package alain.niyonema.zatec;

import alain.niyonema.zatec.utils.AlnUtils;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class HousesFetchTest {

    private MyServlet servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("------------------------------ START Testing: "+ HousesFetchTest.class.getName());
    }
    @BeforeEach
    public void beforeEach() {
        System.out.println("---------------");
    }

    @Test
    public void processRequestTest(){
        System.out.println("TEST: processRequest");

        assertTrue(AlnUtils.isEmpty(null));
        assertTrue(AlnUtils.isEmpty(""));
        assertFalse(AlnUtils.isEmpty(" "));
        assertFalse(AlnUtils.isEmpty("abc"));
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