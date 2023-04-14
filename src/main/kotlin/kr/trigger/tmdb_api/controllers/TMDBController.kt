package kr.trigger.tmdb_api.controllers

import kr.trigger.tmdb_api.dto.common.RestResponseDTO
import kr.trigger.tmdb_api.dto.tmdb.MovieDetailsDTO
import kr.trigger.tmdb_api.dto.tmdb.TMDBInterface
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import retrofit2.Call
import retrofit2.Response

@RestController
@RequestMapping("/tmdb")
class TMDBController(
    val tmdbInterface: TMDBInterface
) {
    @GetMapping("/discovery/movies/{page}")
    fun getDiscoveryMovies(@PathVariable(value = "page") page: Int): ResponseEntity<Any> {
        return try {
            val call = tmdbInterface.getDiscoverMovie(page = page)
            val response = call.execute()
            ResponseEntity.ok().body(response.body())
        } catch (e: Exception) {
            ResponseEntity.status(500).body(e.message)
        }
    }

    @GetMapping("/discovery/tv/{page}")
    fun getDiscoveryTV(@PathVariable(value = "page") page: Int): ResponseEntity<Any> {
        return try {
            val call = tmdbInterface.getDiscoveryTV(page = page)
            val response = call.execute()
            ResponseEntity.ok().body(response.body())
        } catch (e: Exception) {
            ResponseEntity.status(500).body(e.message)
        }
    }

    @GetMapping("/discovery/movies/details/{id}")
    fun getDiscoveryMoviesDetails(@PathVariable(value = "id") id: Long): ResponseEntity<RestResponseDTO> {
        val call: Call<MovieDetailsDTO> = tmdbInterface.getMovieDetails(id = id)
        return try {
            val response: Response<MovieDetailsDTO> = call.execute()
            val responseStatus: HttpStatus = HttpStatus.valueOf(response.code())
            if (!response.isSuccessful) {
                return ResponseEntity.status(responseStatus).body(RestResponseDTO(message = response.errorBody().toString()))
            }
            if (response.body() == null) {
                return ResponseEntity.ok().body(RestResponseDTO(message = "데이터가 없습니다"))
            }
            ResponseEntity.ok().body(RestResponseDTO(data = response.body()))
        } catch (e: Exception) {
            ResponseEntity.status(500).body(RestResponseDTO(data = e.message))
        }
    }

    @GetMapping("/discovery/tv/details/{id}")
    fun getDiscoveryTVDetails(@PathVariable(value = "id") id: Int): ResponseEntity<Any> {
        return try {
            val call = tmdbInterface.getTVDetails(id = id)
            val response = call.execute()
            ResponseEntity.ok().body(response.body())
        } catch (e: Exception) {
            ResponseEntity.status(500).body(e.message)
        }
    }
}