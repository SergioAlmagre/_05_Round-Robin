import kotlin.math.round

fun main(args: Array<String>) {

    var pro = Proceso()
    var i9 = Procesador<Proceso>()
    var ddr4 = MemoriaRam<Proceso>()
    var papelera = ProcesosTerminados<Proceso>()
    var tiempo: Float = 1f

    while (tiempo < 60.0f) {

        if (tiempo % 0.2f < 0.0001f) {
// SI HAY PROCESOS EN LA MEMORIA RAM, LOS LLEVA AL PROCESADOR
            if (!ddr4.isEmpty()) {
                pro = ddr4.pop()!!
                i9.addFirst(pro)
                println("\nAñadido $pro desde la memoria RAM")
            }
            println("Ahora hay un una linea para procesos")
// SI HAY PROCESOS EN EL PROCESADOR LOS PROCESA
            if (!i9.isEmpty()) {
                var procesosSimultanos = i9.totalProcesos()
                var i = 0
                do {
                    pro = i9.getProceso(i)
                    i9.procesarProceso(pro)

// SI HAY PROCESOS TERMINADOS LOS ELIMINA Y ENVÍA A LA PAPELERA
                    if (i9.procesoTerminado(i)) {
                        papelera.addFirst(pro)
                        i9.eliminarProceso(i)
                        procesosSimultanos--
                        println("Proceso terminado: $pro enviado a la papelera")

//  SI LOS PROCESOS AÚN TIENEN CUANTUM, SIGUEN PROCESANDOSE
                    } else {

//  PROCESADO FIFO
//                        if (i9.getProceso(i) != i9.getProceso(0)) {
//                            i9.addFirst(pro)
//                            i9.removeLast()
//                        }
//  PROCESADO POR PRIORIDAD
                        if (!i9.isEmpty()){
                            var prioMax: Int = i9.getProceso(0).prioridad
                            var auxPrio: Int = i9.getProceso(i).prioridad

                            if (auxPrio >= prioMax){
                                prioMax = auxPrio
                            }

                            if (i9.getProceso(i).prioridad >= prioMax && i9.getProceso(0) != i9.getProceso(i)){
                                i9.addFirst(pro)
                                i9.removeLast()
                                println("Procesando i ${i9.getProceso(i)}")
                            }else{
                                println("Procesando pro $pro")
                            }



                        }

                    }
                    i++
                } while (i <= procesosSimultanos)
            }
        }

//CADA SEGUNDO SE CREA UN PROCESO Y SE ALOJA EN LA MEMORIA RAM A LA ESPERA DE SER LLEVADO AL PROCESADOR
        if (tiempo % 1f < 0.0001f) {
            var pro = Proceso()
            ddr4.addLast(pro)
            println(ddr4)
        }

//  CADA 10 SEGUNDOS SE BORRA LA PAPELERA
        if (tiempo % 10f < 0.0001f) {
            println("La papelera contiene $papelera")
            papelera.vaciarPapelera()
            println("Papelera vaciada con éxito")
        }

        Thread.sleep(200)
        tiempo = tiempo + 0.20f
        tiempo = round(tiempo * 100) / 100
    }

}
