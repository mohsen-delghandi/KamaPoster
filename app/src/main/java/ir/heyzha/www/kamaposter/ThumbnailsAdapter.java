package ir.heyzha.www.kamaposter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ThumbnailsAdapter extends RecyclerView.Adapter<ThumbnailsAdapter.UnitsViewHolder> {

    private Context mContext;
    private Intent intent;
    private LayoutInflater mLayoutInflater;
    private List<String> mData;

    public ThumbnailsAdapter(Context context, Intent intent) {
        this.mContext = context;
        this.intent = intent;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    public void updateAdapterData(List<String> data) {
        this.mData = data;
    }


    @Override
    public UnitsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.activity_thumbnails_item, parent, false);
        return new UnitsViewHolder(view);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(final UnitsViewHolder holder, final int position) {
        final List<String> currentModel = mData;

        Glide
                .with(mContext)
                .load(currentModel.get(position))
                .centerCrop()
                .placeholder(R.drawable.loading)
                .into(holder.imageViewThumbnail);

        holder.imageViewThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, GalleryViewActivity.class);
                i.putExtra(Constants.CATEGORY, intent.getExtras().getString(Constants.CATEGORY));
                i.putExtra(Constants.POSITION, position);
                mContext.startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        try {
            return mData.size();
        } catch (Exception e) {
            return 0;
        }
    }

    public class UnitsViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewThumbnail;

        public UnitsViewHolder(View itemView) {
            super(itemView);
            imageViewThumbnail = itemView.findViewById(R.id.imageView_thumbnail);
        }
    }
}
