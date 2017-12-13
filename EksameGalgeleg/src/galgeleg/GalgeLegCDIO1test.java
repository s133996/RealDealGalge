package galgeleg;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

public class GalgeLegCDIO1test {
	
	@Test
	public void basicTests() {
		Galgelogik logic = new Galgelogik();
		
		// Tjekker om det synlige ord, ret faktisk er det ord man skal gætte.
		assertEquals(logic.getOrdet().length(), logic.getSynligtOrd().length());
		
		// Tjekker om spillet slutter, når man har gættet forkert over 6 gange
		assertEquals(logic.getAntalForkerteBogstaver() > 6, logic.erSpilletTabt() == true);
	
	}
	
	@Test
	public void logicTests() {
		Galgelogik logic = new Galgelogik();
		
		logic.gætBogstav("a");
		assertTrue(logic.getBrugteBogstaver().contains("a"));
		
		ArrayList<String> brugteBogstaver = logic.getBrugteBogstaver();
		int i = logic.getBrugteBogstaver().size()-1;
		if(logic.erSidsteBogstavKorrekt()){
			assertTrue(logic.getSynligtOrd().contains(brugteBogstaver.get(i)));
		} else {
			assertFalse(logic.getSynligtOrd().contains(brugteBogstaver.get(i)));
		}
		
	}
	
	
	
	@Test
	public void gameConstruct() {
		//Her køres et komplet spil, med et tilfældigt ord. Spillet skal returnere når
		//ordet enten er gættet, eller når spillet er tabt.
		Galgelogik logic = new Galgelogik();
		
		// Giver et tilfældigt tal mellem 0 og 27
		Random randomnumber = new Random();
		char[] alfabet = "abcdefghijklmnopqrstuvwxyzæøå".toCharArray();
		
		while(logic.erSpilletSlut() == false){
			// Giver et tilfældigt tal mellem 0 og 27
			int tal = randomnumber.nextInt(27);	
			logic.gætBogstav(""+alfabet[tal]);
			if(logic.erSpilletSlut()){
				assertTrue(logic.erSpilletSlut());
			}
		}
	}
	
}