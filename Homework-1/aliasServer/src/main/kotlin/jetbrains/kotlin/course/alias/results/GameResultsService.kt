package jetbrains.kotlin.course.alias.results

import org.springframework.stereotype.Service
import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService

typealias GameResult = List<Team>

@Service
class GameResultsService {
    companion object {
        val gameHistory: MutableList<GameResult> = mutableListOf()
    }

    fun saveGameResults(result: GameResult) {
        require(result.isNotEmpty()) { "Result cannot be empty" }
        require(result.all { TeamService.teamsStorage.containsKey(it.id) }) { "Invalid team ID in result" }
        gameHistory.add(result)
    }

    fun getAllGameResults(): List<GameResult> {
        return gameHistory.reversed()
    }
}
