package games.soloscribe.discord

import org.junit.jupiter.api.Test
import java.net.URI
import java.time.OffsetDateTime

class DiscordTest {
    @Test
    fun send() {
        val urlStr = System.getenv("DISCORD_WEBHOOK_URL")
            ?: error("DISCORD_WEBHOOK_URL not set")
        val webhook = URI.create(urlStr)
        executeWebhook(webhook) {
            username = "test-user"
            content = "Hello, content!"

            embed {
                title = "Embed Title"
                description = "Embed Description"
                url = URI.create("https://example.com")
                color = 0xFF5733
                timestamp = OffsetDateTime.now()

                addField("MyField", "Sweet")
                addField("YourField", "Awesome")
                addField("InlineFile", "Inline", true)
            }

            embed {
                title = "Embed Title 2"
                description = "Embed Description 2"
                url = URI.create("https://example.com")
                color = 0x33FF57
                timestamp = OffsetDateTime.now()

                addField("MyField", "Sweet")
                addField("YourField", "Awesome")
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
}
