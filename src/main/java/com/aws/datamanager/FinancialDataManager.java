/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.datamanager;

import com.aws.connection.AwsConnection;
import com.aws.model.FinancialModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Siddharaj Atodaria
 */
public class FinancialDataManager {

    public static String insertPrivateFinancialDataManager(FinancialModel fmodel) throws ClassNotFoundException, SQLException {
        String type = "";
        try {
            Connection conn = AwsConnection.getConnection();
            Statement stmt = null;
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            StringBuilder sqlQuery = new StringBuilder();
            for (int j = 0; j < fmodel.getPrivatelst().size(); j++) {
                stmt = conn.createStatement();
                type = fmodel.getPrivatelst().get(j).tabtype;
                sqlQuery = new StringBuilder();
                sqlQuery.append("insert into reports (");
                sqlQuery.append("\"Year\",\"Quarter\",\"Total Revenue Value\",\"Gross Margin Value\",");
                sqlQuery.append("\"R&D Value\",\"S&M Value\",\"G&A Value\",\"Others Value\",");
                sqlQuery.append("\"Total Operating Expenses Value\",\"EBITDA\",\"EBITDA Margin Value\",\"Other Income Expenses Net Value\",");
                sqlQuery.append("\"Income Tax Expense Value\",\"Net Income Value\",\"Cash & Equivalents Value\",\"Restricted Cash\",");
                sqlQuery.append("\"Short Term Investments Value\",\"Inventory Value\",\"Net Receivables Value\",\"Prepaid Expenses\",");
                sqlQuery.append("\"Other Current Assets Value\",\"Total Current Assets Value\",\"PP&E Value\",\"Accumulated Amortization Value\",");
                sqlQuery.append("\"Intangible Assets Value\",\"Other Assets Value\",\"Total Assets Value\",\"Short/Current Long Term Debt Value\",");
                sqlQuery.append("\"Accounts Payable Value\",\"Deferred Revenue\",\"Accrued Liabilities\",\"Other Current Liabilities Value\",");
                sqlQuery.append("\"Total Current Liabilities Value\",\"Long Term Debt Value\",\"Other Liabilities Value\",\"Total Liabilities Value\",");
                sqlQuery.append("\"Capital Stock\",\"Retained Earnings Value\",\"Total Equity Value\",\"Total Liabilities & Equity\",");
                sqlQuery.append("\"LTV/CAC Value\",\"Company Type\",\"currencytype\",\"denomination\",\"type\",sfid) ");
                sqlQuery.append("VALUES (");
                sqlQuery.append(fmodel.getPrivatelst().get(j).year + ",");
                sqlQuery.append("'" + fmodel.getPrivatelst().get(j).qtr + "',");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).rev) && fmodel.getPrivatelst().get(j).rev != null) ? fmodel.getPrivatelst().get(j).rev : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).gm) && fmodel.getPrivatelst().get(j).gm != null) ? fmodel.getPrivatelst().get(j).gm : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).rd) && fmodel.getPrivatelst().get(j).rd != null) ? fmodel.getPrivatelst().get(j).rd : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).sm) && fmodel.getPrivatelst().get(j).sm != null) ? fmodel.getPrivatelst().get(j).sm : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ga) && fmodel.getPrivatelst().get(j).ga != null) ? fmodel.getPrivatelst().get(j).ga : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).oe) && fmodel.getPrivatelst().get(j).oe != null) ? fmodel.getPrivatelst().get(j).oe : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).toe) && fmodel.getPrivatelst().get(j).toe != null) ? fmodel.getPrivatelst().get(j).toe : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ebitba) && fmodel.getPrivatelst().get(j).ebitba != null) ? fmodel.getPrivatelst().get(j).ebitba : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ebitbam) && fmodel.getPrivatelst().get(j).ebitbam != null) ? fmodel.getPrivatelst().get(j).ebitbam : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).oien) && fmodel.getPrivatelst().get(j).oien != null) ? fmodel.getPrivatelst().get(j).oien : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).it) && fmodel.getPrivatelst().get(j).it != null) ? fmodel.getPrivatelst().get(j).it : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).nl) && fmodel.getPrivatelst().get(j).nl != null) ? fmodel.getPrivatelst().get(j).nl : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).cae) && fmodel.getPrivatelst().get(j).cae != null) ? fmodel.getPrivatelst().get(j).cae : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).rc) && fmodel.getPrivatelst().get(j).rc != null) ? fmodel.getPrivatelst().get(j).rc : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).sti) && fmodel.getPrivatelst().get(j).sti != null) ? fmodel.getPrivatelst().get(j).sti : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).invtry) && fmodel.getPrivatelst().get(j).invtry != null) ? fmodel.getPrivatelst().get(j).invtry : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ar) && fmodel.getPrivatelst().get(j).ar != null) ? fmodel.getPrivatelst().get(j).ar : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).pe) && fmodel.getPrivatelst().get(j).pe != null) ? fmodel.getPrivatelst().get(j).pe : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).oca) && fmodel.getPrivatelst().get(j).oca != null) ? fmodel.getPrivatelst().get(j).oca : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).tca) && fmodel.getPrivatelst().get(j).tca != null) ? fmodel.getPrivatelst().get(j).tca : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ppe) && fmodel.getPrivatelst().get(j).ppe != null) ? fmodel.getPrivatelst().get(j).ppe : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ada) && fmodel.getPrivatelst().get(j).ada != null) ? fmodel.getPrivatelst().get(j).ada : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).intg) && fmodel.getPrivatelst().get(j).intg != null) ? fmodel.getPrivatelst().get(j).intg : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).onca) && fmodel.getPrivatelst().get(j).onca != null) ? fmodel.getPrivatelst().get(j).onca : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).totass) && fmodel.getPrivatelst().get(j).totass != null) ? fmodel.getPrivatelst().get(j).totass : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).std) && fmodel.getPrivatelst().get(j).std != null) ? fmodel.getPrivatelst().get(j).std : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ap) && fmodel.getPrivatelst().get(j).ap != null) ? fmodel.getPrivatelst().get(j).ap : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).dr) && fmodel.getPrivatelst().get(j).dr != null) ? fmodel.getPrivatelst().get(j).dr : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).al) && fmodel.getPrivatelst().get(j).al != null) ? fmodel.getPrivatelst().get(j).al : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ocl) && fmodel.getPrivatelst().get(j).ocl != null) ? fmodel.getPrivatelst().get(j).ocl : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).tcl) && fmodel.getPrivatelst().get(j).tcl != null) ? fmodel.getPrivatelst().get(j).tcl : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ltd) && fmodel.getPrivatelst().get(j).ltd != null) ? fmodel.getPrivatelst().get(j).ltd : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).oncl) && fmodel.getPrivatelst().get(j).oncl != null) ? fmodel.getPrivatelst().get(j).oncl : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).totlia) && fmodel.getPrivatelst().get(j).totlia != null) ? fmodel.getPrivatelst().get(j).totlia : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).cs) && fmodel.getPrivatelst().get(j).cs != null) ? fmodel.getPrivatelst().get(j).cs : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).re) && fmodel.getPrivatelst().get(j).re != null) ? fmodel.getPrivatelst().get(j).re : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).toteq) && fmodel.getPrivatelst().get(j).toteq != null) ? fmodel.getPrivatelst().get(j).toteq : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).tle) && fmodel.getPrivatelst().get(j).tle != null) ? fmodel.getPrivatelst().get(j).tle : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPrivatelst().get(j).ltvac) && fmodel.getPrivatelst().get(j).ltvac != null) ? fmodel.getPrivatelst().get(j).ltvac : 0) + ",");
                sqlQuery.append("'" + fmodel.getPrivatelst().get(j).cmptype + "',");
                sqlQuery.append("'" + fmodel.getPrivatelst().get(j).currency + "',");
                sqlQuery.append("'" + fmodel.getPrivatelst().get(j).denomination + "',");
                sqlQuery.append("'" + fmodel.getPrivatelst().get(j).tabtype + "',");
                sqlQuery.append("'" + fmodel.getPrivatelst().get(j).sfid + "');");
                System.out.println("---sqlQuery----" + sqlQuery);
                stmt.executeUpdate(sqlQuery.toString());
                stmt.close();
            }

            conn.commit();
            conn.close();

        } catch (SQLException sqlex) {
            System.out.println("---sqlex----" + sqlex);
            Logger.getLogger(CompanyDataManager.class.getName()).log(Level.SEVERE, null, sqlex);
            return sqlex.toString();
        }
        return "Private " + type + " Financial Data created successfully";

    }

    public static String insertPublicFinancialDataManager(FinancialModel fmodel) throws ClassNotFoundException, SQLException {
        String type = "";
        try {
            Connection conn = AwsConnection.getConnection();
            Statement stmt = null;
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            StringBuilder sqlQuery = new StringBuilder();
            for (int j = 0; j < fmodel.getPubliclst().size(); j++) {
                stmt = conn.createStatement();
                type = fmodel.getPubliclst().get(j).tabtype;
                sqlQuery = new StringBuilder();
                sqlQuery.append("insert into reports (");
                sqlQuery.append("\"Year\",\"Quarter\",\"Total Revenue Value\",\"Cost of Revenue Value\",");
                sqlQuery.append("\"Gross Profit Value\",\"Gross Margin\",\"R&D Value\",\"SG&A Value\",");
                sqlQuery.append("\"Non Recurring Value\",\"Others Value\",\"Total Operating Expenses Value\",\"EBITDA\",");
                sqlQuery.append("\"Total Other Income Expenses Net Value\",\"EBIT Value\",\"Interest Expense Value\",\"Income Before Tax Value\",");
                sqlQuery.append("\"Income Tax Expense Value\",\"Minority Interest Value\",\"Discontinued Ops Value\",\"Extraordinary Items Value\",");
                sqlQuery.append("\"Effect of Accounting Changes Value\",\"Other Items Value\",\"Net Income Value\",\"Cash & Equivalents Value\",");
                sqlQuery.append("\"Short Term Investments Value\",\"Net Receivables Value\",\"Inventory Value\",\"Other Current Assets Value\",");
                sqlQuery.append("\"Total Current Assets Value\",\"Long Term Investments Value\",\"PP&E Value\",\"Goodwill Value\",");
                sqlQuery.append("\"Intangible Assets Value\",\"Accumulated Amortization Value\",\"Other Assets Value\",\"Deferred Long Term Asset Charges Value\",");
                sqlQuery.append("\"Total Assets Value\",\"Short/Current Long Term Debt Value\",\"Accounts Payable Value\",\"Other Current Liabilities Value\",");
                sqlQuery.append("\"Total Current Liabilities Value\",\"Long Term Debt Value\",\"Other Liabilities Value\",\"Deferred Long Term Liability Charges Value\",");
                sqlQuery.append("\"Minority Interest (BS)\",\"Negative Goodwill Value\",\"Total Liabilities Value\",\"Misc Stocks Options Warrants Value\",");
                sqlQuery.append("\"Redeemable Preferred Stock Value\",\"Preferred Stock Value\",\"Common Stock Value\",\"Retained Earnings Value\",");
                sqlQuery.append("\"Treasury Stock Value\",\"Capital Surplus Value\",\"Other Stockholder Equity Value\",\"Total Equity Value\",");
                sqlQuery.append("\"Total Liabilites & Equity\",\"LTV/CAC Value\",\"Company Type\",\"currencytype\",\"denomination\",\"type\",sfid) ");
                sqlQuery.append("VALUES (");
                sqlQuery.append(fmodel.getPubliclst().get(j).puyear + ",");
                sqlQuery.append("'" + fmodel.getPubliclst().get(j).puqtr + "',");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).purev) && fmodel.getPubliclst().get(j).purev != null) ? fmodel.getPubliclst().get(j).purev : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pucor) && fmodel.getPubliclst().get(j).pucor != null) ? fmodel.getPubliclst().get(j).pucor : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pugp) && fmodel.getPubliclst().get(j).pugp != null) ? fmodel.getPubliclst().get(j).pugp : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pugm) && fmodel.getPubliclst().get(j).pugm != null) ? fmodel.getPubliclst().get(j).pugm : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).purd) && fmodel.getPubliclst().get(j).purd != null) ? fmodel.getPubliclst().get(j).purd : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pusga) && fmodel.getPubliclst().get(j).pusga != null) ? fmodel.getPubliclst().get(j).pusga : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).punr) && fmodel.getPubliclst().get(j).punr != null) ? fmodel.getPubliclst().get(j).punr : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puoe) && fmodel.getPubliclst().get(j).puoe != null) ? fmodel.getPubliclst().get(j).puoe : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).putoe) && fmodel.getPubliclst().get(j).putoe != null) ? fmodel.getPubliclst().get(j).putoe : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puebitba) && fmodel.getPubliclst().get(j).puebitba != null) ? fmodel.getPubliclst().get(j).puebitba : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).putoien) && fmodel.getPubliclst().get(j).putoien != null) ? fmodel.getPubliclst().get(j).putoien : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puebit) && fmodel.getPubliclst().get(j).puebit != null) ? fmodel.getPubliclst().get(j).puebit : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puit) && fmodel.getPubliclst().get(j).puit != null) ? fmodel.getPubliclst().get(j).puit : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puibt) && fmodel.getPubliclst().get(j).puibt != null) ? fmodel.getPubliclst().get(j).puibt : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puite) && fmodel.getPubliclst().get(j).puite != null) ? fmodel.getPubliclst().get(j).puite : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pumi) && fmodel.getPubliclst().get(j).pumi != null) ? fmodel.getPubliclst().get(j).pumi : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pudo) && fmodel.getPubliclst().get(j).pudo != null) ? fmodel.getPubliclst().get(j).pudo : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puei) && fmodel.getPubliclst().get(j).puei != null) ? fmodel.getPubliclst().get(j).puei : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pueoac) && fmodel.getPubliclst().get(j).pueoac != null) ? fmodel.getPubliclst().get(j).pueoac : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puoi) && fmodel.getPubliclst().get(j).puoi != null) ? fmodel.getPubliclst().get(j).puoi : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).punil) && fmodel.getPubliclst().get(j).punil != null) ? fmodel.getPubliclst().get(j).punil : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pucae) && fmodel.getPubliclst().get(j).pucae != null) ? fmodel.getPubliclst().get(j).pucae : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pusti) && fmodel.getPubliclst().get(j).pusti != null) ? fmodel.getPubliclst().get(j).pusti : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).punre) && fmodel.getPubliclst().get(j).punre != null) ? fmodel.getPubliclst().get(j).punre : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puinvtry) && fmodel.getPubliclst().get(j).puinvtry != null) ? fmodel.getPubliclst().get(j).puinvtry : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puoca) && fmodel.getPubliclst().get(j).puoca != null) ? fmodel.getPubliclst().get(j).puoca : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).putca) && fmodel.getPubliclst().get(j).putca != null) ? fmodel.getPubliclst().get(j).putca : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pulti) && fmodel.getPubliclst().get(j).pulti != null) ? fmodel.getPubliclst().get(j).pulti : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puppe) && fmodel.getPubliclst().get(j).puppe != null) ? fmodel.getPubliclst().get(j).puppe : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pugw) && fmodel.getPubliclst().get(j).pugw != null) ? fmodel.getPubliclst().get(j).pugw : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puia) && fmodel.getPubliclst().get(j).puia != null) ? fmodel.getPubliclst().get(j).puia : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puaa) && fmodel.getPubliclst().get(j).puaa != null) ? fmodel.getPubliclst().get(j).puaa : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puoa) && fmodel.getPubliclst().get(j).puoa != null) ? fmodel.getPubliclst().get(j).puoa : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pudltac) && fmodel.getPubliclst().get(j).pudltac != null) ? fmodel.getPubliclst().get(j).pudltac : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puta) && fmodel.getPubliclst().get(j).puta != null) ? fmodel.getPubliclst().get(j).puta : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puscltd) && fmodel.getPubliclst().get(j).puscltd != null) ? fmodel.getPubliclst().get(j).puscltd : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puap) && fmodel.getPubliclst().get(j).puap != null) ? fmodel.getPubliclst().get(j).puap : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puocl) && fmodel.getPubliclst().get(j).puocl != null) ? fmodel.getPubliclst().get(j).puocl : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).putcl) && fmodel.getPubliclst().get(j).putcl != null) ? fmodel.getPubliclst().get(j).putcl : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pultd) && fmodel.getPubliclst().get(j).pultd != null) ? fmodel.getPubliclst().get(j).pultd : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puolia) && fmodel.getPubliclst().get(j).puolia != null) ? fmodel.getPubliclst().get(j).puolia : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pudltlc) && fmodel.getPubliclst().get(j).pudltlc != null) ? fmodel.getPubliclst().get(j).pudltlc : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pumi) && fmodel.getPubliclst().get(j).pumi != null) ? fmodel.getPubliclst().get(j).pumi : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pungw) && fmodel.getPubliclst().get(j).pungw != null) ? fmodel.getPubliclst().get(j).pungw : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).putotlia) && fmodel.getPubliclst().get(j).putotlia != null) ? fmodel.getPubliclst().get(j).putotlia : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pumsow) && fmodel.getPubliclst().get(j).pumsow != null) ? fmodel.getPubliclst().get(j).pumsow : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).purps) && fmodel.getPubliclst().get(j).purps != null) ? fmodel.getPubliclst().get(j).purps : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pups) && fmodel.getPubliclst().get(j).pups != null) ? fmodel.getPubliclst().get(j).pups : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pucs) && fmodel.getPubliclst().get(j).pucs != null) ? fmodel.getPubliclst().get(j).pucs : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pure) && fmodel.getPubliclst().get(j).pure != null) ? fmodel.getPubliclst().get(j).pure : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puts) && fmodel.getPubliclst().get(j).puts != null) ? fmodel.getPubliclst().get(j).puts : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pucs) && fmodel.getPubliclst().get(j).pucs != null) ? fmodel.getPubliclst().get(j).pucs : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).puose) && fmodel.getPubliclst().get(j).puose != null) ? fmodel.getPubliclst().get(j).puose : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).putote) && fmodel.getPubliclst().get(j).putote != null) ? fmodel.getPubliclst().get(j).putote : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).putle) && fmodel.getPubliclst().get(j).putle != null) ? fmodel.getPubliclst().get(j).putle : 0) + ",");
                sqlQuery.append(((!"".equals(fmodel.getPubliclst().get(j).pultvac) && fmodel.getPubliclst().get(j).pultvac != null) ? fmodel.getPubliclst().get(j).pultvac : 0) + ",");
                sqlQuery.append("'" + fmodel.getPubliclst().get(j).cmptype + "',");
                sqlQuery.append("'" + fmodel.getPubliclst().get(j).currency + "',");
                sqlQuery.append("'" + fmodel.getPubliclst().get(j).denomination + "',");
                sqlQuery.append("'" + fmodel.getPubliclst().get(j).tabtype + "',");
                sqlQuery.append("'" + fmodel.getPubliclst().get(j).sfid + "');");
                System.out.println("---sqlQuery----" + sqlQuery);
                stmt.executeUpdate(sqlQuery.toString());
                stmt.close();
            }

            conn.commit();
            conn.close();

        } catch (SQLException sqlex) {
            System.out.println("---sqlex----" + sqlex);
            Logger.getLogger(CompanyDataManager.class.getName()).log(Level.SEVERE, null, sqlex);
            return sqlex.toString();
        }
        return "Public "+type+" Financial Data created successfully";

    }

}
