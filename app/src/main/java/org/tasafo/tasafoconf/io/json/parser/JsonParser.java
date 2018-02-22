package org.tasafo.tasafoconf.io.json.parser;

import android.os.Parcelable;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.Serializable;

/**
 * Created by ramonrabello on 12/11/15.
 */
public abstract class JsonParser<T extends Serializable> {

    private Gson gson = new Gson();

    protected abstract T parse(InputStream is);

    protected Gson getGson(){
        return gson;
    }
}
