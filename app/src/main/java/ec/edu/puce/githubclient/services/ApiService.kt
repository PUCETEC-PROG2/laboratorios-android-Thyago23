package ec.edu.puce.githubclient.services

import ec.edu.puce.githubclient.models.Repository
import ec.edu.puce.githubclient.models.RepositoryPayload
import retrofit2.http.*

interface ApiService {
    @GET(value = "user/repos")
    suspend fun getRepositories (
        @Query(value = "affiliation") affiliation: String = "owner",
        @Query(value = "sort") sort: String = "created",
        @Query(value = "direction") direction: String = "desc",
        @Query(value = "per_page") perPage: Int = 100,
        @Query(value = "t") t: String = "${System.currentTimeMillis()}",
    ): List<Repository>

    @POST(value = "user/repos")
    suspend fun createRepository (
        @Body repository: RepositoryPayload
    ): Repository

    @DELETE(value = "repos/{owner}/{repo}")
    suspend fun deleteRepository(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): retrofit2.Response<Unit>

    @PATCH(value = "repos/{owner}/{repo}")
    suspend fun updateRepository(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Body repository: RepositoryPayload
    ): Repository
}