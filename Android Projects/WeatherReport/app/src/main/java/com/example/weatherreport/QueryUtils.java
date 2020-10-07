package com.example.weatherreport;

import android.icu.number.Precision;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class QueryUtils {

    private static final String LOG_TAG = "HTTPQuery" ;
    private static final String API_KEY = "ENTER YOUR API KEY HERE";
    private static final String OWM_REQUEST_URL = "https://api.openweathermap.org/data/2.5/weather";
    private static final String OWM_QUERY_1 = "?lat=";
    private static final String OWM_QUERY_2 = "&lon=";
    private static String JSONresponse;
    private static String temp;
    private static String city;

    /**
     * Create a private constructor because no one should ever create a {@link QueryUtils} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
     */
    private QueryUtils(){
    }

//    Method to create url object
    private static URL createUrl(String latitude, String longitude) {
        String stringUrl = OWM_REQUEST_URL+OWM_QUERY_1+latitude+OWM_QUERY_2+longitude+"&appid="+API_KEY ;
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL ", e);
        }
        return url;
    }

//    Method to connect to API and receive data
    private static String makeHttpRequest(String latitude, String longitude) throws IOException {
        URL url = createUrl(latitude, longitude);
        String jsonResponse = "";
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() ==  200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            }
            else
            {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            // TODO: Handle the exception
            Log.e(LOG_TAG, "Problem retrieving the weather JSON response.", e);
        } catch (android.os.NetworkOnMainThreadException nex) {
            Log.e(LOG_TAG,"Network calls should be made on background thread ",nex);
        }
        finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies that an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }

//    Method to parse response received from API
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

//    Method to store data in a Weather Object
    private static Weather extractWeatherfromJSON(String responseFromAPI){
        Weather currentWeather = null;
        try {
            JSONObject root = new JSONObject(responseFromAPI);
            city = root.optString("name");

            JSONObject main = root.getJSONObject("main");
            temp = main.optString("temp");
            currentWeather = new Weather(city,temp);
        }
        catch (JSONException e) {
            Log.e(LOG_TAG, "Error Parsing JSON");
        }

        return currentWeather;
    }

//    Driver Method
    public static Weather fetchWeather(String latitude, String longitude) {
        Weather currentWeather = null;
        try {
            JSONresponse = makeHttpRequest(latitude, longitude);
            currentWeather = extractWeatherfromJSON(JSONresponse);
        }
        catch (IOException e) {
            Log.e(LOG_TAG,"Error Fetching Response");
        }
        return currentWeather;
    }
}
