package br.com.birocredito.birocredito.enuns;
public enum StatusCadastral {
    POSITIVA("POSITIVA"),
    NEGATIVA("NEGATIVA");

    String value;
    StatusCadastral(String value){
        this.value = value;
    }
}
