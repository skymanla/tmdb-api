package kr.trigger.tmdb_api.dto.tmdb

import retrofit2.Call
import retrofit2.http.GET
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
}