package jetbrains.kotlin.course.alias.team

import org.springframework.stereotype.Service
import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory

@Service
class TeamService {

    private val identifierFactory: IdentifierFactory = IdentifierFactory()

    companion object {
        val teamsStorage: MutableMap<Identifier, Team> = mutableMapOf()
    }

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
