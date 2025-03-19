package jetbrains.kotlin.course.alias.team

import org.springframework.stereotype.Service
import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory

@Service
class TeamService {

    // Property to generate unique identifiers for teams
    private val identifierFactory: IdentifierFactory = IdentifierFactory()

    // Companion object to hold a storage of all teams
    companion object {
        val teamsStorage: MutableMap<Identifier, Team> = mutableMapOf()
    }

    // Method to generate teams for one round and store them in the storage
    fun generateTeamsForOneRound(teamsNumber: Int): List<Team> {
        val teams = (1..teamsNumber).map {
            val id = identifierFactory.uniqueIdentifier()
            val team = Team(id)
            teamsStorage[id] = team
            team
        }
        return teams
    }
}
