package mutant.ml.exceptions;

import java.io.Serializable;

public class DNAMalFormadoException extends Exception {

    private static final long serialVersionUID = 7598786107980175748L;

    public DNAMalFormadoException(String message) {
        super(message);
    }
}
