package com.example.juicr.usecases

import com.example.juicr.models.Juice
import com.example.juicr.repositories.IJuiceRepository
import javax.inject.Inject

class AddJuiceUsecase @Inject constructor(
    private val juiceRepository: IJuiceRepository
) {
    suspend operator fun invoke(juice: Juice): Long {
        return juiceRepository.addJuice(juice)
    }
}