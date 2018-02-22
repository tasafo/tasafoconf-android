package org.tasafo.tasafoconf.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.github.florent37.glidepalette.GlidePalette;

import org.tasafo.tasafoconf.R;
import org.tasafo.tasafoconf.SpeakerDetailsActivity;
import org.tasafo.tasafoconf.io.json.model.Speaker;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by ramonrabello on 16/11/15.
 */
public class SpeakersAdapter extends RecyclerView.Adapter<SpeakersAdapter.SpeakerViewHolder> {

    static WeakReference<Context> contextWeakReference;
    static List<Speaker> speakers;

    public SpeakersAdapter(Context c, List<Speaker> speakerList) {
        contextWeakReference = new WeakReference<>(c);
        speakers = speakerList;
    }

    @Override
    public SpeakerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.speaker_view_holder, parent, false);
        return new SpeakerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SpeakerViewHolder holder, int position) {
        holder.bind(speakers.get(position));
    }

    @Override
    public int getItemCount() {
        return speakers.size();
    }

//    private static class LoadProfileImageTask extends AsyncTask<String, Void, Bitmap> {
//
//        @Override
//        protected Bitmap doInBackground(String... params) {
//            Bitmap bitmap = null;
//            try {
//                String profilImageUrl = params[0];
//                Glide.with(contextWeakReference.get()).load(profilImageUrl)
//                        .apply(RequestOptions.placeholderOf(R.drawable.ic_account))
//                        .listener(new RequestListener<Drawable>() {
//                            @Override
//                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                                return false;
//                            }
//
//                            @Override
//                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                                return false;
//                            }
//                        })
//                        .into(250, 250);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return bitmap;
//        }
//
//        @Override
//        protected void onPostExecute(final Bitmap bitmap) {
//            new Palette.Builder(bitmap).generate(new Palette.PaletteAsyncListener() {
//                @Override
//                public void onGenerated(Palette palette) {
//                    holder.speakerIcon.setImageBitmap(bitmap);
//                    holder.footerContainer.setVisibility(View.VISIBLE);
//                    holder.footerContainer.setBackgroundColor(palette.getVibrantColor(contextWeakReference.getResources().getColor(android.R.color.darker_gray)));
//                    holder.footerContainer.animate().alpha(100).setDuration(1000).start();
//                }
//            });
//        }
//    }.
//
//    execute();

    static class SpeakerViewHolder extends RecyclerView.ViewHolder {

        private final ImageView speakerIcon;
        private final TextView speakerName;
        private final TextView speakerWorkAt;
        //private final TextView presentationAvailable;
        private final View footerContainer;

        SpeakerViewHolder(final View itemView) {
            super(itemView);
            speakerIcon = itemView.findViewById(R.id.speaker_icon);
            speakerName = itemView.findViewById(R.id.speaker_name);
            speakerWorkAt = itemView.findViewById(R.id.speaker_work_at);
            footerContainer = itemView.findViewById(R.id.footer_container);
            //presentationAvailable = itemView.findViewById(R.id.presentation_available);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = itemView.getContext();
                    Speaker speaker = speakers.get(getAdapterPosition());
                    Intent i = new Intent(context, SpeakerDetailsActivity.class);
                    i.putExtra("chosen_speaker", speaker);
                    context.startActivity(i);
                }
            });
        }

        @SuppressLint("CheckResult")
        void bind(Speaker speaker) {
            speakerName.setText(speaker.getName());
            speakerWorkAt.setText(speaker.getWorkAt());

            Glide.with(itemView.getContext()).load(speaker.getProfileImageUrl())
                    .listener(GlidePalette.with(speaker.getProfileImageUrl())
                            .use(GlidePalette.Profile.MUTED_DARK)
                            .intoBackground(speakerIcon)
                            .intoCallBack(new GlidePalette.CallBack() {

                                @Override
                                public void onPaletteLoaded(@Nullable Palette palette) {
                                    if (palette != null) {
                                        footerContainer.setVisibility(View.VISIBLE);
                                        footerContainer.setBackgroundColor(palette.getVibrantColor(ContextCompat.getColor(itemView.getContext(), android.R.color.darker_gray)));
                                        footerContainer.animate().alpha(100).setDuration(1000).start();
                                    }
                                }
                            })
                            .crossfade(true));
        }
    }

}
