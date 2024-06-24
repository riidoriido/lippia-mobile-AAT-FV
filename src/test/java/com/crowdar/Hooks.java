package com.crowdar;

import com.crowdar.examples.services.ApiHelperService;
import io.cucumber.java.After;

public class Hooks {

    @After
    public static void cleanupEntries() {
        ApiHelperService.cleanUpEntriesAfterTest();
        ApiHelperService.cleanUpSpecificEntry();
    }
}
