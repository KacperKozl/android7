package com.example.libraryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BookDetailsActivity extends AppCompatActivity {
    private TextView bookTitleTextView;
    private TextView bookAuthorTextView;
    private TextView bookSubtitleTextView;
    private ImageView bookCover;
    public static final String BOOK_DETAILS_TITLE = "BOOK_DETAILS_TITLE";
    public static final String BOOK_DETAILS_AUTHOR = "BOOK_DETAILS_AUTHOR";
    public static final String BOOK_DETAILS_COVER = "BOOK_DETAILS_COVER";
    public static final String BOOK_DETAILS_SUBTITLE = "BOOK_DETAILS_SUBTITLE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        bookAuthorTextView=findViewById(R.id.book_author);
        bookTitleTextView=findViewById(R.id.book_title);
        bookSubtitleTextView=findViewById(R.id.book_subtitle);
        bookCover=findViewById(R.id.img_cover);
        Intent intent=getIntent();
        bookTitleTextView.setText(intent.getStringExtra(BOOK_DETAILS_TITLE));
        bookAuthorTextView.setText(intent.getStringExtra(BOOK_DETAILS_AUTHOR));
        bookSubtitleTextView.setText(intent.getStringExtra(BOOK_DETAILS_SUBTITLE));
        String cover= intent.getStringExtra(BOOK_DETAILS_COVER);
        if(cover!=null){
            Picasso.with(this)
                    .load(MainActivity.IMAGE_URL_BASE+cover+"-L.jpg")
                    .placeholder(R.drawable.book_icon).into(bookCover);
        }else{
            bookCover.setImageResource(R.drawable.book_icon);
        }
    }
}