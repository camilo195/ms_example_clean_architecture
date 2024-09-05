package co.com.bancolombia.r2dbc.helper.enums;

import co.com.bancolombia.r2dbc.helper.enums.constants.TypeCodeDocumentConstants;
import co.com.bancolombia.r2dbc.helper.enums.constants.TypeDocumentConstants;

public enum TypeDocumentEnum {

    FS000(TypeCodeDocumentConstants.TIPDOC_FS000, TypeDocumentConstants.DIPLOMATIC_CARD),
    FS001(TypeCodeDocumentConstants.TIPDOC_FS001, TypeDocumentConstants.CITIZENSHIP_ID),
    FS002(TypeCodeDocumentConstants.TIPDOC_FS002, TypeDocumentConstants.FOREIGN_ID),
    FS003(TypeCodeDocumentConstants.TIPDOC_FS003, TypeDocumentConstants.NIT),
    FS004(TypeCodeDocumentConstants.TIPDOC_FS004, TypeDocumentConstants.IDENTITY_CARD),
    FS005(TypeCodeDocumentConstants.TIPDOC_FS005, TypeDocumentConstants.PASSPORT),
    FS006(TypeCodeDocumentConstants.TIPDOC_FS006, TypeDocumentConstants.FOREIGNER_ID_PN_NOT_RESIDENT),
    FS007(TypeCodeDocumentConstants.TIPDOC_FS007, TypeDocumentConstants.FOREIGNER_ID_PJ_NOT_RESIDENT),
    FS008(TypeCodeDocumentConstants.TIPDOC_FS008, TypeDocumentConstants.TRUST),
    FS009(TypeCodeDocumentConstants.TIPDOC_FS009, TypeDocumentConstants.BIRTH_CERTIFICATE),
    GET_TYPE("#","#");

    private final String documentTypeCode;
    private final String documentType;

    private String getDocumentTypeCode(){
        return documentTypeCode;
    }
    public String getDocumentType(){
        return documentType;
    }

    TypeDocumentEnum(String documentTypeCode,String documentType){
        this.documentTypeCode = documentTypeCode;
        this.documentType = documentType;
    }

    public static TypeDocumentEnum getTypeDocument(String documentType){
        for (TypeDocumentEnum typeDocumentEnum : values()){
            if (typeDocumentEnum.getDocumentTypeCode().contains(documentType)){
                return typeDocumentEnum;
            }
        }
        return GET_TYPE;
    }
}
