package kr.trigger.tmdb_api.config

import kr.trigger.tmdb_api.dto.tmdb.TMDBInterface
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import okhttp3.OkHttpClient
import org.springframework.beans.factory.annotation.Qualifier
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Configuration
class RetrofitConfig {
    @Bean("okhttpClient")
    fun okhttpClient(): OkHttpClient {
        return OkHttpClient()
            .newBuilder().apply {
                connectTimeout(10, TimeUnit.SECONDS)
                writeTimeout(10, TimeUnit.SECONDS)
                readTimeout(10, TimeUnit.SECONDS)
            }
            .build()
    }

    @Bean("tmdbOkhttpClient")
    fun tmdbOkhttpClient(): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .apply {
                connectTimeout(10, TimeUnit.SECONDS)
                writeTimeout(10, TimeUnit.SECONDS)
                readTimeout(10, TimeUnit.SECONDS)
            }
            .addInterceptor(BearerTokenInterceptor())
            .build()
    }

    @Bean("tmdbClient")
    fun tmdbClient(@Qualifier("tmdbOkhttpClient") client: OkHttpClient): Retrofit {
        // api key 471c995e437fc933dd3350d36a161e44
        val baseUrl: String = "https://api.themoviedb.org/3/"
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Bean("tmdbInterface")
    fun tmdbInterface(@Qualifier("tmdbClient") retrofit: Retrofit): TMDBInterface {
        return retrofit.create(TMDBInterface::class.java)
    }
}