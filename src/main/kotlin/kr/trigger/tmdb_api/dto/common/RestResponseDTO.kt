package kr.trigger.tmdb_api.dto.common

data class RestResponseDTO(
    val success: Boolean = true,
    val message: String = "",
    val data: Any? = null,
    val code: Int? = 0
)