package co.uk.neelsw.controller;

import co.uk.neelsw.model.Primes;
import co.uk.neelsw.service.PrimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Max;

import java.util.Optional;

@RestController
@Validated
public class PrimesController {

    @Autowired
    PrimesService primesService;

    @RequestMapping(value ="/primes/{number}", method = RequestMethod.GET , produces = { "application/json", "application/xml" })
    public Primes getPrimeNumbers(@PathVariable(value = "number", required = true)  @Max(999999) Integer number, @RequestParam(value = "algorithm") Optional<String> algorithm){
        return primesService.getPrimes(number , algorithm);
    }

    @ExceptionHandler
    public String constraintViolationHandler(ConstraintViolationException ex){
        return "please enter valid int number between 0 to 99999";
    }
}
