/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.manager;

import com.aws.connection.AwsConnection;
import com.aws.datamanager.FinancialDataManager;
import com.aws.model.PrivateFinancial;
import com.aws.model.FinancialModel;
import com.aws.model.PublicFinancial;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Siddharaj Atodaria
 */
public class FinancialManager {

        public static String insertFinancialRecManager(String finData, String sfid, String cmptype) throws ParseException, SQLException, ClassNotFoundException {
        Connection conn = AwsConnection.getConnection();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(finData);
        String retunStr;
        FinancialModel finObj = new FinancialModel();
        List<PrivateFinancial> priFinList = new ArrayList<PrivateFinancial>();
        List<PublicFinancial> pubFinList = new ArrayList<PublicFinancial>();
        int million = 1000000;
        int thousand = 1000;
        int multyplx = 1;
        String preval = "";

        if ("Projection".equalsIgnoreCase((String) json.get("tabtype"))) {
            preval = "pro";
        } else {
            preval = "";
        }

        if (cmptype.equalsIgnoreCase("private")) {
            if ("Thousands".equalsIgnoreCase((String) json.get("currency"))) {
                multyplx = thousand;
            } else if ("Millions".equalsIgnoreCase((String) json.get("currency"))) {
                multyplx = million;
            }

            PrivateFinancial fobj = new PrivateFinancial();
            for (int i = 0; i < 8; i++) {
                fobj = new PrivateFinancial();
                fobj.setCmptype(cmptype);
                fobj.setSfid(sfid);
                fobj.setSfdcunique(sfid+'_'+i);
                fobj.setTabtype((String) json.get("tabtype"));
                fobj.setCurrency((String) json.get("currency"));
                fobj.setDenomination((String) json.get("denomination"));
                fobj.setYear((String) json.get(preval+"year_" + i));
                fobj.setQtr((String) json.get(preval+"qtr_" + i));
                fobj.setRev(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"rev_" + i).equals("") && !json.get(preval+"rev_" + i).toString().contains("-"))? json.get(preval+"rev_" + i) : "0"))));
                fobj.setGm(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"gm_" + i).equals("")&& !json.get(preval+"gm_" + i).toString().contains("-")) ? json.get(preval+"gm_" + i) : "0"))));
                fobj.setEbitba(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"ebitba_" + i).equals("") && !json.get(preval+"ebitba_" + i).toString().contains("-"))? json.get(preval+"ebitba_" + i) : "0"))));
                fobj.setCor(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"cor_" + i).equals("") && !json.get(preval+"cor_" + i).toString().contains("-"))? json.get(preval+"cor_" + i) : "0"))));
                fobj.setGp(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"gp_" + i).equals("")&& !json.get(preval+"gp_" + i).toString().contains("-")) ? json.get(preval+"gp_" + i) : "0"))));
                fobj.setRd(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"rd_" + i).equals("") && !json.get(preval+"rd_" + i).toString().contains("-"))? json.get(preval+"rd_" + i) : "0"))));
                fobj.setSm(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"sm_" + i).equals("") && !json.get(preval+"sm_" + i).toString().contains("-"))? json.get(preval+"sm_" + i) : "0"))));
                fobj.setGa(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"ga_" + i).equals("") && !json.get(preval+"ga_" + i).toString().contains("-"))? json.get(preval+"ga_" + i) : "0"))));
                fobj.setOe(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"oe_" + i).equals("")&& !json.get(preval+"oe_" + i).toString().contains("-")) ? json.get(preval+"oe_" + i) : "0"))));
                fobj.setToe(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"toe_" + i).equals("")&& !json.get(preval+"toe_" + i).toString().contains("-")) ? json.get(preval+"toe_" + i) : "0"))));
                fobj.setEbitbam(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"ebitbam_" + i).equals("")&& !json.get(preval+"ebitbam_" + i).toString().contains("-")) ? json.get(preval+"ebitbam_" + i) : "0"))));
                fobj.setOien(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"oien_" + i).equals("") && !json.get(preval+"oien_" + i).toString().contains("-"))? json.get(preval+"oien_" + i) : "0"))));
                fobj.setIt(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"it_" + i).equals("") && !json.get(preval+"it_" + i).toString().contains("-"))? json.get(preval+"it_" + i) : "0"))));
                fobj.setNl(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"nl_" + i).equals("") && !json.get(preval+"nl_" + i).toString().contains("-"))? json.get(preval+"nl_" + i) : "0"))));
                fobj.setCash(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"cash_" + i).equals("") && !json.get(preval+"cash_" + i).toString().contains("-"))? json.get(preval+"cash_" + i) : "0"))));
                fobj.setTca(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"tca_" + i).equals("") && !json.get(preval+"tca_" + i).toString().contains("-"))? json.get(preval+"tca_" + i) : "0"))));
                fobj.setTcl(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"tcl_" + i).equals("")&& !json.get(preval+"tcl_" + i).toString().contains("-")) ? json.get(preval+"tcl_" + i) : "0"))));
                fobj.setCae(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"cae_" + i).equals("")&& !json.get(preval+"cae_" + i).toString().contains("-")) ? json.get(preval+"cae_" + i) : "0"))));
                fobj.setRc(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"rc_" + i).equals("")&& !json.get(preval+"rc_" + i).toString().contains("-")) ? json.get(preval+"rc_" + i) : "0"))));
                fobj.setSti(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"sti_" + i).equals("") && !json.get(preval+"sti_" + i).toString().contains("-"))? json.get(preval+"sti_" + i) : "0"))));
                fobj.setInvtry(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"invtry_" + i).equals("")&& !json.get(preval+"invtry_" + i).toString().contains("-")) ? json.get(preval+"invtry_" + i) : "0"))));
                fobj.setAr(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"ar_" + i).equals("")&& !json.get(preval+"ar_" + i).toString().contains("-")) ? json.get(preval+"ar_" + i) : "0"))));
                fobj.setPe(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pe_" + i).equals("")&& !json.get(preval+"pe_" + i).toString().contains("-")) ? json.get(preval+"pe_" + i) : "0"))));
                fobj.setOca(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"oca_" + i).equals("") && !json.get(preval+"oca_" + i).toString().contains("-"))? json.get(preval+"oca_" + i) : "0"))));
                fobj.setPpe(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"ppe_" + i).equals("") && !json.get(preval+"ppe_" + i).toString().contains("-"))? json.get(preval+"ppe_" + i) : "0"))));
                fobj.setAda(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"ada_" + i).equals("") && !json.get(preval+"ada_" + i).toString().contains("-"))? json.get(preval+"ada_" + i) : "0"))));
                fobj.setIntg(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"intg_" + i).equals("")&& !json.get(preval+"intg_" + i).toString().contains("-"))  ? json.get(preval+"intg_" + i) : "0"))));
                fobj.setOnca(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"onca_" + i).equals("")&& !json.get(preval+"onca_" + i).toString().contains("-")) ? json.get(preval+"onca_" + i) : "0"))));
                fobj.setTotass(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"totass_" + i).equals("") && !json.get(preval+"totass_" + i).toString().contains("-"))? json.get(preval+"totass_" + i) : "0"))));
                fobj.setStd(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"std_" + i).equals("")&& !json.get(preval+"std_" + i).toString().contains("-")) ? json.get(preval+"std_" + i) : "0"))));
                fobj.setAp(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"ap_" + i).equals("") && !json.get(preval+"ap_" + i).toString().contains("-"))? json.get(preval+"ap_" + i) : "0"))));
                fobj.setDr(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"dr_" + i).equals("") && !json.get(preval+"dr_" + i).toString().contains("-"))? json.get(preval+"dr_" + i) : "0"))));
                fobj.setAl(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"al_" + i).equals("")&& !json.get(preval+"al_" + i).toString().contains("-")) ? json.get(preval+"al_" + i) : "0"))));
                fobj.setOcl(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"ocl_" + i).equals("")&& !json.get(preval+"ocl_" + i).toString().contains("-")) ? json.get(preval+"ocl_" + i) : "0"))));
                fobj.setLtd(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"ltd_" + i).equals("") && !json.get(preval+"ltd_" + i).toString().contains("-"))? json.get(preval+"ltd_" + i) : "0"))));
                fobj.setOncl(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"oncl_" + i).equals("") && !json.get(preval+"oncl_" + i).toString().contains("-"))? json.get(preval+"oncl_" + i) : "0"))));
                fobj.setTotlia(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"totlia_" + i).equals("")&& !json.get(preval+"totlia_" + i).toString().contains("-")) ? json.get(preval+"totlia_" + i) : "0"))));
                fobj.setCs(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"cs_" + i).equals("")&& !json.get(preval+"cs_" + i).toString().contains("-")) ? json.get(preval+"cs_" + i) : "0"))));
                fobj.setRe(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"re_" + i).equals("")&& !json.get(preval+"re_" + i).toString().contains("-")) ? json.get(preval+"re_" + i) : "0"))));
                fobj.setToteq(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"toteq_" + i).equals("")&& !json.get(preval+"toteq_" + i).toString().contains("-")) ? json.get(preval+"toteq_" + i) : "0"))));
                fobj.setTle(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"tle_" + i).equals("")&& !json.get(preval+"tle_" + i).toString().contains("-")) ? json.get(preval+"tle_" + i) : "0"))));
                fobj.setFet(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"fet_" + i).equals("")&& !json.get(preval+"fet_" + i).toString().contains("-")) ? json.get(preval+"fet_" + i) : "0"))));
                fobj.setLtv(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"ltv_" + i).equals("")&& !json.get(preval+"ltv_" + i).toString().contains("-")) ? json.get(preval+"ltv_" + i) : "0"))));
                fobj.setCac(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"cac_" + i).equals("")&& !json.get(preval+"cac_" + i).toString().contains("-")) ? json.get(preval+"cac_" + i) : "0"))));
                fobj.setLtvac(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"ltvac_" + i).equals("") && !json.get(preval+"ltvac_" + i).toString().contains("-"))? json.get(preval+"ltvac_" + i) : "0"))));
                priFinList.add(fobj);
            }
            finObj.setPrivatelst(priFinList);
            retunStr = FinancialDataManager.bypassFinancialRecord(conn,finObj);
        } else {
            PublicFinancial pobj = new PublicFinancial();
            for (int i = 0; i < 8; i++) {
                pobj = new PublicFinancial();
                pobj.setCmptype(cmptype);
                pobj.setSfid(sfid);
                pobj.setTabtype((String) json.get("tabtype"));
                pobj.setCurrency((String) json.get("currency"));
                pobj.setDenomination((String) json.get("denomination"));
                pobj.setPuyear((String) json.get(preval+"puyear_" + i));
                pobj.setPuqtr((String) json.get(preval+"puqtr_" + i));
                pobj.setPurev(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"purev_" + i).equals("") && !json.get(preval+"purev_" + i).toString().contains("-")) ? json.get(preval+"purev_" + i) : "0"))));
                pobj.setPugm(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pugm_" + i).equals("") && !json.get(preval+"pugm_" + i).toString().contains("-")) ? json.get(preval+"pugm_" + i) : "0"))));
                pobj.setPuebitba(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"puebitba_" + i).equals("") && !json.get(preval+"puebitba_" + i).toString().contains("-")) ? json.get(preval+"puebitba_" + i) : "0"))));
                pobj.setPucor(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pucor_" + i).equals("") && !json.get(preval+"pucor_" + i).toString().contains("-"))? json.get(preval+"pucor_" + i) : "0"))));
                pobj.setPugp(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pugp_" + i).equals("") && !json.get(preval+"pugp_" + i).toString().contains("-")) ? json.get(preval+"pugp_" + i) : "0"))));
                pobj.setPurd(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"purd_" + i).equals("") && !json.get(preval+"purd_" + i).toString().contains("-")) ? json.get(preval+"purd_" + i) : "0"))));
                pobj.setPusga(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pusga_" + i).equals("")&& !json.get(preval+"pusga_" + i).toString().contains("-")) ? json.get(preval+"pusga_" + i) : "0"))));
                pobj.setPunr(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"punr_" + i).equals("")&& !json.get(preval+"punr_" + i).toString().contains("-")) ? json.get(preval+"punr_" + i) : "0"))));
                pobj.setPungw(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pungw_" + i).equals("") && !json.get(preval+"pungw_" + i).toString().contains("-"))? json.get(preval+"pungw_" + i) : "0"))));
                pobj.setPutotlia(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"putotlia_" + i).equals("") && !json.get(preval+"putotlia_" + i).toString().contains("-"))? json.get(preval+"putotlia_" + i) : "0"))));
                pobj.setPumsow(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pumsow_" + i).equals("") && !json.get(preval+"pumsow_" + i).toString().contains("-"))? json.get(preval+"pumsow_" + i) : "0"))));
                pobj.setPurps(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"purps_" + i).equals("") && !json.get(preval+"purps_" + i).toString().contains("-"))? json.get(preval+"purps_" + i) : "0"))));
                pobj.setPups(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pups_" + i).equals("") && !json.get(preval+"pups_" + i).toString().contains("-"))? json.get(preval+"pups_" + i) : "0"))));
                pobj.setPucs(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pucs_" + i).equals("")&& !json.get(preval+"pucs_" + i).toString().contains("-")) ? json.get(preval+"pucs_" + i) : "0"))));
                pobj.setPuts(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"puts_" + i).equals("")&& !json.get(preval+"puts_" + i).toString().contains("-")) ? json.get(preval+"puts_" + i) : "0"))));
                pobj.setPucas(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pucas_" + i).equals("")&& !json.get(preval+"pucas_" + i).toString().contains("-")) ? json.get(preval+"pucas_" + i) : "0"))));
                pobj.setPuose(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"puose_" + i).equals("") && !json.get(preval+"puose_" + i).toString().contains("-"))? json.get(preval+"puose_" + i) : "0"))));
                pobj.setPutote(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"putote_" + i).equals("")&& !json.get(preval+"putote_" + i).toString().contains("-")) ? json.get(preval+"putote_" + i) : "0"))));
                pobj.setPutle(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"putle_" + i).equals("")&& !json.get(preval+"putle_" + i).toString().contains("-")) ? json.get(preval+"putle_" + i) : "0"))));
                pobj.setPuoe(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"puoe_" + i).equals("")&& !json.get(preval+"puoe_" + i).toString().contains("-")) ? json.get(preval+"puoe_" + i) : "0"))));
                pobj.setPutoe(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"putoe_" + i).equals("") && !json.get(preval+"putoe_" + i).toString().contains("-"))? json.get(preval+"putoe_" + i) : "0"))));
                pobj.setPutoien(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"putoien_" + i).equals("")&& !json.get(preval+"putoien_" + i).toString().contains("-")) ? json.get(preval+"putoien_" + i) : "0"))));
                pobj.setPuebit(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"puebit_" + i).equals("") && !json.get(preval+"puebit_" + i).toString().contains("-"))? json.get(preval+"puebit_" + i) : "0"))));
                pobj.setPuit(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"puit_" + i).equals("")&& !json.get(preval+"puit_" + i).toString().contains("-")) ? json.get(preval+"puit_" + i) : "0"))));
                pobj.setPuibt(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"puibt_" + i).equals("") && !json.get(preval+"puibt_" + i).toString().contains("-"))? json.get(preval+"puibt_" + i) : "0"))));
                pobj.setPuite(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"puite_" + i).equals("") && !json.get(preval+"puite_" + i).toString().contains("-"))? json.get(preval+"puite_" + i) : "0"))));
                pobj.setPumi(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pumi_" + i).equals("")&& !json.get(preval+"pumi_" + i).toString().contains("-")) ? json.get(preval+"pumi_" + i) : "0"))));
                pobj.setPudo(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pudo_" + i).equals("")&& !json.get(preval+"pudo_" + i).toString().contains("-")) ? json.get(preval+"pudo_" + i) : "0"))));
                pobj.setPuei(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"puei_" + i).equals("")&& !json.get(preval+"puei_" + i).toString().contains("-")) ? json.get(preval+"puei_" + i) : "0"))));
                pobj.setPueoac(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pueoac_" + i).equals("") && !json.get(preval+"pueoac_" + i).toString().contains("-"))? json.get(preval+"pueoac_" + i) : "0"))));
                pobj.setPuoi(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"puoi_" + i).equals("")&& !json.get(preval+"puoi_" + i).toString().contains("-")) ? json.get(preval+"puoi_" + i) : "0"))));
                pobj.setPunil(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"punil_" + i).equals("")&& !json.get(preval+"punil_" + i).toString().contains("-")) ? json.get(preval+"punil_" + i) : "0"))));
                pobj.setPucash(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pucash_" + i).equals("") && !json.get(preval+"pucash_" + i).toString().contains("-"))? json.get(preval+"pucash_" + i) : "0"))));
                pobj.setPutca(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"putca_" + i).equals("") && !json.get(preval+"putca_" + i).toString().contains("-"))? json.get(preval+"putca_" + i) : "0"))));
                pobj.setPutcl(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"putcl_" + i).equals("") && !json.get(preval+"putcl_" + i).toString().contains("-")) ? json.get(preval+"putcl_" + i) : "0"))));
                pobj.setPucae(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pucae_" + i).equals("") && !json.get(preval+"pucae_" + i).toString().contains("-"))? json.get(preval+"pucae_" + i) : "0"))));
                pobj.setPusti(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pusti_" + i).equals("") && !json.get(preval+"pusti_" + i).toString().contains("-"))? json.get(preval+"pusti_" + i) : "0"))));
                pobj.setPunre(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"punre_" + i).equals("") && !json.get(preval+"punre_" + i).toString().contains("-"))? json.get(preval+"punre_" + i) : "0"))));
                pobj.setPuinvtry(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"puinvtry_" + i).equals("")&& !json.get(preval+"puinvtry_" + i).toString().contains("-")) ? json.get(preval+"puinvtry_" + i) : "0"))));
                pobj.setPuoca(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"puoca_" + i).equals("")&& !json.get(preval+"puoca_" + i).toString().contains("-")) ? json.get(preval+"puoca_" + i) : "0"))));
                pobj.setPutcass(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"putcass_" + i).equals("") && !json.get(preval+"putcass_" + i).toString().contains("-"))? json.get(preval+"putcass_" + i) : "0"))));
                pobj.setPulti(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pulti_" + i).equals("")&& !json.get(preval+"pulti_" + i).toString().contains("-")) ? json.get(preval+"pulti_" + i) : "0"))));
                pobj.setPuppe(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"puppe_" + i).equals("")&& !json.get(preval+"puppe_" + i).toString().contains("-")) ? json.get(preval+"puppe_" + i) : "0"))));
                pobj.setPugw(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pugw_" + i).equals("") && !json.get(preval+"pugw_" + i).toString().contains("-"))? json.get(preval+"pugw_" + i) : "0"))));
                pobj.setPuia(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"puia_" + i).equals("") && !json.get(preval+"puia_" + i).toString().contains("-"))? json.get(preval+"puia_" + i) : "0"))));
                pobj.setPuaa(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"puaa_" + i).equals("") && !json.get(preval+"puaa_" + i).toString().contains("-"))? json.get(preval+"puaa_" + i) : "0"))));
                pobj.setPuoa(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"puoa_" + i).equals("") && !json.get(preval+"puoa_" + i).toString().contains("-"))? json.get(preval+"puoa_" + i) : "0"))));
                pobj.setPudltac(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pudltac_" + i).equals("")&& !json.get(preval+"pudltac_" + i).toString().contains("-")) ? json.get(preval+"pudltac_" + i) : "0"))));
                pobj.setPuta(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"puta_" + i).equals("") && !json.get(preval+"puta_" + i).toString().contains("-"))? json.get(preval+"puta_" + i) : "0"))));
                pobj.setPuscltd(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"puscltd_" + i).equals("") && !json.get(preval+"puscltd_" + i).toString().contains("-"))? json.get(preval+"puscltd_" + i) : "0"))));
                pobj.setPuap(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"puap_" + i).equals("") && !json.get(preval+"puap_" + i).toString().contains("-"))? json.get(preval+"puap_" + i) : "0"))));
                pobj.setPuocl(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"puocl_" + i).equals("") && !json.get(preval+"puocl_" + i).toString().contains("-"))? json.get(preval+"puocl_" + i) : "0"))));
                pobj.setPultd(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pultd_" + i).equals("")&& !json.get(preval+"pultd_" + i).toString().contains("-")) ? json.get(preval+"pultd_" + i) : "0"))));
                pobj.setPuolia(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"puolia_" + i).equals("")&& !json.get(preval+"puolia_" + i).toString().contains("-")) ? json.get(preval+"puolia_" + i) : "0"))));
                pobj.setPudltlc(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pudltlc_" + i).equals("")&& !json.get(preval+"pudltlc_" + i).toString().contains("-")) ? json.get(preval+"pudltlc_" + i) : "0"))));
                pobj.setPumino(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pumino_" + i).equals("") && !json.get(preval+"pumino_" + i).toString().contains("-"))? json.get(preval+"pumino_" + i) : "0"))));
                pobj.setPufet(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pufet_" + i).equals("")&& !json.get(preval+"pufet_" + i).toString().contains("-")) ? json.get(preval+"pufet_" + i) : "0"))));
                pobj.setPultv(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pultv_" + i).equals("")&& !json.get(preval+"pultv_" + i).toString().contains("-")) ? json.get(preval+"pultv_" + i) : "0"))));
                pobj.setPucac(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pucac_" + i).equals("") && !json.get(preval+"pucac_" + i).toString().contains("-"))? json.get(preval+"pucac_" + i) : "0"))));
                pobj.setPultvac(Integer.toString(multyplx * Integer.parseInt((String) ((!json.get(preval+"pultvac_" + i).equals("")&& !json.get(preval+"pultvac_" + i).toString().contains("-")) ? json.get(preval+"pultvac_" + i) : "0"))));

                pubFinList.add(pobj);
            }
            finObj.setPubliclst(pubFinList);
            retunStr = FinancialDataManager.insertPublicFinancialDataManager(conn,finObj);
        }

        return retunStr;
    }
        
        

}
