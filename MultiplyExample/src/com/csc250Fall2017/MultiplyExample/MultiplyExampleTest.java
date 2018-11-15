package com.csc250Fall2017.MultiplyExample;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiplyExampleTest {

	@Test
	public void testMyMultiply() {
		MultiplyExample lab = new MultiplyExample();
		double number = lab.MyMultiply(4.3, 1.9);
		assertEquals(8.17, number, .01);
	}

}