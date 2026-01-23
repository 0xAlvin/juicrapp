package com.example.juicr

import com.example.juicr.dao.IJuiceDao
import com.example.juicr.mappers.toDomain
import com.example.juicr.mappers.toEntity
import com.example.juicr.models.Juice
import com.example.juicr.repositories.IJuiceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class JuiceRepositoryImpl @Inject constructor(
    private val juiceDao: IJuiceDao
): IJuiceRepository{
    override fun getAllJuices(): Flow<List<Juice>> {
        return juiceDao.getAll().map { entities -> entities.map { it.toDomain() } }
    }

    override fun getJuiceById(id: Long): Flow<Juice?> {
        return juiceDao.getById(id).map { entity -> entity?.toDomain() }
    }

    override fun getFavourites(): Flow<List<Juice>> {
        return juiceDao.getFavourites().map { entities -> entities.map {
            it.toDomain()
        } }
    }

    override fun search(text: String): Flow<List<Juice>> {
        return juiceDao.search(text).map { entities -> entities.map {
            it.toDomain()
        } }
    }

    override fun sortByNameDesc(): Flow<List<Juice>> {
        return juiceDao.sortByNameDesc().map { entities -> entities.map {
            it.toDomain()
        } }
    }

    override fun sortByRating(): Flow<List<Juice>> {
        return juiceDao.sortByRating().map { entities -> entities.map {
            it.toDomain()
        } }
    }

    override suspend fun addJuice(juice: Juice): Long {
        return juiceDao.addJuice(juice.toEntity())
    }

    override suspend fun updateJuice(juice: Juice): Int {
        return juiceDao.updateJuice(juice.toEntity())
    }

    override suspend fun deleteJuice(id: Long): Int {
        return juiceDao.deleteJuice(id)
    }

    override suspend fun toggleFavourite(id: Long): Int {
        return juiceDao.toggleFavorite(id)
    }

}