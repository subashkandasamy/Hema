package org.Com.Qa.Utils;

/**
 * @author subash Kandasmay
 *
 */
public class TimeUtils {

	public static void mediumWait() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void SamllWait() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void longWait() {

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
