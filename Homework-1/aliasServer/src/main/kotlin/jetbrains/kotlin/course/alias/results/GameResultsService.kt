package jetbrains.kotlin.course.alias.results

import org.springframework.stereotype.Service
import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService

typealias GameResult = List<Team>

@Service
class GameResultsService {
    companion object {
        private val gameHistory: MutableList<GameResult> = mutableListOf()
    }
    fun saveGameResults(result: GameResult) {
        require(result.isNotEmpty()) { "Game result cannot be empty" }
        require(result.all { it.id in TeamService.teamsStorage }) { "Invalid team IDs in the result" }
        gameHistory.add(result)
    }

    fun getAllGameResults(): List<GameResult> = gameHistory.reversed()
}
