import java.util.Scanner
import kotlin.system.exitProcess

class cmd(private val objectHandler: ObjectHandler) {
    private val scanner = Scanner(System.`in`)
    fun start(){
        println("Running the engine...")

        var running = true

        while(running){
            print(">")
            val input = scanner.nextLine()
            when(input.trim().lowercase()){
                "collider 1" -> {
                    for(gameObject in objectHandler.gameObjects){
                        gameObject.collidable = true
                    }
                }
                "collider 0" -> {
                    for(gameObject in objectHandler.gameObjects){
                        gameObject.collidable = false
                    }
                }
                "quit" -> {
                    running = false
                    println("Exiting the program...")
                    exitProcess(0)
                }
            }
        }
    }

}