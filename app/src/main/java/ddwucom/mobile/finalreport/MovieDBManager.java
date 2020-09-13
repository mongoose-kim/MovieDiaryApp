package ddwucom.mobile.finalreport;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


public class MovieDBManager {

    MovieDBHelper movieDBHelper = null;
    Cursor cursor = null;

    public MovieDBManager(Context context) {
        movieDBHelper = new MovieDBHelper(context);
    }


    public ArrayList<Movie> getAllMovie() {
        ArrayList movieList = new ArrayList<>();
        SQLiteDatabase db = movieDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + MovieDBHelper.TABLE_NAME, null);

        while(cursor.moveToNext()) {
            long id = cursor.getInt(cursor.getColumnIndex(MovieDBHelper.COL_ID));
            String movieTitle = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_TITLE));
            String director = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_DIREC));
            String mainActor = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_ACTOR));
            String genre = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_GENRE));
            String nation = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_NATION));
            movieList.add ( new Movie (id, movieTitle, director, mainActor, genre, nation) );
        }

        cursor.close();
        movieDBHelper.close();
        return movieList;
    }

    public boolean addNewMovie(Movie newMovie) {
        SQLiteDatabase db = movieDBHelper.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(MovieDBHelper.COL_TITLE, newMovie.getMovieTitle());
        value.put(MovieDBHelper.COL_DIREC, newMovie.getDirector());
        value.put(MovieDBHelper.COL_ACTOR, newMovie.getMainActor());
        value.put(MovieDBHelper.COL_GENRE, newMovie.getGenre());
        value.put(MovieDBHelper.COL_NATION, newMovie.getNation());

        long count = db.insert(MovieDBHelper.TABLE_NAME, null, value);
        movieDBHelper.close();
        if (count > 0) return true;
        return false;
    }

    public boolean modifyMovie(Movie movie) {
        SQLiteDatabase sqLiteDatabase = movieDBHelper.getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put(MovieDBHelper.COL_TITLE, movie.getMovieTitle());
        row.put(MovieDBHelper.COL_DIREC, movie.getDirector());
        row.put(MovieDBHelper.COL_ACTOR, movie.getMainActor());
        row.put(MovieDBHelper.COL_GENRE, movie.getGenre());
        row.put(MovieDBHelper.COL_NATION, movie.getNation());

        String whereClause = MovieDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(movie.get_id()) };
        int result = sqLiteDatabase.update(MovieDBHelper.TABLE_NAME, row, whereClause, whereArgs);
        movieDBHelper.close();
        if (result > 0) return true;
        return false;
    }

    public boolean removeMovie(long id) {
        SQLiteDatabase db = movieDBHelper.getWritableDatabase();
        String whereClause = MovieDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(id) };
        int result = db.delete(MovieDBHelper.TABLE_NAME, whereClause,whereArgs);
        movieDBHelper.close();
        if (result > 0) return true;
        return false;
    }

    //    id 로 DB 검색
    public Movie getMovieById(long findId) {
        Movie findMovie = null;
        SQLiteDatabase db = movieDBHelper.getReadableDatabase();
        String whereClause = MovieDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(findId) };
        Cursor cursor = db.query(MovieDBHelper.TABLE_NAME, null, whereClause, whereArgs,
                null, null, null, null);

        while(cursor.moveToNext()) {
            long id = cursor.getInt(cursor.getColumnIndex(MovieDBHelper.COL_ID));
            String movieTitle = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_TITLE));
            String director = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_DIREC));
            String mainActor = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_ACTOR));
            String genre = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_GENRE));
            String nation = cursor.getString(cursor.getColumnIndex(MovieDBHelper.COL_NATION));
            findMovie = new Movie(id, movieTitle, director, mainActor, genre, nation);
        }

        cursor.close();
        movieDBHelper.close();
        return findMovie;
    }

//        close 수행
    public void close() {
        if (movieDBHelper != null) movieDBHelper.close();
        if (cursor != null) cursor.close();
    };
}
