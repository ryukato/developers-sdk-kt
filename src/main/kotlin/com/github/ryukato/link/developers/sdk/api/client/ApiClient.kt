@file:Suppress("unused")

package com.github.ryukato.link.developers.sdk.api.client

import com.github.ryukato.link.developers.sdk.api.BASE_COIN_TRANSFER_PATH
import com.github.ryukato.link.developers.sdk.api.COMMIT_SESSION_TOKEN_PATH
import com.github.ryukato.link.developers.sdk.api.FUNGIBLE_TOKENS_PATH
import com.github.ryukato.link.developers.sdk.api.FUNGIBLE_TOKEN_BURN_PATH
import com.github.ryukato.link.developers.sdk.api.FUNGIBLE_TOKEN_CREATE_PATH
import com.github.ryukato.link.developers.sdk.api.FUNGIBLE_TOKEN_HOLDERS_PATH
import com.github.ryukato.link.developers.sdk.api.FUNGIBLE_TOKEN_MINT_PATH
import com.github.ryukato.link.developers.sdk.api.FUNGIBLE_TOKEN_PATH
import com.github.ryukato.link.developers.sdk.api.FUNGIBLE_TOKEN_UPDATE_PATH
import com.github.ryukato.link.developers.sdk.api.ISSUE_SESSION_TOKEN_FOR_BASE_COIN_PATH
import com.github.ryukato.link.developers.sdk.api.ISSUE_SESSION_TOKEN_FOR_ITEM_TOKEN_PROXY
import com.github.ryukato.link.developers.sdk.api.ISSUE_SESSION_TOKEN_FOR_SERVICE_TOKEN_PATH
import com.github.ryukato.link.developers.sdk.api.ITEM_TOKEN_PATH
import com.github.ryukato.link.developers.sdk.api.MEMO_BY_TX_HASH_PATH
import com.github.ryukato.link.developers.sdk.api.MEMO_PATH
import com.github.ryukato.link.developers.sdk.api.NON_FUNGIBLE_TOKENS_PATH
import com.github.ryukato.link.developers.sdk.api.NON_FUNGIBLE_TOKEN_BURN_PATH
import com.github.ryukato.link.developers.sdk.api.NON_FUNGIBLE_TOKEN_CHILDREN_PATH
import com.github.ryukato.link.developers.sdk.api.NON_FUNGIBLE_TOKEN_HOLDER_PATH
import com.github.ryukato.link.developers.sdk.api.NON_FUNGIBLE_TOKEN_ID_PATH
import com.github.ryukato.link.developers.sdk.api.NON_FUNGIBLE_TOKEN_MINT_PATH
import com.github.ryukato.link.developers.sdk.api.NON_FUNGIBLE_TOKEN_MULTI_MINT_PATH
import com.github.ryukato.link.developers.sdk.api.NON_FUNGIBLE_TOKEN_PARENT_PATH
import com.github.ryukato.link.developers.sdk.api.NON_FUNGIBLE_TOKEN_ROOT_PATH
import com.github.ryukato.link.developers.sdk.api.NON_FUNGIBLE_TOKEN_TYPE_HOLDERS_PATH
import com.github.ryukato.link.developers.sdk.api.NON_FUNGIBLE_TOKEN_TYPE_PATH
import com.github.ryukato.link.developers.sdk.api.REQUEST_SESSION_TOKEN_PATH
import com.github.ryukato.link.developers.sdk.api.SERVICE_DETAIL_API_PATH
import com.github.ryukato.link.developers.sdk.api.SERVICE_TOKENS_PATH
import com.github.ryukato.link.developers.sdk.api.SERVICE_TOKEN_BURN_PATH
import com.github.ryukato.link.developers.sdk.api.SERVICE_TOKEN_BY_TX_HASH_PATH
import com.github.ryukato.link.developers.sdk.api.SERVICE_TOKEN_HOLDERS_PATH
import com.github.ryukato.link.developers.sdk.api.SERVICE_TOKEN_MINT_PATH
import com.github.ryukato.link.developers.sdk.api.SERVICE_TOKEN_PATH
import com.github.ryukato.link.developers.sdk.api.SERVICE_TOKEN_TRANSFER_PATH
import com.github.ryukato.link.developers.sdk.api.TIME_API_PATH
import com.github.ryukato.link.developers.sdk.api.TRANSACTION_PATH
import com.github.ryukato.link.developers.sdk.api.USER_BASE_COIN_BALANCE_PATH
import com.github.ryukato.link.developers.sdk.api.USER_DETAIL_PATH
import com.github.ryukato.link.developers.sdk.api.USER_FUNGIBLE_TOKENS_BALANCE_PATH
import com.github.ryukato.link.developers.sdk.api.USER_FUNGIBLE_TOKEN_BALANCE_PATH
import com.github.ryukato.link.developers.sdk.api.USER_FUNGIBLE_TOKEN_TRANSFER_PATH
import com.github.ryukato.link.developers.sdk.api.USER_ITEM_TOKEN_IS_PROXY_PATH
import com.github.ryukato.link.developers.sdk.api.USER_NON_FUNGIBLE_TOKENS_BALANCE_PATH
import com.github.ryukato.link.developers.sdk.api.USER_NON_FUNGIBLE_TOKEN_BALANCES_BY_TYPE_PATH
import com.github.ryukato.link.developers.sdk.api.USER_NON_FUNGIBLE_TOKEN_BALANCE_PATH
import com.github.ryukato.link.developers.sdk.api.USER_NON_FUNGIBLE_TOKEN_BATCH_TRANSFER_PATH
import com.github.ryukato.link.developers.sdk.api.USER_NON_FUNGIBLE_TOKEN_TRANSFER_PATH
import com.github.ryukato.link.developers.sdk.api.USER_REQUESTS_PATH
import com.github.ryukato.link.developers.sdk.api.USER_SERVICE_TOKENS_BALANCE_PATH
import com.github.ryukato.link.developers.sdk.api.USER_SERVICE_TOKEN_BALANCE_PATH
import com.github.ryukato.link.developers.sdk.api.USER_SERVICE_TOKEN_IS_PROXY_PATH
import com.github.ryukato.link.developers.sdk.api.USER_SERVICE_TOKEN_TRANSFER_PATH
import com.github.ryukato.link.developers.sdk.api.USER_TRANSACTIONS_PATH
import com.github.ryukato.link.developers.sdk.api.WALLET_BASE_COIN_BALANCE_PATH
import com.github.ryukato.link.developers.sdk.api.WALLET_FUNGIBLE_TOKENS_BALANCE_PATH
import com.github.ryukato.link.developers.sdk.api.WALLET_FUNGIBLE_TOKEN_BALANCE_PATH
import com.github.ryukato.link.developers.sdk.api.WALLET_FUNGIBLE_TOKEN_TRANSFER_PATH
import com.github.ryukato.link.developers.sdk.api.WALLET_LIST_PATH
import com.github.ryukato.link.developers.sdk.api.WALLET_NON_FUNGIBLE_TOKENS_BALANCE_PATH
import com.github.ryukato.link.developers.sdk.api.WALLET_NON_FUNGIBLE_TOKEN_BALANCES_BY_TYPE_PATH
import com.github.ryukato.link.developers.sdk.api.WALLET_NON_FUNGIBLE_TOKEN_BALANCE_PATH
import com.github.ryukato.link.developers.sdk.api.WALLET_NON_FUNGIBLE_TOKEN_BATCH_TRANSFER_PATH
import com.github.ryukato.link.developers.sdk.api.WALLET_NON_FUNGIBLE_TOKEN_TRANSFER_PATH
import com.github.ryukato.link.developers.sdk.api.WALLET_PATH
import com.github.ryukato.link.developers.sdk.api.WALLET_SERVICE_TOKENS_BALANCE_PATH
import com.github.ryukato.link.developers.sdk.api.WALLET_SERVICE_TOKEN_BALANCE_PATH
import com.github.ryukato.link.developers.sdk.api.WALLET_TRANSACTIONS_PATH
import com.github.ryukato.link.developers.sdk.api.request.BatchTransferNonFungibleOfUserRequest
import com.github.ryukato.link.developers.sdk.api.request.BatchTransferNonFungibleRequest
import com.github.ryukato.link.developers.sdk.api.request.BurnFromServiceTokenRequest
import com.github.ryukato.link.developers.sdk.api.request.FungibleTokenBurnRequest
import com.github.ryukato.link.developers.sdk.api.request.FungibleTokenCreateUpdateRequest
import com.github.ryukato.link.developers.sdk.api.request.FungibleTokenMintRequest
import com.github.ryukato.link.developers.sdk.api.request.IssueServiceTokenRequest
import com.github.ryukato.link.developers.sdk.api.request.MemoRequest
import com.github.ryukato.link.developers.sdk.api.request.MintServiceTokenRequest
import com.github.ryukato.link.developers.sdk.api.request.NonFungibleTokenBurnRequest
import com.github.ryukato.link.developers.sdk.api.request.NonFungibleTokenCreateUpdateRequest
import com.github.ryukato.link.developers.sdk.api.request.NonFungibleTokenItemTokenAttachRequest
import com.github.ryukato.link.developers.sdk.api.request.NonFungibleTokenItemTokenDetachRequest
import com.github.ryukato.link.developers.sdk.api.request.NonFungibleTokenMintRequest
import com.github.ryukato.link.developers.sdk.api.request.NonFungibleTokenMultiMintRequest
import com.github.ryukato.link.developers.sdk.api.request.OrderBy
import com.github.ryukato.link.developers.sdk.api.request.TransferBaseCoinRequest
import com.github.ryukato.link.developers.sdk.api.request.TransferFungibleTokenRequest
import com.github.ryukato.link.developers.sdk.api.request.TransferNonFungibleOfUserRequest
import com.github.ryukato.link.developers.sdk.api.request.TransferNonFungibleRequest
import com.github.ryukato.link.developers.sdk.api.request.TransferServiceTokenRequest
import com.github.ryukato.link.developers.sdk.api.request.TransferTokenOfUserRequest
import com.github.ryukato.link.developers.sdk.api.request.UpdateServiceTokenRequest
import com.github.ryukato.link.developers.sdk.api.request.UserAssetProxyRequest
import com.github.ryukato.link.developers.sdk.api.request.UserServiceTokenTransferRequest
import com.github.ryukato.link.developers.sdk.api.response.BaseCoinBalance
import com.github.ryukato.link.developers.sdk.api.response.FungibleBalance
import com.github.ryukato.link.developers.sdk.api.response.FungibleToken
import com.github.ryukato.link.developers.sdk.api.response.FungibleTokenHolder
import com.github.ryukato.link.developers.sdk.api.response.GenericResponse
import com.github.ryukato.link.developers.sdk.api.response.ItemToken
import com.github.ryukato.link.developers.sdk.api.response.ItemTokenType
import com.github.ryukato.link.developers.sdk.api.response.Memo
import com.github.ryukato.link.developers.sdk.api.response.NonFungibleBalance
import com.github.ryukato.link.developers.sdk.api.response.NonFungibleId
import com.github.ryukato.link.developers.sdk.api.response.NonFungibleTokenHolder
import com.github.ryukato.link.developers.sdk.api.response.NonFungibleTokenType
import com.github.ryukato.link.developers.sdk.api.response.NonFungibleTokenTypeHolder
import com.github.ryukato.link.developers.sdk.api.response.ProxyStatus
import com.github.ryukato.link.developers.sdk.api.response.RequestSession
import com.github.ryukato.link.developers.sdk.api.response.RequestSessionStatus
import com.github.ryukato.link.developers.sdk.api.response.ServiceDetail
import com.github.ryukato.link.developers.sdk.api.response.ServiceToken
import com.github.ryukato.link.developers.sdk.api.response.ServiceTokenBalance
import com.github.ryukato.link.developers.sdk.api.response.ServiceTokenHolder
import com.github.ryukato.link.developers.sdk.api.response.SimpleServiceToken
import com.github.ryukato.link.developers.sdk.api.response.TokenIndex
import com.github.ryukato.link.developers.sdk.api.response.TransactionResponse
import com.github.ryukato.link.developers.sdk.api.response.TxResultResponse
import com.github.ryukato.link.developers.sdk.api.response.UserIdAddress
import com.github.ryukato.link.developers.sdk.api.response.UserRequestStatus
import com.github.ryukato.link.developers.sdk.api.response.WalletResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import java.time.LocalDateTime
import java.time.ZoneOffset

interface ApiClient {
    @GET(TIME_API_PATH)
    suspend fun time(): GenericResponse<Unit>

    /**
     * Retrieve service information
     */
    @GET(SERVICE_DETAIL_API_PATH)
    suspend fun serviceDetail(@Path("serviceId") serviceId: String): GenericResponse<ServiceDetail>

    /**
     *  Issue a service token
     */
    @POST(SERVICE_TOKENS_PATH)
    suspend fun issueServiceToken(
        @Body issueServiceTokenRequest: IssueServiceTokenRequest
    ): GenericResponse<TransactionResponse>

    @GET(SERVICE_TOKEN_BY_TX_HASH_PATH)
    suspend fun serviceTokenByTxHash(
        @Path("txHash") txHash: String,
        @Query("isOnlyContractId") isOnlyContractId : Boolean = false,
    ): GenericResponse<SimpleServiceToken>

    /**
     * List all service tokens
     */
    @GET(SERVICE_TOKENS_PATH)
    suspend fun serviceTokens(): GenericResponse<Collection<ServiceToken>>

    /**
     * Retrieve service token information
     */
    @GET(SERVICE_TOKEN_PATH)
    suspend fun serviceToken(@Path("contractId") contractId: String): GenericResponse<ServiceToken>

    /**
     * List all service token holders
     */
    @GET(SERVICE_TOKEN_HOLDERS_PATH)
    suspend fun serviceTokenHolders(
        @Path("contractId") contractId: String,
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 1,
        @Query("orderBy") orderBy: OrderBy = OrderBy.ASC,
    ): GenericResponse<Collection<ServiceTokenHolder>>

    /**
     * Update service token information
     */
    @PUT(SERVICE_TOKEN_PATH)
    suspend fun updateServiceToken(
        @Path("contractId") contractId: String,
        @Body request: UpdateServiceTokenRequest
    ): GenericResponse<TransactionResponse>

    /**
     * Mint a service token
     */
    @POST(SERVICE_TOKEN_MINT_PATH)
    suspend fun mintServiceToken(
        @Path("contractId") contractId: String,
        @Body request: MintServiceTokenRequest,
    ): GenericResponse<TransactionResponse>

    /**
     * Burn a service token
     */
    @POST(SERVICE_TOKEN_BURN_PATH)
    suspend fun burnFromServiceToken(
        @Path("contractId") contractId: String,
        @Body requestFrom: BurnFromServiceTokenRequest,
    ): GenericResponse<TransactionResponse>

    /**
     * Retrieve transaction detail
     */
    @GET(TRANSACTION_PATH)
    suspend fun transaction(@Path("txHash") txHash: String): GenericResponse<TxResultResponse>

    // memo
    /**
     * Save the text
     */
    @POST(MEMO_PATH)
    suspend fun saveMemo(@Body request: MemoRequest): GenericResponse<TransactionResponse>

    /**
     * Query memo of a transaction by tx-hash
     */
    @GET(MEMO_BY_TX_HASH_PATH)
    suspend fun queryMemo(@Path("txHash") txHash: String): GenericResponse<Memo>

    // wallet
    /**
     * List all service wallets
     */
    @GET(WALLET_LIST_PATH)
    suspend fun wallets(): GenericResponse<Collection<WalletResponse>>

    /**
     * Retrieve service wallet information
     */
    @GET(WALLET_PATH)
    suspend fun wallet(@Path("walletAddress") walletAddress: String): GenericResponse<WalletResponse>

    /**
     * Retrieve service wallet transaction history
     * By default 1 day transactions of given wallet will be returned
     */
    @GET(WALLET_TRANSACTIONS_PATH)
    suspend fun transactionOfWallet(
        @Path("walletAddress") walletAddress: String,
        @Query("after") after: Long? = LocalDateTime.now().minusDays(1).toEpochMilli(),
        @Query("before") before: Long? = LocalDateTime.now().toEpochMilli(),
        @Query("msgType") msgType: String? = null,
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 1,
        @Query("orderBy") orderBy: OrderBy = OrderBy.ASC,
    ): GenericResponse<Collection<TxResultResponse>>

    // wallet-balance
    /**
     * Retrieve base coin balance (service wallet)
     * Only for Cashew
     */
    @GET(WALLET_BASE_COIN_BALANCE_PATH)
    suspend fun baseCoinBalanceOfWallet(@Path("walletAddress") walletAddress: String): GenericResponse<BaseCoinBalance>

    /**
     * Transfer base coins (service wallet)
     */
    @POST(BASE_COIN_TRANSFER_PATH)
    suspend fun transferBaseCoin(
        @Path("walletAddress") walletAddress: String,
        @Body request: TransferBaseCoinRequest,
    ): GenericResponse<TransactionResponse>

    /**
     * Retrieve balance of all service tokens (service wallet)
     */
    @GET(WALLET_SERVICE_TOKENS_BALANCE_PATH)
    suspend fun serviceTokenBalancesOfWallet(
        @Path("walletAddress") walletAddress: String,
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 1,
        @Query("orderBy") orderBy: OrderBy = OrderBy.ASC,
    ): GenericResponse<Collection<ServiceTokenBalance>>

    /**
     * Retrieve balance of a specific service token (service wallet)
     */
    @GET(WALLET_SERVICE_TOKEN_BALANCE_PATH)
    suspend fun serviceTokenBalanceOfWallet(
        @Path("walletAddress") walletAddress: String,
        @Path("contractId") contractId: String,
    ): GenericResponse<ServiceTokenBalance>

    /**
     * Transfer service tokens (service wallet)
     */
    @POST(SERVICE_TOKEN_TRANSFER_PATH)
    suspend fun transferServiceToken(
        @Path("walletAddress") walletAddress: String,
        @Path("contractId") contractId: String,
        @Body request: TransferServiceTokenRequest,
    ): GenericResponse<TransactionResponse>

    /**
     * Retrieve balance of all fungibles (service wallet)
     */
    @GET(WALLET_FUNGIBLE_TOKENS_BALANCE_PATH)
    suspend fun fungibleTokensBalanceOfWallet(
        @Path("walletAddress") walletAddress: String,
        @Path("contractId") contractId: String,
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 1,
        @Query("orderBy") orderBy: OrderBy = OrderBy.ASC,
    ): GenericResponse<Collection<FungibleBalance>>

    /**
     * Retrieve balance of a specific fungible (service wallet)
     */
    @GET(WALLET_FUNGIBLE_TOKEN_BALANCE_PATH)
    suspend fun fungibleTokenBalanceOfWallet(
        @Path("walletAddress") walletAddress: String,
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
    ): GenericResponse<FungibleBalance>

    /**
     * Transfer a fungible (service wallet)
     */
    @POST(WALLET_FUNGIBLE_TOKEN_TRANSFER_PATH)
    suspend fun transferFungibleTokenOfWallet(
        @Path("walletAddress") walletAddress: String,
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Body request: TransferFungibleTokenRequest,
    ): GenericResponse<TransactionResponse>

    /**
     * Retrieve balance of all non-fungibles (service wallet)
     */
    @GET(WALLET_NON_FUNGIBLE_TOKENS_BALANCE_PATH)
    suspend fun nonFungibleTokenBalancesOfWallet(
        @Path("walletAddress") walletAddress: String,
        @Path("contractId") contractId: String,
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 1,
        @Query("orderBy") orderBy: OrderBy = OrderBy.ASC,
    ): GenericResponse<Collection<NonFungibleBalance>>

    /**
     * Retrieve balance of specific type of non-fungibles (service wallet)
     */
    @GET(WALLET_NON_FUNGIBLE_TOKEN_BALANCES_BY_TYPE_PATH)
    suspend fun nonFungibleTokenBalancesOfWalletByType(
        @Path("walletAddress") walletAddress: String,
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 1,
        @Query("orderBy") orderBy: OrderBy = OrderBy.ASC,
    ): GenericResponse<Collection<TokenIndex>>

    /**
     * Retrieve balance of a specific non-fungible (service wallet)
     */
    @GET(WALLET_NON_FUNGIBLE_TOKEN_BALANCE_PATH)
    suspend fun nonFungibleTokenBalanceOfWallet(
        @Path("walletAddress") walletAddress: String,
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Path("tokenIndex") tokenIndex: String,
    ): GenericResponse<TokenIndex>

    /**
     * Transfer a non-fungible (service wallet)
     */
    @POST(WALLET_NON_FUNGIBLE_TOKEN_TRANSFER_PATH)
    suspend fun transferNonFungibleTokenOfWallet(
        @Path("walletAddress") walletAddress: String,
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Path("tokenIndex") tokenIndex: String,
        @Body request: TransferNonFungibleRequest,
    ): GenericResponse<TransactionResponse>

    /**
     * Batch transfer non-fungibles (service wallet)
     */
    @POST(WALLET_NON_FUNGIBLE_TOKEN_BATCH_TRANSFER_PATH)
    suspend fun batchTransferNonFungibleTokenOfWallet(
        @Path("walletAddress") walletAddress: String,
        @Path("contractId") contractId: String,
        @Body request: BatchTransferNonFungibleRequest,
    ): GenericResponse<TransactionResponse>

    // item-tokens
    /**
     * Retrieve item token contract information
     */
    @GET(ITEM_TOKEN_PATH)
    suspend fun itemToken(
        @Path("contractId") contractId: String,
    ): GenericResponse<ItemToken>

    // fungibles
    /**
     * List all fungibles
     */
    @GET(FUNGIBLE_TOKENS_PATH)
    suspend fun fungibleTokens(
        @Path("contractId") contractId: String,
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 1,
        @Query("orderBy") orderBy: OrderBy = OrderBy.ASC,
    ): GenericResponse<Collection<FungibleToken>>

    /**
     * Retrieve fungible information
     */
    @GET(FUNGIBLE_TOKEN_PATH)
    suspend fun fungibleToken(
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
    ): GenericResponse<FungibleToken>

    /**
     * Retrieve all fungible holders
     */
    @GET(FUNGIBLE_TOKEN_HOLDERS_PATH)
    suspend fun fungibleTokenHolders(
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 1,
        @Query("orderBy") orderBy: OrderBy = OrderBy.ASC,
    ): GenericResponse<Collection<FungibleTokenHolder>>

    /**
     * Create a fungible
     */
    @POST(FUNGIBLE_TOKEN_CREATE_PATH)
    suspend fun createFungible(
        @Path("contractId") contractId: String,
        @Body request: FungibleTokenCreateUpdateRequest,
    ): GenericResponse<TransactionResponse>

    /**
     * Update fungible information
     */
    @PUT(FUNGIBLE_TOKEN_UPDATE_PATH)
    suspend fun updateFungible(
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Body request: FungibleTokenCreateUpdateRequest,
    ): GenericResponse<TransactionResponse>

    /**
     * Mint a fungible
     */
    @POST(FUNGIBLE_TOKEN_MINT_PATH)
    suspend fun mintFungible(
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Body request: FungibleTokenMintRequest,
    ): GenericResponse<TransactionResponse>

    /**
     * Burn a fungible
     */
    @POST(FUNGIBLE_TOKEN_BURN_PATH)
    suspend fun burnFungible(
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Body request: FungibleTokenBurnRequest
    ): GenericResponse<TransactionResponse>

    // non-fungibles
    /**
     * List all non-fungibles
     */
    @GET(NON_FUNGIBLE_TOKENS_PATH)
    suspend fun nonFungibleTokenTypes(
        @Path("contractId") contractId: String,
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 1,
        @Query("orderBy") orderBy: OrderBy = OrderBy.ASC,
    ): GenericResponse<Collection<ItemTokenType>>

    /**
     * Create a non-fungible
     */
    @POST(NON_FUNGIBLE_TOKENS_PATH)
    suspend fun createNonFungibleType(
        @Path("contractId") contractId: String,
        @Body request: NonFungibleTokenCreateUpdateRequest
    ): GenericResponse<TransactionResponse>

    /**
     * Retrieve a non-fungible token type
     */
    @GET(NON_FUNGIBLE_TOKEN_TYPE_PATH)
    suspend fun nonFungibleTokenType(
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 1,
        @Query("orderBy") orderBy: OrderBy = OrderBy.ASC,
    ): GenericResponse<NonFungibleTokenType>

    /**
     * Update a non-fungible token type
     */
    @PUT(NON_FUNGIBLE_TOKEN_TYPE_PATH)
    suspend fun updateNonFungibleTokenType(
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Body request: NonFungibleTokenCreateUpdateRequest
    ): GenericResponse<TransactionResponse>

    /**
     * Retrieve non-fungible information
     */
    @GET(NON_FUNGIBLE_TOKEN_ID_PATH)
    suspend fun nonFungibleToken(
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Path("tokenIndex") tokenIndex: String,
    ): GenericResponse<NonFungibleId>

    /**
     * Update non-fungible information
     */
    @PUT(NON_FUNGIBLE_TOKEN_ID_PATH)
    suspend fun updateNonFungibleToken(
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Path("tokenIndex") tokenIndex: String,
        @Body request: NonFungibleTokenCreateUpdateRequest,
    ): GenericResponse<TransactionResponse>

    /**
     * Mint a non-fungible
     */
    @POST(NON_FUNGIBLE_TOKEN_MINT_PATH)
    suspend fun mintNonFungible(
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Body request: NonFungibleTokenMintRequest,
    ): GenericResponse<TransactionResponse>

    /**
     * Retrieve holders of a specific non-fungible token type
     */
    @GET(NON_FUNGIBLE_TOKEN_TYPE_HOLDERS_PATH)
    suspend fun nonFungibleTokenTypeHolders(
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 1,
        @Query("orderBy") orderBy: OrderBy = OrderBy.ASC,
    ): GenericResponse<Collection<NonFungibleTokenTypeHolder>>

    /**
     * Retrieve the holder of a specific non-fungible
     */
    @GET(NON_FUNGIBLE_TOKEN_HOLDER_PATH)
    suspend fun nonFungibleTokenHolder(
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Path("tokenIndex") tokenIndex: String
    ): GenericResponse<NonFungibleTokenHolder>

    /**
     * Mint multiple non-fungibles
     */
    @POST(NON_FUNGIBLE_TOKEN_MULTI_MINT_PATH)
    suspend fun multiMintNonFungible(
        @Path("contractId") contractId: String,
        @Body request: NonFungibleTokenMultiMintRequest,
    ): GenericResponse<TransactionResponse>

    /**
     * Burn a non-fungible
     */
    @POST(NON_FUNGIBLE_TOKEN_BURN_PATH)
    suspend fun burnNonFungible(
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Path("tokenIndex") tokenIndex: String,
        @Body request: NonFungibleTokenBurnRequest
    ): GenericResponse<TransactionResponse>

    /**
     * List the children of a non-fungible
     */
    @GET(NON_FUNGIBLE_TOKEN_CHILDREN_PATH)
    suspend fun nonFungibleTokenChildren(
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Path("tokenIndex") tokenIndex: String,
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 1,
        @Query("orderBy") orderBy: OrderBy = OrderBy.ASC,
    ): GenericResponse<Collection<NonFungibleId>>

    /**
     * Retrieve the parent of a non-fungible
     */
    @GET(NON_FUNGIBLE_TOKEN_PARENT_PATH)
    suspend fun nonFungibleTokenParent(
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Path("tokenIndex") tokenIndex: String,
    ): GenericResponse<NonFungibleId>

    /**
     * Retrieve the root of a non-fungible
     */
    @GET(NON_FUNGIBLE_TOKEN_ROOT_PATH)
    suspend fun nonFungibleTokenRoot(
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Path("tokenIndex") tokenIndex: String,
    ): GenericResponse<NonFungibleId>

    /**
     * Attach a non-fungible to another
     */
    @POST(NON_FUNGIBLE_TOKEN_PARENT_PATH)
    suspend fun attachNonFungible(
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Path("tokenIndex") tokenIndex: String,
        @Body request: NonFungibleTokenItemTokenAttachRequest,
    ): GenericResponse<TransactionResponse>

    /**
     * Detach a non-fungible from the parent
     */
    @HTTP(method = "DELETE", hasBody = true, path = NON_FUNGIBLE_TOKEN_PARENT_PATH)
    suspend fun detachNonFungible(
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Path("tokenIndex") tokenIndex: String,
        @Body request: NonFungibleTokenItemTokenDetachRequest,
    ): GenericResponse<TransactionResponse>

    // user api
    /**
     * Retrieve user information
     */
    @GET(USER_DETAIL_PATH)
    suspend fun userDetail(
        @Path("userId") userId: String,
    ): GenericResponse<UserIdAddress>

    /**
     * Retrieve user wallet transaction history
     */
    @GET(USER_TRANSACTIONS_PATH)
    suspend fun transactionOfUser(
        @Path("userId") userId: String,
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 1,
        @Query("orderBy") orderBy: OrderBy = OrderBy.ASC,
    ): GenericResponse<Collection<TxResultResponse>>

    /**
     * Retrieve base coin balance (user wallet)
     */
    @GET(USER_BASE_COIN_BALANCE_PATH)
    suspend fun baseCoinBalanceOfUser(userId: String): GenericResponse<BaseCoinBalance>

    /**
     * Retrieve balance of all service tokens (user wallet)
     */
    @GET(USER_SERVICE_TOKENS_BALANCE_PATH)
    suspend fun serviceTokenBalancesOfUser(
        @Path("userId") userId: String,
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 1,
        @Query("orderBy") orderBy: OrderBy = OrderBy.ASC,
    ): GenericResponse<Collection<ServiceTokenBalance>>

    /**
     * Retrieve balance of a specific service token (user wallet)
     */
    @GET(USER_SERVICE_TOKEN_BALANCE_PATH)
    suspend fun serviceTokenBalanceOfUser(
        @Path("userId") userId: String,
        contractId: String
    ): GenericResponse<ServiceTokenBalance>

    /**
     * Retrieve balance of all fungibles (user wallet)
     */
    @GET(USER_FUNGIBLE_TOKENS_BALANCE_PATH)
    suspend fun fungibleTokenBalancesOfUser(
        @Path("userId") userId: String,
        @Path("contractId") contractId: String,
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 1,
        @Query("orderBy") orderBy: OrderBy = OrderBy.ASC,
    ): GenericResponse<Collection<FungibleBalance>>

    /**
     * Retrieve balance of a specific fungible (user wallet)
     */
    @GET(USER_FUNGIBLE_TOKEN_BALANCE_PATH)
    suspend fun fungibleTokenBalanceOfUser(
        @Path("userId") userId: String,
        @Path("contractId") contractId: String,
        tokenType: String
    ): GenericResponse<FungibleBalance>

    /**
     * Retrieve balance of all non-fungibles (user wallet)
     */
    @GET(USER_NON_FUNGIBLE_TOKENS_BALANCE_PATH)
    suspend fun nonFungibleTokenBalancesOfUser(
        @Path("userId") userId: String,
        @Path("contractId") contractId: String,
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 1,
        @Query("orderBy") orderBy: OrderBy = OrderBy.ASC,
    ): GenericResponse<Collection<NonFungibleBalance>>

    /**
     * Retrieve balance of specific type of non-fungibles (user wallet)
     */
    @GET(USER_NON_FUNGIBLE_TOKEN_BALANCES_BY_TYPE_PATH)
    suspend fun nonFungibleTokenBalancesOfUser(
        @Path("userId") userId: String,
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 1,
        @Query("orderBy") orderBy: OrderBy = OrderBy.ASC,
    ): GenericResponse<Collection<TokenIndex>>

    /**
     * Retrieve balance of a specific non-fungible (service wallet)
     */
    @GET(USER_NON_FUNGIBLE_TOKEN_BALANCE_PATH)
    suspend fun nonFungibleTokenBalanceOfUser(
        @Path("userId") userId: String,
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Path("tokenIndex") tokenIndex: String,
    ): GenericResponse<TokenIndex>

    /**
     * Retrieve the status of a session token
     */
    @GET(REQUEST_SESSION_TOKEN_PATH)
    suspend fun requestSessionToken(
        @Path("requestSessionToken") requestSessionToken: String,
    ): GenericResponse<RequestSessionStatus>

    /**
     * Commit a transaction signed by a user wallet
     */
    @POST(COMMIT_SESSION_TOKEN_PATH)
    suspend fun commitRequestSession(
        @Path("requestSessionToken") requestSessionToken: String,
    ): GenericResponse<TransactionResponse>

    /**
     * Issue a session token for base coin transfer
     */
    @POST(ISSUE_SESSION_TOKEN_FOR_BASE_COIN_PATH)
    suspend fun issueSessionTokenForBaseCoinTransfer(
        @Path("userId") userId: String,
        @Query("requestType") requestType: String,
    ): GenericResponse<RequestSession>

    /**
     * Issue session token for service-token-proxy setting
     */
    @POST(ISSUE_SESSION_TOKEN_FOR_ITEM_TOKEN_PROXY)
    suspend fun issueSessionTokenForServiceTokenProxy(
        @Path("userId") userId: String,
        @Path("contractId") contractId: String,
        @Query("requestType") requestType: String,
        @Body requestUser: UserAssetProxyRequest,
    ): GenericResponse<RequestSession>

    /**
     * Issue a session token for service token transfer
     */
    @POST(ISSUE_SESSION_TOKEN_FOR_SERVICE_TOKEN_PATH)
    suspend fun issueSessionTokenForServiceTokenTransfer(
        @Path("userId") userId: String,
        @Path("contractId") contractId: String,
        @Query("requestType") requestType: String,
        @Body request: UserServiceTokenTransferRequest,
    ): GenericResponse<RequestSession>

    /**
     * Issue a session token for proxy setting
     */
    @POST(ISSUE_SESSION_TOKEN_FOR_ITEM_TOKEN_PROXY)
    suspend fun issueSessionTokenForItemTokenProxy(
        @Path("userId") userId: String,
        @Path("contractId") contractId: String,
        @Query("requestType") requestType: String,
        @Body requestUser: UserAssetProxyRequest
    ): GenericResponse<RequestSession>

    /**
     * Retrieve whether the proxy set or not for service-token
     */
    @GET(USER_SERVICE_TOKEN_IS_PROXY_PATH)
    suspend fun isProxyOfServiceToken(
        @Path("userId") userId: String,
        @Path("contractId") contractId: String,
    ): GenericResponse<ProxyStatus>


    /**
     * Retrieve whether the proxy set or not
     */
    @GET(USER_ITEM_TOKEN_IS_PROXY_PATH)
    suspend fun isProxyOfItemToken(
        @Path("userId") userId: String,
        @Path("contractId") contractId: String,
    ): GenericResponse<ProxyStatus>

    @POST(USER_SERVICE_TOKEN_TRANSFER_PATH)
    suspend fun transferServiceTokenOfUser(
        @Path("userId") userId: String,
        @Path("contractId") contractId: String,
        @Body request: TransferTokenOfUserRequest,
    ): GenericResponse<TransactionResponse>

    /**
     * Transfer a fungible (user wallet)
     */
    @POST(USER_FUNGIBLE_TOKEN_TRANSFER_PATH)
    suspend fun transferFungibleTokenOfUser(
        @Path("userId") userId: String,
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Body request: TransferTokenOfUserRequest,
    ): GenericResponse<TransactionResponse>

    /**
     * Transfer a non-fungible (user wallet)
     */
    @POST(USER_NON_FUNGIBLE_TOKEN_TRANSFER_PATH)
    suspend fun transferNonFungibleTokenOfUser(
        @Path("userId") userId: String,
        @Path("contractId") contractId: String,
        @Path("tokenType") tokenType: String,
        @Path("tokenIndex") tokenIndex: String,
        @Body request: TransferNonFungibleOfUserRequest,
    ): GenericResponse<TransactionResponse>

    /**
     * Batch transfer non-fungibles (user wallet)
     */
    @POST(USER_NON_FUNGIBLE_TOKEN_BATCH_TRANSFER_PATH)
    suspend fun batchTransferNonFungibleTokenOfUser(
        @Path("userId") userId: String,
        @Path("contractId") contractId: String,
        @Body request: BatchTransferNonFungibleOfUserRequest,
    ): GenericResponse<TransactionResponse>

}


fun LocalDateTime.toEpochMilli(): Long = this.toInstant(ZoneOffset.UTC).toEpochMilli()
