package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/computer")
public class ComputerResource {

    private Logger logger = LoggerFactory.getLogger(ComputerResource.class);
    private static final List<Computer> computers = new ArrayList<>();

    //    different result compare to books
//    curl -X POST -H "Content-Type:application/xml" localhost:8081/computer -d '<computer><brand>mac</brand><serialNumber>111</serialNumber></computer>'
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public List<Computer> addComputer(Computer computer) {
        computers.add(computer);
        computers.forEach(it -> {
            logger.info(it.toString());
        });
        return computers;
    }
}
