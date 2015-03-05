package br.com.m4u.brazilian.commons;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import br.com.m4u.commons.brazilia.app.demo.automator.Automator;
import br.com.m4u.commons.brazilia.app.demo.automator.AutomatorFactory;


public class SampleActivityTest extends ActivityInstrumentationTestCase2 {

    protected Automator automator;
    protected Solo solo;

    public SampleActivityTest() {
        super(SampleActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        final Instrumentation instrumentation = getInstrumentation();
        solo = new Solo(instrumentation, getActivity());
        automator = AutomatorFactory.getAutomator(solo, instrumentation, this);
    }

    @Override
    public void tearDown() throws Exception {
        automator.finishOpenedActivities();
    }

    public void testTextWatcherCPF() {
        String stringCpf = "13064663771";
        String formatedCpf = "130.646.637-71";

        solo.enterText(0, stringCpf);

        assertEquals(formatedCpf, solo.getEditText(0).getEditableText().toString());
    }

    public void testTextWatcherPhone() {
        String stringPhone = "21997178644";
        String formatedPhone = "(21) 997178644";

        solo.enterText(1, stringPhone);

        assertEquals(formatedPhone, solo.getEditText(1).getEditableText().toString());
    }

}
