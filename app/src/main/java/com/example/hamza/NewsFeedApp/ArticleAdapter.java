
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
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.stories_list_items, parent, false);
        }
        Article currentArticle = getItem(position);

        // Find the TextView with view ID title
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        titleView.setText(currentArticle.getTitle());

        // Find the TextView with view ID section_name
        TextView sectionNameView = (TextView) listItemView.findViewById(R.id.section_name);
        sectionNameView.setText(currentArticle.getSectionName());

        // Find the TextView with view ID author_name
        TextView authorNameView = (TextView) listItemView.findViewById(R.id.author_name);
        authorNameView.setText(currentArticle.getAuthorName());

        //separate the date into two parts
        String Date;
        String Time;
        String[] parts = currentArticle.getDate().split("T");
        Date = parts[0];
        Time = parts[1];
        // Display the date of the current article in that TextView
        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(Date);
        // Find the TextView with view ID time
        TextView TimeView = (TextView) listItemView.findViewById(R.id.time);
        TimeView.setText(Time);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

}
