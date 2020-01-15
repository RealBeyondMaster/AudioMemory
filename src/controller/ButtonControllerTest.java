package controller;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.ButtonGame;

public class ButtonControllerTest {
	private ButtonController ButtonController;
	private ArrayList<ButtonGame> clickedButton;

	@Before
	public void setUp() throws Exception {
		ButtonController = new ButtonController();
	}

	@After
	public void tearDown() throws Exception {
		ButtonController = null;
	}

	@Test
	public void testIsMatchingPairsReturnsNotNull() {
		// clickedButton[1] = true;

		assertNotNull(ButtonController.isMatchingPairs(null));
		System.out.println(clickedButton);

	}

//	@Test
//	public void isMatchingPairstest() {
//		this.clickedButton = new ArrayList<ButtonGame>(1);
//	}

}
