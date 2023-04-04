package kr.trigger.tmdb_api.config

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class BearerTokenInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token: String = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0NzFjOTk1ZTQzN2ZjOTMzZGQzMzUwZDM2YTE2MWU0NCIsInN1YiI6IjYzOGU4NTRlNTgwMGM0MDA4MzQ0NjRjYyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.ZUAvKfZwMaK5iOWPxFl4vvHSSK7UJuSc9RULJ92-kds"
        val originRequest: Request = chain.request()
        val newRequest: Request = originRequest.newBuilder()
            .header("Authorization", "Bearer $token")
            .build()
        return chain.proceed(newRequest)
    }
}