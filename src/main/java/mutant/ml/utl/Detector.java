package mutant.ml.utl;

import mutant.ml.exceptions.DNAMalFormadoException;

public class Detector {

    public boolean isMutant(String[] dna) throws DNAMalFormadoException {
        //Transforma dns em uma array bidmensional de caracteres de tamanho n
        char[][] dnaSeq = obtemSequenciaBidDNA(dna);
        return hasTwoMutantDNASquences(dnaSeq);
    }

    private char[][] obtemSequenciaBidDNA(String[] dna) throws DNAMalFormadoException{
        int tam = dna.length;
        char[][] dnaSeq = new char[tam][tam];

        for(int i = 0; i < tam; i++){
            String linha = dna[i];
            char[] sequenciaDeChars = linha.toCharArray();

            if(tam != sequenciaDeChars.length)
                throw new DNAMalFormadoException(
                        String.format("Erro na sequência %s (posi≤ão %d), o número total necessário é de %d caracteres", linha, i, tam));

            for(int j = 0; j < tam; j++)
                dnaSeq[i][j] = sequenciaDeChars[j];
        }

        return dnaSeq;
    }

    private boolean hasTwoMutantDNASquences(char[][] dnaSeq){
        int altura = dnaSeq.length;
        int largura = dnaSeq[0].length;
        int count = 0;
        for(int i = 0; i < altura; i++){
            for(int j = 0; j < largura; j++){
                char atual = dnaSeq[i][j];

                //Verifica se existe mais de uma sequencia mutante
                if(count > 1)
                    return true;

                //Verificação horizontal
                if(j + 3 < largura &&
                        atual == dnaSeq[i][j + 3] &&
                        atual == dnaSeq[i][j + 2] &&
                        atual == dnaSeq[i][j + 1]){
                    count += 1;
                }
                //Verifica a vertical e as diagonais
                if(i + 3 < altura){

                    //Vertical
                    if(atual == dnaSeq[i + 3][j] &&
                            atual == dnaSeq[i + 2][j] &&
                            atual == dnaSeq[i + 1][j])
                        count += 1;

                    //Diagonal direita
                    if(j + 3 < largura &&
                            atual == dnaSeq[i+3][j+3] &&
                            atual == dnaSeq[i+2][j+2] &&
                            atual == dnaSeq[i+1][j+1])
                        count +=1;

                    //Diagonal esquerda
                    if(j - 3 >= 0 &&
                            atual == dnaSeq[i+3][j-3] &&
                            atual == dnaSeq[i+2][j-2] &&
                            atual == dnaSeq[i+1][j-1])
                        count +=1;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) throws DNAMalFormadoException {
        String[] dna = {"CTGAGA", "CTATGA", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};
        Detector detector = new Detector();
        System.out.println(detector.isMutant(dna));
    }
}
