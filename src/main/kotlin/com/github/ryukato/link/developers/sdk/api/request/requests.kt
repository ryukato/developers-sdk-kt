package com.github.ryukato.link.developers.sdk.api.request

import com.fasterxml.jackson.annotation.JsonInclude


@JsonInclude(JsonInclude.Include.NON_NULL)
data class IssueServiceTokenRequest(
    val serviceWalletAddress: String,
    val serviceWalletSecret: String,
    val name: String,
    val symbol: String,
    val initialSupply: String,
    val recipientWalletAddress: String,
    val imgUri: String
) {
    init {
        require(serviceWalletSecret.isNotBlank()) { "Invalid request parameter: serviceWalletSecret can not be blank" }

        require(WALLET_ADDRESS_REGEX.matches(recipientWalletAddress)) {
            "Invalid recipient wallet address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}"
        }

        require(WALLET_ADDRESS_REGEX.matches(serviceWalletAddress)) {
            "Invalid service wallet address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}"
        }

        require(WALLET_ADDRESS_REGEX.matches(recipientWalletAddress)) {
            "Invalid recipient wallet address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}"
        }

        require((name.length in NAME_LENGTH_RANGE) || (name.isAlphanumeric())) {
            getInvalidServiceTokenNameMessage(name)
        }

        require((symbol.length in SYMBOL_LENGTH_RANGE) || (symbol.isAlphanumeric())) {
            getInvalidServiceTokenSymbolMessage(name)
        }

        require(BASE_URI_OR_EMPTY_REGEX.matches(imgUri)) {
            "Invalid base img uri - invalid pattern against ${BASE_URI_OR_EMPTY_REGEX.pattern}"
        }

        require(SERVICE_TOKEN_SYMBOL_REGEX.matches(symbol)) {
            "Invalid symbol - invalid pattern against ${SERVICE_TOKEN_SYMBOL_REGEX.pattern}"
        }

        require(PATTERN_NUMERIC_VALUE_REGEX.matches(initialSupply)) {
            "Invalid initialSupply- invalid pattern against ${PATTERN_NUMERIC_VALUE_REGEX.pattern}"
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class UpdateServiceTokenRequest(
    val ownerAddress: String,
    val ownerSecret: String,
    val name: String?,
    val meta: String? = null
) {
    init {
        require(ownerSecret.isNotBlank()) { "Invalid request parameter: ownerSecret can not be blank" }

        require(WALLET_ADDRESS_REGEX.matches(ownerAddress)) {
            "Invalid owner address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}"
        }

        if (name != null && (name.length !in NAME_LENGTH_RANGE || !name.isAlphanumeric())) {
            throw IllegalArgumentException(getInvalidServiceTokenNameMessage(name))
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class BurnFromServiceTokenRequest(
    val ownerAddress: String,
    val ownerSecret: String,
    val fromAddress: String? = null,
    val fromUserId: String? = null,
    val amount: String
) : AbstractBurnTransactionRequest(fromUserId, fromAddress) {
    init {
        require(ownerSecret.isNotBlank()) { "Invalid request parameter: ownerSecret can not be blank" }

        require(WALLET_ADDRESS_REGEX.matches(ownerAddress)) {
            "Invalid owner address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}"
        }

        require(PATTERN_NUMERIC_VALUE_REGEX.matches(amount)) {
            "Invalid amount - invalid pattern against ${PATTERN_NUMERIC_VALUE_REGEX.pattern}"
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class MintServiceTokenRequest(
    val ownerAddress: String,
    val ownerSecret: String,
    val toAddress: String? = null,
    val toUserId: String? = null,
    val amount: String
) : AbstractTransactionRequest(toAddress, toUserId) {
    init {
        require(ownerSecret.isNotBlank()) { "Invalid request parameter: ownerSecret can not be blank" }

        require(WALLET_ADDRESS_REGEX.matches(ownerAddress)) {
            "Invalid owner address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}"
        }

        require(PATTERN_NUMERIC_VALUE_REGEX.matches(amount)) {
            "Invalid amount - invalid pattern against ${PATTERN_NUMERIC_VALUE_REGEX.pattern}"
        }
    }
}

data class MemoRequest(
    val memo: String,
    val walletAddress: String,
    val walletSecret: String
) {
    init {
        require(walletSecret.isNotBlank()) { "Invalid request parameter: walletSecret can not be blank" }

        require(WALLET_ADDRESS_REGEX.matches(walletAddress)) {
            "Invalid wallet address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}"
        }
        require((memo.length in MEMO_LENGTH_RANGE)) {
            "Invalid memo - out of range $MEMO_LENGTH_RANGE"
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class TransferBaseCoinRequest(
    val walletSecret: String,
    val toAddress: String? = null,
    val toUserId: String? = null,
    val amount: String
) : AbstractTransactionRequest(toAddress, toUserId) {
    init {
        require(walletSecret.isNotBlank()) { "Invalid request parameter: walletSecret can not be blank" }

        require(PATTERN_NUMERIC_VALUE_REGEX.matches(amount)) {
            "Invalid amount - invalid pattern against ${PATTERN_NUMERIC_VALUE_REGEX.pattern}"
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class TransferServiceTokenRequest(
    val walletSecret: String,
    val toAddress: String? = null,
    val toUserId: String? = null,
    val amount: String
) : AbstractTransactionRequest(toAddress, toUserId) {
    init {
        require(walletSecret.isNotBlank()) { "Invalid request parameter: walletSecret can not be blank" }

        require(PATTERN_NUMERIC_VALUE_REGEX.matches(amount)) {
            "Invalid amount - invalid pattern against ${PATTERN_NUMERIC_VALUE_REGEX.pattern}"
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class TransferFungibleTokenRequest(
    val walletSecret: String,
    val toAddress: String? = null,
    val toUserId: String? = null,
    val amount: String
) : AbstractTransactionRequest(toAddress, toUserId) {
    init {
        require(walletSecret.isNotBlank()) { "Invalid request parameter: walletSecret can not be blank" }

        require(PATTERN_NUMERIC_VALUE_REGEX.matches(amount)) {
            "Invalid amount - invalid pattern against ${PATTERN_NUMERIC_VALUE_REGEX.pattern}"
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class TransferTokenOfUserRequest(
    val ownerAddress: String,
    val ownerSecret: String,
    val toAddress: String? = null,
    val toUserId: String? = null,
    val amount: String
) : AbstractTransactionRequest(toAddress, toUserId) {
    init {
        require(ownerSecret.isNotBlank()) { "Invalid request parameter: ownerSecret can not be blank" }

        require(WALLET_ADDRESS_REGEX.matches(ownerAddress)) {
            "Invalid owner address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}"
        }

        require(PATTERN_NUMERIC_VALUE_REGEX.matches(amount)) {
            "Invalid amount - invalid pattern against ${PATTERN_NUMERIC_VALUE_REGEX.pattern}"
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class TransferNonFungibleRequest(
    val walletSecret: String,
    val toAddress: String? = null,
    val toUserId: String? = null
) : AbstractTransactionRequest(toAddress, toUserId) {
    init {
        require(walletSecret.isNotBlank()) { "Invalid request parameter: walletSecret can not be blank" }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class TransferNonFungibleOfUserRequest(
    val ownerAddress: String,
    val ownerSecret: String,
    val toAddress: String? = null,
    val toUserId: String? = null
) : AbstractTransactionRequest(toAddress, toUserId) {
    init {
        require(ownerSecret.isNotBlank()) { "Invalid request parameter: ownerSecret can not be blank" }

        require(WALLET_ADDRESS_REGEX.matches(ownerAddress)) {
            "Invalid owner address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}"
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class BatchTransferNonFungibleRequest(
    val walletSecret: String,
    val toAddress: String? = null,
    val toUserId: String? = null,
    val transferList: Collection<TokenId>
) : AbstractTransactionRequest(toAddress, toUserId) {
    init {
        require(walletSecret.isNotBlank()) { "Invalid request parameter: walletSecret can not be blank" }

        require(transferList.isNotEmpty()) {
            "Invalid transfer list - empty transfer list"
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class BatchTransferNonFungibleOfUserRequest(
    val ownerAddress: String,
    val ownerSecret: String,
    val toAddress: String? = null,
    val toUserId: String? = null,
    val transferList: Collection<TokenId>
) : AbstractTransactionRequest(toAddress, toUserId) {
    init {
        require(ownerSecret.isNotBlank()) { "Invalid request parameter: ownerSecret can not be blank" }

        require(WALLET_ADDRESS_REGEX.matches(ownerAddress)) {
            "Invalid owner address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}"
        }

        require(transferList.isNotEmpty()) {
            "Invalid transfer list - empty transfer list"
        }
    }
}

data class TokenId(val tokenId: String) {
    private val tokenIdFormat = "\\d{8}\\d{8}".toRegex()
    private val tokenIdLength = 16

    init {

        require(tokenId.length == tokenIdLength) { "Invalid tokenId: length of token-id has to be 16" }
        require(tokenIdFormat.matches(tokenId)) { "Invalid tokenId: invalid format of tokenId, valid format is $tokenIdFormat" }
    }

    companion object {
        @Suppress("unused")
        fun fromMulti(identifiers: Set<String>): Collection<TokenId> {
            return identifiers.map {
                TokenId(it)
            }
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class FungibleTokenCreateUpdateRequest(
    val ownerAddress: String,
    val ownerSecret: String,
    val name: String,
    val meta: String? = null
) {
    init {
        require(ownerSecret.isNotBlank()) { "Invalid request parameter: ownerSecret can not be blank" }

        require(WALLET_ADDRESS_REGEX.matches(ownerAddress)) {
            "Invalid owner address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}"
        }

        require(name.length in NAME_LENGTH_RANGE || name.isAlphanumeric()) {
            getInvalidItemTokenNameMessage(name)
        }

        if (meta != null && meta.length !in META_LENGTH_RANGE) {
            throw IllegalArgumentException("Invalid fungible token meta - out of range: $META_LENGTH_RANGE")
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class FungibleTokenMintRequest(
    val ownerAddress: String,
    val ownerSecret: String,
    val toAddress: String? = null,
    val toUserId: String? = null,
    val amount: String
) : AbstractTransactionRequest(toAddress, toUserId) {
    init {
        require(ownerSecret.isNotBlank()) { "Invalid request parameter: ownerSecret can not be blank" }

        require(WALLET_ADDRESS_REGEX.matches(ownerAddress)) {
            "Invalid owner address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}"
        }

        require(PATTERN_NUMERIC_VALUE_REGEX.matches(amount)) {
            "Invalid amount - invalid pattern against ${PATTERN_NUMERIC_VALUE_REGEX.pattern}"
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class FungibleTokenBurnRequest(
    val ownerAddress: String,
    val ownerSecret: String,
    val fromUserId: String? = null,
    val fromAddress: String? = null,
    val amount: String
) : AbstractBurnTransactionRequest(fromUserId, fromAddress) {
    init {
        require(ownerSecret.isNotBlank()) { "Invalid request parameter: ownerSecret can not be blank" }

        require(WALLET_ADDRESS_REGEX.matches(ownerAddress)) {
            "Invalid owner address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}"
        }

        require(PATTERN_NUMERIC_VALUE_REGEX.matches(amount)) {
            "Invalid amount - invalid pattern against ${PATTERN_NUMERIC_VALUE_REGEX.pattern}"
        }
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class NonFungibleTokenCreateUpdateRequest(
    val ownerAddress: String,
    val ownerSecret: String,
    val name: String,
    val meta: String? = null
) {
    init {
        require(ownerSecret.isNotBlank()) { "Invalid request parameter: ownerSecret can not be blank" }

        require(WALLET_ADDRESS_REGEX.matches(ownerAddress)) {
            "Invalid owner address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}"
        }

        require(name.length in NAME_LENGTH_RANGE || name.isAlphanumeric()) {
            getInvalidItemTokenNameMessage(name)
        }

        if (meta != null && meta.length !in META_LENGTH_RANGE) {
            throw IllegalArgumentException("Invalid non-fungible token meta - out of range: $META_LENGTH_RANGE")
        }
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class NonFungibleTokenMintRequest(
    val ownerAddress: String,
    val ownerSecret: String,
    val toAddress: String? = null,
    val toUserId: String? = null,
    val name: String,
    val meta: String? = null
) : AbstractTransactionRequest(toAddress, toUserId) {
    init {
        require(ownerSecret.isNotBlank()) { "Invalid request parameter: ownerSecret can not be blank" }

        require(WALLET_ADDRESS_REGEX.matches(ownerAddress)) {
            "Invalid owner address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}"
        }

        require(name.length in NAME_LENGTH_RANGE || name.isAlphanumeric()) {
            getInvalidItemTokenNameMessage(name)
        }

        if (meta != null && meta.length !in META_LENGTH_RANGE) {
            throw IllegalArgumentException("Invalid non-fungible token meta - out of range: $META_LENGTH_RANGE")
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class NonFungibleTokenMultiMintRequest(
    val ownerAddress: String,
    val ownerSecret: String,
    val toAddress: String? = null,
    val toUserId: String? = null,
    val mintList: Collection<MultiMintNonFungible>
) : AbstractTransactionRequest(toAddress, toUserId) {
    init {
        require(ownerSecret.isNotBlank()) { "Invalid request parameter: ownerSecret can not be blank" }

        require(WALLET_ADDRESS_REGEX.matches(ownerAddress)) {
            "Invalid owner address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}"
        }

        require(mintList.isNotEmpty()) {
            "Invalid mint list - empty list"
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class MultiMintNonFungible(
    val tokenType: String,
    val name: String,
    val meta: String? = null
) {
    init {
        require(TOKEN_TYPE_REGEX.matches(tokenType)) {
            "Invalid token-type - invalid pattern against: ${TOKEN_TYPE_REGEX.pattern}"
        }
        require(name.length in NAME_LENGTH_RANGE || name.isAlphanumeric()) {
            getInvalidItemTokenNameMessage(name)
        }

        if (meta != null && meta.length !in META_LENGTH_RANGE) {
            throw IllegalArgumentException("Invalid non-fungible token meta - out of range: $META_LENGTH_RANGE")
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class NonFungibleTokenBurnRequest(
    val ownerAddress: String,
    val ownerSecret: String,
    val fromAddress: String? = null,
    val fromUserId: String? = null
) : AbstractBurnTransactionRequest(fromUserId, fromAddress) {
    init {
        require(ownerSecret.isNotBlank()) { "Invalid request parameter: ownerSecret can not be blank" }

        require(WALLET_ADDRESS_REGEX.matches(ownerAddress)) {
            "Invalid owner address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}"
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class NonFungibleTokenItemTokenAttachRequest(
    val parentTokenId: String,
    val serviceWalletAddress: String,
    val serviceWalletSecret: String,
    val tokenHolderAddress: String? = null,
    val tokenHolderUserId: String? = null
) {
    init {
        require(serviceWalletSecret.isNotBlank()) { "Invalid request parameter: ownerSecret can not be blank" }

        require(WALLET_ADDRESS_REGEX.matches(serviceWalletAddress)) {
            "Invalid service wallet address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}"
        }

        require(tokenHolderAddress != null || tokenHolderUserId != null) {
            "tokenHolderAddress or tokenHolderUserId, one of them is required"
        }

        if (tokenHolderAddress != null && !WALLET_ADDRESS_REGEX.matches(tokenHolderAddress)) {
            throw IllegalArgumentException("Invalid token holder address - invalid pattern against: ${WALLET_ADDRESS_REGEX.pattern}")
        }

        if (tokenHolderUserId != null && tokenHolderUserId.isBlank()) {
            throw IllegalArgumentException("Invalid token holder user id - can not be blank")
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class NonFungibleTokenItemTokenDetachRequest(
    val serviceWalletAddress: String,
    val serviceWalletSecret: String,
    val tokenHolderAddress: String? = null,
    val tokenHolderUserId: String? = null
) {
    init {
        require(serviceWalletSecret.isNotBlank()) { "Invalid request parameter: ownerSecret can not be blank" }

        require(WALLET_ADDRESS_REGEX.matches(serviceWalletAddress)) {
            "Invalid service wallet address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}"
        }

        require(tokenHolderAddress != null || tokenHolderUserId != null) {
            "tokenHolderAddress or tokenHolderUserId, one of them is required"
        }

        if (tokenHolderAddress != null && !WALLET_ADDRESS_REGEX.matches(tokenHolderAddress)) {
            throw IllegalArgumentException("Invalid token holder address - invalid pattern against: ${WALLET_ADDRESS_REGEX.pattern}")
        }

        if (tokenHolderUserId != null && tokenHolderUserId.isBlank()) {
            throw IllegalArgumentException("Invalid token holder user id - can not be blank")
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class UserServiceTokenTransferRequest(
    val toAddress: String? = null,
    val toUserId: String? = null,
    val amount: String,
    val landingUri: String?
) : AbstractTransactionRequest(toAddress, toUserId) {
    init {
        require(PATTERN_NUMERIC_VALUE_REGEX.matches(amount)) {
            "Invalid amount - invalid pattern against ${PATTERN_NUMERIC_VALUE_REGEX.pattern}"
        }

        if (landingUri != null && landingUri.isBlank()) {
            throw IllegalArgumentException("Invalid landing uri - blank value is not allowed")
        }
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class UserAssetProxyRequest(
    val ownerAddress: String,
    val landingUri: String?
) {
    init {
        require(WALLET_ADDRESS_REGEX.matches(ownerAddress)) {
            "Invalid owner address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}"
        }

        if (landingUri != null && landingUri.isBlank()) {
            throw IllegalArgumentException("Invalid landing uri - blank value is not allowed")
        }
    }
}

abstract class AbstractBurnTransactionRequest(
    fromUserId: String?,
    fromAddress: String?
) {
    init {
        require(fromAddress != null || fromUserId != null) { "fromAddress or fromUserId, one of them is required" }

        if (fromAddress != null && !WALLET_ADDRESS_REGEX.matches(fromAddress)) {
            throw IllegalArgumentException("Invalid fromAddress wallet address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}")
        }

        if (fromUserId != null && fromUserId.isBlank()) {
            throw IllegalArgumentException("Invalid fromUserId - fromUserId can not be blank")
        }
    }
}

abstract class AbstractTransactionRequest(
    toAddress: String?,
    toUserId: String?
) {
    init {
        require(toAddress != null || toUserId != null) { "toAddress or toUserId, one of them is required" }

        if (toAddress != null && !WALLET_ADDRESS_REGEX.matches(toAddress)) {
            throw IllegalArgumentException("Invalid toAddress wallet address - invalid pattern against ${WALLET_ADDRESS_REGEX.pattern}")
        }

        if (toUserId != null && toUserId.isBlank()) {
            throw IllegalArgumentException("Invalid toUserId - fromUserId can not be blank")
        }
    }
}

@Suppress("unused")
enum class OrderBy {
    ASC, DESC;

    fun toParameter(): String = this.name.lowercase()
}

fun OrderBy.name() = this.name.lowercase()

@Suppress("unused")
enum class RequestType {
    REDIRECT_URI, AOA;

    fun toParameter(): String = this.name.lowercase()
}

fun RequestType.name() = this.name.lowercase()
