//[discord](../../../index.md)/[games.soloscribe.discord](../index.md)/[Poll](index.md)

# Poll

class [Poll](index.md)

A builder of a poll object for Discord.

Used as part of [WebhookMessage](../-webhook-message/index.md).

#### See also

| | |
|---|---|
| https | ://discord.com/developers/docs/resources/poll#poll-create-request-object |

## Constructors

| | |
|---|---|
| [Poll](-poll.md) | [jvm]<br>constructor() |

## Properties

| Name | Summary |
|---|---|
| [allowMultiselect](allow-multiselect.md) | [jvm]<br>var [allowMultiselect](allow-multiselect.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html)?<br>Whether a user can select multiple answers. |
| [duration](duration.md) | [jvm]<br>var [duration](duration.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html)?<br>Number of hours the poll should be open for, up to 32 days. Defaults to 24. |
| [question](question.md) | [jvm]<br>var [question](question.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)?<br>The question of the poll. |

## Functions

| Name | Summary |
|---|---|
| [addAnswer](add-answer.md) | [jvm]<br>fun [addAnswer](add-answer.md)(text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html), emojiId: [Snowflake](../-snowflake/index.md)? = null, emojiName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)? = null)<br>Add an answer to the poll. |
