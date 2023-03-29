package jaxws;

import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import client.*;

/**
 *
 * @author Logan
 */
@Path("client")
public class ClientRessource {
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FormationResource
     */
    public ClientRessource()
    {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Client> getJson()
    {
        ArrayList<Client> lesClients = GestionSQL.ListeDesClients();
        return lesClients;
    }

    @GET
    @Path("numero")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Client> getJson(@QueryParam("numero") String numero)
    {
        ArrayList<Client> lesIngredients = GestionSQL.ListeDesClients("numero");
        return lesIngredients;
    }
}
