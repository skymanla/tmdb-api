package kr.trigger.tmdb_api.config

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.springframework.beans.factory.annotation.Value

class BearerTokenInterceptor(
    private var tmdbApiKey: String
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token: String = tmdbApiKey
        val originRequest: Request = chain.request()
        val newRequest: Request = originRequest.newBuilder()
            .header("Authorization", "Bearer $token")
            .build()
        return chain.proceed(newRequest)
    }
}