package ir.heyzha.www.kamaposter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ThumbnailsAdapter extends RecyclerView.Adapter<ThumbnailsAdapter.UnitsViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<String> mData;

    public ThumbnailsAdapter(Context context) {
        this.mContext = context;
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

        holder.imageViewThumbnail.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @SuppressLint("NewApi")
            @Override
            public void onGlobalLayout() {
                int h = holder.imageViewThumbnail.getMeasuredWidth();
                holder.imageViewThumbnail.setLayoutParams(new LinearLayout.LayoutParams(h, h));
                holder.imageViewThumbnail.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

        Picasso.get()
                .load(mData.get(position))
                .error(R.drawable.ic_error)
                .placeholder(mContext.getResources().getDrawable(R.drawable.ic_error))
                .into(holder.imageViewThumbnail);
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
