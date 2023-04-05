package kr.trigger.tmdb_api.dto.tmdb

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBInterface {
    @GET("discover/movie")
    fun getDiscoverMovie(
        @Query("page") page: Int,
        @Query("language") language: String = "ko-KR",
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("include_adult") includeAdult: Boolean = true,
        @Query("include_video") includeVideo: Boolean = false,
        @Query("with_watch_monetization_types") withWatchMonetizationTypes: String = "flatrate"
    ): Call<DiscoveryMovieDTO>

    @GET("discover/tv")
    fun getDiscoveryTV(
        @Query("page") page: Int,
        @Query("language") language: String = "ko-KR",
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("timezone") timezone: String = "Asia/Seoul",
        @Query("include_null_first_air_dates") includeNullFirstAirDates: Boolean = false,
        @Query("with_watch_monetization_types") withWatchMonetizationTypes: String = "flatrate",
        @Query("with_status") withStatus: String = "0",
        @Query("with_type") withType: String = "0"
    ): Call<DiscoveryTVDTO>

    @GET("movie/{id}")
    fun getMovieDetails(
        @Path("id") id: Int,
        @Query("language") language: String = "ko-KR"
    ): Call<MovieDetailsDTO>

    @GET( "tv/{id}")
    fun getTVDetails(
        @Path("id") id: Int,
        @Query("language") language: String = "ko-KR"
    ): Call<TVDetailsDTO>
}