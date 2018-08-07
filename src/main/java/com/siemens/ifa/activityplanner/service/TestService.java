package com.siemens.ifa.activityplanner.service;

import org.springframework.stereotype.Component;

/**
 * Spring bean -> has a scope.
 * By default scope is singleton.
 */
@Component
public class TestService {
    public String message() {
        return "test";
    }
}
