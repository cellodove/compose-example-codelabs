package com.cellodove.migrating_compose.sunflower.utilities

import android.content.Context
import androidx.fragment.app.Fragment
import com.cellodove.migrating_compose.sunflower.data.AppDatabase
import com.cellodove.migrating_compose.sunflower.data.GardenPlantingRepository
import com.cellodove.migrating_compose.sunflower.data.PlantRepository
import com.cellodove.migrating_compose.sunflower.viewmodels.GardenPlantingListViewModelFactory
import com.cellodove.migrating_compose.sunflower.viewmodels.PlantDetailViewModelFactory
import com.cellodove.migrating_compose.sunflower.viewmodels.PlantListViewModelFactory

/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 */
object InjectorUtils {

    private fun getPlantRepository(context: Context): PlantRepository {
        return PlantRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).plantDao()
        )
    }

    private fun getGardenPlantingRepository(context: Context): GardenPlantingRepository {
        return GardenPlantingRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).gardenPlantingDao()
        )
    }

    fun provideGardenPlantingListViewModelFactory(
        context: Context
    ): GardenPlantingListViewModelFactory {
        return GardenPlantingListViewModelFactory(getGardenPlantingRepository(context))
    }

    fun providePlantListViewModelFactory(fragment: Fragment): PlantListViewModelFactory {
        return PlantListViewModelFactory(getPlantRepository(fragment.requireContext()), fragment)
    }

    fun providePlantDetailViewModelFactory(
        context: Context,
        plantId: String
    ): PlantDetailViewModelFactory {
        return PlantDetailViewModelFactory(
            getPlantRepository(context),
            getGardenPlantingRepository(context),
            plantId
        )
    }
}
