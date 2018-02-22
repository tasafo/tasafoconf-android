package org.tasafo.tasafoconf.io.json.model;

import java.io.Serializable;

/**
 * Created by ramonrabello on 13/11/15.
 */
public class BaseModel implements Serializable {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
