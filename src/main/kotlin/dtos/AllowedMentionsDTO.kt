package games.soloscribe.discord.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents allowed mentions in a message.
 *
 * @see https://discord.com/developers/docs/resources/message#allowed-mentions-object
 */
@Serializable
internal data class AllowedMentionsDTO(
    /**
     * An array of allowed mention types to parse from the content.
     */
    val parse: List<String>? = null,

    /**
     * Array of role_ids to mention (Max size of 100)
     */
    val roles: List<String>? = null,

    /**
     * Array of user_ids to mention (Max size of 100)
     */
    val users: List<String>? = null,

    /**
     * For replies, whether to mention the author of the message being replied to (default false)
     */
    @SerialName("replied_user")
    val repliedUser: Boolean? = null,
)