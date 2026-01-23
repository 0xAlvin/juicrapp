package com.example.juicr.usecases

import com.example.juicr.models.Juice
import com.example.juicr.repositories.IJuiceRepository
import javax.inject.Inject

class UpdateJuiceUsecase @Inject constructor(
    private val juiceRepository: IJuiceRepository
) {
    suspend operator fun invoke(juice: Juice): Int {
        return juiceRepository.updateJuice(juice)
    }
}