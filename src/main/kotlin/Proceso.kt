import kotlin.random.Random

class Proceso {
    private var id: String
    var cuantum:Float
    var prioridad: Int

    companion object{
        var idAuto: Int = 0
    }

    init {
        this.id = "P"
        this.prioridad = Random.nextInt(1,4)
        this.cuantum = Random.nextInt(1,5).toFloat()
    }

    constructor() {
        this.id = this.id + idAuto.toString()
        this.cuantum = this.cuantum
        this.prioridad = this.prioridad
        idAuto++
    }


    override fun toString(): String {
        return "Proceso(id='$id', cuantum=$cuantum, prioridad=$prioridad)"
    }


}