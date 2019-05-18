package br.com.birocredito.birocredito.enuns;

public enum OrgaoProtecaoCredito {
    SPC("SPC"),
    SERASA("SERASA"),
    BOA_VISTA("BOA_VISTA");
    private  String value;
    OrgaoProtecaoCredito(String value){
        this.value=value;
    }
}
