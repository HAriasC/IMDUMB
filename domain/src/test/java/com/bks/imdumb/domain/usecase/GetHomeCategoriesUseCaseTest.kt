package com.bks.imdumb.domain.usecase

import com.bks.imdumb.domain.model.Movie
import com.bks.imdumb.domain.repository.MovieRepository
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class GetHomeCategoriesUseCaseTest {

    private val repository: MovieRepository = mockk()
    private lateinit var useCase: GetHomeCategoriesUseCase

    @Before
    fun setup() {
        useCase = GetHomeCategoriesUseCase(repository)
    }

    @Test
    fun `deberia retornar categorias combinadas cuando todas las llamadas son exitosas`() {
        // Escenario (Given)
        val movie = Movie(
            id = 1, 
            title = "Test", 
            overview = "Overview", 
            posterUrl = "", 
            backdropUrl = "", 
            rating = 8.0,
            isAdult = false,
            genres = emptyList()
        )
        val movies = listOf(movie)
        
        every { repository.getPopularMovies() } returns Single.just(movies)
        every { repository.getTopRatedMovies() } returns Single.just(movies)
        every { repository.getUpcomingMovies() } returns Single.just(movies)

        // Acción (When)
        val testObserver = useCase.execute().test()

        // Resultado (Then)
        testObserver.assertNoErrors()
        testObserver.assertValue { categories ->
            categories.size == 3 &&
            categories[0].name == "Populares" &&
            categories[1].name == "Mejor Valoradas" &&
            categories[2].name == "Próximamente"
        }
    }

    @Test
    fun `deberia retornar error cuando el repositorio falla`() {
        // Escenario (Given)
        val error = RuntimeException("API Error")
        every { repository.getPopularMovies() } returns Single.error(error)
        every { repository.getTopRatedMovies() } returns Single.just(emptyList())
        every { repository.getUpcomingMovies() } returns Single.just(emptyList())

        // Acción (When)
        val testObserver = useCase.execute().test()

        // Resultado (Then)
        testObserver.assertError(error)
    }
}
