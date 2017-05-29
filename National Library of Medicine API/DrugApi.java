package finale;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DrugApi {

	public DrugApi (){
		
	}
	// Gets Drug ID
	public void DrugID (String ID){
		//https://rxnav.nlm.nih.gov/REST/interaction/interaction.json?rxcui=88014&sources=ONCHigh
		 try {
				URL url = new URL("https://rxnav.nlm.nih.gov/REST/interaction/list.json?rxcuis=207106+152923+656659");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				
				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

				String output;
				output = br.readLine();
				System.out.println(output);
				String [] Id = output.split("fullInteractionTypeGroup");
				if(Id.length < 2){
					System.out.println("Drug is Not Available");
				}else{
					String [] allDrugs = Id[1].split("name");
				for(int i = 1; i < allDrugs.length; i++){
						String [] x = allDrugs[i].split(",");
						System.out.println(x[0]);
					}
				}
				
				conn.disconnect();

			  } catch (MalformedURLException e) {

				e.printStackTrace();

			  } catch (IOException e) {

				e.printStackTrace();

			  }
	}
	
	/*
	 * Type in Name and the ID gets searched ...  
	 */
	public void getListOfDrugInteractions (ArrayList<String> list){
		
		int i = 0;
		
		String drug = "";
		
		while (i < list.size() ){
			drug += getDrugID(list.get(i)) + "+";
		}
		
		https://rxnav.nlm.nih.gov/REST/interaction/list.json?rxcuis=207106+152923+656659
			
		try {
			URL url = new URL("https://rxnav.nlm.nih.gov/REST/interaction/list.json?rxcuis"+drug);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output= br.readLine();
		System.out.println("Output from Server .... \n");		
		String [] interAction = output.split("fullInteractionTypeGroup");
		if(interAction.length < 2){
			System.out.println("One or More of the drugs are not in the Data Base");
		}else{
			
			String [] minConcept = interAction[1].split("minConcept");
			for(int n = 0; n < minConcept.length; n ++){
				String [] name = minConcept [n].split("name");
				for(int x = 0; x < name.length; x++){
					// COULDN"T FIGURE IT OUT FACE 
				}
			}
		}
		
		conn.disconnect();

	  } catch (MalformedURLException e) {
		e.printStackTrace();
	  } catch (IOException e) {
		e.printStackTrace();
	  }
	}

	public String getDrugID(String name){
		
		try {
			URL url = new URL("https://rxnav.nlm.nih.gov/REST/rxcui?name="+name);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output = br.readLine();
			String [] Id = output.split("rxnormId");
			System.out.println(output);
			String drugId = Id[1].substring(4, 9);
			System.out.println(drugId);
			return drugId;
		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }
		return null;
		
	}
	
}