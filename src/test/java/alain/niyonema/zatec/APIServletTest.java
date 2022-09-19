package alain.niyonema.zatec;

import alain.niyonema.zatec.api.APIServlet;
import alain.niyonema.zatec.functions.HousesFetch;
import alain.niyonema.zatec.utils.AlnUtils;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.*;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class APIServletTest {

    private APIServlet apiServlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("------------------------------ START Testing: "+ APIServletTest.class.getName());
    }
    @BeforeEach
    public void beforeEach() {
        System.out.println("---------------");
    }

    @Test
    public void doGetTest() throws IOException {
        System.out.println("TEST: doGet");

        apiServlet = new APIServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();

        request.addParameter("page", "1");
        request.addParameter("pageSize", "10");

        apiServlet.init();
        apiServlet.doGet(request, response);

        assertEquals("application/json;charset=UTF-8", response.getContentType());
        assertEquals(0, response.getContentLength());
        assertEquals(200, response.getStatus());

        String jsonResponse = response.getContentAsString();
        JsonObject jsonObject = AlnUtils.toJsonObject(jsonResponse);

        assertNotNull(jsonObject.get("data"));
        assertNotNull(jsonObject.get("counts"));

        assertNotEquals(0, jsonObject.get("counts").getAsInt());

        apiServlet.destroy();
    }

    @Test
    public void doPostTest() throws IOException {
        System.out.println("TEST: doPost");

        apiServlet = new APIServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();

        request.addParameter("name", "House Algood");
        request.addParameter("match", "true");

        apiServlet.init();
        apiServlet.doGet(request, response);

        assertEquals("application/json;charset=UTF-8", response.getContentType());
        assertEquals(0, response.getContentLength());
        assertEquals(200, response.getStatus());

        String jsonResponse = response.getContentAsString();
        JsonObject jsonObject = AlnUtils.toJsonObject(jsonResponse);

        assertNotNull(jsonObject.get("data"));
        assertNotNull(jsonObject.get("counts"));

        assertEquals(1, jsonObject.get("counts").getAsInt());

        apiServlet.destroy();
    }

    @AfterEach
    public void afterEach() {
        System.out.println("---------------");
    }
    @AfterAll
    public static void afterAll() {
        System.out.println("------------------------------ END Testing: "+ APIServletTest.class.getName());
    }

}