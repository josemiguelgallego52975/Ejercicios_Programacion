package Utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntradaDatos {
    public static void validarIban(String iban) throws Exception{
        if(iban==null||iban==""){throw new Exception("El IBAN no puede estar vacio");}
        Pattern pattern = Pattern.compile("^ES[0-9]{22}$");
        Matcher matcher = pattern.matcher(iban);
        if(!matcher.matches()){
            throw new Exception("El IBAN no es valido, debe tener el formato ES+22 numeros");
        }
    }

    public static Double validarSaldo(String codigo) throws Exception{
        if (codigo==null||codigo=="") {throw new Exception("El saldo no puede estar vacio");}
        try {
            double saldo= Double.parseDouble(codigo);
            return saldo;
        }catch(Exception e){
            throw new Exception("El saldo no puede estar vacio");
        }
    }

    public static void validarDni(String dni) throws Exception{
        if (dni.equals("")||dni==null) {throw new Exception("El DNI no puede estar vacio");}
        Pattern pattern=Pattern.compile("^[0-9]{8}[A-Z]$");
        Matcher matcher=pattern.matcher(dni);
        if (!matcher.matches()) {
            throw new Exception("El DNI no es valido, debe tener el formato 8 numeros + letra mayuscula");
        }
    }
}
