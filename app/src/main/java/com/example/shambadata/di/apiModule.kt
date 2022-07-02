package com.example.shambadata.di

import android.content.Context
import com.example.shambadata.data.DataWrangler
import com.example.shambadata.models.*
import com.example.shambadata.utils.Utils
import com.example.shambadataapi.di.provideGlobalShambaDataApiRepository
import org.koin.dsl.module

val apiModule = module {
    single { provideGlobalShambaDataApiRepository() }
    single { provideShambaDataJson(get()) }
    single { provideLiveStockBreedJson(get()) }
    single { provideLivestockCategoryJson(get()) }
    single { provideCountiesJson(get()) }
    single { provideDataWrangler(get(), get(), get(), get()) }
}

fun provideShambaDataJson(context: Context): ShambaDataResponse{
    return Utils.getShambaDataJsonFromAssets(context, "shamba_data.json")
}

fun provideLiveStockBreedJson(context: Context): LiveStockBreedResponse? {
    return Utils.getLiveStockBreedDataJsonFromAssets(context, "response_livestock_breeds.json")
}

fun provideLivestockCategoryJson(context: Context): LiveStockCategoryResponse {
    return Utils.getLiveStockCategoriesDataJsonFromAssets(
        context,
        "response_livestock_categories.json"
    )
}

fun provideCountiesJson(context: Context): CountiesResponse {
    return Utils.getCountiesDataJsonFromAssets(context, "counties.json")
}

fun provideDataWrangler(
    shambaDataResponse: ShambaDataResponse,
    liveStockBreedResponse: LiveStockBreedResponse,
    livestockCategory: LiveStockCategoryResponse,
    countiesResponse: CountiesResponse
): DataWrangler {
    return DataWrangler(
        shambaDataJson = shambaDataResponse,
        liveStockBreedResponse = liveStockBreedResponse,
        livestockCategory = livestockCategory,
        counties = countiesResponse
    )
}