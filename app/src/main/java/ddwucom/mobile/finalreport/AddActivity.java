package ddwucom.mobile.finalreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    EditText etTitle;
    EditText etDirector;
    EditText etActor;
    EditText etGenre;
    EditText etNation;

    MovieDBManager movieDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etTitle = findViewById(R.id.etTitle);
        etDirector = findViewById(R.id.etDirector);
        etActor = findViewById(R.id.etActor);
        etGenre = findViewById(R.id.etGenre);
        etNation = findViewById(R.id.etGenre);

        movieDBManager = new MovieDBManager(this);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                if(etTitle.getText().toString().equals("") || etDirector.getText().toString().equals("") ||
                    etActor.getText().toString().equals("") || etGenre.getText().toString().equals("") ||
                    etNation.getText().toString().equals("")){
                    Toast.makeText(this, "필수 입력 항목입니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean result = movieDBManager.addNewMovie(
                            new Movie(etTitle.getText().toString(), etDirector.getText().toString(),
                              etActor.getText().toString(), etGenre.getText().toString(), etNation.getText().toString()));
                    if (result) {
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("movie", etTitle.getText().toString() );
                        setResult(RESULT_OK, resultIntent);
                        finish();
                    } else {
                        Toast.makeText(this, "새로운 영화 추가 실패!", Toast.LENGTH_SHORT).show();
                    }
                }

                break;
            case R.id.btn_cancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}
