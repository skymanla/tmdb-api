package kr.trigger.tmdb_api.dto.tmdb

class CommonDTO(
    val page: Int,
    val totalPages: Int,
    val totalResults: Int,
    val results: Any
)