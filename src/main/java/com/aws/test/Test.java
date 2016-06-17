/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.test;

import com.aws.connection.AwsConnection;
import com.aws.manager.CompanyManager;
import com.aws.manager.FinancialManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Siddharaj Atodaria
 */
public class Test {

    public static void main(String[] args) throws ParseException, SQLException, ClassNotFoundException {
        //String privateCmp="{\"currency\":\"Currency\",\"denomination\":\"Denomination\",\"year_0\":\"2015\",\"qtr_0\":\"Q1\",\"rev_0\":\"\",\"gm_0\":\"\",\"ebitba_0\":\"\",\"cor_0\":\"\",\"gp_0\":\"\",\"rd_0\":\"\",\"sm_0\":\"\",\"ga_0\":\"\",\"oe_0\":\"\",\"toe_0\":\"\",\"ebitbam_0\":\"\",\"oien_0\":\"\",\"it_0\":\"\",\"nl_0\":\"\",\"cash_0\":\"\",\"tca_0\":\"\",\"tcl_0\":\"\",\"cae_0\":\"\",\"rc_0\":\"\",\"sti_0\":\"\",\"invtry_0\":\"\",\"ar_0\":\"\",\"pe_0\":\"\",\"oca_0\":\"\",\"ppe_0\":\"\",\"ada_0\":\"\",\"intg_0\":\"\",\"onca_0\":\"\",\"totass_0\":\"\",\"std_0\":\"\",\"ap_0\":\"\",\"dr_0\":\"\",\"al_0\":\"\",\"ocl_0\":\"\",\"ltd_0\":\"\",\"oncl_0\":\"\",\"totlia_0\":\"\",\"cs_0\":\"\",\"re_0\":\"\",\"toteq_0\":\"\",\"tle_0\":\"\",\"fet_0\":\"\",\"ltv_0\":\"\",\"cac_0\":\"\",\"ltvac_0\":\"\",\"year_1\":\"2015\",\"qtr_1\":\"Q1\",\"rev_1\":\"\",\"gm_1\":\"\",\"ebitba_1\":\"\",\"cor_1\":\"\",\"gp_1\":\"\",\"rd_1\":\"\",\"sm_1\":\"\",\"ga_1\":\"\",\"oe_1\":\"\",\"toe_1\":\"\",\"ebitbam_1\":\"\",\"oien_1\":\"\",\"it_1\":\"\",\"nl_1\":\"\",\"cash_1\":\"\",\"tca_1\":\"\",\"tcl_1\":\"\",\"cae_1\":\"\",\"rc_1\":\"\",\"sti_1\":\"\",\"invtry_1\":\"\",\"ar_1\":\"\",\"pe_1\":\"\",\"oca_1\":\"\",\"ppe_1\":\"\",\"ada_1\":\"\",\"intg_1\":\"\",\"onca_1\":\"\",\"totass_1\":\"\",\"std_1\":\"\",\"ap_1\":\"\",\"dr_1\":\"\",\"al_1\":\"\",\"ocl_1\":\"\",\"ltd_1\":\"\",\"oncl_1\":\"\",\"totlia_1\":\"\",\"cs_1\":\"\",\"re_1\":\"\",\"toteq_1\":\"\",\"tle_1\":\"\",\"fet_1\":\"\",\"ltv_1\":\"\",\"cac_1\":\"\",\"ltvac_1\":\"\",\"year_2\":\"2015\",\"qtr_2\":\"Q1\",\"rev_2\":\"\",\"gm_2\":\"\",\"ebitba_2\":\"\",\"cor_2\":\"\",\"gp_2\":\"\",\"rd_2\":\"\",\"sm_2\":\"\",\"ga_2\":\"\",\"oe_2\":\"\",\"toe_2\":\"\",\"ebitbam_2\":\"\",\"oien_2\":\"\",\"it_2\":\"\",\"nl_2\":\"\",\"cash_2\":\"\",\"tca_2\":\"\",\"tcl_2\":\"\",\"cae_2\":\"\",\"rc_2\":\"\",\"sti_2\":\"\",\"invtry_2\":\"\",\"ar_2\":\"\",\"pe_2\":\"\",\"oca_2\":\"\",\"ppe_2\":\"\",\"ada_2\":\"\",\"intg_2\":\"\",\"onca_2\":\"\",\"totass_2\":\"\",\"std_2\":\"\",\"ap_2\":\"\",\"dr_2\":\"\",\"al_2\":\"\",\"ocl_2\":\"\",\"ltd_2\":\"\",\"oncl_2\":\"\",\"totlia_2\":\"\",\"cs_2\":\"\",\"re_2\":\"\",\"toteq_2\":\"\",\"tle_2\":\"\",\"fet_2\":\"\",\"ltv_2\":\"\",\"cac_2\":\"\",\"ltvac_2\":\"\",\"year_3\":\"2015\",\"qtr_3\":\"Q1\",\"rev_3\":\"\",\"gm_3\":\"\",\"ebitba_3\":\"\",\"cor_3\":\"\",\"gp_3\":\"\",\"rd_3\":\"\",\"sm_3\":\"\",\"ga_3\":\"\",\"oe_3\":\"\",\"toe_3\":\"\",\"ebitbam_3\":\"\",\"oien_3\":\"\",\"it_3\":\"\",\"nl_3\":\"\",\"cash_3\":\"\",\"tca_3\":\"\",\"tcl_3\":\"\",\"cae_3\":\"\",\"rc_3\":\"\",\"sti_3\":\"\",\"invtry_3\":\"\",\"ar_3\":\"\",\"pe_3\":\"\",\"oca_3\":\"\",\"ppe_3\":\"\",\"ada_3\":\"\",\"intg_3\":\"\",\"onca_3\":\"\",\"totass_3\":\"\",\"std_3\":\"\",\"ap_3\":\"\",\"dr_3\":\"\",\"al_3\":\"\",\"ocl_3\":\"\",\"ltd_3\":\"\",\"oncl_3\":\"\",\"totlia_3\":\"\",\"cs_3\":\"\",\"re_3\":\"\",\"toteq_3\":\"\",\"tle_3\":\"\",\"fet_3\":\"\",\"ltv_3\":\"\",\"cac_3\":\"\",\"ltvac_3\":\"\",\"year_4\":\"2015\",\"qtr_4\":\"Q1\",\"rev_4\":\"\",\"gm_4\":\"\",\"ebitba_4\":\"\",\"cor_4\":\"\",\"gp_4\":\"\",\"rd_4\":\"\",\"sm_4\":\"\",\"ga_4\":\"\",\"oe_4\":\"\",\"toe_4\":\"\",\"ebitbam_4\":\"\",\"oien_4\":\"\",\"it_4\":\"\",\"nl_4\":\"\",\"cash_4\":\"\",\"tca_4\":\"\",\"tcl_4\":\"\",\"cae_4\":\"\",\"rc_4\":\"\",\"sti_4\":\"\",\"invtry_4\":\"\",\"ar_4\":\"\",\"pe_4\":\"\",\"oca_4\":\"\",\"ppe_4\":\"\",\"ada_4\":\"\",\"intg_4\":\"\",\"onca_4\":\"\",\"totass_4\":\"\",\"std_4\":\"\",\"ap_4\":\"\",\"dr_4\":\"\",\"al_4\":\"\",\"ocl_4\":\"\",\"ltd_4\":\"\",\"oncl_4\":\"\",\"totlia_4\":\"\",\"cs_4\":\"\",\"re_4\":\"\",\"toteq_4\":\"\",\"tle_4\":\"\",\"fet_4\":\"\",\"ltv_4\":\"\",\"cac_4\":\"\",\"ltvac_4\":\"\",\"year_5\":\"2015\",\"qtr_5\":\"Q1\",\"rev_5\":\"\",\"gm_5\":\"\",\"ebitba_5\":\"\",\"cor_5\":\"\",\"gp_5\":\"\",\"rd_5\":\"\",\"sm_5\":\"\",\"ga_5\":\"\",\"oe_5\":\"\",\"toe_5\":\"\",\"ebitbam_5\":\"\",\"oien_5\":\"\",\"it_5\":\"\",\"nl_5\":\"\",\"cash_5\":\"\",\"tca_5\":\"\",\"tcl_5\":\"\",\"cae_5\":\"\",\"rc_5\":\"\",\"sti_5\":\"\",\"invtry_5\":\"\",\"ar_5\":\"\",\"pe_5\":\"\",\"oca_5\":\"\",\"ppe_5\":\"\",\"ada_5\":\"\",\"intg_5\":\"\",\"onca_5\":\"\",\"totass_5\":\"\",\"std_5\":\"\",\"ap_5\":\"\",\"dr_5\":\"\",\"al_5\":\"\",\"ocl_5\":\"\",\"ltd_5\":\"\",\"oncl_5\":\"\",\"totlia_5\":\"\",\"cs_5\":\"\",\"re_5\":\"\",\"toteq_5\":\"\",\"tle_5\":\"\",\"fet_5\":\"\",\"ltv_5\":\"\",\"cac_5\":\"\",\"ltvac_5\":\"\",\"year_6\":\"2015\",\"qtr_6\":\"Q1\",\"rev_6\":\"\",\"gm_6\":\"\",\"ebitba_6\":\"\",\"cor_6\":\"\",\"gp_6\":\"\",\"rd_6\":\"\",\"sm_6\":\"\",\"ga_6\":\"\",\"oe_6\":\"\",\"toe_6\":\"\",\"ebitbam_6\":\"\",\"oien_6\":\"\",\"it_6\":\"\",\"nl_6\":\"\",\"cash_6\":\"\",\"tca_6\":\"\",\"tcl_6\":\"\",\"cae_6\":\"\",\"rc_6\":\"\",\"sti_6\":\"\",\"invtry_6\":\"\",\"ar_6\":\"\",\"pe_6\":\"\",\"oca_6\":\"\",\"ppe_6\":\"\",\"ada_6\":\"\",\"intg_6\":\"\",\"onca_6\":\"\",\"totass_6\":\"\",\"std_6\":\"\",\"ap_6\":\"\",\"dr_6\":\"\",\"al_6\":\"\",\"ocl_6\":\"\",\"ltd_6\":\"\",\"oncl_6\":\"\",\"totlia_6\":\"\",\"cs_6\":\"\",\"re_6\":\"\",\"toteq_6\":\"\",\"tle_6\":\"\",\"fet_6\":\"\",\"ltv_6\":\"\",\"cac_6\":\"\",\"ltvac_6\":\"\",\"year_7\":\"2015\",\"qtr_7\":\"Q1\",\"rev_7\":\"\",\"gm_7\":\"\",\"ebitba_7\":\"\",\"cor_7\":\"\",\"gp_7\":\"\",\"rd_7\":\"\",\"sm_7\":\"\",\"ga_7\":\"\",\"oe_7\":\"\",\"toe_7\":\"\",\"ebitbam_7\":\"\",\"oien_7\":\"\",\"it_7\":\"\",\"nl_7\":\"\",\"cash_7\":\"\",\"tca_7\":\"\",\"tcl_7\":\"\",\"cae_7\":\"\",\"rc_7\":\"\",\"sti_7\":\"\",\"invtry_7\":\"\",\"ar_7\":\"\",\"pe_7\":\"\",\"oca_7\":\"\",\"ppe_7\":\"\",\"ada_7\":\"\",\"intg_7\":\"\",\"onca_7\":\"\",\"totass_7\":\"\",\"std_7\":\"\",\"ap_7\":\"\",\"dr_7\":\"\",\"al_7\":\"\",\"ocl_7\":\"\",\"ltd_7\":\"\",\"oncl_7\":\"\",\"totlia_7\":\"\",\"cs_7\":\"\",\"re_7\":\"\",\"toteq_7\":\"\",\"tle_7\":\"\",\"fet_7\":\"\",\"ltv_7\":\"\",\"cac_7\":\"\",\"ltvac_7\":\"\"}";
         String privateproCmp="{\"tabtype\":\"Projection\",\"currency\":\"Currency\",\"denomination\":\"Denomination\",\"proyear_0\":\"2015\",\"proqtr_0\":\"Q1\",\"prorev_0\":\"\",\"progm_0\":\"\",\"proebitba_0\":\"\",\"procor_0\":\"\",\"progp_0\":\"\",\"prord_0\":\"\",\"prosm_0\":\"\",\"proga_0\":\"\",\"prooe_0\":\"\",\"protoe_0\":\"\",\"proebitbam_0\":\"\",\"prooien_0\":\"\",\"proit_0\":\"\",\"pronl_0\":\"\",\"procash_0\":\"\",\"protca_0\":\"\",\"protcl_0\":\"\",\"procae_0\":\"\",\"prorc_0\":\"\",\"prosti_0\":\"\",\"proinvtry_0\":\"\",\"proar_0\":\"\",\"prope_0\":\"\",\"prooca_0\":\"\",\"proppe_0\":\"\",\"proada_0\":\"\",\"prointg_0\":\"\",\"proonca_0\":\"\",\"prototass_0\":\"\",\"prostd_0\":\"\",\"proap_0\":\"\",\"prodr_0\":\"\",\"proal_0\":\"\",\"proocl_0\":\"\",\"proltd_0\":\"\",\"prooncl_0\":\"\",\"prototlia_0\":\"\",\"procs_0\":\"\",\"prore_0\":\"\",\"prototeq_0\":\"\",\"protle_0\":\"\",\"profet_0\":\"\",\"proltv_0\":\"\",\"procac_0\":\"\",\"proltvac_0\":\"\",\"proyear_1\":\"2015\",\"proqtr_1\":\"Q1\",\"prorev_1\":\"\",\"progm_1\":\"\",\"proebitba_1\":\"\",\"procor_1\":\"\",\"progp_1\":\"\",\"prord_1\":\"\",\"prosm_1\":\"\",\"proga_1\":\"\",\"prooe_1\":\"\",\"protoe_1\":\"\",\"proebitbam_1\":\"\",\"prooien_1\":\"\",\"proit_1\":\"\",\"pronl_1\":\"\",\"procash_1\":\"\",\"protca_1\":\"\",\"protcl_1\":\"\",\"procae_1\":\"\",\"prorc_1\":\"\",\"prosti_1\":\"\",\"proinvtry_1\":\"\",\"proar_1\":\"\",\"prope_1\":\"\",\"prooca_1\":\"\",\"proppe_1\":\"\",\"proada_1\":\"\",\"prointg_1\":\"\",\"proonca_1\":\"\",\"prototass_1\":\"\",\"prostd_1\":\"\",\"proap_1\":\"\",\"prodr_1\":\"\",\"proal_1\":\"\",\"proocl_1\":\"\",\"proltd_1\":\"\",\"prooncl_1\":\"\",\"prototlia_1\":\"\",\"procs_1\":\"\",\"prore_1\":\"\",\"prototeq_1\":\"\",\"protle_1\":\"\",\"profet_1\":\"\",\"proltv_1\":\"\",\"procac_1\":\"\",\"proltvac_1\":\"\",\"proyear_2\":\"2015\",\"proqtr_2\":\"Q1\",\"prorev_2\":\"\",\"progm_2\":\"\",\"proebitba_2\":\"\",\"procor_2\":\"\",\"progp_2\":\"\",\"prord_2\":\"\",\"prosm_2\":\"\",\"proga_2\":\"\",\"prooe_2\":\"\",\"protoe_2\":\"\",\"proebitbam_2\":\"\",\"prooien_2\":\"\",\"proit_2\":\"\",\"pronl_2\":\"\",\"procash_2\":\"\",\"protca_2\":\"\",\"protcl_2\":\"\",\"procae_2\":\"\",\"prorc_2\":\"\",\"prosti_2\":\"\",\"proinvtry_2\":\"\",\"proar_2\":\"\",\"prope_2\":\"\",\"prooca_2\":\"\",\"proppe_2\":\"\",\"proada_2\":\"\",\"prointg_2\":\"\",\"proonca_2\":\"\",\"prototass_2\":\"\",\"prostd_2\":\"\",\"proap_2\":\"\",\"prodr_2\":\"\",\"proal_2\":\"\",\"proocl_2\":\"\",\"proltd_2\":\"\",\"prooncl_2\":\"\",\"prototlia_2\":\"\",\"procs_2\":\"\",\"prore_2\":\"\",\"prototeq_2\":\"\",\"protle_2\":\"\",\"profet_2\":\"\",\"proltv_2\":\"\",\"procac_2\":\"\",\"proltvac_2\":\"\",\"proyear_3\":\"2015\",\"proqtr_3\":\"Q1\",\"prorev_3\":\"\",\"progm_3\":\"\",\"proebitba_3\":\"\",\"procor_3\":\"\",\"progp_3\":\"\",\"prord_3\":\"\",\"prosm_3\":\"\",\"proga_3\":\"\",\"prooe_3\":\"\",\"protoe_3\":\"\",\"proebitbam_3\":\"\",\"prooien_3\":\"\",\"proit_3\":\"\",\"pronl_3\":\"\",\"procash_3\":\"\",\"protca_3\":\"\",\"protcl_3\":\"\",\"procae_3\":\"\",\"prorc_3\":\"\",\"prosti_3\":\"\",\"proinvtry_3\":\"\",\"proar_3\":\"\",\"prope_3\":\"\",\"prooca_3\":\"\",\"proppe_3\":\"\",\"proada_3\":\"\",\"prointg_3\":\"\",\"proonca_3\":\"\",\"prototass_3\":\"\",\"prostd_3\":\"\",\"proap_3\":\"\",\"prodr_3\":\"\",\"proal_3\":\"\",\"proocl_3\":\"\",\"proltd_3\":\"\",\"prooncl_3\":\"\",\"prototlia_3\":\"\",\"procs_3\":\"\",\"prore_3\":\"\",\"prototeq_3\":\"\",\"protle_3\":\"\",\"profet_3\":\"\",\"proltv_3\":\"\",\"procac_3\":\"\",\"proltvac_3\":\"\",\"proyear_4\":\"2015\",\"proqtr_4\":\"Q1\",\"prorev_4\":\"\",\"progm_4\":\"\",\"proebitba_4\":\"\",\"procor_4\":\"\",\"progp_4\":\"\",\"prord_4\":\"\",\"prosm_4\":\"\",\"proga_4\":\"\",\"prooe_4\":\"\",\"protoe_4\":\"\",\"proebitbam_4\":\"\",\"prooien_4\":\"\",\"proit_4\":\"\",\"pronl_4\":\"\",\"procash_4\":\"\",\"protca_4\":\"\",\"protcl_4\":\"\",\"procae_4\":\"\",\"prorc_4\":\"\",\"prosti_4\":\"\",\"proinvtry_4\":\"\",\"proar_4\":\"\",\"prope_4\":\"\",\"prooca_4\":\"\",\"proppe_4\":\"\",\"proada_4\":\"\",\"prointg_4\":\"\",\"proonca_4\":\"\",\"prototass_4\":\"\",\"prostd_4\":\"\",\"proap_4\":\"\",\"prodr_4\":\"\",\"proal_4\":\"\",\"proocl_4\":\"\",\"proltd_4\":\"\",\"prooncl_4\":\"\",\"prototlia_4\":\"\",\"procs_4\":\"\",\"prore_4\":\"\",\"prototeq_4\":\"\",\"protle_4\":\"\",\"profet_4\":\"\",\"proltv_4\":\"\",\"procac_4\":\"\",\"proltvac_4\":\"\",\"proyear_5\":\"2015\",\"proqtr_5\":\"Q1\",\"prorev_5\":\"\",\"progm_5\":\"\",\"proebitba_5\":\"\",\"procor_5\":\"\",\"progp_5\":\"\",\"prord_5\":\"\",\"prosm_5\":\"\",\"proga_5\":\"\",\"prooe_5\":\"\",\"protoe_5\":\"\",\"proebitbam_5\":\"\",\"prooien_5\":\"\",\"proit_5\":\"\",\"pronl_5\":\"\",\"procash_5\":\"\",\"protca_5\":\"\",\"protcl_5\":\"\",\"procae_5\":\"\",\"prorc_5\":\"\",\"prosti_5\":\"\",\"proinvtry_5\":\"\",\"proar_5\":\"\",\"prope_5\":\"\",\"prooca_5\":\"\",\"proppe_5\":\"\",\"proada_5\":\"\",\"prointg_5\":\"\",\"proonca_5\":\"\",\"prototass_5\":\"\",\"prostd_5\":\"\",\"proap_5\":\"\",\"prodr_5\":\"\",\"proal_5\":\"\",\"proocl_5\":\"\",\"proltd_5\":\"\",\"prooncl_5\":\"\",\"prototlia_5\":\"\",\"procs_5\":\"\",\"prore_5\":\"\",\"prototeq_5\":\"\",\"protle_5\":\"\",\"profet_5\":\"\",\"proltv_5\":\"\",\"procac_5\":\"\",\"proltvac_5\":\"\",\"proyear_6\":\"2015\",\"proqtr_6\":\"Q1\",\"prorev_6\":\"\",\"progm_6\":\"\",\"proebitba_6\":\"\",\"procor_6\":\"\",\"progp_6\":\"\",\"prord_6\":\"\",\"prosm_6\":\"\",\"proga_6\":\"\",\"prooe_6\":\"\",\"protoe_6\":\"\",\"proebitbam_6\":\"\",\"prooien_6\":\"\",\"proit_6\":\"\",\"pronl_6\":\"\",\"procash_6\":\"\",\"protca_6\":\"\",\"protcl_6\":\"\",\"procae_6\":\"\",\"prorc_6\":\"\",\"prosti_6\":\"\",\"proinvtry_6\":\"\",\"proar_6\":\"\",\"prope_6\":\"\",\"prooca_6\":\"\",\"proppe_6\":\"\",\"proada_6\":\"\",\"prointg_6\":\"\",\"proonca_6\":\"\",\"prototass_6\":\"\",\"prostd_6\":\"\",\"proap_6\":\"\",\"prodr_6\":\"\",\"proal_6\":\"\",\"proocl_6\":\"\",\"proltd_6\":\"\",\"prooncl_6\":\"\",\"prototlia_6\":\"\",\"procs_6\":\"\",\"prore_6\":\"\",\"prototeq_6\":\"\",\"protle_6\":\"\",\"profet_6\":\"\",\"proltv_6\":\"\",\"procac_6\":\"\",\"proltvac_6\":\"\",\"proyear_7\":\"2015\",\"proqtr_7\":\"Q1\",\"prorev_7\":\"\",\"progm_7\":\"\",\"proebitba_7\":\"\",\"procor_7\":\"\",\"progp_7\":\"\",\"prord_7\":\"\",\"prosm_7\":\"\",\"proga_7\":\"\",\"prooe_7\":\"\",\"protoe_7\":\"\",\"proebitbam_7\":\"\",\"prooien_7\":\"\",\"proit_7\":\"\",\"pronl_7\":\"\",\"procash_7\":\"\",\"protca_7\":\"\",\"protcl_7\":\"\",\"procae_7\":\"\",\"prorc_7\":\"\",\"prosti_7\":\"\",\"proinvtry_7\":\"\",\"proar_7\":\"\",\"prope_7\":\"\",\"prooca_7\":\"\",\"proppe_7\":\"\",\"proada_7\":\"\",\"prointg_7\":\"\",\"proonca_7\":\"\",\"prototass_7\":\"\",\"prostd_7\":\"\",\"proap_7\":\"\",\"prodr_7\":\"\",\"proal_7\":\"\",\"proocl_7\":\"\",\"proltd_7\":\"\",\"prooncl_7\":\"\",\"prototlia_7\":\"\",\"procs_7\":\"\",\"prore_7\":\"\",\"prototeq_7\":\"\",\"protle_7\":\"\",\"profet_7\":\"\",\"proltv_7\":\"\",\"procac_7\":\"\",\"proltvac_7\":\"\"}";
        //String publicCmp="{\"currency\":\"Currency\",\"denomination\":\"Denomination\",\"puyear_0\":\"2015\",\"puqtr_0\":\"Q1\",\"purev_0\":\"\",\"pugm_0\":\"\",\"puebitba_0\":\"\",\"pucor_0\":\"\",\"pugp_0\":\"\",\"purd_0\":\"\",\"pusga_0\":\"\",\"punr_0\":\"\",\"pungw_0\":\"\",\"putotlia_0\":\"\",\"pumsow_0\":\"\",\"purps_0\":\"\",\"pups_0\":\"\",\"pucs_0\":\"\",\"puts_0\":\"\",\"pucas_0\":\"\",\"puose_0\":\"\",\"putote_0\":\"\",\"putle_0\":\"\",\"puoe_0\":\"\",\"putoe_0\":\"\",\"putoien_0\":\"\",\"puebit_0\":\"\",\"puit_0\":\"\",\"puibt_0\":\"\",\"puite_0\":\"\",\"pumi_0\":\"\",\"pudo_0\":\"\",\"puei_0\":\"\",\"pueoac_0\":\"\",\"puoi_0\":\"\",\"punil_0\":\"\",\"pucash_0\":\"\",\"putca_0\":\"\",\"putcl_0\":\"\",\"pucae_0\":\"\",\"pusti_0\":\"\",\"punre_0\":\"\",\"puinvtry_0\":\"\",\"puoca_0\":\"\",\"putcass_0\":\"\",\"pulti_0\":\"\",\"puppe_0\":\"\",\"pugw_0\":\"\",\"puia_0\":\"\",\"puaa_0\":\"\",\"puoa_0\":\"\",\"pudltac_0\":\"\",\"puta_0\":\"\",\"puscltd_0\":\"\",\"puap_0\":\"\",\"puocl_0\":\"\",\"pultd_0\":\"\",\"puolia_0\":\"\",\"pudltlc_0\":\"\",\"pumino_0\":\"\",\"pufet_0\":\"\",\"pultv_0\":\"\",\"pucac_0\":\"\",\"pultvac_0\":\"\",\"puyear_1\":\"2015\",\"puqtr_1\":\"Q1\",\"purev_1\":\"\",\"pugm_1\":\"\",\"puebitba_1\":\"\",\"pucor_1\":\"\",\"pugp_1\":\"\",\"purd_1\":\"\",\"pusga_1\":\"\",\"punr_1\":\"\",\"pungw_1\":\"\",\"putotlia_1\":\"\",\"pumsow_1\":\"\",\"purps_1\":\"\",\"pups_1\":\"\",\"pucs_1\":\"\",\"puts_1\":\"\",\"pucas_1\":\"\",\"puose_1\":\"\",\"putote_1\":\"\",\"putle_1\":\"\",\"puoe_1\":\"\",\"putoe_1\":\"\",\"putoien_1\":\"\",\"puebit_1\":\"\",\"puit_1\":\"\",\"puibt_1\":\"\",\"puite_1\":\"\",\"pumi_1\":\"\",\"pudo_1\":\"\",\"puei_1\":\"\",\"pueoac_1\":\"\",\"puoi_1\":\"\",\"punil_1\":\"\",\"pucash_1\":\"\",\"putca_1\":\"\",\"putcl_1\":\"\",\"pucae_1\":\"\",\"pusti_1\":\"\",\"punre_1\":\"\",\"puinvtry_1\":\"\",\"puoca_1\":\"\",\"putcass_1\":\"\",\"pulti_1\":\"\",\"puppe_1\":\"\",\"pugw_1\":\"\",\"puia_1\":\"\",\"puaa_1\":\"\",\"puoa_1\":\"\",\"pudltac_1\":\"\",\"puta_1\":\"\",\"puscltd_1\":\"\",\"puap_1\":\"\",\"puocl_1\":\"\",\"pultd_1\":\"\",\"puolia_1\":\"\",\"pudltlc_1\":\"\",\"pumino_1\":\"\",\"pufet_1\":\"\",\"pultv_1\":\"\",\"pucac_1\":\"\",\"pultvac_1\":\"\",\"puyear_2\":\"2015\",\"puqtr_2\":\"Q1\",\"purev_2\":\"\",\"pugm_2\":\"\",\"puebitba_2\":\"\",\"pucor_2\":\"\",\"pugp_2\":\"\",\"purd_2\":\"\",\"pusga_2\":\"\",\"punr_2\":\"\",\"pungw_2\":\"\",\"putotlia_2\":\"\",\"pumsow_2\":\"\",\"purps_2\":\"\",\"pups_2\":\"\",\"pucs_2\":\"\",\"puts_2\":\"\",\"pucas_2\":\"\",\"puose_2\":\"\",\"putote_2\":\"\",\"putle_2\":\"\",\"puoe_2\":\"\",\"putoe_2\":\"\",\"putoien_2\":\"\",\"puebit_2\":\"\",\"puit_2\":\"\",\"puibt_2\":\"\",\"puite_2\":\"\",\"pumi_2\":\"\",\"pudo_2\":\"\",\"puei_2\":\"\",\"pueoac_2\":\"\",\"puoi_2\":\"\",\"punil_2\":\"\",\"pucash_2\":\"\",\"putca_2\":\"\",\"putcl_2\":\"\",\"pucae_2\":\"\",\"pusti_2\":\"\",\"punre_2\":\"\",\"puinvtry_2\":\"\",\"puoca_2\":\"\",\"putcass_2\":\"\",\"pulti_2\":\"\",\"puppe_2\":\"\",\"pugw_2\":\"\",\"puia_2\":\"\",\"puaa_2\":\"\",\"puoa_2\":\"\",\"pudltac_2\":\"\",\"puta_2\":\"\",\"puscltd_2\":\"\",\"puap_2\":\"\",\"puocl_2\":\"\",\"pultd_2\":\"\",\"puolia_2\":\"\",\"pudltlc_2\":\"\",\"pumino_2\":\"\",\"pufet_2\":\"\",\"pultv_2\":\"\",\"pucac_2\":\"\",\"pultvac_2\":\"\",\"puyear_3\":\"2015\",\"puqtr_3\":\"Q1\",\"purev_3\":\"\",\"pugm_3\":\"\",\"puebitba_3\":\"\",\"pucor_3\":\"\",\"pugp_3\":\"\",\"purd_3\":\"\",\"pusga_3\":\"\",\"punr_3\":\"\",\"pungw_3\":\"\",\"putotlia_3\":\"\",\"pumsow_3\":\"\",\"purps_3\":\"\",\"pups_3\":\"\",\"pucs_3\":\"\",\"puts_3\":\"\",\"pucas_3\":\"\",\"puose_3\":\"\",\"putote_3\":\"\",\"putle_3\":\"\",\"puoe_3\":\"\",\"putoe_3\":\"\",\"putoien_3\":\"\",\"puebit_3\":\"\",\"puit_3\":\"\",\"puibt_3\":\"\",\"puite_3\":\"\",\"pumi_3\":\"\",\"pudo_3\":\"\",\"puei_3\":\"\",\"pueoac_3\":\"\",\"puoi_3\":\"\",\"punil_3\":\"\",\"pucash_3\":\"\",\"putca_3\":\"\",\"putcl_3\":\"\",\"pucae_3\":\"\",\"pusti_3\":\"\",\"punre_3\":\"\",\"puinvtry_3\":\"\",\"puoca_3\":\"\",\"putcass_3\":\"\",\"pulti_3\":\"\",\"puppe_3\":\"\",\"pugw_3\":\"\",\"puia_3\":\"\",\"puaa_3\":\"\",\"puoa_3\":\"\",\"pudltac_3\":\"\",\"puta_3\":\"\",\"puscltd_3\":\"\",\"puap_3\":\"\",\"puocl_3\":\"\",\"pultd_3\":\"\",\"puolia_3\":\"\",\"pudltlc_3\":\"\",\"pumino_3\":\"\",\"pufet_3\":\"\",\"pultv_3\":\"\",\"pucac_3\":\"\",\"pultvac_3\":\"\",\"puyear_4\":\"2015\",\"puqtr_4\":\"Q1\",\"purev_4\":\"\",\"pugm_4\":\"\",\"puebitba_4\":\"\",\"pucor_4\":\"\",\"pugp_4\":\"\",\"purd_4\":\"\",\"pusga_4\":\"\",\"punr_4\":\"\",\"pungw_4\":\"\",\"putotlia_4\":\"\",\"pumsow_4\":\"\",\"purps_4\":\"\",\"pups_4\":\"\",\"pucs_4\":\"\",\"puts_4\":\"\",\"pucas_4\":\"\",\"puose_4\":\"\",\"putote_4\":\"\",\"putle_4\":\"\",\"puoe_4\":\"\",\"putoe_4\":\"\",\"putoien_4\":\"\",\"puebit_4\":\"\",\"puit_4\":\"\",\"puibt_4\":\"\",\"puite_4\":\"\",\"pumi_4\":\"\",\"pudo_4\":\"\",\"puei_4\":\"\",\"pueoac_4\":\"\",\"puoi_4\":\"\",\"punil_4\":\"\",\"pucash_4\":\"\",\"putca_4\":\"\",\"putcl_4\":\"\",\"pucae_4\":\"\",\"pusti_4\":\"\",\"punre_4\":\"\",\"puinvtry_4\":\"\",\"puoca_4\":\"\",\"putcass_4\":\"\",\"pulti_4\":\"\",\"puppe_4\":\"\",\"pugw_4\":\"\",\"puia_4\":\"\",\"puaa_4\":\"\",\"puoa_4\":\"\",\"pudltac_4\":\"\",\"puta_4\":\"\",\"puscltd_4\":\"\",\"puap_4\":\"\",\"puocl_4\":\"\",\"pultd_4\":\"\",\"puolia_4\":\"\",\"pudltlc_4\":\"\",\"pumino_4\":\"\",\"pufet_4\":\"\",\"pultv_4\":\"\",\"pucac_4\":\"\",\"pultvac_4\":\"\",\"puyear_5\":\"2015\",\"puqtr_5\":\"Q1\",\"purev_5\":\"\",\"pugm_5\":\"\",\"puebitba_5\":\"\",\"pucor_5\":\"\",\"pugp_5\":\"\",\"purd_5\":\"\",\"pusga_5\":\"\",\"punr_5\":\"\",\"pungw_5\":\"\",\"putotlia_5\":\"\",\"pumsow_5\":\"\",\"purps_5\":\"\",\"pups_5\":\"\",\"pucs_5\":\"\",\"puts_5\":\"\",\"pucas_5\":\"\",\"puose_5\":\"\",\"putote_5\":\"\",\"putle_5\":\"\",\"puoe_5\":\"\",\"putoe_5\":\"\",\"putoien_5\":\"\",\"puebit_5\":\"\",\"puit_5\":\"\",\"puibt_5\":\"\",\"puite_5\":\"\",\"pumi_5\":\"\",\"pudo_5\":\"\",\"puei_5\":\"\",\"pueoac_5\":\"\",\"puoi_5\":\"\",\"punil_5\":\"\",\"pucash_5\":\"\",\"putca_5\":\"\",\"putcl_5\":\"\",\"pucae_5\":\"\",\"pusti_5\":\"\",\"punre_5\":\"\",\"puinvtry_5\":\"\",\"puoca_5\":\"\",\"putcass_5\":\"\",\"pulti_5\":\"\",\"puppe_5\":\"\",\"pugw_5\":\"\",\"puia_5\":\"\",\"puaa_5\":\"\",\"puoa_5\":\"\",\"pudltac_5\":\"\",\"puta_5\":\"\",\"puscltd_5\":\"\",\"puap_5\":\"\",\"puocl_5\":\"\",\"pultd_5\":\"\",\"puolia_5\":\"\",\"pudltlc_5\":\"\",\"pumino_5\":\"\",\"pufet_5\":\"\",\"pultv_5\":\"\",\"pucac_5\":\"\",\"pultvac_5\":\"\",\"puyear_6\":\"2015\",\"puqtr_6\":\"Q1\",\"purev_6\":\"\",\"pugm_6\":\"\",\"puebitba_6\":\"\",\"pucor_6\":\"\",\"pugp_6\":\"\",\"purd_6\":\"\",\"pusga_6\":\"\",\"punr_6\":\"\",\"pungw_6\":\"\",\"putotlia_6\":\"\",\"pumsow_6\":\"\",\"purps_6\":\"\",\"pups_6\":\"\",\"pucs_6\":\"\",\"puts_6\":\"\",\"pucas_6\":\"\",\"puose_6\":\"\",\"putote_6\":\"\",\"putle_6\":\"\",\"puoe_6\":\"\",\"putoe_6\":\"\",\"putoien_6\":\"\",\"puebit_6\":\"\",\"puit_6\":\"\",\"puibt_6\":\"\",\"puite_6\":\"\",\"pumi_6\":\"\",\"pudo_6\":\"\",\"puei_6\":\"\",\"pueoac_6\":\"\",\"puoi_6\":\"\",\"punil_6\":\"\",\"pucash_6\":\"\",\"putca_6\":\"\",\"putcl_6\":\"\",\"pucae_6\":\"\",\"pusti_6\":\"\",\"punre_6\":\"\",\"puinvtry_6\":\"\",\"puoca_6\":\"\",\"putcass_6\":\"\",\"pulti_6\":\"\",\"puppe_6\":\"\",\"pugw_6\":\"\",\"puia_6\":\"\",\"puaa_6\":\"\",\"puoa_6\":\"\",\"pudltac_6\":\"\",\"puta_6\":\"\",\"puscltd_6\":\"\",\"puap_6\":\"\",\"puocl_6\":\"\",\"pultd_6\":\"\",\"puolia_6\":\"\",\"pudltlc_6\":\"\",\"pumino_6\":\"\",\"pufet_6\":\"\",\"pultv_6\":\"\",\"pucac_6\":\"\",\"pultvac_6\":\"\",\"puyear_7\":\"2015\",\"puqtr_7\":\"Q1\",\"purev_7\":\"\",\"pugm_7\":\"\",\"puebitba_7\":\"\",\"pucor_7\":\"\",\"pugp_7\":\"\",\"purd_7\":\"\",\"pusga_7\":\"\",\"punr_7\":\"\",\"pungw_7\":\"\",\"putotlia_7\":\"\",\"pumsow_7\":\"\",\"purps_7\":\"\",\"pups_7\":\"\",\"pucs_7\":\"\",\"puts_7\":\"\",\"pucas_7\":\"\",\"puose_7\":\"\",\"putote_7\":\"\",\"putle_7\":\"\",\"puoe_7\":\"\",\"putoe_7\":\"\",\"putoien_7\":\"\",\"puebit_7\":\"\",\"puit_7\":\"\",\"puibt_7\":\"\",\"puite_7\":\"\",\"pumi_7\":\"\",\"pudo_7\":\"\",\"puei_7\":\"\",\"pueoac_7\":\"\",\"puoi_7\":\"\",\"punil_7\":\"\",\"pucash_7\":\"\",\"putca_7\":\"\",\"putcl_7\":\"\",\"pucae_7\":\"\",\"pusti_7\":\"\",\"punre_7\":\"\",\"puinvtry_7\":\"\",\"puoca_7\":\"\",\"putcass_7\":\"\",\"pulti_7\":\"\",\"puppe_7\":\"\",\"pugw_7\":\"\",\"puia_7\":\"\",\"puaa_7\":\"\",\"puoa_7\":\"\",\"pudltac_7\":\"\",\"puta_7\":\"\",\"puscltd_7\":\"\",\"puap_7\":\"\",\"puocl_7\":\"\",\"pultd_7\":\"\",\"puolia_7\":\"\",\"pudltlc_7\":\"\",\"pumino_7\":\"\",\"pufet_7\":\"\",\"pultv_7\":\"\",\"pucac_7\":\"\",\"pultvac_7\":\"\"}";
         String publicProCmp="{\"tabtype\":\"Projection\",\"currency\":\"Currency\",\"denomination\":\"Denomination\",\"propuyear_0\":\"2015\",\"propuqtr_0\":\"Q1\",\"propurev_0\":\"\",\"propugm_0\":\"\",\"propuebitba_0\":\"\",\"propucor_0\":\"\",\"propugp_0\":\"\",\"propurd_0\":\"\",\"propusga_0\":\"\",\"propunr_0\":\"\",\"propungw_0\":\"\",\"proputotlia_0\":\"\",\"propumsow_0\":\"\",\"propurps_0\":\"\",\"propups_0\":\"\",\"propucs_0\":\"\",\"proputs_0\":\"\",\"propucas_0\":\"\",\"propuose_0\":\"\",\"proputote_0\":\"\",\"proputle_0\":\"\",\"propuoe_0\":\"\",\"proputoe_0\":\"\",\"proputoien_0\":\"\",\"propuebit_0\":\"\",\"propuit_0\":\"\",\"propuibt_0\":\"undefined\",\"propuite_0\":\"\",\"propumi_0\":\"\",\"propudo_0\":\"\",\"propuei_0\":\"\",\"propueoac_0\":\"\",\"propuoi_0\":\"\",\"propunil_0\":\"\",\"propucash_0\":\"\",\"proputca_0\":\"\",\"proputcl_0\":\"\",\"propucae_0\":\"\",\"propusti_0\":\"\",\"propunre_0\":\"\",\"propuinvtry_0\":\"\",\"propuoca_0\":\"\",\"proputcass_0\":\"\",\"propulti_0\":\"\",\"propuppe_0\":\"\",\"propugw_0\":\"\",\"propuia_0\":\"\",\"propuaa_0\":\"\",\"propuoa_0\":\"\",\"propudltac_0\":\"\",\"proputa_0\":\"\",\"propuscltd_0\":\"\",\"propuap_0\":\"\",\"propuocl_0\":\"\",\"propultd_0\":\"\",\"propuolia_0\":\"\",\"propudltlc_0\":\"\",\"propumino_0\":\"\",\"propufet_0\":\"\",\"propultv_0\":\"\",\"propucac_0\":\"\",\"propultvac_0\":\"\",\"propuyear_1\":\"2015\",\"propuqtr_1\":\"Q1\",\"propurev_1\":\"\",\"propugm_1\":\"\",\"propuebitba_1\":\"\",\"propucor_1\":\"\",\"propugp_1\":\"\",\"propurd_1\":\"\",\"propusga_1\":\"\",\"propunr_1\":\"\",\"propungw_1\":\"\",\"proputotlia_1\":\"\",\"propumsow_1\":\"\",\"propurps_1\":\"\",\"propups_1\":\"\",\"propucs_1\":\"\",\"proputs_1\":\"\",\"propucas_1\":\"\",\"propuose_1\":\"\",\"proputote_1\":\"\",\"proputle_1\":\"\",\"propuoe_1\":\"\",\"proputoe_1\":\"\",\"proputoien_1\":\"\",\"propuebit_1\":\"\",\"propuit_1\":\"\",\"propuibt_1\":\"undefined\",\"propuite_1\":\"\",\"propumi_1\":\"\",\"propudo_1\":\"\",\"propuei_1\":\"\",\"propueoac_1\":\"\",\"propuoi_1\":\"\",\"propunil_1\":\"\",\"propucash_1\":\"\",\"proputca_1\":\"\",\"proputcl_1\":\"\",\"propucae_1\":\"\",\"propusti_1\":\"\",\"propunre_1\":\"\",\"propuinvtry_1\":\"\",\"propuoca_1\":\"\",\"proputcass_1\":\"\",\"propulti_1\":\"\",\"propuppe_1\":\"\",\"propugw_1\":\"\",\"propuia_1\":\"\",\"propuaa_1\":\"\",\"propuoa_1\":\"\",\"propudltac_1\":\"\",\"proputa_1\":\"\",\"propuscltd_1\":\"\",\"propuap_1\":\"\",\"propuocl_1\":\"\",\"propultd_1\":\"\",\"propuolia_1\":\"\",\"propudltlc_1\":\"\",\"propumino_1\":\"\",\"propufet_1\":\"\",\"propultv_1\":\"\",\"propucac_1\":\"\",\"propultvac_1\":\"\",\"propuyear_2\":\"2015\",\"propuqtr_2\":\"Q1\",\"propurev_2\":\"\",\"propugm_2\":\"\",\"propuebitba_2\":\"\",\"propucor_2\":\"\",\"propugp_2\":\"\",\"propurd_2\":\"\",\"propusga_2\":\"\",\"propunr_2\":\"\",\"propungw_2\":\"\",\"proputotlia_2\":\"\",\"propumsow_2\":\"\",\"propurps_2\":\"\",\"propups_2\":\"\",\"propucs_2\":\"\",\"proputs_2\":\"\",\"propucas_2\":\"\",\"propuose_2\":\"\",\"proputote_2\":\"\",\"proputle_2\":\"\",\"propuoe_2\":\"\",\"proputoe_2\":\"\",\"proputoien_2\":\"\",\"propuebit_2\":\"\",\"propuit_2\":\"\",\"propuibt_2\":\"undefined\",\"propuite_2\":\"\",\"propumi_2\":\"\",\"propudo_2\":\"\",\"propuei_2\":\"\",\"propueoac_2\":\"\",\"propuoi_2\":\"\",\"propunil_2\":\"\",\"propucash_2\":\"\",\"proputca_2\":\"\",\"proputcl_2\":\"\",\"propucae_2\":\"\",\"propusti_2\":\"\",\"propunre_2\":\"\",\"propuinvtry_2\":\"\",\"propuoca_2\":\"\",\"proputcass_2\":\"\",\"propulti_2\":\"\",\"propuppe_2\":\"\",\"propugw_2\":\"\",\"propuia_2\":\"\",\"propuaa_2\":\"\",\"propuoa_2\":\"\",\"propudltac_2\":\"\",\"proputa_2\":\"\",\"propuscltd_2\":\"\",\"propuap_2\":\"\",\"propuocl_2\":\"\",\"propultd_2\":\"\",\"propuolia_2\":\"\",\"propudltlc_2\":\"\",\"propumino_2\":\"\",\"propufet_2\":\"\",\"propultv_2\":\"\",\"propucac_2\":\"\",\"propultvac_2\":\"\",\"propuyear_3\":\"2015\",\"propuqtr_3\":\"Q1\",\"propurev_3\":\"\",\"propugm_3\":\"\",\"propuebitba_3\":\"\",\"propucor_3\":\"\",\"propugp_3\":\"\",\"propurd_3\":\"\",\"propusga_3\":\"\",\"propunr_3\":\"\",\"propungw_3\":\"\",\"proputotlia_3\":\"\",\"propumsow_3\":\"\",\"propurps_3\":\"\",\"propups_3\":\"\",\"propucs_3\":\"\",\"proputs_3\":\"\",\"propucas_3\":\"\",\"propuose_3\":\"\",\"proputote_3\":\"\",\"proputle_3\":\"\",\"propuoe_3\":\"\",\"proputoe_3\":\"\",\"proputoien_3\":\"\",\"propuebit_3\":\"\",\"propuit_3\":\"\",\"propuibt_3\":\"undefined\",\"propuite_3\":\"\",\"propumi_3\":\"\",\"propudo_3\":\"\",\"propuei_3\":\"\",\"propueoac_3\":\"\",\"propuoi_3\":\"\",\"propunil_3\":\"\",\"propucash_3\":\"\",\"proputca_3\":\"\",\"proputcl_3\":\"\",\"propucae_3\":\"\",\"propusti_3\":\"\",\"propunre_3\":\"\",\"propuinvtry_3\":\"\",\"propuoca_3\":\"\",\"proputcass_3\":\"\",\"propulti_3\":\"\",\"propuppe_3\":\"\",\"propugw_3\":\"\",\"propuia_3\":\"\",\"propuaa_3\":\"\",\"propuoa_3\":\"\",\"propudltac_3\":\"\",\"proputa_3\":\"\",\"propuscltd_3\":\"\",\"propuap_3\":\"\",\"propuocl_3\":\"\",\"propultd_3\":\"\",\"propuolia_3\":\"\",\"propudltlc_3\":\"\",\"propumino_3\":\"\",\"propufet_3\":\"\",\"propultv_3\":\"\",\"propucac_3\":\"\",\"propultvac_3\":\"\",\"propuyear_4\":\"2015\",\"propuqtr_4\":\"Q1\",\"propurev_4\":\"\",\"propugm_4\":\"\",\"propuebitba_4\":\"\",\"propucor_4\":\"\",\"propugp_4\":\"\",\"propurd_4\":\"\",\"propusga_4\":\"\",\"propunr_4\":\"\",\"propungw_4\":\"\",\"proputotlia_4\":\"\",\"propumsow_4\":\"\",\"propurps_4\":\"\",\"propups_4\":\"\",\"propucs_4\":\"\",\"proputs_4\":\"\",\"propucas_4\":\"\",\"propuose_4\":\"\",\"proputote_4\":\"\",\"proputle_4\":\"\",\"propuoe_4\":\"\",\"proputoe_4\":\"\",\"proputoien_4\":\"\",\"propuebit_4\":\"\",\"propuit_4\":\"\",\"propuibt_4\":\"undefined\",\"propuite_4\":\"\",\"propumi_4\":\"\",\"propudo_4\":\"\",\"propuei_4\":\"\",\"propueoac_4\":\"\",\"propuoi_4\":\"\",\"propunil_4\":\"\",\"propucash_4\":\"\",\"proputca_4\":\"\",\"proputcl_4\":\"\",\"propucae_4\":\"\",\"propusti_4\":\"\",\"propunre_4\":\"\",\"propuinvtry_4\":\"\",\"propuoca_4\":\"\",\"proputcass_4\":\"\",\"propulti_4\":\"\",\"propuppe_4\":\"\",\"propugw_4\":\"\",\"propuia_4\":\"\",\"propuaa_4\":\"\",\"propuoa_4\":\"\",\"propudltac_4\":\"\",\"proputa_4\":\"\",\"propuscltd_4\":\"\",\"propuap_4\":\"\",\"propuocl_4\":\"\",\"propultd_4\":\"\",\"propuolia_4\":\"\",\"propudltlc_4\":\"\",\"propumino_4\":\"\",\"propufet_4\":\"\",\"propultv_4\":\"\",\"propucac_4\":\"\",\"propultvac_4\":\"\",\"propuyear_5\":\"2015\",\"propuqtr_5\":\"Q1\",\"propurev_5\":\"\",\"propugm_5\":\"\",\"propuebitba_5\":\"\",\"propucor_5\":\"\",\"propugp_5\":\"\",\"propurd_5\":\"\",\"propusga_5\":\"\",\"propunr_5\":\"\",\"propungw_5\":\"\",\"proputotlia_5\":\"\",\"propumsow_5\":\"\",\"propurps_5\":\"\",\"propups_5\":\"\",\"propucs_5\":\"\",\"proputs_5\":\"\",\"propucas_5\":\"\",\"propuose_5\":\"\",\"proputote_5\":\"\",\"proputle_5\":\"\",\"propuoe_5\":\"\",\"proputoe_5\":\"\",\"proputoien_5\":\"\",\"propuebit_5\":\"\",\"propuit_5\":\"\",\"propuibt_5\":\"undefined\",\"propuite_5\":\"\",\"propumi_5\":\"\",\"propudo_5\":\"\",\"propuei_5\":\"\",\"propueoac_5\":\"\",\"propuoi_5\":\"\",\"propunil_5\":\"\",\"propucash_5\":\"\",\"proputca_5\":\"\",\"proputcl_5\":\"\",\"propucae_5\":\"\",\"propusti_5\":\"\",\"propunre_5\":\"\",\"propuinvtry_5\":\"\",\"propuoca_5\":\"\",\"proputcass_5\":\"\",\"propulti_5\":\"\",\"propuppe_5\":\"\",\"propugw_5\":\"\",\"propuia_5\":\"\",\"propuaa_5\":\"\",\"propuoa_5\":\"\",\"propudltac_5\":\"\",\"proputa_5\":\"\",\"propuscltd_5\":\"\",\"propuap_5\":\"\",\"propuocl_5\":\"\",\"propultd_5\":\"\",\"propuolia_5\":\"\",\"propudltlc_5\":\"\",\"propumino_5\":\"\",\"propufet_5\":\"\",\"propultv_5\":\"\",\"propucac_5\":\"\",\"propultvac_5\":\"\",\"propuyear_6\":\"2015\",\"propuqtr_6\":\"Q1\",\"propurev_6\":\"\",\"propugm_6\":\"\",\"propuebitba_6\":\"\",\"propucor_6\":\"\",\"propugp_6\":\"\",\"propurd_6\":\"\",\"propusga_6\":\"\",\"propunr_6\":\"\",\"propungw_6\":\"\",\"proputotlia_6\":\"\",\"propumsow_6\":\"\",\"propurps_6\":\"\",\"propups_6\":\"\",\"propucs_6\":\"\",\"proputs_6\":\"\",\"propucas_6\":\"\",\"propuose_6\":\"\",\"proputote_6\":\"\",\"proputle_6\":\"\",\"propuoe_6\":\"\",\"proputoe_6\":\"\",\"proputoien_6\":\"\",\"propuebit_6\":\"\",\"propuit_6\":\"\",\"propuibt_6\":\"undefined\",\"propuite_6\":\"\",\"propumi_6\":\"\",\"propudo_6\":\"\",\"propuei_6\":\"\",\"propueoac_6\":\"\",\"propuoi_6\":\"\",\"propunil_6\":\"\",\"propucash_6\":\"\",\"proputca_6\":\"\",\"proputcl_6\":\"\",\"propucae_6\":\"\",\"propusti_6\":\"\",\"propunre_6\":\"\",\"propuinvtry_6\":\"\",\"propuoca_6\":\"\",\"proputcass_6\":\"\",\"propulti_6\":\"\",\"propuppe_6\":\"\",\"propugw_6\":\"\",\"propuia_6\":\"\",\"propuaa_6\":\"\",\"propuoa_6\":\"\",\"propudltac_6\":\"\",\"proputa_6\":\"\",\"propuscltd_6\":\"\",\"propuap_6\":\"\",\"propuocl_6\":\"\",\"propultd_6\":\"\",\"propuolia_6\":\"\",\"propudltlc_6\":\"\",\"propumino_6\":\"\",\"propufet_6\":\"\",\"propultv_6\":\"\",\"propucac_6\":\"\",\"propultvac_6\":\"\",\"propuyear_7\":\"2015\",\"propuqtr_7\":\"Q1\",\"propurev_7\":\"\",\"propugm_7\":\"\",\"propuebitba_7\":\"\",\"propucor_7\":\"\",\"propugp_7\":\"\",\"propurd_7\":\"\",\"propusga_7\":\"\",\"propunr_7\":\"\",\"propungw_7\":\"\",\"proputotlia_7\":\"\",\"propumsow_7\":\"\",\"propurps_7\":\"\",\"propups_7\":\"\",\"propucs_7\":\"\",\"proputs_7\":\"\",\"propucas_7\":\"\",\"propuose_7\":\"\",\"proputote_7\":\"\",\"proputle_7\":\"\",\"propuoe_7\":\"\",\"proputoe_7\":\"\",\"proputoien_7\":\"\",\"propuebit_7\":\"\",\"propuit_7\":\"\",\"propuibt_7\":\"undefined\",\"propuite_7\":\"\",\"propumi_7\":\"\",\"propudo_7\":\"\",\"propuei_7\":\"\",\"propueoac_7\":\"\",\"propuoi_7\":\"\",\"propunil_7\":\"\",\"propucash_7\":\"\",\"proputca_7\":\"\",\"proputcl_7\":\"\",\"propucae_7\":\"\",\"propusti_7\":\"\",\"propunre_7\":\"\",\"propuinvtry_7\":\"undefined\",\"propuoca_7\":\"\",\"proputcass_7\":\"\",\"propulti_7\":\"\",\"propuppe_7\":\"\",\"propugw_7\":\"\",\"propuia_7\":\"\",\"propuaa_7\":\"\",\"propuoa_7\":\"\",\"propudltac_7\":\"\",\"proputa_7\":\"\",\"propuscltd_7\":\"\",\"propuap_7\":\"\",\"propuocl_7\":\"\",\"propultd_7\":\"\",\"propuolia_7\":\"\",\"propudltlc_7\":\"\",\"propumino_7\":\"\",\"propufet_7\":\"\",\"propultv_7\":\"\",\"propucac_7\":\"\",\"propultvac_7\":\"\"}";

        System.out.println("privatePro--result---"+FinancialManager.insertFinancialRecManager(privateproCmp,"2221112","private"));
        //System.out.println("private--result---"+FinancialManager.insertFinancialRecManager(privateCmp,"2221112","private"));
        //System.out.println("private--result---"+FinancialManager.insertFinancialRecManager(privateCmp,"2221112","private"));
        //System.out.println("public--result---"+FinancialManager.insertFinancialRecManager(publicCmp,"48975255","public"));
       
    }
}
