package ddwucom.mobile.finalreport;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MovieDBHelper extends SQLiteOpenHelper {
    final static String TAG = "MovieDBHelper";

    final static String DB_NAME = "movies.db";
    public final static String TABLE_NAME = "movie_table";

    public final static String COL_ID = "_id";
    public final static String COL_TITLE = "movieTitle";
    public final static String COL_DIREC = "director";
    public final static String COL_ACTOR = "mainActor";
    public final static String COL_GENRE = "genre";
    public final static String COL_NATION = "nation";

    public MovieDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, "
                + COL_TITLE + " TEXT, " + COL_DIREC + " TEXT, " + COL_ACTOR + " TEXT, "
                + COL_GENRE + " TEXT, " + COL_NATION + " TEXT)";
        Log.d(TAG, sql);
        db.execSQL(sql);

        db.execSQL("insert into " + TABLE_NAME + " values (null, '가려진 시간', '엄태화', '강동원', '판타지', '한국');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '기생충', '봉준호', '조여정', '드라마', '한국');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '나의 소녀시대', '프랭키 첸', '왕대륙', '로맨스', '대만');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '말레피센트', '로버트 스트롬버그', '안젤리나 졸리', '판타지', '미국');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '부산행', '연상호', '공유', '스릴러', '한국');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '알라딘', '가이 리치', '나오미 스콧', '판타지', '미국');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '어바웃타임', '리차드 커티스', '레이첼 맥아담스', '로맨스', '영국');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '오션스8', '게리 로스', '산드라 블록', '액션', '미국');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '컨저링', '제임스 완', '베라 파미가', '공포', '미국');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '히로인 실격', '하나부사 츠토무', '야마자키 켄토', '로맨스', '일본');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
