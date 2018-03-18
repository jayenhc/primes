package co.uk.neelsw.controller;


import co.uk.neelsw.PrimesApiApp;
import co.uk.neelsw.model.Primes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = PrimesApiApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class ITPrimesControllerTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();


    @Test
    public void testJsonGetPrimeNumbers() {
        HttpEntity<Primes> entity = new HttpEntity<Primes>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/primes/5"),
                HttpMethod.GET, entity, String.class);

        String expected = "{\"initial\":5,\"priimes\":[2,3,5]}";
        assertEquals(expected,response.getBody());
    }

    @Test
    public void testXmlGetPrimeNumbers() {
        HttpEntity<Primes> entity = new HttpEntity<Primes>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/primes/5.xml"),
                HttpMethod.GET, entity, String.class);

        String expected = "<primes><initial>5</initial><priimes>2</priimes><priimes>3</priimes><priimes>5</priimes></primes>";
        assertTrue(response.getBody().contains(expected));
    }

    @Test
    public void testInvalidPrimeNumber() {
        HttpEntity<Primes> entity = new HttpEntity<Primes>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/primes/99999999"),
                HttpMethod.GET, entity, String.class);

        String expected = "please enter valid int number between 0 to 99999";
        assertEquals(expected,response.getBody());
    }


    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}