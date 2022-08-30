package service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import model.Vengador;
import org.json.JSONArray;
import org.json.JSONObject;

    
 public class APImarvel {
    
    public static void api(Vengador aven) throws UnirestException {

        String api_public = "&apikey=4f9b4e2f1ba0a99daf5e5a6ad573f9a1";
        String ts = "&ts=1";
        String hash = "&hash=7013e560f8e6732bcb53078a9cd5df7c";
        String name = "name="+aven.getNombre();
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://gateway.marvel.com/v1/public/characters?"
                + name + api_public + ts + hash)
                .asString();
        JSONObject cadenaJSON = new JSONObject(response.getBody().toString());
        JSONObject cadena = cadenaJSON.getJSONObject("data");
        JSONArray detalles = cadena.getJSONArray("results");

        String url = detalles.getJSONObject(0).getJSONObject("thumbnail").getString("path");
        String extension = detalles.getJSONObject(0).getJSONObject("thumbnail").getString("extension");
        int comics = detalles.getJSONObject(0).getJSONObject("comics").getInt("available");
        int series = detalles.getJSONObject(0).getJSONObject("series").getInt("available");
        int stories = detalles.getJSONObject(0).getJSONObject("stories").getInt("available");
        int event = detalles.getJSONObject(0).getJSONObject("events").getInt("available");
        
        aven.setUrl(url+"."+extension);
        aven.setComic(comics);
        aven.setEventos(event);
        aven.setHistorias(stories);
        aven.setSeries(series); 
    }
}
