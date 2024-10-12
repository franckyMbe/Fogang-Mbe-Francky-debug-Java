package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int pupilCount = 0;
	
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
	
	
	public static void main(String args[]) throws Exception {
		// first get input

		BufferedReader reader = new BufferedReader (new FileReader(".//Project02Eclipse//symptoms.txt"));
		String line = reader.readLine();

		int i = 0;	
		int headCount = 0;	// counts headaches
		while (line != null) {
			i++;	
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
