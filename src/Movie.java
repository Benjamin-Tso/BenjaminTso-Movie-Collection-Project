
public class Movie {
    String title;
    String[] cast;
    String director;
    String overview;
    int runtime;
    double userRating;
    public Movie(String title, String cast, String director,String overview,int runtime, double userRating){
        this.title = title;
        this.cast = cast.split("\\|");
        insertionStringArrSort(this.cast);
        this.director = director;
        this.overview = overview;
        this.runtime = runtime;
        this.userRating = userRating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getCast() {
        return cast;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public double getUserRating() {
        return userRating;
    }

    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }

    public static void insertionStringArrSort(String[] arr){
        for(int i = 1; i<arr.length; i++){
            String temp = arr[i];
            int count = 1;
            while(i-count>-1 && temp.compareTo(arr[i-count])<0){
                arr[i-count+1]=arr[i-count];
                count++;
            }
            arr[i-count+1] = temp;
        }
    }
}
