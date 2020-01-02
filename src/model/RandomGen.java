package model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomGen {

	List<Integer> reihenFolge = new ArrayList<>();

	public List<Integer> reihenfolge() {

		for (int i = 0; i < 7; i++) {
			reihenFolge.add(i);

		}

		Collections.shuffle(reihenFolge);
		return reihenFolge;
	}

}
