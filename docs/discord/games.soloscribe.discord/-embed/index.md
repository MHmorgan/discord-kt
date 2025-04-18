//[discord](../../../index.md)/[games.soloscribe.discord](../index.md)/[Embed](index.md)

# Embed

class [Embed](index.md)

A builder of an embed object in Discord.

Used as part of [WebhookMessage](../-webhook-message/index.md).

#### See also

| | |
|---|---|
| https | ://discord.com/developers/docs/resources/message#embed-object |

## Constructors

| | |
|---|---|
| [Embed](-embed.md) | [jvm]<br>constructor() |

## Properties

| Name | Summary |
|---|---|
| [color](color.md) | [jvm]<br>var [color](color.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html)?<br>Color code of the embed |
| [description](description.md) | [jvm]<br>var [description](description.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)?<br>Description of embed |
| [timestamp](timestamp.md) | [jvm]<br>var [timestamp](timestamp.md): [OffsetDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/OffsetDateTime.html)?<br>Timestamp of embed content |
| [title](title.md) | [jvm]<br>var [title](title.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html)?<br>Title of embed |
| [url](url.md) | [jvm]<br>var [url](url.md): [URI](https://docs.oracle.com/javase/8/docs/api/java/net/URI.html)?<br>Url of embed |

## Functions

| Name | Summary |
|---|---|
| [addField](add-field.md) | [jvm]<br>fun [addField](add-field.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html), value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html), inline: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-boolean/index.html) = false)<br>Add a field to the fields information |
| [author](author.md) | [jvm]<br>fun [author](author.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html), url: [URI](https://docs.oracle.com/javase/8/docs/api/java/net/URI.html)? = null, iconUrl: [URI](https://docs.oracle.com/javase/8/docs/api/java/net/URI.html)? = null, proxyIconUrl: [URI](https://docs.oracle.com/javase/8/docs/api/java/net/URI.html)? = null)<br>Set author information |
| [footer](footer.md) | [jvm]<br>fun [footer](footer.md)(text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html), icon: [URI](https://docs.oracle.com/javase/8/docs/api/java/net/URI.html), proxyIcon: [URI](https://docs.oracle.com/javase/8/docs/api/java/net/URI.html)? = null)<br>Set footer information |
| [image](image.md) | [jvm]<br>fun [image](image.md)(url: [URI](https://docs.oracle.com/javase/8/docs/api/java/net/URI.html), proxyUrl: [URI](https://docs.oracle.com/javase/8/docs/api/java/net/URI.html)? = null, height: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html)? = null, width: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html)? = null)<br>Set image information |
| [provider](provider.md) | [jvm]<br>fun [provider](provider.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-string/index.html), url: [URI](https://docs.oracle.com/javase/8/docs/api/java/net/URI.html)? = null)<br>Set provider information |
| [thumbnail](thumbnail.md) | [jvm]<br>fun [thumbnail](thumbnail.md)(url: [URI](https://docs.oracle.com/javase/8/docs/api/java/net/URI.html), proxyUrl: [URI](https://docs.oracle.com/javase/8/docs/api/java/net/URI.html)? = null, height: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html)? = null, width: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html)? = null)<br>Set thumbnail information |
| [video](video.md) | [jvm]<br>fun [video](video.md)(url: [URI](https://docs.oracle.com/javase/8/docs/api/java/net/URI.html), proxyUrl: [URI](https://docs.oracle.com/javase/8/docs/api/java/net/URI.html)? = null, height: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html)? = null, width: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-int/index.html)? = null)<br>Set video information |
