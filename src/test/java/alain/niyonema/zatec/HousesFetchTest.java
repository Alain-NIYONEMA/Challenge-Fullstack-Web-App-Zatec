package alain.niyonema.zatec;

import alain.niyonema.zatec.api.APIServlet;
import alain.niyonema.zatec.functions.HousesFetch;
import alain.niyonema.zatec.utils.AlnUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.*;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class HousesFetchTest {

    private MockHttpServletRequest request;

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

        request = new MockHttpServletRequest();

        request.addParameter("page", "1");
        request.addParameter("pageSize", "10");

        HousesFetch housesFetch = new HousesFetch();

        String jsonResponse = housesFetch.processRequest(request);
        JsonObject jsonObject = AlnUtils.toJsonObject(jsonResponse);

        assertNotEquals(0, jsonResponse.length());
        assertNotNull(jsonObject.get("data"));
        assertNotNull(jsonObject.get("counts"));


        request.addParameter("name", "House Algood");
        request.addParameter("match", "true");

        jsonResponse = housesFetch.processRequest(request);
        jsonObject = AlnUtils.toJsonObject(jsonResponse);

        JsonArray jsonData = AlnUtils.toJsonArray(jsonObject.get("data").getAsString());

        assertNotNull(jsonData);
        assertEquals(1, jsonObject.get("counts").getAsInt());
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