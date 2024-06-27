package com.crowdar;

import com.crowdar.examples.services.APIManagement;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;

public class Hooks {

    @After(value = "@CleanUpTimeEntry")
    public static void cleanupEntries() {
            APIManagement.cleanUpEntriesAfterTest();
            APIManagement.cleanUpSpecificEntry();

    }

}
