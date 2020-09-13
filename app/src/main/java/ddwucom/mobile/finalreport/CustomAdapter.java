package ddwucom.mobile.finalreport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Movie> movieList;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, int layout, ArrayList<Movie> movieList){
        this.context = context;
        this.layout = layout;
        this.movieList = movieList;

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int i) {
        return movieList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return movieList.get(i).get_id();
    }


    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        final int pos = i;
        ViewHolder viewHolder;

        if(convertView == null){
            convertView = inflater.inflate(layout, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.img = convertView.findViewById(R.id.imageView1);
            viewHolder.id = convertView.findViewById(R.id.text_id);
            viewHolder.movieTitle = convertView.findViewById(R.id.text_title);
            viewHolder.director = convertView.findViewById(R.id.text_director);
            viewHolder.genre = convertView.findViewById(R.id.text_genre);

            convertView.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if(movieList.get(0).equals(movieList.get(pos)))
            viewHolder.img.setImageResource(R.mipmap.vanashingtime);
        else if(movieList.get(1).equals(movieList.get(pos)))
            viewHolder.img.setImageResource(R.mipmap.parasite);
        else if(movieList.get(2).equals(movieList.get(pos)))
            viewHolder.img.setImageResource(R.mipmap.my);
        else if(movieList.get(3).equals(movieList.get(pos)))
            viewHolder.img.setImageResource(R.mipmap.maleficent);
        else if(movieList.get(4).equals(movieList.get(pos)))
            viewHolder.img.setImageResource(R.mipmap.busan);
        else if(movieList.get(5).equals(movieList.get(pos)))
            viewHolder.img.setImageResource(R.mipmap.aladdin);
        else if(movieList.get(6).equals(movieList.get(pos)))
            viewHolder.img.setImageResource(R.mipmap.abouttime);
        else if(movieList.get(7).equals(movieList.get(pos)))
            viewHolder.img.setImageResource(R.mipmap.oceans8);
        else if(movieList.get(8).equals(movieList.get(pos)))
            viewHolder.img.setImageResource(R.mipmap.theconjuring);
        else if(movieList.get(9).equals(movieList.get(pos)))
            viewHolder.img.setImageResource(R.mipmap.hero);
        else
            viewHolder.img.setImageResource(R.mipmap.newmovie);

        viewHolder.id.setText(String.valueOf(movieList.get(i).get_id()));
        viewHolder.movieTitle.setText(movieList.get(i).getMovieTitle());
        viewHolder.director.setText(movieList.get(i).getDirector());
        viewHolder.genre.setText(movieList.get(i).getGenre());

        return convertView;
    }
    static class ViewHolder{
        ImageView img;
        TextView id;
        TextView movieTitle;
        TextView director;
        TextView genre;
    }
}
