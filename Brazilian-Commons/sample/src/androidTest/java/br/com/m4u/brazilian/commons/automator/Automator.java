/*
 * Created on 03/02/2015 by samir for CieloMobileTest
 * 
 * Copyright M4U Solucoes 2001-2015
 */
package br.com.m4u.brazilian.commons.automator;

@SuppressWarnings("rawtypes")
public abstract class Automator {

    public abstract void finishOpenedActivities();

    public abstract void goToActivity(Class string);

    public abstract void typeText(int i, String technicalPassword);

    public abstract void typeTextWithMask(int i, String technicalPassword);

    public abstract void clickOnText(String text);

    public abstract void clickOnView(int id);

    public abstract void waitingForActivity(Class class1);

    public abstract void waitForText(String pagamento);

    public abstract boolean checkIfExistsText(String amountTest);

    public abstract void goBack();
}
