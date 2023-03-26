import kotlin.math.roundToInt

open class Procesador<TIPO>: Cola<TIPO> {
     constructor() : super()


     fun procesarProceso(proceso: Proceso){
        proceso.cuantum = proceso.cuantum - 0.2f
    }

     fun procesoTerminado(posicion:Int):Boolean{
         var estaTermindo:Boolean = false
         var aux  = this.cola.get(posicion) as Proceso
         if (aux.cuantum <= 0.001f){
             estaTermindo = true
         }
        return estaTermindo
     }

     fun totalProcesos():Int{
        var total = this.cola.size-1
        return total
     }

     fun getProceso(indice:Int):TIPO{
         var pro = this.cola.get(indice)
         return pro
     }

     fun eliminarProceso(indice:Int){
         this.cola.removeAt(indice)
     }

     override fun toString(): String {
         return "Procesador ${super.toString()} "
     }
 }