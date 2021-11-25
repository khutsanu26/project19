package project19;

import static org.junit.Assert.*;

import org.junit.Test;

public class FormVisibilityTest {

	@Test
	public void test() {
		Main clc = new Main();
	    clc.setVisible(true);
	    
	    boolean visibilityTestPassed = false;
	    
	    if (clc.isVisible()) {
	    	visibilityTestPassed = true;
	    }
	    
		assertTrue(visibilityTestPassed);
	}

}
