
package com.example.hamza.NewsFeedApp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ArticleAdapter extends ArrayAdapter<Article> {

    public ArticleAdapter(@NonNull Context context, List<Article> articles) {
        super(context, 0, articles);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        ViewHolder holder;
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.stories_list_items, null);
            holder = new ViewHolder();
            holder.titleView = (TextView) listItemView.findViewById(R.id.title);
            holder.sectionNameView = (TextView) listItemView.findViewById(R.id.section_name);
            holder.authorNameView = (TextView) listItemView.findViewById(R.id.author_name);
            holder.dateView = (TextView) listItemView.findViewById(R.id.date);
            holder.timeView = (TextView) listItemView.findViewById(R.id.time);

            listItemView.setTag(holder);
        } else {
            holder = (ViewHolder) listItemView.getTag();
        }

        Article currentArticle = getItem(position);
        // Find the TextView with view ID title
        holder.titleView.setText(currentArticle.getTitle());

        // Find the TextView with view ID section_name
        holder.sectionNameView.setText(currentArticle.getSectionName());

        // Find the TextView with view ID author_name
        holder.authorNameView.setText(currentArticle.getAuthorName());

        //separate the date into two parts
        String Date;
        String Time;
        String[] parts = currentArticle.getDate().split("T");
        Date = parts[0];
        Time = parts[1];
        // Display the date of the current article in that TextView
        // Find the TextView with view ID date
        holder.dateView.setText(Date);
        // Find the TextView with view ID time
        holder.timeView.setText(Time);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    static class ViewHolder {
        private TextView titleView;
        private TextView sectionNameView;
        private TextView authorNameView;
        private TextView dateView;
        private TextView timeView;
    }
}
