package fr.ubalia.callapis

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreditCard (
    @SerialName("id")
    val id: Long,
    @SerialName("uid")
    val uid: String,
    @SerialName("credit_card_number")
    val creditCardNumber: String,
    @SerialName("credit_card_expiry_date")
    val creditCardExpiryDate: String,
    @SerialName("credit_card_type")
    val creditCardType: String
)