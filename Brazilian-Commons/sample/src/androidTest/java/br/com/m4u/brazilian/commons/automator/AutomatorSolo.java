/*
 * Created on 03/02/2015 by samir for CieloMobileTest
 * 
 * Copyright M4U Solucoes 2001-2015
 */
package br.com.m4u.brazilian.commons.automator;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.EditText;

import com.robotium.solo.Solo;

@SuppressWarnings("rawtypes")
public class AutomatorSolo extends Automator {

    private static final int DELAY_DAFAULT = 800;
    private static final int TEMPO_ESPERA = (60 * 1000) * 5;
    private Solo solo;
    private Instrumentation mInstrumentation;
    private ActivityInstrumentationTestCase2<?> testCase2;

    public AutomatorSolo(final Solo solo, Instrumentation mInstrumentation, ActivityInstrumentationTestCase2<?> testCase2) {
        this.solo = solo;
        this.mInstrumentation = mInstrumentation;
        this.testCase2 = testCase2;
    }

    @Override
    public void finishOpenedActivities() {

        solo.finishOpenedActivities();

    }

    @Override
    public void goToActivity(Class activityCls) {

        final String pkg = mInstrumentation.getTargetContext().getPackageName();

        testCase2.launchActivity(pkg, activityCls, null);

        postExecuteAction();
    }

    @Override
    public void typeText(final int index, final String text) {
        solo.typeText(index, text);

        postExecuteAction();
    }

    @Override
    public void typeTextWithMask(final int index, final String text) {
        final EditText editText = solo.getEditText(0);
        final Activity currentActivity = solo.getCurrentActivity();
        currentActivity.runOnUiThread(new Runnable() {
            public void run() {

                editText.setText(text);

            }
        });

        postExecuteAction();
    }

    @Override
    public void clickOnText(final String text) {
        solo.clickOnText(text);
        postExecuteAction();
    }

    @Override
    public void clickOnView(final int id) {
        final View view = solo.getView(id);
        solo.clickOnView(view);
        postExecuteAction();
    }

    public void postExecuteAction() {
        final int delayTime = DELAY_DAFAULT;
        sleep(delayTime);
    }

    private void sleep(final int delayTime) {
        try {
            Thread.sleep(delayTime);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void waitingForActivity(Class activity) {

        solo.waitForActivity(activity, TEMPO_ESPERA);

    }

    @SuppressWarnings("unchecked")
    @Override
    public void waitForText(String string) {

        solo.waitForText(string, 1, TEMPO_ESPERA);

    }

    @Override
    public boolean checkIfExistsText(String amountTest) {
        return solo.searchText(amountTest);
    }

    @Override
    public void goBack() {
        solo.goBack();
    }
}
