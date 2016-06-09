/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.model;

import java.util.List;

/**
 *
 * @author Siddharaj Atodaria
 */
public class FinancialModel {

    /**
     * Private financial data List
     */
    public List<PrivateFinancial> getPrivatelst() {
        return privatelst;
    }

    /**
     * Public financial data List
     */
    public List<PublicFinancial> getPubliclst() {
        return publiclst;
    }

    public void setPrivatelst(List<PrivateFinancial> privatelst) {
        this.privatelst = privatelst;
    }

    public void setPubliclst(List<PublicFinancial> publiclst) {
        this.publiclst = publiclst;
    }

    public List<PrivateFinancial> privatelst;
    public List<PublicFinancial> publiclst;

}
