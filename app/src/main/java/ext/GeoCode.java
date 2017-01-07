package ext;

import android.os.AsyncTask;

import org.json.JSONObject;

/**
 * Created by Samsung on 05/01/2017.
 */

public class GeoCode extends AsyncTask<String, Integer, JSONObject>{
    @Override
    protected JSONObject doInBackground(String... params) {
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}
