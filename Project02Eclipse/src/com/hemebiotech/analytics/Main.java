package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		ISymptomReader lecteur = new ReadSymptomDataFromFile (".//Project02Eclipse//symptoms.txt");
		ISymptomWriter writer= new WriteSymptomDataToFile();
		AnalyticsCounter analisticsCounter= new AnalyticsCounter(lecteur,writer);
		
		List<String> symptoms= new ArrayList<>();
		
		// recuperation des valeurs du fichier
		symptoms=analisticsCounter.getSymptoms(); // obtention de la liste des symptoms
		Map<String,Integer> occurrenceMap = new HashMap<>();
		occurrenceMap= analisticsCounter.countSymptoms(symptoms); // decompte des symptoms
		occurrenceMap=analisticsCounter.sortSymptoms(occurrenceMap); //trie des symptomes
		
		/// des symptomes dans le fichier result.out
		
		analisticsCounter.writeSymptoms(occurrenceMap);
		
	}

}
