package games.soloscribe.discord.dtos

import games.soloscribe.discord.Poll
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A poll object for Discord.
 *
 * @see https://discord.com/developers/docs/resources/poll#poll-create-request-object
 */
@Serializable
internal data class PollDTO(
    /**
     * The question of the poll. Only text is supported.
     */
    val question: MediaObject,

    /**
     * Each of the answers available in the poll.
     */
    val answers: List<Answer>,

    /**
     * Number of hours the poll should be open for, up to 32 days. Defaults to 24
     */
    val duration: Int? = null,

    /**
     * Whether a user can select multiple answers.
     */
    @SerialName("allow_multiselect")
    val allowMultiselect: Boolean? = null,
) {
    constructor(poll: Poll) : this(
        question = MediaObject(text = poll.question),
        answers = poll.answers,
        duration = poll.duration,
        allowMultiselect = poll.allowMultiselect
    )

    @Serializable
    data class MediaObject(
        val text: String? = null,
        val emoji: Emoji? = null,
    )

    @Serializable
    data class Emoji(
        val id: String? = null,
        val name: String? = null,
    )

    @Serializable
    data class Answer(
        @SerialName("poll_media")
        val pollMedia: MediaObject,
    )
}
