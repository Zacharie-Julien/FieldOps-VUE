/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package WARSecurity;

import static WARSecurity.HashAlgo.generateSHA256Hash;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import sFEJB.AuthEJB;
import sFEJB.UsersEJB;
import sFEJB.DomainEJB;
import sFJPA.Domaine;
import sFJPA.Utilisateur;


/**
 * REST Web Service
 *
 * @author d4cd13ger
 */
@Path("/auth")
@Stateless
public class AuthWAR {
    
    @Inject
    private UsersEJB ejb;
    
    @Inject
    private AuthEJB authEjb;
    
    
    @Inject
    private DomainEJB domainEjb;
    
    @GET
    @Path("/login/{login}/passwd/{passwd}")
    public Response getAuthLogin(@PathParam("login") String login, @PathParam("passwd") String passwd, @Context HttpServletResponse response) {
        
        
        // A mettre dans un fichier de CONF 
        Key key = Keys.hmacShaKeyFor("MaSuperCleSecreteTrèsLongueEtSécurisée123!".getBytes(StandardCharsets.UTF_8));
        if (authEjb.verifyAuth(login, generateSHA256Hash(passwd))) {
                 
            Utilisateur user = ejb.getUserByLogin(login);
            Domaine domain;
            Integer idDomain;
            String role = authEjb.verifAdmin(user);
            
            if(role == "admin"){
                domain = domainEjb.getSingleDomainById(user.getId());
                idDomain = domain.getId();
            } else {
                idDomain = 0;
            }
            
            String token = Jwts.builder()
                    .issuer("d4d13ger.fr")
                    .subject("utilisateur")
                    .issuedAt(new Date())
                    .expiration(new Date(System.currentTimeMillis() + 3600000)) // 1h
                    .claim("id", user.getId())
                    .claim("idDomain", idDomain)
                    .claim("role", role)
                    .claim("login", user.getLogin())
                    .signWith(key)
                    .compact();          
            Cookie cookie = new Cookie("JWT", token);
            cookie.setPath("/");
            cookie.setMaxAge(3600); // Le cookie est valable dans le naviguateur pendant un durée d'une heure
            response.addCookie(cookie);

            return Response.ok().build();
        }

        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
