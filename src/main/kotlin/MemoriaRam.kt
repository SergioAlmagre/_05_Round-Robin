class MemoriaRam<TIPO>: Cola<TIPO> {

    constructor() : super()


    override fun toString(): String {
        return "\nProcesos en RAM\n${super.toString()}"
    }


}