package org.tasafo.tasafoconf.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.tasafo.tasafoconf.R;
import org.tasafo.tasafoconf.SessionDetailsActivity;
import org.tasafo.tasafoconf.SpeakerDetailsActivity;
import org.tasafo.tasafoconf.io.json.model.Session;
import org.tasafo.tasafoconf.io.json.model.Speaker;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ramonrabello on 16/11/15.
 */
public class SessionAdapter extends RecyclerView.Adapter<SessionAdapter.SessionViewHolder> implements View.OnClickListener {

    private static final int BREAK_SESSION_TYPE = 1;
    private static final int KEYNOTE_SESSION_TYPE = 2;
    private static final int SPEAKER_SESSION_TYPE = 3;

    static private List<Session> sessions;
    static private Context context;

    public SessionAdapter(Context context, List<Session> sessions) {
        this.context = context;
        this.sessions = sessions;
    }

    @Override
    public SessionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        switch (viewType){
            case BREAK_SESSION_TYPE:{
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.break_session_view, parent, false);
                break;
            }

            case KEYNOTE_SESSION_TYPE:{
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.keynote_session_view, parent, false);
                break;
            }

            case SPEAKER_SESSION_TYPE:{
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.speaker_session_view, parent, false);
                break;
            }
        }
        return new SessionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SessionViewHolder holder, int position) {
        Session session = sessions.get(position);
        holder.startTime.setText(session.getStartTime());
        holder.endTime.setText(session.getEndTime());
        holder.sessionTitle.setText(session.getTitle());

        if (!session.isBreak()){

            Speaker speaker = session.getSpeakers().get(0);

            if (session.hasOneSpeaker()){

                if (holder.firstSpeakerIcon != null){
                    Glide.with(context).load(speaker.getProfileImageUrl()).into(holder.firstSpeakerIcon);
                }

                if (holder.firstSpeakerName != null){
                    holder.firstSpeakerName.setText(speaker.getName());
                }

                if (holder.firstSpeakerWorkAt != null){
                    holder.firstSpeakerWorkAt.setText(speaker.getWorkAt());
                }

            } else if (session.hasTwoSpeakers()){

                if (holder.firstSpeakerIcon != null){
                    Glide.with(context).load(speaker.getProfileImageUrl()).into(holder.firstSpeakerIcon);
                }

                if(holder.firstSpeakerName != null){
                    holder.firstSpeakerName.setText(speaker.getName());
                }

                if(holder.firstSpeakerWorkAt != null){
                    holder.firstSpeakerWorkAt.setText(speaker.getWorkAt());
                }

                holder.secondSpeakerIcon.setVisibility(View.VISIBLE);
                holder.secondSpeakerName.setVisibility(View.VISIBLE);
                holder.secondSpeakerWorkAt.setVisibility(View.VISIBLE);

                Speaker secondSpeaker = session.getSpeakers().get(1);

                if (holder.secondSpeakerIcon != null){
                    Glide.with(context).load(secondSpeaker.getProfileImageUrl()).into(holder.secondSpeakerIcon);
                }

                if (holder.secondSpeakerName != null){
                    holder.secondSpeakerName.setText(secondSpeaker.getName());
                }

                if (holder.secondSpeakerWorkAt != null){
                    holder.secondSpeakerWorkAt.setText(secondSpeaker.getWorkAt());
                }

                holder.presentationAvailable.setVisibility(session.isPresentationAvailable() ? View.VISIBLE : View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return sessions.size();
    }

    @Override
    public int getItemViewType(int position) {
        Session session = sessions.get(position);

        if (session.isBreak()){
            return BREAK_SESSION_TYPE;

        } else if (session.isKeynote() || session.isInvitedSpeaker()){
            return KEYNOTE_SESSION_TYPE;

        } else if (session.isDevOpsTrack() ||
                session.isInnovationEnterpreneurshipAndCommunityTrack() ||
                session.isManagementBusinessAgileTrack() ||
                session.isMobileAndGameTrack()){
            return SPEAKER_SESSION_TYPE;
        }
        return -1;
    }

    @Override
    public void onClick(View v) {

    }

    public static final class SessionViewHolder extends RecyclerView.ViewHolder {

        private TextView startTime;
        private TextView endTime;
        private TextView sessionTitle;

        private CircleImageView firstSpeakerIcon;
        private TextView firstSpeakerName;
        private TextView firstSpeakerWorkAt;

        private CircleImageView secondSpeakerIcon;
        private TextView secondSpeakerName;
        private TextView secondSpeakerWorkAt;
        private TextView presentationAvailable;

        private Session chosenSession;

        public SessionViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chosenSession = sessions.get(getAdapterPosition());

                    if (!chosenSession.isBreak()){
                        Intent i = new Intent(context, SessionDetailsActivity.class);
                        i.putExtra("chosen_session", chosenSession);
                        context.startActivity(i);
                    }
                }
            });
            startTime = itemView.findViewById(R.id.start_time);
            endTime = itemView.findViewById(R.id.end_time);
            sessionTitle = itemView.findViewById(R.id.session_title);

            firstSpeakerIcon = itemView.findViewById(R.id.first_speaker_icon);
            if (firstSpeakerIcon != null){
                firstSpeakerIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openSpeakerDetailsActivity(0);
                    }
                });
            }

            firstSpeakerName = itemView.findViewById(R.id.first_speaker_name);
            firstSpeakerWorkAt = itemView.findViewById(R.id.first_speaker_work_at);

            secondSpeakerIcon = itemView.findViewById(R.id.second_speaker_icon);
            if (secondSpeakerIcon != null){
                secondSpeakerIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openSpeakerDetailsActivity(1);
                    }
                });
            }

            secondSpeakerName = itemView.findViewById(R.id.second_speaker_name);
            secondSpeakerWorkAt = itemView.findViewById(R.id.second_speaker_work_at);
            presentationAvailable = itemView.findViewById(R.id.presentation_available);
        }

        private void openSpeakerDetailsActivity(int index) {
            chosenSession = sessions.get(getAdapterPosition());
            Intent i = new Intent(context, SpeakerDetailsActivity.class);
            i.putExtra("chosen_speaker", chosenSession.getSpeakers().get(index));
            context.startActivity(i);
        }
    }
}
