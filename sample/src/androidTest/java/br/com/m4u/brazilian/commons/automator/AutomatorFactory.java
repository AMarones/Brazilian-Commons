/*
 * Created on 03/02/2015 by samir for CieloMobileTest
 * 
 * Copyright M4U Solucoes 2001-2015
 */
package br.com.m4u.brazilian.commons.automator;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

public class AutomatorFactory {

    public static Automator getAutomator(Solo solo, Instrumentation instrumentation, ActivityInstrumentationTestCase2<?> testCase2) {
        // TODO Auto-generated method stub
        return new AutomatorSolo(solo, instrumentation, testCase2);
    }

}
