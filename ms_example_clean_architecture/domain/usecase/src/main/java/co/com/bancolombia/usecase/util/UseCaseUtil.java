package co.com.bancolombia.usecase.util;

import java.util.HashMap;
import java.util.Map;

public class UseCaseUtil {

    private static final Map<String, String> typeDocument = new HashMap<>();

    public static String getTypeDocument(String key){
        typeDocument.put("TIPDOC_FS000", "CARNET DIPLOMATICO");
        typeDocument.put("TIPDOC_FS001", "CEDULA DE CIUDADANIA");
        typeDocument.put("TIPDOC_FS002", "CEDULA DE EXTRANJERIA");
        typeDocument.put("TIPDOC_FS003", "NIT");
        typeDocument.put("TIPDOC_FS004", "TARJETA DE IDENTIDAD");
        typeDocument.put("TIPDOC_FS005", "PASAPORTE");
        typeDocument.put("TIPDOC_FS006", "ID EXTRANJERO PN NO RESIDENTE EN COLOMBIA");
        typeDocument.put("TIPDOC_FS007", "ID EXTRANJERO PJ NO RESIDENTE EN COLOMBIA");
        typeDocument.put("TIPDOC_FS008", "FIDEICOMISO");
        typeDocument.put("TIPDOC_FS009", "REGISTRO CIVIL");
        return typeDocument.get(key);
    }

}
