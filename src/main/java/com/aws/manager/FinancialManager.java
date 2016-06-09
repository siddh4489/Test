/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.manager;

import com.aws.datamanager.FinancialDataManager;
import com.aws.model.PrivateFinancial;
import com.aws.model.FinancialModel;
import com.aws.model.PublicFinancial;
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
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(finData);
        String retunStr;
        FinancialModel finObj = new FinancialModel();
        List<PrivateFinancial> priFinList = new ArrayList<PrivateFinancial>();
        List<PublicFinancial> pubFinList = new ArrayList<PublicFinancial>();
        int million = 1000000;
        int thousand = 1000;
        int multyplx = 1;

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
                fobj.setCurrency((String) json.get("currency"));
                fobj.setDenomination((String) json.get("denomination"));
                fobj.setYear((String) json.get("year_" + i));
                fobj.setQtr((String) json.get("qtr_" + i));
                fobj.setRev(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("rev_" + i).equals("") ? json.get("rev_" + i) : "0"))));
                fobj.setGm(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("gm_" + i).equals("") ? json.get("gm_" + i) : "0"))));
                fobj.setEbitba(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("ebitba_" + i).equals("") ? json.get("ebitba_" + i) : "0"))));
                fobj.setCor(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("cor_" + i).equals("") ? json.get("cor_" + i) : "0"))));
                fobj.setGp(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("gp_" + i).equals("") ? json.get("gp_" + i) : "0"))));
                fobj.setRd(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("rd_" + i).equals("") ? json.get("rd_" + i) : "0"))));
                fobj.setSm(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("sm_" + i).equals("") ? json.get("sm_" + i) : "0"))));
                fobj.setGa(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("ga_" + i).equals("") ? json.get("ga_" + i) : "0"))));
                fobj.setOe(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("oe_" + i).equals("") ? json.get("oe_" + i) : "0"))));
                fobj.setToe(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("toe_" + i).equals("") ? json.get("toe_" + i) : "0"))));
                fobj.setEbitbam(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("ebitbam_" + i).equals("") ? json.get("ebitbam_" + i) : "0"))));
                fobj.setOien(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("oien_" + i).equals("") ? json.get("oien_" + i) : "0"))));
                fobj.setIt(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("it_" + i).equals("") ? json.get("it_" + i) : "0"))));
                fobj.setNl(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("nl_" + i).equals("") ? json.get("nl_" + i) : "0"))));
                fobj.setCash(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("cash_" + i).equals("") ? json.get("cash_" + i) : "0"))));
                fobj.setTca(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("tca_" + i).equals("") ? json.get("tca_" + i) : "0"))));
                fobj.setTcl(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("tcl_" + i).equals("") ? json.get("tcl_" + i) : "0"))));
                fobj.setCae(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("cae_" + i).equals("") ? json.get("cae_" + i) : "0"))));
                fobj.setRc(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("rc_" + i).equals("") ? json.get("rc_" + i) : "0"))));
                fobj.setSti(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("sti_" + i).equals("") ? json.get("sti_" + i) : "0"))));
                fobj.setInvtry(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("invtry_" + i).equals("") ? json.get("invtry_" + i) : "0"))));
                fobj.setAr(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("ar_" + i).equals("") ? json.get("ar_" + i) : "0"))));
                fobj.setPe(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pe_" + i).equals("") ? json.get("pe_" + i) : "0"))));
                fobj.setOca(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("oca_" + i).equals("") ? json.get("oca_" + i) : "0"))));
                fobj.setPpe(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("ppe_" + i).equals("") ? json.get("ppe_" + i) : "0"))));
                fobj.setAda(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("ada_" + i).equals("") ? json.get("ada_" + i) : "0"))));
                fobj.setIntg(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("intg_" + i).equals("") ? json.get("intg_" + i) : "0"))));
                fobj.setOnca(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("onca_" + i).equals("") ? json.get("onca_" + i) : "0"))));
                fobj.setTotass(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("totass_" + i).equals("") ? json.get("totass_" + i) : "0"))));
                fobj.setStd(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("std_" + i).equals("") ? json.get("std_" + i) : "0"))));
                fobj.setAp(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("ap_" + i).equals("") ? json.get("ap_" + i) : "0"))));
                fobj.setDr(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("dr_" + i).equals("") ? json.get("dr_" + i) : "0"))));
                fobj.setAl(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("al_" + i).equals("") ? json.get("al_" + i) : "0"))));
                fobj.setOcl(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("ocl_" + i).equals("") ? json.get("ocl_" + i) : "0"))));
                fobj.setLtd(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("ltd_" + i).equals("") ? json.get("ltd_" + i) : "0"))));
                fobj.setOncl(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("oncl_" + i).equals("") ? json.get("oncl_" + i) : "0"))));
                fobj.setTotlia(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("totlia_" + i).equals("") ? json.get("totlia_" + i) : "0"))));
                fobj.setCs(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("cs_" + i).equals("") ? json.get("cs_" + i) : "0"))));
                fobj.setRe(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("re_" + i).equals("") ? json.get("re_" + i) : "0"))));
                fobj.setToteq(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("toteq_" + i).equals("") ? json.get("toteq_" + i) : "0"))));
                fobj.setTle(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("tle_" + i).equals("") ? json.get("tle_" + i) : "0"))));
                fobj.setFet(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("fet_" + i).equals("") ? json.get("fet_" + i) : "0"))));
                fobj.setLtv(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("ltv_" + i).equals("") ? json.get("ltv_" + i) : "0"))));
                fobj.setCac(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("cac_" + i).equals("") ? json.get("cac_" + i) : "0"))));
                fobj.setLtvac(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("ltvac_" + i).equals("") ? json.get("ltvac_" + i) : "0"))));
                priFinList.add(fobj);
            }
            finObj.setPrivatelst(priFinList);
            retunStr = FinancialDataManager.insertPrivateFinancialDataManager(finObj);
        } else {
            PublicFinancial pobj = new PublicFinancial();
            for (int i = 0; i < 8; i++) {
                pobj = new PublicFinancial();
                pobj.setCmptype(cmptype);
                pobj.setSfid(sfid);
                pobj.setCurrency((String) json.get("currency"));
                pobj.setDenomination((String) json.get("denomination"));
                pobj.setPuyear((String) json.get("puyear_" + i));
                pobj.setPuqtr((String) json.get("puqtr_" + i));
                pobj.setPurev(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("purev_" + i).equals("") ? json.get("purev_" + i) : "0"))));
                pobj.setPugm(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pugm_" + i).equals("") ? json.get("pugm_" + i) : "0"))));
                pobj.setPuebitba(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("puebitba_" + i).equals("") ? json.get("puebitba_" + i) : "0"))));
                pobj.setPucor(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pucor_" + i).equals("") ? json.get("pucor_" + i) : "0"))));
                pobj.setPugp(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pugp_" + i).equals("") ? json.get("pugp_" + i) : "0"))));
                pobj.setPurd(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("purd_" + i).equals("") ? json.get("purd_" + i) : "0"))));
                pobj.setPusga(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pusga_" + i).equals("") ? json.get("pusga_" + i) : "0"))));
                pobj.setPunr(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("punr_" + i).equals("") ? json.get("punr_" + i) : "0"))));
                pobj.setPungw(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pungw_" + i).equals("") ? json.get("pungw_" + i) : "0"))));
                pobj.setPutotlia(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("putotlia_" + i).equals("") ? json.get("putotlia_" + i) : "0"))));
                pobj.setPumsow(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pumsow_" + i).equals("") ? json.get("pumsow_" + i) : "0"))));
                pobj.setPurps(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("purps_" + i).equals("") ? json.get("purps_" + i) : "0"))));
                pobj.setPups(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pups_" + i).equals("") ? json.get("pups_" + i) : "0"))));
                pobj.setPucs(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pucs_" + i).equals("") ? json.get("pucs_" + i) : "0"))));
                pobj.setPuts(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("puts_" + i).equals("") ? json.get("puts_" + i) : "0"))));
                pobj.setPucas(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pucas_" + i).equals("") ? json.get("pucas_" + i) : "0"))));
                pobj.setPuose(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("puose_" + i).equals("") ? json.get("puose_" + i) : "0"))));
                pobj.setPutote(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("putote_" + i).equals("") ? json.get("putote_" + i) : "0"))));
                pobj.setPutle(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("putle_" + i).equals("") ? json.get("putle_" + i) : "0"))));
                pobj.setPuoe(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("puoe_" + i).equals("") ? json.get("puoe_" + i) : "0"))));
                pobj.setPutoe(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("putoe_" + i).equals("") ? json.get("putoe_" + i) : "0"))));
                pobj.setPutoien(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("putoien_" + i).equals("") ? json.get("putoien_" + i) : "0"))));
                pobj.setPuebit(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("puebit_" + i).equals("") ? json.get("puebit_" + i) : "0"))));
                pobj.setPuit(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("puit_" + i).equals("") ? json.get("puit_" + i) : "0"))));
                pobj.setPuibt(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("puibt_" + i).equals("") ? json.get("puibt_" + i) : "0"))));
                pobj.setPuite(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("puite_" + i).equals("") ? json.get("puite_" + i) : "0"))));
                pobj.setPumi(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pumi_" + i).equals("") ? json.get("pumi_" + i) : "0"))));
                pobj.setPudo(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pudo_" + i).equals("") ? json.get("pudo_" + i) : "0"))));
                pobj.setPuei(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("puei_" + i).equals("") ? json.get("puei_" + i) : "0"))));
                pobj.setPueoac(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pueoac_" + i).equals("") ? json.get("pueoac_" + i) : "0"))));
                pobj.setPuoi(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("puoi_" + i).equals("") ? json.get("puoi_" + i) : "0"))));
                pobj.setPunil(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("punil_" + i).equals("") ? json.get("punil_" + i) : "0"))));
                pobj.setPucash(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pucash_" + i).equals("") ? json.get("pucash_" + i) : "0"))));
                pobj.setPutca(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("putca_" + i).equals("") ? json.get("putca_" + i) : "0"))));
                pobj.setPutcl(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("putcl_" + i).equals("") ? json.get("putcl_" + i) : "0"))));
                pobj.setPucae(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pucae_" + i).equals("") ? json.get("pucae_" + i) : "0"))));
                pobj.setPusti(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pusti_" + i).equals("") ? json.get("pusti_" + i) : "0"))));
                pobj.setPunre(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("punre_" + i).equals("") ? json.get("punre_" + i) : "0"))));
                pobj.setPuinvtry(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("puinvtry_" + i).equals("") ? json.get("puinvtry_" + i) : "0"))));
                pobj.setPuoca(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("puoca_" + i).equals("") ? json.get("puoca_" + i) : "0"))));
                pobj.setPutcass(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("putcass_" + i).equals("") ? json.get("putcass_" + i) : "0"))));
                pobj.setPulti(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pulti_" + i).equals("") ? json.get("pulti_" + i) : "0"))));
                pobj.setPuppe(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("puppe_" + i).equals("") ? json.get("puppe_" + i) : "0"))));
                pobj.setPugw(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pugw_" + i).equals("") ? json.get("pugw_" + i) : "0"))));
                pobj.setPuia(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("puia_" + i).equals("") ? json.get("puia_" + i) : "0"))));
                pobj.setPuaa(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("puaa_" + i).equals("") ? json.get("puaa_" + i) : "0"))));
                pobj.setPuoa(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("puoa_" + i).equals("") ? json.get("puoa_" + i) : "0"))));
                pobj.setPudltac(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pudltac_" + i).equals("") ? json.get("pudltac_" + i) : "0"))));
                pobj.setPuta(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("puta_" + i).equals("") ? json.get("puta_" + i) : "0"))));
                pobj.setPuscltd(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("puscltd_" + i).equals("") ? json.get("puscltd_" + i) : "0"))));
                pobj.setPuap(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("puap_" + i).equals("") ? json.get("puap_" + i) : "0"))));
                pobj.setPuocl(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("puocl_" + i).equals("") ? json.get("puocl_" + i) : "0"))));
                pobj.setPultd(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pultd_" + i).equals("") ? json.get("pultd_" + i) : "0"))));
                pobj.setPuolia(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("puolia_" + i).equals("") ? json.get("puolia_" + i) : "0"))));
                pobj.setPudltlc(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pudltlc_" + i).equals("") ? json.get("pudltlc_" + i) : "0"))));
                pobj.setPumino(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pumino_" + i).equals("") ? json.get("pumino_" + i) : "0"))));
                pobj.setPufet(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pufet_" + i).equals("") ? json.get("pufet_" + i) : "0"))));
                pobj.setPultv(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pultv_" + i).equals("") ? json.get("pultv_" + i) : "0"))));
                pobj.setPucac(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pucac_" + i).equals("") ? json.get("pucac_" + i) : "0"))));
                pobj.setPultvac(Integer.toString(multyplx * Integer.parseInt((String) (!json.get("pultvac_" + i).equals("") ? json.get("pultvac_" + i) : "0"))));

                pubFinList.add(pobj);
            }
            finObj.setPubliclst(pubFinList);
            retunStr = FinancialDataManager.insertPublicFinancialDataManager(finObj);
        }

        return retunStr;
    }

}
