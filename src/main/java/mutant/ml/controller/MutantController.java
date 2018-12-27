package mutant.ml.controller;

import mutant.ml.domain.DNA;
import mutant.ml.exceptions.DNAMalFormadoException;
import mutant.ml.service.MutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MutantController {

    @Autowired
    MutantService mutantService;

    @RequestMapping(method= RequestMethod.POST, value="/mutant", consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> mutant(@RequestBody DNA dna) throws DNAMalFormadoException {
        if(mutantService.isMutant(dna.getDna())){
            return ResponseEntity.ok(Boolean.TRUE);
        }else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}
