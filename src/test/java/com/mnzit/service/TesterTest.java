package com.mnzit.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.reflect.Whitebox;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;

@ExtendWith(SpringExtension.class)
public class TesterTest {

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    Tester tester;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void isCalled() {
        tester.setMap(new HashMap<>());
        tester.setValue("runOnce","asd");
        tester.testMethod("asd");
        Mockito.verify(tester, Mockito.times(1)).testMethod2();
    }
}