package alain.niyonema.zatec;

import alain.niyonema.zatec.api.APIServlet;
import alain.niyonema.zatec.functions.HousesFetch;
import org.junit.jupiter.api.*;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class HousesFetchTest {

    private APIServlet apiServlet;
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
    public void processRequestTest() throws IOException {
        System.out.println("TEST: processRequest");

        apiServlet = new APIServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();

        apiServlet.doGet(request, response);

        assertEquals(16, response.getContentLength());
        assertEquals(200, response.getStatus());

        HousesFetch housesFetch = new HousesFetch();

        String jsonResponse = housesFetch.processRequest(request);

        assertEquals(4, jsonResponse.length());

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