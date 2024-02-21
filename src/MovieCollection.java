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
        keyWord = keyWord.toLowerCase();
        Movie[] out;
        int matches = 0;
        String indices = "";
        for(int i = 0 ; i<movies.length;i++){
            if(movies[i].getTitle().toLowerCase().contains(keyWord)){
                matches++;
                indices+=i+" ";
            }
        }
        out = new Movie[matches];
        String[] indices0 = indices.split(" ");
        for(int i = 0; i<matches;i++){
            out[i] = movies[Integer.parseInt(indices0[i])];
        }
        return out;
    }
    public String[] searchCast(String keyWord){
        keyWord = keyWord.toLowerCase();
        String[] out;
        String names = "";
        for(int i =0 ; i<movies.length;i++){
            for(String n : movies[i].getCast()){
                String name = n.toLowerCase();
                if(!names.contains(n.replaceAll(" ",",")+"|")&&name.contains(keyWord)){
                    names+=n.replaceAll(" ",",")+"|";
                }
            }
        }
        if(names.length()==0){
            return null;
        }
        out = names.trim().split("\\|");
        Movie.insertionStringArrSort(out);
        return out;
    }
    public Movie[] actorMovies(String name){
        Movie[] out;
        int matches = 0;
        String indices = "";
        for(int i =0; i<movies.length;i++){
            for(String actor : movies[i].getCast()){
                if(actor.equals(name)){
                    indices+=i+" ";
                    matches++;
                    break;
                }
            }
        }
        out = new Movie[matches];
        String[] indices0 = indices.trim().split(" ");
        for(int i = 0; i<matches;i++){
            out[i] = movies[Integer.parseInt(indices0[i])];
        }
        return out;
    }
}
