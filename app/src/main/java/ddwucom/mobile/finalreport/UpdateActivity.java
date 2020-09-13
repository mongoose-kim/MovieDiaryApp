package ddwucom.mobile.finalreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    Movie movie;

    ImageView img;
    EditText etTitle;
    EditText etDirector;
    EditText etActor;
    EditText etGenre;
    EditText etNation;

    MovieDBManager movieDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        movie = (Movie) getIntent().getSerializableExtra("movie");

        etTitle = findViewById(R.id.et_title);
        etDirector = findViewById(R.id.et_director);
        etActor = findViewById(R.id.et_actor);
        etGenre = findViewById(R.id.et_genre);
        etNation = findViewById(R.id.et_nation);

        etTitle.setText(movie.getMovieTitle());
        etDirector.setText(movie.getDirector());
        etActor.setText(movie.getMainActor());
        etGenre.setText(movie.getGenre());
        etNation.setText(movie.getNation());

        movieDBManager = new MovieDBManager(this);

        img = findViewById(R.id.imageMovie);

        if(movie.get_id() == 1)
            img.setImageResource(R.mipmap.vanashingtime);
        else if(movie.get_id() == 2)
            img.setImageResource(R.mipmap.parasite);
        else if(movie.get_id() == 3)
            img.setImageResource(R.mipmap.my);
        else if(movie.get_id() == 4)
            img.setImageResource(R.mipmap.maleficent);
        else if(movie.get_id() == 5)
            img.setImageResource(R.mipmap.busan);
        else if(movie.get_id() == 6)
            img.setImageResource(R.mipmap.aladdin);
        else if(movie.get_id() == 7)
            img.setImageResource(R.mipmap.abouttime);
        else if(movie.get_id() == 8)
            img.setImageResource(R.mipmap.oceans8);
        else if(movie.get_id() == 9)
            img.setImageResource(R.mipmap.theconjuring);
        else if(movie.get_id() == 10)
            img.setImageResource(R.mipmap.hero);
        else
            img.setImageResource(R.mipmap.newmovie);

    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_update:
                movie.setAll(etTitle.getText().toString(), etDirector.getText().toString(),
                        etActor.getText().toString(), etGenre.getText().toString(), etNation.getText().toString());


                if (movieDBManager.modifyMovie(movie)) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("movie", movie);
                    setResult(RESULT_OK, resultIntent);
                } else {
                    setResult(RESULT_CANCELED);
                }
                break;
            case R.id.btn_cancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }

}
