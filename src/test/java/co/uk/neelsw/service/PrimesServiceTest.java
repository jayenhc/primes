package co.uk.neelsw.service;

import co.uk.neelsw.model.Primes;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class PrimesServiceTest {

    private PrimesService primesService;

    @Before
    public void before()
    {
        primesService = new PrimesService();
    }

    @Test
    public void testGetPrimesWithDefaultAlgorithm() {
        Primes primes = primesService.getPrimes(5, Optional.empty());
        List<Integer> expected = Arrays.asList(2,3,5);
        assertEquals(new Integer("5"), primes.getInitial());
        assertEquals(expected, primes.getPriimes());

    }

    @Test
    public void testGetPrimesWithSqrtAlgorithm() {
        Primes primes = primesService.getPrimes(5, Optional.of("sqrt"));
        List<Integer> expected = Arrays.asList(2,3,5);
        assertEquals(new Integer("5"), primes.getInitial());
        assertEquals(expected, primes.getPriimes());

    }
}
