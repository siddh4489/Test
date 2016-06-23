/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.test;

import com.aws.connection.AwsConnection;
import com.aws.datamanager.FinancialDataManager;
import com.aws.manager.FinancialManager;
import java.sql.Connection;
import java.sql.SQLException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author siddhraj.atodaria
 */
public class Test2 {

    public static void main(String[] args) throws Exception {
       Connection conn = AwsConnection.getConnection();
        System.out.println("----"+FinancialDataManager.getPrivateRecord(conn, "0012800000dw2X3"));
        //FinancialDataManager.update(conn, "0012800000dw2X3_0","2018");
        //System.out.println("-- delete --"+FinancialDataManager.getDelete(conn, "0012800000dw2X3"));
    }

}
