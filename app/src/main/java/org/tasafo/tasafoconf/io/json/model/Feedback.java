package org.tasafo.tasafoconf.io.json.model;

import java.io.Serializable;

/**
 * Created by ramonrabello on 19/11/15.
 */
public class Feedback implements Serializable {

    private String category;
    private String type;
    private String content;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
