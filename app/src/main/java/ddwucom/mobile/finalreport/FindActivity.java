package ddwucom.mobile.finalreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FindActivity extends AppCompatActivity {

    Movie movie;
    EditText etId;
    MovieDBManager movieDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        etId = findViewById(R.id.etId);

        movieDBManager = new MovieDBManager(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_find:
                long findId = Integer.parseInt(etId.getText().toString());
                movie = movieDBManager.getMovieById(findId);
                if(movieDBManager.getMovieById(findId) == null)
                    Toast.makeText(this, findId + "라는 id를 가진 영화가 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(this, movie.getMovieTitle() + "의 정보 - 감독:" + movie.getDirector() + ", 주연베우:" +
                     movie.getMainActor() + ", 장르:" + movie.getGenre() + ", 국가:" + movie.getNation(), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btn_cancel:
                finish();
                break;
        }
    }
}
