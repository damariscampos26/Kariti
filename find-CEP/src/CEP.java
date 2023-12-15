import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class CEP {

    public static void main(String[] args) {
                
		try{
			String cep = JOptionPane.showInputDialog("Digite o CEP:");
			String endereco = "https://viacep.com.br/ws/" + cep + "/json/";			
			URL objURL = new URL(endereco);
			HttpURLConnection conexao = (HttpURLConnection) objURL.openConnection();
			conexao.setRequestMethod("GET");
            conexao.connect();

			StringBuilder informationString = new StringBuilder();
			Scanner scanner = new Scanner(objURL.openStream());

			while (scanner.hasNext()) {
				informationString.append(scanner.nextLine());
			}
			//Close the scanner
			scanner.close();

			System.out.println(informationString);

/*
			//JSON simple library Setup with Maven is used to convert strings to JSON
			JSONParser parse = new JSONParser();
			JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(informationString));

			//Get the first JSON object in the JSON array
			System.out.println(dataObject.get(0));

			JSONObject countryData = (JSONObject) dataObject.get(0);

			System.out.println(countryData.get("woeid"));
	*/
		}catch(Exception e){
			System.out.println("Deu erro na URL.");
		}
	}
}