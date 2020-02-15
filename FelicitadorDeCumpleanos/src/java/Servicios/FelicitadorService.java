

package Servicios;

import DAO.*;
import DTO.*;
import com.google.gson.Gson;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.Access;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.json.JSONException;

@Path("Felicitador")
public class FelicitadorService {
    PersonaDAO dao = new PersonaDAO();
    @GET
    @Produces({"application/xml", "application/json", "text/plain", "text/html"})
    public Response creaMensaje(@QueryParam("nombre1") String nombre1, 
                                    @QueryParam("nombre2") String nombre2, 
                                        @QueryParam("apellido1") String apellido1, 
                                            @QueryParam("apellido2") String apellido2, 
                                                @QueryParam("fecha") String fecha) throws IOException, JSONException{ 
        Gson gson = new Gson();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-d");
        
        LocalDate fechaNac = LocalDate.parse(fecha, formato);
                
        Persona pers = new Persona();
        pers.setNombre1(nombre1);
        pers.setNombre2(nombre2);
        pers.setApellido1(apellido1);
        pers.setApellido2(apellido2);
        pers.setFecha(fechaNac);
        pers = dao.agregar(pers);
        return Response.ok(pers).build();
    }
    
}
