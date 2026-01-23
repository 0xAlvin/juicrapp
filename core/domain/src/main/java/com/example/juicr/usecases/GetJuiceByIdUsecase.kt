package com.example.juicr.usecases

import com.example.juicr.models.Juice
import com.example.juicr.repositories.IJuiceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetJuiceByIdUsecase @Inject constructor(
    private val juiceRepository: IJuiceRepository
) {
    operator fun invoke(id: Long): Flow<Juice?> {
        return juiceRepository.getJuiceById(id)
    }
}