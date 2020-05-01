
package kuis2;

public class IntiModel {
    private String judul, tipe, status, episode, rating, genre, cari;
    
    public void setIntiModel(String judul, String tipe, String status, String episode, String rating, String genre, String cari){
        this.judul = judul;
        this.tipe = tipe;
        this.status = status;
        this.episode = episode;
        this.rating = rating;
        this.genre = genre;
        this.cari = cari;
    }
    
    public String getJudul(){
        return judul;
    }
    public void setJudul(String judul){
        this.judul = judul;
    }
    public String getTipe(){
        return tipe;
    }
    public void setTipe(String tipe){
        this.tipe = tipe;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getEpisode(){
        return episode;
    }
    public void setEpisode(String episode){
        this.episode = episode;
    }
    public String getRating(){
        return rating;
    }
    public void setRating(String rating){
        this.rating = rating;
    }
    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public String getCari(){
        return cari;
    }
    public void setCari(String cari){
        this.cari = cari;
    }
}
