class Physics(private val objectHandler: ObjectHandler) {
    val gravity: Int = 2

    fun applyGravity(){
        for(gameObject in objectHandler.gameObjects){
            gameObject.positionY += gravity
        }
    }
}