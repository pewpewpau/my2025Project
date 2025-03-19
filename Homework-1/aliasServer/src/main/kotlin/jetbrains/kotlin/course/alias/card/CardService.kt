package jetbrains.kotlin.course.alias.card

import org.springframework.stereotype.Service
import jetbrains.kotlin.course.alias.util.IdentifierFactory

@Service
class CardService {

    // Property to generate unique identifiers for each card
    private val identifierFactory: IdentifierFactory = IdentifierFactory()

    // Property to store the list of cards, initialized by calling generateCards
    val cards: List<Card> = generateCards()

    companion object {

        const val WORDS_IN_CARD = 4
        val words: List<String> = listOf("Apple", "Banana", "Carrot", "Dragon", "Egg", "Fox", "Grape", "Horse")
        val cardsAmount: Int = words.size / WORDS_IN_CARD
    }

    private fun generateCards(): List<Card> {
        return words.shuffled()
            .chunked(WORDS_IN_CARD)
            .take(cardsAmount)
            .mapIndexed { index, chunk ->
                Card(identifierFactory.uniqueIdentifier(), chunk.toWords())
            }
    }

    private fun List<String>.toWords(): List<Word> = this.map { Word(it) }

    // Method to retrieve a card by its index
    fun getCardByIndex(index: Int): Card  {
        return cards.getOrNull(index) ?: throw IllegalArgumentException("Card not found at index $index")
    }
}
