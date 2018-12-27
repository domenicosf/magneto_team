package mutant.ml.domain;

import org.springframework.stereotype.Indexed;

import javax.persistence.*;

@Entity
public class DNA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String[] dna;

    public DNA() {

    }

    public DNA(String[] dna) {
        this.dna = dna;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    public Long getId() {
        return id;
    }

}
