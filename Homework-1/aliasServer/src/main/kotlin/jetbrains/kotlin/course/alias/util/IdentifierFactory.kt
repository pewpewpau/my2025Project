package jetbrains.kotlin.course.alias.util

// Alias for Identifier
typealias Identifier = Int

// IdentifierFactory to generate unique identifiers
class IdentifierFactory {
    private var counter: Int = 0

    fun uniqueIdentifier(): Identifier {
        counter++
        return counter
    }
}