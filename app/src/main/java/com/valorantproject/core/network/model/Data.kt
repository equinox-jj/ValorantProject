package com.valorantproject.core.network.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("abilities") val abilities: List<Ability?> = listOf(),
    @SerializedName("assetPath") val assetPath: String? = "",
    @SerializedName("background") val background: String? = "",
    @SerializedName("backgroundGradientColors") val backgroundGradientColors: List<String?> = listOf(),
    @SerializedName("bustPortrait") val bustPortrait: String? = "",
    @SerializedName("characterTags") val characterTags: List<String?> = listOf(),
    @SerializedName("description") val description: String? = "",
    @SerializedName("developerName") val developerName: String? = "",
    @SerializedName("displayIcon") val displayIcon: String? = "",
    @SerializedName("displayIconSmall") val displayIconSmall: String? = "",
    @SerializedName("displayName") val displayName: String? = "",
    @SerializedName("fullPortrait") val fullPortrait: String? = "",
    @SerializedName("fullPortraitV2") val fullPortraitV2: String? = "",
    @SerializedName("isAvailableForTest") val isAvailableForTest: Boolean? = false,
    @SerializedName("isBaseContent") val isBaseContent: Boolean? = false,
    @SerializedName("isFullPortraitRightFacing") val isFullPortraitRightFacing: Boolean? = false,
    @SerializedName("isPlayableCharacter") val isPlayableCharacter: Boolean? = false,
    @SerializedName("killfeedPortrait") val killfeedPortrait: String? = "",
    @SerializedName("recruitmentData") val recruitmentData: RecruitmentData? = RecruitmentData(),
    @SerializedName("role") val role: Role? = Role(),
    @SerializedName("uuid") val uuid: String? = "",
    @SerializedName("voiceLine") val voiceLine: Any? = Any()
)