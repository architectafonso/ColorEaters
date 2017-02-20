package com.empire_of_science.joao.coloreaters2;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;

//import org.junit.Test;
//import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }
}

/*
todo: mudar estes testes
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext () throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("org.mypackage", appContext.getPackageName());
    }
}
*/