package com.hemebiotech.analytics;

import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;

public class WriteSymptomDataToFile implements ISymptomWriter {
	
	private String writePath;
	
	public WriteSymptomDataToFile() {
		this.writePath="result.out";
	}
	
	public void writeSymptoms(Map<String, Integer> symptoms) {
		
		//ecriture des donnees donnees dans le fichier resultat.out
		try {
			FileWriter writer= new FileWriter(this.writePath);
			writer.write("\n");
			writer.write("\n");
			writer.write("\t\t"+"Symptoms"+"\t\t\t\t"+"Nombre"+"\n");
			writer.write("\t\t"+"_________"+"\t\t\t\t"+"_______"+"\n");
			writer.write("\n");
			writer.write("\n");
	        for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
	            writer.write("\t\t" + entry.getKey() + "  :\t\t\t\t\t" + entry.getValue()+"\n");
	        }
	        writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
