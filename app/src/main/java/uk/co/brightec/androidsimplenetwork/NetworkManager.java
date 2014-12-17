package uk.co.brightec.androidsimplenetwork;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import uk.co.brightec.androidsimplenetwork.model.Person;


/**
 * Created by chris on 17/12/14.
 */
public class NetworkManager {
    private static NetworkManager instance;
    private RequestQueue mRequestQueue;

    private NetworkManager(Context context) {
        mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static NetworkManager getInstance(Context context) {
        if (instance == null) {
            instance = new NetworkManager(context);
        }

        return instance;
    }

    public void cancelAll(Object tag) {
        mRequestQueue.cancelAll(tag);
    }

    public void getMyObject(Object tag) {
        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                Person[] person = new Gson().fromJson(string, Person[].class);
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        };

        StringRequest request = new StringRequest("http://api.domain.com/my-object.json", listener, errorListener);
        request.setTag(tag);
        mRequestQueue.add(request);
    }
}
