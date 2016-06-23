/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.rest;

import com.aws.connection.AwsConnection;
import com.aws.datamanager.FinancialDataManager;
import com.aws.manager.CompanyManager;
import com.aws.manager.FinancialManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Siddharaj Atodaria
 */
@Path("/aws")
public class AwsService {

    @POST
    @Path("/company")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCompany(@HeaderParam("cmpstr") String cmpstr) throws ParseException, SQLException, ClassNotFoundException {
        return Response.status(201).entity(CompanyManager.insertCompanyManager(cmpstr)).build();
    }

//    @POST
//    @Path("/financial")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response createFinancialData(@HeaderParam("finstr") String finstr,@HeaderParam("sfid") String sfid,@HeaderParam("cmptype") String cmptype) throws ParseException, SQLException, ClassNotFoundException {
//        return Response.status(201).entity(FinancialManager.insertFinancialRecManager(finstr,sfid,cmptype)).build();
//    }
    @POST
    @Path("/financial")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createFinancialData(String finstr, @HeaderParam("sfid") String sfid, @HeaderParam("cmptype") String cmptype) throws ParseException, SQLException, ClassNotFoundException {
        return Response.status(201).entity(FinancialManager.insertFinancialRecManager(finstr, sfid, cmptype)).build();
    }

    @POST
    @Path("/getprivaterecord")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response test(@HeaderParam("sfid") String sfid) throws ParseException, SQLException, ClassNotFoundException {
        Connection conn = AwsConnection.getConnection();
        return Response.status(201).entity(FinancialDataManager.getPrivateRecord(conn,sfid)).build();
    }

    @POST
    @Path("/testbody")
    public Response someMethod(String x, @HeaderParam("data") String data) {

        System.out.println("x");
        return Response.status(201).entity("Welcome " + x + "====" + data).build();        // process string x, for example parse using JAXB and so on ...

    }

    @GET
    @Path("/test2")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test2(@HeaderParam("test2") String test2) throws ParseException, SQLException, ClassNotFoundException {
        return Response.status(201).entity("Welcome " + test2).build();
    }

}
