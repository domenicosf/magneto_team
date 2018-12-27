package mutant.ml.service;

import mutant.ml.exceptions.DNAMalFormadoException;
import mutant.ml.utl.Detector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutantService {

    @Autowired
    Detector detector;

    public boolean isMutant(String[] dna) throws DNAMalFormadoException {
        return detector.isMutant(dna);
    }

}
