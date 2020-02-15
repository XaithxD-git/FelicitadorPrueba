
package DAO;

import DTO.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PersonaDAO {
    public PersonaDAO() {
    }
    
    public Persona agregar(Persona pers) throws IOException, JSONException {
        LocalDate hoy = LocalDate.now();
        Period periodo = Period.between(pers.getFecha(), hoy);
        pers.setEdad(periodo.getYears());
        pers.setMensajeCumpleaños(calcularCumpleaños(pers.getFecha()));
        //El metodo lo llame agregar por que en un principio pensé en usar una base de datos MongoDB, 
        //pero volviendo a leer el documento analice que ustedes no me pidieron eso, 
        //asi que las personas las termine manejando como una lista JSON en la vista.
        return pers;
    }
    
    static String calcularCumpleaños(LocalDate cumple) throws IOException, JSONException{ 
        String mensaje = "";
        Gson gson = new Gson(); 
        try {
            //Fecha actual
            LocalDate hoy = LocalDate.now();

            //Creo una fecha que deberia ser el cumpleaños pero con el año actual
            LocalDate siguienteCumple = cumple.withYear(hoy.getYear());

            //Pregunto si el cumpleaños es hoy
            if (siguienteCumple.isEqual(hoy)) {
                String poema = GenerarPoema();
                mensaje = "¡Su cumpleaños es hoy. Felicidades!\nY por que eres tan especial para nosotros te dedicamos el siguiente poema: \n" + poema;
            }else{
                //Pregunto si el cumpleaños ya paso agrego 1 año al siguiente cumpleaños
                if (siguienteCumple.isBefore(hoy)) {
                    siguienteCumple = siguienteCumple.plusYears(1);
                }
                
                //Obtengo el periodo que falta entre el siguiente cumple y hoy
                Period periodo = Period.between(hoy, siguienteCumple);
                long totalDias = ChronoUnit.DAYS.between(hoy, siguienteCumple);

                mensaje = "Restan ";
                if (periodo.getMonths()> 0) {
                    mensaje = mensaje + periodo.getMonths() + " meses, y ";
                }  
                mensaje = mensaje + periodo.getDays() + " días para su próximo cumpleaños.";

                if (periodo.getMonths()> 0) {
                    mensaje = mensaje + " (" + totalDias + " días en total)";
                }
            }

        }catch (DateTimeParseException exc) {
            //En caso de error al convertir la fecha
            mensaje =  "Error: la fecha no es válida!";
        } catch (MalformedURLException ex) {             
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensaje;
    }
    
    //Funciones para usar la api desde una api (Primera vez que uso una api dentro de otra api)
    private static String GenerarPoema() throws MalformedURLException, JSONException, IOException{
        URL url = new URL("https://www.poemist.com/api/v1/randompoems");
        InputStream is = url.openStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8"))); 
        String jsonText = readAll(rd);
        JSONArray json = new JSONArray(jsonText);
        JSONObject objeto = json.getJSONObject(0);
        String nombre = objeto.getString("content");
        return nombre;
    }
    
    private static String readAll(Reader rd) throws IOException { 
        StringBuilder sb = new StringBuilder(); 
        int cp; 
        while ((cp = rd.read()) != -1) { 
         sb.append((char) cp); 
        } 
        return sb.toString(); 
    }
    
}
