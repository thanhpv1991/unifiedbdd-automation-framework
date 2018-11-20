package com.github.kripaliz.automation.step;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.kripaliz.automation.AutomationApplication;

/**
 * A marker interface for StepDef classes. It takes care of the spring context
 * initialisation.
 *
 * @author kkurian
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AutomationApplication.class)
@SpringBootTest
public @interface StepDef {

}