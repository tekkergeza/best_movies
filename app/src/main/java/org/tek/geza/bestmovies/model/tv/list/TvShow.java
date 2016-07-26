package org.tek.geza.bestmovies.model.tv.list;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class TvShow {

    public static final int ERROR = -1;
    @SerializedName("first_air_date")
    @Expose
    private String firstAirDate;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("original_name")
    @Expose
    private String originalName;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;

    public static TvShow error() {
        TvShow tvShow = new TvShow();
        tvShow.setId(ERROR);
        return tvShow;
    }

    /**
     * @return The firstAirDate
     */
    public String getFirstAirDate() {
        return firstAirDate;
    }

    /**
     * @param firstAirDate The first_air_date
     */
    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The originalName
     */
    public String getOriginalName() {
        return originalName;
    }

    /**
     * @param originalName The original_name
     */
    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    /**
     * @return The overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     * @param overview The overview
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     * @return The posterPath
     */
    public String getPosterPath() {
        return posterPath;
    }

    /**
     * @param posterPath The poster_path
     */
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The voteAverage
     */
    public Double getVoteAverage() {
        return voteAverage;
    }

    /**
     * @param voteAverage The vote_average
     */
    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }
}
