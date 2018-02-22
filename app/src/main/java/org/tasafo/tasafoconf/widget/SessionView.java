package org.tasafo.tasafoconf.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import org.tasafo.tasafoconf.R;

/**
 * Created by ramonrabello on 12/11/15.
 */
public class SessionView extends FrameLayout {

    public SessionView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public SessionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public SessionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr){

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SessionView);

        String startTimeAttr = a.getString(R.styleable.SessionView_startTime);
        String endTimeAttr = a.getString(R.styleable.SessionView_endTime);
        String sessionTitleAttr = a.getString(R.styleable.SessionView_sessionTitle);
        String typeAttr = a.getString(R.styleable.SessionView_type);

        if(typeAttr != null){

            if (typeAttr.equals("break")){

                inflate(context, R.layout.break_session_view, this);

            } else if (typeAttr.equals("keynote")){

                inflate(context, R.layout.keynote_session_view, this);

            } else if (typeAttr.equals("speaker")){

                inflate(context, R.layout.speaker_session_view, this);

            } else {
                throw new IllegalArgumentException("Error while reading type attribute from SessionView. Types accepted: speaker, break, keynote");
            }
        }

        int speakerIconRes = a.getInteger(R.styleable.SessionView_speakerIcon, 0);
        String speakerName = a.getString(R.styleable.SessionView_speakerName);

        TextView startTime = (TextView) findViewById(R.id.start_time);

        TextView endTime = (TextView) findViewById(R.id.end_time);
        TextView sessionTitle = (TextView) findViewById(R.id.session_title);
        ImageView speakerIcon = (ImageView) findViewById(R.id.speaker_icon);

        a.recycle();
    }
}
