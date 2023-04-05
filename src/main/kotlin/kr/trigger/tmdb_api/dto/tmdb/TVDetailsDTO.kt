package kr.trigger.tmdb_api.dto.tmdb

import com.google.gson.annotations.SerializedName

data class TVDetailsDTO(
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("created_by") val createdBy: List<CreatedByTV>,
    @SerializedName("episode_run_time") val episodeRunTime: List<Int>,
    @SerializedName("first_air_date") val firstAirDate: String,
    @SerializedName("genres") val genres: List<GenresTV>,
    val homepage: String,
    val id: Int,
    @SerializedName("in_production") val inProduction: Boolean,
    val languages: List<String>,
    @SerializedName("last_air_date") val lastAirDate: String,
    @SerializedName("last_episode_to_air") val lastEpisodeToAir: LastEpisodeToAirTV,
    val name: String,
    @SerializedName("next_episode_to_air") val nextEpisodeToAir: Any,
    val networks: List<NetworkTV>,
    @SerializedName("number_of_episodes") val numberOfEpisodes: Int,
    @SerializedName("number_of_seasons") val numberOfSeasons: Int,
    @SerializedName("origin_country") val originCountry: List<String>,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("original_name") val originalName: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("production_companies") val productionCompanies: List<ProductionCompaniesTV>,
    @SerializedName("production_countries") val productionCountries: List<ProductionCountriesTV>,
    val seasons: List<SeasonsTV>,
    @SerializedName("spoken_languages") val spokenLanguages: List<SpokenLanguagesTV>,
    val status: String,
    val tagline: String,
    val type: String,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: Int
)

data class CreatedByTV(
    val id: Int,
    @SerializedName("created_by") val createdBy: String,
    val name: String,
    val gender: Int,
    @SerializedName("profile_path") val profilePath: String?,
)

data class GenresTV(
    val id: Int,
    val name: String
)

data class LastEpisodeToAirTV(
    @SerializedName("air_date") val airDate: String,
    @SerializedName("episode_number") val episodeNumber: Int,
    val id: Int,
    val name: String,
    val overview: String,
    @SerializedName("production_code") val productionCode: String,
    @SerializedName("season_number") val seasonNumber: Int,
    @SerializedName("still_path") val stillPath: String?,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: String
)

data class NetworkTV(
    val name: String,
    val id: Int,
    @SerializedName("logo_path") val logoPath: String?,
    @SerializedName("origin_country") val originCountry: String
)

data class ProductionCompaniesTV(
    val id: Int,
    @SerializedName("logo_path") val logoPath: String?,
    val name: String,
    @SerializedName("origin_country") val originCountry: String
)

data class ProductionCountriesTV(
    @SerializedName("iso_3166_1") val iso31661: String,
    val name: String
)

data class SeasonsTV(
    @SerializedName("air_date") val airDate: String,
    @SerializedName("episode_count") val episodeCount: Int,
    val id: Int,
    val name: String,
    val overview: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("season_number") val seasonNumber: Int
)

data class SpokenLanguagesTV(
    @SerializedName("english_name") val englishName: String,
    @SerializedName("iso_639_1") val iso6391: String,
    val name: String
)