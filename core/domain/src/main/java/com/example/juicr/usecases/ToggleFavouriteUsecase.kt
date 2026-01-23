package com.example.juicr.usecases

import com.example.juicr.repositories.IJuiceRepository
import javax.inject.Inject

class ToggleFavouriteUsecase @Inject constructor(
    private val juiceRepository: IJuiceRepository
) {
    suspend operator fun invoke(id: Long): Int {
        return juiceRepository.toggleFavourite(id)
    }
}
