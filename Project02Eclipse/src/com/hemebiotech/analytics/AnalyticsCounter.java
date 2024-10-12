package com.hemebiotech.analytics;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	// variable de class pour la lecture et l'ecriture dans un fichier
	
	private static ISymptomReader reader;
	private static ISymptomWriter writer;
	
	
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader=reader;
		this.writer=writer;
	}
	
	
	//
	/// recuperation des entrees d'un fichier
	
	public List<String> getSymptoms() {
		List<String> symptoms=new ArrayList<>();
		return symptoms=this.reader.GetSymptoms();
	}
	
	
	//
	// compter les occurrences de chaque symptôme
	
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		
		Map<String,Integer> occurrenceMap = new HashMap<>();

        for (String symptom : symptoms) {
            occurrenceMap.put(symptom, occurrenceMap.getOrDefault(symptom, 0) + 1);
        }

        return occurrenceMap;
	}
	
	
	///
	/// méthode sortSymptoms qui trie la liste de symptômes et d’occurrences par ordre alphabétique
	
	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
		 return new TreeMap<>(symptoms);
	}
	
	
	///
	////ecriture des donnees dans le fichier de sorti
	
	public void writeSymptoms(Map<String, Integer> symptoms) { 
		this.writer.writeSymptoms(symptoms);
	}
	
	
}
