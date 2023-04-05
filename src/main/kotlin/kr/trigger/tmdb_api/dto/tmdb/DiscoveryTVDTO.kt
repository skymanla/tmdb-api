package kr.trigger.tmdb_api.dto.tmdb

import com.google.gson.annotations.SerializedName

data class DiscoveryTVDTO(
    val page: Int,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int,
    val results: List<DiscoveryTVResultsDTO>
)

data class DiscoveryTVResultsDTO(
    @SerializedName("poster_path") val posterPath: String,
    val popularity: Float,
    val id: Int,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("vote_average") val voteAverage: Float,
    val overview: String,
    @SerializedName("first_air_date") val firstAirDate: String,
    @SerializedName("origin_country") val originCountry: List<String>,
    @SerializedName("genre_ids") val genreIds: List<Int>,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("vote_count") val voteCount: Int,
    val name: String,
    @SerializedName("original_name") val originalName: String
)