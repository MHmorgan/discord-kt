Discord + Kotlin = <3
=====================

[Documentation](docs/index.md)

## Usage

```kotlin
import java.net.URI
import java.time.OffsetDateTime

fun main() {
    val webhook = URI.create("...")
    executeWebhook(webhook) {
        username = "test-user"
        content = "Hello, content!"

        allowedMention(parse = "roles")
        allowedMention(parse = "users")

        embed {
            title = "Embed Title"
            description = "Embed Description"
            url = URI.create("https://example.com")
            color = 0xFF5733
            timestamp = OffsetDateTime.now()

            addField("MyField", "Sweet")
            addField("YourField", "Awesome")
        }

        embed {
            title = "Embed Title 2"
            description = "Embed Description 2"
            color = 0x33FF57
            
            addField("InlineFile", "Inline", true)
        }

        poll {
            question = "Do you like this?"
            addAnswer("Yes")
            addAnswer("No")
            addAnswer("Maybe")
            addAnswer("I don't know")
        }
    }
}
```
