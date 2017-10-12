package org.pprls.client;

import com.google.gson.Gson;
import org.glassfish.jersey.client.ClientResponse;
import org.pprls.model.PerformanceBondDto;

import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class PerformanceBondClient {


    public List<PerformanceBondDto> findByName(String name)
    {
        Client client = ClientBuilder.newClient();

        WebTarget performanceBondResource = client
                .target("http://localhost:8090/PerformanceBond/")
                .queryParam("name",name);



        Invocation.Builder invocationBuilder =
                performanceBondResource
                        .request(MediaType.APPLICATION_JSON)
                        .header("Content-type","application/json");
        Response response = invocationBuilder.get();
        List<PerformanceBondDto> dtos = response.readEntity(new GenericType<List<PerformanceBondDto>>(){});


        return dtos;
    }

    public PerformanceBondDto save(PerformanceBondDto bond)
    {
        Gson gson = new Gson();

        Client client = ClientBuilder.newClient();

        WebTarget performanceBondResource = client
                .target("http://localhost:8090/PerformanceBond/")
                ;



        Invocation.Builder invocationBuilder =
                performanceBondResource
                        .request(MediaType.APPLICATION_JSON)
                        .header("Content-type","application/json");

        Response response = invocationBuilder.post(Entity.json(bond));


        if (response.getStatus() != 200)
        {
            throw new RuntimeException("Failed : Http error code: " + response.getStatus());
        }

        PerformanceBondDto dto = response.readEntity(PerformanceBondDto.class);

        return dto;
    }

}
