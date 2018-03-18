package co.uk.neelsw.service;

import co.uk.neelsw.model.Primes;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ArrayList;

@Service
public class PrimesService {

    private Map<Integer, Primes> primesMap = new HashMap<>();

    @Cacheable("primes")
    public Primes getPrimes(Integer number, Optional<String> algorithm) {
        if (primesMap.get(number) == null) {
            Primes primes = new Primes();
            primes.setInitial(number);
            primes.setPriimes(getPrimesPriimes(number, algorithm));
            primesMap.put(number, primes);
        }
        return primesMap.get(number);
    }

    private List<Integer> getPrimesPriimes(int number, Optional<String> algorithm) {

        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            if (algorithm.isPresent() && "sqrt".equalsIgnoreCase(algorithm.get())) {
                sqrtAlgorithm(primeNumbers, i);
            } else {
                defaultAlgorithm(primeNumbers, i);
            }
        }
        return primeNumbers;

    }

    private void sqrtAlgorithm(final List<Integer> primeNumbers, final int number) {
        int counter = 0;
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                // number is perfectly divisible - no prime
                counter = counter + 1;
            }
        }
        if(counter == 0){
            primeNumbers.add(number);
        }

    }

    private void defaultAlgorithm(final List<Integer> primeNumbers, final int i) {
        int counter = 0;
        for (int num = i - 1; num >= 1; num--) {
            if (i % num == 0) {
                counter = counter + 1;
            }
        }
        if (counter == 1) {
            primeNumbers.add(i);
        }
    }
}
