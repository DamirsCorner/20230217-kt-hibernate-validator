package org.example

import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/hello")
class GreetingResource {

    @Path("/validate")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun autoValidation(@Valid person: ContactDetails?): Response =
        Response.noContent().build()
}