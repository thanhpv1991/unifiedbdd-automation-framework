/**
 *
 */
package com.klk.testing.automation.allure.listener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;

/**
 * An allure lifecycle listener used to subscribe to events.
 *
 * <ul>
 * <li>saves test name on scheduling a test</li>
 * <li>captures screenshots on test failure</li> </ul
 * 
 *
 * @author kkurian
 *
 */
public class TestReportListener implements TestLifecycleListener {

	public static ThreadLocal<String> TEST_NAME = new ThreadLocal<>();

	public static ThreadLocal<WebDriver> WEB_DRIVER = new ThreadLocal<>();

	@Override
	public void beforeTestSchedule(final TestResult result) {
		TEST_NAME.set(result.getName());
	}

	@Override
	public void afterTestUpdate(final TestResult result) {
		final WebDriver webDriver = WEB_DRIVER.get();
		if (webDriver != null && Status.FAILED.equals(result.getStatus())) {
			Allure.addByteAttachmentAsync("Screenshot", "image/png", ".png",
					() -> ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));
		}
	}

}