class ProcesosTerminados<TIPO>:Cola<TIPO> {

    constructor() : super()


    fun vaciarPapelera(){
        super.emptyQueue()
    }


    override fun toString(): String {
        return "\n${super.toString()}"
    }
}