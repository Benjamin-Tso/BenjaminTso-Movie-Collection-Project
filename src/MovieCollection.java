public class MovieCollection {
    Movie[] movies;
    public MovieCollection(String[] movies){
        this.movies = new Movie[movies.length];
        for(int i = 0; i<movies.length;i++){
            //0title,1cast,2director,3overview,4runtime,5userRating
            String[] movieInfo = movies[i].split(",");
            this.movies[i] = new Movie(movieInfo[0],movieInfo[1],movieInfo[2],movieInfo[3],Integer.parseInt(movieInfo[4]),Double.parseDouble(movieInfo[5]));
        }
    }
    public Movie[] searchTitles(String keyWord){
        Movie[] out;
        int matches = 0;
        String indices = "";
        for(int i = 0 ; i<movies.length;i++){
            if(movies[i].getTitle().contains(keyWord)){
                matches++;
                indices+=i+" ";
            }
        }
        out = new Movie[matches];
        for(String s : indices.split(" ")){
            out[out.length-matches] = movies[Integer.parseInt(s)];
            matches--;
        }
        return out;
    }
    public Movie[] searchCast(String keyWord){
        Movie[] out;
        int matches = 0;
        String indices = "";
        for(int i =0 ; i<movies.length;i++){
            for(String name : movies[i].getCast()){
                if
            }
        }
        return out;
    }
    public String movieInfo(Movie[] options, int choice){
        String out = "";

        return out;
    }
}
