package com.mertozan.androbuddyproject.common

import com.mertozan.androbuddyproject.data.dto.ValorantCharacter
import com.mertozan.androbuddyproject.data.model.ValorantModel

fun List<ValorantCharacter>.toValorantModelList() : List<ValorantModel> {
    return mapList { it.toValorantModel() }
}

fun ValorantCharacter.toValorantModel() : ValorantModel {
    return ValorantModel(
        id = uuid,
        name = displayName.orEmpty(),
        description = description.orEmpty(),
        developerName = developerName.orEmpty(),
        displayIcon = displayIcon.orEmpty(),
        fullPortraitImage = fullPortrait.orEmpty()
    )
}

fun <T, R> List<T>.mapList(mapper: (T) -> R): List<R> {
    return map(mapper)
}