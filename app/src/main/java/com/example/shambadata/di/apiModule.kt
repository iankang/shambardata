package com.example.shambadata.di

import android.content.Context
import com.example.shambadata.models.LiveStockBreedResponse
import com.example.shambadata.models.LiveStockCategoryResponse
import com.example.shambadata.models.LivestockCategory
import com.example.shambadata.models.ShambaDataResponseItem
import com.example.shambadata.utils.Utils
import com.example.shambadataapi.di.provideGlobalShambaDataApiRepository
import org.koin.dsl.module

val apiModule = module {
    single { provideGlobalShambaDataApiRepository() }
    single { provideShambaDataJson(get()) }
    single { provideLiveStockBreedJson(get()) }
    single { provideLivestockCategoryJson(get()) }
}

fun provideShambaDataJson(context: Context):MutableList<ShambaDataResponseItem>{
    return Utils.getShambaDataJsonFromAssets(context, "shamba_data.json")
}

fun provideLiveStockBreedJson(context: Context): LiveStockBreedResponse? {
    return Utils.getLiveStockBreedDataJsonFromAssets(context,"response_livestock_breeds.json")
}

fun provideLivestockCategoryJson(context: Context):LiveStockCategoryResponse{
  return Utils.getLiveStockCategoriesDataJsonFromAssets(context,"response_livestock_categories.json")
}
