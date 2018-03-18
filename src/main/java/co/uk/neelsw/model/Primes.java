package co.uk.neelsw.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Primes {

    private Integer initial;
    private List<Integer> priimes;

    public Primes(){
    }

    public Integer getInitial() {
        return initial;
    }

    public void setInitial(final Integer initial) {
        this.initial = initial;
    }

    public List<Integer> getPriimes() {
        return priimes;
    }

    public void setPriimes(final List<Integer> priimes) {
        this.priimes = priimes;
    }
}
